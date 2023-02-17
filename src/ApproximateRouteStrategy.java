public class ApproximateRouteStrategy extends RouteStrategy {

	public static int[] SpriteBuffer_yOffsets;

	static Archive archive10;

	public boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}
}
