public final class WorldMapSprite {

	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	final int getTileColor(int var1, int var2) {
		return this.tileColors[var2 * 64 + var1];
	}

	public static void method1456(AbstractArchive var0, AbstractArchive var1) {
		NPCComposition.NpcDefinition_archive = var0;
		NPCComposition.field1550 = var1;
	}

	static void method1455(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field664 += var2.groupCount;
	}
}
