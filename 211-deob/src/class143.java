import java.security.SecureRandom;

public class class143 extends class139 {

    static int loginBoxCenter;

    int field1310;

    byte field1312;
    // $FF: synthetic field

    final class142 this$0;

    class143(class142 var1) {
        this.this$0 = var1;
        this.field1310 = -1;
    }

    void vmethod3254(Buffer var1) {
        this.field1310 = var1.readUnsignedShort();
        this.field1312 = var1.readByte();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method804(this.field1310, this.field1312);
    }

    static SecureRandom method764() {
        SecureRandom var0 = new SecureRandom();
        var0.nextInt();
        return var0;
    }
}
