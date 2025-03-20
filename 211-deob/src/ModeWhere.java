import java.util.HashSet;
import java.util.Set;

public enum ModeWhere implements class349 {

    field3544("", 0, new class348[] { class348.field3521 }),

    field3536("", 1, new class348[] { class348.field3522, class348.field3521 }),

    field3537("", 2, new class348[] { class348.field3522, class348.field3523, class348.field3521 }),

    field3538("", 3, new class348[] { class348.field3522 }),

    field3551("", 4),

    field3548("", 5, new class348[] { class348.field3522, class348.field3521 }),

    field3539("", 6, new class348[] { class348.field3521 }),

    field3542("", 8, new class348[] { class348.field3522, class348.field3521 }),

    field3543("", 9, new class348[] { class348.field3522, class348.field3523 }),

    field3535("", 10, new class348[] { class348.field3522 }),

    field3547("", 11, new class348[] { class348.field3522 }),

    field3546("", 12, new class348[] { class348.field3522, class348.field3521 }),

    field3540("", 13, new class348[] { class348.field3522 });

    static int cameraMoveToSpeed;

    static int menuY;

    final int id;

    final Set field3549 = new HashSet();

    ModeWhere(String var3, int var4, class348[] var5) {
        this.id = var4;
        class348[] var6 = var5;

        for (int var7 = 0; var7 < var6.length; ++var7) {
            class348 var8 = var6[var7];
            this.field3549.add(var8);
        }

    }

    ModeWhere(String var3, int var4) {
        this.id = var4;
    }

    public int rsOrdinal() {
        return this.id;
    }

    static Widget method1883(int var0, Widget var1, int var2, int var3, int var4, int var5, int var6, float[] var7) {
        Widget var8 = new Widget();
        var8.type = var0;
        var8.parentId = var1.id;
        var8.childIndex = var2;
        var8.isIf3 = true;
        var8.xAlignment = var3;
        var8.yAlignment = var4;
        var8.widthAlignment = var5;
        var8.heightAlignment = var6;
        var8.rawX = (int) (var7[0] * (float) var1.width);
        var8.rawY = (int) ((float) var1.height * var7[1]);
        var8.rawWidth = (int) (var7[2] * (float) var1.width);
        var8.rawHeight = (int) ((float) var1.height * var7[3]);
        return var8;
    }

    static final InterfaceParent ifOpenSub(int var0, int var1, int var2) {
        InterfaceParent var3 = new InterfaceParent();
        var3.group = var1;
        var3.type = var2;
        Client.interfaceParents.put(var3, (long) var0);
        class155.Widget_resetModelFrames(var1);
        Widget var4 = class133.getWidget(var0);
        LoginScreenAnimation.invalidateWidget(var4);
        if (Client.meslayerContinueWidget != null) {
            LoginScreenAnimation.invalidateWidget(Client.meslayerContinueWidget);
            Client.meslayerContinueWidget = null;
        }

        AbstractWorldMapData.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var0 >> 16], var4, false);
        SoundCache.runWidgetOnLoadListener(var1);
        if (Client.rootInterface != -1) {
            class147.runIntfCloseListeners(Client.rootInterface, 1);
        }

        return var3;
    }

    static void method1885(int var0) {
        if (var0 != Client.loginState) {
            Client.loginState = var0;
        }
    }
}
