public class Timer {

    long field3650 = -1L;

    long field3649 = -1L;

    public boolean field3655 = false;

    long field3651 = 0L;

    long field3657 = 0L;

    long field3653 = 0L;

    int field3654 = 0;

    int field3648 = 0;

    int field3656 = 0;

    int field3652 = 0;

    public void method2023() {
        this.field3650 = class153.clockNow();
    }

    public void method2021() {
        if (-1L != this.field3650) {
            this.field3657 = class153.clockNow() - this.field3650;
            this.field3650 = -1L;
        }

    }

    public void method2026(int var1) {
        this.field3649 = class153.clockNow();
        this.field3654 = var1;
    }

    public void method2022() {
        if (this.field3649 != -1L) {
            this.field3651 = class153.clockNow() - this.field3649;
            this.field3649 = -1L;
        }

        ++this.field3656;
        this.field3655 = true;
    }

    public void method2025() {
        this.field3655 = false;
        this.field3648 = 0;
    }

    public void method2024() {
        this.method2022();
    }

    public void write(Buffer var1) {
        ServerPacket.method1539(var1, this.field3657);
        ServerPacket.method1539(var1, this.field3651);
        ServerPacket.method1539(var1, this.field3653);
        var1.writeShort(this.field3654);
        var1.writeShort(this.field3648);
        var1.writeShort(this.field3656);
        var1.writeShort(this.field3652);
    }

    static void method2027() {
        Tiles.Tiles_underlays = null;
        class172.Tiles_overlays = null;
        Tiles.Tiles_shapes = null;
        Tiles.field835 = null;
        class312.field3014 = null;
        Tiles.field836 = null;
        class323.field3055 = null;
        class100.Tiles_hue = null;
        class161.Tiles_saturation = null;
        Tiles.Tiles_lightness = null;
        class463.Tiles_hueMultiplier = null;
        SceneTilePaint.field2195 = null;
    }
}
