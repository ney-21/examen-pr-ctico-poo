package app;

import modelo.Tablero;
import modelo.Jugador;
import vista.VistaConsola;
import controlador.Controlador;

public class App {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        Jugador jugador = new Jugador(vista.pedirNombreJugador());
        Tablero tablero = new Tablero(10, 10, 10); // tablero de 10x10 con 10 minas
        Controlador controlador = new Controlador(tablero, vista, jugador);
        controlador.jugar();
    }
}
