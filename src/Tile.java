public final class Tile extends Node {

	int plane;

	int x;

	int y;

	int originalPlane;

	SceneTilePaint paint;

	SceneTileModel model;

	BoundaryObject boundaryObject;

	WallDecoration wallDecoration;

	FloorDecoration floorDecoration;

	ItemLayer itemLayer;

	int gameObjectsCount;

	GameObject[] gameObjects = new GameObject[5];

	int[] gameObjectEdgeMasks = new int[5];

	int gameObjectsEdgeMask = 0;

	int minPlane;

	boolean drawPrimary;

	boolean drawSecondary;

	boolean drawGameObjects;

	int drawGameObjectEdges;

	int field1954;

	int field1944;

	int field1959;

	Tile linkedBelowTile;

	Tile(int var1, int var2, int var3) {
		this.originalPlane = this.plane = var1;
		this.x = var2;
		this.y = var3;
	}
}
