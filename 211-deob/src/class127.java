public class class127 implements class349 {

    static final class127 field1244 = new class127(0, 0, (String) null, -1, -1);

    static final class127 field1237 = new class127(1, 1, (String) null, 0, 2);

    static final class127 field1246 = new class127(2, 2, (String) null, 1, 2);

    static final class127 field1238 = new class127(3, 3, (String) null, 2, 2);

    static final class127 field1240 = new class127(4, 4, (String) null, 3, 1);

    static final class127 field1256 = new class127(5, 5, (String) null, 4, 1);

    static final class127 field1242 = new class127(6, 6, (String) null, 5, 1);

    static final class127 field1243 = new class127(7, 7, (String) null, 6, 3);

    static final class127 field1239 = new class127(8, 8, (String) null, 7, 3);

    static final class127 field1245 = new class127(9, 9, (String) null, 8, 3);

    static final class127 field1241 = new class127(10, 10, (String) null, 0, 7);

    static final class127 field1247 = new class127(11, 11, (String) null, 1, 7);

    static final class127 field1248 = new class127(12, 12, (String) null, 2, 7);

    static final class127 field1249 = new class127(13, 13, (String) null, 3, 7);

    static final class127 field1250 = new class127(14, 14, (String) null, 4, 7);

    static final class127 field1251 = new class127(15, 15, (String) null, 5, 7);

    static final class127 field1252 = new class127(16, 16, (String) null, 0, 5);

    public static int canvasHeight;

    final int field1253;

    final int field1254;

    final int field1255;

    class127(int var1, int var2, String var3, int var4, int var5) {
        this.field1253 = var1;
        this.field1254 = var2;
        this.field1255 = var4;
    }

    public int rsOrdinal() {
        return this.field1254;
    }

    int method711() {
        return this.field1255;
    }

    static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
        int var2 = var0.readUnsignedByte();
        int var3;
        if (var1 == null) {
            var3 = class4.method5(var2);
            var1 = new IterableNodeHashTable(var3);
        }

        for (var3 = 0; var3 < var2; ++var3) {
            boolean var4 = var0.readUnsignedByte() == 1;
            int var5 = var0.readMedium();
            Object var6;
            if (var4) {
                var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
            } else {
                var6 = new IntegerNode(var0.readInt());
            }

            var1.put((Node) var6, (long) var5);
        }

        return var1;
    }

    static final void method712() {
        boolean var0 = false;

        while (!var0) {
            var0 = true;

            for (int var1 = 0; var1 < Client.menuOptionsCount - 1; ++var1) {
                if (Client.menuOpcodes[var1] < 1000 && Client.menuOpcodes[var1 + 1] > 1000) {
                    String var2 = Client.menuTargets[var1];
                    Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                    Client.menuTargets[var1 + 1] = var2;
                    String var3 = Client.menuActions[var1];
                    Client.menuActions[var1] = Client.menuActions[var1 + 1];
                    Client.menuActions[var1 + 1] = var3;
                    int var4 = Client.menuOpcodes[var1];
                    Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
                    Client.menuOpcodes[var1 + 1] = var4;
                    var4 = Client.menuArguments1[var1];
                    Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
                    Client.menuArguments1[var1 + 1] = var4;
                    var4 = Client.menuArguments2[var1];
                    Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
                    Client.menuArguments2[var1 + 1] = var4;
                    var4 = Client.menuIdentifiers[var1];
                    Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                    Client.menuIdentifiers[var1 + 1] = var4;
                    var4 = Client.menuItemIds[var1];
                    Client.menuItemIds[var1] = Client.menuItemIds[var1 + 1];
                    Client.menuItemIds[var1 + 1] = var4;
                    boolean var5 = Client.menuShiftClick[var1];
                    Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
                    Client.menuShiftClick[var1 + 1] = var5;
                    var0 = false;
                }
            }
        }

    }
}
