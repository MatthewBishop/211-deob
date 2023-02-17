public class class9 implements class349 {

	public static final class9 field19 = new class9(0, "POST", true, true);

	public static final class9 field20 = new class9(1, "GET", true, false);

	static final class9 field21 = new class9(2, "PUT", false, true);

	static final class9 field29 = new class9(3, "PATCH", false, true);

	static final class9 field23 = new class9(4, "DELETE", false, true);

	public static byte[][][] ByteArrayPool_arrays;

	static int selectedSpellWidget;

	static Varcs varcs;

	int field24;

	String field25;

	boolean field26;

	boolean field27;

	class9(int var1, String var2, boolean var3, boolean var4) {
		this.field24 = var1;
		this.field25 = var2;
		this.field26 = var3;
		this.field27 = var4;
	}

	public int rsOrdinal() {
		return this.field24;
	}

	boolean method35() {
		return this.field26;
	}

	public String method31() {
		return this.field25;
	}

	boolean method34() {
		return this.field27;
	}

	public static void method32(AbstractArchive var0) {
		DevicePcmPlayerProvider.VarbitDefinition_archive = var0;
	}

	public static void method36() {
		MouseHandler var0 = MouseHandler.MouseHandler_instance;
		synchronized (MouseHandler.MouseHandler_instance) {
			MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButtonVolatile;
			MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_xVolatile;
			MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_yVolatile;
			MouseHandler.MouseHandler_millis = MouseHandler.MouseHandler_lastMovedVolatile;
			MouseHandler.MouseHandler_lastButton = MouseHandler.MouseHandler_lastButtonVolatile;
			MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedXVolatile;
			MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedYVolatile;
			MouseHandler.MouseHandler_lastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillisVolatile;
			MouseHandler.MouseHandler_lastButtonVolatile = 0;
		}
	}
}
