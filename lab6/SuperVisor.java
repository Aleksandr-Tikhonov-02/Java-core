package lab6;


public class SuperVisor implements Runnable {

    private final Program program = new Program();
    private Thread t;

    @Override
    public void run() {
        start();
        while (true) {
            synchronized (program.mutex) {
                try {
                    program.mutex.wait();
                    State state = program.getState();
                    switch (state) {
                        case UNKNOWN, STOPPING -> {
                            System.out.println("---PROGRAM_STOPPED---");
                            stop();
                            System.out.println("---RELOAD_PROGRAM---");
                            start();
                        }
                        case RUNNING -> System.out.println("---PROGRAM_IS_RUNNING---");
                        case FATAL_ERROR -> {
                            System.out.println("---PROGRAM_IS_FATAL_ERROR---");
                            System.out.println("---CLOSING_PROGRAM---");
                            stop();
                            return;
                        }

                    }
                } catch (InterruptedException e) {
                    System.err.println("SV is interrupted");
                }
            }
        }
    }

    public void start() {
        t = new Thread(program);
        t.setDaemon(true);
        t.start();
    }

    public void stop() throws InterruptedException {
        t.interrupt();
        t.join();
    }
}
