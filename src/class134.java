public enum class134 implements class349 {

	field1282(0, 0),

	field1271(1, 1),

	field1272(2, 2),

	field1273(3, 3),

	field1274(4, 4),

	field1281(5, 5),

	field1276(6, 6),

	field1275(7, 7),

	field1278(8, 8);

	static StudioGame field1270;

	static int field1277;

	final int field1279;

	final int field1280;

	class134(int var3, int var4) {
		this.field1279 = var3;
		this.field1280 = var4;
	}

	public int rsOrdinal() {
		return this.field1280;
	}

	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel) Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, (long) var5.count);
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	public static void method730() {
		KitDefinition.KitDefinition_cached.clear();
	}

	static int method732(int var0, Script var1, boolean var2) {
		if (var0 == 6754) {
			int var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
			NPCComposition var4 = class137.getNpcDefinition(var3);
			Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4 != null ? var4.name
					: "";
			return 1;
		} else {
			NPCComposition var5;
			if (var0 == 6764) {
				class302.Interpreter_intStackSize -= 2;
				var5 = class137.getNpcDefinition(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize]);
				int var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5.method969(var6);
				Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5.method966(var6);
				return 1;
			} else if (var0 == 6765) {
				var5 = class137.getNpcDefinition(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
				Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5 != null
						? var5.combatLevel * 1652634765 * 176795205
						: 0;
				return 1;
			} else {
				return 2;
			}
		}
	}
}
