public class FaceNormal {

	int x;

	int y;

	int z;

	public static void method1245() {
		VarpDefinition.VarpDefinition_cached.clear();
	}

	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}

	static final void forceDisconnect(int var0) {
		HealthBarDefinition.logOut();
		switch (var0) {
		case 1:
			WorldMapArea.method1353();
			break;
		case 2:
			ReflectionCheck.method171(24);
			class70.setLoginResponseString("The game servers are currently being updated.",
					"Please wait a few minutes and try again.", "");
		}

	}
}
