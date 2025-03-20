public abstract class class422 extends class266 implements class481 {

	protected class422(StudioGame var1, Language var2, int var3) {
		super(var1, var2, var3);
	}

	protected abstract class424 vmethod8207(int var1);

	public int method2195() {
		return super.field2411;
	}

	public Object vmethod8697(int var1) {
		class424 var2 = this.vmethod8207(var1);
		return var2 != null && var2.method2202() ? var2.method2201() : null;
	}

	public class482 method2197(Buffer var1) {
		int var2 = var1.readUnsignedShort();
		class424 var3 = this.vmethod8207(var2);
		class482 var4 = new class482(var2);
		Class var5 = var3.field3804.field3983;
		if (var5 == Integer.class) {
			var4.field4060 = var1.readInt();
		} else if (var5 == Long.class) {
			var4.field4060 = var1.readLong();
		} else if (var5 == String.class) {
			var4.field4060 = var1.readStringCp1252NullCircumfixed();
		} else {
			if (!class477.class.isAssignableFrom(var5)) {
				throw new IllegalStateException();
			}

			try {
				class477 var6 = (class477) var5.newInstance();
				var6.method2458(var1);
				var4.field4060 = var6;
			} catch (InstantiationException var7) {
				;
			} catch (IllegalAccessException var8) {
				;
			}
		}

		return var4;
	}
}
