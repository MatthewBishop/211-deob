public class UserComparator8 extends AbstractUserComparator {

	public static short[][] field1152;

	public static AbstractArchive Widget_archive;

	final boolean reversed;

	public UserComparator8(boolean var1) {
		this.reversed = var1;
	}

	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world) {
			if (var2.world != Client.worldId) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world == Client.worldId) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy) var1, (Buddy) var2);
	}
}
