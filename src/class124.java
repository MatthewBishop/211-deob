import java.util.concurrent.Callable;

public class class124 implements Callable {

	final class125 field1203;

	final class126 field1200;

	final class127 field1201;

	final int field1202;
	// $FF: synthetic field

	final class133 this$0;

	class124(class133 var1, class125 var2, class126 var3, class127 var4, int var5) {
		this.this$0 = var1;
		this.field1203 = var2;
		this.field1200 = var3;
		this.field1201 = var4;
		this.field1202 = var5;
	}

	public Object call() {
		this.field1203.method703();
		class125[][] var1;
		if (this.field1200 == class126.field1229) {
			var1 = this.this$0.field1267;
		} else {
			var1 = this.this$0.field1266;
		}

		var1[this.field1202][this.field1201.method711()] = this.field1203;
		return null;
	}

	public static int Entity_unpackID(long var0) {
		return (int) (var0 >>> 17 & 4294967295L);
	}

	static void method695(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = WorldMapDecorationType.getWorldMap().getMapArea(var0);
		int var4 = class387.localPlayer.plane;
		int var5 = (class387.localPlayer.x >> 7) + ParamComposition.baseX;
		int var6 = (class387.localPlayer.y >> 7) + Client.baseY;
		Coord var7 = new Coord(var4, var5, var6);
		WorldMapDecorationType.getWorldMap().method2287(var3, var7, var1, var2);
	}
}
