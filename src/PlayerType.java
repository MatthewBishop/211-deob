public enum PlayerType implements class349 {

	PlayerType_normal(0, -1, true, false, true),

	PlayerType_playerModerator(1, 0, true, true, true),

	PlayerType_jagexModerator(2, 1, true, true, false),

	PlayerType_ironman(3, 2, false, false, true),

	PlayerType_ultimateIronman(4, 3, false, false, true),

	PlayerType_hardcoreIronman(5, 10, false, false, true),

	field3409(6, 22, false, false, true),

	field3415(7, 41, false, false, true),

	field3416(8, 42, false, false, true),

	field3417(9, 43, false, false, true),

	field3418(10, 44, false, false, true),

	field3430(11, 45, false, false, true),

	field3420(12, 46, false, false, true),

	field3414(13, 47, false, false, true),

	field3422(14, 48, false, false, true),

	field3419(15, 49, false, false, true),

	field3424(16, 52, false, false, true);

	static IndexedSprite[] modIconSprites;

	static int menuHeight;

	final int id;

	public final int modIcon;

	public final boolean isPrivileged;

	public final boolean isUser;

	PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
		this.id = var3;
		this.modIcon = var4;
		this.isPrivileged = var6;
		this.isUser = var7;
	}

	public int rsOrdinal() {
		return this.id;
	}
}
