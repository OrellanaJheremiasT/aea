package vista;

import java.util.Scanner;

public class ConsolaVista {
    private Scanner scanner;

    public ConsolaVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void mostrarLinea() {
        System.out.println("----------------------------------------");
    }

    public String leerTexto(String etiqueta) {
        System.out.print(etiqueta + ": ");
        return scanner.nextLine();
    }

    public int leerEntero(String etiqueta) {
        System.out.print(etiqueta + ": ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public double leerDouble(String etiqueta) {
        System.out.print(etiqueta + ": ");
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return -1.0;
        }
    }

    public void mostrarMenuPrincipal(String usuario) {
        System.out.println("========================================");
        System.out.println("         SISTEMA ACADEMICO              ");
        System.out.println("========================================");
        System.out.println(" Usuario: " + usuario);
        mostrarLinea();
        System.out.println("  [1] Gestion de Estudiantes");
        System.out.println("  [2] Reportes Generales");
        System.out.println("  [3] Gestion de Usuarios");
        System.out.println("  [4] Salir");
        mostrarLinea();
    }

    public void mostrarMenuEstudiantes() {
        mostrarLinea();
        System.out.println("        GESTION DE ESTUDIANTES          ");
        mostrarLinea();
        System.out.println("  [1] Listar estudiantes");
        System.out.println("  [2] Buscar estudiante por ID");
        System.out.println("  [3] Agregar estudiante");
        System.out.println("  [4] Eliminar estudiante");
        System.out.println("  [5] Volver");
    }
    
    public void mostrarMenuUsuarios() {
        mostrarLinea();
        System.out.println("          GESTION DE USUARIOS           ");
        mostrarLinea();
        System.out.println("  [1] Listar usuarios");
        System.out.println("  [2] Agregar usuario");
        System.out.println("  [3] Cambiar password");
        System.out.println("  [4] Volver");
    }
}