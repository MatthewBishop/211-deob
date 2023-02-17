import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

public class class387 {

	static Player localPlayer;

	final Map field3662 = new HashMap();

	final Map field3663 = new HashMap();

	final DecimalFormat field3665 = new DecimalFormat();

	public class387() {
		this.field3665.setMaximumFractionDigits(2);
	}

	public void method2032(HttpsURLConnection var1) {
		Iterator var2 = this.field3662.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			var1.setRequestProperty((String) var3.getKey(), (String) var3.getValue());
		}

	}

	public Map method2033() {
		return this.field3662;
	}

	public void method2044(String var1, String var2) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3662.put(var1, var2 != null ? var2 : "");
		}

	}

	public void method2034(String var1) {
		if (var1 != null && !var1.isEmpty()) {
			this.field3662.remove(var1);
		}

	}

	void method2043(class386 var1, String var2) {
		String var3 = String.format("%s %s", var1.method2031(), var2);
		this.method2044("Authorization", var3);
	}

	public void method2041(String var1) {
		this.method2043(class386.field3661, var1);
	}

	public void method2042(String var1) {
		this.method2043(class386.field3660, var1);
	}

	public void method2035(class427 var1) {
		this.field3662.put("Content-Type", var1.method2204());
	}

	public void method2036() {
		this.field3662.remove("Content-Type");
	}

	public void method2037(class427 var1) {
		this.method2038(var1, 1.0F);
	}

	void method2038(class427 var1, float var2) {
		this.field3663.put(var1, Math.max(0.0F, Math.min(1.0F, var2)));
		this.method2040();
	}

	void method2040() {
		this.field3662.remove("Accept");
		if (!this.field3663.isEmpty()) {
			this.field3662.put("Accept", this.method2039());
		}

	}

	String method2039() {
		ArrayList var1 = new ArrayList(this.field3663.entrySet());
		Collections.sort(var1, new class388(this));
		StringBuilder var2 = new StringBuilder();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Entry var4 = (Entry) var3.next();
			if (var2.length() > 0) {
				var2.append(",");
			}

			var2.append(((class427) var4.getKey()).method2204());
			float var5 = (Float) var4.getValue();
			if (var5 < 1.0F) {
				String var6 = this.field3665.format((double) var5);
				var2.append(";q=").append(var6);
			}
		}

		return var2.toString();
	}
}
