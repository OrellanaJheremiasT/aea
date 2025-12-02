package modelo;

public class Postulante {
    private String especialidad;
    private String sexo;
    private String ingreso;
    
    public Postulante(String especialidad, String sexo, String ingreso) {
        this.especialidad = especialidad;
        this.sexo = sexo;
        this.ingreso = ingreso;
    }
    
    public String getEspecialidad() { return especialidad; }
    public String getSexo() { return sexo; }
    public String getIngreso() { return ingreso; }
    
    @Override
    public String toString() {
        return String.format("%-30s | %-6s | %-3s", especialidad, sexo, ingreso);
    }

  
}
