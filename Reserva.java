import java.time.LocalDateTime;

public class Reserva {
    private int idReserva;
    private LocalDateTime dataReserva;
    private String tipoRecebimento;
    private String status;

    public Reserva(int idReserva, LocalDateTime dataReserva, String tipoRecebimento, String status) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.tipoRecebimento = tipoRecebimento;
        this.status = status;
    }
    
    public String getStatus() { return status; }
}