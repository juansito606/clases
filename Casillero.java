public class Casillero {
    private Paquete paquete;

    public Casillero() {
        this.paquete = null;
    }

    public boolean estaOcupado() {
        return this.paquete != null;
    }

    public void registrarPaquete(Paquete paquete) {
        if (!estaOcupado()) {
            this.paquete = paquete;
        }
    }

    public Paquete getPaquete() {
        return this.paquete;
    }
}