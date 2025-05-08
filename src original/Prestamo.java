import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private final Libro libro;
    private final Usuario usuario;
    private final LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public void devolver() {
        this.fechaDevolucion = LocalDate.now();
        libro.devolverEjemplar();
    }

    public long calcularMulta() {
        if (fechaDevolucion == null) return 0;
        long dias = ChronoUnit.DAYS.between(fechaPrestamo.plusDays(7), fechaDevolucion);
        return dias > 0 ? dias * 10 : 0;
    }

    public boolean estaActivo() {
        return fechaDevolucion == null;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return usuario.getNombre() + " - " + libro.getTitulo() + 
               " | Prestado: " + fechaPrestamo + 
               (estaActivo() ? " | ACTIVO" : " | Devuelto: " + fechaDevolucion + 
               " | Multa: $" + calcularMulta());
    }
}
