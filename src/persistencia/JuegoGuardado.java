package persistencia;

import java.io.Serializable;
import modelo.Tablero;
import modelo.Jugador;

public class JuegoGuardado implements Serializable {
    private static final long serialVersionUID = 1L;

    private Tablero tablero;
    private Jugador jugador;

    public JuegoGuardado(Tablero tablero, Jugador jugador) {
        this.tablero = tablero;
        this.jugador = jugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
