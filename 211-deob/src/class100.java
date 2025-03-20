final class class100 implements class301 {

    public static int[] SpriteBuffer_spritePalette;

    static int[] Tiles_hue;

    static IndexedSprite field1079;
    // $FF: synthetic field

    final Widget val$cc;

    class100(Widget var1) {
        this.val$cc = var1;
    }

    public void vmethod5708() {
        if (this.val$cc != null && this.val$cc.method1747().field2805 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.method461(this.val$cc);
            var1.setArgs(this.val$cc.method1747().field2805);
            class12.getScriptEvents().addFirst(var1);
        }

    }

    public static void method595() {
        class488.SpriteBuffer_xOffsets = null;
        ApproximateRouteStrategy.SpriteBuffer_yOffsets = null;
        FriendsList.SpriteBuffer_spriteWidths = null;
        class132.SpriteBuffer_spriteHeights = null;
        SpriteBuffer_spritePalette = null;
        class140.SpriteBuffer_pixels = null;
    }
}
