public class Bounds {

    public int lowX;

    public int lowY;

    public int highX;

    public int highY;

    public Bounds(int var1, int var2, int var3, int var4) {
        this.setLow(var1, var2);
        this.setHigh(var3, var4);
    }

    public Bounds(int var1, int var2) {
        this(0, 0, var1, var2);
    }

    public void setLow(int var1, int var2) {
        this.lowX = var1;
        this.lowY = var2;
    }

    public void setHigh(int var1, int var2) {
        this.highX = var1;
        this.highY = var2;
    }

    public boolean method2160(int var1, int var2) {
        return var1 >= this.lowX && var1 < this.lowX + this.highX && var2 >= this.lowY && var2 < this.highY + this.lowY;
    }

    public void method2161(Bounds var1, Bounds var2) {
        this.method2164(var1, var2);
        this.method2165(var1, var2);
    }

    void method2164(Bounds var1, Bounds var2) {
        var2.lowX = this.lowX;
        var2.highX = this.highX;
        if (this.lowX < var1.lowX) {
            var2.highX = (var2.highX * 1795339931 - (var1.lowX * 1795339931 - this.lowX * 1795339931)) * -820822125;
            var2.lowX = var1.lowX;
        }

        if (var2.method2162() > var1.method2162()) {
            var2.highX -= var2.method2162() - var1.method2162();
        }

        if (var2.highX < 0) {
            var2.highX = 0;
        }

    }

    void method2165(Bounds var1, Bounds var2) {
        var2.lowY = this.lowY;
        var2.highY = this.highY;
        if (this.lowY < var1.lowY) {
            var2.highY = (var2.highY * -168455399 - (var1.lowY * -168455399 - this.lowY * -168455399)) * 1249777961;
            var2.lowY = var1.lowY;
        }

        if (var2.method2163() > var1.method2163()) {
            var2.highY -= var2.method2163() - var1.method2163();
        }

        if (var2.highY < 0) {
            var2.highY = 0;
        }

    }

    int method2162() {
        return this.highX + this.lowX;
    }

    int method2163() {
        return this.highY + this.lowY;
    }

    public String toString() {
        return null;
    }
}
