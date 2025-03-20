public class VertexNormal {

    int x;

    int y;

    int z;

    int magnitude;

    VertexNormal() {
    }

    VertexNormal(VertexNormal var1) {
        this.x = var1.x;
        this.y = var1.y;
        this.z = var1.z;
        this.magnitude = var1.magnitude;
    }

    public static long method1298(int var0) {
        return ViewportMouse.ViewportMouse_entityTags[var0];
    }

    static void method1299() {
        WorldMapRegion.WorldMapRegion_cachedSprites.clear();
    }

    public static void method1297() {
        PlayerComposition.PlayerAppearance_cachedModels.clear();
    }
}
