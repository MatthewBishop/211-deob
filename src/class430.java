import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class class430 implements class428 {

	final Map field3810;

	public class430(Map var1) {
		this.field3810 = var1;
	}

	public class427 vmethod2213() {
		return null;
	}

	public byte[] vmethod7797() throws UnsupportedEncodingException {
		return this.method2214().getBytes("UTF-8");
	}

	public String method2214() throws UnsupportedEncodingException {
		StringBuilder var1 = new StringBuilder();
		Iterator var2 = this.field3810.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			String var4 = URLEncoder.encode((String) var3.getKey(), "UTF-8");
			String var5 = URLEncoder.encode((String) var3.getValue(), "UTF-8");
			var1.append(var4).append("=").append(var5).append("&");
		}

		if (var1.length() == 0) {
			return "";
		} else {
			var1.deleteCharAt(var1.length() - 1);
			var1.insert(0, "?");
			return var1.toString();
		}
	}
}
