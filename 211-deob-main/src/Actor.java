public abstract class Actor extends Renderable {

	int x;

	int y;

	int rotation;

	boolean isWalking = false;

	int field939 = 1;

	int playerCycle;

	int idleSequence = -1;

	int turnLeftSequence = -1;

	int turnRightSequence = -1;

	int walkSequence = -1;

	int walkBackSequence = -1;

	int walkLeftSequence = -1;

	int walkRightSequence = -1;

	int runSequence = -1;

	int runBackSequence = -1;

	int runLeftSequence = -1;

	int runRightSequence = -1;

	int crawlSequence = -1;

	int crawlBackSequence = -1;

	int crawlLeftSequence = -1;

	int crawlRightSequence = -1;

	String overheadText = null;

	boolean isAutoChatting;

	boolean showPublicPlayerChat = false;

	int overheadTextCyclesRemaining = 100;

	int field937 = 0;

	int field961 = 0;

	byte hitSplatCount = 0;

	int[] hitSplatTypes = new int[4];

	int[] hitSplatValues = new int[4];

	int[] hitSplatCycles = new int[4];

	int[] hitSplatTypes2 = new int[4];

	int[] hitSplatValues2 = new int[4];

	IterableNodeDeque healthBars = new IterableNodeDeque();

	int targetIndex = -1;

	boolean false0 = false;

	int movingOrientation = -1;

	boolean instantTurn;

	int movementSequence = -1;

	int movementFrame = 0;

	int movementFrameCycle = 0;

	int field976 = 0;

	int sequence = -1;

	int sequenceFrame = 0;

	int sequenceFrameCycle = 0;

	int sequenceDelay = 0;

	int currentSequenceFrameIndex = 0;

	int spotAnimation = -1;

	int spotAnimationFrame = 0;

	int spotAnimFrameCycle = 0;

	int spotAnimationStartCycle;

	int spotAnimHeight;

	int exactMoveDeltaX1;

	int exactMoveDeltaX2;

	int exactMoveDeltaY1;

	int exactMoveDeltaY2;

	int exactMoveArrive1Cycle;

	int exactMoveArrive2Cycle;

	int exactMoveDirection;

	int npcCycle = 0;

	int defaultHeight = 200;

	int recolourStartCycle = -1;

	int recolourEndCycle = -1;

	byte recolourHue;

	byte recolourSaturation;

	byte recolourLuminance;

	byte recolourAmount;

	int orientation;

	int field967 = 0;

	int field1004 = 32;

	int pathLength = 0;

	int[] pathX = new int[10];

	int[] pathY = new int[10];

	MoveSpeed[] pathTraversed = new MoveSpeed[10];

	int field951 = 0;

	int field1006 = 0;

	int combatLevelChange = -1;

	boolean isVisible() {
		return false;
	}

	final void method501() {
		this.pathLength = 0;
		this.field1006 = 0;
	}

	final void addHitSplat(int var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var7 = true;
		boolean var8 = true;

		int var9;
		for (var9 = 0; var9 < 4; ++var9) {
			if (this.hitSplatCycles[var9] > var5) {
				var7 = false;
			} else {
				var8 = false;
			}
		}

		var9 = -1;
		int var10 = -1;
		int var11 = 0;
		if (var1 >= 0) {
			HitSplatDefinition var12 = ChatChannel.method446(var1);
			var10 = var12.field1658;
			var11 = var12.field1655;
		}

		int var14;
		if (var8) {
			if (var10 == -1) {
				return;
			}

			var9 = 0;
			var14 = 0;
			if (var10 == 0) {
				var14 = this.hitSplatCycles[0];
			} else if (var10 == 1) {
				var14 = this.hitSplatValues[0];
			}

			for (int var13 = 1; var13 < 4; ++var13) {
				if (var10 == 0) {
					if (this.hitSplatCycles[var13] < var14) {
						var9 = var13;
						var14 = this.hitSplatCycles[var13];
					}
				} else if (var10 == 1 && this.hitSplatValues[var13] < var14) {
					var9 = var13;
					var14 = this.hitSplatValues[var13];
				}
			}

			if (var10 == 1 && var14 >= var2) {
				return;
			}
		} else {
			if (var7) {
				this.hitSplatCount = 0;
			}

			for (var14 = 0; var14 < 4; ++var14) {
				byte var15 = this.hitSplatCount;
				this.hitSplatCount = (byte) ((this.hitSplatCount + 1) % 4);
				if (this.hitSplatCycles[var15] <= var5) {
					var9 = var15;
					break;
				}
			}
		}

		if (var9 >= 0) {
			this.hitSplatTypes[var9] = var1;
			this.hitSplatValues[var9] = var2;
			this.hitSplatTypes2[var9] = var3;
			this.hitSplatValues2[var9] = var4;
			this.hitSplatCycles[var9] = var5 + var11 + var6;
		}
	}

	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var7 = class122.method687(var1);
		HealthBar var8 = null;
		HealthBar var9 = null;
		int var10 = var7.int2;
		int var11 = 0;

		HealthBar var12;
		for (var12 = (HealthBar) this.healthBars.last(); var12 != null; var12 = (HealthBar) this.healthBars
				.previous()) {
			++var11;
			if (var12.definition.field1517 == var7.field1517) {
				var12.put(var2 + var4, var5, var6, var3);
				return;
			}

			if (var12.definition.int1 <= var7.int1) {
				var8 = var12;
			}

			if (var12.definition.int2 > var10) {
				var9 = var12;
				var10 = var12.definition.int2;
			}
		}

		if (var9 != null || var11 < 4) {
			var12 = new HealthBar(var7);
			if (var8 == null) {
				this.healthBars.addLast(var12);
			} else {
				IterableNodeDeque.IterableNodeDeque_addBefore(var12, var8);
			}

			var12.put(var2 + var4, var5, var6, var3);
			if (var11 >= 4) {
				var9.remove();
			}

		}
	}

	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = class122.method687(var1);

		for (HealthBar var3 = (HealthBar) this.healthBars.last(); var3 != null; var3 = (HealthBar) this.healthBars
				.previous()) {
			if (var2 == var3.definition) {
				var3.remove();
				return;
			}
		}

	}

	public static StructComposition StructDefinition_getStructDefinition(int var0) {
		StructComposition var1 = (StructComposition) StructComposition.StructDefinition_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = StructComposition.StructDefinition_archive.takeFile(34, var0);
			var1 = new StructComposition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			StructComposition.StructDefinition_cached.put(var1, (long) var0);
			return var1;
		}
	}

	static final void method505(double var0) {
		Rasterizer3D.Rasterizer3D_setBrightness(var0);
		((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(var0);
		ItemComposition.ItemDefinition_cachedSprites.clear();
		PacketWriter.clientPreferences.setBrightness(var0);
	}
}
