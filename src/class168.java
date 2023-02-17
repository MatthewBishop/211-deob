public class class168 {

	public static String operatingSystemName;

	public static void method892() {
		NPCComposition.NpcDefinition_cached.clear();
		NPCComposition.NpcDefinition_cachedModels.clear();
	}

	public static void method891(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = Renderable.getPacketBufferNode(ClientPacket.field2458, Client.packetWriter.isaacCipher);
		var4.packetBuffer.writeByteS(var2);
		var4.packetBuffer.writeShortLEA(var1);
		var4.packetBuffer.writeShortLE(var0);
		var4.packetBuffer.method2414(var3 ? Client.field462 * 523373087 * -270601761 : 0);
		Client.packetWriter.addNode(var4);
	}
}
