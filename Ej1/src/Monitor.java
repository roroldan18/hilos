public class Monitor {
    private boolean esTurnoPim = true;


    public synchronized void imprimirPim() throws InterruptedException {
        while (!esTurnoPim) {
            wait();
        }
        System.out.println("PIM");
        esTurnoPim = false;
        notify();
    }

    public synchronized void imprimirPam() throws InterruptedException {
        while (esTurnoPim) {
            wait();
        }
        System.out.println("PAM");
        esTurnoPim = true;
        notify();
    }

}
