package util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auditoria {

    private static final String RUTA = "src/data/auditoria.log";
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static void escribirLog(String mensaje) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA, true))) {
            pw.println(mensaje);
        } catch (Exception e) {
            System.out.println("Error crítico en auditoría.");
        }
    }
    public static void registrarAccion(String usuario, String accion) {
        String fecha = LocalDateTime.now().format(FORMATO);
        String entrada = "[" + fecha + "] Usuario: " + usuario + " | Acción: " + accion +
                         "\n----------------------------------------";
        escribirLog(entrada);
    }
    public static void registrarError(String usuario, Exception e) {
        String fecha = LocalDateTime.now().format(FORMATO);
        String entrada = "[" + fecha + "] Usuario: " + usuario +
                         "\nError: " + e.getMessage() +
                         "\n----------------------------------------";
        escribirLog(entrada);
    }
}
