import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Metodos metodos = new Metodos();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Elige una opción:");
            System.out.println("1. Alta de Producto");
            System.out.println("2. Borrar Producto");
            System.out.println("3 Modificar Producto");
            System.out.println("4. Mostrar lista de productos");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    metodos.alta();
                    break;
                case 2:
                    metodos.borrar();
                    break;
                case 3:
                    metodos.modificar();
                    break;
                case 4:
                     metodos.mostrar();
                     break;
                case 0:
                     System.out.println("Saliendo del programa.");
                     break;
                default:
                    System.out.println("Opción no válida. Introduce una opción válida.");
            }
        } while (opcion != 0);

    }
}