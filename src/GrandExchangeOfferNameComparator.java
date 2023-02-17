import java.util.Comparator;

final class GrandExchangeOfferNameComparator implements Comparator {

	static WorldMapElement[] WorldMapElement_cached;

	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.getOfferName().compareTo(var2.getOfferName());
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
	}

	static void method1845(boolean var0) {
		byte var1 = 0;
		if (!ClanSettings.method809()) {
			var1 = 12;
		} else if (Decimator.client.method369() || Decimator.client.method344() || Decimator.client.method343()) {
			var1 = 10;
		}

		ReflectionCheck.method171(var1);
		if (var0) {
			Login.Login_username = "";
			Login.Login_password = "";
			UserComparator4.field1149 = 0;
			InvDefinition.otp = "";
		}

		FriendSystem.method405();
		class361.method1925();
	}

	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4]
					+ Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
			int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1]
					+ Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var9 * var7 + var8 * (128 - var7) >> 7;
		} else {
			return 0;
		}
	}
}
