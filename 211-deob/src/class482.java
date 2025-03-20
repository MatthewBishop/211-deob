public class class482 {

    static ClanChannel guestClanChannel;

    public final int field4059;

    public Object field4060;

    public class482(int var1) {
        this.field4059 = var1;
    }

    public class482(int var1, Object var2) {
        this.field4059 = var1;
        this.field4060 = var2;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class482)) {
            return false;
        } else {
            class482 var2 = (class482) var1;
            if (var2.field4060 == null && this.field4060 != null) {
                return false;
            } else if (this.field4060 == null && var2.field4060 != null) {
                return false;
            } else {
                return this.field4059 == var2.field4059 && var2.field4060.equals(this.field4060);
            }
        }
    }
}
