import java.util.Date;

public class Paquete {
    private String destinatario;
    private Date fechaIngreso;

    public Paquete(String destinatario) {
        this.destinatario = destinatario;
        this.fechaIngreso = new Date(); // Asigna la fecha y hora actuales
    }

    public String getDestinatario() {
        return destinatario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }
}