public abstract class AbstractByteArrayCopier {

	abstract byte[] get();

	public abstract void set(byte[] var1);

	static final void method1768(int var0, int var1) {
		ClanChannel var2 = var0 >= 0 ? Client.currentClanChannels[var0] : class482.guestClanChannel;
		if (var2 != null && var1 >= 0 && var1 < var2.method844()) {
			ClanChannelMember var3 = (ClanChannelMember) var2.members.get(var1);
			if (var3.rank == -1) {
				String var4 = var3.username.getName();
				PacketBufferNode var5 = Renderable.getPacketBufferNode(ClientPacket.field2463,
						Client.packetWriter.isaacCipher);
				var5.packetBuffer.writeByte(3 + class96.stringCp1252NullTerminatedByteSize(var4));
				var5.packetBuffer.writeByte(var0);
				var5.packetBuffer.writeShort(var1);
				var5.packetBuffer.writeStringCp1252NullTerminated(var4);
				Client.packetWriter.addNode(var5);
			}
		}
	}
}
