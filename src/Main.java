import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LibroDAO libroDAO = new LibroDAO();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Agregar libro");
            System.out.println("3. Actualizar stock");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    libroDAO.verTodos();
                    break;

                case 2:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = scanner.nextInt();
                    System.out.print("Número de páginas: ");
                    int paginas = scanner.nextInt();
                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();
                    System.out.print("ID del autor: ");
                    int idAutor = scanner.nextInt();
                    System.out.print("ID de categoría: ");
                    int idCategoria = scanner.nextInt();
                    scanner.nextLine();
                    libroDAO.agregar(titulo, isbn, anio, paginas, stock, idAutor, idCategoria);
                    break;

                case 3:
                    System.out.print("ID del libro: ");
                    int idLibro = scanner.nextInt();
                    System.out.print("Nuevo stock: ");
                    int nuevoStock = scanner.nextInt();
                    scanner.nextLine();
                    libroDAO.actualizarStock(idLibro, nuevoStock);
                    break;

                case 4:
                    System.out.print("ID del libro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();
                    libroDAO.eliminar(idEliminar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    System.out.println("✘ Opción no válida.");
            }
        }
        scanner.close();
    }
}