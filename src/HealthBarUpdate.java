public class HealthBarUpdate extends Node {

	int cycle;

	int health;

	int health2;

	int cycleOffset;

	HealthBarUpdate(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	void set(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	static void method507(String var0, String var1, String var2) {
		ReflectionCheck.method171(7);
		class70.setLoginResponseString(var0, var1, var2);
	}
}
