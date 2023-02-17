public class ClanMate extends Buddy {

	static boolean mouseCam;

	TriBool friend;

	TriBool ignored;

	ClanMate() {
		this.friend = TriBool.TriBool_unknown;
		this.ignored = TriBool.TriBool_unknown;
	}

	void clearIsFriend() {
		this.friend = TriBool.TriBool_unknown;
	}

	public final boolean isFriend() {
		if (this.friend == TriBool.TriBool_unknown) {
			this.fillIsFriend();
		}

		return this.friend == TriBool.TriBool_true;
	}

	void fillIsFriend() {
		this.friend = WorldMapElement.friendSystem.friendsList.contains(super.username) ? TriBool.TriBool_true
				: TriBool.TriBool_false;
	}

	void clearIsIgnored() {
		this.ignored = TriBool.TriBool_unknown;
	}

	public final boolean isIgnored() {
		if (this.ignored == TriBool.TriBool_unknown) {
			this.fillIsIgnored();
		}

		return this.ignored == TriBool.TriBool_true;
	}

	void fillIsIgnored() {
		this.ignored = WorldMapElement.friendSystem.ignoreList.contains(super.username) ? TriBool.TriBool_true
				: TriBool.TriBool_false;
	}
}
