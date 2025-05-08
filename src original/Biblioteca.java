import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Libro> inventario = new ArrayList<>();
    private final List<Prestamo> prestamos = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();

    public void registrarLibro(Libro libro) {
        inventario.add(libro);
    }

    public Libro buscarLibro(String ISBN) {
        return inventario.stream()
                .filter(libro -> libro.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario(String idUsuario) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(idUsuario))
                .findFirst()
                .orElse(null);
    }

    public void realizarPrestamo(String ISBN, String idUsuario) {
        Libro libro = buscarLibro(ISBN);
        Usuario usuario = buscarUsuario(idUsuario);

        if (libro != null && usuario != null && libro.prestarEjemplar()) {
            Prestamo prestamo = new Prestamo(libro, usuario);
            prestamos.add(prestamo);
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No se puede realizar el préstamo.");
        }
    }

    public void devolverLibro(String ISBN, String idUsuario) {
        for (Prestamo p : prestamos) {
            if (p.estaActivo() &&
                p.getLibro().getISBN().equals(ISBN) &&
                p.getUsuario().getId().equals(idUsuario)) {
                p.devolver();
                System.out.println("Libro devuelto.");
                return;
            }
        }
        System.out.println(" Préstamo no encontrado.");
    }

    public void generarReporte() {
        System.out.println("\n--- Reporte de Préstamos ---");
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
}
