package persistencia;

import java.io.*;
import modelo.Tablero;
import modelo.Jugador;

public class GestorArchivos {
    private static final String ARCHIVO = "partida.dat";

    public static void guardar(Tablero tablero, Jugador jugador) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(new JuegoGuardado(tablero, jugador));
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static JuegoGuardado cargar() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("⚠ No hay partida guardada.");
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (JuegoGuardado) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e.getMessage());
            return null;
        }
    }
}
