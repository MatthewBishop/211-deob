import java.applet.Applet;
import java.net.URL;

public class class154 extends class139 {

	public static SoundCache soundCache;

	long field1378;

	String field1380;

	int field1379;
	// $FF: synthetic field

	final class142 this$0;

	class154(class142 var1) {
		this.this$0 = var1;
		this.field1378 = -1L;
		this.field1380 = null;
		this.field1379 = 0;
	}

	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1378 = var1.readLong();
		}

		this.field1380 = var1.readStringCp1252NullTerminatedOrNull();
		this.field1379 = var1.readUnsignedShort();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method792(this.field1378, this.field1380, this.field1379);
	}

	static boolean method823(String var0, int var1, String var2) {
		if (var1 == 0) {
			try {
				if (!class31.field99.startsWith("win")) {
					throw new Exception();
				} else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				} else {
					String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

					for (int var4 = 0; var4 < var0.length(); ++var4) {
						if (var14.indexOf(var0.charAt(var4)) == -1) {
							throw new Exception();
						}
					}

					Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
					return true;
				}
			} catch (Throwable var8) {
				return false;
			}
		} else if (var1 == 1) {
			try {
				Applet var7 = class31.field100;
				Object[] var5 = new Object[] { (new URL(class31.field100.getCodeBase(), var0)).toString() };
				Object var13 = null; // JSObject.getWindow(var7).call(var2, var5);
				return var13 != null;
			} catch (Throwable var9) {
				return false;
			}
		} else if (var1 == 2) {
			try {
				class31.field100.getAppletContext().showDocument(new URL(class31.field100.getCodeBase(), var0),
						"_blank");
				return true;
			} catch (Exception var10) {
				return false;
			}
		} else if (var1 == 3) {
			try {
				Applet var3 = class31.field100;
				// JSObject.getWindow(var3).call("loggedout", (Object[])null);
			} catch (Throwable var12) {
				;
			}

			try {
				class31.field100.getAppletContext().showDocument(new URL(class31.field100.getCodeBase(), var0), "_top");
				return true;
			} catch (Exception var11) {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
