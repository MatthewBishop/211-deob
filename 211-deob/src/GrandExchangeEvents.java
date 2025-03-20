import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrandExchangeEvents {

    public static Comparator GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();

    public static Comparator GrandExchangeEvents_priceComparator;

    public static Comparator GrandExchangeEvents_nameComparator;

    public static Comparator GrandExchangeEvents_quantityComparator;

    public final List events;

    static {
        new GrandExchangeOfferWorldComparator();
        GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
        GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
        GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
    }

    public GrandExchangeEvents(Buffer var1, boolean var2) {
        int var3 = var1.readUnsignedShort();
        boolean var4 = var1.readUnsignedByte() == 1;
        byte var5;
        if (var4) {
            var5 = 1;
        } else {
            var5 = 0;
        }

        int var6 = var1.readUnsignedShort();
        this.events = new ArrayList(var6);

        for (int var7 = 0; var7 < var6; ++var7) {
            this.events.add(new GrandExchangeEvent(var1, var5, var3));
        }

    }

    public void sort(Comparator var1, boolean var2) {
        if (var2) {
            Collections.sort(this.events, var1);
        } else {
            Collections.sort(this.events, Collections.reverseOrder(var1));
        }

    }

    static void method1840(int var0) {
        for (IntegerNode var1 = (IntegerNode) Client.widgetFlags
                .first(); var1 != null; var1 = (IntegerNode) Client.widgetFlags.next()) {
            if ((var1.key >> 48 & 65535L) == (long) var0) {
                var1.remove();
            }
        }

    }
}
