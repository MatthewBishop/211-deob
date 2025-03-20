public class StructComposition extends DualNode {

    public static AbstractArchive StructDefinition_archive;

    static EvictingDualNodeHashTable StructDefinition_cached = new EvictingDualNodeHashTable(64);

    IterableNodeHashTable params;

    void postDecode() {
    }

    void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decodeNext(var1, var2);
        }
    }

    void decodeNext(Buffer var1, int var2) {
        if (var2 == 249) {
            this.params = class127.readStringIntParameters(var1, this.params);
        }

    }

    public int getIntParam(int var1, int var2) {
        IterableNodeHashTable var4 = this.params;
        int var3;
        if (var4 == null) {
            var3 = var2;
        } else {
            IntegerNode var5 = (IntegerNode) var4.get((long) var1);
            if (var5 == null) {
                var3 = var2;
            } else {
                var3 = var5.integer;
            }
        }

        return var3;
    }

    public String getStringParam(int var1, String var2) {
        return class145.method771(this.params, var1, var2);
    }

    public static long method1003(int var0) {
        if (var0 > 63) {
            throw new class367(
                    "Cannot generate max unsigned value for more than 63 bits as this is greater than the boundaries of a java long. Value provided: %d",
                    new Object[] { var0 });
        } else {
            return (long) Math.pow(2.0D, (double) var0) - 1L;
        }
    }

    public static void method1001(boolean var0) {
        if (var0 != ItemComposition.ItemDefinition_inMembersWorld) {
            TaskHandler.method888();
            ItemComposition.ItemDefinition_inMembersWorld = var0;
        }

    }

    static int method1002(int var0, Script var1, boolean var2) {
        return 2;
    }

    static final void method999() {
        int var0 = class130.menuX;
        int var1 = ModeWhere.menuY;
        int var2 = class7.menuWidth;
        int var3 = PlayerType.menuHeight;
        int var4 = 6116423;
        Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
        Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
        Rasterizer2D.Rasterizer2D_drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
        class19.fontBold12.draw("Choose Option", var0 + 3, var1 + 14, var4, -1);
        int var5 = MouseHandler.MouseHandler_x;
        int var6 = MouseHandler.MouseHandler_y;

        for (int var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
            int var8 = var1 + (Client.menuOptionsCount - 1 - var7) * 15 + 31;
            int var9 = 16777215;
            if (var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
                var9 = 16776960;
            }

            class19.fontBold12.draw(TriBool.method2128(var7), var0 + 3, var8, var9, 0);
        }

        class7.method27(class130.menuX, ModeWhere.menuY, class7.menuWidth, PlayerType.menuHeight);
    }
}
