import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class class266 implements class268 {

    static SoundSystem soundSystem;

    protected int field2411;

    protected class266(StudioGame var1, Language var2, int var3) {
        this.field2411 = var3;
    }

    public static final SpritePixels method1505(byte[] var0) {
        BufferedImage var1 = null;

        try {
            Class var2 = ImageIO.class;
            synchronized (ImageIO.class) {
                var1 = ImageIO.read(new ByteArrayInputStream(var0));
            }

            int var6 = var1.getWidth();
            int var7 = var1.getHeight();
            int[] var4 = new int[var6 * var7];
            PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var6, var7, var4, 0, var6);
            var5.grabPixels();
            return new SpritePixels(var4, var6, var7);
        } catch (IOException var9) {
            ;
        } catch (InterruptedException var10) {
            ;
        }

        return new SpritePixels(0, 0);
    }
}
