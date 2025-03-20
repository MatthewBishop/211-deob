public abstract class Clock {

	public abstract void mark();

	public abstract int wait(int var1, int var2);

	public static final void method911(long var0) {
		if (var0 > 0L) {
			if (var0 % 10L == 0L) {
				long var2 = var0 - 1L;

				try {
					Thread.sleep(var2);
				} catch (InterruptedException var8) {
					;
				}

				try {
					Thread.sleep(1L);
				} catch (InterruptedException var7) {
					;
				}
			} else {
				try {
					Thread.sleep(var0);
				} catch (InterruptedException var6) {
					;
				}
			}

		}
	}

	static class467 method910(int var0) {
		class467 var1 = (class467) Client.Widget_cachedFonts.get((long) var0);
		if (var1 == null) {
			var1 = new class467(Canvas.field75, var0);
		}

		return var1;
	}
}
