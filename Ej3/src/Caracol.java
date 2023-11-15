class Caracol implements Runnable {
    private String nombre;

    public Caracol(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            synchronized (Carrera.class) {
                while (!Carrera.carreraIniciada) {
                    System.out.println(nombre + " está esperando a que comience la carrera.");
                    // Esperar a que comience la carrera
                    Carrera.class.wait();
                }
            }

                System.out.println(nombre + " comienza la carrera.");

                // Simular el tiempo que tarda en correr
                int tiempo = (int) (Math.random() * 6) + 5;
                Thread.sleep(tiempo * 1000);

                System.out.println(nombre + " ha terminado en " + tiempo + " segundos.");

            } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}