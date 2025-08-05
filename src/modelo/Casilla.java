package modelo;

import java.io.Serializable;

public class Casilla implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean tieneMina;
    private boolean descubierta;
    private boolean marcada;
    private int minasAlrededor;

    public Casilla() {
        this.tieneMina = false;
        this.descubierta = false;
        this.marcada = false;
        this.minasAlrededor = 0;
    }

    public boolean tieneMina() { return tieneMina; }
    public void colocarMina() { this.tieneMina = true; }
    public boolean estaDescubierta() { return descubierta; }
    public void descubrir() { this.descubierta = true; }
    public boolean estaMarcada() { return marcada; }
    public void marcar() { this.marcada = !this.marcada; }
    public int getMinasAlrededor() { return minasAlrededor; }
    public void incrementarMinasAlrededor() { this.minasAlrededor++; }
}
