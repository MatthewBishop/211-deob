public class WorldMapElement extends DualNode {

    public static FriendSystem friendSystem;

    static AbstractArchive WorldMapElement_archive;

    static EvictingDualNodeHashTable WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);

    public final int objectId;

    public int sprite1 = -1;

    int sprite2 = -1;

    public String name;

    public int field1481;

    public int textSize = 0;

    public boolean field1483 = true;

    public boolean field1494 = false;

    public String[] menuActions = new String[5];

    public String menuTargetName;

    int[] field1487;

    int field1488 = Integer.MAX_VALUE;

    int field1489 = Integer.MAX_VALUE;

    int field1480 = Integer.MIN_VALUE;

    int field1491 = Integer.MIN_VALUE;

    public HorizontalAlignment horizontalAlignment;

    public VerticalAlignment verticalAlignment;

    int[] field1495;

    byte[] field1497;

    public int category;

    WorldMapElement(int var1) {
        this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
        this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
        this.category = -1;
        this.objectId = var1;
    }

    void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decodeNext(var1, var2);
        }
    }

    void decodeNext(Buffer var1, int var2) {
        if (var2 == 1) {
            this.sprite1 = var1.method2419();
        } else if (var2 == 2) {
            this.sprite2 = var1.method2419();
        } else if (var2 == 3) {
            this.name = var1.readStringCp1252NullTerminated();
        } else if (var2 == 4) {
            this.field1481 = var1.readMedium();
        } else if (var2 == 5) {
            var1.readMedium();
        } else if (var2 == 6) {
            this.textSize = var1.readUnsignedByte();
        } else {
            int var3;
            if (var2 == 7) {
                var3 = var1.readUnsignedByte();
                if ((var3 & 1) == 0) {
                    this.field1483 = false;
                }

                if ((var3 & 2) == 2) {
                    this.field1494 = true;
                }
            } else if (var2 == 8) {
                var1.readUnsignedByte();
            } else if (var2 >= 10 && var2 <= 14) {
                this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
            } else if (var2 == 15) {
                var3 = var1.readUnsignedByte();
                this.field1487 = new int[var3 * 2];

                int var4;
                for (var4 = 0; var4 < var3 * 2; ++var4) {
                    this.field1487[var4] = var1.readShort();
                }

                var1.readInt();
                var4 = var1.readUnsignedByte();
                this.field1495 = new int[var4];

                int var5;
                for (var5 = 0; var5 < this.field1495.length; ++var5) {
                    this.field1495[var5] = var1.readInt();
                }

                this.field1497 = new byte[var3];

                for (var5 = 0; var5 < var3; ++var5) {
                    this.field1497[var5] = var1.readByte();
                }
            } else if (var2 != 16) {
                if (var2 == 17) {
                    this.menuTargetName = var1.readStringCp1252NullTerminated();
                } else if (var2 == 18) {
                    var1.method2419();
                } else if (var2 == 19) {
                    this.category = var1.readUnsignedShort();
                } else if (var2 == 21) {
                    var1.readInt();
                } else if (var2 == 22) {
                    var1.readInt();
                } else if (var2 == 23) {
                    var1.readUnsignedByte();
                    var1.readUnsignedByte();
                    var1.readUnsignedByte();
                } else if (var2 == 24) {
                    var1.readShort();
                    var1.readShort();
                } else if (var2 == 25) {
                    var1.method2419();
                } else if (var2 == 28) {
                    var1.readUnsignedByte();
                } else if (var2 == 29) {
                    HorizontalAlignment[] var6 = new HorizontalAlignment[] { HorizontalAlignment.field1542,
                            HorizontalAlignment.field1539, HorizontalAlignment.HorizontalAlignment_centered };
                    this.horizontalAlignment = (HorizontalAlignment) class4.findEnumerated(var6,
                            var1.readUnsignedByte());
                } else if (var2 == 30) {
                    VerticalAlignment[] var7 = new VerticalAlignment[] { VerticalAlignment.field1600,
                            VerticalAlignment.field1598, VerticalAlignment.VerticalAlignment_centered };
                    this.verticalAlignment = (VerticalAlignment) class4.findEnumerated(var7, var1.readUnsignedByte());
                }
            }
        }

    }

    void method922() {
        if (this.field1487 != null) {
            for (int var1 = 0; var1 < this.field1487.length; var1 += 2) {
                if (this.field1487[var1] < this.field1488) {
                    this.field1488 = this.field1487[var1];
                } else if (this.field1487[var1] > this.field1480) {
                    this.field1480 = this.field1487[var1];
                }

                if (this.field1487[var1 + 1] < this.field1489) {
                    this.field1489 = this.field1487[var1 + 1];
                } else if (this.field1487[var1 + 1] > this.field1491) {
                    this.field1491 = this.field1487[var1 + 1];
                }
            }
        }

    }

    public SpritePixels getSpriteBool(boolean var1) {
        int var2 = this.sprite1 * 203330695 * 1498280247;
        return this.getSprite(var2);
    }

    SpritePixels getSprite(int var1) {
        if (var1 < 0) {
            return null;
        } else {
            SpritePixels var2 = (SpritePixels) WorldMapElement_cachedSprites.get((long) var1);
            if (var2 != null) {
                return var2;
            } else {
                var2 = BZip2State.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
                if (var2 != null) {
                    WorldMapElement_cachedSprites.put(var2, (long) var1);
                }

                return var2;
            }
        }
    }

    public int getObjectId() {
        return this.objectId;
    }

    public static int method928(int var0) {
        return class140.method751(ViewportMouse.ViewportMouse_entityTags[var0]);
    }

    public static void method925() {
        FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
    }

    static final void method929(String var0) {
        PacketBufferNode var1 = Renderable.getPacketBufferNode(ClientPacket.field2501, Client.packetWriter.isaacCipher);
        var1.packetBuffer.writeByte(class96.stringCp1252NullTerminatedByteSize(var0));
        var1.packetBuffer.writeStringCp1252NullTerminated(var0);
        Client.packetWriter.addNode(var1);
    }
}
