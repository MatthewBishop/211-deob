import java.awt.Component;
import java.awt.Graphics;
import java.util.Iterator;

public final class Canvas extends java.awt.Canvas {

	static Iterator field78;

	static IndexedSprite field79;

	static Archive field75;

	static int field77;

	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	static LoginPacket[] method82() {
		return new LoginPacket[] { LoginPacket.RECONNECT_LOGIN_CONNECTION, LoginPacket.field2681, LoginPacket.field2682,
				LoginPacket.NEW_LOGIN_CONNECTION, LoginPacket.field2677, LoginPacket.field2678 };
	}
}
