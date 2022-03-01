package lab7;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static BlockingQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Incorrect number of arguments");
            System.exit(1);
        }
        int threadsCount = 0;
        try {
            threadsCount = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The argument should be integer");
            System.exit(1);
        }
        if (threadsCount < 1) {
            System.out.println("The number is incorrect");
            System.exit(1);
        }

        AtomicInteger readersCount = new AtomicInteger();
        AtomicInteger writersCount = new AtomicInteger();

        ExecutorService readers = Executors.newFixedThreadPool(threadsCount, r ->
                new Thread(r, "reader-" + readersCount.incrementAndGet()));
        ExecutorService writers = Executors.newFixedThreadPool(threadsCount, r ->
                new Thread(r, "writer-" + writersCount.incrementAndGet()));

        for (int i = 1; i <= 10; i++) {
            writers.execute(new WriteTask("Message - " + i));
            readers.execute(new ReadTask());
        }

        readers.shutdown();
        writers.shutdown();
    }

    private static class WriteTask implements Runnable {
        String str;

        public WriteTask(String str) {
            this.str = str;
        }

        @Override
        public void run() {
            try {
                queue.put(str);
                System.out.println(Thread.currentThread().getName() + " is writing message: " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ReadTask implements Runnable {
        @Override
        public void run() {
            try {
                String str = queue.take();
                System.out.println(Thread.currentThread().getName() + " has read message: " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
