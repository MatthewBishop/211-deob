public class class163 extends class139 {

	int field1408;

	long field1409;
	// $FF: synthetic field

	final class142 this$0;

	class163(class142 var1) {
		this.this$0 = var1;
	}

	void vmethod3254(Buffer var1) {
		this.field1408 = var1.readInt();
		this.field1409 = var1.readLong();
	}

	void vmethod3248(ClanSettings var1) {
		var1.method800(this.field1408, this.field1409);
	}

	public static String readString(Buffer var0) {
		String var1;
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > 32767) {
				var2 = 32767;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class312.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = class101.decodeStringCp1252(var3, 0, var2);
			var1 = var4;
		} catch (Exception var6) {
			var1 = "Cabbage";
		}

		return var1;
	}
}
