public class UserComparator6 extends AbstractUserComparator {

	static SpritePixels[] mapMarkerSprites;

	final boolean reversed;

	public UserComparator6(boolean var1) {
		this.reversed = var1;
	}

	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername())
					: var2.getUsername().compareToTyped(var1.getUsername());
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy) var1, (Buddy) var2);
	}

	static final void method668() {
		Decimator.method306("You can't add yourself to your own friend list");
	}

	static void Login_promptCredentials(boolean var0) {
		if (!Decimator.client.method369() && !Decimator.client.method344() && !Decimator.client.method343()) {
			Login.Login_response1 = "";
			Login.Login_response2 = "Enter your username/email & password.";
			Login.Login_response3 = "";
			ReflectionCheck.method171(2);
			if (var0) {
				Login.Login_password = "";
			}

			FriendSystem.method405();
			class361.method1925();
		} else {
			ReflectionCheck.method171(10);
		}
	}
}
