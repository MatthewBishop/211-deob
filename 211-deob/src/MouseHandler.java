import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {

    public static MouseHandler MouseHandler_instance = new MouseHandler();

    public static volatile int MouseHandler_idleCycles = 0;

    static volatile int MouseHandler_currentButtonVolatile = 0;

    static volatile int MouseHandler_xVolatile = -1;

    static volatile int MouseHandler_yVolatile = -1;

    static volatile long MouseHandler_lastMovedVolatile = -1L;

    public static int MouseHandler_x = 0;

    public static int MouseHandler_currentButton = 0;

    public static int MouseHandler_y = 0;

    public static long MouseHandler_millis = 0L;

    static volatile int MouseHandler_lastButtonVolatile = 0;

    static volatile int MouseHandler_lastPressedXVolatile = 0;

    static volatile int MouseHandler_lastPressedYVolatile = 0;

    static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;

    public static int MouseHandler_lastButton = 0;

    public static int MouseHandler_lastPressedX = 0;

    public static int MouseHandler_lastPressedY = 0;

    public static long MouseHandler_lastPressedTimeMillis = 0L;

    static Widget[] field159;

    final int getButton(MouseEvent var1) {
        int var2 = var1.getButton();
        if (!var1.isAltDown() && var2 != 2) {
            return !var1.isMetaDown() && var2 != 3 ? 1 : 2;
        } else {
            return 4;
        }
    }

    public final synchronized void mouseMoved(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_xVolatile = var1.getX();
            MouseHandler_yVolatile = var1.getY();
            MouseHandler_lastMovedVolatile = var1.getWhen();
        }

    }

    public final synchronized void mousePressed(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_lastPressedXVolatile = var1.getX();
            MouseHandler_lastPressedYVolatile = var1.getY();
            MouseHandler_lastPressedTimeMillisVolatile = class153.clockNow();
            MouseHandler_lastButtonVolatile = this.getButton(var1);
            if (MouseHandler_lastButtonVolatile != 0) {
                MouseHandler_currentButtonVolatile = MouseHandler_lastButtonVolatile;
            }
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final void mouseClicked(MouseEvent var1) {
        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void mouseEntered(MouseEvent var1) {
        this.mouseMoved(var1);
    }

    public final synchronized void mouseDragged(MouseEvent var1) {
        this.mouseMoved(var1);
    }

    public final synchronized void focusLost(FocusEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_currentButtonVolatile = 0;
        }

    }

    public final synchronized void mouseExited(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_xVolatile = -1;
            MouseHandler_yVolatile = -1;
            MouseHandler_lastMovedVolatile = var1.getWhen();
        }

    }

    public final synchronized void mouseReleased(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_currentButtonVolatile = 0;
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final void focusGained(FocusEvent var1) {
    }
}
