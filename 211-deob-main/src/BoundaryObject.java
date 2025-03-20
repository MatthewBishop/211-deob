public final class BoundaryObject {

	static String field2196;

	int z;

	int x;

	int y;

	int orientationA;

	int orientationB;

	public Renderable renderable1;

	public Renderable renderable2;

	public long tag = 0L;

	int flags = 0;

	static final void method1300() {
		class275.method1525(WorldMapRegion.field2281, PacketWriter.field1136, WorldMapDecoration.field2367);
		FloorOverlayDefinition.method1048(class135.field1289, class16.field56);
		if (ClanSettings.cameraX == WorldMapRegion.field2281 && UserComparator10.cameraY == PacketWriter.field1136
				&& WorldMapDecoration.field2367 == class366.cameraZ && class135.field1289 == class103.cameraPitch
				&& class16.field56 == class285.cameraYaw) {
			Client.field631 = false;
			Client.isCameraLocked = false;
			WorldMapData_0.cameraLookAtX = 0;
			Players.cameraLookAtY = 0;
			FloorOverlayDefinition.cameraLookAtHeight = 0;
			Message.cameraLookAtSpeed = 0;
			AttackOption.cameraLookAtAcceleration = 0;
			UserComparator7.cameraMoveToAcceleration = 0;
			ModeWhere.cameraMoveToSpeed = 0;
			Occluder.cameraMoveToX = 0;
			class108.cameraMoveToY = 0;
			class10.cameraMoveToHeight = 0;
		}

	}
}
