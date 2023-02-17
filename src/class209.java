import java.util.Iterator;

public class class209 {

	static PcmStreamMixer pcmStreamMixer;

	public static int[][] directions = new int[128][128];

	public static int[][] distances = new int[128][128];

	public static int field1853;

	public static int field1854;

	public static int[] bufferX = new int[4096];

	public static int[] bufferY = new int[4096];

	static boolean field1857;

	static String method1111() {
		StringBuilder var0 = new StringBuilder();

		Message var2;
		for (Iterator var1 = Messages.Messages_hashTable.iterator(); var1.hasNext(); var0.append(var2.text)
				.append('\n')) {
			var2 = (Message) var1.next();
			if (var2.sender != null && !var2.sender.isEmpty()) {
				var0.append(var2.sender).append(':');
			}
		}

		return var0.toString();
	}
}
