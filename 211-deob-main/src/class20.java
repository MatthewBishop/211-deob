import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Map;

public class class20 {

	public static int musicTrackGroupId;

	static int Interpreter_stringStackSize;

	static int field69;

	static WorldMapEvent worldMapEvent;

	final int field71;

	final Map field72;

	final String field68;

	class20(String var1) {
		this.field71 = 400;
		this.field72 = null;
		this.field68 = "";
	}

	class20(HttpURLConnection var1) throws IOException {
		this.field71 = var1.getResponseCode();
		var1.getResponseMessage();
		this.field72 = var1.getHeaderFields();
		StringBuilder var2 = new StringBuilder();
		InputStream var3 = this.field71 >= 300 ? var1.getErrorStream() : var1.getInputStream();
		if (var3 != null) {
			InputStreamReader var4 = new InputStreamReader(var3);
			BufferedReader var5 = new BufferedReader(var4);

			String var6;
			while ((var6 = var5.readLine()) != null) {
				var2.append(var6);
			}

			var3.close();
		}

		this.field68 = var2.toString();
	}

	public int method76() {
		return this.field71;
	}

	public Map method74() {
		return this.field72;
	}

	public String method75() {
		return this.field68;
	}
}
