import java.time.LocalDateTime;

public class ServicoReservas {
    private int contadorReservas = 1;

    public Reserva reservarOferta(OfertaAntidesperdicio oferta, String tipoRecebimentoSelecionado) {
        
        if (oferta.getDataValidade().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Oferta esgotada ou expirada.");
        }

        if (oferta.getQuantidadeDisponivel() <= 0) {
            throw new IllegalStateException("Oferta esgotada ou expirada.");
        }

        if (tipoRecebimentoSelecionado.equalsIgnoreCase("Entrega") && !oferta.isPermiteEntrega()) {
             throw new IllegalArgumentException("Recebimento não permitido para esta oferta.");
        }
        if (tipoRecebimentoSelecionado.equalsIgnoreCase("Retirada") && !oferta.isPermiteRetirada()) {
             throw new IllegalArgumentException("Recebimento não permitido para esta oferta.");
        }

        oferta.decrementarQuantidade();
        Reserva novaReserva = new Reserva(contadorReservas++, LocalDateTime.now(), tipoRecebimentoSelecionado, "Confirmada");
        
        System.out.println("Reserva confirmada! Unidades restantes da oferta: " + oferta.getQuantidadeDisponivel());
        return novaReserva;
    }
}