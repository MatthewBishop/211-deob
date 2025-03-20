import java.util.LinkedList;

public abstract class AbstractWorldMapData {

	public static boolean field2351 = true;

	int regionXLow;

	int regionYLow;

	int regionX;

	int regionY;

	int minPlane;

	int planes;

	int groupId = -1;

	int fileId = -1;

	short[][][] floorUnderlayIds;

	short[][][] floorOverlayIds;

	byte[][][] field2358;

	byte[][][] field2355;

	WorldMapDecoration[][][][] decorations;

	boolean field2356;

	boolean field2357;

	AbstractWorldMapData() {
		new LinkedList();
		this.field2356 = false;
		this.field2357 = false;
	}

	abstract void readGeography(Buffer var1);

	boolean isFullyLoaded() {
		return this.field2356 && this.field2357;
	}

	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field2356 = true;
				this.field2357 = true;
			}

		}
	}

	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field2358 = null;
		this.field2355 = null;
		this.decorations = null;
		this.field2356 = false;
		this.field2357 = false;
	}

	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method1445(var1, var2, var3, var4);
			} else {
				this.method1450(var1, var2, var3, var4);
			}

		}
	}

	void method1445(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = field2351 ? (short) var3.readUnsignedShort()
					: (short) var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = field2351 ? (short) var3.readUnsignedShort()
				: (short) var3.readUnsignedByte();
	}

	void method1450(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean hasOverlay = (var4 & 2) != 0;
		boolean hasObjects = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = field2351 ? (short) var3.readUnsignedShort()
				: (short) var3.readUnsignedByte();
		int var9;
		int var11;
		if (hasOverlay) {
			int var8 = var3.readUnsignedByte();
			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = field2351 ? var3.readUnsignedShort() : var3.readUnsignedByte();
				
				if (var10 != 0) {
					var11 = var3.readUnsignedByte();
					if (var9 < this.floorOverlayIds.length) {
						this.floorOverlayIds[var9][var1][var2] = (short) var10;
						this.field2358[var9][var1][var2] = (byte) (var11 >> 2);
						this.field2355[var9][var1][var2] = (byte) (var11 & 3);
					} else {
						System.out.println("SAVED IT");
					}
				}
				
//				if (var10 != 0) {
//					this.floorOverlayIds[var9][var1][var2] = (short) var10;
//					var11 = var3.readUnsignedByte();
//					this.field2358[var9][var1][var2] = (byte) (var11 >> 2);
//					this.field2355[var9][var1][var2] = (byte) (var11 & 3);
//				}
			}
		}

		if (hasObjects) {
			for (int var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method2419();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	int getRegionX() {
		return this.regionX;
	}

	int getRegionY() {
		return this.regionY;
	}

	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth * -1665715877 * 1727370963
				: var1.width * -1145697413 * -1115677773;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight * -2014827871 * 1565145441
				: var1.height * -1361869075 * 2038548197;
		class374.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			class374.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent) Client.interfaceParents.get((long) var1.id);
		if (var5 != null) {
			int var6 = var5.group;
			if (class153.loadInterface(var6)) {
				class374.resizeInterface(WorldMapLabel.Widget_interfaceComponents[var6], -1, var3, var4, var2);
			}
		}

		if (var1.contentType == 1337) {
			;
		}

	}
}
