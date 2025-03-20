public class DefaultsGroup {

    static final DefaultsGroup field3749 = new DefaultsGroup(3);

    final int group;

    DefaultsGroup(int var1) {
        this.group = var1;
    }

    public static FloorUnderlayDefinition method2155(int var0) {
        FloorUnderlayDefinition var1 = (FloorUnderlayDefinition) FloorUnderlayDefinition.FloorUnderlayDefinition_cached
                .get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var0);
            var1 = new FloorUnderlayDefinition();
            if (var2 != null) {
                var1.decode(new Buffer(var2), var0);
            }

            var1.postDecode();
            FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long) var0);
            return var1;
        }
    }

    static int ItemContainer_getCount(int var0, int var1) {
        ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.get((long) var0);
        if (var2 == null) {
            return 0;
        } else {
            return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
        }
    }
}
