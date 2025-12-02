package controlador;

import datos.UsuarioDAO;
import vista.ConsolaVista;
import util.Auditoria;

public class LoginControlador {
    private UsuarioDAO usuarioDAO;
    private ConsolaVista vista;

    public LoginControlador() {
        this.usuarioDAO = new UsuarioDAO();
        this.vista = new ConsolaVista();
    }

    public String iniciarSesion() {
        int intentos = 0;

        while (intentos < 3) {
            vista.mostrarMensaje("\n--- INICIO DE SESION ---");
            String usuario = vista.leerTexto("Usuario");
            String password = vista.leerTexto("Password");

            Auditoria.registrarAccion(usuario, "Intentó iniciar sesión");

            if (usuarioDAO.validarCredenciales(usuario, password)) {
                vista.mostrarMensaje("Bienvenido, " + usuario);

                Auditoria.registrarAccion(usuario, "Inicio de sesión exitoso");

                return usuario;
            } else {
                intentos++;

                Auditoria.registrarAccion(usuario, "Intento fallido de inicio de sesión (" + intentos + "/3)");

                vista.mostrarMensaje("Credenciales incorrectas. Intento " + intentos + "/3");
            }
        }

        Auditoria.registrarError("Sistema", new Exception("Bloqueo por 3 intentos fallidos de inicio de sesión"));

        return null;
    }
}
