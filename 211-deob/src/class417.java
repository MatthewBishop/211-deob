import java.util.Arrays;

public final class class417 {

    public static final class417 field3779;

    public static class417[] field3775 = new class417[0];

    static int field3776 = 100;

    public static int field3777;

    public float[] field3778 = new float[16];

    static {
        field3775 = new class417[100];
        field3777 = 0;
        field3779 = new class417();
    }

    public class417() {
        this.method2187();
    }

    public class417(class417 var1) {
        this.method2176(var1);
    }

    public class417(Buffer var1, boolean var2) {
        this.method2184(var1, var2);
    }

    public void method2172() {
        class417[] var1 = field3775;
        synchronized (field3775) {
            if (field3777 < field3776 - 1) {
                field3775[++field3777 - 1] = this;
            }

        }
    }

    void method2184(Buffer var1, boolean var2) {
        if (var2) {
            class418 var3 = new class418();
            int var6 = var1.readShort();
            var6 &= 16383;
            float var5 = (float) (6.283185307179586D * (double) ((float) var6 / 16384.0F));
            var3.method2189(var5);
            int var9 = var1.readShort();
            var9 &= 16383;
            float var8 = (float) (6.283185307179586D * (double) ((float) var9 / 16384.0F));
            var3.method2192(var8);
            int var12 = var1.readShort();
            var12 &= 16383;
            float var11 = (float) ((double) ((float) var12 / 16384.0F) * 6.283185307179586D);
            var3.method2190(var11);
            var3.method2191((float) var1.readShort(), (float) var1.readShort(), (float) var1.readShort());
            this.method2179(var3);
        } else {
            for (int var13 = 0; var13 < 16; ++var13) {
                this.field3778[var13] = var1.method2428();
            }
        }

    }

    float[] method2173() {
        float[] var1 = new float[3];
        if ((double) this.field3778[2] < 0.999D && (double) this.field3778[2] > -0.999D) {
            var1[1] = (float) (-Math.asin((double) this.field3778[2]));
            double var2 = Math.cos((double) var1[1]);
            var1[0] = (float) Math.atan2((double) this.field3778[6] / var2, (double) this.field3778[10] / var2);
            var1[2] = (float) Math.atan2((double) this.field3778[1] / var2, (double) this.field3778[0] / var2);
        } else {
            var1[0] = 0.0F;
            var1[1] = (float) Math.atan2((double) this.field3778[2], 0.0D);
            var1[2] = (float) Math.atan2((double) (-this.field3778[9]), (double) this.field3778[5]);
        }

        return var1;
    }

    public float[] method2174() {
        float[] var1 = new float[] { (float) (-Math.asin((double) this.field3778[6])), 0.0F, 0.0F };
        double var2 = Math.cos((double) var1[0]);
        double var4;
        double var6;
        if (Math.abs(var2) > 0.005D) {
            var4 = (double) this.field3778[2];
            var6 = (double) this.field3778[10];
            double var8 = (double) this.field3778[4];
            double var10 = (double) this.field3778[5];
            var1[1] = (float) Math.atan2(var4, var6);
            var1[2] = (float) Math.atan2(var8, var10);
        } else {
            var4 = (double) this.field3778[1];
            var6 = (double) this.field3778[0];
            if (this.field3778[6] < 0.0F) {
                var1[1] = (float) Math.atan2(var4, var6);
            } else {
                var1[1] = (float) (-Math.atan2(var4, var6));
            }

            var1[2] = 0.0F;
        }

        return var1;
    }

    public void method2187() {
        this.field3778[0] = 1.0F;
        this.field3778[1] = 0.0F;
        this.field3778[2] = 0.0F;
        this.field3778[3] = 0.0F;
        this.field3778[4] = 0.0F;
        this.field3778[5] = 1.0F;
        this.field3778[6] = 0.0F;
        this.field3778[7] = 0.0F;
        this.field3778[8] = 0.0F;
        this.field3778[9] = 0.0F;
        this.field3778[10] = 1.0F;
        this.field3778[11] = 0.0F;
        this.field3778[12] = 0.0F;
        this.field3778[13] = 0.0F;
        this.field3778[14] = 0.0F;
        this.field3778[15] = 1.0F;
    }

    public void method2186() {
        this.field3778[0] = 0.0F;
        this.field3778[1] = 0.0F;
        this.field3778[2] = 0.0F;
        this.field3778[3] = 0.0F;
        this.field3778[4] = 0.0F;
        this.field3778[5] = 0.0F;
        this.field3778[6] = 0.0F;
        this.field3778[7] = 0.0F;
        this.field3778[8] = 0.0F;
        this.field3778[9] = 0.0F;
        this.field3778[10] = 0.0F;
        this.field3778[11] = 0.0F;
        this.field3778[12] = 0.0F;
        this.field3778[13] = 0.0F;
        this.field3778[14] = 0.0F;
        this.field3778[15] = 0.0F;
    }

    public void method2176(class417 var1) {
        System.arraycopy(var1.field3778, 0, this.field3778, 0, 16);
    }

    public void method2185(float var1) {
        this.method2182(var1, var1, var1);
    }

    public void method2182(float var1, float var2, float var3) {
        this.method2187();
        this.field3778[0] = var1;
        this.field3778[5] = var2;
        this.field3778[10] = var3;
    }

    public void method2177(class417 var1) {
        for (int var2 = 0; var2 < this.field3778.length; ++var2) {
            this.field3778[var2] += var1.field3778[var2];
        }

    }

    public void method2175(class417 var1) {
        float var2 = var1.field3778[0] * this.field3778[0] + var1.field3778[4] * this.field3778[1]
                + var1.field3778[8] * this.field3778[2] + var1.field3778[12] * this.field3778[3];
        float var3 = this.field3778[3] * var1.field3778[13] + this.field3778[1] * var1.field3778[5]
                + this.field3778[0] * var1.field3778[1] + var1.field3778[9] * this.field3778[2];
        float var4 = this.field3778[3] * var1.field3778[14] + var1.field3778[2] * this.field3778[0]
                + var1.field3778[6] * this.field3778[1] + this.field3778[2] * var1.field3778[10];
        float var5 = this.field3778[3] * var1.field3778[15] + this.field3778[2] * var1.field3778[11]
                + this.field3778[0] * var1.field3778[3] + var1.field3778[7] * this.field3778[1];
        float var6 = this.field3778[7] * var1.field3778[12] + this.field3778[6] * var1.field3778[8]
                + var1.field3778[0] * this.field3778[4] + this.field3778[5] * var1.field3778[4];
        float var7 = this.field3778[5] * var1.field3778[5] + this.field3778[4] * var1.field3778[1]
                + var1.field3778[9] * this.field3778[6] + this.field3778[7] * var1.field3778[13];
        float var8 = var1.field3778[14] * this.field3778[7] + var1.field3778[10] * this.field3778[6]
                + var1.field3778[6] * this.field3778[5] + var1.field3778[2] * this.field3778[4];
        float var9 = var1.field3778[11] * this.field3778[6] + this.field3778[5] * var1.field3778[7]
                + this.field3778[4] * var1.field3778[3] + this.field3778[7] * var1.field3778[15];
        float var10 = this.field3778[9] * var1.field3778[4] + var1.field3778[0] * this.field3778[8]
                + this.field3778[10] * var1.field3778[8] + this.field3778[11] * var1.field3778[12];
        float var11 = var1.field3778[13] * this.field3778[11] + this.field3778[10] * var1.field3778[9]
                + var1.field3778[5] * this.field3778[9] + var1.field3778[1] * this.field3778[8];
        float var12 = this.field3778[11] * var1.field3778[14] + var1.field3778[6] * this.field3778[9]
                + var1.field3778[2] * this.field3778[8] + this.field3778[10] * var1.field3778[10];
        float var13 = var1.field3778[15] * this.field3778[11] + var1.field3778[3] * this.field3778[8]
                + this.field3778[9] * var1.field3778[7] + this.field3778[10] * var1.field3778[11];
        float var14 = this.field3778[14] * var1.field3778[8] + this.field3778[12] * var1.field3778[0]
                + this.field3778[13] * var1.field3778[4] + var1.field3778[12] * this.field3778[15];
        float var15 = var1.field3778[13] * this.field3778[15] + this.field3778[12] * var1.field3778[1]
                + this.field3778[13] * var1.field3778[5] + var1.field3778[9] * this.field3778[14];
        float var16 = this.field3778[15] * var1.field3778[14] + var1.field3778[2] * this.field3778[12]
                + var1.field3778[6] * this.field3778[13] + this.field3778[14] * var1.field3778[10];
        float var17 = this.field3778[15] * var1.field3778[15] + this.field3778[14] * var1.field3778[11]
                + this.field3778[13] * var1.field3778[7] + this.field3778[12] * var1.field3778[3];
        this.field3778[0] = var2;
        this.field3778[1] = var3;
        this.field3778[2] = var4;
        this.field3778[3] = var5;
        this.field3778[4] = var6;
        this.field3778[5] = var7;
        this.field3778[6] = var8;
        this.field3778[7] = var9;
        this.field3778[8] = var10;
        this.field3778[9] = var11;
        this.field3778[10] = var12;
        this.field3778[11] = var13;
        this.field3778[12] = var14;
        this.field3778[13] = var15;
        this.field3778[14] = var16;
        this.field3778[15] = var17;
    }

    public void method2178(class416 var1) {
        float var2 = var1.field3774 * var1.field3774;
        float var3 = var1.field3771 * var1.field3774;
        float var4 = var1.field3774 * var1.field3772;
        float var5 = var1.field3773 * var1.field3774;
        float var6 = var1.field3771 * var1.field3771;
        float var7 = var1.field3772 * var1.field3771;
        float var8 = var1.field3771 * var1.field3773;
        float var9 = var1.field3772 * var1.field3772;
        float var10 = var1.field3773 * var1.field3772;
        float var11 = var1.field3773 * var1.field3773;
        this.field3778[0] = var2 + var6 - var11 - var9;
        this.field3778[1] = var5 + var5 + var7 + var7;
        this.field3778[2] = var8 - var4 - var4 + var8;
        this.field3778[4] = var7 + (var7 - var5 - var5);
        this.field3778[5] = var2 + var9 - var6 - var11;
        this.field3778[6] = var10 + var3 + var10 + var3;
        this.field3778[8] = var4 + var8 + var8 + var4;
        this.field3778[9] = var10 - var3 - var3 + var10;
        this.field3778[10] = var2 + var11 - var9 - var6;
    }

    void method2179(class418 var1) {
        this.field3778[0] = var1.field3785;
        this.field3778[1] = var1.field3781;
        this.field3778[2] = var1.field3782;
        this.field3778[3] = 0.0F;
        this.field3778[4] = var1.field3783;
        this.field3778[5] = var1.field3784;
        this.field3778[6] = var1.field3786;
        this.field3778[7] = 0.0F;
        this.field3778[8] = var1.field3787;
        this.field3778[9] = var1.field3788;
        this.field3778[10] = var1.field3791;
        this.field3778[11] = 0.0F;
        this.field3778[12] = var1.field3789;
        this.field3778[13] = var1.field3790;
        this.field3778[14] = var1.field3780;
        this.field3778[15] = 1.0F;
    }

    float method2180() {
        return this.field3778[8] * this.field3778[5] * this.field3778[3] * this.field3778[14]
                + this.field3778[13] * this.field3778[10] * this.field3778[3] * this.field3778[4]
                + (this.field3778[8] * this.field3778[1] * this.field3778[6] * this.field3778[15]
                        + this.field3778[14] * this.field3778[1] * this.field3778[4] * this.field3778[11]
                        + (this.field3778[14] * this.field3778[9] * this.field3778[0] * this.field3778[7]
                                + this.field3778[11] * this.field3778[6] * this.field3778[0] * this.field3778[13]
                                + (this.field3778[15] * this.field3778[10] * this.field3778[5] * this.field3778[0]
                                        - this.field3778[11] * this.field3778[5] * this.field3778[0]
                                                * this.field3778[14]
                                        - this.field3778[15] * this.field3778[9] * this.field3778[0]
                                                * this.field3778[6])
                                - this.field3778[0] * this.field3778[7] * this.field3778[10] * this.field3778[13]
                                - this.field3778[1] * this.field3778[4] * this.field3778[10] * this.field3778[15])
                        - this.field3778[12] * this.field3778[6] * this.field3778[1] * this.field3778[11]
                        - this.field3778[8] * this.field3778[1] * this.field3778[7] * this.field3778[14]
                        + this.field3778[12] * this.field3778[10] * this.field3778[7] * this.field3778[1]
                        + this.field3778[2] * this.field3778[4] * this.field3778[9] * this.field3778[15]
                        - this.field3778[13] * this.field3778[11] * this.field3778[4] * this.field3778[2]
                        - this.field3778[2] * this.field3778[5] * this.field3778[8] * this.field3778[15]
                        + this.field3778[12] * this.field3778[11] * this.field3778[5] * this.field3778[2]
                        + this.field3778[13] * this.field3778[2] * this.field3778[7] * this.field3778[8]
                        - this.field3778[7] * this.field3778[2] * this.field3778[9] * this.field3778[12]
                        - this.field3778[14] * this.field3778[4] * this.field3778[3] * this.field3778[9])
                - this.field3778[3] * this.field3778[5] * this.field3778[10] * this.field3778[12]
                - this.field3778[13] * this.field3778[3] * this.field3778[6] * this.field3778[8]
                + this.field3778[9] * this.field3778[6] * this.field3778[3] * this.field3778[12];
    }

    public void method2181() {
        float var1 = 1.0F / this.method2180();
        float var2 = var1 * (this.field3778[13] * this.field3778[6] * this.field3778[11]
                + (this.field3778[10] * this.field3778[5] * this.field3778[15]
                        - this.field3778[14] * this.field3778[11] * this.field3778[5]
                        - this.field3778[6] * this.field3778[9] * this.field3778[15])
                + this.field3778[9] * this.field3778[7] * this.field3778[14]
                - this.field3778[13] * this.field3778[10] * this.field3778[7]);
        float var3 = var1 * (this.field3778[13] * this.field3778[10] * this.field3778[3]
                + (this.field3778[10] * -this.field3778[1] * this.field3778[15]
                        + this.field3778[14] * this.field3778[11] * this.field3778[1]
                        + this.field3778[9] * this.field3778[2] * this.field3778[15]
                        - this.field3778[13] * this.field3778[11] * this.field3778[2]
                        - this.field3778[3] * this.field3778[9] * this.field3778[14]));
        float var4 = (this.field3778[15] * this.field3778[1] * this.field3778[6]
                - this.field3778[14] * this.field3778[7] * this.field3778[1]
                - this.field3778[2] * this.field3778[5] * this.field3778[15]
                + this.field3778[2] * this.field3778[7] * this.field3778[13]
                + this.field3778[5] * this.field3778[3] * this.field3778[14]
                - this.field3778[13] * this.field3778[6] * this.field3778[3]) * var1;
        float var5 = (this.field3778[9] * this.field3778[6] * this.field3778[3]
                + (this.field3778[2] * this.field3778[5] * this.field3778[11]
                        + this.field3778[1] * this.field3778[7] * this.field3778[10]
                        + this.field3778[11] * this.field3778[6] * -this.field3778[1]
                        - this.field3778[9] * this.field3778[7] * this.field3778[2]
                        - this.field3778[3] * this.field3778[5] * this.field3778[10]))
                * var1;
        float var6 = (this.field3778[6] * this.field3778[8] * this.field3778[15]
                + this.field3778[15] * -this.field3778[4] * this.field3778[10]
                + this.field3778[14] * this.field3778[4] * this.field3778[11]
                - this.field3778[12] * this.field3778[11] * this.field3778[6]
                - this.field3778[7] * this.field3778[8] * this.field3778[14]
                + this.field3778[12] * this.field3778[10] * this.field3778[7]) * var1;
        float var7 = var1 * (this.field3778[8] * this.field3778[3] * this.field3778[14]
                + this.field3778[2] * this.field3778[11] * this.field3778[12]
                + (this.field3778[10] * this.field3778[0] * this.field3778[15]
                        - this.field3778[0] * this.field3778[11] * this.field3778[14]
                        - this.field3778[15] * this.field3778[8] * this.field3778[2])
                - this.field3778[3] * this.field3778[10] * this.field3778[12]);
        float var8 = var1 * (this.field3778[2] * this.field3778[4] * this.field3778[15]
                + this.field3778[15] * this.field3778[6] * -this.field3778[0]
                + this.field3778[7] * this.field3778[0] * this.field3778[14]
                - this.field3778[12] * this.field3778[7] * this.field3778[2]
                - this.field3778[14] * this.field3778[3] * this.field3778[4]
                + this.field3778[3] * this.field3778[6] * this.field3778[12]);
        float var9 = (this.field3778[4] * this.field3778[3] * this.field3778[10]
                + this.field3778[11] * this.field3778[0] * this.field3778[6]
                - this.field3778[10] * this.field3778[7] * this.field3778[0]
                - this.field3778[11] * this.field3778[4] * this.field3778[2]
                + this.field3778[8] * this.field3778[2] * this.field3778[7]
                - this.field3778[8] * this.field3778[3] * this.field3778[6]) * var1;
        float var10 = (this.field3778[13] * this.field3778[7] * this.field3778[8]
                + this.field3778[11] * this.field3778[5] * this.field3778[12]
                + (this.field3778[9] * this.field3778[4] * this.field3778[15]
                        - this.field3778[4] * this.field3778[11] * this.field3778[13]
                        - this.field3778[15] * this.field3778[5] * this.field3778[8])
                - this.field3778[12] * this.field3778[7] * this.field3778[9]) * var1;
        float var11 = (this.field3778[3] * this.field3778[9] * this.field3778[12]
                + (this.field3778[8] * this.field3778[1] * this.field3778[15]
                        + this.field3778[9] * -this.field3778[0] * this.field3778[15]
                        + this.field3778[11] * this.field3778[0] * this.field3778[13]
                        - this.field3778[1] * this.field3778[11] * this.field3778[12]
                        - this.field3778[13] * this.field3778[3] * this.field3778[8]))
                * var1;
        float var12 = (this.field3778[15] * this.field3778[5] * this.field3778[0]
                - this.field3778[0] * this.field3778[7] * this.field3778[13]
                - this.field3778[1] * this.field3778[4] * this.field3778[15]
                + this.field3778[1] * this.field3778[7] * this.field3778[12]
                + this.field3778[13] * this.field3778[4] * this.field3778[3]
                - this.field3778[12] * this.field3778[5] * this.field3778[3]) * var1;
        float var13 = var1 * (this.field3778[3] * this.field3778[5] * this.field3778[8]
                + (this.field3778[11] * this.field3778[4] * this.field3778[1]
                        + -this.field3778[0] * this.field3778[5] * this.field3778[11]
                        + this.field3778[7] * this.field3778[0] * this.field3778[9]
                        - this.field3778[1] * this.field3778[7] * this.field3778[8]
                        - this.field3778[3] * this.field3778[4] * this.field3778[9]));
        float var14 = var1 * (this.field3778[14] * this.field3778[9] * -this.field3778[4]
                + this.field3778[13] * this.field3778[4] * this.field3778[10]
                + this.field3778[8] * this.field3778[5] * this.field3778[14]
                - this.field3778[12] * this.field3778[10] * this.field3778[5]
                - this.field3778[8] * this.field3778[6] * this.field3778[13]
                + this.field3778[12] * this.field3778[9] * this.field3778[6]);
        float var15 = (this.field3778[14] * this.field3778[0] * this.field3778[9]
                - this.field3778[13] * this.field3778[0] * this.field3778[10]
                - this.field3778[14] * this.field3778[8] * this.field3778[1]
                + this.field3778[12] * this.field3778[1] * this.field3778[10]
                + this.field3778[2] * this.field3778[8] * this.field3778[13]
                - this.field3778[12] * this.field3778[2] * this.field3778[9]) * var1;
        float var16 = var1 * (this.field3778[14] * this.field3778[1] * this.field3778[4]
                + this.field3778[5] * -this.field3778[0] * this.field3778[14]
                + this.field3778[6] * this.field3778[0] * this.field3778[13]
                - this.field3778[12] * this.field3778[6] * this.field3778[1]
                - this.field3778[4] * this.field3778[2] * this.field3778[13]
                + this.field3778[12] * this.field3778[2] * this.field3778[5]);
        float var17 = (this.field3778[9] * this.field3778[2] * this.field3778[4]
                + this.field3778[1] * this.field3778[6] * this.field3778[8]
                + (this.field3778[5] * this.field3778[0] * this.field3778[10]
                        - this.field3778[0] * this.field3778[6] * this.field3778[9]
                        - this.field3778[4] * this.field3778[1] * this.field3778[10])
                - this.field3778[2] * this.field3778[5] * this.field3778[8]) * var1;
        this.field3778[0] = var2;
        this.field3778[1] = var3;
        this.field3778[2] = var4;
        this.field3778[3] = var5;
        this.field3778[4] = var6;
        this.field3778[5] = var7;
        this.field3778[6] = var8;
        this.field3778[7] = var9;
        this.field3778[8] = var10;
        this.field3778[9] = var11;
        this.field3778[10] = var12;
        this.field3778[11] = var13;
        this.field3778[12] = var14;
        this.field3778[13] = var15;
        this.field3778[14] = var16;
        this.field3778[15] = var17;
    }

    public float[] method2183() {
        float[] var1 = new float[3];
        class415 var2 = new class415(this.field3778[0], this.field3778[1], this.field3778[2]);
        class415 var3 = new class415(this.field3778[4], this.field3778[5], this.field3778[6]);
        class415 var4 = new class415(this.field3778[8], this.field3778[9], this.field3778[10]);
        var1[0] = var2.method2166();
        var1[1] = var3.method2166();
        var1[2] = var4.method2166();
        return var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        this.method2174();
        this.method2173();

        for (int var2 = 0; var2 < 4; ++var2) {
            for (int var3 = 0; var3 < 4; ++var3) {
                if (var3 > 0) {
                    var1.append("\t");
                }

                float var4 = this.field3778[var3 + var2 * 4];
                if (Math.sqrt((double) (var4 * var4)) < 9.999999747378752E-5D) {
                    var4 = 0.0F;
                }

                var1.append(var4);
            }

            var1.append("\n");
        }

        return var1.toString();
    }

    public int hashCode() {
        boolean var1 = true;
        byte var2 = 1;
        int var3 = var2 * 31 + Arrays.hashCode(this.field3778);
        return var3;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class417)) {
            return false;
        } else {
            class417 var2 = (class417) var1;

            for (int var3 = 0; var3 < 16; ++var3) {
                if (var2.field3778[var3] != this.field3778[var3]) {
                    return false;
                }
            }

            return true;
        }
    }
}
