import java.util.concurrent.Future;

public class class18 {

	public static BufferedFile[] JagexCache_idxFiles;

	static int[] field58;

	static Widget field60;

	Future field59;

	String field61;

	class18(Future var1) {
		this.field59 = var1;
	}

	class18(String var1) {
		this.method68(var1);
	}

	void method68(String var1) {
		if (var1 == null) {
			var1 = "";
		}

		this.field61 = var1;
		if (this.field59 != null) {
			this.field59.cancel(true);
			this.field59 = null;
		}

	}

	public final String method69() {
		return this.field61;
	}

	public boolean method72() {
		return this.field61 != null || this.field59 == null;
	}

	public final boolean method70() {
		return this.method72() ? true : this.field59.isDone();
	}

	public final class20 method71() {
		if (this.method72()) {
			return new class20(this.field61);
		} else if (!this.method70()) {
			return null;
		} else {
			try {
				return (class20) this.field59.get();
			} catch (Exception var3) {
				String var2 = "Error retrieving REST request reply";
				System.err.println(var2 + "\r\n" + var3);
				this.method68(var2);
				return new class20(var2);
			}
		}
	}

	static void Widget_runOnTargetLeave() {
		if (Client.isSpellSelected) {
			Widget var0 = class135.getWidgetChild(class9.selectedSpellWidget, Client.selectedSpellChildIndex);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				WorldMapAreaData.runScriptEvent(var1);
			}

			Client.selectedSpellItemId = -1;
			Client.isSpellSelected = false;
			LoginScreenAnimation.invalidateWidget(var0);
		}
	}
}
