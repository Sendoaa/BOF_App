package definicion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * La Clase Jugador.
 */
public class Jugador extends Participante {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = -1812403768776440701L;

	/** La Constante FILENAME que indica la ubicacion del fichero. */
	private static final String FILENAME = "ficheros/jugadores.ser";

	/** La Posicion de Juego. */
	private String Posicion;

	/**
	 * Instancia para crear un nuevo Jugador por defecto.
	 */
	// Contrustor por defecto
	public Jugador() {
		super();
		this.Posicion = "";
	}

	/**
	 * Instancia para crear un nuevo Jugador copia.
	 *
	 * @param j el Jugador copia
	 */
	// Contructor copia
	public Jugador(Jugador j) {
		super(j);
		this.Posicion = j.Posicion;
	}

	/**
	 * Instancia para crear un nuevo Jugador personalizado.
	 *
	 * @param p   el Participante
	 * @param pos la Posicion
	 */
	// Contructor personalizado
	public Jugador(Participante p, String pos) {
		super(p);
		this.Posicion = pos;
	}
	
	public Jugador(String dni, String nombre, String apellido, String nacionalidad, String posicion) {
      super(dni, nombre, apellido, nacionalidad);
      this.Posicion = posicion;
  }
	
	//Jugador jugador = new Jugador(dni, nombre, apellidos, nacionalidad, posicion);

	/**
	 * Funcion To string.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return (super.toString() + " | " + Posicion);
	}

	/**
	 * Obtener la Posicion.
	 *
	 * @return la Posicion
	 */
	public String getPosicion() {
		return Posicion;
	}

	/**
	 * Asignar la Posicion.
	 *
	 * @param posicion la nueva Posicion
	 */
	public void setPosicion(String posicion) {
		Posicion = posicion;
	}
	

	/**
	 * Obtener el serialversionuid.
	 *
	 * @return el serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Funcion para Guardar jugadores en el fichero.
	 *
	 * @param lstJugadores la Lista de Jugadores
	 */
	// Guarda la lista de jugadores en un archivo
	public static void guardarJugadores(ArrayList<Jugador> lstJugadores) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
			oos.writeObject(lstJugadores);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para Cargar jugadores desde fichero.
	 *
	 * @return el ArrayList de Jugadores
	 */
	// Carga la lista de jugadores desde un archivo
	@SuppressWarnings("unchecked")
	public static ArrayList<Jugador> cargarJugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
			jugadores = (ArrayList<Jugador>) ois.readObject();
		} catch (FileNotFoundException e) {
			// El archivo no existe, se creará uno nuevo cuando sea necesario
		} catch (IOException | ClassNotFoundException e) {
			if (!jugadores.isEmpty()) {
				e.printStackTrace();
			}
		}
		return jugadores;
	}

}
