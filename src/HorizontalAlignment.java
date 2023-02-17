public enum HorizontalAlignment implements class349 {

	field1542(0, 0),

	HorizontalAlignment_centered(2, 1),

	field1539(1, 2);

	static long field1543;

	public final int value;

	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	public int rsOrdinal() {
		return this.id;
	}

	static void method951() {
		Tiles.Tiles_minPlane = 99;
		Tiles.Tiles_underlays = new short[4][104][104];
		class172.Tiles_overlays = new short[4][104][104];
		Tiles.Tiles_shapes = new byte[4][104][104];
		Tiles.field835 = new byte[4][104][104];
		class312.field3014 = new int[4][105][105];
		Tiles.field836 = new byte[4][105][105];
		class323.field3055 = new int[105][105];
		class100.Tiles_hue = new int[104];
		class161.Tiles_saturation = new int[104];
		Tiles.Tiles_lightness = new int[104];
		class463.Tiles_hueMultiplier = new int[104];
		SceneTilePaint.field2195 = new int[104];
	}

	static final void playPcmPlayers() {
		if (WorldMapSectionType.pcmPlayer1 != null) {
			WorldMapSectionType.pcmPlayer1.run();
		}

		if (SoundSystem.pcmPlayer0 != null) {
			SoundSystem.pcmPlayer0.run();
		}

	}
}
