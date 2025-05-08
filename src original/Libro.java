public class Libro {
    private final String titulo;
    private final String autor;
    private final String ISBN;
    private int ejemplaresDisponibles;

    public Libro(String titulo, String autor, String ISBN, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.ejemplaresDisponibles = ejemplares;
    }

    public boolean prestarEjemplar() {
        if (ejemplaresDisponibles > 0) {
            ejemplaresDisponibles--;
            return true;
        }
        return false;
    }

    public void devolverEjemplar() {
        ejemplaresDisponibles++;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getISBN() { return ISBN; }
    public int getEjemplaresDisponibles() { return ejemplaresDisponibles; }
}
