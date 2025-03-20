public class SoundSystem implements Runnable {

	static PcmPlayer pcmPlayer0;

	static SpritePixels compass;

	volatile PcmPlayer[] players = new PcmPlayer[2];

	public void run() {
		try {
			for (int var1 = 0; var1 < 2; ++var1) {
				PcmPlayer var2 = this.players[var1];
				if (var2 != null) {
					var2.run();
				}
			}
		} catch (Exception var4) {
			class121.RunException_sendStackTrace((String) null, var4);
		}

	}

	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = UrlRequester.getPreferencesFile("", class134.field1270.name, true);
			Buffer var1 = PacketWriter.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
			;
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
			;
		}

	}

	static void method221() {
		if (Client.oculusOrbState == 1) {
			Client.oculusOrbOnLocalPlayer = true;
		}

	}
}
