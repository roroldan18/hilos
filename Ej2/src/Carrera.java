public class Carrera {

    public static int turnoActual = 1;

    public static void main(String[] args) {
        // Creo un array de 4 caracoles
        Caracol[] caracoles = new Caracol[4];

        // Creo los caracoles 1, 2, 3 y 4
        for (int i = 0; i < caracoles.length; i++) {
            caracoles[i] = new Caracol("Caracol " + (i + 1), i + 1, caracoles);
        }

        // Iniciar la carrera en hilos separados
        for (Caracol caracol : caracoles) {
            new Thread(caracol).start();
        }
    }
}