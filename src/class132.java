import java.util.concurrent.Callable;

class class132 implements Callable {

	public static int[] SpriteBuffer_spriteHeights;

	public static int[] ByteArrayPool_altSizeArrayCounts;
	// $FF: synthetic field

	final class133 this$0;
	// $FF: synthetic field

	final Buffer val$p;
	// $FF: synthetic field
	final int val$version;

	class132(class133 var1, Buffer var2, int var3) {
		this.this$0 = var1;
		this.val$p = var2;
		this.val$version = var3;
	}

	public Object call() {
		this.this$0.method725(this.val$p, this.val$version);
		return null;
	}

	static int method717(int var0, Script var1, boolean var2) {
		Widget var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
		if (var0 == 2500) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == 2501) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == 2502) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == 2503) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == 2504) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == 2505) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}
}
