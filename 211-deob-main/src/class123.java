public enum class123 implements class349 {

	field1193(0, 0),

	field1195(1, 1),

	field1194(2, 2),

	field1197(3, 3),

	field1196(4, 4);

	final int field1199;

	final int field1198;

	class123(int var3, int var4) {
		this.field1199 = var3;
		this.field1198 = var4;
	}

	public int rsOrdinal() {
		return this.field1198;
	}

	public static final void method690(int var0, int var1) {
		ViewportMouse.ViewportMouse_x = var0;
		ViewportMouse.ViewportMouse_y = var1;
		ViewportMouse.ViewportMouse_isInViewport = true;
		ViewportMouse.ViewportMouse_entityCount = 0;
		ViewportMouse.ViewportMouse_false0 = false;
	}

	static final int method693(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
	}

	static void process() {
		for (InterfaceParent var0 = (InterfaceParent) Client.interfaceParents
				.first(); var0 != null; var0 = (InterfaceParent) Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (class153.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = WorldMapLabel.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int) var0.key;
					Widget var5 = class133.getWidget(var4);
					if (var5 != null) {
						LoginScreenAnimation.invalidateWidget(var5);
					}
				}
			}
		}

	}
}
