import java.util.Scanner;

public class ControlBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        biblioteca.registrarLibro(new Libro("El Principito", "Antoine de Saint-Exupéry", "111", 3));
        biblioteca.registrarUsuario(new Estudiante("Carlos Pérez", "E001", "Sistemas"));

        int opcion;
        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Realizar préstamo");
            System.out.println("4. Devolver libro");
            System.out.println("5. Generar reporte");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Ejemplares: ");
                    int ejemplares = sc.nextInt(); sc.nextLine();
                    biblioteca.registrarLibro(new Libro(titulo, autor, isbn, ejemplares));
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Carrera: ");
                    String carrera = sc.nextLine();
                    biblioteca.registrarUsuario(new Estudiante(nombre, id, carrera));
                    break;
                case 3:
                    System.out.print("ISBN del libro: ");
                    String isbnPrestamo = sc.nextLine();
                    System.out.print("ID del usuario: ");
                    String idUsuario = sc.nextLine();
                    biblioteca.realizarPrestamo(isbnPrestamo, idUsuario);
                    break;
                case 4:
                    System.out.print("ISBN del libro: ");
                    String isbnDev = sc.nextLine();
                    System.out.print("ID del usuario: ");
                    String idDev = sc.nextLine();
                    biblioteca.devolverLibro(isbnDev, idDev);
                    break;
                case 5:
                    biblioteca.generarReporte();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
