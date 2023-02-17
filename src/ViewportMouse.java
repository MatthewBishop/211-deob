public class ViewportMouse {

	static boolean ViewportMouse_isInViewport = false;

	static int ViewportMouse_x = 0;

	static int ViewportMouse_y = 0;

	static boolean ViewportMouse_false0 = false;

	static int field2177;

	public static int ViewportMouse_entityCount = 0;

	public static long[] ViewportMouse_entityTags = new long[1000];

	public static boolean method1295(int var0) {
		return (var0 >> 28 & 1) != 0;
	}

	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field2939 == null) {
			throw new RuntimeException();
		} else {
			var0.field2939[var1] = var2;
			var0.field2940[var1] = var3;
		}
	}
}
