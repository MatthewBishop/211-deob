import java.io.IOException;
import java.util.concurrent.Callable;

public class class19 implements Callable {

    static IndexedSprite field64;

    static Font fontBold12;

    final class10 field65;
    // $FF: synthetic field

    final class14 this$0;

    class19(class14 var1, class10 var2) {
        this.this$0 = var1;
        this.field65 = var2;
    }

    public Object call() throws Exception {
        try {
            while (this.field65.method42()) {
                Clock.method911(10L);
            }
        } catch (IOException var2) {
            return new class20("Error servicing REST query: " + var2.getMessage());
        }

        return this.field65.method40();
    }
}
