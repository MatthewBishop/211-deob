public class class147 extends class155 {

    static IndexedSprite titleboxSprite;

    static GameBuild field1330;

    int field1329;
    // $FF: synthetic field

    final class156 this$0;

    class147(class156 var1) {
        this.this$0 = var1;
        this.field1329 = -1;
    }

    void vmethod3238(Buffer var1) {
        this.field1329 = var1.readUnsignedShort();
        var1.readUnsignedByte();
        if (var1.readUnsignedByte() != 255) {
            --var1.offset;
            var1.readLong();
        }

    }

    void vmethod3239(ClanChannel var1) {
        var1.removeMember(this.field1329);
    }

    public static int method781(int var0, int var1, int var2) {
        var2 &= 3;
        if (var2 == 0) {
            return var1;
        } else if (var2 == 1) {
            return 7 - var0;
        } else {
            return var2 == 2 ? 7 - var1 : var0;
        }
    }

    static final void runIntfCloseListeners(int var0, int var1) {
        if (class153.loadInterface(var0)) {
            class135.runComponentCloseListeners(WorldMapLabel.Widget_interfaceComponents[var0], var1);
        }
    }
}
