public class MenuAction {

	static Font fontPlain12;

	int param0;

	int param1;

	int opcode;

	int identifier;

	int itemId;

	String action;

	String target;

	public static final boolean method417(char var0) {
		return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
	}

	public static int Widget_unpackTargetMask(int var0) {
		return var0 >> 11 & 63;
	}

	static final void method415() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			Player var3 = Client.players[var1[var2]];
			if (var3 != null) {
				PcmPlayer.updateActorSequence(var3, 1);
			}
		}

	}
}
