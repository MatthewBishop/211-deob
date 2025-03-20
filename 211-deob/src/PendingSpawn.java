import java.io.File;

public final class PendingSpawn extends Node {

    static Archive archive13;

    int plane;

    int type;

    int x;

    int y;

    int objectId;

    int field926;

    int field927;

    int id;

    int rotation;

    int objectType;

    int field931 = 31;

    int startCycle = 0;

    int endCycle = -1;

    void method496(int var1) {
        this.field931 = var1;
    }

    boolean method497(int var1) {
        if (var1 >= 0 && var1 <= 4) {
            return (this.field931 & 1 << var1) != 0;
        } else {
            return true;
        }
    }

    public static void method499(File var0) {
        FileSystem.FileSystem_cacheDir = var0;
        if (!FileSystem.FileSystem_cacheDir.exists()) {
            throw new RuntimeException("");
        } else {
            FileSystem.FileSystem_hasPermissions = true;
        }
    }

    static void performPlayerAnimation(Player var0, int var1, int var2) {
        if (var0.sequence == var1 && var1 != -1) {
            int var3 = class85.SequenceDefinition_get(var1).replyMode;
            if (var3 == 1) {
                var0.sequenceFrame = 0;
                var0.sequenceFrameCycle = 0;
                var0.sequenceDelay = var2;
                var0.currentSequenceFrameIndex = 0;
            }

            if (var3 == 2) {
                var0.currentSequenceFrameIndex = 0;
            }
        } else if (var1 == -1 || var0.sequence == -1 || class85.SequenceDefinition_get(var1).forcedPriority >= class85
                .SequenceDefinition_get(var0.sequence).forcedPriority) {
            var0.sequence = var1;
            var0.sequenceFrame = 0;
            var0.sequenceFrameCycle = 0;
            var0.sequenceDelay = var2;
            var0.currentSequenceFrameIndex = 0;
            var0.field1006 = var0.pathLength;
        }

    }
}
