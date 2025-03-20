public class MenuAction {

    static Font fontPlain12;

    int param0;

    int param1;

    int opcode;

    int identifier;

    int itemId;

    String action;

    String target;

    public static final boolean method417(char var0) {
        return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
    }

    public static int Widget_unpackTargetMask(int var0) {
        return var0 >> 11 & 63;
    }

    static final void method415() {
        int var0 = Players.Players_count;
        int[] var1 = Players.Players_indices;

        for (int var2 = 0; var2 < var0; ++var2) {
            Player var3 = Client.players[var1[var2]];
            if (var3 != null) {
                PcmPlayer.updateActorSequence(var3, 1);
            }
        }

    }

    static void method131(int var0) {
        class148.tempMenuAction = new MenuAction();
        class148.tempMenuAction.param0 = Client.menuArguments1[var0];
        class148.tempMenuAction.param1 = Client.menuArguments2[var0];
        class148.tempMenuAction.opcode = Client.menuOpcodes[var0];
        class148.tempMenuAction.identifier = Client.menuIdentifiers[var0];
        class148.tempMenuAction.itemId = Client.menuItemIds[var0];
        class148.tempMenuAction.action = Client.menuActions[var0];
        class148.tempMenuAction.target = Client.menuTargets[var0];
    }
}
