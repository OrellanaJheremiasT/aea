package datos;

import modelo.Rendimiento;
import java.io.*;

public class RendimientoDAO {
    private final String RUTA = "src/data/matriculados.txt";
    private Rendimiento [] arreglo = new Rendimiento[5000];
    private int contador = 0;
    
    public RendimientoDAO(){
        cargarDatos();
    }
    
    private void cargarDatos(){
        try(BufferedReader br = new BufferedReader(new FileReader(RUTA))){
            String linea;
            br.readLine();
            
            while ((linea = br.readLine())!=null){
                String[] p = linea.split("\\s{2,}");
                
                if (p.length >= 15) {
                    String programa = p[2].trim();
                    int creditos = Integer.parseInt(p[8].trim());
                    double promedio = Double.parseDouble(p[11].trim());
                    arreglo[contador++] = new Rendimiento(programa, promedio, creditos);
                }
            }
        } catch (Exception e) { }
    }

    public Rendimiento[] obtenerTodos() { return arreglo; }
    public int getTotal() { return contador; }
}
