public class Message extends DualNode {

    static int cameraLookAtSpeed;

    static int field359;

    int count;

    int cycle;

    int type;

    String sender;

    Username senderUsername;

    TriBool isFromFriend0;

    TriBool isFromIgnored0;

    String prefix;

    String text;

    Message(int var1, String var2, String var3, String var4) {
        this.isFromFriend0 = TriBool.TriBool_unknown;
        this.isFromIgnored0 = TriBool.TriBool_unknown;
        this.set(var1, var2, var3, var4);
    }

    void set(int var1, String var2, String var3, String var4) {
        int var5 = ++Messages.Messages_count - 1;
        this.count = var5;
        this.cycle = Client.cycle;
        this.type = var1;
        this.sender = var2;
        this.fillSenderUsername();
        this.prefix = var3;
        this.text = var4;
        this.clearIsFromFriend();
        this.clearIsFromIgnored();
    }

    void clearIsFromFriend() {
        this.isFromFriend0 = TriBool.TriBool_unknown;
    }

    final boolean isFromFriend() {
        if (this.isFromFriend0 == TriBool.TriBool_unknown) {
            this.fillIsFromFriend();
        }

        return this.isFromFriend0 == TriBool.TriBool_true;
    }

    void fillIsFromFriend() {
        this.isFromFriend0 = WorldMapElement.friendSystem.friendsList.contains(this.senderUsername)
                ? TriBool.TriBool_true
                : TriBool.TriBool_false;
    }

    void clearIsFromIgnored() {
        this.isFromIgnored0 = TriBool.TriBool_unknown;
    }

    final boolean isFromIgnored() {
        if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
            this.fillIsFromIgnored();
        }

        return this.isFromIgnored0 == TriBool.TriBool_true;
    }

    void fillIsFromIgnored() {
        this.isFromIgnored0 = WorldMapElement.friendSystem.ignoreList.contains(this.senderUsername)
                ? TriBool.TriBool_true
                : TriBool.TriBool_false;
    }

    final void fillSenderUsername() {
        if (this.sender != null) {
            this.senderUsername = new Username(class6.method16(this.sender), WorldMapCacheName.loginType);
        } else {
            this.senderUsername = null;
        }

    }

    static Message Messages_getByChannelAndID(int var0, int var1) {
        ChatChannel var2 = (ChatChannel) Messages.Messages_channels.get(var0);
        return var2.getMessage(var1);
    }

    static final int method333(int var0, int var1) {
        int var2 = method323(var0 - 1, var1 - 1) + method323(var0 + 1, var1 - 1) + method323(var0 - 1, var1 + 1)
                + method323(var0 + 1, var1 + 1);
        int var3 = method323(var0 - 1, var1) + method323(var0 + 1, var1) + method323(var0, var1 - 1)
                + method323(var0, var1 + 1);
        int var4 = method323(var0, var1);
        return var2 / 16 + var3 / 8 + var4 / 4;
    }

    static final int method323(int var0, int var1) {
        int var2 = var1 * 57 + var0;
        var2 ^= var2 << 13;
        int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
        return var3 >> 19 & 255;
    }

    static int getWindowedMode() {
        return Client.isResizable ? 2 : 1;
    }
}
