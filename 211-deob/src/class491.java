public class class491 {

    static SpritePixels[] worldSelectBackSprites;

    static class458 HitSplatDefinition_cachedSprites;

    int field4113;

    int field4101;

    int field4103;

    int field4110;

    int field4104;

    int field4106;

    int field4102 = 0;

    int field4108 = 0;

    boolean field4109;

    int field4105;

    int field4111;

    int field4112;

    int field4107;

    public void method2537(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9,
            int var10, boolean var11) {
        this.field4113 = var1;
        this.field4101 = var2;
        this.field4103 = var3;
        this.field4110 = var4;
        this.field4104 = var5;
        this.field4106 = var6;
        this.field4102 = var9;
        this.field4108 = var10;
        this.field4109 = var11;
    }

    public void method2535(int var1, int var2, int var3, int var4) {
        this.field4105 = var1;
        this.field4111 = var2;
        this.field4112 = var3;
        this.field4107 = var4;
    }

    public void method2536(class372 var1, Font var2) {
        if (var2 != null) {
            int var3 = var2.ascent;
            int var4 = Math.min(this.field4110, (int) (0.9F * (float) var3));
            int var5 = this.field4113 - this.field4104;
            int var6 = var3 + (this.field4101 - this.field4106);
            Rasterizer2D.Rasterizer2D_setClip(this.field4113, this.field4101, this.field4103 + this.field4113,
                    this.field4110 + this.field4101);
            int var7 = this.field4108;
            int var8 = this.field4102;
            if (var7 > var8) {
                int var9 = var7;
                var7 = var8;
                var8 = var9;
            }

            class376 var19 = var1.method1965(0, var7);
            class376 var10 = var1.method1965(var7, var8);
            class376 var11 = var1.method1965(var8, var1.method1967());
            class376 var12 = var1.method1965(0, this.field4102);
            int var14;
            int var16;
            if (!var10.method2006()) {
                int var13 = var2.maxDescent + var2.maxAscent;

                for (var14 = 0; var14 < var10.method2008(); ++var14) {
                    class374 var15 = var10.method2011(var14);
                    var16 = var5 + var15.field3601;
                    int var17 = var2.charWidth(var15.field3603);
                    int var18 = var6 + var15.field3602 - var3;
                    Rasterizer2D.Rasterizer2D_fillRectangle(var16, var18, var17, var13, this.field4107);
                }
            }

            if (!var19.method2006()) {
                var2.method1985(var19, var5, var6, this.field4105, this.field4111, -1);
            }

            if (!var10.method2006()) {
                var2.method1985(var10, var5, var6, this.field4112, this.field4111, -1);
            }

            if (!var11.method2006()) {
                var2.method1985(var11, var5, var6, this.field4105, this.field4111, -1);
            }

            if (this.field4109) {
                class447 var20 = var12.method2010();
                var14 = var5 + (Integer) var20.field3927;
                int var21 = var6 + (Integer) var20.field3928;
                var16 = var21 - var4;
                Rasterizer2D.Rasterizer2D_drawLine(var14, var21, var14, var16, this.field4105);
                if (this.field4111 != -1) {
                    Rasterizer2D.Rasterizer2D_drawLine(var14 + 1, var21 + 1, var14 + 1, var16 + 1, this.field4111);
                }
            }

        }
    }
}
