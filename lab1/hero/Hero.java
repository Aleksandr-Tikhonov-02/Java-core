package lab1.hero;

public class Hero {
    protected RouteStrategy routeStrategy;
    {
        routeStrategy = new Walking();
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void startMoving() {
        routeStrategy.move();
    }
}
