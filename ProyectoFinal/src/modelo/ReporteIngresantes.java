package modelo;

public class ReporteIngresantes {

    private final int totalIngresantes;
    private final int totalNoIngresantes;

    public ReporteIngresantes(int ingresantes, int noIngresantes) {
        this.totalIngresantes = ingresantes;
        this.totalNoIngresantes = noIngresantes;
    }

    public int getTotalIngresantes() { return totalIngresantes; }
    public int getTotalNoIngresantes() { return totalNoIngresantes; }

    @Override
    public String toString() {
        return "Ingresantes=" + totalIngresantes +
               ", NoIngresantes=" + totalNoIngresantes;
    }
}
