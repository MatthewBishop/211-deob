import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public abstract class UserList {

	final int capacity;

	int size = 0;

	User[] array;

	HashMap usernamesMap;

	HashMap previousUsernamesMap;

	Comparator comparator = null;

	UserList(int var1) {
		this.capacity = var1;
		this.array = this.newTypedArray(var1);
		this.usernamesMap = new HashMap(var1 / 8);
		this.previousUsernamesMap = new HashMap(var1 / 8);
	}

	abstract User newInstance();

	abstract User[] newTypedArray(int var1);

	public void clear() {
		this.size = 0;
		Arrays.fill(this.array, (Object) null);
		this.usernamesMap.clear();
		this.previousUsernamesMap.clear();
	}

	public int getSize() {
		return this.size;
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}

	public boolean contains(Username var1) {
		if (!var1.hasCleanName()) {
			return false;
		} else {
			return this.usernamesMap.containsKey(var1) ? true : this.previousUsernamesMap.containsKey(var1);
		}
	}

	public User getByUsername(Username var1) {
		User var2 = this.getByCurrentUsername(var1);
		return var2 != null ? var2 : this.getByPreviousUsername(var1);
	}

	User getByCurrentUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User) this.usernamesMap.get(var1);
	}

	User getByPreviousUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User) this.previousUsernamesMap.get(var1);
	}

	public final boolean removeByUsername(Username var1) {
		User var2 = this.getByCurrentUsername(var1);
		if (var2 == null) {
			return false;
		} else {
			this.remove(var2);
			return true;
		}
	}

	final void remove(User var1) {
		int var2 = this.indexOf(var1);
		if (var2 != -1) {
			this.arrayRemove(var2);
			this.mapRemove(var1);
		}
	}

	User addLastNoPreviousUsername(Username var1) {
		return this.addLast(var1, (Username) null);
	}

	User addLast(Username var1, Username var2) {
		if (this.getByCurrentUsername(var1) != null) {
			throw new IllegalStateException();
		} else {
			User var3 = this.newInstance();
			var3.set(var1, var2);
			this.arrayAddLast(var3);
			this.mapPut(var3);
			return var3;
		}
	}

	public final User get(int var1) {
		if (var1 >= 0 && var1 < this.size) {
			return this.array[var1];
		} else {
			throw new ArrayIndexOutOfBoundsException(var1);
		}
	}

	public final void sort() {
		if (this.comparator == null) {
			Arrays.sort(this.array, 0, this.size);
		} else {
			Arrays.sort(this.array, 0, this.size, this.comparator);
		}

	}

	final void changeName(User var1, Username var2, Username var3) {
		this.mapRemove(var1);
		var1.set(var2, var3);
		this.mapPut(var1);
	}

	final int indexOf(User var1) {
		for (int var2 = 0; var2 < this.size; ++var2) {
			if (this.array[var2] == var1) {
				return var2;
			}
		}

		return -1;
	}

	final void mapRemove(User var1) {
		if (this.usernamesMap.remove(var1.username) == null) {
			throw new IllegalStateException();
		} else {
			if (var1.previousUsername != null) {
				this.previousUsernamesMap.remove(var1.previousUsername);
			}

		}
	}

	final void arrayAddLast(User var1) {
		this.array[++this.size - 1] = var1;
	}

	final void mapPut(User var1) {
		this.usernamesMap.put(var1.username, var1);
		if (var1.previousUsername != null) {
			User var2 = (User) this.previousUsernamesMap.put(var1.previousUsername, var1);
			if (var2 != null && var2 != var1) {
				var2.previousUsername = null;
			}
		}

	}

	final void arrayRemove(int var1) {
		--this.size;
		if (var1 < this.size) {
			System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
		}

	}

	public final void removeComparator() {
		this.comparator = null;
	}

	public final void addComparator(Comparator var1) {
		if (this.comparator == null) {
			this.comparator = var1;
		} else if (this.comparator instanceof AbstractUserComparator) {
			((AbstractUserComparator) this.comparator).addComparator(var1);
		}

	}

	static final void addObjects(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6,
			CollisionMap var7) {
		if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0
				|| (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
			if (var0 < Tiles.Tiles_minPlane) {
				Tiles.Tiles_minPlane = var0;
			}

			ObjectComposition var8 = class463.getObjectDefinition(var3);
			int var9;
			int var10;
			if (var4 != 1 && var4 != 3) {
				var9 = var8.sizeX;
				var10 = var8.sizeY;
			} else {
				var9 = var8.sizeY;
				var10 = var8.sizeX;
			}

			int var11;
			int var12;
			if (var9 + var1 <= 104) {
				var11 = (var9 >> 1) + var1;
				var12 = (var9 + 1 >> 1) + var1;
			} else {
				var11 = var1;
				var12 = var1 + 1;
			}

			int var13;
			int var14;
			if (var10 + var2 <= 104) {
				var13 = (var10 >> 1) + var2;
				var14 = var2 + (var10 + 1 >> 1);
			} else {
				var13 = var2;
				var14 = var2 + 1;
			}

			int[][] var15 = Tiles.Tiles_heights[var0];
			int var16 = var15[var12][var13] + var15[var11][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
			int var17 = (var1 << 7) + (var9 << 6);
			int var18 = (var2 << 7) + (var10 << 6);
			long var19 = ItemLayer.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
			int var21 = var5 + (var4 << 6);
			if (var8.int3 == 1) {
				var21 += 256;
			}

			int var23;
			int var24;
			if (var8.hasSound()) {
				ObjectSound var22 = new ObjectSound();
				var22.plane = var0;
				var22.x = var1 * 128;
				var22.y = var2 * 128;
				var23 = var8.sizeX;
				var24 = var8.sizeY;
				if (var4 == 1 || var4 == 3) {
					var23 = var8.sizeY;
					var24 = var8.sizeX;
				}

				var22.maxX = (var23 + var1) * 128;
				var22.maxY = (var24 + var2) * 128;
				var22.soundEffectId = var8.ambientSoundId;
				var22.field692 = var8.int7 * 128;
				var22.field699 = var8.int5;
				var22.field695 = var8.int6;
				var22.soundEffectIds = var8.soundEffectIds;
				if (var8.transforms != null) {
					var22.obj = var8;
					var22.set();
				}

				ObjectSound.objectSounds.addFirst(var22);
				if (var22.soundEffectIds != null) {
					var22.field697 = var22.field699
							+ (int) (Math.random() * (double) (var22.field695 - var22.field699));
				}
			}

			Object var34;
			if (var5 == 22) {
				if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(22, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, var8.boolean3,
								(Renderable) null);
					}

					var6.newFloorDecoration(var0, var1, var2, var16, (Renderable) var34, var19, var21);
					if (var8.interactType == 1 && var7 != null) {
						var7.setBlockedByFloorDec(var1, var2);
					}

				}
			} else if (var5 != 10 && var5 != 11) {
				if (var5 >= 12) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3,
								(Renderable) null);
					}

					var6.method1193(var0, var1, var2, var16, 1, 1, (Renderable) var34, 0, var19, var21);
					if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
						class312.field3014[var0][var1][var2] |= 2340;
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
					}

				} else if (var5 == 0) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(0, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, var8.boolean3,
								(Renderable) null);
					}

					var6.newBoundaryObject(var0, var1, var2, var16, (Renderable) var34, (Renderable) null,
							Tiles.field838[var4], 0, var19, var21);
					if (var4 == 0) {
						if (var8.clipped) {
							Tiles.field836[var0][var1][var2] = 50;
							Tiles.field836[var0][var1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							class312.field3014[var0][var1][var2] |= 585;
						}
					} else if (var4 == 1) {
						if (var8.clipped) {
							Tiles.field836[var0][var1][var2 + 1] = 50;
							Tiles.field836[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							class312.field3014[var0][var1][var2 + 1] |= 1170;
						}
					} else if (var4 == 2) {
						if (var8.clipped) {
							Tiles.field836[var0][var1 + 1][var2] = 50;
							Tiles.field836[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							class312.field3014[var0][var1 + 1][var2] |= 585;
						}
					} else if (var4 == 3) {
						if (var8.clipped) {
							Tiles.field836[var0][var1][var2] = 50;
							Tiles.field836[var0][var1 + 1][var2] = 50;
						}

						if (var8.modelClipped) {
							class312.field3014[var0][var1][var2] |= 1170;
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.method1093(var1, var2, var5, var4, var8.boolean1);
					}

					if (var8.int2 != 16) {
						var6.method1234(var0, var1, var2, var8.int2);
					}

				} else if (var5 == 1) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(1, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, var8.boolean3,
								(Renderable) null);
					}

					var6.newBoundaryObject(var0, var1, var2, var16, (Renderable) var34, (Renderable) null,
							Tiles.field839[var4], 0, var19, var21);
					if (var8.clipped) {
						if (var4 == 0) {
							Tiles.field836[var0][var1][var2 + 1] = 50;
						} else if (var4 == 1) {
							Tiles.field836[var0][var1 + 1][var2 + 1] = 50;
						} else if (var4 == 2) {
							Tiles.field836[var0][var1 + 1][var2] = 50;
						} else if (var4 == 3) {
							Tiles.field836[var0][var1][var2] = 50;
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.method1093(var1, var2, var5, var4, var8.boolean1);
					}

				} else {
					int var28;
					if (var5 == 2) {
						var28 = var4 + 1 & 3;
						Object var29;
						Object var30;
						if (var8.animationId == -1 && var8.transforms == null) {
							var29 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
							var30 = var8.getEntity(2, var28, var15, var17, var16, var18);
						} else {
							var29 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId,
									var8.boolean3, (Renderable) null);
							var30 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, var8.boolean3,
									(Renderable) null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Renderable) var29, (Renderable) var30,
								Tiles.field838[var4], Tiles.field838[var28], var19, var21);
						if (var8.modelClipped) {
							if (var4 == 0) {
								class312.field3014[var0][var1][var2] |= 585;
								class312.field3014[var0][var1][var2 + 1] |= 1170;
							} else if (var4 == 1) {
								class312.field3014[var0][var1][var2 + 1] |= 1170;
								class312.field3014[var0][var1 + 1][var2] |= 585;
							} else if (var4 == 2) {
								class312.field3014[var0][var1 + 1][var2] |= 585;
								class312.field3014[var0][var1][var2] |= 1170;
							} else if (var4 == 3) {
								class312.field3014[var0][var1][var2] |= 1170;
								class312.field3014[var0][var1][var2] |= 585;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method1093(var1, var2, var5, var4, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method1234(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 3) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(3, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, var8.boolean3,
									(Renderable) null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Renderable) var34, (Renderable) null,
								Tiles.field839[var4], 0, var19, var21);
						if (var8.clipped) {
							if (var4 == 0) {
								Tiles.field836[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								Tiles.field836[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								Tiles.field836[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								Tiles.field836[var0][var1][var2] = 50;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method1093(var1, var2, var5, var4, var8.boolean1);
						}

					} else if (var5 == 9) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId,
									var8.boolean3, (Renderable) null);
						}

						var6.method1193(var0, var1, var2, var16, 1, 1, (Renderable) var34, 0, var19, var21);
						if (var8.interactType != 0 && var7 != null) {
							var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method1234(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 4) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(4, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3,
									(Renderable) null);
						}

						var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var34, (Renderable) null,
								Tiles.field838[var4], 0, 0, 0, var19, var21);
					} else {
						Object var25;
						long var31;
						if (var5 == 5) {
							var28 = 16;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (var31 != 0L) {
								var28 = class463.getObjectDefinition(class124.Entity_unpackID(var31)).int2;
							}

							if (var8.animationId == -1 && var8.transforms == null) {
								var25 = var8.getEntity(4, var4, var15, var17, var16, var18);
							} else {
								var25 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId,
										var8.boolean3, (Renderable) null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var25, (Renderable) null,
									Tiles.field838[var4], 0, var28 * Tiles.field840[var4], var28 * Tiles.field830[var4],
									var19, var21);
						} else if (var5 == 6) {
							var28 = 8;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (0L != var31) {
								var28 = class463.getObjectDefinition(class124.Entity_unpackID(var31)).int2 / 2;
							}

							if (var8.animationId == -1 && var8.transforms == null) {
								var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
							} else {
								var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId,
										var8.boolean3, (Renderable) null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var25, (Renderable) null, 256,
									var4, var28 * Tiles.field841[var4], var28 * Tiles.field842[var4], var19, var21);
						} else if (var5 == 7) {
							var23 = var4 + 2 & 3;
							if (var8.animationId == -1 && var8.transforms == null) {
								var34 = var8.getEntity(4, var23 + 4, var15, var17, var16, var18);
							} else {
								var34 = new DynamicObject(var3, 4, var23 + 4, var0, var1, var2, var8.animationId,
										var8.boolean3, (Renderable) null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var34, (Renderable) null, 256,
									var23, 0, 0, var19, var21);
						} else if (var5 == 8) {
							var28 = 8;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (var31 != 0L) {
								var28 = class463.getObjectDefinition(class124.Entity_unpackID(var31)).int2 / 2;
							}

							int var27 = var4 + 2 & 3;
							Object var26;
							if (var8.animationId == -1 && var8.transforms == null) {
								var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
								var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
							} else {
								var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId,
										var8.boolean3, (Renderable) null);
								var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId,
										var8.boolean3, (Renderable) null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var25, (Renderable) var26, 256,
									var4, var28 * Tiles.field841[var4], var28 * Tiles.field842[var4], var19, var21);
						}
					}
				}
			} else {
				if (var8.animationId == -1 && var8.transforms == null) {
					var34 = var8.getEntity(10, var4, var15, var17, var16, var18);
				} else {
					var34 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, var8.boolean3,
							(Renderable) null);
				}

				if (var34 != null && var6.method1193(var0, var1, var2, var16, var9, var10, (Renderable) var34,
						var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
					var23 = 15;
					if (var34 instanceof Model) {
						var23 = ((Model) var34).method1267() / 4;
						if (var23 > 30) {
							var23 = 30;
						}
					}

					for (var24 = 0; var24 <= var9; ++var24) {
						for (int var33 = 0; var33 <= var10; ++var33) {
							if (var23 > Tiles.field836[var0][var24 + var1][var33 + var2]) {
								Tiles.field836[var0][var24 + var1][var33 + var2] = (byte) var23;
							}
						}
					}
				}

				if (var8.interactType != 0 && var7 != null) {
					var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
				}

			}
		}
	}
}
