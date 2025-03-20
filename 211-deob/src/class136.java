public class class136 extends class139 {

    public static class347 field1293;

    int field1295;

    int field1292;

    int field1291;

    int field1294;
    // $FF: synthetic field

    final class142 this$0;

    class136(class142 var1) {
        this.this$0 = var1;
        this.field1295 = -1;
    }

    void vmethod3254(Buffer var1) {
        this.field1295 = var1.readUnsignedShort();
        this.field1292 = var1.readInt();
        this.field1291 = var1.readUnsignedByte();
        this.field1294 = var1.readUnsignedByte();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method802(this.field1295, this.field1292, this.field1291, this.field1294);
    }
}
