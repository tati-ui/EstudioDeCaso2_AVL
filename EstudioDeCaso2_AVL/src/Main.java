import java.util.Scanner;

/**
 * Clase principal que contiene el menú interactivo
 * para manipular el Árbol AVL.
 *
 * Permite:
 * - Insertar valores
 * - Eliminar valores
 * - Buscar valores
 * - Mostrar recorrido en orden
 * - Mostrar estructura del árbol
 */
public class Main {

    /**
     * Método de entrada del programa.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AVL arbol = new AVL();

        int opcion;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    System.out.print("Ingrese un número a insertar: ");
                    int valor = sc.nextInt();
                    arbol.insertar(valor);
                    System.out.println("✔ Valor insertado.\n");
                }

                case 2 -> {
                    System.out.print("Ingrese un número a eliminar: ");
                    int valor = sc.nextInt();
                    if (arbol.buscar(valor)) {
                        arbol.eliminar(valor);
                        System.out.println("✔ Valor eliminado.\n");
                    } else {
                        System.out.println("✘ El valor no existe.\n");
                    }
                }

                case 3 -> {
                    System.out.print("Ingrese un número a buscar: ");
                    int valor = sc.nextInt();
                    if (arbol.buscar(valor))
                        System.out.println("✔ El valor SÍ está en el árbol.\n");
                    else
                        System.out.println("✘ El valor NO existe.\n");
                }

                case 4 -> {
                    System.out.println("\n--- Recorrido en Orden ---");
                    arbol.imprimirEnOrden();
                    System.out.println("---------------------------\n");
                }

                case 5 -> {
                    System.out.println("\n--- Estructura del Árbol ---");
                    arbol.imprimirDetalles();
                    System.out.println("-----------------------------\n");
                }

                case 6 -> {
                    System.out.println("Saliendo...");
                }

                default -> System.out.println("Opción inválida.\n");
            }

        } while (opcion != 6);

        sc.close();
    }

    /**
     * Muestra el menú principal del programa.
     */
    public static void mostrarMenu() {
        System.out.println("           MENÚ ÁRBOL AVL             ");
        System.out.println("1. Insertar un valor");
        System.out.println("2. Eliminar un valor");
        System.out.println("3. Buscar un valor");
        System.out.println("4. Mostrar recorrido en orden");
        System.out.println("5. Mostrar detalles del árbol");
        System.out.println("6. Salir");
    }
}

