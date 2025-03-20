import java.util.Comparator;

public abstract class AbstractUserComparator implements Comparator {

    Comparator nextComparator;

    final void addComparator(Comparator var1) {
        if (this.nextComparator == null) {
            this.nextComparator = var1;
        } else if (this.nextComparator instanceof AbstractUserComparator) {
            ((AbstractUserComparator) this.nextComparator).addComparator(var1);
        }

    }

    protected final int compareUser(User var1, User var2) {
        return this.nextComparator == null ? 0 : this.nextComparator.compare(var1, var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    static float method2095(float[] var0, int var1, float var2) {
        float var3 = var0[var1];

        for (int var4 = var1 - 1; var4 >= 0; --var4) {
            var3 = var3 * var2 + var0[var4];
        }

        return var3;
    }
}
