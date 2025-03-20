public final class class392 implements Comparable {

    Object field3682;

    Object field3680;

    long field3681;

    long field3679;

    class392(Object var1, Object var2) {
        this.field3682 = var1;
        this.field3680 = var2;
    }

    int method2056(class392 var1) {
        if (this.field3679 < var1.field3679) {
            return -1;
        } else {
            return this.field3679 > var1.field3679 ? 1 : 0;
        }
    }

    public int compareTo(Object var1) {
        return this.method2056((class392) var1);
    }

    public int hashCode() {
        return this.field3680.hashCode();
    }

    public boolean equals(Object var1) {
        if (var1 instanceof class392) {
            return this.field3680.equals(((class392) var1).field3680);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
