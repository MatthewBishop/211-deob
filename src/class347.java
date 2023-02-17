import java.util.HashMap;

public class class347 {

	static int[] field3520;

	final HashMap spriteMap = new HashMap();

	Bounds bounds = new Bounds(0, 0);

	int[] field3516 = new int[2048];

	int[] field3518 = new int[2048];

	int field3515 = 0;

	public class347() {
		field3520 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = SecureRandomCallable.method451((double) ((float) var2 / 360.0F), 0.9998999834060669D,
					(double) (0.425F * (float) var1 / 16.0F + 0.075F));
			field3520[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < field3520.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = SecureRandomCallable.method451((double) ((float) var2 / 360.0F), 0.9998999834060669D,
					0.5D); var1 < var4 && var1 < field3520.length; ++var1) {
				field3520[var1] = var5;
			}
		}

	}

	void method1865(int var1) {
		int var2 = var1 * 2 + 1;
		double var4 = (double) ((float) var1 / 3.0F);
		int var6 = var1 * 2 + 1;
		double[] var7 = new double[var6];
		int var8 = -var1;

		for (int var9 = 0; var8 <= var1; ++var9) {
			double var12 = class6.method15((double) (var8 - 0) / var4) / var4;
			var7[var9] = var12;
			++var8;
		}

		double[] var14 = var7;
		double var15 = var7[var1] * var7[var1];
		int[] var17 = new int[var2 * var2];
		boolean var18 = false;

		for (int var11 = 0; var11 < var2; ++var11) {
			for (int var19 = 0; var19 < var2; ++var19) {
				int var13 = var17[var19 + var2 * var11] = (int) (256.0D * (var14[var11] * var14[var19] / var15));
				if (!var18 && var13 > 0) {
					var18 = true;
				}
			}
		}

		SpritePixels var20 = new SpritePixels(var17, var2, var2);
		this.spriteMap.put(var1, var20);
	}

	SpritePixels method1866(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method1865(var1);
		}

		return (SpritePixels) this.spriteMap.get(var1);
	}

	public final void method1867(int var1, int var2) {
		if (this.field3515 < this.field3516.length) {
			this.field3516[this.field3515] = var1;
			this.field3518[this.field3515] = var2;
			++this.field3515;
		}
	}

	public final void method1869() {
		this.field3515 = 0;
	}

	public final void method1870(int var1, int var2, SpritePixels var3, float var4) {
		int var5 = (int) (var4 * 18.0F);
		SpritePixels var6 = this.method1866(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3515; ++var10) {
			var11 = this.field3516[var10];
			var12 = this.field3518[var10];
			int var13 = (int) (var4 * (float) (var11 - var1)) - var5;
			int var14 = (int) ((float) var3.subHeight - (float) (var12 - var2) * var4) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method2161(var8, var9);
			this.method1868(var6, var3, var9);
		}

		System.nanoTime();
		System.nanoTime();

		for (var10 = 0; var10 < var3.pixels.length; ++var10) {
			if (var3.pixels[var10] == 0) {
				var3.pixels[var10] = -16777216;
			} else {
				var11 = (var3.pixels[var10] + 64 - 1) / 256;
				if (var11 <= 0) {
					var3.pixels[var10] = -16777216;
				} else {
					if (var11 > field3520.length) {
						var11 = field3520.length;
					}

					var12 = field3520[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	void method1868(SpritePixels var1, SpritePixels var2, Bounds var3) {
		if (var3.highX != 0 && var3.highY != 0) {
			int var4 = 0;
			int var5 = 0;
			if (var3.lowX == 0) {
				var4 = var1.subWidth - var3.highX;
			}

			if (var3.lowY == 0) {
				var5 = var1.subHeight - var3.highY;
			}

			int var6 = var4 + var5 * var1.subWidth;
			int var7 = var2.subWidth * var3.lowY + var3.lowX;

			for (int var8 = 0; var8 < var3.highY; ++var8) {
				for (int var9 = 0; var9 < var3.highX; ++var9) {
					int var10001 = var7++;
					var2.pixels[var10001] += var1.pixels[var6++];
				}

				var6 += var1.subWidth - var3.highX;
				var7 += var2.subWidth - var3.highX;
			}

		}
	}
}
