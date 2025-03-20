public class InterfaceParent extends Node {

    static int gameCyclesToDo;

    int group;

    int type;

    boolean field854 = false;

    static PacketBufferNode createPacketBufferNode() {
        return PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0 ? new PacketBufferNode()
                : PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
    }
}
