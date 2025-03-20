import java.applet.Applet;

public final class Occluder {

    static int cameraMoveToX;

    int minTileX;

    int maxTileX;

    int minTileY;

    int maxTileY;

    int type;

    int minX;

    int maxX;

    int minZ;

    int maxZ;

    int minY;

    int maxY;

    int field2066;

    int field2072;

    int field2071;

    int field2074;

    int field2073;

    int field2078;

    int field2077;

    public static void method1251(Applet var0, String var1) {
        class31.field100 = var0;
        if (var1 != null) {
            class31.field99 = var1;
        }

    }

    static void method1250(String var0) {
        String var1;
        if (var0 != null && !var0.isEmpty() && var0.charAt(0) != '#') {
            var1 = var0;
        } else {
            var1 = "";
        }

        Login.field762 = var1;
    }
}
