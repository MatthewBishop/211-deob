final class class101 implements class301 {
	// $FF: synthetic field

	final Widget val$cc;

	class101(Widget var1) {
		this.val$cc = var1;
	}

	public void vmethod5708() {
		if (this.val$cc != null && this.val$cc.method1747().field2807 != null) {
			ScriptEvent var1 = new ScriptEvent();
			var1.method461(this.val$cc);
			var1.setArgs(this.val$cc.method1747().field2807);
			class12.getScriptEvents().addFirst(var1);
		}

	}

	public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class362.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char) var6;
			}
		}

		return new String(var3, 0, var4);
	}

	static int method599(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 5504) {
			class302.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
			int var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
			if (!Client.isCameraLocked) {
				Client.camAngleX = var3;
				Client.camAngleY = var4;
			}

			return 1;
		} else if (var0 == 5505) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.camAngleX;
			return 1;
		} else if (var0 == 5506) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.camAngleY;
			return 1;
		} else if (var0 == 5530) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			if (var3 < 0) {
				var3 = 0;
			}

			Client.camFollowHeight = var3;
			return 1;
		} else if (var0 == 5531) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.camFollowHeight;
			return 1;
		} else {
			return 2;
		}
	}
}
