package test;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Casilla;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CasillaTest {

    private Casilla casilla;

    @BeforeEach
    public void setUp() {
        casilla = new Casilla();
    }

    @Test
    public void testInicializacion() {
        assertFalse(casilla.estaDescubierta());
        assertFalse(casilla.tieneMina());
        assertFalse(casilla.estaMarcada());
        assertEquals(0, casilla.getMinasAlrededor());
    }

    @Test
    public void testColocarMina() {
        casilla.colocarMina();
        assertTrue(casilla.tieneMina());
    }

    @Test
    public void testMarcarYDesmarcar() {
        casilla.marcar();
        assertTrue(casilla.estaMarcada());

        casilla.marcar();  // toggle
        assertFalse(casilla.estaMarcada());
    }

    @Test
    public void testIncrementarMinasAlrededor() {
        casilla.incrementarMinasAlrededor();
        assertEquals(1, casilla.getMinasAlrededor());
    }
}
