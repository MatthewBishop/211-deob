public class PacketBufferNode extends Node {

    static PacketBufferNode[] PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];

    static int PacketBufferNode_packetBufferNodeCount = 0;

    static SpritePixels redHintArrowSprite;

    ClientPacket clientPacket;

    int clientPacketLength;

    public PacketBuffer packetBuffer;

    public int index;

    public void release() {
        if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
            PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
        }
    }

    static class86[] method1537() {
        return new class86[] { class86.field886, class86.field882, class86.field884, class86.field888, class86.field885,
                class86.field883 };
    }

    static final void method1538() {
        for (int var0 = 0; var0 < Players.Players_count; ++var0) {
            Player var1 = Client.players[Players.Players_indices[var0]];
            var1.clearIsInFriendsChat();
        }

    }
}
