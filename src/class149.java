public class class149 extends class139 {

	static long field1336;

	static int selectedSpellFlags;

	int field1335;

	String field1337;
	// $FF: synthetic field

	final class142 this$0;

	class149(class142 var1) {
		this.this$0 = var1;
	}

	void vmethod3254(Buffer var1) {
		this.field1335 = var1.readInt();
		this.field1337 = var1.readStringCp1252NullTerminated();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method801(this.field1335, this.field1337);
	}

	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}
}
