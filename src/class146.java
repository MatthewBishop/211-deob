public class class146 extends class139 {

	boolean field1327;

	byte field1323;

	byte field1324;

	byte field1325;

	byte field1326;
	// $FF: synthetic field

	final class142 this$0;

	class146(class142 var1) {
		this.this$0 = var1;
	}

	void vmethod3254(Buffer var1) {
		this.field1327 = var1.readUnsignedByte() == 1;
		this.field1323 = var1.readByte();
		this.field1324 = var1.readByte();
		this.field1325 = var1.readByte();
		this.field1326 = var1.readByte();
	}

	void vmethod3248(ClanSettings var1) {
		var1.allowGuests = this.field1327;
		var1.field1347 = this.field1323;
		var1.field1363 = this.field1324;
		var1.field1359 = this.field1325;
		var1.field1349 = this.field1326;
	}

	static boolean method776(long var0) {
		return class121.method672(var0) == 2;
	}

	public static void method775() {
		ReflectionCheck.reflectionChecks = new IterableNodeDeque();
	}
}
