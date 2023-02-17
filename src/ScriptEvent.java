public class ScriptEvent extends Node {

	Object[] args;

	boolean isMouseInputEvent;

	Widget widget;

	int mouseX;

	int mouseY;

	int opIndex;

	Widget dragTarget;

	int keyTyped;

	int keyPressed;

	String targetName;

	int field866;

	int type = 76;

	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	public void setType(int var1) {
		this.type = var1;
	}

	public void method461(Widget var1) {
		this.widget = var1;
	}

	static void playJingle(int var0, int var1) {
		if (PacketWriter.clientPreferences.getCurrentMusicVolume() != 0 && var0 != -1) {
			class148.method784(MusicPatchNode.field2782, var0, 0,
					PacketWriter.clientPreferences.getCurrentMusicVolume(), false);
			Client.playingJingle = true;
		}

	}
}
