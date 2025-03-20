public class ParamComposition extends DualNode {

    public static AbstractArchive ParamDefinition_archive;

    public static EvictingDualNodeHashTable ParamDefinition_cached = new EvictingDualNodeHashTable(64);

    static int baseX;

    char type;

    public int defaultInt;

    public String defaultStr;

    boolean autoDisable = true;

    void postDecode() {
    }

    void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decodeNext(var1, var2);
        }
    }

    void decodeNext(Buffer var1, int var2) {
        if (var2 == 1) {
            byte var4 = var1.readByte();
            int var5 = var4 & 255;
            if (var5 == 0) {
                throw new IllegalArgumentException("" + Integer.toString(var5, 16));
            }

            if (var5 >= 128 && var5 < 160) {
                char var6 = class362.cp1252AsciiExtension[var5 - 128];
                if (var6 == 0) {
                    var6 = '?';
                }

                var5 = var6;
            }

            char var3 = (char) var5;
            this.type = var3;
        } else if (var2 == 2) {
            this.defaultInt = var1.readInt();
        } else if (var2 == 4) {
            this.autoDisable = false;
        } else if (var2 == 5) {
            this.defaultStr = var1.readStringCp1252NullTerminated();
        }

    }

    public boolean isString() {
        return this.type == 's';
    }

    static long method993(int var0, int var1, int var2) {
        return (long) (var2 << 16 | var0 << 8 | var1);
    }

    public static String intToString(int var0, boolean var1) {
        return var1 && var0 >= 0 ? BuddyRankComparator.method665(var0, 10, var1) : Integer.toString(var0);
    }

    public static String method994(String var0) {
        int var1 = var0.length();
        char[] var2 = new char[var1];
        byte var3 = 2;

        for (int var4 = 0; var4 < var1; ++var4) {
            char var5 = var0.charAt(var4);
            if (var3 == 0) {
                var5 = Character.toLowerCase(var5);
            } else if (var3 == 2 || Character.isUpperCase(var5)) {
                var5 = class302.method1628(var5);
            }

            if (Character.isLetter(var5)) {
                var3 = 0;
            } else if (var5 != '.' && var5 != '?' && var5 != '!') {
                if (Character.isSpaceChar(var5)) {
                    if (var3 != 2) {
                        var3 = 1;
                    }
                } else {
                    var3 = 1;
                }
            } else {
                var3 = 2;
            }

            var2[var4] = var5;
        }

        return new String(var2);
    }

    static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
        InvDefinition.scrollBarSprites[0].drawAt(var0, var1);
        InvDefinition.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
        Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field443);
        int var5 = var3 * (var3 - 32) / var4;
        if (var5 < 8) {
            var5 = 8;
        }

        int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
        Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field444);
        Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field504);
        Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field504);
        Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field504);
        Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field504);
        Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field524);
        Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field524);
        Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field524);
        Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field524);
    }
}
