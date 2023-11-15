public class ThreadPam extends Thread {
    private Monitor monitor;

    public ThreadPam(Monitor monitor) {
        this.monitor = monitor;
    }

    public void run() {
        while (true) {
            try {
                monitor.imprimirPam();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
