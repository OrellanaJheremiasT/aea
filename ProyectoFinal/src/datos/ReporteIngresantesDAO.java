package datos;

import java.io.*;
import modelo.ReporteIngresantes;

public class ReporteIngresantesDAO {

    private final String RUTA = "src/data/reporte_ingresantes.txt";

    private ReporteIngresantes[] arreglo = new ReporteIngresantes[100];
    private int contador = 0;

    public ReporteIngresantesDAO() {
        cargarDatos();
    }

    private void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] p = linea.split(",");

                if (p.length >= 2) {
                    int ingresantes = Integer.parseInt(p[0].trim());
                    int noIngresantes = Integer.parseInt(p[1].trim());

                    arreglo[contador++] = new ReporteIngresantes(ingresantes, noIngresantes);
                }
            }

        } catch (Exception e) { }
    }

    public void agregar(ReporteIngresantes rep) {
        if (contador < arreglo.length) {
            arreglo[contador++] = rep;

            try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA, true))) {
                pw.println(rep.getTotalIngresantes() + "," + rep.getTotalNoIngresantes());
            } catch (Exception e) { }
        }
    }

    public void mostrarTodos() {
        for (int i = 0; i < contador; i++) {
            System.out.println(arreglo[i]);
        }
    }

    public ReporteIngresantes obtener(int index) {
        if (index >= 0 && index < contador) {
            return arreglo[index];
        }
        return null;
    }

    public int getTotal() {
        return contador;
    }
}
