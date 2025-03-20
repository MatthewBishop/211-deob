import java.util.zip.CRC32;

public class NetCache {

    public static AbstractSocket NetCache_socket;

    public static int NetCache_loadTime = 0;

    public static long field3486;

    public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);

    public static int NetCache_pendingPriorityWritesCount = 0;

    public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);

    public static int NetCache_pendingPriorityResponsesCount = 0;

    public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();

    public static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);

    public static int NetCache_pendingWritesCount = 0;

    public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);

    public static int NetCache_pendingResponsesCount = 0;

    public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);

    public static int field3484 = 0;

    static CRC32 NetCache_crc = new CRC32();

    static Archive[] NetCache_archives = new Archive[256];

    static int field3487 = -1;

    static int field3488 = 255;

    public static byte field3482 = 0;

    public static int NetCache_crcMismatches = 0;

    public static int NetCache_ioExceptions = 0;

    static Archive archive9;

    static String worldHost;

    public static byte[] method1839(CharSequence var0) {
        int var1 = var0.length();
        byte[] var2 = new byte[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            char var4 = var0.charAt(var3);
            if (var4 > 127) {
                var2[var3] = 63;
            } else {
                var2[var3] = (byte) var4;
            }
        }

        return var2;
    }
}
