import java.util.concurrent.Semaphore;

public class Semaforo {
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        ThreadPim pim = new ThreadPim();
        ThreadPam pam = new ThreadPam();

        pim.start();
        pam.start();
    }

    static class ThreadPim extends Thread {
        public void run() {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.println("PIM");
                    semaphore.release();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadPam extends Thread {
        public void run() {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.println("PAM");
                    semaphore.release();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
