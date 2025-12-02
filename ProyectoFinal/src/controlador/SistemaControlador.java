package controlador;

import datos.*;
import modelo.*;
import vista.ConsolaVista;
import util.Auditoria;

public class SistemaControlador {
    private String usuarioActual;
    private ConsolaVista vista;
    
    // DAOs para la gestión de datos
    private EstudianteEscuelaDAO estudianteDAO;
    private UsuarioDAO usuarioDAO;
    private ReporteIngresantesDAO reporteIngresantesDAO;
    private RendimientoDAO rendimientoDAO;
    private PostulanteDAO postulanteDAO;
    private MatriculadoDAO matriculadoDAO;

    public SistemaControlador(String usuario) {
        this.usuarioActual = usuario;
        this.vista = new ConsolaVista();
        
        this.estudianteDAO = new EstudianteEscuelaDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.reporteIngresantesDAO = new ReporteIngresantesDAO();
        this.rendimientoDAO = new RendimientoDAO();
        this.postulanteDAO = new PostulanteDAO();
        this.matriculadoDAO = new MatriculadoDAO();
    }

    public void iniciar() {
        int opcion = 0;
        do {
            vista.mostrarMenuPrincipal(usuarioActual);
            opcion = vista.leerEntero("Seleccione una opción");

            switch (opcion) {
                case 1:
                    gestionarEstudiantes();
                    break;
                case 2:
                    verReportesGenerales();
                    break;
                case 3:
                    gestionarUsuarios();
                    break;
                case 4:
                    vista.mostrarMensaje("Cerrando sesión...");
                    Auditoria.registrarAccion(usuarioActual, "Cierre de sesión");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 4);
    }

    private void gestionarEstudiantes() {
        int opcion = 0;
        do {
            vista.mostrarMenuEstudiantes();
            opcion = vista.leerEntero("Opción");

            switch (opcion) {
                case 1:
                    vista.mostrarLinea();
                    vista.mostrarMensaje("LISTA DE ESTUDIANTES");
                    EstudianteEscuela[] estudiantes = estudianteDAO.obtenerTodos();
                    for (int i = 0; i < estudianteDAO.getTotal(); i++) {
                        System.out.println(estudiantes[i]); 
                    }
                    Auditoria.registrarAccion(usuarioActual, "Listó estudiantes");
                    break;

                case 2: 
                    String codBusqueda = vista.leerTexto("Ingrese Código a buscar");
                    EstudianteEscuela est = estudianteDAO.buscar(codBusqueda); 
                    if (est != null) {
                        vista.mostrarMensaje("Encontrado: " + est);
                    } else {
                        vista.mostrarMensaje("Estudiante no encontrado.");
                    }
                    break;

                case 3:
                    String codigo = vista.leerTexto("Código");
                    String nombre = vista.leerTexto("Nombre Completo");
                    String escuela = vista.leerTexto("Escuela Profesional");
                    String esIngresanteStr = vista.leerTexto("¿Es ingresante? (S/N)");
                    boolean esIngresante = esIngresanteStr.equalsIgnoreCase("S");

                    EstudianteEscuela nuevoEst = new EstudianteEscuela(codigo, nombre, escuela, esIngresante);
                    estudianteDAO.agregar(nuevoEst); // [cite: 71]
                    vista.mostrarMensaje("Estudiante agregado correctamente.");
                    Auditoria.registrarAccion(usuarioActual, "Agregó estudiante: " + codigo);
                    break;

                case 4:
                    String codEliminar = vista.leerTexto("Ingrese Código a eliminar");
                    if (estudianteDAO.eliminar(codEliminar)) { // [cite: 75]
                        vista.mostrarMensaje("Estudiante eliminado.");
                        Auditoria.registrarAccion(usuarioActual, "Eliminó estudiante: " + codEliminar);
                    } else {
                        vista.mostrarMensaje("Error o código no existe.");
                    }
                    break;

                case 5:
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void gestionarUsuarios() {
        int opcion = 0;
        do {
            vista.mostrarMenuUsuarios();
            opcion = vista.leerEntero("Opción");

            switch (opcion) {
                case 1: 
                    vista.mostrarLinea();
                    vista.mostrarMensaje("USUARIOS DEL SISTEMA");
                    Usuario[] usuarios = usuarioDAO.obtenerUsuarios(); 
                    for (int i = 0; i < usuarioDAO.getTotal(); i++) {
                        System.out.println("User: " + usuarios[i].getNombreUsuario());
                    }
                    break;

                case 2: 
                    String nuevoUser = vista.leerTexto("Nuevo Usuario");
                    String nuevoPass = vista.leerTexto("Password");
                    usuarioDAO.agregarUsuario(nuevoUser, nuevoPass); 
                    vista.mostrarMensaje("Usuario registrado.");
                    Auditoria.registrarAccion(usuarioActual, "Creó usuario: " + nuevoUser);
                    break;

                case 3:
                    String userCambio = vista.leerTexto("Usuario a modificar");
                    String passCambio = vista.leerTexto("Nuevo Password");
                    if (usuarioDAO.cambiarPassword(userCambio, passCambio)) { 
                        vista.mostrarMensaje("Contraseña actualizada.");
                        Auditoria.registrarAccion(usuarioActual, "Cambió pass de: " + userCambio);
                    } else {
                        vista.mostrarMensaje("Usuario no encontrado.");
                    }
                    break;

                case 4: 
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 4);
    }
    private void verReportesGenerales() {
        int opcion = 0;
        do {
            vista.mostrarLinea();
            vista.mostrarMensaje("      REPORTES Y DATOS ACADÉMICOS");
            vista.mostrarLinea();
            vista.mostrarMensaje("[1] Reporte de Ingresantes");
            vista.mostrarMensaje("[2] Rendimiento Académico");
            vista.mostrarMensaje("[3] Postulantes");
            vista.mostrarMensaje("[4] Matriculados");
            vista.mostrarMensaje("[5] Listado General de Estudiantes"); // 5to Reporte agregado
            vista.mostrarMensaje("[6] Volver");
            
            opcion = vista.leerEntero("Seleccione reporte");

            switch(opcion) {
                case 1:
                    vista.mostrarMensaje("-- REPORTE INGRESANTES --");
                    reporteIngresantesDAO.mostrarTodos(); 
                    break;
                case 2:
                    vista.mostrarMensaje("-- RENDIMIENTO --");
                    Rendimiento[] rend = rendimientoDAO.obtenerTodos(); 
                    for(int i=0; i<rendimientoDAO.getTotal(); i++) System.out.println(rend[i]);
                    break;
                case 3:
                    vista.mostrarMensaje("-- POSTULANTES --");
                    Postulante[] post = postulanteDAO.obtenerTodos(); 
                    for(int i=0; i<postulanteDAO.getTotal(); i++) System.out.println(post[i]);
                    break;
                case 4:
                    vista.mostrarMensaje("-- MATRICULADOS --");
                    Matriculado[] mat = matriculadoDAO.obtenerTodos(); 
                    for(int i=0; i<matriculadoDAO.getTotal(); i++) System.out.println(mat[i]);
                    break;
                case 5:
                    vista.mostrarMensaje("-- ESTUDIANTES ESCUELA --");
                    estudianteDAO.mostrarTodos();
                    break;
                case 6:
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
            if(opcion != 6) {
                Auditoria.registrarAccion(usuarioActual, "Visualizó reporte tipo: " + opcion);
            }
        } while (opcion != 6);
    }
}