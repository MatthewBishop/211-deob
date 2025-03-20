import java.io.IOException;

public class class138 extends class139 {

	public static Font ItemDefinition_fontPlain11;

	int field1300;
	// $FF: synthetic field

	final class142 this$0;

	class138(class142 var1) {
		this.this$0 = var1;
		this.field1300 = -1;
	}

	void vmethod3254(Buffer var1) {
		this.field1300 = var1.readUnsignedShort();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method793(this.field1300);
	}

	static ClientPreferences method746() {
		AccessFile var0 = null;
		ClientPreferences var1 = new ClientPreferences();

		try {
			var0 = UrlRequester.getPreferencesFile("", class134.field1270.name, false);
			byte[] var2 = new byte[(int) var0.length()];

			int var4;
			for (int var3 = 0; var3 < var2.length; var3 += var4) {
				var4 = var0.read(var2, var3, var2.length - var3);
				if (var4 == -1) {
					throw new IOException();
				}
			}

			var1 = new ClientPreferences(new Buffer(var2));
		} catch (Exception var6) {
			;
		}

		try {
			if (var0 != null) {
				var0.close();
			}
		} catch (Exception var5) {
			;
		}

		return var1;
	}

	static final void method745() {
		Client.field505 = Client.cycleCntr;
		WorldMapSectionType.ClanChat_inClanChat = true;
	}
}
