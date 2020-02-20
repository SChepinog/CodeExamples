package summarise;

public class SummarizeMain {

    public static void main(String[] args) throws InterruptedException {
        summarizeOneThreadStatic();
        summarizeOneThread();
        summarizeTwoThreads();
    }

    private static void summarizeOneThreadStatic() {
        long startTime = System.currentTimeMillis();
        long counter = 0;
        counter = doSumm(0, Integer.MAX_VALUE);
        long workingTime = System.currentTimeMillis() - startTime;
        System.out.println("One thread static worked " + workingTime + " millis and got " + counter);
    }

    private static void summarizeOneThread() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long counter = 0;
        Summator summator = new Summator(0, Integer.MAX_VALUE);
        Thread th = new Thread(() -> {
            summator.summarize();
        });
        th.start();
        th.join();
        counter = summator.counter;
        long workingTime = System.currentTimeMillis() - startTime;
        System.out.println("One thread worked " + workingTime + " millis and got " + counter);
    }

    private static void summarizeTwoThreads() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long counter = 0;

        Summator summator1 = new Summator(0, Integer.MAX_VALUE / 2);
        Summator summator2 = new Summator(Integer.MAX_VALUE / 2 + 1, Integer.MAX_VALUE);

        Thread th1 = new Thread(() -> {
            summator1.summarize();
        });
        Thread th2 = new Thread(() -> {
            summator2.summarize();
        });
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
        private long start;
        private long end;
        public long counter = 0;

        Summator(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public void summarize() {
            for (long i = start; i <= end; i++) {
                counter += i;
            }
        }
    }
}
