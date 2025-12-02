package datos;

import modelo.Usuario;
import java.io.*;

public class UsuarioDAO {

    private final String RUTA_ARCHIVO = "src/data/usuarios.txt";

    private Usuario[] usuarios = new Usuario[500];
    private int contador = 0;

    public UsuarioDAO() {
        cargarDatos();
    }

    private void cargarDatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length >= 2 && contador < usuarios.length) {
                    usuarios[contador++] = new Usuario(p[0].trim(), p[1].trim());
                }
            }
        } catch (Exception e) { }
    }

    private void guardarDatos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < contador; i++) {
                Usuario u = usuarios[i];
                writer.println(u.getNombreUsuario() + "," + u.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validarCredenciales(String user, String pass) {
        for (int i = 0; i < contador; i++) {
            Usuario u = usuarios[i];
            if (u.getNombreUsuario().equals(user) &&
                u.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public void agregarUsuario(String user, String pass) {
        if (contador < usuarios.length) {
            usuarios[contador++] = new Usuario(user, pass);
            guardarDatos();
        }
    }

    public boolean cambiarPassword(String user, String nuevaPass) {
        for (int i = 0; i < contador; i++) {
            Usuario u = usuarios[i];
            if (u.getNombreUsuario().equals(user)) {
                u.setPassword(nuevaPass);
                guardarDatos();
                return true;
            }
        }
        return false;
    }

    public Usuario[] obtenerUsuarios() {
        return usuarios;
    }

    public int getTotal() {
        return contador;
    }
}