package test;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Tablero;
import org.junit.jupiter.api.Test;

public class TableroTest {

    @Test
    public void testInicializacionTablero() {
        Tablero tablero = new Tablero(8, 8, 10);
        assertEquals(8, tablero.getFilas());
        assertEquals(8, tablero.getColumnas());
        assertNotNull(tablero.getCasilla(0, 0));
    }

    @Test
    public void testCantidadMinas() {
        Tablero tablero = new Tablero(8, 8, 10);
        int totalMinas = 0;
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (tablero.getCasilla(i, j).tieneMina()) {
                    totalMinas++;
                }
            }
        }
        assertEquals(10, totalMinas);
    }

    @Test
    public void testDescubrirCasillaVacia() {
        Tablero tablero = new Tablero(5, 5, 0);
        tablero.descubrirCasilla(2, 2);
        assertTrue(tablero.getCasilla(2, 2).estaDescubierta());
    }
}
