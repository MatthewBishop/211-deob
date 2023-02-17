import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ClientPreferences {

	boolean roofsHidden;

	boolean hideUsername = false;

	boolean titleMusicDisabled;

	boolean displayFps = false;

	int field1037;

	double brightness = 0.8D;

	int musicVolume = 127;

	int soundEffectsVolume = 127;

	int areaSoundEffectsVolume = 127;

	int field1042 = -1;

	String rememberedUsername = null;

	int windowMode = 1;

	final Map parameters = new LinkedHashMap();

	ClientPreferences() {
		this.method520(true);
	}

	ClientPreferences(Buffer var1) {
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= 10) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}

				if (var2 > 6) {
					this.brightness = (double) var1.readUnsignedByte() / 100.0D;
					this.musicVolume = var1.readUnsignedByte();
					this.soundEffectsVolume = var1.readUnsignedByte();
					this.areaSoundEffectsVolume = var1.readUnsignedByte();
				}

				if (var2 > 7) {
					this.field1042 = var1.readUnsignedByte();
				}

				if (var2 > 8) {
					this.displayFps = var1.readUnsignedByte() == 1;
				}

				if (var2 > 9) {
					this.field1037 = var1.readInt();
				}
			} else {
				this.method520(true);
			}
		} else {
			this.method520(true);
		}

	}

	void method520(boolean var1) {
	}

	Buffer toBuffer() {
		Buffer var1 = new Buffer(417, true);
		var1.writeByte(10);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			var1.writeInt((Integer) var3.getKey());
			var1.writeInt((Integer) var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		var1.writeByte((int) (this.brightness * 100.0D));
		var1.writeByte(this.musicVolume);
		var1.writeByte(this.soundEffectsVolume);
		var1.writeByte(this.areaSoundEffectsVolume);
		var1.writeByte(this.field1042);
		var1.writeByte(this.displayFps ? 1 : 0);
		var1.writeInt(this.field1037);
		return var1;
	}

	void setRoofsHidden(boolean var1) {
		this.roofsHidden = var1;
		SoundSystem.savePreferences();
	}

	boolean getRoofsHidden() {
		return this.roofsHidden;
	}

	void setIsUsernameHidden(boolean var1) {
		this.hideUsername = var1;
		SoundSystem.savePreferences();
	}

	boolean getIsUsernameHidden() {
		return this.hideUsername;
	}

	void getTitleMusicDisabled(boolean var1) {
		this.titleMusicDisabled = var1;
		SoundSystem.savePreferences();
	}

	boolean getTitleMusicDisabled() {
		return this.titleMusicDisabled;
	}

	void method524(boolean var1) {
		this.displayFps = var1;
		SoundSystem.savePreferences();
	}

	void method525() {
		this.method524(!this.displayFps);
	}

	boolean method526() {
		return this.displayFps;
	}

	void method527(int var1) {
		this.field1037 = var1;
		SoundSystem.savePreferences();
	}

	int method528() {
		return this.field1037;
	}

	void setBrightness(double var1) {
		this.brightness = var1;
		SoundSystem.savePreferences();
	}

	double getBrightness() {
		return this.brightness;
	}

	void setCurrentMusicVolume(int var1) {
		this.musicVolume = var1;
		SoundSystem.savePreferences();
	}

	int getCurrentMusicVolume() {
		return this.musicVolume;
	}

	void setCurrentSoundEffectVolume(int var1) {
		this.soundEffectsVolume = var1;
		SoundSystem.savePreferences();
	}

	int getCurrentSoundEffectsVolume() {
		return this.soundEffectsVolume;
	}

	void setAreaSoundEffectsVolume(int var1) {
		this.areaSoundEffectsVolume = var1;
		SoundSystem.savePreferences();
	}

	int getAreaSoundEffectsVolume() {
		return this.areaSoundEffectsVolume;
	}

	void setUsernameToRemember(String var1) {
		this.rememberedUsername = var1;
		SoundSystem.savePreferences();
	}

	String getUsernameToRemember() {
		return this.rememberedUsername;
	}

	void method533(int var1) {
		this.field1042 = var1;
		SoundSystem.savePreferences();
	}

	int method534() {
		return this.field1042;
	}

	void method535(int var1) {
		this.windowMode = var1;
		SoundSystem.savePreferences();
	}

	int method536() {
		return this.windowMode;
	}

	void method550(String var1, int var2) {
		int var3 = this.method539(var1);
		if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
			Iterator var4 = this.parameters.entrySet().iterator();
			var4.next();
			var4.remove();
		}

		this.parameters.put(var3, var2);
		SoundSystem.savePreferences();
	}

	boolean method537(String var1) {
		int var2 = this.method539(var1);
		return this.parameters.containsKey(var2);
	}

	int method538(String var1) {
		int var2 = this.method539(var1);
		return !this.parameters.containsKey(var2) ? 0 : (Integer) this.parameters.get(var2);
	}

	int method539(String var1) {
		return GrandExchangeOfferAgeComparator.method1848(var1.toLowerCase());
	}
}
