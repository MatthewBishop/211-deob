import java.util.Comparator;
import java.util.Map.Entry;

class class388 implements Comparator {

	public static int field3666;

	static class421 field3667;
	// $FF: synthetic field

	final class387 this$0;

	class388(class387 var1) {
		this.this$0 = var1;
	}

	int method2045(Entry var1, Entry var2) {
		return ((Float) var2.getValue()).compareTo((Float) var1.getValue());
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.method2045((Entry) var1, (Entry) var2);
	}

	public static int method2046(int var0) {
		return class431.field3812[var0 & 16383];
	}
}
