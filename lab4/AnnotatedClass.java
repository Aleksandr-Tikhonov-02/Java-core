package lab4;

public class AnnotatedClass {

    @TimesToInvoke(number = 3)
    public static void printHelloWorld() {
        System.out.println("Hello, World!");
    }

    @TimesToInvoke(number = 2)
    private static void printHello() {
        System.out.println("Hello");
    }

    @TimesToInvoke(number = 5)
    private static void askWhatIsYourName(String str) {
        System.out.println("You name is " + str);
    }

    private static void askHowAreYou() {
        System.out.println("How are you?");
    }
}
