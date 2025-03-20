public class class431 {

	static final int[] field3811 = new int[16384];

	static final int[] field3812 = new int[16384];

	public static boolean[] Widget_loadedInterfaces;

	static {
		double var0 = 3.834951969714103E-4D;

		for (int var2 = 0; var2 < 16384; ++var2) {
			field3811[var2] = (int) (16384.0D * Math.sin(var0 * (double) var2));
			field3812[var2] = (int) (16384.0D * Math.cos(var0 * (double) var2));
		}

	}

	static void method2216() {
		if (Client.renderSelf) {
			Decimator.addPlayerToScene(class387.localPlayer, false);
		}

	}
}
