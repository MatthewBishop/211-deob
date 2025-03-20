public class class97 {

	int field1063;

	int field1066;

	int field1064;

	int field1065;

	class97(int var1, int var2, int var3, int var4) {
		this.field1063 = var1;
		this.field1066 = var2;
		this.field1064 = var3;
		this.field1065 = var4;
	}

	int method584() {
		return this.field1063;
	}

	int method581() {
		return this.field1066;
	}

	int method582() {
		return this.field1064;
	}

	int method583() {
		return this.field1065;
	}

	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (class153.loadInterface(var0)) {
			MouseHandler.field159 = null;
			class27.drawInterface(WorldMapLabel.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5,
					var6, var7);
			if (MouseHandler.field159 != null) {
				class27.drawInterface(MouseHandler.field159, -1412584499, var1, var2, var3, var4, class288.field2691,
						class366.field3575, var7);
				MouseHandler.field159 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field591[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field591[var8] = true;
				}
			}

		}
	}
}
