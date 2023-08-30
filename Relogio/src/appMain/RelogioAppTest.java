package appMain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RelogioAppTest {
    private oRelogio relogio;

    @BeforeEach
    public void setUp() {
        relogio = new oRelogio();
    }

    @Test
    public void testDefinirHorario() {
        relogio.definirHorario(12, 30, 45);
        assertEquals(12, relogio.getHoras());
        assertEquals(30, relogio.getMinutos());
        assertEquals(45, relogio.getSegundos());
    }

    @Test
    public void testDefinirHorarioInvalido() {
        relogio.definirHorario(25, 70, 90); // Valores inválidos
        assertEquals(0, relogio.getHoras());
        assertEquals(0, relogio.getMinutos());
        assertEquals(0, relogio.getSegundos());
    }

    @Test
    public void testReiniciarMeiaNoite() {
        relogio.definirHorario(23, 45, 10);
        relogio.reiniciarMeiaNoite();
        assertEquals(0, relogio.getHoras());
        assertEquals(0, relogio.getMinutos());
        assertEquals(0, relogio.getSegundos());
    }

    @Test
    public void testMarcarIntervalo() {
        relogio.definirHorario(8, 0, 0);
        relogio.marcarIntervalo(8, 0, 0, 10, 30, 15);
        assertEquals("Tempo decorrido: 02:30:15", relogio.getUltimaMensagem());
    }

    @Test
    public void testMarcarIntervaloInvalido() {
        relogio.definirHorario(18, 0, 0);
        relogio.marcarIntervalo(18, 0, 0, 18, 0, 90); // Segundos inválidos
        assertEquals("Intervalo de tempo inválido.", relogio.getUltimaMensagem());
    }

    @Test
    public void testImprimirFormato24h() {
        relogio.definirHorario(15, 30, 0);
        String formato24h = relogio.imprimirFormatoHorario(true);
        assertEquals("15:30:00", formato24h);
    }

    @Test
    public void testImprimirFormato12hAM() {
        relogio.definirHorario(9, 45, 0);
        String formato12hAM = relogio.imprimirFormatoHorario(false);
        assertEquals("09:45:00 AM", formato12hAM);
    }

    @Test
    public void testImprimirFormato12hPM() {
        relogio.definirHorario(20, 15, 0);
        String formato12hPM = relogio.imprimirFormatoHorario(false);
        assertEquals("08:15:00 PM", formato12hPM);
    }
}

