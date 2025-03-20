import java.util.Iterator;

public class class458 extends class422 implements class268 {

    final AbstractArchive field3974;

    final DemotingHashTable field3975 = new DemotingHashTable(64);

    final int field3973;

    public class458(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
        super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
        this.field3974 = var4;
        this.field3973 = var2;
    }

    protected class424 vmethod8207(int var1) {
        DemotingHashTable var3 = this.field3975;
        synchronized (this.field3975) {
            class423 var2 = (class423) this.field3975.get((long) var1);
            if (var2 == null) {
                var2 = this.method2327(var1);
                this.field3975.method1512(var2, (long) var1);
            }

            return var2;
        }
    }

    class423 method2327(int var1) {
        byte[] var2 = this.field3974.takeFile(this.field3973, var1);
        class423 var3 = new class423(var1);
        if (var2 != null) {
            var3.method2200(new Buffer(var2));
        }

        return var3;
    }

    public void method2326() {
        DemotingHashTable var1 = this.field3975;
        synchronized (this.field3975) {
            this.field3975.clear();
        }
    }

    public Iterator iterator() {
        return new class457(this);
    }
}
