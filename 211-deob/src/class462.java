final class class462 implements class459 {

    public void vmethod8274(Object var1, Buffer var2) {
        this.method2334((Long) var1, var2);
    }

    public Object vmethod8273(Buffer var1) {
        return var1.readLong();
    }

    void method2334(Long var1, Buffer var2) {
        var2.writeLong(var1);
    }
}
