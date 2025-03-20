public class class288 {

    static int[] field2689;

    static int field2691;

    static PrivateChatMode privateChatMode;

    static {
        new Object();
        field2689 = new int[33];
        field2689[0] = 0;
        int var0 = 2;

        for (int var1 = 1; var1 < 33; ++var1) {
            field2689[var1] = var0 - 1;
            var0 += var0;
        }

    }

    static void method1550() {
        Object var0 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
        synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
            if (ArchiveDiskActionHandler.field3437 == 0) {
                ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
                ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setDaemon(true);
                ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.start();
                ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setPriority(5);
            }

            ArchiveDiskActionHandler.field3437 = 600;
        }
    }

    public static boolean method1551(int var0) {
        return (var0 >> 31 & 1) != 0;
    }
}
