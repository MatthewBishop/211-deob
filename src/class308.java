public class class308 {

	public static final short[] field2844 = new short[] { 6798, 8741, 25238, 4626, 4550 };

	public static final short[][] field2845 = new short[][] {
			{ 6798, 107, 10283, 16, 4797, 7744, 5799, 4634, -31839, 22433, 2983, -11343, 8, 5281, 10438, 3650, -27322,
					-21845, 200, 571, 908, 21830, 28946, -15701, -14010 },
			{ 8741, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 25239,
					8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010 },
			{ 25238, 8742, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533,
					8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010 },
			{ 4626, 11146, 6439, 12, 4758, 10270 },
			{ 4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574, 17050, 0, 127, -31821, -17991 } };

	public static final short[] field2846 = new short[] { -10304, 9104, -1, -1, -1 };

	public static final short[][] field2847 = new short[][] {
			{ 6554, 115, 10304, 28, 5702, 7756, 5681, 4510, -31835, 22437, 2859, -11339, 16, 5157, 10446, 3658, -27314,
					-21965, 472, 580, 784, 21966, 28950, -15697, -14002 },
			{ 9104, 10275, 7595, 3610, 7975, 8526, 918, -26734, 24466, 10145, -6882, 5027, 1457, 16565, -30545, 25486,
					24, 5392, 10429, 3673, -27335, -21957, 192, 687, 412, 21821, 28835, -15460, -14019 },
			new short[0], new short[0], new short[0] };

	static int method1721(Widget var0) {
		if (var0.type != 11) {
			Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize - 1] = "";
			return 1;
		} else {
			String var1 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
			Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var0.method1753(var1);
			return 1;
		}
	}

	static void method1722() {
		for (class204 var0 = (class204) Client.field587.last(); var0 != null; var0 = (class204) Client.field587
				.previous()) {
			var0.remove();
		}

	}
}
