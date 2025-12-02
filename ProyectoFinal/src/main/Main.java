package main;

import controlador.LoginControlador;
import controlador.SistemaControlador;

public class Main {
    public static void main(String[] args) {
       
        LoginControlador loginCtrl = new LoginControlador();
        String usuarioAutenticado = loginCtrl.iniciarSesion();

        if (usuarioAutenticado != null) {
            SistemaControlador sistema = new SistemaControlador(usuarioAutenticado);
            sistema.iniciar();
        } else {
            System.out.println("Acceso denegado. Cerrando sistema.");
        }
    }
}