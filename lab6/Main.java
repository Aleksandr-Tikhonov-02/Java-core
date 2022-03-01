package lab6;

public class Main {
    public static void main(String[] args) {
       Thread t = new Thread(new SuperVisor());
       t.start();
    }
}
