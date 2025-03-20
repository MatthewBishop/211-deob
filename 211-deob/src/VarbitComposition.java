public class VarbitComposition extends DualNode {

    static boolean field1631;

    static short[] foundItemIds;

    static EvictingDualNodeHashTable VarbitDefinition_cached = new EvictingDualNodeHashTable(64);

    static final int[] field1629 = new int[32];

    public int baseVar;

    public int startBit;

    public int endBit;

    static {
        int var0 = 2;

        for (int var1 = 0; var1 < 32; ++var1) {
            field1629[var1] = var0 - 1;
            var0 += var0;
        }

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
            this.baseVar = var1.readUnsignedShort();
            this.startBit = var1.readUnsignedByte();
            this.endBit = var1.readUnsignedByte();
        }

    }

    static void changeWorld(World var0) {
        if (var0.isMembersOnly() != Client.isMembersWorld) {
            Client.isMembersWorld = var0.isMembersOnly();
            StructComposition.method1001(var0.isMembersOnly());
        }

        if (var0.properties != Client.worldProperties) {
            ObjectComposition.method1028(WorldMapEvent.archive8, var0.properties);
        }

        NetCache.worldHost = var0.host;
        Client.worldId = var0.id;
        Client.worldProperties = var0.properties;
        class1.worldPort = Client.gameBuild == 0 ? 'ꩊ' : var0.id + '鱀';
        class10.js5Port = Client.gameBuild == 0 ? 443 : var0.id + '썐';
        Calendar.currentPort = class1.worldPort;
    }

    static final void method983() {
        for (int var0 = 0; var0 < Client.npcCount; ++var0) {
            int var1 = Client.npcIndices[var0];
            NPC var2 = Client.npcs[var1];
            if (var2 != null) {
                PcmPlayer.updateActorSequence(var2, var2.definition.size);
            }
        }

    }
}
