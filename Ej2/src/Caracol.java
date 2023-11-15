class Caracol implements Runnable {
    private String nombre;
    private int posicion;
    private Caracol[] caracoles;

    public Caracol(String nombre, int posicion, Caracol[] caracoles) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.caracoles = caracoles;
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (true) {
                    if (posicion != Carrera.turnoActual) {
                        // Esperar a que sea el turno del caracol
                        wait();
                    } else {
                        break;
                    }
                }

                System.out.println(nombre + " comienza la carrera.");

                // Simular el tiempo que tarda en correr
                int tiempo = (int) (Math.random() * 11) + 20;
                Thread.sleep(tiempo * 1000);

                System.out.println(nombre + " ha terminado en " + tiempo + " segundos.");

                if (nombre.charAt(nombre.length() - 1) != '4') {
                    // Pasar la banderita al siguiente caracol
                    System.out.println(nombre + " pasa la banderita al siguiente caracol.");
                    Carrera.turnoActual++;

                    // Notificar a todos los caracoles que pueden intentar avanzar
                    for (Caracol c : caracoles) {
                        synchronized (c) {
                            c.notify();
                        }
                    }
                } else {
                    // Reiniciar la carrera después de que el cuarto caracol ha terminado
                    Carrera.turnoActual = 1;
                    System.out.println("Reiniciando la carrera.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}