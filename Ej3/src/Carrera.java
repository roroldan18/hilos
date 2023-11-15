/**
 *
 * Implementar una carrera de caracoles motorizados.
 * Tenemos 8 Caracoles dispuestos a correr, cada uno tiene un dorsal.
 * Todos los Caracoles comienzan, pero se quedan parados esperando el pistoletazo de salida de la clase
 * Carrera y tardan entre 5 y 10 segundos en acabar la carrera. Cuando acaban la carrera, notifican a la misma con su dorsal y terminan.
 * Tenemos una clase principal Carrera que indica el pistoletazo de salida y el resultado de la carrera.
 * La Carrera escribe “preparados” y espera 1s, luego escribe “listos” y espera 1s y finalmente escribe “ya!” y notifica a los hilos de los Caracoles.
 * Cuando los caracoles notifican que han acabado se va a escribir por consola un mensaje indicando que el caracol del dorsal X ha acabado la carrera en YYYY segundos.
 */

public class Carrera {
    public static boolean carreraIniciada = false;

    public static void main(String[] args) {
        // Creo un array de 8 caracoles
        Caracol[] caracoles = new Caracol[8];

        // Creo los caracoles
        for (int i = 0; i < caracoles.length; i++) {
            caracoles[i] = new Caracol("Caracol " + (i + 1));
        }

        // Iniciar la carrera en hilos separados
        for (Caracol caracol : caracoles) {
            new Thread(caracol).start();
        }
        esperarUnSeg();
        // Iniciar la carrera
        System.out.println("Preparados...");
        esperarUnSeg();
        System.out.println("Listos...");
        esperarUnSeg();
        System.out.println("Ya!");

        // Notificar a los caracoles que pueden empezar a correr
        synchronized (Carrera.class) {
            carreraIniciada = true;
            Carrera.class.notifyAll();
        }

    }

    public static void esperarUnSeg() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}