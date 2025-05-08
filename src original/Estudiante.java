public class Estudiante extends Usuario {
    private String carrera;

    public Estudiante(String nombre, String id, String carrera) {
        super(nombre, id);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String getTipo() {
        return "Estudiante";
    }
}
