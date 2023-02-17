public class class145 extends class155 {

	public static AbstractArchive field1322;

	int field1319;

	byte field1321;

	int field1318;

	String field1320;
	// $FF: synthetic field

	final class156 this$0;

	class145(class156 var1) {
		this.this$0 = var1;
		this.field1319 = -1;
	}

	void vmethod3238(Buffer var1) {
		this.field1319 = var1.readUnsignedShort();
		this.field1321 = var1.readByte();
		this.field1318 = var1.readUnsignedShort();
		var1.readLong();
		this.field1320 = var1.readStringCp1252NullTerminated();
	}

	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember) var1.members.get(this.field1319);
		var2.rank = this.field1321;
		var2.world = this.field1318;
		var2.username = new Username(this.field1320);
	}

	static String method771(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode) var0.get((long) var1);
			return var3 == null ? var2 : (String) var3.obj;
		}
	}

	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		Script var6 = (Script) Script.Script_cached.get((long) (var3 << 16));
		Script var5;
		if (var6 != null) {
			var5 = var6;
		} else {
			String var7 = String.valueOf(var3);
			int var8 = class12.archive12.getGroupId(var7);
			if (var8 == -1) {
				var5 = null;
			} else {
				label47: {
					byte[] var9 = class12.archive12.takeFileFlat(var8);
					if (var9 != null) {
						if (var9.length <= 1) {
							var5 = null;
							break label47;
						}

						var6 = WorldMapLabelSize.newScript(var9);
						if (var6 != null) {
							Script.Script_cached.put(var6, (long) (var3 << 16));
							var5 = var6;
							break label47;
						}
					}

					var5 = null;
				}
			}
		}

		if (var5 != null) {
			return var5;
		} else {
			int var4 = MoveSpeed.method1110(var2, var0);
			Script var12 = (Script) Script.Script_cached.get((long) (var4 << 16));
			Script var13;
			if (var12 != null) {
				var13 = var12;
			} else {
				String var14 = String.valueOf(var4);
				int var10 = class12.archive12.getGroupId(var14);
				if (var10 == -1) {
					var13 = null;
				} else {
					byte[] var11 = class12.archive12.takeFileFlat(var10);
					if (var11 != null) {
						if (var11.length <= 1) {
							var13 = null;
							return var13 != null ? var13 : null;
						}

						var12 = WorldMapLabelSize.newScript(var11);
						if (var12 != null) {
							Script.Script_cached.put(var12, (long) (var4 << 16));
							var13 = var12;
							return var13 != null ? var13 : null;
						}
					}

					var13 = null;
				}
			}

			return var13 != null ? var13 : null;
		}
	}

	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2937 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2900 == null) {
				var0.field2900 = new int[var0.field2937.length];
			}

			var0.field2900[var1] = Integer.MAX_VALUE;
		}
	}
}
