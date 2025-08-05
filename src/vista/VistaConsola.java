package vista;

import modelo.Tablero;
import modelo.Casilla;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarTablero(Tablero tablero) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();

        // Encabezado de letras
        System.out.print("    ");
        for (int c = 0; c < columnas; c++) {
            System.out.printf(" %c ", 'A' + c);
        }
        System.out.println();

        // Línea superior
        System.out.print("   ┌");
        for (int c = 0; c < columnas - 1; c++) System.out.print("───┬");
        System.out.println("───┐");

        // Filas con contenido
        for (int f = 0; f < filas; f++) {
            System.out.printf("%2d │", f + 1);
            for (int c = 0; c < columnas; c++) {
                Casilla casilla = tablero.getCasilla(f, c);
                String simbolo;
                if (casilla.estaDescubierta()) {
                    if (casilla.tieneMina()) {
                        simbolo = "X";
                    } else if (casilla.getMinasAlrededor() == 0) {
                        simbolo = "V";
                    } else {
                        simbolo = String.valueOf(casilla.getMinasAlrededor());
                    }
                } else if (casilla.estaMarcada()) {
                    simbolo = "M";
                } else {
                    simbolo = "-";
                }
                System.out.printf(" %s │", simbolo);
            }
            System.out.println();

            if (f < filas - 1) {
                System.out.print("   ├");
                for (int c = 0; c < columnas - 1; c++) System.out.print("───┼");
                System.out.println("───┤");
            }
        }

        // Línea inferior
        System.out.print("   └");
        for (int c = 0; c < columnas - 1; c++) System.out.print("───┴");
        System.out.println("───┘");
    }

    public String pedirNombreJugador() {
        System.out.print("Ingrese su nombre: ");
        return scanner.nextLine();
    }

    public String pedirCoordenada() {
        System.out.print("Ingrese coordenada (ej. B4): ");
        return scanner.nextLine().toUpperCase();
    }

    public String pedirAccion() {
        System.out.print("Acción (D = descubrir, M = marcar, G = guardar, C = cargar): ");
        return scanner.nextLine().toUpperCase();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

