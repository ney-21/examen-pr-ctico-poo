package modelo;

import java.io.Serializable;

public class Tablero implements Serializable {
    private static final long serialVersionUID = 1L;
    private int filas;
    private int columnas;
    private int minas;
    private Casilla[][] casillas;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.casillas = new Casilla[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        colocarMinas();
        calcularMinasAlrededor();
    }

    private void colocarMinas() {
        java.util.Random rand = new java.util.Random();
        int colocadas = 0;
        while (colocadas < minas) {
            int f = rand.nextInt(filas);
            int c = rand.nextInt(columnas);
            if (!casillas[f][c].tieneMina()) {
                casillas[f][c].colocarMina();
                colocadas++;
            }
        }
    }

    private void calcularMinasAlrededor() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].tieneMina()) continue;
                for (int fi = -1; fi <= 1; fi++) {
                    for (int co = -1; co <= 1; co++) {
                        int ni = i + fi, nj = j + co;
                        if (enRango(ni, nj) && casillas[ni][nj].tieneMina()) {
                            casillas[i][j].incrementarMinasAlrededor();
                        }
                    }
                }
            }
        }
    }

    public void descubrirCasilla(int fila, int columna) {
        if (!enRango(fila, columna)) return;
        Casilla casilla = casillas[fila][columna];
        if (casilla.estaDescubierta() || casilla.estaMarcada()) return;

        casilla.descubrir();

        if (casilla.getMinasAlrededor() == 0 && !casilla.tieneMina()) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        descubrirCasilla(fila + i, columna + j);
                    }
                }
            }
        }
    }

    private boolean enRango(int i, int j) {
        return i >= 0 && i < filas && j >= 0 && j < columnas;
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
}
