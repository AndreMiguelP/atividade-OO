import java.time.LocalDateTime;

public class OfertaAntidesperdicio {
    private int idOferta;
    private String descricao;
    private int quantidadeDisponivel;
    private LocalDateTime dataValidade;
    private boolean permiteEntrega;
    private boolean permiteRetirada;

    public OfertaAntidesperdicio(int idOferta, String descricao, int quantidadeDisponivel, 
                                 LocalDateTime dataValidade, boolean permiteEntrega, boolean permiteRetirada) {
        this.idOferta = idOferta;
        this.descricao = descricao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.dataValidade = dataValidade;
        this.permiteEntrega = permiteEntrega;
        this.permiteRetirada = permiteRetirada;
    }

    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public LocalDateTime getDataValidade() { return dataValidade; }
    public boolean isPermiteEntrega() { return permiteEntrega; }
    public boolean isPermiteRetirada() { return permiteRetirada; }

    public void decrementarQuantidade() {
        if (this.quantidadeDisponivel > 0) {
            this.quantidadeDisponivel--;
        }
    }
}