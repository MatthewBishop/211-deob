public class class418 {

    float field3785;

    float field3781;

    float field3782;

    float field3783;

    float field3784;

    float field3786;

    float field3787;

    float field3788;

    float field3791;

    float field3789;

    float field3790;

    float field3780;

    static {
        new class418();
    }

    class418() {
        this.method2188();
    }

    void method2188() {
        this.field3780 = 0.0F;
        this.field3790 = 0.0F;
        this.field3789 = 0.0F;
        this.field3788 = 0.0F;
        this.field3787 = 0.0F;
        this.field3786 = 0.0F;
        this.field3783 = 0.0F;
        this.field3782 = 0.0F;
        this.field3781 = 0.0F;
        this.field3791 = 1.0F;
        this.field3784 = 1.0F;
        this.field3785 = 1.0F;
    }

    void method2189(float var1) {
        float var2 = (float) Math.cos((double) var1);
        float var3 = (float) Math.sin((double) var1);
        float var4 = this.field3781;
        float var5 = this.field3784;
        float var6 = this.field3788;
        float var7 = this.field3790;
        this.field3781 = var4 * var2 - this.field3782 * var3;
        this.field3782 = var4 * var3 + var2 * this.field3782;
        this.field3784 = var2 * var5 - var3 * this.field3786;
        this.field3786 = var2 * this.field3786 + var3 * var5;
        this.field3788 = var2 * var6 - var3 * this.field3791;
        this.field3791 = this.field3791 * var2 + var6 * var3;
        this.field3790 = var7 * var2 - var3 * this.field3780;
        this.field3780 = var2 * this.field3780 + var3 * var7;
    }

    void method2192(float var1) {
        float var2 = (float) Math.cos((double) var1);
        float var3 = (float) Math.sin((double) var1);
        float var4 = this.field3785;
        float var5 = this.field3783;
        float var6 = this.field3787;
        float var7 = this.field3789;
        this.field3785 = this.field3782 * var3 + var4 * var2;
        this.field3782 = var2 * this.field3782 - var3 * var4;
        this.field3783 = var3 * this.field3786 + var5 * var2;
        this.field3786 = this.field3786 * var2 - var5 * var3;
        this.field3787 = var3 * this.field3791 + var6 * var2;
        this.field3791 = this.field3791 * var2 - var6 * var3;
        this.field3789 = var2 * var7 + this.field3780 * var3;
        this.field3780 = this.field3780 * var2 - var3 * var7;
    }

    void method2190(float var1) {
        float var2 = (float) Math.cos((double) var1);
        float var3 = (float) Math.sin((double) var1);
        float var4 = this.field3785;
        float var5 = this.field3783;
        float var6 = this.field3787;
        float var7 = this.field3789;
        this.field3785 = var4 * var2 - var3 * this.field3781;
        this.field3781 = var2 * this.field3781 + var4 * var3;
        this.field3783 = var5 * var2 - var3 * this.field3784;
        this.field3784 = this.field3784 * var2 + var3 * var5;
        this.field3787 = var6 * var2 - var3 * this.field3788;
        this.field3788 = var2 * this.field3788 + var3 * var6;
        this.field3789 = var2 * var7 - this.field3790 * var3;
        this.field3790 = var3 * var7 + this.field3790 * var2;
    }

    void method2191(float var1, float var2, float var3) {
        this.field3789 += var1;
        this.field3790 += var2;
        this.field3780 += var3;
    }

    public String toString() {
        return this.field3785 + "," + this.field3783 + "," + this.field3787 + "," + this.field3789 + "\n"
                + this.field3781 + "," + this.field3784 + "," + this.field3788 + "," + this.field3790 + "\n"
                + this.field3782 + "," + this.field3786 + "," + this.field3791 + "," + this.field3780;
    }
}
