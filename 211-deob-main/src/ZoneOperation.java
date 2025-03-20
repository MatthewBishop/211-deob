public class ZoneOperation {

	public static final ZoneOperation field2547 = new ZoneOperation(15);

	public static final ZoneOperation field2540 = new ZoneOperation(14);

	public static final ZoneOperation field2541 = new ZoneOperation(16);

	public static final ZoneOperation field2542 = new ZoneOperation(7);

	public static final ZoneOperation field2543 = new ZoneOperation(7);

	public static final ZoneOperation field2546 = new ZoneOperation(4);

	public static final ZoneOperation field2544 = new ZoneOperation(5);

	public static final ZoneOperation field2539 = new ZoneOperation(2);

	public static final ZoneOperation field2551 = new ZoneOperation(6);

	public static final ZoneOperation field2548 = new ZoneOperation(4);

	public static final ZoneOperation field2549 = new ZoneOperation(14);

	public static final ZoneOperation field2550 = new ZoneOperation(5);

	public static final ZoneOperation field2545 = new ZoneOperation(11);

	ZoneOperation(int var1) {
	}

	static void addGameMessage(int var0, String var1, String var2) {
		class134.addChatMessage(var0, var1, var2, (String) null);
	}

	static int method1535(int var0, int var1) {
		ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.get((long) var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}
}
