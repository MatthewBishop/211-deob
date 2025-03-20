public enum class317 implements class349 {

    field3024(0),

    field3025(1),

    field3023(2),

    field3026(3),

    field3027(4);

    final int field3028;

    class317(int var3) {
        this.field3028 = var3;
    }

    public int rsOrdinal() {
        return this.field3028;
    }

    static String Widget_getSpellActionName(Widget var0) {
        if (MenuAction.Widget_unpackTargetMask(class173.getWidgetFlags(var0)) == 0) {
            return null;
        } else {
            return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName
                    : null;
        }
    }
}
