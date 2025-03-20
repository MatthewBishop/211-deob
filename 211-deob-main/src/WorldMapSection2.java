@Deprecated

public class WorldMapSection2 implements WorldMapSection {

	int minPlane;

	int planes;

	int regionStartX;

	int regionStartY;

	int regionEndX;

	int regionEndY;

	int field2251;

	int field2250;

	int field2256;

	int field2257;

	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2251) {
			var1.regionLowX = this.field2251;
		}

		if (var1.regionHighX < this.field2256) {
			var1.regionHighX = this.field2256;
		}

		if (var1.regionLowY > this.field2250) {
			var1.regionLowY = this.field2250;
		}

		if (var1.regionHighY < this.field2257) {
			var1.regionHighY = this.field2257;
		}

	}

	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY
					&& var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field2251 && var1 >> 6 <= this.field2256 && var2 >> 6 >= this.field2250
				&& var2 >> 6 <= this.field2257;
	}

	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] { var2 + (this.field2251 * 64 - this.regionStartX * 64),
					var3 + (this.field2250 * 64 - this.regionStartY * 64) };
			return var4;
		}
	}

	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field2251 * 64 + var1;
			int var4 = var2 + (this.regionStartY * 64 - this.field2250 * 64);
			return new Coord(this.minPlane, var3, var4);
		}
	}

	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field2251 = var1.readUnsignedShort();
		this.field2250 = var1.readUnsignedShort();
		this.field2256 = var1.readUnsignedShort();
		this.field2257 = var1.readUnsignedShort();
		this.postRead();
	}

	void postRead() {
	}
}
