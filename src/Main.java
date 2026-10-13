import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] tamanos = {1_000, 10_000, 100_000, 1_000_000, 10_000_000, 50_000_000, 200_000_000};
        int busquedas = 2000;

        // Calentamiento de la JVM
        int[] calentamiento = BusquedaArrays.generarArrayOrdenado(10_000);
        for (int i = 0; i < 20_000; i++) {
            BusquedaArrays.busquedaLineal(calentamiento, calentamiento[i % calentamiento.length]);
            Arrays.binarySearch(calentamiento, calentamiento[i % calentamiento.length]);
        }

        System.out.printf("%-12s %-20s %-25s%n", "Tamaño", "Lineal (ns/búsq.)", "binarySearch (ns/búsq.)");
        for (int n : tamanos) {
            int[] array = BusquedaArrays.generarArrayOrdenado(n);
            // Peor caso para la lineal: el último elemento
            int clave = array[n - 1];

            long t0 = System.nanoTime();
            int r1 = -1;
            for (int i = 0; i < busquedas; i++) {
                r1 = BusquedaArrays.busquedaLineal(array, clave);
            }
            long lineal = (System.nanoTime() - t0) / busquedas;

            t0 = System.nanoTime();
            int r2 = -1;
            for (int i = 0; i < busquedas; i++) {
                r2 = Arrays.binarySearch(array, clave);
            }
            long binaria = (System.nanoTime() - t0) / busquedas;

            if (r1 != r2) {
                System.out.println("¡Resultados distintos! " + r1 + " vs " + r2);
            }
            System.out.printf("%-12d %-20d %-25d%n", n, lineal, binaria);
        }
    }
}
