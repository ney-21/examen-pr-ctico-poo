package controlador;

import modelo.*;
import vista.VistaConsola;
import excepciones.*;
import persistencia.*;

public class Controlador {
    private Tablero tablero;
    private VistaConsola vista;
    private Jugador jugador;
    private boolean juegoTerminado = false;

    public Controlador(Tablero tablero, VistaConsola vista, Jugador jugador) {
        this.tablero = tablero;
        this.vista = vista;
        this.jugador = jugador;
    }

    public void jugar() {
        while (!juegoTerminado) {
            vista.mostrarTablero(tablero);
            String coord = vista.pedirCoordenada();
            String accion = vista.pedirAccion();

            try {
                int columna = coord.charAt(0) - 'A';
                int fila = Integer.parseInt(coord.substring(1)) - 1;

                if (!enRango(fila, columna)) {
                    throw new CasillaFueraDeRangoException("Coordenada fuera del tablero.");
                }

                Casilla casilla = tablero.getCasilla(fila, columna);

                switch (accion) {
                    case "D":
                        procesarDescubrir(fila, columna, casilla);
                        break;
                    case "M":
                        casilla.marcar();
                        break;
                    case "G":
                        GestorArchivos.guardar(tablero, jugador);
                        vista.mostrarMensaje("✅ Partida guardada.");
                        break;
                    case "C":
                        JuegoGuardado cargado = GestorArchivos.cargar();
                        if (cargado != null) {
                            this.tablero = cargado.getTablero();
                            this.jugador = cargado.getJugador();
                            vista.mostrarMensaje("✅ Partida cargada de " + jugador.getNombre());
                        }
                        break;
                    default:
                        vista.mostrarMensaje("❌ Acción no reconocida.");
                        break;
                }

                if (verificarVictoria()) {
                    vista.mostrarTablero(tablero);
                    vista.mostrarMensaje("🎉 ¡Felicidades " + jugador.getNombre() + "! Has ganado.");
                    juegoTerminado = true;
                }

            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                vista.mostrarMensaje("Formato inválido. Use letra+número (ej. B4).");
            } catch (CasillaFueraDeRangoException | CasillaYaDescubiertaException e) {
                vista.mostrarMensaje(e.getMessage());
            }
        }
    }

    private void procesarDescubrir(int fila, int columna, Casilla casilla)
            throws CasillaYaDescubiertaException {
        if (casilla.estaDescubierta()) {
            throw new CasillaYaDescubiertaException("La casilla ya está descubierta.");
        }
        tablero.descubrirCasilla(fila, columna);
        if (casilla.tieneMina()) {
            vista.mostrarTablero(tablero);
            vista.mostrarMensaje("💥 ¡Perdiste! Has descubierto una mina.");
            juegoTerminado = true;
        }
    }

    private boolean enRango(int fila, int columna) {
        return fila >= 0 && fila < tablero.getFilas() && columna >= 0 && columna < tablero.getColumnas();
    }

    private boolean verificarVictoria() {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Casilla c = tablero.getCasilla(i, j);
                if (!c.tieneMina() && !c.estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }
}
