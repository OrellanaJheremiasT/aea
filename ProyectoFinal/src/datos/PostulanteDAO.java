package datos;

import modelo.Postulante;
import java.io.*;

public class PostulanteDAO {
    private final String RUTA = "src/data/postulantes.txt";
    private Postulante[] arreglo = new Postulante[5000];
    private int contador = 0;

    public PostulanteDAO() {
        cargarDatos();
    }

    private void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            String linea;
            br.readLine(); // omitir cabecera
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length >= 16) {
                    String especialidad = p[5].trim();
                    String sexo = p[13].trim();
                    String ingreso = p[15].trim();
                    arreglo[contador++] = new Postulante(especialidad, sexo, ingreso);
                }
            }
        } catch (Exception e) { }
    }

    public Postulante[] obtenerTodos() { return arreglo; }
    public int getTotal() { return contador; }
}
