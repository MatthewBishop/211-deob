public abstract class class424 implements class265 {

	class463 field3804;

	class424(int var1) {
	}

	abstract void vmethod7769(Buffer var1, int var2);

	public void method2200(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			class420[] var3 = new class420[] { class420.field3796, class420.field3797, class420.field3798,
					class420.field3799 };
			class420 var4 = (class420) class4.findEnumerated(var3, var2);
			if (var4 != null) {
				switch (var4.field3800) {
				case 0:
					int var5 = var1.readUnsignedByte();
					this.field3804 = class370.method1933(var5);
					if (this.field3804 != null) {
						break;
					}

					throw new IllegalStateException("Unknown ScriptVarType ID in VarType.decode: " + var5);
				case 1:
				default:
					throw new IllegalStateException("Unrecognised VarTypeEncodingKey - " + var4);
				case 2:
					var1.readStringCp1252NullCircumfixed();
					break;
				case 3:
					class4.findEnumerated(class13.method51(), var1.readUnsignedByte());
				}
			} else {
				this.vmethod7769(var1, var2);
			}
		}
	}

	boolean method2202() {
		return this.field3804 != null;
	}

	Object method2201() {
		if (this.field3804 == class463.field3979) {
			return 0;
		} else if (this.field3804 == class463.field3980) {
			return -1L;
		} else {
			return this.field3804 == class463.field3985 ? "" : null;
		}
	}
}
