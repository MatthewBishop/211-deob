public class class432 {

	static final int[] field3814 = new int[2048];

	static final int[] field3815 = new int[2048];

	static {
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field3814[var2] = (int) (65536.0D * Math.sin((double) var2 * var0));
			field3815[var2] = (int) (65536.0D * Math.cos(var0 * (double) var2));
		}

	}
}
