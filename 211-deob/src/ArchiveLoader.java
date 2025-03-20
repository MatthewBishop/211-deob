public class ArchiveLoader {

    final Archive archive;

    final int groupCount;

    int loadedCount = 0;

    ArchiveLoader(Archive var1, String var2) {
        this.archive = var1;
        this.groupCount = var1.getGroupCount();
    }

    boolean isLoaded() {
        this.loadedCount = 0;

        for (int var1 = 0; var1 < this.groupCount; ++var1) {
            if (!this.archive.method1800(var1) || this.archive.method1799(var1)) {
                ++this.loadedCount;
            }
        }

        return this.loadedCount >= this.groupCount;
    }

    public static PlayerType[] PlayerType_values() {
        return new PlayerType[] { PlayerType.field3415, PlayerType.field3409, PlayerType.PlayerType_jagexModerator,
                PlayerType.PlayerType_ironman, PlayerType.field3418, PlayerType.field3424,
                PlayerType.PlayerType_ultimateIronman, PlayerType.field3422, PlayerType.PlayerType_normal,
                PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_hardcoreIronman, PlayerType.field3416,
                PlayerType.field3417, PlayerType.field3420, PlayerType.field3414, PlayerType.field3430,
                PlayerType.field3419 };
    }

    static int method452(PacketBuffer var0) {
        int var1 = var0.readBits(2);
        int var2;
        if (var1 == 0) {
            var2 = 0;
        } else if (var1 == 1) {
            var2 = var0.readBits(5);
        } else if (var1 == 2) {
            var2 = var0.readBits(8);
        } else {
            var2 = var0.readBits(11);
        }

        return var2;
    }
}
