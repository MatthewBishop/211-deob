public class class173 {

	public String field1442;

	public float[] field1446;

	public int field1443;

	public int field1444;

	public int field1445;
	// $FF: synthetic field

	final class166 this$0;

	class173(class166 var1) {
		this.this$0 = var1;
		this.field1446 = new float[4];
		this.field1443 = 1;
		this.field1444 = 1;
		this.field1445 = 0;
	}

	static int getWidgetFlags(Widget var0) {
		IntegerNode var1 = (IntegerNode) Client.widgetFlags.get((long) var0.childIndex + ((long) var0.id << 32));
		return var1 != null ? var1.integer : var0.flags;
	}
}
