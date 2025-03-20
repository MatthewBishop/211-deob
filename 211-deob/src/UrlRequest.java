import java.net.URL;

public class UrlRequest {

    static SpritePixels[] mapDotSprites;

    final URL url;

    volatile boolean isDone0;

    volatile byte[] response0;

    UrlRequest(URL var1) {
        this.url = var1;
    }

    public boolean isDone() {
        return this.isDone0;
    }

    public byte[] getResponse() {
        return this.response0;
    }

    public String method642() {
        return this.url.toString();
    }

    public static void method643() {
        StructComposition.StructDefinition_cached.clear();
    }

    static void method645(int var0) {
        Client.oculusOrbState = var0;
    }
}
