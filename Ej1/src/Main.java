/**
 *
 * Crear un programa mediante hilos. Se deben crear 2 hilos, uno debe escribir en la
 * consola PIM y el otro PAM. Cada vez que uno de los dos hilos escriba en consola,
 * debe dormir durante un segundo.
 *  Haz el ejercicio sin ningún tipo de monitor y añade en el pdf la captura de la
 * consola
 *  Haz el mismo ejercicio, pero utilizando un monitor para que se escriba de
 * forma repetida PIM PAM y añade en el pdf la captura de la consola.
 *  Realizar el mismo ejercicio, pero con un semáforo (OPCIONAL para el 10)
 */

public class Main {
    public static void main(String[] args) {

        Monitor monitor = new Monitor();

        ThreadPim pim = new ThreadPim(monitor);
        ThreadPam pam = new ThreadPam(monitor);

        pim.start();
        pam.start();

    }
}