public class class158 extends class139 {

	public static String[] cacheParentPaths;

	int field1389;
	// $FF: synthetic field

	final class142 this$0;

	class158(class142 var1) {
		this.this$0 = var1;
		this.field1389 = -1;
	}

	void vmethod3254(Buffer var1) {
		this.field1389 = var1.readUnsignedShort();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method805(this.field1389);
	}

	static boolean method839(String var0, int var1) {
		return class154.method823(var0, var1, "openjs");
	}
}
