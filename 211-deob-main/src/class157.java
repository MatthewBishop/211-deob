public class class157 extends class139 {

	public static class50 pcmPlayerProvider;

	static Widget hoveredItemContainer;

	int field1387;

	int field1385;
	// $FF: synthetic field

	final class142 this$0;

	class157(class142 var1) {
		this.this$0 = var1;
	}

	void vmethod3254(Buffer var1) {
		this.field1387 = var1.readInt();
		this.field1385 = var1.readInt();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method795(this.field1387, this.field1385);
	}
}
