public class class88 {

	static World[] World_worlds;

	public static void method495(AbstractArchive var0) {
		FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
	}

	static float[] method494(JSONObject var0, String var1) throws JSONException {
		float[] var2 = new float[4];

		try {
			JSONArray var3 = var0.getJSONArray(var1);
			var2[0] = (float) var3.optDouble(0, 0.0D);
			var2[1] = (float) var3.optDouble(1, 0.0D);
			var2[2] = (float) var3.optDouble(2, 1.0D);
			var2[3] = (float) var3.optDouble(3, 1.0D);
		} catch (JSONException var4) {
			var2[0] = 0.0F;
			var2[1] = 0.0F;
			var2[2] = 1.0F;
			var2[3] = 1.0F;
		}

		return var2;
	}
}
