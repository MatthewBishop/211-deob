public class class125 {

	boolean field1226;

	boolean field1205;

	class123 field1206;

	class123 field1223;

	class120[] field1208;

	boolean field1209;

	float field1204;

	float field1211;

	float field1212;

	float field1213;

	float field1225;

	float field1215;

	float field1216;

	float field1219;

	float field1217;

	float field1218;

	boolean field1214 = true;

	int field1207 = 0;

	float[] field1220;

	int field1210;

	int field1222;

	float field1221;

	float field1224;

	int method704(Buffer var1, int var2) {
		int var3 = var1.readUnsignedShort();
		ReflectionCheck.method170(var1.readUnsignedByte());
		int var5 = var1.readUnsignedByte();
		class123 var6 = (class123) class4.findEnumerated(UrlRequester.method628(), var5);
		if (var6 == null) {
			var6 = class123.field1193;
		}

		this.field1206 = var6;
		this.field1223 = ItemContainer.method455(var1.readUnsignedByte());
		this.field1226 = var1.readUnsignedByte() != 0;
		this.field1208 = new class120[var3];
		class120 var9 = null;

		for (int var7 = 0; var7 < var3; ++var7) {
			class120 var8 = new class120();
			var8.method669(var1, var2);
			this.field1208[var7] = var8;
			if (var9 != null) {
				var9.field1168 = var8;
			}

			var9 = var8;
		}

		return var3;
	}

	void method703() {
		this.field1210 = this.field1208[0].field1173;
		this.field1222 = this.field1208[this.method701() - 1].field1173;
		this.field1220 = new float[this.method698() + 1];

		for (int var1 = this.method702(); var1 <= this.method697(); ++var1) {
			this.field1220[var1 - this.method702()] = UrlRequester.method635(this, (float) var1);
		}

		this.field1208 = null;
		this.field1221 = UrlRequester.method635(this, (float) (this.method702() - 1));
		this.field1224 = UrlRequester.method635(this, (float) (this.method697() + 1));
	}

	public float method696(int var1) {
		if (var1 < this.method702()) {
			return this.field1221;
		} else {
			return var1 > this.method697() ? this.field1224 : this.field1220[var1 - this.method702()];
		}
	}

	int method702() {
		return this.field1210;
	}

	int method697() {
		return this.field1222;
	}

	int method698() {
		return this.method697() - this.method702();
	}

	int method699(float var1) {
		if (this.field1207 < 0 || (float) this.field1208[this.field1207].field1173 > var1
				|| this.field1208[this.field1207].field1168 != null
						&& (float) this.field1208[this.field1207].field1168.field1173 <= var1) {
			if (var1 >= (float) this.method702() && var1 <= (float) this.method697()) {
				int var2 = this.method701();
				int var3 = this.field1207;
				if (var2 > 0) {
					int var4 = 0;
					int var5 = var2 - 1;

					do {
						int var6 = var5 + var4 >> 1;
						if (var1 < (float) this.field1208[var6].field1173) {
							if (var1 > (float) this.field1208[var6 - 1].field1173) {
								var3 = var6 - 1;
								break;
							}

							var5 = var6 - 1;
						} else {
							if (var1 <= (float) this.field1208[var6].field1173) {
								var3 = var6;
								break;
							}

							if (var1 < (float) this.field1208[var6 + 1].field1173) {
								var3 = var6;
								break;
							}

							var4 = var6 + 1;
						}
					} while (var4 <= var5);
				}

				if (var3 != this.field1207) {
					this.field1207 = var3;
					this.field1214 = true;
				}

				return this.field1207;
			} else {
				return -1;
			}
		} else {
			return this.field1207;
		}
	}

	class120 method700(float var1) {
		int var2 = this.method699(var1);
		return var2 >= 0 && var2 < this.field1208.length ? this.field1208[var2] : null;
	}

	int method701() {
		return this.field1208 == null ? 0 : this.field1208.length;
	}

	public static IndexedSprite[] method705(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		IndexedSprite[] var5;
		if (!Buffer.method2444(var0, var3, var4)) {
			var5 = null;
		} else {
			IndexedSprite[] var7 = new IndexedSprite[class488.SpriteBuffer_spriteCount];

			for (int var8 = 0; var8 < class488.SpriteBuffer_spriteCount; ++var8) {
				IndexedSprite var9 = var7[var8] = new IndexedSprite();
				var9.width = class488.SpriteBuffer_spriteWidth;
				var9.height = class488.SpriteBuffer_spriteHeight;
				var9.xOffset = class488.SpriteBuffer_xOffsets[var8];
				var9.yOffset = ApproximateRouteStrategy.SpriteBuffer_yOffsets[var8];
				var9.subWidth = FriendsList.SpriteBuffer_spriteWidths[var8];
				var9.subHeight = class132.SpriteBuffer_spriteHeights[var8];
				var9.palette = class100.SpriteBuffer_spritePalette;
				var9.pixels = class140.SpriteBuffer_pixels[var8];
			}

			class100.method595();
			var5 = var7;
		}

		return var5;
	}
}
