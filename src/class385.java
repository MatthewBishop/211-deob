public class class385 {

	static final void method2030(String var0, int var1) {
		PacketBufferNode var2 = Renderable.getPacketBufferNode(ClientPacket.field2482, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(class96.stringCp1252NullTerminatedByteSize(var0) + 1);
		var2.packetBuffer.writeByteA(var1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var2);
	}
}
