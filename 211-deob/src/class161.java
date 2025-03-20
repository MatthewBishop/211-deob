public class class161 extends class139 {

    public static int musicTrackFileId;

    static int[] Tiles_saturation;

    long field1402;

    String field1403;
    // $FF: synthetic field

    final class142 this$0;

    class161(class142 var1) {
        this.this$0 = var1;
        this.field1402 = -1L;
        this.field1403 = null;
    }

    void vmethod3254(Buffer var1) {
        if (var1.readUnsignedByte() != 255) {
            --var1.offset;
            this.field1402 = var1.readLong();
        }

        this.field1403 = var1.readStringCp1252NullTerminatedOrNull();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method794(this.field1402, this.field1403);
    }

    public static Clock method857() {
        try {
            return new NanoClock();
        } catch (Throwable var1) {
            return new MilliClock();
        }
    }

    static final byte[] decompressBytes(byte[] var0) {
        Buffer var1 = new Buffer(var0);
        int var2 = var1.readUnsignedByte();
        int var3 = var1.readInt();
        if (var3 >= 0 && (AbstractArchive.maximumContainerSize == 0 || var3 <= AbstractArchive.maximumContainerSize)) {
            if (var2 == 0) {
                byte[] var4 = new byte[var3];
                var1.readBytes(var4, 0, var3);
                return var4;
            } else {
                int var6 = var1.readInt();
                if (var6 < 0
                        || AbstractArchive.maximumContainerSize != 0 && var6 > AbstractArchive.maximumContainerSize) {
                    throw new RuntimeException();
                } else {
                    byte[] var5 = new byte[var6];
                    if (var2 == 1) {
                        BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
                    } else {
                        AbstractArchive.gzipDecompressor.decompress(var1, var5);
                    }

                    return var5;
                }
            }
        } else {
            throw new RuntimeException();
        }
    }

    static final void method856() {
        for (Projectile var0 = (Projectile) Client.projectiles
                .last(); var0 != null; var0 = (Projectile) Client.projectiles.previous()) {
            if (var0.plane == class103.Client_plane && Client.cycle <= var0.cycleEnd) {
                if (Client.cycle >= var0.cycleStart) {
                    if (var0.targetIndex > 0) {
                        NPC var1 = Client.npcs[var0.targetIndex - 1];
                        if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                            var0.setDestination(var1.x, var1.y,
                                    GrandExchangeOfferNameComparator.getTileHeight(var1.x, var1.y, var0.plane)
                                            - var0.endHeight,
                                    Client.cycle);
                        }
                    }

                    if (var0.targetIndex < 0) {
                        int var2 = -var0.targetIndex - 1;
                        Player var3;
                        if (var2 == Client.localPlayerIndex) {
                            var3 = class387.localPlayer;
                        } else {
                            var3 = Client.players[var2];
                        }

                        if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                            var0.setDestination(var3.x, var3.y,
                                    GrandExchangeOfferNameComparator.getTileHeight(var3.x, var3.y, var0.plane)
                                            - var0.endHeight,
                                    Client.cycle);
                        }
                    }

                    var0.advance(Client.field442);
                    WorldMapAreaData.scene.drawEntity(class103.Client_plane, (int) var0.x, (int) var0.y, (int) var0.z,
                            60, var0, var0.yaw, -1L, false);
                }
            } else {
                var0.remove();
            }
        }

    }
}
