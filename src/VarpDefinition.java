public class VarpDefinition extends DualNode {

	static AbstractArchive VarpDefinition_archive;

	public static int field1471;

	static EvictingDualNodeHashTable VarpDefinition_cached = new EvictingDualNodeHashTable(64);

	static IndexedSprite[] mapSceneSprites;

	public int type = 0;

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	void decodeNext(Buffer var1, int var2) {
		if (var2 == 5) {
			this.type = var1.readUnsignedShort();
		}

	}

	public static VarbitComposition method919(int var0) {
		VarbitComposition var1 = (VarbitComposition) VarbitComposition.VarbitDefinition_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = DevicePcmPlayerProvider.VarbitDefinition_archive.takeFile(14, var0);
			var1 = new VarbitComposition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarbitComposition.VarbitDefinition_cached.put(var1, (long) var0);
			return var1;
		}
	}

	static void method918(int var0) {
		ItemContainer var1 = (ItemContainer) ItemContainer.itemContainers.get((long) var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		class204.method1077();
		class431.method2216();
		PcmPlayer.method210();
		class10.addNpcsToScene(true);
		int var4 = Players.Players_count;
		int[] var5 = Players.Players_indices;

		int var6;
		for (var6 = 0; var6 < var4; ++var6) {
			if (var5[var6] != Client.combatTargetPlayerIndex && var5[var6] != Client.localPlayerIndex) {
				Decimator.addPlayerToScene(Client.players[var5[var6]], true);
			}
		}

		class10.addNpcsToScene(false);
		class161.method856();
		TextureProvider.method1261();
		MusicPatchPcmStream.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		var4 = Client.camAngleX;
		if (Client.field466 / 256 > var4) {
			var4 = Client.field466 / 256;
		}

		if (Client.cameraShaking[4] && Client.cameraMoveIntensity[4] + 128 > var4) {
			var4 = Client.cameraMoveIntensity[4] + 128;
		}

		int var21 = Client.camAngleY & 2047;
		var6 = class245.oculusOrbFocalPointX;
		int var7 = Ignored.field3716;
		int var8 = UserComparator10.oculusOrbFocalPointY;
		int var9 = class17.method67(var4);
		int var11 = var3 - 334;
		if (var11 < 0) {
			var11 = 0;
		} else if (var11 > 100) {
			var11 = 100;
		}

		int var12 = (Client.zoomWidth - Client.zoomHeight) * var11 / 100 + Client.zoomHeight;
		int var10 = var12 * var9 / 256;
		var11 = 2048 - var4 & 2047;
		var12 = 2048 - var21 & 2047;
		int var13 = 0;
		int var14 = 0;
		int var15 = var10;
		int var16;
		int var17;
		int var18;
		if (var11 != 0) {
			var16 = Rasterizer3D.Rasterizer3D_sine[var11];
			var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
			var18 = var17 * var14 - var16 * var10 >> 16;
			var15 = var10 * var17 + var14 * var16 >> 16;
			var14 = var18;
		}

		if (var12 != 0) {
			var16 = Rasterizer3D.Rasterizer3D_sine[var12];
			var17 = Rasterizer3D.Rasterizer3D_cosine[var12];
			var18 = var16 * var15 + var13 * var17 >> 16;
			var15 = var17 * var15 - var13 * var16 >> 16;
			var13 = var18;
		}

		if (Client.isCameraLocked) {
			WorldMapRegion.field2281 = var6 - var13;
			PacketWriter.field1136 = var7 - var14;
			WorldMapDecoration.field2367 = var8 - var15;
			class135.field1289 = var4;
			class16.field56 = var21;
		} else {
			ClanSettings.cameraX = var6 - var13;
			UserComparator10.cameraY = var7 - var14;
			class366.cameraZ = var8 - var15;
			class103.cameraPitch = var4;
			class285.cameraYaw = var21;
		}

		if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0
				&& (class245.oculusOrbFocalPointX >> 7 != class387.localPlayer.x >> 7
						|| UserComparator10.oculusOrbFocalPointY >> 7 != class387.localPlayer.y >> 7)) {
			var16 = class387.localPlayer.plane;
			var17 = (class245.oculusOrbFocalPointX >> 7) + ParamComposition.baseX;
			var18 = (UserComparator10.oculusOrbFocalPointY >> 7) + Client.baseY;
			class168.method891(var17, var18, var16, true);
		}

		int var20;
		if (!Client.isCameraLocked) {
			if (PacketWriter.clientPreferences.getRoofsHidden()) {
				var11 = class103.Client_plane;
			} else {
				label299: {
					var12 = 3;
					if (class103.cameraPitch < 310) {
						if (Client.oculusOrbState == 1) {
							var13 = class245.oculusOrbFocalPointX >> 7;
							var14 = UserComparator10.oculusOrbFocalPointY >> 7;
						} else {
							var13 = class387.localPlayer.x >> 7;
							var14 = class387.localPlayer.y >> 7;
						}

						var15 = ClanSettings.cameraX >> 7;
						var16 = class366.cameraZ >> 7;
						if (var15 < 0 || var16 < 0 || var15 >= 104 || var16 >= 104) {
							var11 = class103.Client_plane;
							break label299;
						}

						if (var13 < 0 || var14 < 0 || var13 >= 104 || var14 >= 104) {
							var11 = class103.Client_plane;
							break label299;
						}

						if ((Tiles.Tiles_renderFlags[class103.Client_plane][var15][var16] & 4) != 0) {
							var12 = class103.Client_plane;
						}

						if (var13 > var15) {
							var17 = var13 - var15;
						} else {
							var17 = var15 - var13;
						}

						if (var14 > var16) {
							var18 = var14 - var16;
						} else {
							var18 = var16 - var14;
						}

						int var19;
						if (var17 > var18) {
							var19 = var18 * 65536 / var17;
							var20 = 32768;

							while (var13 != var15) {
								if (var15 < var13) {
									++var15;
								} else if (var15 > var13) {
									--var15;
								}

								if ((Tiles.Tiles_renderFlags[class103.Client_plane][var15][var16] & 4) != 0) {
									var12 = class103.Client_plane;
								}

								var20 += var19;
								if (var20 >= 65536) {
									var20 -= 65536;
									if (var16 < var14) {
										++var16;
									} else if (var16 > var14) {
										--var16;
									}

									if ((Tiles.Tiles_renderFlags[class103.Client_plane][var15][var16] & 4) != 0) {
										var12 = class103.Client_plane;
									}
								}
							}
						} else if (var18 > 0) {
							var19 = var17 * 65536 / var18;
							var20 = 32768;

							while (var16 != var14) {
								if (var16 < var14) {
									++var16;
								} else if (var16 > var14) {
									--var16;
								}

								if ((Tiles.Tiles_renderFlags[class103.Client_plane][var15][var16] & 4) != 0) {
									var12 = class103.Client_plane;
								}

								var20 += var19;
								if (var20 >= 65536) {
									var20 -= 65536;
									if (var15 < var13) {
										++var15;
									} else if (var15 > var13) {
										--var15;
									}

									if ((Tiles.Tiles_renderFlags[class103.Client_plane][var15][var16] & 4) != 0) {
										var12 = class103.Client_plane;
									}
								}
							}
						}
					}

					if (class387.localPlayer.x >= 0 && class387.localPlayer.y >= 0 && class387.localPlayer.x < 13312
							&& class387.localPlayer.y < 13312) {
						if ((Tiles.Tiles_renderFlags[class103.Client_plane][class387.localPlayer.x >> 7][class387.localPlayer.y >> 7]
								& 4) != 0) {
							var12 = class103.Client_plane;
						}

						var11 = var12;
					} else {
						var11 = class103.Client_plane;
					}
				}
			}

			var10 = var11;
		} else {
			var10 = class28.method112();
		}

		var11 = ClanSettings.cameraX;
		var12 = UserComparator10.cameraY;
		var13 = class366.cameraZ;
		var14 = class103.cameraPitch;
		var15 = class285.cameraYaw;

		for (var16 = 0; var16 < 5; ++var16) {
			if (Client.cameraShaking[var16]) {
				var17 = (int) (Math.random() * (double) (Client.cameraShakeIntensity[var16] * 2 + 1)
						- (double) Client.cameraShakeIntensity[var16]
						+ Math.sin((double) Client.cameraShakeSpeed[var16] / 100.0D
								* (double) Client.cameraShakeCycle[var16])
								* (double) Client.cameraMoveIntensity[var16]);
				if (var16 == 0) {
					ClanSettings.cameraX += var17;
				}

				if (var16 == 1) {
					UserComparator10.cameraY += var17;
				}

				if (var16 == 2) {
					class366.cameraZ += var17;
				}

				if (var16 == 3) {
					class285.cameraYaw = var17 + class285.cameraYaw & 2047;
				}

				if (var16 == 4) {
					class103.cameraPitch += var17;
					if (class103.cameraPitch < 128) {
						class103.cameraPitch = 128;
					}

					if (class103.cameraPitch > 383) {
						class103.cameraPitch = 383;
					}
				}
			}
		}

		var16 = MouseHandler.MouseHandler_x;
		var17 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var16 = MouseHandler.MouseHandler_lastPressedX;
			var17 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var16 >= var0 && var16 < var0 + var2 && var17 >= var1 && var17 < var3 + var1) {
			class123.method690(var16 - var0, var17 - var1);
		} else {
			class142.method757();
		}

		HorizontalAlignment.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		HorizontalAlignment.playPcmPlayers();
		var18 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		WorldMapAreaData.scene.draw(ClanSettings.cameraX, UserComparator10.cameraY, class366.cameraZ,
				class103.cameraPitch, class285.cameraYaw, var10);
		Rasterizer3D.Rasterizer3D_zoom = var18;
		HorizontalAlignment.playPcmPlayers();
		WorldMapAreaData.scene.clearTempGameObjects();
		FloorDecoration.method1143(var0, var1, var2, var3);
		if (Client.hintArrowType == 2) {
			class467.worldToScreen((Client.hintArrowX - ParamComposition.baseX << 7) + Client.hintArrowSubX,
					(Client.hintArrowY - Client.baseY << 7) + Client.hintArrowSubY, Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				WorldMapSectionType.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12,
						Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field442);
		AABB.method1239(var0, var1, var2, var3);
		ClanSettings.cameraX = var11;
		UserComparator10.cameraY = var12;
		class366.cameraZ = var13;
		class103.cameraPitch = var14;
		class285.cameraYaw = var15;
		if (Client.isLoading) {
			byte var22 = 0;
			var20 = var22 + NetCache.NetCache_pendingPriorityResponsesCount
					+ NetCache.NetCache_pendingPriorityWritesCount;
			if (var20 == 0) {
				Client.isLoading = false;
			}
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			class165.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
