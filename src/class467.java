import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class class467 extends DualNode {

	class463[] field3992;

	List field3991;

	public class467(AbstractArchive var1, int var2) {
		byte[] var3 = var1.takeFile(var2, 0);
		this.method2350(new Buffer(var3));
	}

	public class467(AbstractArchive var1, int var2, int var3) {
		byte[] var4 = var1.takeFile(var2, var3 + 1);
		this.method2350(new Buffer(var4));
	}

	void method2350(Buffer var1) {
		int var2 = var1.method2394();
		this.field3992 = new class463[var2];
		this.field3991 = new ArrayList(var2);

		for (int var3 = 0; var3 < var2; ++var3) {
			this.field3992[var3] = (class463) class4.findEnumerated(class463.method2337(), var1.readUnsignedByte());
			int var4 = var1.method2394();
			HashMap var5 = new HashMap(var4);

			while (var4-- > 0) {
				Object var6 = this.field3992[var3].method2339(var1);
				int var7 = var1.method2394();
				ArrayList var8 = new ArrayList();

				while (var7-- > 0) {
					int var9 = var1.method2394();
					var8.add(var9);
				}

				var5.put(var6, var8);
			}

			this.field3991.add(var3, var5);
		}

	}

	public List method2349(Object var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		Map var3 = (Map) this.field3991.get(var2);
		return (List) var3.get(var1);
	}

	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = GrandExchangeOfferNameComparator.getTileHeight(var0, var1, class103.Client_plane) - var2;
			var0 -= ClanSettings.cameraX;
			var3 -= UserComparator10.cameraY;
			var1 -= class366.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[class103.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[class103.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[class285.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[class285.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var3 * var5 - var4 * var1 >> 16;
			var1 = var5 * var1 + var4 * var3 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = Client.viewportHeight / 2 + var8 * Client.viewportZoom / var1;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}
}
