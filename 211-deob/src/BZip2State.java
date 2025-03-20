public final class BZip2State {

    final int field4012 = 4096;

    final int field4010 = 16;

    final int field4011 = 258;

    final int field4040 = 6;

    final int field4013 = 50;

    final int field4031 = 18002;

    byte[] inputArray;

    int nextByte = 0;

    int nextBit_unused;

    byte[] outputArray;

    int next_out = 0;

    int outputLength;

    int field4021;

    byte out_char;

    int su_rNToGo;

    int bsBuff;

    int bsLive;

    int blockSize100k;

    int originalPointer;

    int field4028;

    int su_ch2;

    int[] unzftab = new int[256];

    int nblocks_used;

    int[] cftab = new int[257];

    int nInUse;

    boolean[] inUse = new boolean[256];

    boolean[] inUse16 = new boolean[16];

    byte[] seqToUnseq = new byte[256];

    byte[] ll8 = new byte[4096];

    int[] getAndMoveToFrontDecode_yy = new int[16];

    byte[] selector = new byte[18002];

    byte[] selectorMtf = new byte[18002];

    byte[][] temp_charArray2d = new byte[6][258];

    int[][] limit = new int[6][258];

    int[][] base = new int[6][258];

    int[][] perm = new int[6][258];

    int[] minLens = new int[6];

    int field4046;

    public static SpritePixels SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
        if (!Buffer.method2444(var0, var1, var2)) {
            return null;
        } else {
            SpritePixels var4 = new SpritePixels();
            var4.width = class488.SpriteBuffer_spriteWidth;
            var4.height = class488.SpriteBuffer_spriteHeight;
            var4.xOffset = class488.SpriteBuffer_xOffsets[0];
            var4.yOffset = ApproximateRouteStrategy.SpriteBuffer_yOffsets[0];
            var4.subWidth = FriendsList.SpriteBuffer_spriteWidths[0];
            var4.subHeight = class132.SpriteBuffer_spriteHeights[0];
            int var5 = var4.subWidth * var4.subHeight;
            byte[] var6 = class140.SpriteBuffer_pixels[0];
            var4.pixels = new int[var5];

            for (int var7 = 0; var7 < var5; ++var7) {
                var4.pixels[var7] = class100.SpriteBuffer_spritePalette[var6[var7] & 255];
            }

            class100.method595();
            return var4;
        }
    }
}
