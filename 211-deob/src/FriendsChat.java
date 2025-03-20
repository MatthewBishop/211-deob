public class FriendsChat extends UserList {

    static Archive archive7;

    final LoginType loginType;

    final Usernamed localUser;

    public String name = null;

    public String owner = null;

    public byte minKick;

    public int rank;

    int memberCount = 1;

    public FriendsChat(LoginType var1, Usernamed var2) {
        super(500);
        this.loginType = var1;
        this.localUser = var2;
    }

    User newInstance() {
        return new ClanMate();
    }

    User[] newTypedArray(int var1) {
        return new ClanMate[var1];
    }

    final void method2069(String var1) {
        String var3 = WorldMapSection1.base37DecodeLong(Decimator.method308(var1));
        if (var3 == null) {
            var3 = "";
        }

        this.name = var3;
    }

    final void method2075(String var1) {
        String var3 = WorldMapSection1.base37DecodeLong(Decimator.method308(var1));
        if (var3 == null) {
            var3 = "";
        }

        this.owner = var3;
    }

    public final void method2072(Buffer var1, int var2) {
        this.method2075(var1.readStringCp1252NullTerminated());
        long var3 = var1.readLong();
        long var6 = var3;
        String var5;
        int var8;
        if (var3 > 0L && var3 < 6582952005840035281L) {
            if (0L == var3 % 37L) {
                var5 = null;
            } else {
                var8 = 0;

                for (long var9 = var3; 0L != var9; var9 /= 37L) {
                    ++var8;
                }

                StringBuilder var11 = new StringBuilder(var8);

                while (0L != var6) {
                    long var12 = var6;
                    var6 /= 37L;
                    var11.append(class366.base37Table[(int) (var12 - var6 * 37L)]);
                }

                var5 = var11.reverse().toString();
            }
        } else {
            var5 = null;
        }

        this.method2069(var5);
        this.minKick = var1.readByte();
        short var14;
        if (var2 == 1) {
            var8 = var1.readUnsignedByte();
            var14 = 255;
        } else {
            if (var2 != 2) {
                throw new IllegalArgumentException("Invalid friend chat full update version: " + var2);
            }

            var8 = var1.method2389();
            var14 = -1;
        }

        if (var14 != var8) {
            int var10 = var8;
            this.clear();

            for (int var15 = 0; var15 < var10; ++var15) {
                ClanMate var16 = (ClanMate) this
                        .addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
                int var13 = var1.readUnsignedShort();
                var16.set(var13, ++this.memberCount - 1);
                var16.rank = var1.readByte();
                var1.readStringCp1252NullTerminated();
                this.isLocalPlayer(var16);
            }

        }
    }

    public final void method2070(Buffer var1) {
        Username var2 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
        int var3 = var1.readUnsignedShort();
        byte var4 = var1.readByte();
        boolean var5 = false;
        if (var4 == -128) {
            var5 = true;
        }

        ClanMate var6;
        if (var5) {
            if (this.getSize() == 0) {
                return;
            }

            var6 = (ClanMate) this.getByCurrentUsername(var2);
            if (var6 != null && var6.getWorld() == var3) {
                this.remove(var6);
            }
        } else {
            var1.readStringCp1252NullTerminated();
            var6 = (ClanMate) this.getByCurrentUsername(var2);
            if (var6 == null) {
                if (this.getSize() > super.capacity) {
                    return;
                }

                var6 = (ClanMate) this.addLastNoPreviousUsername(var2);
            }

            var6.set(var3, ++this.memberCount - 1);
            var6.rank = var4;
            this.isLocalPlayer(var6);
        }

    }

    public final void clearFriends() {
        for (int var1 = 0; var1 < this.getSize(); ++var1) {
            ((ClanMate) this.get(var1)).clearIsFriend();
        }

    }

    public final void invalidateIgnoreds() {
        for (int var1 = 0; var1 < this.getSize(); ++var1) {
            ((ClanMate) this.get(var1)).clearIsIgnored();
        }

    }

    final void isLocalPlayer(ClanMate var1) {
        if (var1.getUsername().equals(this.localUser.username())) {
            this.rank = var1.rank;
        }

    }

    static final void method2077() {
        if (!ViewportMouse.ViewportMouse_false0) {
            int var0 = Scene.Scene_cameraPitchSine;
            int var1 = Scene.Scene_cameraPitchCosine;
            int var2 = Scene.Scene_cameraYawSine;
            int var3 = Scene.Scene_cameraYawCosine;
            byte var4 = 50;
            short var5 = 3500;
            int var6 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var4
                    / Rasterizer3D.Rasterizer3D_zoom;
            int var7 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var4
                    / Rasterizer3D.Rasterizer3D_zoom;
            int var8 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var5
                    / Rasterizer3D.Rasterizer3D_zoom;
            int var9 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var5
                    / Rasterizer3D.Rasterizer3D_zoom;
            int var10 = Rasterizer3D.method1168(var7, var4, var1, var0);
            int var11 = Rasterizer3D.method1167(var7, var4, var1, var0);
            var7 = var10;
            var10 = Rasterizer3D.method1168(var9, var5, var1, var0);
            int var12 = Rasterizer3D.method1167(var9, var5, var1, var0);
            var9 = var10;
            var10 = Rasterizer3D.method1165(var6, var11, var3, var2);
            var11 = Rasterizer3D.method1166(var6, var11, var3, var2);
            var6 = var10;
            var10 = Rasterizer3D.method1165(var8, var12, var3, var2);
            var12 = Rasterizer3D.method1166(var8, var12, var3, var2);
            class148.field1332 = (var6 + var10) / 2;
            GrandExchangeEvent.field3502 = (var7 + var9) / 2;
            ViewportMouse.field2177 = (var12 + var11) / 2;
            class419.field3793 = (var10 - var6) / 2;
            VerticalAlignment.field1595 = (var9 - var7) / 2;
            class14.field48 = (var12 - var11) / 2;
            class172.field1439 = Math.abs(class419.field3793);
            class137.field1297 = Math.abs(VerticalAlignment.field1595);
            class151.field1365 = Math.abs(class14.field48);
        }
    }

    static void method2076() {
        PacketWriter.clientPreferences.method533(Client.param21);
    }
}
