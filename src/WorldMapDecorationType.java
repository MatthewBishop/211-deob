public enum WorldMapDecorationType implements class349 {

	field3038(0, 0),

	field3035(1, 0),

	field3031(2, 0),

	field3032(3, 0),

	field3037(9, 2),

	field3034(4, 1),

	field3030(5, 1),

	field3036(6, 1),

	field3043(7, 1),

	field3033(8, 1),

	field3042(12, 2),

	field3040(13, 2),

	field3041(14, 2),

	field3039(15, 2),

	field3046(16, 2),

	field3044(17, 2),

	field3045(18, 2),

	field3029(19, 2),

	field3047(20, 2),

	field3048(21, 2),

	field3049(10, 2),

	field3050(11, 2),

	field3051(22, 3);

	public final int id;

	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	public int rsOrdinal() {
		return this.id;
	}

	public static void method1777() {
		VarbitComposition.VarbitDefinition_cached.clear();
	}

	static WorldMap getWorldMap() {
		return GrandExchangeOfferUnitPriceComparator.worldMap;
	}
}
