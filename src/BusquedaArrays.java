import java.util.Random;

public class BusquedaArrays {

    /** Búsqueda lineal manual: devuelve el índice del primer elemento igual a clave, o -1. */
    public static int busquedaLineal(int[] array, int clave) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == clave) {
                return i;
            }
        }
        return -1;
    }

    /** Genera un array ordenado (estrictamente creciente) de tamaño dado con incrementos aleatorios. */
    public static int[] generarArrayOrdenado(int tamano) {
        Random random = new Random();
        int[] array = new int[tamano];
        int valor = 0;
        for (int i = 0; i < tamano; i++) {
            valor += 1 + random.nextInt(10);
            array[i] = valor;
        }
        return array;
    }
}
