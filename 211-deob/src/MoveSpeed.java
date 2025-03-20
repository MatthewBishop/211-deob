public enum MoveSpeed implements class349 {

    STATIONARY((byte) -1),

    CRAWL((byte) 0),

    WALK((byte) 1),

    RUN((byte) 2);

    static class458 HitSplatDefinition_cached;

    public byte speed;

    MoveSpeed(byte var3) {
        this.speed = var3;
    }

    public int rsOrdinal() {
        return this.speed;
    }

    public static int method1110(int var0, int var1) {
        return (-3 - var0 << 8) + var1;
    }
}
