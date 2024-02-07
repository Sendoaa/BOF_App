package definicion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * La Clase Entrenador.
 */
public class Entrenador extends Participante {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 2953596603435362053L;

	/** La Constante FILENAME que indica la ubicacion del fichero. */
	private static final String FILENAME = "ficheros/entrenadores.ser";

	/** La Fecha de Alta. */
	private Fecha FechaAlta;

	/**
	 * Instancia para crear un nuevo Entrenador por defecto.
	 */
	// Contrustor por defecto
	public Entrenador() {
		super();
		this.FechaAlta = new Fecha();
	}

	/**
	 * Instancia para crear un nuevo Entrenador copia.
	 *
	 * @param e el Entrenador copia
	 */
	// Contructor copia
	public Entrenador(Entrenador e) {
		super(e);
		this.FechaAlta = e.FechaAlta;
	}

	/**
	 * Instancia para crear un nuevo Entrenador personalizado.
	 *
	 * @param p el Participante
	 * @param f la Fecha
	 */
	// Contructor personalizado
	public Entrenador(Participante p, Fecha f) {
		super(p);
		this.FechaAlta = f;
	}

	/**
	 * Obtener la Fecha de Alta.
	 *
	 * @return la Fecha de Alta
	 */
	public Fecha getFechaAlta() {
		return FechaAlta;
	}

	/**
	 * Asignar la Fecha de Alta.
	 *
	 * @param fechaAlta la nueva Fecha de Alta
	 */
	public void setFechaAlta(Fecha fechaAlta) {
		FechaAlta = fechaAlta;
	}

	/**
	 * Obtener el FILENAME.
	 *
	 * @return el FILENAME
	 */
	public static String getFilename() {
		return FILENAME;
	}

	/**
	 * Funcion To String.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return (super.toString() + " | " + FechaAlta);
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
	 * Funcion para Guardar entrenadores en el fichero.
	 *
	 * @param lstEntrenadores la Lista de Entrenadores
	 */
	// Guarda la lista de entrenadores en un archivo
	public static void guardarEntrenadores(ArrayList<Entrenador> lstEntrenadores) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
			oos.writeObject(lstEntrenadores);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para Cargar entrenadores desde fichero.
	 *
	 * @return el ArrayList de Entrenadores
	 */
	// Carga la lista de entrenadores desde un archivo
	@SuppressWarnings("unchecked")
	public static ArrayList<Entrenador> cargarEntrenadores() {
		ArrayList<Entrenador> entrenadores = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
			entrenadores = (ArrayList<Entrenador>) ois.readObject();
		} catch (FileNotFoundException e) {
			// El archivo no existe, se creará uno nuevo cuando sea necesario
		} catch (IOException | ClassNotFoundException e) {
			if (!entrenadores.isEmpty()) {
				e.printStackTrace();
			}
		}
		return entrenadores;
	}
}
