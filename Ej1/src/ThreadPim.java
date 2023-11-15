public class ThreadPim extends Thread {
    private Monitor monitor;

    public ThreadPim(Monitor monitor) {
        this.monitor = monitor;
    }

    public void run() {
        while (true) {
            try {
                monitor.imprimirPim();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

