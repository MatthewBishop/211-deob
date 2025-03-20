import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class class16 implements ThreadFactory {

    static int field56;

    static AbstractArchive SequenceDefinition_skeletonsArchive;

    final ThreadGroup field57;

    final AtomicInteger field55;
    // $FF: synthetic field

    final class14 this$0;

    class16(class14 var1) {
        this.this$0 = var1;
        this.field55 = new AtomicInteger(1);
        SecurityManager var2 = System.getSecurityManager();
        this.field57 = var2 != null ? var2.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    public Thread newThread(Runnable var1) {
        Thread var2 = new Thread(this.field57, var1,
                this.this$0.field45 + "-rest-request-" + this.field55.getAndIncrement(), 0L);
        var2.setDaemon(true);
        var2.setPriority(5);
        return var2;
    }

    public static boolean method58(int var0) {
        return (var0 >> 29 & 1) != 0;
    }

    static int method59() {
        return Login.loginIndex;
    }

    static void widgetDefaultMenuAction(int var0, int var1, int var2, int var3, String var4) {
        Widget var5 = class135.getWidgetChild(var1, var2);
        if (var5 != null) {
            if (var5.onOp != null) {
                ScriptEvent var6 = new ScriptEvent();
                var6.widget = var5;
                var6.opIndex = var0;
                var6.targetName = var4;
                var6.args = var5.onOp;
                WorldMapAreaData.runScriptEvent(var6);
            }

            boolean var8 = true;
            if (var5.contentType > 0) {
                var8 = class276.method1527(var5);
            }

            if (var8) {
                if (ItemLayer.method1115(class173.getWidgetFlags(var5), var0 - 1)) {
                    PacketBufferNode var7;
                    if (var0 == 1) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2491, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 2) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2484, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 3) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2447, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 4) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2451, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 5) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2518, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 6) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2504, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 7) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2507, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 8) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2486, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 9) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2480, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                    if (var0 == 10) {
                        var7 = Renderable.getPacketBufferNode(ClientPacket.field2509, Client.packetWriter.isaacCipher);
                        var7.packetBuffer.writeInt(var1);
                        var7.packetBuffer.writeShort(var2);
                        var7.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var7);
                    }

                }
            }
        }
    }
}
