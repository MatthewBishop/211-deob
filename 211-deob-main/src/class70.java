import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;

public class class70 {

	static final BigInteger field737 = new BigInteger("10001", 16);

	static final BigInteger field736 = new BigInteger(
			"9bd0220dd8ba90fb50d00115bf9616c936013e54d0271cb5109e1f39b9fc91483633e6bbe8aeb1bf4175520973b24adc60598eaa848bf28b0dba4ab5a2fc984c8c1a5e059e98170870ac78b6951bd5a090c503509d1f1d19e17a45edafbb632fe490cec99825a9093e2cdd6aa39fc6f095845ae722ff41e3ac1729f20cc9d92b491bf5d0da7ec3fe4ca12474a018696d4923fda322657209822b923f5698e209af0343a3e970360167365a0087260f9d9de24e62bf6a981fe4077cd03e44df7ff3b4b8afebb75c1ad139dca9771aba56b0a2a1c541772f5e692cf3d0b1be2f5855ddedb3c40b4daa89b2f137d1b262f1902dc497e72328683aaa626932efcff1",
			16);

	public static class3 method423(class6 var0) {
		switch (var0.field10) {
		case 0:
			return new class0();
		default:
			throw new IllegalArgumentException();
		}
	}

	static long method418() {
		try {
			URL var0 = new URL(class310.method1760("services", false) + "m=accountappeal/login.ws");
			URLConnection var1 = var0.openConnection();
			var1.setRequestProperty("connection", "close");
			var1.setDoInput(true);
			var1.setDoOutput(true);
			var1.setConnectTimeout(5000);
			OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
			var2.write("data1=req");
			var2.flush();
			InputStream var3 = var1.getInputStream();
			Buffer var4 = new Buffer(new byte[1000]);

			do {
				int var5 = var3.read(var4.array, var4.offset, 1000 - var4.offset);
				if (var5 == -1) {
					var4.offset = 0;
					long var7 = var4.readLong();
					return var7;
				}

				var4.offset += var5;
			} while (var4.offset < 1000);

			return 0L;
		} catch (Exception var9) {
			return 0L;
		}
	}

	static Script getScript(int var0) {
		Script var1 = (Script) Script.Script_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class12.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = WorldMapLabelSize.newScript(var2);
				Script.Script_cached.put(var1, (long) var0);
				return var1;
			}
		}
	}

	static SpritePixels method421(int var0, int var1, int var2) {
		return (SpritePixels) WorldMapRegion.WorldMapRegion_cachedSprites
				.get(ParamComposition.method993(var0, var1, var2));
	}

	public static int method420(int var0) {
		class133 var2 = (class133) SequenceDefinition.SequenceDefinition_cachedModel.get((long) var0);
		class133 var1;
		if (var2 != null) {
			var1 = var2;
		} else {
			var2 = Login.method425(SequenceDefinition.SequenceDefinition_animationsArchive,
					class16.SequenceDefinition_skeletonsArchive, var0, false);
			if (var2 != null) {
				SequenceDefinition.SequenceDefinition_cachedModel.put(var2, (long) var0);
			}

			var1 = var2;
		}

		if (var1 == null) {
			return 2;
		} else {
			return var1.method719() ? 0 : 1;
		}
	}

	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}
}
