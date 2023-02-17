import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.net.URL;

public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {

	protected static TaskHandler taskHandler;

	static GameEngine gameEngine = null;

	static int GameEngine_redundantStartThreadCount = 0;

	static long stopTimeMs = 0L;

	static boolean isKilled = false;

	static int cycleDurationMillis = 20;

	static int fiveOrOne = 1;

	protected static int fps = 0;

	static long[] graphicsTickTimes = new long[32];

	static long[] clientTickTimes = new long[32];

	public static int canvasWidth;

	static int field129 = 500;

	static volatile boolean volatileFocus = true;

	protected static boolean hasFocus;

	protected static KeyHandler keyHandler = new KeyHandler();

	static long garbageCollectorLastCollectionTime = -1L;

	static long garbageCollectorLastCheckTimeMs = -1L;

	static Archive archive19;

	boolean hasErrored = false;

	protected int contentWidth;

	protected int contentHeight;

	int canvasX = 0;

	int canvasY = 0;

	int field126;

	int field123;

	int maxCanvasWidth;

	int maxCanvasHeight;

	Frame frame;

	java.awt.Canvas canvas;

	volatile boolean fullRedraw = true;

	boolean resizeCanvasNextFrame = false;

	volatile boolean isCanvasInvalid = false;

	volatile long field130 = 0L;

	MouseWheelHandler mouseWheelHandler;

	Clipboard clipboard;

	final EventQueue eventQueue;

	protected GameEngine() {
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
			;
		}

		this.eventQueue = var1;
		DevicePcmPlayerProvider var2 = new DevicePcmPlayerProvider();
		class157.pcmPlayerProvider = var2;
	}

	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method150();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				Clock.method911(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	protected class170 mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	protected void copyToClipboard(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner) null);
	}

	protected Clipboard getClipboard() {
		return this.clipboard;
	}

	protected final void setUpKeyboard() {
		if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
			class28.KeyHandler_keyCodes[186] = 57;
			class28.KeyHandler_keyCodes[187] = 27;
			class28.KeyHandler_keyCodes[188] = 71;
			class28.KeyHandler_keyCodes[189] = 26;
			class28.KeyHandler_keyCodes[190] = 72;
			class28.KeyHandler_keyCodes[191] = 73;
			class28.KeyHandler_keyCodes[192] = 58;
			class28.KeyHandler_keyCodes[219] = 42;
			class28.KeyHandler_keyCodes[220] = 74;
			class28.KeyHandler_keyCodes[221] = 43;
			class28.KeyHandler_keyCodes[222] = 59;
			class28.KeyHandler_keyCodes[223] = 28;
		} else {
			class28.KeyHandler_keyCodes[44] = 71;
			class28.KeyHandler_keyCodes[45] = 26;
			class28.KeyHandler_keyCodes[46] = 72;
			class28.KeyHandler_keyCodes[47] = 73;
			class28.KeyHandler_keyCodes[59] = 57;
			class28.KeyHandler_keyCodes[61] = 27;
			class28.KeyHandler_keyCodes[91] = 42;
			class28.KeyHandler_keyCodes[92] = 74;
			class28.KeyHandler_keyCodes[93] = 43;
			class28.KeyHandler_keyCodes[192] = 28;
			class28.KeyHandler_keyCodes[222] = 58;
			class28.KeyHandler_keyCodes[520] = 59;
		}

		keyHandler.method92(this.canvas);
	}

	protected final void method152() {
		keyHandler.method93();
	}

	protected void method142(class29 var1, int var2) {
		keyHandler.method90(var1, var2);
	}

	protected final void method143() {
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field126);
			this.contentHeight = Math.max(var2.highY, this.field123);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			class127.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(canvasWidth, class127.canvasHeight);
			KeyHandler.rasterProvider = new RasterProvider(canvasWidth, class127.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var3.left, var3.top + this.canvasY);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.fullRedraw = true;
			this.resizeGame();
		}
	}

	protected abstract void resizeGame();

	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - canvasWidth - var1;
		int var4 = this.contentHeight - class127.canvasHeight - var2;
		if (var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
			try {
				Container var5 = this.container();
				int var6 = 0;
				int var7 = 0;
				if (var5 == this.frame) {
					Insets var8 = this.frame.getInsets();
					var6 = var8.left;
					var7 = var8.top;
				}

				Graphics var10 = var5.getGraphics();
				var10.setColor(Color.black);
				if (var1 > 0) {
					var10.fillRect(var6, var7, var1, this.contentHeight);
				}

				if (var2 > 0) {
					var10.fillRect(var6, var7, this.contentWidth, var2);
				}

				if (var3 > 0) {
					var10.fillRect(var6 + this.contentWidth - var3, var7, var3, this.contentHeight);
				}

				if (var4 > 0) {
					var10.fillRect(var6, var7 + this.contentHeight - var4, this.contentWidth, var4);
				}
			} catch (Exception var9) {
				;
			}
		}

	}

	final void replaceCanvas() {
		keyHandler.method95(this.canvas);
		NewShit.method953(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.method78(this.canvas);
		}

		this.addCanvas();
		keyHandler.method92(this.canvas);
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method150();
	}

	protected final void startThread(int var1, int var2, int var3, int var4) {
		try {
			if (gameEngine != null) {
				++GameEngine_redundantStartThreadCount;
				if (GameEngine_redundantStartThreadCount >= 3) {
					this.error("alreadyloaded");
					return;
				}

				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}

			gameEngine = this;
			canvasWidth = var1;
			class127.canvasHeight = var2;
			RunException.RunException_revision = var3;
			RunException.field4126 = var4;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var6) {
			class121.RunException_sendStackTrace((String) null, var6);
			this.error("crash");
		}

	}

	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		canvasWidth = Math.max(var1.getWidth(), this.field126);
		class127.canvasHeight = Math.max(var1.getHeight(), this.field123);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			canvasWidth -= var2.right + var2.left;
			class127.canvasHeight -= var2.bottom + var2.top;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager) null);
		var1.add(this.canvas);
		this.canvas.setSize(canvasWidth, class127.canvasHeight);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.BLACK);
		if (var1 == this.frame) {
			var2 = this.frame.getInsets();
			this.canvas.setLocation(this.canvasX + var2.left, var2.top + this.canvasY);
		} else {
			this.canvas.setLocation(this.canvasX, this.canvasY);
		}

		this.canvas.addFocusListener(this);
		this.canvas.requestFocus();
		this.fullRedraw = true;
		if (KeyHandler.rasterProvider != null && canvasWidth == KeyHandler.rasterProvider.width
				&& class127.canvasHeight == KeyHandler.rasterProvider.height) {
			((RasterProvider) KeyHandler.rasterProvider).setComponent(this.canvas);
			KeyHandler.rasterProvider.drawFull(0, 0);
		} else {
			KeyHandler.rasterProvider = new RasterProvider(canvasWidth, class127.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field130 = class153.clockNow();
	}

	protected final boolean checkHost() {
		String var1 = this.getDocumentBase().getHost().toLowerCase();
		if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
			if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
				if (var1.endsWith("127.0.0.1")) {
					return true;
				} else {
					while (var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0'
							&& var1.charAt(var1.length() - 1) <= '9') {
						var1 = var1.substring(0, var1.length() - 1);
					}

					if (var1.endsWith("192.168.1.")) {
						return true;
					} else {
						this.error("invalidhost");
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	void clientTick() {
		long var1 = class153.clockNow();
		long var3 = clientTickTimes[ReflectionCheck.field172];
		clientTickTimes[ReflectionCheck.field172] = var1;
		ReflectionCheck.field172 = ReflectionCheck.field172 + 1 & 31;
		if (0L != var3 && var1 > var3) {
			;
		}

		synchronized (this) {
			hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	void graphicsTick() {
		Container var1 = this.container();
		long var2 = class153.clockNow();
		long var4 = graphicsTickTimes[class20.field69];
		graphicsTickTimes[class20.field69] = var2;
		class20.field69 = class20.field69 + 1 & 31;
		if (0L != var4 && var2 > var4) {
			int var6 = (int) (var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field129 - 1 > 50) {
			field129 -= 50;
			this.fullRedraw = true;
			this.canvas.setSize(canvasWidth, class127.canvasHeight);
			this.canvas.setVisible(true);
			if (var1 == this.frame) {
				Insets var7 = this.frame.getInsets();
				this.canvas.setLocation(var7.left + this.canvasX, this.canvasY + var7.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}
		}

		if (this.isCanvasInvalid) {
			this.replaceCanvas();
		}

		this.method149();
		this.draw(this.fullRedraw);
		if (this.fullRedraw) {
			this.clearBackground();
		}

		this.fullRedraw = false;
	}

	final void method149() {
		Bounds var1 = this.getFrameContentBounds();
		if (var1.highX != this.contentWidth || var1.highY != this.contentHeight || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	final void method150() {
		this.resizeCanvasNextFrame = true;
	}

	final synchronized void kill() {
		if (!isKilled) {
			isKilled = true;

			try {
				this.canvas.removeFocusListener(this);
			} catch (Exception var5) {
				;
			}

			try {
				this.kill0();
			} catch (Exception var4) {
				;
			}

			if (this.frame != null) {
				try {
					System.exit(0);
				} catch (Throwable var3) {
					;
				}
			}

			if (taskHandler != null) {
				try {
					taskHandler.close();
				} catch (Exception var2) {
					;
				}
			}

			this.vmethod1485();
		}
	}

	protected abstract void setUp();

	protected abstract void doCycle();

	protected abstract void draw(boolean var1);

	protected abstract void kill0();

	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (class1.fontHelvetica13 == null) {
				class1.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				class153.loginScreenFontMetrics = this.canvas.getFontMetrics(class1.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, canvasWidth, class127.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (class364.field3574 == null) {
					class364.field3574 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = class364.field3574.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(class1.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - class153.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(class364.field3574, canvasWidth / 2 - 152, class127.canvasHeight / 2 - 18,
						(ImageObserver) null);
			} catch (Exception var9) {
				int var7 = canvasWidth / 2 - 152;
				int var8 = class127.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(class1.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - class153.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	protected final void method165() {
		class364.field3574 = null;
		class1.fontHelvetica13 = null;
		class153.loginScreenFontMetrics = null;
	}

	protected void error(String var1) {
		if (!this.hasErrored) {
			this.hasErrored = true;
			System.out.println("error_game_" + var1);

			try {
				this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"),
						"_self");
			} catch (Exception var3) {
				;
			}

		}
	}

	Container container() {
		return (Container) (this.frame != null ? this.frame : this);
	}

	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field126);
		int var3 = Math.max(var1.getHeight(), this.field123);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.right + var4.left;
			var3 -= var4.top + var4.bottom;
		}

		return new Bounds(var2, var3);
	}

	protected final boolean hasFrame() {
		return this.frame != null;
	}

	protected abstract void vmethod1485();

	public final void destroy() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = class153.clockNow();
			Clock.method911(5000L);
			this.kill();
		}
	}

	public final synchronized void paint(Graphics var1) {
		if (this == gameEngine && !isKilled) {
			this.fullRedraw = true;
			if (class153.clockNow() - this.field130 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= canvasWidth && var2.height >= class127.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void start() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	public final void stop() {
		if (this == gameEngine && !isKilled) {
			stopTimeMs = class153.clockNow() + 4000L;
		}
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.fullRedraw = true;
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public abstract void init();

	public void run() {
		try {
			if (TaskHandler.javaVendor != null) {
				String var1 = TaskHandler.javaVendor.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = TaskHandler.javaVersion;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.")
							|| var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4")
							|| var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.")
							|| var2.equals("1.6.0")) {
						this.error("wrongjava");
						return;
					}

					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length() && CollisionMap.isDigit(var2.charAt(var3)); ++var3) {
							;
						}

						String var4 = var2.substring(6, var3);
						if (class142.isNumber(var4) && WorldMapScaleHandler.method1502(var4) < 10) {
							this.error("wrongjava");
							return;
						}
					}

					fiveOrOne = 5;
				}
			}

			this.setFocusCycleRoot(true);
			this.addCanvas();
			this.setUp();
			class177.clock = class161.method857();

			while (0L == stopTimeMs || class153.clockNow() < stopTimeMs) {
				InterfaceParent.gameCyclesToDo = class177.clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < InterfaceParent.gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			class121.RunException_sendStackTrace((String) null, var6);
			this.error("crash");
		}

		this.kill();
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}
}
