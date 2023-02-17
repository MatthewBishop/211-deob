import java.util.Iterator;
import java.util.LinkedList;

public class WorldMapArea {

	static ClanSettings field2264;

	int id = -1;

	String internalName;

	String externalName;

	int backGroundColor = -1;

	int zoom = -1;

	Coord origin = null;

	int regionLowX = Integer.MAX_VALUE;

	int regionHighX = 0;

	int regionLowY = Integer.MAX_VALUE;

	int regionHighY = 0;

	boolean isMain = false;

	LinkedList sections;

	public void read(Buffer var1, int var2) {
		this.id = var2;
		this.internalName = var1.readStringCp1252NullTerminated();
		this.externalName = var1.readStringCp1252NullTerminated();
		this.origin = new Coord(var1.readInt());
		this.backGroundColor = var1.readInt();
		var1.readUnsignedByte();
		this.isMain = var1.readUnsignedByte() == 1;
		this.zoom = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		this.sections = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.sections.add(this.readWorldMapSection(var1));
		}

		this.setBounds();
	}

	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType[] var3 = new WorldMapSectionType[] { WorldMapSectionType.WORLDMAPSECTIONTYPE2,
				WorldMapSectionType.WORLDMAPSECTIONTYPE1, WorldMapSectionType.WORLDMAPSECTIONTYPE3,
				WorldMapSectionType.WORLDMAPSECTIONTYPE0 };
		WorldMapSectionType var4 = (WorldMapSectionType) class4.findEnumerated(var3, var2);
		Object var5 = null;
		switch (var4.type) {
		case 0:
			var5 = new WorldMapSection2();
			break;
		case 1:
			var5 = new WorldMapSection0();
			break;
		case 2:
			var5 = new class245();
			break;
		case 3:
			var5 = new WorldMapSection1();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection) var5).read(var1);
		return (WorldMapSection) var5;
	}

	public boolean containsCoord(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			var5 = (WorldMapSection) var4.next();
		} while (!var5.containsCoord(var1, var2, var3));

		return true;
	}

	public boolean containsPosition(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
				Iterator var5 = this.sections.iterator();

				WorldMapSection var6;
				do {
					if (!var5.hasNext()) {
						return false;
					}

					var6 = (WorldMapSection) var5.next();
				} while (!var6.containsPosition(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int[] position(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapSection) var4.next();
		} while (!var5.containsCoord(var1, var2, var3));

		return var5.getBorderTileLengths(var1, var2, var3);
	}

	public Coord coord(int var1, int var2) {
		Iterator var3 = this.sections.iterator();

		WorldMapSection var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (WorldMapSection) var3.next();
		} while (!var4.containsPosition(var1, var2));

		return var4.coord(var1, var2);
	}

	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection) var1.next();
			var2.expandBounds(this);
		}

	}

	public int getId() {
		return this.id;
	}

	public boolean getIsMain() {
		return this.isMain;
	}

	public String getInternalName() {
		return this.internalName;
	}

	public String getExternalName() {
		return this.externalName;
	}

	int getBackGroundColor() {
		return this.backGroundColor;
	}

	public int getZoom() {
		return this.zoom;
	}

	public int getRegionLowX() {
		return this.regionLowX;
	}

	public int getRegionHighX() {
		return this.regionHighX;
	}

	public int getRegionLowY() {
		return this.regionLowY;
	}

	public int getRegionHighY() {
		return this.regionHighY;
	}

	public int getOriginX() {
		return this.origin.x;
	}

	public int getOriginPlane() {
		return this.origin.plane;
	}

	public int getOriginY() {
		return this.origin.y;
	}

	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	public static InvDefinition getInvDefinition(int var0) {
		InvDefinition var1 = (InvDefinition) InvDefinition.InvDefinition_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0);
			var1 = new InvDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			InvDefinition.InvDefinition_cached.put(var1, (long) var0);
			return var1;
		}
	}

	static AttackOption[] method1355() {
		return new AttackOption[] { AttackOption.AttackOption_hidden, AttackOption.field1071, AttackOption.field1067,
				AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels };
	}

	static void method1353() {
		ReflectionCheck.method171(24);
		class70.setLoginResponseString("", "You were disconnected from the server.", "");
	}
}
