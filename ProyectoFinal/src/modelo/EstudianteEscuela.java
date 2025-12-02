package modelo;

public class EstudianteEscuela {

    private String codigo;
    private String nombreCompleto;
    private String escuelaProfesional;
    private boolean esIngresante;

    public EstudianteEscuela(String codigo, String nombreCompleto,
                             String escuelaProfesional, boolean esIngresante) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.escuelaProfesional = escuelaProfesional;
        this.esIngresante = esIngresante;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEscuelaProfesional() {
        return escuelaProfesional;
    }

    public void setEscuelaProfesional(String escuelaProfesional) {
        this.escuelaProfesional = escuelaProfesional;
    }

    public boolean isIngresante() {
        return esIngresante;
    }

    public void setIngresante(boolean esIngresante) {
        this.esIngresante = esIngresante;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-40s | %-35s | %s",
                codigo, nombreCompleto, escuelaProfesional,
                esIngresante ? "Ingresante" : "No Ingresante");
    }
}
