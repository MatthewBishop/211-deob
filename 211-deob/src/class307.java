import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class class307 {

    static IndexedSprite[] worldSelectFlagSprites;

    class372 field2824 = new class372();

    class372 field2840 = new class372();

    boolean field2826 = false;

    boolean field2827 = true;

    int field2828 = 0;

    boolean field2829 = false;

    int field2830 = 0;

    int field2831 = 0;

    int field2825 = 0;

    int field2832 = 0;

    int field2833 = 0;

    int field2834 = 0;

    int field2835 = 0;

    int field2836 = Integer.MAX_VALUE;

    int field2837 = Integer.MAX_VALUE;

    int field2838 = Integer.MAX_VALUE;

    int field2839 = 0;

    int field2842 = 0;

    int field2821 = 0;

    int field2841 = 0;

    class301 field2823;

    class301 field2822;

    class307() {
        this.field2824.method1958(1);
        this.field2840.method1958(1);
    }

    void method1641() {
        this.field2828 = (this.field2828 + 1) % 60;
        if (this.field2835 > 0) {
            --this.field2835;
        }

    }

    public boolean method1708(boolean var1) {
        var1 = var1 && this.field2827;
        boolean var2 = this.field2826 != var1;
        this.field2826 = var1;
        if (!this.field2826) {
            this.method1700(this.field2832, this.field2832);
        }

        return var2;
    }

    public void method1643(boolean var1) {
        this.field2827 = var1;
        this.field2826 = var1 && this.field2826;
    }

    boolean method1659(String var1) {
        String var2 = this.field2824.method1941();
        if (!var2.equals(var1)) {
            var1 = this.method1691(var1);
            this.field2824.method1947(var1);
            this.method1648(this.field2821, this.field2841);
            this.method1695();
            this.method1698();
            return true;
        } else {
            return false;
        }
    }

    boolean method1644(String var1) {
        this.field2840.method1947(var1);
        return true;
    }

    boolean method1702(AbstractFont var1) {
        boolean var2 = !this.field2829;
        this.field2824.method1948(var1);
        this.field2840.method1948(var1);
        this.field2829 = true;
        var2 |= this.method1648(this.field2821, this.field2841);
        var2 |= this.method1700(this.field2833, this.field2832);
        if (this.method1695()) {
            this.method1698();
            var2 = true;
        }

        return var2;
    }

    public boolean method1645(int var1, int var2) {
        boolean var3 = this.field2839 != var1 || var2 != this.field2842;
        this.field2839 = var1;
        this.field2842 = var2;
        var3 |= this.method1648(this.field2821, this.field2841);
        return var3;
    }

    public boolean method1646(int var1) {
        if (var1 < 0) {
            var1 = Integer.MAX_VALUE;
        }

        boolean var2 = var1 == this.field2824.method1956();
        this.field2824.method1942(var1, true);
        this.field2840.method1942(var1, true);
        if (this.method1695()) {
            this.method1698();
            var2 = true;
        }

        return var2;
    }

    public boolean method1647(int var1) {
        if (var1 < 0) {
            this.field2836 = Integer.MAX_VALUE;
        } else {
            this.field2836 = var1;
        }

        if (this.method1695()) {
            this.method1698();
            return true;
        } else {
            return false;
        }
    }

    public boolean method1717(int var1) {
        this.field2838 = var1;
        if (this.method1695()) {
            this.method1698();
            return true;
        } else {
            return false;
        }
    }

    public boolean method1648(int var1, int var2) {
        if (!this.method1683()) {
            this.field2821 = var1;
            this.field2841 = var2;
            return false;
        } else {
            int var3 = this.field2821;
            int var4 = this.field2841;
            int var5 = Math.max(0, this.field2824.method1969() - this.field2839 + 2);
            int var6 = Math.max(0, this.field2824.method1952() - this.field2842 + 1);
            this.field2821 = Math.max(0, Math.min(var5, var1));
            this.field2841 = Math.max(0, Math.min(var6, var2));
            return var3 != this.field2821 || var4 != this.field2841;
        }
    }

    public boolean method1711(int var1, int var2) {
        return true;
    }

    public void method1649(int var1) {
        this.field2824.method1944(var1);
    }

    public void method1650(int var1) {
        this.field2830 = var1;
    }

    public void method1651(int var1) {
        this.field2824.method1958(var1);
    }

    public void method1652(int var1) {
        this.field2824.method1943(var1);
    }

    public boolean method1653(int var1) {
        this.field2825 = var1;
        String var2 = this.field2824.method1941();
        int var3 = var2.length();
        var2 = this.method1691(var2);
        if (var2.length() != var3) {
            this.field2824.method1947(var2);
            this.method1648(this.field2821, this.field2841);
            this.method1695();
            this.method1698();
            return true;
        } else {
            return false;
        }
    }

    public void method1701() {
        this.field2829 = false;
    }

    public boolean method1654(int var1) {
        if (this.method1699(var1)) {
            this.method1658();
            class373 var2 = this.field2824.method1968((char) var1, this.field2832, this.field2837, this.field2836);
            this.method1700(var2.method1972(), var2.method1972());
            this.method1695();
            this.method1698();
        }

        return true;
    }

    public void method1655() {
        if (!this.method1658() && this.field2832 > 0) {
            int var1 = this.field2824.method1966(this.field2832 - 1);
            this.method1698();
            this.method1700(var1, var1);
        }

    }

    public void method1713() {
        if (!this.method1658() && this.field2832 < this.field2824.method1967()) {
            int var1 = this.field2824.method1966(this.field2832);
            this.method1698();
            this.method1700(var1, var1);
        }

    }

    public void method1656() {
        if (!this.method1658() && this.field2832 > 0) {
            class447 var1 = this.method1693(this.field2832 - 1);
            int var2 = this.field2824.method1950((Integer) var1.field3927, this.field2832);
            this.method1698();
            this.method1700(var2, var2);
        }

    }

    public void method1657() {
        if (!this.method1658() && this.field2832 < this.field2824.method1967()) {
            class447 var1 = this.method1693(this.field2832);
            int var2 = this.field2824.method1950(this.field2832, (Integer) var1.field3928);
            this.method1698();
            this.method1700(var2, var2);
        }

    }

    boolean method1658() {
        if (!this.method1712()) {
            return false;
        } else {
            int var1 = this.field2824.method1950(this.field2833, this.field2832);
            this.method1698();
            this.method1700(var1, var1);
            return true;
        }
    }

    public void method1692() {
        this.method1700(0, this.field2824.method1967());
    }

    public boolean method1700(int var1, int var2) {
        if (!this.method1683()) {
            this.field2833 = var1;
            this.field2832 = var2;
            return false;
        } else {
            if (var1 > this.field2824.method1967()) {
                var1 = this.field2824.method1967();
            }

            if (var2 > this.field2824.method1967()) {
                var2 = this.field2824.method1967();
            }

            boolean var3 = this.field2833 != var1 || var2 != this.field2832;
            this.field2833 = var1;
            if (var2 != this.field2832) {
                this.field2832 = var2;
                this.field2828 = 0;
                this.method1696();
            }

            if (var3 && this.field2822 != null) {
                this.field2822.vmethod5708();
            }

            return var3;
        }
    }

    public void method1642(boolean var1) {
        class447 var2 = this.method1694(this.field2832);
        this.method1685((Integer) var2.field3927, var1);
    }

    public void method1710(boolean var1) {
        class447 var2 = this.method1694(this.field2832);
        this.method1685((Integer) var2.field3928, var1);
    }

    public void method1715(boolean var1) {
        this.method1685(0, var1);
    }

    public void method1718(boolean var1) {
        this.method1685(this.field2824.method1967(), var1);
    }

    public void method1703(boolean var1) {
        if (this.method1712() && !var1) {
            this.method1685(Math.min(this.field2833, this.field2832), var1);
        } else if (this.field2832 > 0) {
            this.method1685(this.field2832 - 1, var1);
        }

    }

    public void method1662(boolean var1) {
        if (this.method1712() && !var1) {
            this.method1685(Math.max(this.field2833, this.field2832), var1);
        } else if (this.field2832 < this.field2824.method1967()) {
            this.method1685(this.field2832 + 1, var1);
        }

    }

    public void method1719(boolean var1) {
        if (this.field2832 > 0) {
            class447 var2 = this.method1693(this.field2832 - 1);
            this.method1685((Integer) var2.field3927, var1);
        }

    }

    public void method1664(boolean var1) {
        if (this.field2832 < this.field2824.method1967()) {
            class447 var2 = this.method1693(this.field2832 + 1);
            this.method1685((Integer) var2.field3928, var1);
        }

    }

    public void method1665(boolean var1) {
        if (this.field2832 > 0) {
            this.method1685(this.field2824.method1963(this.field2832, -1), var1);
        }

    }

    public void method1666(boolean var1) {
        if (this.field2832 < this.field2824.method1967()) {
            this.method1685(this.field2824.method1963(this.field2832, 1), var1);
        }

    }

    public void method1667(boolean var1) {
        if (this.field2832 > 0) {
            int var2 = this.method1720();
            this.method1685(this.field2824.method1963(this.field2832, -var2), var1);
        }

    }

    public void method1668(boolean var1) {
        if (this.field2832 < this.field2824.method1967()) {
            int var2 = this.method1720();
            this.method1685(this.field2824.method1963(this.field2832, var2), var1);
        }

    }

    public void method1669(boolean var1) {
        class376 var2 = this.field2824.method1965(0, this.field2832);
        class447 var3 = var2.method2010();
        this.method1685(this.field2824.method1951((Integer) var3.field3927, this.field2841), var1);
    }

    public void method1670(boolean var1) {
        class376 var2 = this.field2824.method1965(0, this.field2832);
        class447 var3 = var2.method2010();
        this.method1685(this.field2824.method1951((Integer) var3.field3927, this.field2841 + this.field2842), var1);
    }

    public void method1671(int var1, int var2, boolean var3, boolean var4) {
        boolean var5 = false;
        int var8;
        if (!this.field2829) {
            var8 = 0;
        } else {
            var1 += this.field2821;
            var2 += this.field2841;
            var8 = this.field2824.method1951(var1, var2);
        }

        class447 var6;
        if (var3 && var4) {
            this.field2831 = 1;
            var6 = this.method1693(var8);
            class447 var7 = this.method1693(this.field2834);
            this.method1707(var7, var6);
        } else if (var3) {
            this.field2831 = 1;
            var6 = this.method1693(var8);
            this.method1700((Integer) var6.field3927, (Integer) var6.field3928);
            this.field2834 = (Integer) var6.field3927;
        } else if (var4) {
            this.method1700(this.field2834, var8);
        } else {
            if (this.field2835 > 0 && var8 == this.field2834) {
                if (this.field2832 == this.field2833) {
                    this.field2831 = 1;
                    var6 = this.method1693(var8);
                    this.method1700((Integer) var6.field3927, (Integer) var6.field3928);
                } else {
                    this.field2831 = 2;
                    var6 = this.method1694(var8);
                    this.method1700((Integer) var6.field3927, (Integer) var6.field3928);
                }
            } else {
                this.field2831 = 0;
                this.method1700(var8, var8);
                this.field2834 = var8;
            }

            this.field2835 = 25;
        }

    }

    public void method1706(int var1, int var2) {
        if (this.field2829 && this.method1680()) {
            var1 += this.field2821;
            var2 += this.field2841;
            int var3 = this.field2824.method1951(var1, var2);
            class447 var4;
            class447 var5;
            switch (this.field2831) {
            case 0:
                this.method1700(this.field2833, var3);
                break;
            case 1:
                var4 = this.method1693(this.field2834);
                var5 = this.method1693(var3);
                this.method1707(var4, var5);
                break;
            case 2:
                var4 = this.method1694(this.field2834);
                var5 = this.method1694(var3);
                this.method1707(var4, var5);
            }
        }

    }

    public void method1672(Clipboard var1) {
        class376 var2 = this.field2824.method1965(this.field2833, this.field2832);
        if (!var2.method2006()) {
            String var3 = var2.method2013();
            if (!var3.isEmpty()) {
                var1.setContents(new StringSelection(var3), (ClipboardOwner) null);
            }
        }

    }

    public void method1673(Clipboard var1) {
        if (this.method1712()) {
            this.method1672(var1);
            this.method1658();
        }

    }

    public void method1705(Clipboard var1) {
        Transferable var2 = var1.getContents((Object) null);
        if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                String var3 = this.method1691((String) var2.getTransferData(DataFlavor.stringFlavor));
                this.method1658();
                class373 var4 = this.field2824.method1946(var3, this.field2832, this.field2837, this.field2836);
                this.method1700(var4.method1972(), var4.method1972());
                this.method1695();
                this.method1698();
            } catch (Exception var5) {
                System.out.println("Error pasting clipboard to InputField.");
            }
        }

    }

    public void method1674() {
        this.field2841 = Math.max(0, this.field2841 - this.field2824.method1953());
    }

    public void method1675() {
        int var1 = Math.max(0, this.field2824.method1952() - this.field2842);
        this.field2841 = Math.min(var1, this.field2841 + this.field2824.method1953());
    }

    public void method1676(class301 var1) {
        this.field2823 = var1;
    }

    public void method1677(class301 var1) {
        this.field2822 = var1;
    }

    public class372 method1678() {
        return this.field2824;
    }

    public class372 method1714() {
        return this.field2840;
    }

    public class376 method1679() {
        return this.field2824.method1965(this.field2833, this.field2832);
    }

    public boolean method1680() {
        return this.field2826;
    }

    public boolean method1663() {
        return this.field2827;
    }

    public boolean method1681() {
        return this.method1680() && this.field2828 % 60 < 30;
    }

    public int method1716() {
        return this.field2832;
    }

    public int method1682() {
        return this.field2833;
    }

    public boolean method1683() {
        return this.field2829;
    }

    public int method1684() {
        return this.field2821;
    }

    public int method1704() {
        return this.field2841;
    }

    public int method1661() {
        return this.field2824.method1956();
    }

    public int method1686() {
        return this.field2836;
    }

    public int method1687() {
        return this.field2838;
    }

    public int method1660() {
        return this.field2830;
    }

    public int method1688() {
        return this.field2824.method1957();
    }

    public int method1709() {
        return this.field2825;
    }

    public int method1689() {
        return this.field2824.method1945();
    }

    public boolean method1690() {
        return this.field2836 > 1;
    }

    boolean method1712() {
        return this.field2833 != this.field2832;
    }

    String method1691(String var1) {
        StringBuilder var2 = new StringBuilder(var1.length());

        for (int var3 = 0; var3 < var1.length(); ++var3) {
            char var4 = var1.charAt(var3);
            if (this.method1699(var4)) {
                var2.append(var4);
            }
        }

        return var2.toString();
    }

    void method1707(class447 var1, class447 var2) {
        if ((Integer) var2.field3927 < (Integer) var1.field3927) {
            this.method1700((Integer) var1.field3928, (Integer) var2.field3927);
        } else {
            this.method1700((Integer) var1.field3927, (Integer) var2.field3928);
        }

    }

    class447 method1693(int var1) {
        int var2 = this.field2824.method1967();
        int var3 = 0;
        int var4 = var2;

        int var5;
        for (var5 = var1; var5 > 0; --var5) {
            if (this.method1697(this.field2824.method1937(var5 - 1).field3603)) {
                var3 = var5;
                break;
            }
        }

        for (var5 = var1; var5 < var2; ++var5) {
            if (this.method1697(this.field2824.method1937(var5).field3603)) {
                var4 = var5;
                break;
            }
        }

        return new class447(var3, var4);
    }

    class447 method1694(int var1) {
        int var2 = this.field2824.method1967();
        int var3 = 0;
        int var4 = var2;

        int var5;
        for (var5 = var1; var5 > 0; --var5) {
            if (this.field2824.method1937(var5 - 1).field3603 == '\n') {
                var3 = var5;
                break;
            }
        }

        for (var5 = var1; var5 < var2; ++var5) {
            if (this.field2824.method1937(var5).field3603 == '\n') {
                var4 = var5;
                break;
            }
        }

        return new class447(var3, var4);
    }

    boolean method1695() {
        if (!this.method1683()) {
            return false;
        } else {
            boolean var1 = false;
            if (this.field2824.method1967() > this.field2838) {
                this.field2824.method1950(this.field2838, this.field2824.method1967());
                var1 = true;
            }

            int var2;
            if (this.field2824.method1964() > this.field2836) {
                var2 = this.field2824.method1963(0, this.field2836) - 1;
                this.field2824.method1950(var2, this.field2824.method1967());
                var1 = true;
            }

            if (var1) {
                var2 = this.field2832;
                int var3 = this.field2833;
                int var4 = this.field2824.method1967();
                if (this.field2832 > var4) {
                    var2 = var4;
                }

                if (this.field2833 > var4) {
                    var3 = var4;
                }

                this.method1700(var3, var2);
            }

            return var1;
        }
    }

    void method1685(int var1, boolean var2) {
        if (var2) {
            this.method1700(this.field2833, var1);
        } else {
            this.method1700(var1, var1);
        }

    }

    int method1720() {
        return this.field2842 / this.field2824.method1953();
    }

    void method1696() {
        class376 var1 = this.field2824.method1965(0, this.field2832);
        class447 var2 = var1.method2010();
        int var3 = this.field2824.method1953();
        int var4 = (Integer) var2.field3927 - 10;
        int var5 = var4 + 20;
        int var6 = (Integer) var2.field3928 - 3;
        int var7 = var6 + var3 + 6;
        int var8 = this.field2821;
        int var9 = var8 + this.field2839;
        int var10 = this.field2841;
        int var11 = var10 + this.field2842;
        int var12 = this.field2821;
        int var13 = this.field2841;
        if (var4 < var8) {
            var12 = var4;
        } else if (var5 > var9) {
            var12 = var5 - this.field2839;
        }

        if (var6 < var10) {
            var13 = var6;
        } else if (var7 > var11) {
            var13 = var7 - this.field2842;
        }

        this.method1648(var12, var13);
    }

    boolean method1697(int var1) {
        return var1 == 32 || var1 == 10 || var1 == 9;
    }

    void method1698() {
        if (this.field2823 != null) {
            this.field2823.vmethod5708();
        }

    }

    boolean method1699(int var1) {
        switch (this.field2825) {
        case 1:
            return class97.isAlphaNumeric((char) var1);
        case 2:
            return class155.isCharAlphabetic((char) var1);
        case 3:
            return CollisionMap.isDigit((char) var1);
        case 4:
            char var2 = (char) var1;
            if (CollisionMap.isDigit(var2)) {
                return true;
            } else {
                if (var2 != 'k' && var2 != 'K' && var2 != 'm' && var2 != 'M' && var2 != 'b' && var2 != 'B') {
                    return false;
                }

                return true;
            }
        default:
            return true;
        }
    }
}
