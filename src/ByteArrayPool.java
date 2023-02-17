import java.util.ArrayList;
import java.util.HashMap;

public class ByteArrayPool {

	static int ByteArrayPool_smallCount = 0;

	static int ByteArrayPool_mediumCount = 0;

	static int ByteArrayPool_largeCount = 0;

	static int field3639 = 0;

	static int field3640 = 1000;

	static int field3644 = 250;

	static int field3645 = 100;

	static int field3641 = 50;

	static byte[][] ByteArrayPool_small = new byte[1000][];

	static byte[][] ByteArrayPool_medium = new byte[250][];

	static byte[][] ByteArrayPool_large = new byte[100][];

	static byte[][] field3642 = new byte[50][];

	public static ArrayList field3635 = new ArrayList();

	static {
		class36.method169();
		new HashMap();
	}

	public static synchronized byte[] ByteArrayPool_getArrayBool(int var0, boolean var1) {
		byte[] var2;
		if ((var0 == 100 || var0 < 100 && var1) && ByteArrayPool_smallCount > 0) {
			var2 = ByteArrayPool_small[--ByteArrayPool_smallCount];
			ByteArrayPool_small[ByteArrayPool_smallCount] = null;
			return var2;
		} else if ((var0 == 5000 || var0 < 5000 && var1) && ByteArrayPool_mediumCount > 0) {
			var2 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
			ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
			return var2;
		} else if ((var0 == 10000 || var0 < 10000 && var1) && ByteArrayPool_largeCount > 0) {
			var2 = ByteArrayPool_large[--ByteArrayPool_largeCount];
			ByteArrayPool_large[ByteArrayPool_largeCount] = null;
			return var2;
		} else if ((var0 == 30000 || var0 < 30000 && var1) && field3639 > 0) {
			var2 = field3642[--field3639];
			field3642[field3639] = null;
			return var2;
		} else {
			int var4;
			if (class9.ByteArrayPool_arrays != null) {
				for (var4 = 0; var4 < class172.ByteArrayPool_alternativeSizes.length; ++var4) {
					if ((class172.ByteArrayPool_alternativeSizes[var4] == var0
							|| var0 < class172.ByteArrayPool_alternativeSizes[var4] && var1)
							&& class132.ByteArrayPool_altSizeArrayCounts[var4] > 0) {
						byte[] var3 = class9.ByteArrayPool_arrays[var4][--class132.ByteArrayPool_altSizeArrayCounts[var4]];
						class9.ByteArrayPool_arrays[var4][class132.ByteArrayPool_altSizeArrayCounts[var4]] = null;
						return var3;
					}
				}
			}

			if (var1 && class172.ByteArrayPool_alternativeSizes != null) {
				for (var4 = 0; var4 < class172.ByteArrayPool_alternativeSizes.length; ++var4) {
					if (var0 <= class172.ByteArrayPool_alternativeSizes[var4]
							&& class132.ByteArrayPool_altSizeArrayCounts[var4] < class9.ByteArrayPool_arrays[var4].length) {
						return new byte[class172.ByteArrayPool_alternativeSizes[var4]];
					}
				}
			}

			return new byte[var0];
		}
	}
}
