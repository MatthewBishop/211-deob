public class class303 {

	static AbstractArchive HealthBarDefinition_archive;

	static int timeOfPreviousKeyPress;

	static final String method1629(int var0) {
		if (var0 < 100000) {
			return "<col=ffff00>" + var0 + "</col>";
		} else {
			return var0 < 10000000 ? "<col=ffffff>" + var0 / 1000 + "K" + "</col>"
					: "<col=00ff80>" + var0 / 1000000 + "M" + "</col>";
		}
	}
}
