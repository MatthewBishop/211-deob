import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SecureRandomFuture {

    static String[] Interpreter_stringLocals;

    ExecutorService executor = Executors.newSingleThreadExecutor();

    Future future;

    SecureRandomFuture() {
        this.future = this.executor.submit(new SecureRandomCallable());
    }

    void shutdown() {
        this.executor.shutdown();
        this.executor = null;
    }

    boolean isDone() {
        return this.future.isDone();
    }

    SecureRandom get() {
        try {
            return (SecureRandom) this.future.get();
        } catch (Exception var2) {
            return class143.method764();
        }
    }

    public static int getVarbit(int var0) {
        VarbitComposition var1 = VarpDefinition.method919(var0);
        int var2 = var1.baseVar;
        int var3 = var1.startBit;
        int var4 = var1.endBit;
        int var5 = Varps.Varps_masks[var4 - var3];
        return Varps.Varps_main[var2] >> var3 & var5;
    }
}
