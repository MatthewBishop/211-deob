public class PlayerComposition {

	static final int[] equipmentIndices = new int[] { 8, 11, 4, 6, 9, 7, 10 };

	static EvictingDualNodeHashTable PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);

	int[] equipment;

	int[] bodyColors;

	public int field2812 = -1;

	public int field2817 = 0;

	public int npcTransformId;

	long hash;

	long field2816;

	ObjTypeCustomisation[] customisations;

	boolean isFemale = false;

	public void setAppearance(int[] var1, ObjTypeCustomisation[] var2, boolean var3, int[] var4, int var5, int var6,
			int var7) {
		this.customisations = var2;
		this.isFemale = var3;
		this.field2812 = var7;
		this.initiateAppearance(var1, var4, var5, var6);
	}

	public void initiateAppearance(int[] var1, int[] var2, int var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = UrlRequester.KitDefinition_get(var6);
					if (var7 != null && !var7.nonSelectable && var5 + (var3 == 1 ? 7 : 0) == var7.bodypartID) {
						var1[equipmentIndices[var5]] = var6 + 256;
						break;
					}
				}
			}
		}

		this.equipment = var1;
		this.bodyColors = var2;
		this.field2817 = var3;
		this.npcTransformId = var4;
		this.setHash();
	}

	public void changeAppearance(int var1, boolean var2) {
		if (var1 != 1 || this.field2817 != 1) {
			int var3 = this.equipment[equipmentIndices[var1]];
			if (var3 != 0) {
				var3 -= 256;

				KitDefinition var4;
				do {
					if (!var2) {
						--var3;
						if (var3 < 0) {
							var3 = KitDefinition.KitDefinition_fileCount - 1;
						}
					} else {
						++var3;
						if (var3 >= KitDefinition.KitDefinition_fileCount) {
							var3 = 0;
						}
					}

					var4 = UrlRequester.KitDefinition_get(var3);
				} while (var4 == null || var4.nonSelectable || var4.bodypartID != var1 + (this.field2817 == 1 ? 7 : 0));

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	public void method1632(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = UserComparator8.field1152[var1].length - 1;
				}
			} while (!FriendSystem.method400(var1, var3));
		} else {
			do {
				++var3;
				if (var3 >= UserComparator8.field1152[var1].length) {
					var3 = 0;
				}
			} while (!FriendSystem.method400(var1, var3));
		}

		this.bodyColors[var1] = var3;
		this.setHash();
	}

	public void method1637(int var1) {
		if (this.field2817 != var1) {
			this.initiateAppearance((int[]) null, this.bodyColors, var1, -1);
		}
	}

	public void write(Buffer var1) {
		var1.writeByte(this.field2817);

		int var2;
		for (var2 = 0; var2 < 7; ++var2) {
			int var3 = this.equipment[equipmentIndices[var2]];
			if (var3 == 0) {
				var1.writeByte(-1);
			} else {
				var1.writeByte(var3 - 256);
			}
		}

		for (var2 = 0; var2 < 5; ++var2) {
			var1.writeByte(this.bodyColors[var2]);
		}

	}

	void setHash() {
		long var1 = this.hash;
		int var3 = this.equipment[5];
		int var4 = this.equipment[9];
		this.equipment[5] = var4;
		this.equipment[9] = var3;
		this.hash = 0L;

		int var5;
		for (var5 = 0; var5 < 12; ++var5) {
			this.hash <<= 4;
			if (this.equipment[var5] >= 256) {
				this.hash += (long) (this.equipment[var5] - 256);
			}
		}

		if (this.equipment[0] >= 256) {
			this.hash += (long) (this.equipment[0] - 256 >> 4);
		}

		if (this.equipment[1] >= 256) {
			this.hash += (long) (this.equipment[1] - 256 >> 8);
		}

		for (var5 = 0; var5 < 5; ++var5) {
			this.hash <<= 3;
			this.hash += (long) this.bodyColors[var5];
		}

		this.hash <<= 1;
		this.hash += (long) this.field2817;
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (var1 != 0L && this.hash != var1 || this.isFemale) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return class137.getNpcDefinition(this.npcTransformId).method958(var1, var2, var3, var4, (NewShit) null);
		} else {
			long var5 = this.hash;
			int[] var7 = this.equipment;
			if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
				var7 = new int[12];

				for (int var8 = 0; var8 < 12; ++var8) {
					var7[var8] = this.equipment[var8];
				}

				if (var1.shield >= 0) {
					var5 += (long) (var1.shield - this.equipment[5] << 40);
					var7[5] = var1.shield;
				}

				if (var1.weapon >= 0) {
					var5 += (long) (var1.weapon - this.equipment[3] << 48);
					var7[3] = var1.weapon;
				}
			}

			Model var18 = (Model) PlayerAppearance_cachedModels.get(var5);
			if (var18 == null) {
				boolean var9 = false;

				int var11;
				for (int var10 = 0; var10 < 12; ++var10) {
					var11 = var7[var10];
					if (var11 >= 256 && var11 < 512 && !UrlRequester.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !TileItem.ItemDefinition_get(var11 - 512).method1039(this.field2817)) {
						var9 = true;
					}
				}

				if (var9) {
					if (-1L != this.field2816) {
						var18 = (Model) PlayerAppearance_cachedModels.get(this.field2816);
					}

					if (var18 == null) {
						return null;
					}
				}

				if (var18 == null) {
					ModelData[] var19 = new ModelData[12];
					var11 = 0;

					int var13;
					for (int var12 = 0; var12 < 12; ++var12) {
						var13 = var7[var12];
						if (var13 >= 256 && var13 < 512) {
							ModelData var14 = UrlRequester.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var19[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							ItemComposition var22 = TileItem.ItemDefinition_get(var13 - 512);
							ModelData var15 = var22.method1034(this.field2817);
							if (var15 != null) {
								if (this.customisations != null) {
									ObjTypeCustomisation var16 = this.customisations[var12];
									if (var16 != null) {
										int var17;
										if (var16.recol != null && var22.recolorFrom != null
												&& var22.recolorTo.length == var16.recol.length) {
											for (var17 = 0; var17 < var22.recolorFrom.length; ++var17) {
												var15.recolor(var22.recolorTo[var17], var16.recol[var17]);
											}
										}

										if (var16.retex != null && var22.retextureFrom != null
												&& var16.retex.length == var22.retextureTo.length) {
											for (var17 = 0; var17 < var22.retextureFrom.length; ++var17) {
												var15.retexture(var22.retextureTo[var17], var16.retex[var17]);
											}
										}
									}
								}

								var19[var11++] = var15;
							}
						}
					}

					ModelData var20 = new ModelData(var19, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < UserComparator8.field1152[var13].length) {
							var20.recolor(class384.field3658[var13],
									UserComparator8.field1152[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < Varcs.field1116[var13].length) {
							var20.recolor(ItemLayer.field1866[var13], Varcs.field1116[var13][this.bodyColors[var13]]);
						}
					}

					var18 = var20.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var18, var5);
					this.field2816 = var5;
				}
			}

			Model var21;
			if (var1 == null && var3 == null) {
				var21 = var18.toSharedSequenceModel(true);
			} else if (var1 != null && var3 != null) {
				var21 = var1.applyTransformations(var18, var2, var3, var4);
			} else if (var1 != null) {
				var21 = var1.transformActorModel(var18, var2);
			} else {
				var21 = var3.transformActorModel(var18, var4);
			}

			return var21;
		}
	}

	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return class137.getNpcDefinition(this.npcTransformId).method968((NewShit) null);
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !UrlRequester.KitDefinition_get(var3 - 256).method934()) {
					var1 = true;
				}

				if (var3 >= 512 && !TileItem.ItemDefinition_get(var3 - 512).method1035(this.field2817)) {
					var1 = true;
				}
			}

			if (var1) {
				return null;
			} else {
				ModelData[] var7 = new ModelData[12];
				var3 = 0;

				int var5;
				for (int var4 = 0; var4 < 12; ++var4) {
					var5 = this.equipment[var4];
					ModelData var6;
					if (var5 >= 256 && var5 < 512) {
						var6 = UrlRequester.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = TileItem.ItemDefinition_get(var5 - 512).method1036(this.field2817);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < UserComparator8.field1152[var5].length) {
						var8.recolor(class384.field3658[var5], UserComparator8.field1152[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < Varcs.field1116[var5].length) {
						var8.recolor(ItemLayer.field1866[var5], Varcs.field1116[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	public int getChatHeadId() {
		return this.npcTransformId == -1
				? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10)
						+ (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20)
				: 305419896 + class137.getNpcDefinition(this.npcTransformId).id;
	}
}
