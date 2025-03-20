public class GameBuild {

	public static final GameBuild LIVE = new GameBuild("LIVE", 0);

	public static final GameBuild BUILDLIVE = new GameBuild("BUILDLIVE", 3);

	public static final GameBuild RC = new GameBuild("RC", 1);

	public static final GameBuild WIP = new GameBuild("WIP", 2);

	static TextureProvider textureProvider;

	public final String name;

	public final int buildId;

	GameBuild(String var1, int var2) {
		this.name = var1;
		this.buildId = var2;
	}
}
