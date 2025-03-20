public class DbTableType extends DualNode {

    static AbstractArchive field3990;

    public static EvictingDualNodeHashTable DBTableType_cache = new EvictingDualNodeHashTable(64);

    public int[][] types;

    public Object[][] defaultValues;

    void method2346(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method2347(var1, var2);
        }
    }

    void method2347(Buffer var1, int var2) {
        if (var2 == 1) {
            int var3 = var1.readUnsignedByte();
            if (this.types == null) {
                this.types = new int[var3][];
            }

            for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
                int var5 = var4 & 127;
                boolean var6 = (var4 & 128) != 0;
                int[] var7 = new int[var1.readUnsignedByte()];

                for (int var8 = 0; var8 < var7.length; ++var8) {
                    var7[var8] = var1.readUShortSmart();
                }

                this.types[var5] = var7;
                if (var6) {
                    if (this.defaultValues == null) {
                        this.defaultValues = new Object[this.types.length][];
                    }

                    Object[][] var17 = this.defaultValues;
                    int var11 = var1.readUShortSmart();
                    Object[] var12 = new Object[var7.length * var11];

                    for (int var13 = 0; var13 < var11; ++var13) {
                        for (int var14 = 0; var14 < var7.length; ++var14) {
                            int var15 = var14 + var7.length * var13;
                            class463 var16 = class370.method1933(var7[var14]);
                            var12[var15] = var16.method2339(var1);
                        }
                    }

                    var17[var5] = var12;
                }
            }
        }

    }

    void method2348() {
    }
}
