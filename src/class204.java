public class class204 extends Node {

	public int field1816;

	public int field1817;

	public int field1815;

	public Widget field1818;

	public class204(int var1, int var2, int var3, Widget var4) {
		this.field1815 = var1;
		this.field1816 = var2;
		this.field1817 = var3;
		this.field1818 = var4;
	}

	protected static final void method1075() {
		class177.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.graphicsTickTimes[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.clientTickTimes[var0] = 0L;
		}

		InterfaceParent.gameCyclesToDo = 0;
	}

	static void method1077() {
		if (class387.localPlayer.x >> 7 == Client.destinationX && class387.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

	}

	static final void method1076(PendingSpawn var0) {
		long var1 = 0L;
		int var3 = -1;
		int var4 = 0;
		int var5 = 0;
		if (var0.type == 0) {
			var1 = WorldMapAreaData.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 1) {
			var1 = WorldMapAreaData.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 2) {
			var1 = WorldMapAreaData.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 3) {
			var1 = WorldMapAreaData.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (0L != var1) {
			int var6 = WorldMapAreaData.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
			var3 = class124.Entity_unpackID(var1);
			var4 = var6 & 31;
			var5 = var6 >> 6 & 3;
		}

		var0.objectId = var3;
		var0.field927 = var4;
		var0.field926 = var5;
	}

	static final void addNpcToMenu(NPC var0, int var1, int var2, int var3) {
		NPCComposition var4 = var0.definition;
		if (Client.menuOptionsCount < 400) {
			if (var4.transforms != null) {
				var4 = var4.transform();
			}

			if (var4 != null) {
				if (var4.isInteractable) {
					if (!var4.isFollower || Client.followerIndex == var1) {
						String var5 = var0.method561();
						int var6;
						int var9;
						if (var4.combatLevel != 0 && var0.combatLevelChange != 0) {
							var6 = var0.combatLevelChange != -1 ? var0.combatLevelChange * -1605021683 * 1962901189
									: var4.combatLevel * 1652634765 * 176795205;
							var9 = class387.localPlayer.combatLevel;
							int var10 = var9 - var6;
							String var8;
							if (var10 < -9) {
								var8 = class149.colorStartTag(16711680);
							} else if (var10 < -6) {
								var8 = class149.colorStartTag(16723968);
							} else if (var10 < -3) {
								var8 = class149.colorStartTag(16740352);
							} else if (var10 < 0) {
								var8 = class149.colorStartTag(16756736);
							} else if (var10 > 9) {
								var8 = class149.colorStartTag(65280);
							} else if (var10 > 6) {
								var8 = class149.colorStartTag(4259584);
							} else if (var10 > 3) {
								var8 = class149.colorStartTag(8453888);
							} else if (var10 > 0) {
								var8 = class149.colorStartTag(12648192);
							} else {
								var8 = class149.colorStartTag(16776960);
							}

							var5 = var5 + var8 + " " + " (" + "level-" + var6 + ")";
						}

						if (var4.isFollower && Client.followerOpsLowPriority) {
							WorldMapManager.insertMenuItemNoShift("Examine", class149.colorStartTag(16776960) + var5,
									1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							WorldMapManager.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " "
									+ class149.colorStartTag(16776960) + var5, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((class149.selectedSpellFlags & 2) == 2) {
								WorldMapManager
										.insertMenuItemNoShift(
												Client.selectedSpellActionName, Client.selectedSpellName + " " + "->"
														+ " " + class149.colorStartTag(16776960) + var5,
												8, var1, var2, var3);
							}
						} else {
							var6 = var4.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var7 = var4.actions;
							int var11;
							if (var7 != null) {
								for (var11 = 4; var11 >= 0; --var11) {
									if (var0.method560(var11) && var7[var11] != null
											&& !var7[var11].equalsIgnoreCase("Attack")) {
										var9 = 0;
										if (var11 == 0) {
											var9 = var6 + 9;
										}

										if (var11 == 1) {
											var9 = var6 + 10;
										}

										if (var11 == 2) {
											var9 = var6 + 11;
										}

										if (var11 == 3) {
											var9 = var6 + 12;
										}

										if (var11 == 4) {
											var9 = var6 + 13;
										}

										WorldMapManager.insertMenuItemNoShift(var7[var11],
												class149.colorStartTag(16776960) + var5, var9, var1, var2, var3);
									}
								}
							}

							if (var7 != null) {
								for (var11 = 4; var11 >= 0; --var11) {
									if (var0.method560(var11) && var7[var11] != null
											&& var7[var11].equalsIgnoreCase("Attack")) {
										short var12 = 0;
										if (AttackOption.AttackOption_hidden != Client.npcAttackOption) {
											if (AttackOption.AttackOption_alwaysRightClick == Client.npcAttackOption
													|| Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels
															&& var4.combatLevel > class387.localPlayer.combatLevel) {
												var12 = 2000;
											}

											var9 = 0;
											if (var11 == 0) {
												var9 = var12 + 9;
											}

											if (var11 == 1) {
												var9 = var12 + 10;
											}

											if (var11 == 2) {
												var9 = var12 + 11;
											}

											if (var11 == 3) {
												var9 = var12 + 12;
											}

											if (var11 == 4) {
												var9 = var12 + 13;
											}

											WorldMapManager.insertMenuItemNoShift(var7[var11],
													class149.colorStartTag(16776960) + var5, var9, var1, var2, var3);
										}
									}
								}
							}

							if (!var4.isFollower || !Client.followerOpsLowPriority) {
								WorldMapManager.insertMenuItemNoShift("Examine",
										class149.colorStartTag(16776960) + var5, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}
}
