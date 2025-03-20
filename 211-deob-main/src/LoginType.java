public class LoginType {

	public static final LoginType oldscape = new LoginType(7, 0, "", "");

	static final LoginType field3948 = new LoginType(2, 1, "", "");

	static final LoginType field3947 = new LoginType(4, 2, "", "");

	static final LoginType field3952 = new LoginType(8, 3, "", "");

	static final LoginType field3949 = new LoginType(3, 4, "", "");

	static final LoginType field3950 = new LoginType(5, 5, "", "");

	static final LoginType field3955 = new LoginType(1, 6, "", "");

	static final LoginType field3951 = new LoginType(6, 7, "", "");

	public static final LoginType field3953;

	public final int field3954;

	final String field3945;

	static {
		field3953 = new LoginType(0, -1, "", "", true,
				new LoginType[] { oldscape, field3948, field3947, field3949, field3952 });
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field3954 = var1;
		this.field3945 = var4;
	}

	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field3954 = var1;
		this.field3945 = var4;
	}

	public String toString() {
		return this.field3945;
	}
}
