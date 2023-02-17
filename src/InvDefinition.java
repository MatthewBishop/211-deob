public class InvDefinition extends DualNode {

	public static AbstractArchive InvDefinition_archive;

	static EvictingDualNodeHashTable InvDefinition_cached = new EvictingDualNodeHashTable(64);

	static String otp;

	static IndexedSprite[] scrollBarSprites;

	public int size = 0;

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
		if (var2 == 2) {
			this.size = var1.readUnsignedShort();
		}

	}
}
