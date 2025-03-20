import java.math.BigInteger;

public class Buffer extends Node {

    static int[] crc32Table = new int[256];

    static long[] crc64Table;

    public byte[] array;

    public int offset;

    static {
        int var2;
        for (int var1 = 0; var1 < 256; ++var1) {
            int var0 = var1;

            for (var2 = 0; var2 < 8; ++var2) {
                if ((var0 & 1) == 1) {
                    var0 = var0 >>> 1 ^ -306674912;
                } else {
                    var0 >>>= 1;
                }
            }

            crc32Table[var1] = var0;
        }

        crc64Table = new long[256];

        for (var2 = 0; var2 < 256; ++var2) {
            long var4 = (long) var2;

            for (int var3 = 0; var3 < 8; ++var3) {
                if (1L == (var4 & 1L)) {
                    var4 = var4 >>> 1 ^ -3932672073523589310L;
                } else {
                    var4 >>>= 1;
                }
            }

            crc64Table[var2] = var4;
        }

    }

    public Buffer(int var1, boolean var2) {
        this.array = ByteArrayPool.ByteArrayPool_getArrayBool(var1, var2);
    }

    public Buffer(int var1) {
        this.array = ClientPacket.ByteArrayPool_getArray(var1);
        this.offset = 0;
    }

    public Buffer(byte[] var1) {
        this.array = var1;
        this.offset = 0;
    }

    public void releaseArray() {
        if (this.array != null) {
            class277.ByteArrayPool_release(this.array);
        }

        this.array = null;
    }

    public void writeByte(int var1) {
        this.array[++this.offset - 1] = (byte) var1;
    }

    public void writeShort(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
        this.array[++this.offset - 1] = (byte) var1;
    }

    public void writeMedium(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 >> 16);
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
        this.array[++this.offset - 1] = (byte) var1;
    }

    public void writeInt(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 >> 24);
        this.array[++this.offset - 1] = (byte) (var1 >> 16);
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
        this.array[++this.offset - 1] = (byte) var1;
    }

    public void writeLongMedium(long var1) {
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 40));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 32));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 24));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 16));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 8));
        this.array[++this.offset - 1] = (byte) ((int) var1);
    }

    public void writeLong(long var1) {
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 56));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 48));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 40));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 32));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 24));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 16));
        this.array[++this.offset - 1] = (byte) ((int) (var1 >> 8));
        this.array[++this.offset - 1] = (byte) ((int) var1);
    }

    public void writeBoolean(boolean var1) {
        this.writeByte(var1 ? 1 : 0);
    }

    public void writeStringCp1252NullTerminated(String var1) {
        int var2 = var1.indexOf(0);
        if (var2 >= 0) {
            throw new IllegalArgumentException("");
        } else {
            this.offset += class285.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
            this.array[++this.offset - 1] = 0;
        }
    }

    public void writeStringCp1252NullCircumfixed(String var1) {
        int var2 = var1.indexOf(0);
        if (var2 >= 0) {
            throw new IllegalArgumentException("");
        } else {
            this.array[++this.offset - 1] = 0;
            this.offset += class285.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
            this.array[++this.offset - 1] = 0;
        }
    }

    public void writeCESU8(CharSequence var1) {
        int var2 = PcmPlayer.method216(var1);
        this.array[++this.offset - 1] = 0;
        this.writeVarInt(var2);
        int var3 = this.offset * 1441360663;
        byte[] var5 = this.array;
        int var6 = this.offset;
        int var7 = var1.length();
        int var8 = var6;

        for (int var9 = 0; var9 < var7; ++var9) {
            char var10 = var1.charAt(var9);
            if (var10 <= 127) {
                var5[var8++] = (byte) var10;
            } else if (var10 <= 2047) {
                var5[var8++] = (byte) (192 | var10 >> 6);
                var5[var8++] = (byte) (128 | var10 & 63);
            } else {
                var5[var8++] = (byte) (224 | var10 >> 12);
                var5[var8++] = (byte) (128 | var10 >> 6 & 63);
                var5[var8++] = (byte) (128 | var10 & 63);
            }
        }

        int var4 = var8 - var6;
        this.offset = (var3 + var4 * 1441360663) * -612074329;
    }

    public void writeBytes(byte[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3 + var2; ++var4) {
            this.array[++this.offset - 1] = var1[var4];
        }

    }

    public void method2443(Buffer var1) {
        this.writeBytes(var1.array, 0, var1.offset);
    }

    public void writeLengthInt(int var1) {
        if (var1 < 0) {
            throw new IllegalArgumentException();
        } else {
            this.array[this.offset - var1 - 4] = (byte) (var1 >> 24);
            this.array[this.offset - var1 - 3] = (byte) (var1 >> 16);
            this.array[this.offset - var1 - 2] = (byte) (var1 >> 8);
            this.array[this.offset - var1 - 1] = (byte) var1;
        }
    }

    public void writeLengthShort(int var1) {
        if (var1 >= 0 && var1 <= 65535) {
            this.array[this.offset - var1 - 2] = (byte) (var1 >> 8);
            this.array[this.offset - var1 - 1] = (byte) var1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void method2434(int var1) {
        if (var1 >= 0 && var1 <= 255) {
            this.array[this.offset - var1 - 1] = (byte) var1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void writeSmartByteShort(int var1) {
        if (var1 >= 0 && var1 < 128) {
            this.writeByte(var1);
        } else if (var1 >= 0 && var1 < 32768) {
            this.writeShort(var1 + '耀');
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void writeVarInt(int var1) {
        if ((var1 & -128) != 0) {
            if ((var1 & -16384) != 0) {
                if ((var1 & -2097152) != 0) {
                    if ((var1 & -268435456) != 0) {
                        this.writeByte(var1 >>> 28 | 128);
                    }

                    this.writeByte(var1 >>> 21 | 128);
                }

                this.writeByte(var1 >>> 14 | 128);
            }

            this.writeByte(var1 >>> 7 | 128);
        }

        this.writeByte(var1 & 127);
    }

    public int readUnsignedByte() {
        return this.array[++this.offset - 1] & 255;
    }

    public byte readByte() {
        return this.array[++this.offset - 1];
    }

    public int readUnsignedShort() {
        this.offset += 2;
        return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
    }

    public int readShort() {
        this.offset += 2;
        int var1 = (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    public int readMedium() {
        this.offset += 3;
        return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255)
                + ((this.array[this.offset - 2] & 255) << 8);
    }

    public int readInt() {
        this.offset += 4;
        return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255)
                + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 24);
    }

    public long readLong() {
        long var1 = (long) this.readInt() & 4294967295L;
        long var3 = (long) this.readInt() & 4294967295L;
        return var3 + (var1 << 32);
    }

    public float method2428() {
        return Float.intBitsToFloat(this.readInt());
    }

    public boolean readBoolean() {
        return (this.readUnsignedByte() & 1) == 1;
    }

    public String readStringCp1252NullTerminatedOrNull() {
        if (this.array[this.offset] == 0) {
            ++this.offset;
            return null;
        } else {
            return this.readStringCp1252NullTerminated();
        }
    }

    public String readStringCp1252NullTerminated() {
        int var1 = this.offset;

        while (this.array[++this.offset - 1] != 0) {
            ;
        }

        int var2 = this.offset - var1 - 1;
        return var2 == 0 ? "" : class101.decodeStringCp1252(this.array, var1, var2);
    }

    public String readStringCp1252NullCircumfixed() {
        byte var1 = this.array[++this.offset - 1];
        if (var1 != 0) {
            throw new IllegalStateException("");
        } else {
            int var2 = this.offset;

            while (this.array[++this.offset - 1] != 0) {
                ;
            }

            int var3 = this.offset - var2 - 1;
            return var3 == 0 ? "" : class101.decodeStringCp1252(this.array, var2, var3);
        }
    }

    public String readCESU8() {
        byte var1 = this.array[++this.offset - 1];
        if (var1 != 0) {
            throw new IllegalStateException("");
        } else {
            int var2 = this.readVarInt();
            if (var2 + this.offset > this.array.length) {
                throw new IllegalStateException("");
            } else {
                String var3 = class285.method1547(this.array, this.offset, var2);
                this.offset += var2;
                return var3;
            }
        }
    }

    public void readBytes(byte[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3 + var2; ++var4) {
            var1[var4] = this.array[++this.offset - 1];
        }

    }

    public int readShortSmart() {
        int var1 = this.array[this.offset] & 255;
        return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - '쀀';
    }

    public int readUShortSmart() {
        int var1 = this.array[this.offset] & 255;
        return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - '耀';
    }

    public int method2389() {
        int var1 = this.array[this.offset] & 255;
        return var1 < 128 ? this.readUnsignedByte() - 1 : this.readUnsignedShort() - '老';
    }

    public int method2433() {
        int var1 = 0;

        int var2;
        for (var2 = this.readUShortSmart(); var2 == 32767; var2 = this.readUShortSmart()) {
            var1 += 32767;
        }

        var1 += var2;
        return var1;
    }

    public int method2391() {
        return this.array[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort();
    }

    public int method2419() {
        if (this.array[this.offset] < 0) {
            return this.readInt() & Integer.MAX_VALUE;
        } else {
            int var1 = this.readUnsignedShort();
            return var1 == 32767 ? -1 : var1;
        }
    }

    public int readVarInt() {
        byte var1 = this.array[++this.offset - 1];

        int var2;
        for (var2 = 0; var1 < 0; var1 = this.array[++this.offset - 1]) {
            var2 = (var2 | var1 & 127) << 7;
        }

        return var2 | var1;
    }

    public int method2394() {
        int var2 = 0;
        int var3 = 0;

        int var1;
        do {
            var1 = this.readUnsignedByte();
            var2 |= (var1 & 127) << var3;
            var3 += 7;
        } while (var1 > 127);

        return var2;
    }

    public void xteaEncryptAll(int[] var1) {
        int var2 = this.offset / 8;
        this.offset = 0;

        for (int var3 = 0; var3 < var2; ++var3) {
            int var4 = this.readInt();
            int var5 = this.readInt();
            int var6 = 0;
            int var7 = -1640531527;

            for (int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
                var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
                var6 += var7;
            }

            this.offset -= 8;
            this.writeInt(var4);
            this.writeInt(var5);
        }

    }

    public void xteaDecryptAll(int[] var1) {
        int var2 = this.offset / 8;
        this.offset = 0;

        for (int var3 = 0; var3 < var2; ++var3) {
            int var4 = this.readInt();
            int var5 = this.readInt();
            int var6 = -957401312;
            int var7 = -1640531527;

            for (int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
                var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
                var6 -= var7;
            }

            this.offset -= 8;
            this.writeInt(var4);
            this.writeInt(var5);
        }

    }

    public void xteaEncrypt(int[] var1, int var2, int var3) {
        int var4 = this.offset;
        this.offset = var2;
        int var5 = (var3 - var2) / 8;

        for (int var6 = 0; var6 < var5; ++var6) {
            int var7 = this.readInt();
            int var8 = this.readInt();
            int var9 = 0;
            int var10 = -1640531527;

            for (int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
                var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
                var9 += var10;
            }

            this.offset -= 8;
            this.writeInt(var7);
            this.writeInt(var8);
        }

        this.offset = var4;
    }

    public void xteaDecrypt(int[] var1, int var2, int var3) {
        int var4 = this.offset;
        this.offset = var2;
        int var5 = (var3 - var2) / 8;

        for (int var6 = 0; var6 < var5; ++var6) {
            int var7 = this.readInt();
            int var8 = this.readInt();
            int var9 = -957401312;
            int var10 = -1640531527;

            for (int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
                var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
                var9 -= var10;
            }

            this.offset -= 8;
            this.writeInt(var7);
            this.writeInt(var8);
        }

        this.offset = var4;
    }

    public void encryptRsa(BigInteger var1, BigInteger var2) {
        int var3 = this.offset;
        this.offset = 0;
        byte[] var4 = new byte[var3];
        this.readBytes(var4, 0, var3);
        BigInteger var5 = new BigInteger(var4);
        BigInteger var6 = var5.modPow(var1, var2);
        byte[] var7 = var6.toByteArray();
        this.offset = 0;
        this.writeShort(var7.length);
        this.writeBytes(var7, 0, var7.length);
    }

    public int writeCrc(int var1) {
        int var2 = IgnoreList.method2060(this.array, var1, this.offset);
        this.writeInt(var2);
        return var2;
    }

    public boolean checkCrc() {
        this.offset -= 4;
        int var1 = IgnoreList.method2060(this.array, 0, this.offset);
        int var2 = this.readInt();
        return var1 == var2;
    }

    public void method2399(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 + 128);
    }

    public void writeByteS(int var1) {
        this.array[++this.offset - 1] = (byte) (0 - var1);
    }

    public void writeByteA(int var1) {
        this.array[++this.offset - 1] = (byte) (128 - var1);
    }

    public int method2401() {
        return this.array[++this.offset - 1] - 128 & 255;
    }

    public int readUnsignedShortA() {
        return 0 - this.array[++this.offset - 1] & 255;
    }

    public int readUnsignedByteA() {
        return 128 - this.array[++this.offset - 1] & 255;
    }

    public byte method2404() {
        return (byte) (this.array[++this.offset - 1] - 128);
    }

    public byte method2431() {
        return (byte) (0 - this.array[++this.offset - 1]);
    }

    public byte method2442() {
        return (byte) (128 - this.array[++this.offset - 1]);
    }

    public void writeShortA(int var1) {
        this.array[++this.offset - 1] = (byte) var1;
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
    }

    public void writeShortLE(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
        this.array[++this.offset - 1] = (byte) (var1 + 128);
    }

    public void writeShortLEA(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 + 128);
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
    }

    public int readUnsignedShortLEA() {
        this.offset += 2;
        return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
    }

    public int readUnsignedByteS() {
        this.offset += 2;
        return (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8);
    }

    public int readUnsignedShortLE() {
        this.offset += 2;
        return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
    }

    public int method2408() {
        this.offset += 2;
        int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    public int method2409() {
        this.offset += 2;
        int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
        if (var1 > 32767) {
            var1 -= 65536;
        }

        return var1;
    }

    public void writeMediumMiddle(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
        this.array[++this.offset - 1] = (byte) (var1 >> 16);
        this.array[++this.offset - 1] = (byte) var1;
    }

    public int method2439() {
        this.offset += 3;
        return (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 2] & 255) << 8)
                + ((this.array[this.offset - 1] & 255) << 16);
    }

    public int method2412() {
        this.offset += 3;
        return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 3] & 255) << 8)
                + ((this.array[this.offset - 2] & 255) << 16);
    }

    public int method2420() {
        this.offset += 3;
        int var1 = (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 2] & 255) << 8)
                + ((this.array[this.offset - 1] & 255) << 16);
        if (var1 > 8388607) {
            var1 -= 16777216;
        }

        return var1;
    }

    public int method2413() {
        this.offset += 3;
        int var1 = ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 3] & 255) << 16)
                + (this.array[this.offset - 2] & 255);
        if (var1 > 8388607) {
            var1 -= 16777216;
        }

        return var1;
    }

    public void method2441(int var1) {
        this.array[++this.offset - 1] = (byte) var1;
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
        this.array[++this.offset - 1] = (byte) (var1 >> 16);
        this.array[++this.offset - 1] = (byte) (var1 >> 24);
    }

    public void method2414(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
        this.array[++this.offset - 1] = (byte) var1;
        this.array[++this.offset - 1] = (byte) (var1 >> 24);
        this.array[++this.offset - 1] = (byte) (var1 >> 16);
    }

    public void method2382(int var1) {
        this.array[++this.offset - 1] = (byte) (var1 >> 16);
        this.array[++this.offset - 1] = (byte) (var1 >> 24);
        this.array[++this.offset - 1] = (byte) var1;
        this.array[++this.offset - 1] = (byte) (var1 >> 8);
    }

    public int method2415() {
        this.offset += 4;
        return (this.array[this.offset - 4] & 255) + ((this.array[this.offset - 3] & 255) << 8)
                + ((this.array[this.offset - 2] & 255) << 16) + ((this.array[this.offset - 1] & 255) << 24);
    }

    public int method2416() {
        this.offset += 4;
        return ((this.array[this.offset - 2] & 255) << 24) + ((this.array[this.offset - 4] & 255) << 8)
                + (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 1] & 255) << 16);
    }

    public int method2417() {
        this.offset += 4;
        return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 16)
                + (this.array[this.offset - 2] & 255) + ((this.array[this.offset - 3] & 255) << 24);
    }

    public void readBytesAReverse(byte[] var1, int var2, int var3) {
        for (int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
            var1[var4] = (byte) (this.array[++this.offset - 1] - 128);
        }

    }

    public static boolean method2444(AbstractArchive var0, int var1, int var2) {
        byte[] var3 = var0.takeFile(var1, var2);
        if (var3 == null) {
            return false;
        } else {
            FriendLoginUpdate.SpriteBuffer_decode(var3);
            return true;
        }
    }
}
