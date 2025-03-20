public class class148 extends class139 {

    static int field1332;

    static Archive field1333;

    static MenuAction tempMenuAction;

    String field1334;
    // $FF: synthetic field

    final class142 this$0;

    class148(class142 var1) {
        this.this$0 = var1;
    }

    void vmethod3254(Buffer var1) {
        this.field1334 = var1.readStringCp1252NullTerminated();
        var1.readInt();
    }

    void vmethod3248(ClanSettings var1) {
        var1.name = this.field1334;
    }

    public static void method784(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
        class290.musicPlayerStatus = 1;
        class6.musicTrackArchive = var0;
        class20.musicTrackGroupId = var1;
        class161.musicTrackFileId = var2;
        class290.musicTrackVolume = var3;
        class423.musicTrackBoolean = var4;
        class203.pcmSampleLength = 10000;
    }
}
