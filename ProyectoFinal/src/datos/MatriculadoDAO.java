package datos;
import java.io.BufferedReader;
import java.io.FileReader;
import modelo.Matriculado;

public class MatriculadoDAO {

    private final String RUTA = "src/data/matriculados.txt";

    private Matriculado[] matriculados = new Matriculado[5000];
    private int contador = 0;

    public MatriculadoDAO() {
        cargarDatos();
    }

    private void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            String linea;

            br.readLine();

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) continue;

                String[] p = linea.split("\\s{2,}");

                if (p.length >= 6 && contador < matriculados.length) {
                    String programa = p[2].trim();
                    String modalidad = p[3].trim();
                    String fecha = p[4].trim();       

                    matriculados[contador++] = new Matriculado(programa, modalidad, fecha);
                }
            }

        } catch (Exception e) { }
    }

    public Matriculado[] obtenerTodos() {
        return matriculados;
    }

    public int getTotal() {
        return contador;
    }
}
