public class WorldMapIcon_0 extends AbstractWorldMapIcon {

    static int selectedItemSlot;

    final int element;

    final WorldMapLabel label;

    final int subWidth;

    final int subHeight;

    WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
        super(var1, var2);
        this.element = var3;
        this.label = var4;
        WorldMapElement var5 = class4.WorldMapElement_get(this.getElement());
        SpritePixels var6 = var5.getSpriteBool(false);
        if (var6 != null) {
            this.subWidth = var6.subWidth;
            this.subHeight = var6.subHeight;
        } else {
            this.subWidth = 0;
            this.subHeight = 0;
        }

    }

    public int getElement() {
        return this.element;
    }

    WorldMapLabel getLabel() {
        return this.label;
    }

    int getSubWidth() {
        return this.subWidth;
    }

    int getSubHeight() {
        return this.subHeight;
    }

    public static void method1427(AbstractArchive var0) {
        VarpDefinition.VarpDefinition_archive = var0;
        VarpDefinition.field1471 = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
    }

    public static void method1425() {
        while (true) {
            NodeDeque var1 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
            ArchiveDiskAction var0;
            synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
                var0 = (ArchiveDiskAction) ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
            }

            if (var0 == null) {
                return;
            }

            var0.archive.load(var0.archiveDisk, (int) var0.key, var0.data, false);
        }
    }

    public static int method1428(int var0) {
        return (var0 & class469.field3999) - 1;
    }

    static void method1426(int var0, String var1) {
        int var2 = Players.Players_count;
        int[] var3 = Players.Players_indices;
        boolean var4 = false;
        Username var5 = new Username(var1, WorldMapCacheName.loginType);

        for (int var6 = 0; var6 < var2; ++var6) {
            Player var7 = Client.players[var3[var6]];
            if (var7 != null && var7 != class387.localPlayer && var7.username != null && var7.username.equals(var5)) {
                PacketBufferNode var8;
                if (var0 == 1) {
                    var8 = Renderable.getPacketBufferNode(ClientPacket.field2450, Client.packetWriter.isaacCipher);
                    var8.packetBuffer.writeShortLEA(var3[var6]);
                    var8.packetBuffer.writeByteA(0);
                    Client.packetWriter.addNode(var8);
                } else if (var0 == 4) {
                    var8 = Renderable.getPacketBufferNode(ClientPacket.field2517, Client.packetWriter.isaacCipher);
                    var8.packetBuffer.writeShort(var3[var6]);
                    var8.packetBuffer.writeByteS(0);
                    Client.packetWriter.addNode(var8);
                } else if (var0 == 6) {
                    var8 = Renderable.getPacketBufferNode(ClientPacket.field2478, Client.packetWriter.isaacCipher);
                    var8.packetBuffer.writeByteS(0);
                    var8.packetBuffer.writeShort(var3[var6]);
                    Client.packetWriter.addNode(var8);
                } else if (var0 == 7) {
                    var8 = Renderable.getPacketBufferNode(ClientPacket.field2438, Client.packetWriter.isaacCipher);
                    var8.packetBuffer.writeShortLEA(var3[var6]);
                    var8.packetBuffer.method2399(0);
                    Client.packetWriter.addNode(var8);
                }

                var4 = true;
                break;
            }
        }

        if (!var4) {
            ZoneOperation.addGameMessage(4, "", "Unable to find " + var1);
        }

    }
}
