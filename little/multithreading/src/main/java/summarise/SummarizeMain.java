package summarise;

import java.util.function.Consumer;

public class SummarizeMain {

    public static void main(String[] args) throws InterruptedException {
        summarizeOneThreadStatic();
        summarizeOneThread();
        summarizeTwoThreads();
        doSummWithLog(new Summator(0, Integer.MAX_VALUE), s -> s.setCounter(doSumm(s.getStart(), s.getEnd())),
            "One thread static worked %s millis and got %s\n");
        doSummWithLog(new Summator(0, Integer.MAX_VALUE), s -> {
                Thread th = new Thread(s::summarize);
                th.start();
                try {
                    th.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },
            "One thread worked %s millis and got %s\n");
    }

    private static void doSummWithLog(Summator summator, Consumer<Summator> consumer, String log) {
        long startTime = System.currentTimeMillis();
        consumer.accept(summator);
        long workingTime = System.currentTimeMillis() - startTime;
        System.out.printf(log, workingTime, summator.getCounter());
    }

    private static void summarizeOneThreadStatic() {
        long startTime = System.currentTimeMillis();
        long counter;
        counter = doSumm(0, Integer.MAX_VALUE);
        long workingTime = System.currentTimeMillis() - startTime;
        System.out.println("One thread static worked " + workingTime + " millis and got " + counter);
    }

    private static void summarizeOneThread() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long counter;
        Summator summator = new Summator(0, Integer.MAX_VALUE);
        Thread th = new Thread(summator::summarize);
        th.start();
        th.join();
        counter = summator.counter;
        long workingTime = System.currentTimeMillis() - startTime;
        System.out.println("One thread worked " + workingTime + " millis and got " + counter);
    }

    private static void summarizeTwoThreads() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long counter;

        Summator summator1 = new Summator(0, Integer.MAX_VALUE / 2);
        Summator summator2 = new Summator(Integer.MAX_VALUE / 2 + 1, Integer.MAX_VALUE);

        Thread th1 = new Thread(summator1::summarize);
        Thread th2 = new Thread(summator2::summarize);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        counter = summator1.counter + summator2.counter;
        long workingTime = System.currentTimeMillis() - startTime;
        System.out.println("Two threads worked " + workingTime + " millis and got " + counter);
    }

    private static long doSumm(int start, int end) {
        long counter = 0;
        for (long i = start; i <= end; i++) {
            counter += i;
        }
        return counter;
    }

    private static class Summator {
        private final int start;
        private final int end;
        public long counter = 0;

        Summator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void summarize() {
            for (long i = start; i <= end; i++) {
                counter += i;
            }
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public long getCounter() {
            return counter;
        }

        public void setCounter(long counter) {
            this.counter = counter;
        }
    }
}
