import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class class108 extends UrlRequester {

	static int cameraMoveToY;

	final boolean field1142;

	public class108(boolean var1, int var2) {
		super(var2);
		this.field1142 = var1;
	}

	void vmethod2700(UrlRequest var1) throws IOException {
		URLConnection var2 = null;

		try {
			try {
				String var3 = var1.url.getProtocol();
				if (var3.equals("http")) {
					var2 = this.method638(var1);
				} else {
					if (!var3.equals("https")) {
						var1.isDone0 = true;
						return;
					}

					var2 = this.method637(var1);
				}

				this.method632(var2, var1);
			} catch (IOException var7) {
				;
			}

		} finally {
			var1.isDone0 = true;
			if (var2 != null) {
				if (var2 instanceof HttpURLConnection) {
					((HttpURLConnection) var2).disconnect();
				} else if (var2 instanceof HttpsURLConnection) {
					((HttpsURLConnection) var2).disconnect();
				}
			}

		}
	}

	URLConnection method638(UrlRequest var1) throws IOException {
		URLConnection var2 = var1.url.openConnection();
		this.method630(var2);
		return var2;
	}

	URLConnection method637(UrlRequest var1) throws IOException {
		HttpsURLConnection var2 = (HttpsURLConnection) var1.url.openConnection();
		if (!this.field1142) {
			var2.setSSLSocketFactory(class15.method57());
		}

		this.method630(var2);
		return var2;
	}

	public static int method640(int var0, int var1) {
		int var2;
		for (var2 = 0; var1 > 0; --var1) {
			var2 = var2 << 1 | var0 & 1;
			var0 >>>= 1;
		}

		return var2;
	}

	static World worldListStart() {
		World.World_listCount = 0;
		return TileItem.getNextWorldListWorld();
	}
}
