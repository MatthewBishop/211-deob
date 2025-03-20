public final class WallDecoration {

    int z;

    int x;

    int y;

    int orientation;

    int orientation2;

    int xOffset;

    int yOffset;

    public Renderable renderable1;

    public Renderable renderable2;

    public long tag = 0L;

    int flags = 0;

    public static boolean method1307(int var0) {
        return var0 >= WorldMapDecorationType.field3038.id && var0 <= WorldMapDecorationType.field3032.id
                || var0 == WorldMapDecorationType.field3037.id;
    }

    public static int method1305(long var0) {
        return (int) (var0 >>> 0 & 127L);
    }

    static Widget method1306(Widget var0) {
        Widget var2 = var0;
        int var3 = ClanChannel.method846(class173.getWidgetFlags(var0));
        Widget var1;
        if (var3 == 0) {
            var1 = null;
        } else {
            int var4 = 0;

            while (true) {
                if (var4 >= var3) {
                    var1 = var2;
                    break;
                }

                var2 = class133.getWidget(var2.parentId);
                if (var2 == null) {
                    var1 = null;
                    break;
                }

                ++var4;
            }
        }

        Widget var5 = var1;
        if (var1 == null) {
            var5 = var0.parent;
        }

        return var5;
    }
}
