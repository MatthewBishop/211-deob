public class class174 extends class177 {

	static Archive archive14;

	int field1448;
	// $FF: synthetic field

	final class166 this$0;

	class174(class166 var1, String var2, int var3) {
		super(var1, var2);
		this.this$0 = var1;
		this.field1448 = var3;
	}

	public int vmethod3379() {
		return 0;
	}

	public int vmethod3378() {
		return this.field1448;
	}

	static void method900(int var0, int var1) {
		int[] var2 = new int[9];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			int var4 = var3 * 32 + 15 + 128;
			int var5 = class17.method67(var4);
			int var6 = Rasterizer3D.Rasterizer3D_sine[var4];
			int var8 = var1 - 334;
			if (var8 < 0) {
				var8 = 0;
			} else if (var8 > 100) {
				var8 = 100;
			}

			int var9 = (Client.zoomWidth - Client.zoomHeight) * var8 / 100 + Client.zoomHeight;
			int var7 = var5 * var9 / 256;
			var2[var3] = var6 * var7 >> 16;
		}

		Scene.Scene_buildVisiblityMap(var2, 500, 800, var0 * 334 / var1, 334);
	}

	static void addCancelMenuEntry() {
		ScriptFrame.method322();
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
