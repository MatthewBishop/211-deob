import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class ClanChannel extends Node {

    static UrlRequest World_request;

    static SpritePixels[] headIconPkSprites;

    boolean field1391;

    boolean field1392 = true;

    public List members;

    int[] sortedMembers;

    long field1394;

    public String name = null;

    public byte field1396;

    public byte field1397;

    static {
        new BitSet(65536);
    }

    public ClanChannel(Buffer var1) {
        this.method843(var1);
    }

    public int[] getSortedMembers() {
        if (this.sortedMembers == null) {
            String[] var1 = new String[this.members.size()];
            this.sortedMembers = new int[this.members.size()];

            for (int var2 = 0; var2 < this.members.size(); this.sortedMembers[var2] = var2++) {
                var1[var2] = ((ClanChannelMember) this.members.get(var2)).username.method2543();
            }

            int[] var3 = this.sortedMembers;
            GameObject.method1309(var1, var3, 0, var1.length - 1);
        }

        return this.sortedMembers;
    }

    void addMember(ClanChannelMember var1) {
        this.members.add(var1);
        this.sortedMembers = null;
    }

    void removeMember(int var1) {
        this.members.remove(var1);
        this.sortedMembers = null;
    }

    public int method844() {
        return this.members.size();
    }

    public int method842(String var1) {
        if (!this.field1392) {
            throw new RuntimeException("Displaynames not available");
        } else {
            for (int var2 = 0; var2 < this.members.size(); ++var2) {
                if (((ClanChannelMember) this.members.get(var2)).username.getName().equalsIgnoreCase(var1)) {
                    return var2;
                }
            }

            return -1;
        }
    }

    void method843(Buffer var1) {
        int var2 = var1.readUnsignedByte();
        if ((var2 & 1) != 0) {
            this.field1391 = true;
        }

        if ((var2 & 2) != 0) {
            this.field1392 = true;
        }

        int var3 = 2;
        if ((var2 & 4) != 0) {
            var3 = var1.readUnsignedByte();
        }

        super.key = var1.readLong();
        this.field1394 = var1.readLong();
        this.name = var1.readStringCp1252NullTerminated();
        var1.readBoolean();
        this.field1397 = var1.readByte();
        this.field1396 = var1.readByte();
        int var4 = var1.readUnsignedShort();
        if (var4 > 0) {
            this.members = new ArrayList(var4);

            for (int var5 = 0; var5 < var4; ++var5) {
                ClanChannelMember var6 = new ClanChannelMember();
                if (this.field1391) {
                    var1.readLong();
                }

                if (this.field1392) {
                    var6.username = new Username(var1.readStringCp1252NullTerminated());
                }

                var6.rank = var1.readByte();
                var6.world = var1.readUnsignedShort();
                if (var3 >= 3) {
                    var1.readBoolean();
                }

                this.members.add(var5, var6);
            }
        }

    }

    public static int method846(int var0) {
        return var0 >> 17 & 7;
    }

    static void selectSpell(int var0, int var1, int var2, int var3) {
        Widget var4 = class135.getWidgetChild(var0, var1);
        if (var4 != null && var4.onTargetEnter != null) {
            ScriptEvent var5 = new ScriptEvent();
            var5.widget = var4;
            var5.args = var4.onTargetEnter;
            WorldMapAreaData.runScriptEvent(var5);
        }

        Client.selectedSpellItemId = var3;
        Client.isSpellSelected = true;
        class9.selectedSpellWidget = var0;
        Client.selectedSpellChildIndex = var1;
        class149.selectedSpellFlags = var2;
        LoginScreenAnimation.invalidateWidget(var4);
    }
}
