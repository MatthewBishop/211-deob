public class class447 {

    public final Object field3927;

    public final Object field3928;

    public class447(Object var1, Object var2) {
        this.field3927 = var1;
        this.field3928 = var2;
    }

    public boolean equals(Object var1) {
        if (var1 != null && var1 instanceof class447) {
            class447 var2 = (class447) var1;
            if (this.field3927 == null) {
                if (var2.field3927 != null) {
                    return false;
                }
            } else if (!this.field3927.equals(var2.field3927)) {
                return false;
            }

            if (this.field3928 == null) {
                if (var2.field3928 != null) {
                    return false;
                }
            } else if (!this.field3928.equals(var2.field3928)) {
                return false;
            }

            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.field3927 + ", " + this.field3928;
    }

    public int hashCode() {
        int var1 = 0;
        if (this.field3927 != null) {
            var1 += this.field3927.hashCode();
        }

        if (this.field3928 != null) {
            var1 += 31 * this.field3928.hashCode();
        }

        return var1;
    }
}
