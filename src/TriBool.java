public class TriBool {

	public static final TriBool TriBool_unknown = new TriBool();

	public static final TriBool TriBool_true = new TriBool();

	public static final TriBool TriBool_false = new TriBool();

	static int playerUUIDLength;

	static int method2127(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 3903) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3]
					.type();
			return 1;
		} else if (var0 == 3904) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].id;
			return 1;
		} else if (var0 == 3905) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].unitPrice;
			return 1;
		} else if (var0 == 3906) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].totalQuantity;
			return 1;
		} else if (var0 == 3907) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].currentQuantity;
			return 1;
		} else if (var0 == 3908) {
			var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
					- 1] = Client.grandExchangeOffers[var3].currentPrice;
			return 1;
		} else {
			int var12;
			if (var0 == 3910) {
				var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == 3911) {
				var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == 3912) {
				var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == 3913) {
				var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var13;
				if (var0 == 3914) {
					var13 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
					if (EnumComposition.grandExchangeEvents != null) {
						EnumComposition.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator,
								var13);
					}

					return 1;
				} else if (var0 == 3915) {
					var13 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
					if (EnumComposition.grandExchangeEvents != null) {
						EnumComposition.grandExchangeEvents
								.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
					}

					return 1;
				} else if (var0 == 3916) {
					class302.Interpreter_intStackSize -= 2;
					var13 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] == 1;
					boolean var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1] == 1;
					if (EnumComposition.grandExchangeEvents != null) {
						Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
						EnumComposition.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
					}

					return 1;
				} else if (var0 == 3917) {
					var13 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
					if (EnumComposition.grandExchangeEvents != null) {
						EnumComposition.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator,
								var13);
					}

					return 1;
				} else if (var0 == 3918) {
					var13 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
					if (EnumComposition.grandExchangeEvents != null) {
						EnumComposition.grandExchangeEvents
								.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
					}

					return 1;
				} else if (var0 == 3919) {
					Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
							- 1] = EnumComposition.grandExchangeEvents == null ? 0
									: EnumComposition.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent var11;
					if (var0 == 3920) {
						var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) EnumComposition.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var11.world;
						return 1;
					} else if (var0 == 3921) {
						var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) EnumComposition.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var11
								.getOfferName();
						return 1;
					} else if (var0 == 3922) {
						var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) EnumComposition.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var11
								.getPreviousOfferName();
						return 1;
					} else if (var0 == 3923) {
						var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) EnumComposition.grandExchangeEvents.events.get(var3);
						long var5 = class153.clockNow() - class361.field3568 - var11.age;
						int var7 = (int) (var5 / 3600000L);
						int var8 = (int) ((var5 - (long) (var7 * 3600000)) / 60000L);
						int var9 = (int) ((var5 - (long) (var7 * 3600000) - (long) (var8 * '\uea60')) / 1000L);
						String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
						Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var10;
						return 1;
					} else if (var0 == 3924) {
						var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) EnumComposition.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
								- 1] = var11.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (var0 == 3925) {
						var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) EnumComposition.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
								- 1] = var11.grandExchangeOffer.unitPrice;
						return 1;
					} else if (var0 == 3926) {
						var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent) EnumComposition.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
								- 1] = var11.grandExchangeOffer.id;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	static String method2128(int var0) {
		if (var0 < 0) {
			return "";
		} else {
			return Client.menuTargets[var0].length() > 0 ? Client.menuActions[var0] + " " + Client.menuTargets[var0]
					: Client.menuActions[var0];
		}
	}
}
