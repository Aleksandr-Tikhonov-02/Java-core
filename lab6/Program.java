package lab6;

public class Program implements Runnable {
    private State state = State.UNKNOWN;
    public final Object mutex = new Object();

    @Override
    public void run() {
        while (!Thread.interrupted()) {

            synchronized (mutex) {
                int state = (int)(Math.random() * 5);
                switch (state) {
                    case 0 -> {
                        this.state = State.FATAL_ERROR;
                        System.out.println("Program is fatal error");
                    }
                    case 1 -> {
                        this.state = State.UNKNOWN;
                        System.out.println("Program is unknown state");
                    }
                    case 2 ->  {
                        this.state = State.STOPPING;
                        System.out.println("Program is stopped");
                    }
                    default -> {
                        this.state = State.RUNNING;
                        System.out.println("Program is running");
                    }
                }
                mutex.notify();
            }
        }
    }

    public State getState() {
        return state;
    }

}
