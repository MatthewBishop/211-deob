public class UserComparator7 extends AbstractUserComparator {

	static int cameraMoveToAcceleration;

	final boolean reversed;

	public UserComparator7(boolean var1) {
		this.reversed = var1;
	}

	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy) var1, (Buddy) var2);
	}

	static final void method651() {
		Client.field577 = Client.cycleCntr;
	}

	static final void method652(int var0, int var1, boolean var2) {
		if (Client.currentClanChannels[var0] != null) {
			if (var1 >= 0 && var1 < Client.currentClanChannels[var0].method844()) {
				ClanChannelMember var3 = (ClanChannelMember) Client.currentClanChannels[var0].members.get(var1);
				PacketBufferNode var4 = Renderable.getPacketBufferNode(ClientPacket.field2453,
						Client.packetWriter.isaacCipher);
				var4.packetBuffer.writeByte(4 + class96.stringCp1252NullTerminatedByteSize(var3.username.getName()));
				var4.packetBuffer.writeByte(var0);
				var4.packetBuffer.writeShort(var1);
				var4.packetBuffer.writeBoolean(var2);
				var4.packetBuffer.writeStringCp1252NullTerminated(var3.username.getName());
				Client.packetWriter.addNode(var4);
			}
		}
	}
}
