import java.util.Iterator;

public class FontName {

	public static final FontName FontName_plain11 = new FontName("p11_full");

	public static final FontName FontName_plain12 = new FontName("p12_full");

	public static final FontName FontName_bold12 = new FontName("b12_full");

	public static final FontName FontName_verdana11 = new FontName("verdana_11pt_regular");

	public static final FontName FontName_verdana13 = new FontName("verdana_13pt_regular");

	public static final FontName FontName_verdana15 = new FontName("verdana_15pt_regular");

	String name;

	FontName(String var1) {
		this.name = var1;
	}

	static class323[] method2295() {
		return new class323[] { class323.field3057, class323.field3056 };
	}

	public static FontName[] method2294() {
		return new FontName[] { FontName_plain12, FontName_verdana15, FontName_verdana11, FontName_bold12,
				FontName_verdana13, FontName_plain11 };
	}

	static final void method2292(Scene var0, CollisionMap[] var1) {
		int var2;
		int var3;
		int var4;
		int var5;
		for (var2 = 0; var2 < 4; ++var2) {
			for (var3 = 0; var3 < 104; ++var3) {
				for (var4 = 0; var4 < 104; ++var4) {
					if ((Tiles.Tiles_renderFlags[var2][var3][var4] & 1) == 1) {
						var5 = var2;
						if ((Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
							var5 = var2 - 1;
						}

						if (var5 >= 0) {
							var1[var5].setBlockedByFloor(var3, var4);
						}
					}
				}
			}
		}

		Tiles.rndHue += (int) (Math.random() * 5.0D) - 2;
		if (Tiles.rndHue < -8) {
			Tiles.rndHue = -8;
		}

		if (Tiles.rndHue > 8) {
			Tiles.rndHue = 8;
		}

		Tiles.rndLightness += (int) (Math.random() * 5.0D) - 2;
		if (Tiles.rndLightness < -16) {
			Tiles.rndLightness = -16;
		}

		if (Tiles.rndLightness > 16) {
			Tiles.rndLightness = 16;
		}

		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		int var15;
		int var16;
		int var17;
		int var18;
		for (var2 = 0; var2 < 4; ++var2) {
			byte[][] var45 = Tiles.field836[var2];
			boolean var52 = true;
			boolean var53 = true;
			boolean var6 = true;
			boolean var7 = true;
			boolean var8 = true;
			var9 = (int) Math.sqrt(5100.0D);
			var10 = var9 * 768 >> 8;

			int var19;
			int var20;
			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					var13 = Tiles.Tiles_heights[var2][var12 + 1][var11] - Tiles.Tiles_heights[var2][var12 - 1][var11];
					var14 = Tiles.Tiles_heights[var2][var12][var11 + 1] - Tiles.Tiles_heights[var2][var12][var11 - 1];
					var15 = (int) Math.sqrt((double) (var13 * var13 + var14 * var14 + 65536));
					var16 = (var13 << 8) / var15;
					var17 = 65536 / var15;
					var18 = (var14 << 8) / var15;
					var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
					var20 = (var45[var12 - 1][var11] >> 2) + (var45[var12][var11 - 1] >> 2)
							+ (var45[var12 + 1][var11] >> 3) + (var45[var12][var11 + 1] >> 3)
							+ (var45[var12][var11] >> 1);
					class323.field3055[var12][var11] = var19 - var20;
				}
			}

			for (var11 = 0; var11 < 104; ++var11) {
				class100.Tiles_hue[var11] = 0;
				class161.Tiles_saturation[var11] = 0;
				Tiles.Tiles_lightness[var11] = 0;
				class463.Tiles_hueMultiplier[var11] = 0;
				SceneTilePaint.field2195[var11] = 0;
			}

			for (var11 = -5; var11 < 109; ++var11) {
				for (var12 = 0; var12 < 104; ++var12) {
					var13 = var11 + 5;
					if (var13 >= 0 && var13 < 104) {
						var14 = Client.param25 < 209 ? (int) StructComposition.method1003(8)
								: (int) StructComposition.method1003(15);
						var15 = Tiles.Tiles_underlays[var2][var13][var12] & var14;
						if (var15 > 0) {
							FloorUnderlayDefinition var46 = DefaultsGroup.method2155(var15 - 1);
							class100.Tiles_hue[var12] += var46.hue;
							class161.Tiles_saturation[var12] += var46.saturation;
							Tiles.Tiles_lightness[var12] += var46.lightness;
							class463.Tiles_hueMultiplier[var12] += var46.hueMultiplier;
							++SceneTilePaint.field2195[var12];
						}
					}

					var14 = var11 - 5;
					if (var14 >= 0 && var14 < 104) {
						var15 = Client.param25 < 209 ? (int) StructComposition.method1003(8)
								: (int) StructComposition.method1003(15);
						var16 = Tiles.Tiles_underlays[var2][var14][var12] & var15;
						if (var16 > 0) {
							FloorUnderlayDefinition var47 = DefaultsGroup.method2155(var16 - 1);
							class100.Tiles_hue[var12] -= var47.hue;
							class161.Tiles_saturation[var12] -= var47.saturation;
							Tiles.Tiles_lightness[var12] -= var47.lightness;
							class463.Tiles_hueMultiplier[var12] -= var47.hueMultiplier;
							--SceneTilePaint.field2195[var12];
						}
					}
				}

				if (var11 >= 1 && var11 < 103) {
					var12 = 0;
					var13 = 0;
					var14 = 0;
					var15 = 0;
					var16 = 0;

					for (var17 = -5; var17 < 109; ++var17) {
						var18 = var17 + 5;
						if (var18 >= 0 && var18 < 104) {
							var12 += class100.Tiles_hue[var18];
							var13 += class161.Tiles_saturation[var18];
							var14 += Tiles.Tiles_lightness[var18];
							var15 += class463.Tiles_hueMultiplier[var18];
							var16 += SceneTilePaint.field2195[var18];
						}

						var19 = var17 - 5;
						if (var19 >= 0 && var19 < 104) {
							var12 -= class100.Tiles_hue[var19];
							var13 -= class161.Tiles_saturation[var19];
							var14 -= Tiles.Tiles_lightness[var19];
							var15 -= class463.Tiles_hueMultiplier[var19];
							var16 -= SceneTilePaint.field2195[var19];
						}

						if (var17 >= 1 && var17 < 103
								&& (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0
										|| (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
							if (var2 < Tiles.Tiles_minPlane) {
								Tiles.Tiles_minPlane = var2;
							}

							var20 = Client.param25 < 209 ? (int) StructComposition.method1003(8)
									: (int) StructComposition.method1003(15);
							int var21 = Tiles.Tiles_underlays[var2][var11][var17] & var20;
							int var22 = class172.Tiles_overlays[var2][var11][var17] & var20;
							if (var21 > 0 || var22 > 0) {
								int var23 = Tiles.Tiles_heights[var2][var11][var17];
								int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17];
								int var25 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
								int var26 = Tiles.Tiles_heights[var2][var11][var17 + 1];
								int var27 = class323.field3055[var11][var17];
								int var28 = class323.field3055[var11 + 1][var17];
								int var29 = class323.field3055[var11 + 1][var17 + 1];
								int var30 = class323.field3055[var11][var17 + 1];
								int var31 = -1;
								int var32 = -1;
								int var33;
								int var34;
								int var35;
								if (var21 > 0) {
									var33 = var12 * 256 / var15;
									var34 = var13 / var16;
									var35 = var14 / var16;
									var31 = class139.hslToRgb(var33, var34, var35);
									var33 = var33 + Tiles.rndHue & 255;
									var35 += Tiles.rndLightness;
									if (var35 < 0) {
										var35 = 0;
									} else if (var35 > 255) {
										var35 = 255;
									}

									var32 = class139.hslToRgb(var33, var34, var35);
								}

								FloorOverlayDefinition var36;
								if (var2 > 0) {
									boolean var58 = true;
									if (var21 == 0 && Tiles.Tiles_shapes[var2][var11][var17] != 0) {
										var58 = false;
									}

									if (var22 > 0) {
										var35 = var22 - 1;
										var36 = (FloorOverlayDefinition) FloorOverlayDefinition.FloorOverlayDefinition_cached
												.get((long) var35);
										FloorOverlayDefinition var48;
										if (var36 != null) {
											var48 = var36;
										} else {
											byte[] var37 = FloorOverlayDefinition.FloorOverlayDefinition_archive
													.takeFile(4, var35);
											var36 = new FloorOverlayDefinition();
											if (var37 != null) {
												var36.decode(new Buffer(var37), var35);
											}

											var36.postDecode();
											FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var36,
													(long) var35);
											var48 = var36;
										}

										if (!var48.hideUnderlay) {
											var58 = false;
										}
									}

									if (var58 && var23 == var24 && var25 == var23 && var23 == var26) {
										class312.field3014[var2][var11][var17] |= 2340;
									}
								}

								var33 = 0;
								if (var32 != -1) {
									var33 = Rasterizer3D.Rasterizer3D_colorPalette[Players.method601(var32, 96)];
								}

								if (var22 == 0) {
									var0.addTile(var2, var11, var17, 0, 0, -1, var23, var24, var25, var26,
											Players.method601(var31, var27), Players.method601(var31, var28),
											Players.method601(var31, var29), Players.method601(var31, var30), 0, 0, 0,
											0, var33, 0);
								} else {
									var34 = Tiles.Tiles_shapes[var2][var11][var17] + 1;
									byte var59 = Tiles.field835[var2][var11][var17];
									int var49 = var22 - 1;
									FloorOverlayDefinition var38 = (FloorOverlayDefinition) FloorOverlayDefinition.FloorOverlayDefinition_cached
											.get((long) var49);
									if (var38 != null) {
										var36 = var38;
									} else {
										byte[] var39 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4,
												var49);
										var38 = new FloorOverlayDefinition();
										if (var39 != null) {
											var38.decode(new Buffer(var39), var49);
										}

										var38.postDecode();
										FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var38, (long) var49);
										var36 = var38;
									}

									int var50 = var36.texture;
									int var40;
									int var41;
									int var42;
									int var43;
									if (var50 >= 0) {
										var41 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var50);
										var40 = -1;
									} else if (var36.primaryRgb == 16711935) {
										var40 = -2;
										var50 = -1;
										var41 = -2;
									} else {
										var40 = class139.hslToRgb(var36.hue, var36.saturation, var36.lightness);
										var42 = var36.hue + Tiles.rndHue & 255;
										var43 = var36.lightness + Tiles.rndLightness;
										if (var43 < 0) {
											var43 = 0;
										} else if (var43 > 255) {
											var43 = 255;
										}

										var41 = class139.hslToRgb(var42, var36.saturation, var43);
									}

									var42 = 0;
									if (var41 != -2) {
										var42 = Rasterizer3D.Rasterizer3D_colorPalette[FloorUnderlayDefinition
												.method979(var41, 96)];
									}

									if (var36.secondaryRgb != -1) {
										var43 = var36.secondaryHue + Tiles.rndHue & 255;
										int var44 = var36.secondaryLightness + Tiles.rndLightness;
										if (var44 < 0) {
											var44 = 0;
										} else if (var44 > 255) {
											var44 = 255;
										}

										var41 = class139.hslToRgb(var43, var36.secondarySaturation, var44);
										var42 = Rasterizer3D.Rasterizer3D_colorPalette[FloorUnderlayDefinition
												.method979(var41, 96)];
									}

									var0.addTile(var2, var11, var17, var34, var59, var50, var23, var24, var25, var26,
											Players.method601(var31, var27), Players.method601(var31, var28),
											Players.method601(var31, var29), Players.method601(var31, var30),
											FloorUnderlayDefinition.method979(var40, var27),
											FloorUnderlayDefinition.method979(var40, var28),
											FloorUnderlayDefinition.method979(var40, var29),
											FloorUnderlayDefinition.method979(var40, var30), var33, var42);
								}
							}
						}
					}
				}
			}

			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					if ((Tiles.Tiles_renderFlags[var2][var12][var11] & 8) != 0) {
						var17 = 0;
					} else if (var2 > 0 && (Tiles.Tiles_renderFlags[1][var12][var11] & 2) != 0) {
						var17 = var2 - 1;
					} else {
						var17 = var2;
					}

					var0.setTileMinPlane(var2, var12, var11, var17);
				}
			}

			Tiles.Tiles_underlays[var2] = null;
			class172.Tiles_overlays[var2] = null;
			Tiles.Tiles_shapes[var2] = null;
			Tiles.field835[var2] = null;
			Tiles.field836[var2] = null;
		}

		var0.method1208(-50, -10, -50);

		for (var2 = 0; var2 < 104; ++var2) {
			for (var3 = 0; var3 < 104; ++var3) {
				if ((Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var0.setLinkBelow(var2, var3);
				}
			}
		}

		var2 = 1;
		var3 = 2;
		var4 = 4;

		for (var5 = 0; var5 < 4; ++var5) {
			if (var5 > 0) {
				var2 <<= 3;
				var3 <<= 3;
				var4 <<= 3;
			}

			for (int var54 = 0; var54 <= var5; ++var54) {
				for (int var55 = 0; var55 <= 104; ++var55) {
					for (int var56 = 0; var56 <= 104; ++var56) {
						short var57;
						if ((class312.field3014[var54][var56][var55] & var2) != 0) {
							var9 = var55;
							var10 = var55;
							var11 = var54;

							for (var12 = var54; var9 > 0
									&& (class312.field3014[var54][var56][var9 - 1] & var2) != 0; --var9) {
								;
							}

							while (var10 < 104 && (class312.field3014[var54][var56][var10 + 1] & var2) != 0) {
								++var10;
							}

							label374: while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((class312.field3014[var11 - 1][var56][var13] & var2) == 0) {
										break label374;
									}
								}

								--var11;
							}

							label363: while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((class312.field3014[var12 + 1][var56][var13] & var2) == 0) {
										break label363;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var57 = 240;
								var15 = Tiles.Tiles_heights[var12][var56][var9] - var57;
								var16 = Tiles.Tiles_heights[var11][var56][var9];
								Scene.Scene_addOccluder(var5, 1, var56 * 128, var56 * 128, var9 * 128,
										var10 * 128 + 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										class312.field3014[var17][var56][var18] &= ~var2;
									}
								}
							}
						}

						if ((class312.field3014[var54][var56][var55] & var3) != 0) {
							var9 = var56;
							var10 = var56;
							var11 = var54;

							for (var12 = var54; var9 > 0
									&& (class312.field3014[var54][var9 - 1][var55] & var3) != 0; --var9) {
								;
							}

							while (var10 < 104 && (class312.field3014[var54][var10 + 1][var55] & var3) != 0) {
								++var10;
							}

							label427: while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((class312.field3014[var11 - 1][var13][var55] & var3) == 0) {
										break label427;
									}
								}

								--var11;
							}

							label416: while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((class312.field3014[var12 + 1][var13][var55] & var3) == 0) {
										break label416;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var57 = 240;
								var15 = Tiles.Tiles_heights[var12][var9][var55] - var57;
								var16 = Tiles.Tiles_heights[var11][var9][var55];
								Scene.Scene_addOccluder(var5, 2, var9 * 128, var10 * 128 + 128, var55 * 128,
										var55 * 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										class312.field3014[var17][var18][var55] &= ~var3;
									}
								}
							}
						}

						if ((class312.field3014[var54][var56][var55] & var4) != 0) {
							var9 = var56;
							var10 = var56;
							var11 = var55;

							for (var12 = var55; var11 > 0
									&& (class312.field3014[var54][var56][var11 - 1] & var4) != 0; --var11) {
								;
							}

							while (var12 < 104 && (class312.field3014[var54][var56][var12 + 1] & var4) != 0) {
								++var12;
							}

							label480: while (var9 > 0) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((class312.field3014[var54][var9 - 1][var13] & var4) == 0) {
										break label480;
									}
								}

								--var9;
							}

							label469: while (var10 < 104) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((class312.field3014[var54][var10 + 1][var13] & var4) == 0) {
										break label469;
									}
								}

								++var10;
							}

							if ((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
								var13 = Tiles.Tiles_heights[var54][var9][var11];
								Scene.Scene_addOccluder(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128,
										var12 * 128 + 128, var13, var13);

								for (var14 = var9; var14 <= var10; ++var14) {
									for (var15 = var11; var15 <= var12; ++var15) {
										class312.field3014[var54][var14][var15] &= ~var4;
									}
								}
							}
						}
					}
				}
			}
		}

	}

	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message) var0.next();
			var1.clearIsFromIgnored();
		}

		if (class463.friendsChat != null) {
			class463.friendsChat.invalidateIgnoreds();
		}

	}
}
