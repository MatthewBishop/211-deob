import java.lang.management.GarbageCollectorMXBean;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class class14 {

    static int field48;

    public static Buffer NetCache_responseArchiveBuffer;

    static GarbageCollectorMXBean garbageCollector;

    final int field51;

    final String field45;

    final ThreadFactory field46;

    final ThreadPoolExecutor field47;

    public class14(String var1, int var2, int var3) {
        this.field45 = var1;
        this.field51 = var2;
        this.field46 = new class16(this);
        this.field47 = this.method52(var3);
    }

    final ThreadPoolExecutor method52(int var1) {
        return new ThreadPoolExecutor(var1, var1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(this.field51),
                this.field46);
    }

    public class18 method55(class10 var1) {
        if (this.field47.getQueue().remainingCapacity() <= 0) {
            System.err.println("REST thread pool queue is empty\r\nThread pool size " + this.field47.getCorePoolSize()
                    + " Queue capacity " + this.field51);
            return new class18("Queue full");
        } else {
            class18 var2 = new class18(this.field47.submit(new class19(this, var1)));
            return var2;
        }
    }

    public final void method54() {
        try {
            this.field47.shutdown();
        } catch (Exception var2) {
            System.err.println("Error shutting down RestRequestService\r\n" + var2);
        }

    }

    static final void method53(int var0, int var1, int var2, int var3) {
        for (int var4 = var1; var4 <= var3 + var1; ++var4) {
            for (int var5 = var0; var5 <= var0 + var2; ++var5) {
                if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
                    Tiles.field836[0][var5][var4] = 127;
                    if (var0 == var5 && var5 > 0) {
                        Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
                    }

                    if (var0 + var2 == var5 && var5 < 103) {
                        Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
                    }

                    if (var4 == var1 && var4 > 0) {
                        Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
                    }

                    if (var3 + var1 == var4 && var4 < 103) {
                        Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
                    }
                }
            }
        }

    }
}
