package lab1.hero;

public class Walking implements RouteStrategy {
    @Override
    public void move() {
        System.out.println("I am walking");
    }
}
