public class World {

	static int World_count = 0;

	static int World_listCount = 0;

	static int[] World_sortOption2 = new int[] { 1, 1, 1, 1 };

	static int[] World_sortOption1 = new int[] { 0, 1, 2, 3 };

	public static AbstractArchive Widget_spritesArchive;

	int id;

	int properties;

	int population;

	String host;

	String activity;

	int location;

	int index;

	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	boolean method384() {
		return (2 & this.properties) != 0;
	}

	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	boolean method381() {
		return (8 & this.properties) != 0;
	}

	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	boolean method375() {
		return (1073741824 & this.properties) != 0;
	}

	boolean method379() {
		return (256 & this.properties) != 0;
	}

	boolean method380() {
		return (134217728 & this.properties) != 0;
	}

	static void requestNetFile(Archive var0, int var1, int var2, int var3, byte var4, boolean var5) {
		long var6 = (long) ((var1 << 16) + var2);
		NetFileRequest var8 = (NetFileRequest) NetCache.NetCache_pendingPriorityWrites.get(var6);
		if (var8 == null) {
			var8 = (NetFileRequest) NetCache.NetCache_pendingPriorityResponses.get(var6);
			if (var8 == null) {
				var8 = (NetFileRequest) NetCache.NetCache_pendingWrites.get(var6);
				if (var8 != null) {
					if (var5) {
						var8.removeDual();
						NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
						--NetCache.NetCache_pendingWritesCount;
						++NetCache.NetCache_pendingPriorityWritesCount;
					}

				} else {
					if (!var5) {
						var8 = (NetFileRequest) NetCache.NetCache_pendingResponses.get(var6);
						if (var8 != null) {
							return;
						}
					}

					var8 = new NetFileRequest();
					var8.archive = var0;
					var8.crc = var3;
					var8.padding = var4;
					if (var5) {
						NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
						++NetCache.NetCache_pendingPriorityWritesCount;
					} else {
						NetCache.NetCache_pendingWritesQueue.addFirst(var8);
						NetCache.NetCache_pendingWrites.put(var8, var6);
						++NetCache.NetCache_pendingWritesCount;
					}

				}
			}
		}
	}

	public static void method386() {
		WorldMapRegion.WorldMapRegion_cachedSprites.demote(5);
	}

	static int method385(int var0, Script var1, boolean var2) {
		if (var0 == 7108) {
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class287.method1549() ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}

	static final void method382(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field549) {
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0;
		}

		Client.field549 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1
				|| !ClanMate.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				LoginScreenAnimation.invalidateWidget(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				LoginScreenAnimation.invalidateWidget(var0);
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth
					&& var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16
					&& var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				LoginScreenAnimation.invalidateWidget(var0);
				Client.field549 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				LoginScreenAnimation.invalidateWidget(var0);
			}
		}

	}
}
