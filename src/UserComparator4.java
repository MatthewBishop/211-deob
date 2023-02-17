import java.util.Comparator;

public class UserComparator4 implements Comparator {

	public static String userHomeDirectory;

	static int field1149;

	final boolean reversed;

	public UserComparator4(boolean var1) {
		this.reversed = var1;
	}

	int compare_bridged(Buddy var1, Buddy var2) {
		return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((Buddy) var1, (Buddy) var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	static void method647() {
		for (ObjectSound var0 = (ObjectSound) ObjectSound.objectSounds
				.last(); var0 != null; var0 = (ObjectSound) ObjectSound.objectSounds.previous()) {
			if (var0.stream1 != null) {
				class209.pcmStreamMixer.removeSubStream(var0.stream1);
				var0.stream1 = null;
			}

			if (var0.stream2 != null) {
				class209.pcmStreamMixer.removeSubStream(var0.stream2);
				var0.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
	}

	static int method648(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 3500) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.keyHandlerInstance
					.getKeyPressed(var3) ? 1 : 0;
			return 1;
		} else if (var0 == 3501) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.keyHandlerInstance
					.method1086(var3) ? 1 : 0;
			return 1;
		} else if (var0 == 3502) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.keyHandlerInstance
					.method1089(var3) ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}
