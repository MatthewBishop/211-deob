public abstract class RouteStrategy {

    public int approxDestinationX;

    public int approxDestinationY;

    public int approxDestinationSizeX;

    public int approxDestinationSizeY;

    public abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

    static final void method1108() {
        Decimator.method306("Your ignore list is full. Max of 100 for free users, and 400 for members");
    }
}
