import java.util.Date;

public enum class86 implements class349 {

    field883(0, -1),

    field882(1, 2),

    field886(2, 3),

    field884(3, 4),

    field885(4, 5),

    field888(5, 6);

    public static int cacheGamebuild;

    final int field889;

    final int field887;

    class86(int var3, int var4) {
        this.field889 = var3;
        this.field887 = var4;
    }

    public int rsOrdinal() {
        return this.field887;
    }

    static int method474(int var0, int var1) {
        if (var0 == -2) {
            return 12345678;
        } else if (var0 == -1) {
            if (var1 < 0) {
                var1 = 0;
            } else if (var1 > 127) {
                var1 = 127;
            }

            var1 = 127 - var1;
            return var1;
        } else {
            var1 = (var0 & 127) * var1 / 128;
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return (var0 & 'ﾀ') + var1;
        }
    }

    static boolean method472(Date var0) {
        java.util.Calendar var1 = java.util.Calendar.getInstance();
        var1.set(1, var1.get(1) - 13);
        var1.set(5, var1.get(5) + 1);
        var1.set(11, 0);
        var1.set(12, 0);
        var1.set(13, 0);
        var1.set(14, 0);
        Date var2 = var1.getTime();
        return var0.before(var2);
    }
}
