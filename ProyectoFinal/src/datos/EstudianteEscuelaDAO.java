package datos;

import java.io.*;
import modelo.EstudianteEscuela;

public class EstudianteEscuelaDAO {

    private static final String RUTA = "src/data/estudiantes_escuela.txt";

    private EstudianteEscuela[] arreglo = new EstudianteEscuela[1000];
    private int contador = 0;

    public EstudianteEscuelaDAO() {
        cargarDatos();
    }

    private void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) continue;

                String[] p = linea.split(",");

                if (p.length >= 4) {
                    String codigo = p[0].trim();
                    String nombre = p[1].trim();
                    String escuela = p[2].trim();
                    boolean ingresante = Boolean.parseBoolean(p[3].trim());

                    arreglo[contador++] =
                        new EstudianteEscuela(codigo, nombre, escuela, ingresante);
                }
            }

        } catch (Exception e) { }
    }

    public void agregar(EstudianteEscuela est) {

        if (contador < arreglo.length)
            arreglo[contador++] = est;

        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA, true))) {
            pw.println(
                est.getCodigo() + "," +
                est.getNombreCompleto() + "," +
                est.getEscuelaProfesional() + "," +
                est.isIngresante()
            );
        } catch (Exception e) {
            System.out.println("Error al agregar estudiante.");
        }
    }

    public void mostrarTodos() {
        for (int i = 0; i < contador; i++) {
            System.out.println(arreglo[i]);
        }
    }

    public EstudianteEscuela buscar(String codigoBuscado) {
        for (int i = 0; i < contador; i++) {
            if (arreglo[i].getCodigo().equalsIgnoreCase(codigoBuscado)) {
                return arreglo[i];
            }
        }
        return null;
    }
    
    public boolean eliminar(String codigo) {

        File original = new File(RUTA);
        File temporal = new File("src/data/temp.txt");

        boolean eliminado = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(original));
            PrintWriter pw = new PrintWriter(new FileWriter(temporal))
        ) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] p = linea.split(",");

                if (p[0].equalsIgnoreCase(codigo)) {
                    eliminado = true;
                    continue;
                }

                pw.println(linea);
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar estudiante.");
        }

        original.delete();
        temporal.renameTo(original);

        if (eliminado) recargarArreglo();

        return eliminado;
    }
    private void recargarArreglo() {
        contador = 0;
        cargarDatos();
    }

    public EstudianteEscuela[] obtenerTodos() {
        return arreglo;
    }

    public int getTotal() {
        return contador;
    }
}
