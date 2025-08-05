package excepciones;

public class CasillaFueraDeRangoException extends Exception {
    private static final long serialVersionUID = 1L;
    public CasillaFueraDeRangoException(String mensaje) {
        super(mensaje);
    }
}
