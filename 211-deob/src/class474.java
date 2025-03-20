public class class474 {

    int[] field4007 = new int[8];

    short[] field4008 = new short[8];

    public class474(NPCComposition var1) {
        int var2 = 0;
        if (var1.method964()) {
            var2 = var1.method970().length;
            System.arraycopy(var1.method970(), 0, this.field4007, 0, var2);
            System.arraycopy(var1.method967(), 0, this.field4008, 0, var2);
        }

        for (int var3 = var2; var3 < 8; ++var3) {
            this.field4007[var3] = -1;
            this.field4008[var3] = -1;
        }

    }

    public int[] method2445() {
        return this.field4007;
    }

    public short[] method2446() {
        return this.field4008;
    }

    public void method2447(int var1, int var2, short var3) {
        this.field4007[var1] = var2;
        this.field4008[var1] = var3;
    }

    public void method2448(int[] var1, short[] var2) {
        this.field4007 = var1;
        this.field4008 = var2;
    }
}
