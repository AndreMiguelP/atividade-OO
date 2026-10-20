import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*; 

import java.time.LocalDateTime;

public class ServicoReservasMockitoTest {

    @Test
    public void testFluxoPrincipal_ReservaConfirmada_ComMockito() {
        OfertaAntidesperdicio ofertaMock = mock(OfertaAntidesperdicio.class);

        when(ofertaMock.getDataValidade()).thenReturn(LocalDateTime.now().plusDays(1)); 
        when(ofertaMock.getQuantidadeDisponivel()).thenReturn(5); 
        when(ofertaMock.isPermiteEntrega()).thenReturn(true); 

        ServicoReservas servico = new ServicoReservas();

        Reserva reserva = servico.reservarOferta(ofertaMock, "Entrega");

        assertNotNull(reserva, "A reserva não deveria ser nula.");
        assertEquals("Confirmada", reserva.getStatus(), "O status da reserva deve ser 'Confirmada'.");

        verify(ofertaMock, times(1)).decrementarQuantidade();
    }

    @Test
    public void testExcecaoE1_SemEstoque_ComMockito() {
        OfertaAntidesperdicio ofertaMock = mock(OfertaAntidesperdicio.class);

        when(ofertaMock.getDataValidade()).thenReturn(LocalDateTime.now().plusDays(1));
        when(ofertaMock.getQuantidadeDisponivel()).thenReturn(0); 

        ServicoReservas servico = new ServicoReservas();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            servico.reservarOferta(ofertaMock, "Retirada");
        });

        assertEquals("Oferta esgotada ou expirada.", exception.getMessage());
        
        verify(ofertaMock, never()).decrementarQuantidade();
    }
}