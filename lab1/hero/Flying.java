package lab1.hero;

public class Flying implements RouteStrategy {
    @Override
    public void move() {
        System.out.println("I am flying");
    }
}
