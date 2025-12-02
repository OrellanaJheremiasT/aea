package modelo;

public class Rendimiento {
    private String programa;
    private double promedio;
    private int creditos;
    
    
    public Rendimiento(String programa, double promedio, int creditos){
        this.creditos = creditos;
        this.programa = programa;
        this.promedio = promedio;
    }
    
    public String getPrograma(){return programa;}
    public double getPromedio(){return promedio;}
    public int getCreditos(){return creditos;}
    
    @Override
    public String toString(){
        return String.format("%-40 | Promedio: %-5.2f | Creditos: %-3d", programa, promedio, creditos);
    
    }
    
}
