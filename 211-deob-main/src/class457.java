import java.util.Iterator;

class class457 implements Iterator {

	int field3972;
	// $FF: synthetic field

	final class458 this$0;

	class457(class458 var1) {
		this.this$0 = var1;
	}

	public boolean hasNext() {
		return this.field3972 < this.this$0.method2195();
	}

	public Object next() {
		int var1 = ++this.field3972 - 1;
		class423 var2 = (class423) this.this$0.field3975.get((long) var1);
		return var2 != null ? var2 : this.this$0.method2327(var1);
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	static int method2324(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
		if (var0 == 1800) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = MenuAction
					.Widget_unpackTargetMask(class173.getWidgetFlags(var3));
			return 1;
		} else if (var0 != 1801) {
			if (var0 == 1802) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}
}
