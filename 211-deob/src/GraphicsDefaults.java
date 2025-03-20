public class GraphicsDefaults {

    static String param9;

    public int compass = -1;

    public int field3758 = -1;

    public int mapScenes = -1;

    public int headIconsPk = -1;

    public int field3753 = -1;

    public int field3754 = -1;

    public int field3757 = -1;

    public int field3756 = -1;

    public int field3759 = -1;

    public int field3750 = -1;

    public int field3761 = -1;

    public void decode(AbstractArchive var1) {
        byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3749.group);
        Buffer var3 = new Buffer(var2);

        while (true) {
            int var4 = var3.readUnsignedByte();
            if (var4 == 0) {
                return;
            }

            switch (var4) {
            case 1:
                var3.readMedium();
                break;
            case 2:
                this.compass = var3.method2419();
                this.field3758 = var3.method2419();
                this.mapScenes = var3.method2419();
                this.headIconsPk = var3.method2419();
                this.field3753 = var3.method2419();
                this.field3754 = var3.method2419();
                this.field3757 = var3.method2419();
                this.field3756 = var3.method2419();
                this.field3759 = var3.method2419();
                this.field3750 = var3.method2419();
                this.field3761 = var3.method2419();
            }
        }
    }
}
