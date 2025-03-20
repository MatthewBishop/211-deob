public class UserComparator10 extends AbstractUserComparator {

    static int cameraY;

    static int oculusOrbFocalPointY;

    final boolean reversed;

    public UserComparator10(boolean var1) {
        this.reversed = var1;
    }

    int compareBuddy(Buddy var1, Buddy var2) {
        if (Client.worldId == var1.world && var2.world == Client.worldId) {
            return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
        } else {
            return this.compareUser(var1, var2);
        }
    }

    public int compare(Object var1, Object var2) {
        return this.compareBuddy((Buddy) var1, (Buddy) var2);
    }

    public static EnumComposition getEnum(int var0) {
        EnumComposition var1 = (EnumComposition) EnumComposition.EnumDefinition_cached.get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = EnumComposition.EnumDefinition_archive.takeFile(8, var0);
            var1 = new EnumComposition();
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            EnumComposition.EnumDefinition_cached.put(var1, (long) var0);
            return var1;
        }
    }
}
