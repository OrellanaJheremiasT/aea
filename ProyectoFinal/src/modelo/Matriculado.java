package modelo;

public class Matriculado {
    private String programa;
    private String modalidad;
    private String fechamatricula;
    
    public Matriculado (String programa, String modalidad, String fechamatricula){
        this.programa=programa;
        this.modalidad=modalidad;
        this.fechamatricula=fechamatricula;
    }
    public String getPrograma() { return programa; }
    public String getModalidad() { return modalidad; }
    public String getFechamatricula() { return fechamatricula; }
    
    @Override
    public String toString() {
        return String.format("%-30s | %-40s | %-6s", programa, modalidad, fechamatricula);
    }
}
