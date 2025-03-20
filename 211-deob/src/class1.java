import java.util.concurrent.Callable;

public class class1 implements Callable {

    static java.awt.Font fontHelvetica13;

    static int worldPort;

    final Buffer field3;

    final class3 field0;
    // $FF: synthetic field

    final class7 this$0;

    class1(class7 var1, Buffer var2, class3 var3) {
        this.this$0 = var1;
        this.field3 = var2;
        this.field0 = var3;
    }

    public Object call() {
        return this.field0.vmethod12(this.field3);
    }

    static void method2(Archive var0, int var1) {
        class10.field38.offset = var1 * 8 + 5;
        if (class10.field38.offset >= class10.field38.array.length) {
            if (var0.field3442) {
                var0.method1796();
            } else {
                throw new RuntimeException("");
            }
        } else {
            int var2 = class10.field38.readInt();
            int var3 = class10.field38.readInt();
            var0.loadIndex(var2, var3);
        }
    }
}
