package definicion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La Clase Temporada.
 */
public class Temporada implements Comparable<Temporada>, Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = -7680466212868208184L;

	/** La Constante FILENAME que indica la ubicacion del fichero. */
	private static final String FILENAME = "ficheros/temporadas.ser";

	/** El Numero. */
	private Integer Numero;

	/** La Fecha de Inicio. */
	private Fecha FechaInicio;

	/** El Estado. */
	private String Estado;

	/** La Lista de Equipos. */
	private List<Equipo> ListaEquipos;

	/** La Lista de Jornadas. */
	private List<Jornada> ListaJornadas;

	/**
	 * Instancia para crear una nueva Temporada por defecto.
	 */
	// Contrustor por defecto
	public Temporada() {
		this.Numero = null;
		this.FechaInicio = new Fecha();
		this.Estado = "PROXIMAMENTE";
		this.ListaEquipos = new ArrayList<Equipo>();
		this.ListaJornadas = new ArrayList<Jornada>();
	}

	/**
	 * Instancia para crear una nueva Temporada copia.
	 *
	 * @param t la Temporada copia
	 */
	// Contructor copia
	public Temporada(Temporada t) {
		this.Numero = t.Numero;
		this.FechaInicio = t.FechaInicio;
		this.Estado = t.Estado;
		this.ListaEquipos = t.ListaEquipos;
		this.ListaJornadas = t.ListaJornadas;
	}

	/**
	 * Instancia para crear una nueva Temporada personalizada.
	 *
	 * @param n  el Numero
	 * @param fi la Fecha de Inicio
	 * @param e  el Estado
	 * @param le la Lista de Equipos
	 */
	// Contructor personalizado
	public Temporada(Integer n, Fecha fi, String e, List<Equipo> le) {
		this.Numero = n;
		this.FechaInicio = fi;
		this.Estado = e;
		this.ListaEquipos = le;
		this.ListaJornadas = null;
	}

	/**
	 * Funcion To string.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return ("Temporada " + Numero + " [Fecha Inicio:" + FechaInicio + "] Estado: " + Estado);
	}

	/**
	 * Obtener el Numero.
	 *
	 * @return el Numero
	 */
	public Integer getNumero() {
		return Numero;
	}

	/**
	 * Asignar el Numero.
	 *
	 * @param numero el nuevo Numero
	 */
	public void setNumero(Integer numero) {
		Numero = numero;
	}

	/**
	 * Obtener el Estado.
	 *
	 * @return el Estado
	 */
	public String getEstado() {
		return Estado;
	}

	/**
	 * Asignar el Estado.
	 *
	 * @param estado el nuevo Estado
	 */
	public void setEstado(String estado) {
		Estado = estado;
	}

	/**
	 * Obtener la Lista de Equipos.
	 *
	 * @return la Lista de Equipos
	 */
	public List<Equipo> getListaEquipos() {
		return ListaEquipos;
	}

	/**
	 * Asignar la Lista de Equipos.
	 *
	 * @param listaEquipos la nueva Lista de Equipos
	 */
	public void setListaEquipos(List<Equipo> listaEquipos) {
		ListaEquipos = listaEquipos;
	}

	/**
	 * Obtener la Lista de Jornadas.
	 *
	 * @return la Lista de Jornadas
	 */
	public List<Jornada> getListaJornadas() {
		return ListaJornadas;
	}

	/**
	 * Asignar la Lista de Jornadas.
	 *
	 * @param listaJornadas la nueva Lista de Jornadas
	 */
	public void setListaJornadas(List<Jornada> listaJornadas) {
		ListaJornadas = listaJornadas;
	}

	/**
	 * Obtener la Fecha de Inicio.
	 *
	 * @return la Fecha de Inicio
	 */
	public Fecha getFechaInicio() {
		return FechaInicio;
	}

	/**
	 * Asignar la Fecha de Inicio.
	 *
	 * @param fechaInicio la nueva Fecha de Inicio
	 */
	public void setFechaInicio(Fecha fechaInicio) {
		FechaInicio = fechaInicio;
	}

	/**
	 * Funcion Hash code.
	 *
	 * @return el hashCode de los Objetos a Comparar
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Numero, FechaInicio);
	}

	/**
	 * Funcion Equals.
	 *
	 * @param obj el Objeto a comparar
	 * @return true, si son Iguales
	 */
	// Compara los objetos de una clase
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			// Si son el mismo objeto
			return true;
		if (obj == null)
			// si el objeto no esta creado
			return false;
		if (getClass() != obj.getClass())
			// si son de distinta clase
			return false;
		// Comparo las propiedades
		Temporada other = (Temporada) obj;
		// Si tienen el mismo contenido devuelvo true
		return Objects.equals(this.Numero, other.Numero);
	}

	/**
	 * Funcion Compare to.
	 *
	 * @param other Otra Temporada
	 * @return un int, que indica cual es mayor que el otro o si son iguales
	 */
	public int compareTo(Temporada other) {
		// Si el valor de Dni en null se le asigna 0
		if (other.Numero.equals(null)) {
			other.setNumero(0);
		} else if (this.Numero.equals(null)) {
			this.setNumero(0);
		}
		return this.Numero.compareTo(other.Numero);
	}

	/**
	 * Funcion para Guardar temporadas en el fichero.
	 *
	 * @param lstTemporadas la Lista de Temporadas
	 */
	// Guarda la lista de temporadas en un archivo
	public static void guardarTemporadas(ArrayList<Temporada> lstTemporadas) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
			oos.writeObject(lstTemporadas);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para Cargar temporadas desde fichero.
	 *
	 * @return el ArrayList de Temporadas
	 */
	// Carga la lista de temporadas desde un archivo
	@SuppressWarnings("unchecked")
	public static ArrayList<Temporada> cargarTemporadas() {
		ArrayList<Temporada> temporadas = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
			temporadas = (ArrayList<Temporada>) ois.readObject();
		} catch (FileNotFoundException e) {
			// El archivo no existe, se creará uno nuevo cuando sea necesario
		} catch (IOException | ClassNotFoundException e) {
			if (!temporadas.isEmpty()) {
				e.printStackTrace();
			}
		}
		return temporadas;
	}
}
