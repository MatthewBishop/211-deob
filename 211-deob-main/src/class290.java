import java.net.URL;

public class class290 {

	public static AbstractArchive musicPatchesArchive;

	public static AbstractArchive musicSamplesArchive;

	public static AbstractArchive soundEffectsArchive;

	public static MidiPcmStream midiPcmStream;

	public static int musicPlayerStatus = 0;

	public static int musicTrackVolume;

	static Bounds field2708;

	static boolean loadWorlds() {
		try {
			if (ClanChannel.World_request == null) {
				ClanChannel.World_request = class245.urlRequester.request(new URL(VerticalAlignment.field1594));
			} else if (ClanChannel.World_request.isDone()) {
				byte[] var0 = ClanChannel.World_request.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.World_count = var1.readUnsignedShort();
				class88.World_worlds = new World[World.World_count];

				World var3;
				for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
					var3 = class88.World_worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				class156.sortWorlds(class88.World_worlds, 0, class88.World_worlds.length - 1, World.World_sortOption1,
						World.World_sortOption2);
				ClanChannel.World_request = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			ClanChannel.World_request = null;
		}

		return false;
	}

	static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, int var6,
			boolean var7) {
		if (!Client.isMenuOpen) {
			if (Client.menuOptionsCount < 500) {
				Client.menuActions[Client.menuOptionsCount] = var0;
				Client.menuTargets[Client.menuOptionsCount] = var1;
				Client.menuOpcodes[Client.menuOptionsCount] = var2;
				Client.menuIdentifiers[Client.menuOptionsCount] = var3;
				Client.menuArguments1[Client.menuOptionsCount] = var4;
				Client.menuArguments2[Client.menuOptionsCount] = var5;
				Client.menuItemIds[Client.menuOptionsCount] = var6;
				Client.menuShiftClick[Client.menuOptionsCount] = var7;
				++Client.menuOptionsCount;
			}

		}
	}
}
