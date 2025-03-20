public class class140 extends class139 {

	public static byte[][] SpriteBuffer_pixels;

	int field1302;

	boolean field1301;
	// $FF: synthetic field

	final class142 this$0;

	class140(class142 var1) {
		this.this$0 = var1;
		this.field1302 = -1;
	}

	void vmethod3254(Buffer var1) {
		this.field1302 = var1.readUnsignedShort();
		this.field1301 = var1.readUnsignedByte() == 1;
	}

	void vmethod3248(ClanSettings var1) {
		var1.method797(this.field1302, this.field1301);
	}

	static void method754() {
		Messages.Messages_channels.clear();
		Messages.Messages_hashTable.clear();
		Messages.Messages_queue.clear();
		Messages.Messages_count = 0;
	}

	public static int method751(long var0) {
		return (int) (var0 >>> 7 & 127L);
	}
}
