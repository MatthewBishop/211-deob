public class class415 {

	float field3768;

	float field3767;

	float field3766;

	static {
		new class415(0.0F, 0.0F, 0.0F);
		new class415(1.0F, 1.0F, 1.0F);
		new class415(1.0F, 0.0F, 0.0F);
		new class415(0.0F, 1.0F, 0.0F);
		new class415(0.0F, 0.0F, 1.0F);
	}

	class415(float var1, float var2, float var3) {
		this.field3768 = var1;
		this.field3767 = var2;
		this.field3766 = var3;
	}

	final float method2166() {
		return (float) Math.sqrt((double) (this.field3766 * this.field3766 + this.field3767 * this.field3767
				+ this.field3768 * this.field3768));
	}

	public String toString() {
		return this.field3768 + ", " + this.field3767 + ", " + this.field3766;
	}
}
