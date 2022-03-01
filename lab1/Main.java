package lab1;

import lab1.hero.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.startMoving();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose type of moving or enter \"end\" to stop program");
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str.equals("end")) {
                break;
            }
            switch (str) {
                case "Flying" -> { hero.setRouteStrategy(new Flying()); hero.startMoving(); }
                case "RidingHorse" -> { hero.setRouteStrategy(new RidingHorse()); hero.startMoving(); }
                case "Walking" -> { hero.setRouteStrategy(new Walking()); hero.startMoving(); }
                default -> { System.out.println("Expected type of moving"); }
            }
        }
    }
}
