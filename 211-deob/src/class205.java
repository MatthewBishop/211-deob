import java.util.Arrays;

public class class205 implements class29 {

    static IndexedSprite worldSelectRightSprite;

    char[] field1819 = new char[128];

    int[] field1820 = new int[128];

    public int[] field1821 = new int[128];

    public int pressedKeysCount = 0;

    int[] field1830 = new int[128];

    int field1822 = 0;

    int field1825 = 0;

    int field1824 = 0;

    int field1827 = 0;

    boolean[] field1831 = new boolean[112];

    boolean[] field1829 = new boolean[112];

    boolean[] field1823 = new boolean[112];

    public char field1826;

    public int field1832;

    public boolean vmethod3949(int var1) {
        this.method1082(var1);
        this.field1831[var1] = true;
        this.field1829[var1] = true;
        this.field1823[var1] = false;
        this.field1821[++this.pressedKeysCount - 1] = var1;
        return true;
    }

    public boolean vmethod3989(int var1) {
        this.field1831[var1] = false;
        this.field1829[var1] = false;
        this.field1823[var1] = true;
        this.field1830[++this.field1822 - 1] = var1;
        return true;
    }

    public boolean vmethod3951(char var1) {
        int var2 = this.field1824 + 1 & 127;
        if (var2 != this.field1825) {
            this.field1820[this.field1824] = -1;
            this.field1819[this.field1824] = var1;
            this.field1824 = var2;
        }

        return false;
    }

    public boolean vmethod3953(boolean var1) {
        return false;
    }

    void method1082(int var1) {
        int var2 = this.field1824 + 1 & 127;
        if (var2 != this.field1825) {
            this.field1820[this.field1824] = var1;
            this.field1819[this.field1824] = 0;
            this.field1824 = var2;
        }

    }

    public void method1084() {
        this.field1825 = this.field1827;
        this.field1827 = this.field1824;
        this.pressedKeysCount = 0;
        this.field1822 = 0;
        Arrays.fill(this.field1829, false);
        Arrays.fill(this.field1823, false);
    }

    public final boolean method1085() {
        if (this.field1827 == this.field1825) {
            return false;
        } else {
            this.field1832 = this.field1820[this.field1825];
            this.field1826 = this.field1819[this.field1825];
            this.field1825 = this.field1825 + 1 & 127;
            return true;
        }
    }

    public boolean method1086(int var1) {
        return var1 >= 0 && var1 < 112 ? this.field1829[var1] : false;
    }

    public boolean getKeyPressed(int var1) {
        return var1 >= 0 && var1 < 112 ? this.field1831[var1] : false;
    }

    public boolean method1089(int var1) {
        return var1 >= 0 && var1 < 112 ? this.field1823[var1] : false;
    }

    public int[] method1090() {
        int[] var1 = new int[this.pressedKeysCount];

        for (int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
            var1[var2] = this.field1821[var2];
        }

        return var1;
    }

    public int[] method1088() {
        int[] var1 = new int[this.field1822];

        for (int var2 = 0; var2 < this.field1822; ++var2) {
            var1[var2] = this.field1830[var2];
        }

        return var1;
    }

    static void resumePauseWidget(int var0, int var1) {
        PacketBufferNode var2 = Renderable.getPacketBufferNode(ClientPacket.field2523, Client.packetWriter.isaacCipher);
        var2.packetBuffer.writeShort(var1);
        var2.packetBuffer.writeInt(var0);
        Client.packetWriter.addNode(var2);
    }
}
