import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WorldMapAreaData extends WorldMapArea {

	static Scene scene;

	HashSet worldMapData0Set;

	HashSet worldMapData1Set;

	List iconList;

	void init(Buffer var1, Buffer var2, int var3, boolean var4) {
		this.read(var1, var3);
		int var5 = var2.readUnsignedShort();
		this.worldMapData0Set = new HashSet(var5);

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			WorldMapData_0 var7 = new WorldMapData_0();

			try {
				var7.init(var2);
			} catch (IllegalStateException var12) {
				continue;
			}

			this.worldMapData0Set.add(var7);
		}

		var6 = var2.readUnsignedShort();
		this.worldMapData1Set = new HashSet(var6);

		for (int var10 = 0; var10 < var6; ++var10) {
			WorldMapData_1 var8 = new WorldMapData_1();

			try {
				var8.init(var2);
			} catch (IllegalStateException var11) {
				continue;
			}

			this.worldMapData1Set.add(var8);
		}

		this.initIconsList(var2, var4);
	}

	void initIconsList(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.readUnsignedShort();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.method2419();
			Coord var6 = new Coord(var1.readInt());
			boolean var7 = var1.readUnsignedByte() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord) null, var6, var5, (WorldMapLabel) null));
			}
		}

	}

	public static void runScriptEvent(ScriptEvent var0) {
		ItemLayer.runScript(var0, 500000, 475000);
	}

	static void method1487() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			class70.setLoginResponseString("Please enter your username.", "If you created your account after November",
					"2010, this will be the creation email address.");
		} else {
			long var1 = class70.method418();
			int var0;
			if (0L == var1) {
				var0 = 5;
			} else {
				var0 = Ignored.method2123(var1, Login.Login_username);
			}

			switch (var0) {
			case 2:
				class70.setLoginResponseString(Strings.field3185, Strings.field3360, Strings.field3361);
				ReflectionCheck.method171(6);
				break;
			case 3:
				class70.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				class70.setLoginResponseString("The part of the website you are trying",
						"to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				class70.setLoginResponseString("Sorry, there was an error trying to",
						"log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				class70.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				class70.setLoginResponseString("You must enter a valid login to proceed. For accounts",
						"created after 24th November 2010, please use your",
						"email address. Otherwise please use your username.");
			}

		}
	}
}
