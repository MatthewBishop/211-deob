public class class144 extends class139 {

    static Archive archive4;

    int field1317;

    int field1313;

    int field1315;

    int field1316;
    // $FF: synthetic field

    final class142 this$0;

    class144(class142 var1) {
        this.this$0 = var1;
    }

    void vmethod3254(Buffer var1) {
        this.field1317 = var1.readInt();
        this.field1316 = var1.readInt();
        this.field1313 = var1.readUnsignedByte();
        this.field1315 = var1.readUnsignedByte();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method799(this.field1317, this.field1316, this.field1313, this.field1315);
    }

    static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (class153.loadInterface(var0)) {
            class85.updateInterface(WorldMapLabel.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5,
                    var6);
        }
    }
}
