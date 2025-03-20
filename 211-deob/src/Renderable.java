public abstract class Renderable extends DualNode {

    static int[] regionMapArchiveIds;

    public int height = 1000;

    protected Model getModel() {
        return null;
    }

    void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
        Model var11 = this.getModel();
        if (var11 != null) {
            this.height = var11.height;
            var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
        }

    }

    public static int method1244(int var0, int var1) {
        return (int) Math.round(Math.atan2((double) var0, (double) var1) * 2607.5945876176133D) & 16383;
    }

    public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
        PacketBufferNode var2 = InterfaceParent.createPacketBufferNode();
        var2.clientPacket = var0;
        var2.clientPacketLength = var0.length;
        if (var2.clientPacketLength == -1) {
            var2.packetBuffer = new PacketBuffer(260);
        } else if (var2.clientPacketLength == -2) {
            var2.packetBuffer = new PacketBuffer(10000);
        } else if (var2.clientPacketLength <= 18) {
            var2.packetBuffer = new PacketBuffer(20);
        } else if (var2.clientPacketLength <= 98) {
            var2.packetBuffer = new PacketBuffer(100);
        } else {
            var2.packetBuffer = new PacketBuffer(260);
        }

        var2.packetBuffer.setIsaacCipher(var1);
        var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
        var2.index = 0;
        return var2;
    }
}
