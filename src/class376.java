import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class class376 {

	class372 field3628;

	int field3627 = 0;

	int field3626 = 0;

	class376(class372 var1, int var2, int var3) {
		this.field3628 = var1;
		this.field3627 = var2;
		this.field3626 = var3;
	}

	public String method2013() {
		if (this.method2006()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method2008());

			for (int var2 = this.field3627; var2 < this.field3626; ++var2) {
				class374 var3 = this.field3628.method1937(var2);
				var1.append(var3.field3603);
			}

			return var1.toString();
		}
	}

	boolean method2012(int var1) {
		return this.field3628.method1945() == 2
				|| this.field3628.method1945() == 1 && (!this.field3628.field3591 || this.field3626 - 1 != var1);
	}

	public boolean method2006() {
		return this.field3626 == this.field3627;
	}

	public int method2008() {
		return this.field3626 - this.field3627;
	}

	boolean method2007(class374 var1) {
		if (this.field3628.field3597 == 2) {
			return true;
		} else if (this.field3628.field3597 == 0) {
			return false;
		} else {
			return this.field3628.method1954() != var1;
		}
	}

	int method2009() {
		if (this.method2006()) {
			return 0;
		} else {
			class374 var1 = this.field3628.method1937(this.field3626 - 1);
			if (var1.field3603 == '\n') {
				return 0;
			} else if (this.method2007(var1)) {
				return this.field3628.field3594.advances[42];
			} else {
				int var2 = this.field3628.field3594.advances[var1.field3603];
				if (var2 == 0) {
					return var1.field3603 == '\t' ? this.field3628.field3594.advances[32] * 3
							: this.field3628.field3594.advances[32];
				} else {
					return var2;
				}
			}
		}
	}

	public class447 method2010() {
		if (this.method2006()) {
			return new class447(0, 0);
		} else {
			class374 var1 = this.field3628.method1937(this.field3626 - 1);
			return new class447(var1.field3601 + this.method2009(), var1.field3602);
		}
	}

	public class374 method2011(int var1) {
		return var1 >= 0 && var1 < this.method2008() ? this.field3628.method1937(this.field3627 + var1) : null;
	}

	static Date method2014() throws ParseException {
		SimpleDateFormat var0 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
		var0.setLenient(false);
		StringBuilder var1 = new StringBuilder();
		String[] var2 = Login.field761;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			String var4 = var2[var3];
			if (var4 == null) {
				HealthBarUpdate.method507("Date not valid.", "Please ensure all characters are populated.", "");
				return null;
			}

			var1.append(var4);
		}

		var1.append("12");
		return var0.parse(var1.toString());
	}
}
