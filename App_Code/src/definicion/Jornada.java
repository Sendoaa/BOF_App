package definicion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * La Clase Jornada.
 */
public class Jornada implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 5312527782867029955L;

	/** El Numero. */
	private Integer Numero;

	/** La Fecha. */
	private Fecha Fecha;

	/** La Temporada. */
	private Temporada Temporada;

	/** La Lista de Partidos. */
	private List<Partido> ListaPartidos;

	/**
	 * Instancia para crear una nueva Jornada por defecto.
	 */
	// Contrustor por defecto
	public Jornada() {
		this.Numero = null;
		this.Fecha = new Fecha();
		this.Temporada = new Temporada();
		this.ListaPartidos = new ArrayList<Partido>();
	}

	/**
	 * Instancia para crear una nueva Jornada copia.
	 *
	 * @param j la Jornada copia
	 */
	// Contructor copia
	public Jornada(Jornada j) {
		this.Numero = j.Numero;
		this.Fecha = j.Fecha;
		this.Temporada = j.Temporada;
		this.ListaPartidos = j.ListaPartidos;
	}

	/**
	 * Instancia para crear una nueva Jornada personalizada.
	 *
	 * @param n  el Numero
	 * @param f  la Fecha
	 * @param t  la Temporada
	 * @param lp la Lista de Partidos
	 */
	// Contructor personalizado
	public Jornada(Integer n, Fecha f, Temporada t, List<Partido> lp) {
		this.Numero = n;
		this.Fecha = f;
		this.Temporada = t;
		this.ListaPartidos = lp;
	}

	/**
	 * Funcion To string.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return ("Numero:" + Numero + ", Fecha:" + Fecha + ", Lista de Partidos:" + ListaPartidos);
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
	 * Obtener la Fecha.
	 *
	 * @return la Fecha
	 */
	public Fecha getFecha() {
		return Fecha;
	}

	/**
	 * Asignar la Fecha.
	 *
	 * @param fecha la nueva Fecha
	 */
	public void setFecha(Fecha fecha) {
		Fecha = fecha;
	}

	/**
	 * Obtener la Temporada.
	 *
	 * @return la Temporada
	 */
	public Temporada getTemporada() {
		return Temporada;
	}

	/**
	 * Asignar la Temporada.
	 *
	 * @param temporada la nueva Temporada
	 */
	public void setTemporada(Temporada temporada) {
		Temporada = temporada;
	}

	/**
	 * Obtener la Lista de Partidos.
	 *
	 * @return la Lista de Partidos
	 */
	public List<Partido> getListaPartidos() {
		return ListaPartidos;
	}

	/**
	 * Asignar la Lista de Partidos.
	 *
	 * @param listaPartidos la Lista de Partidos
	 */
	public void setListaPartidos(List<Partido> listaPartidos) {
		ListaPartidos = listaPartidos;
	}

	/**
	 * Funcion Hash code.
	 *
	 * @return el hashCode de los Objetos a Comparar
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Numero);
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
		Jornada other = (Jornada) obj;
		// Si tienen el mismo contenido devuelvo true
		return Objects.equals(this.Numero, other.Numero);
	}

	/**
	 * Funcion Compare to.
	 *
	 * @param other Otra Jornada
	 * @return un int, que indica cual es mayor que el otro o si son iguales
	 */
	public int compareTo(Jornada other) {
		// Si el valor de Dni en null se le asigna 0
		if (other.Numero.equals(null)) {
			other.setNumero(0);
		} else if (this.Numero.equals(null)) {
			this.setNumero(0);
		}

		return this.Numero.compareTo(other.Numero);
	}

	/**
	 * Funcion para Generar jornadas.
	 *
	 * @param equipos     la Lista de Equipos que hay
	 * @param fechaInicio la Fecha de Inicio de la Temporada
	 * @param temporada   la Temporada en donde se generan
	 * @return el ArrayList de las Jornadas
	 */
	public static ArrayList<Jornada> generarJornadas(List<Equipo> equipos, Fecha fechaInicio, Temporada temporada) {
		ArrayList<Jornada> jornadas = new ArrayList<>();

		// Agregar un equipo para descansar si el número de equipos es impar
		if (equipos.size() % 2 != 0) {
			equipos.add(new Equipo("Equipo para Descansar"));
		}

		int numEquipos = equipos.size();
		int numJornadas = numEquipos - 1;

		// Listas para almacenar los índices de los equipos en las jornadas de ida y
		// vuelta
		List<Integer> indicesIda = new ArrayList<>();
		List<Integer> indicesVuelta = new ArrayList<>();

		// Inicializar las listas con los índices de los equipos
		for (int i = 0; i < numEquipos; i++) {
			indicesIda.add(i);
			indicesVuelta.add(i);
		}

		// Generar jornadas de ida
		for (int i = 0; i < numJornadas; i++) {
			Jornada jornadaIda = new Jornada();
			jornadaIda.setNumero(i + 1);
			jornadaIda.setFecha(sacarFechaNueva(fechaInicio, i));
			jornadaIda.setTemporada(temporada);

			// Crear partidos para la jornada de ida
			for (int j = 0; j < numEquipos / 2; j++) {
				int index1 = indicesIda.get(j);
				int index2 = indicesIda.get(numEquipos - 1 - j);

				Equipo equipo1 = equipos.get(index1);
				Equipo equipo2 = equipos.get(index2);

				Partido partido = new Partido(equipo1, equipo2, -1, -1);
				jornadaIda.getListaPartidos().add(partido);
			}

			jornadas.add(jornadaIda);

			// Rotar los equipos para la próxima jornada de ida
			indicesIda.add(1, indicesIda.remove(indicesIda.size() - 1));
		}

		// Generar jornadas de vuelta
		for (int i = 0; i < numJornadas; i++) {
			Jornada jornadaVuelta = new Jornada();
			int numeroJornadaVuelta = numJornadas + i + 1;
			jornadaVuelta.setNumero(numeroJornadaVuelta);
			jornadaVuelta.setFecha(sacarFechaNueva(fechaInicio, i + numJornadas + 1));
			jornadaVuelta.setTemporada(temporada);

			// Crear partidos para la jornada de vuelta
			for (int j = 0; j < numEquipos / 2; j++) {
				int index1 = indicesVuelta.get(j);
				int index2 = indicesVuelta.get(numEquipos - 1 - j);

				// Se invierten los equipos en las jorandas de vuelta
				Equipo equipo1 = equipos.get(index2);
				Equipo equipo2 = equipos.get(index1);

				Partido partido = new Partido(equipo1, equipo2, -1, -1);
				jornadaVuelta.getListaPartidos().add(partido);
			}

			jornadas.add(jornadaVuelta);

			// Rotar los equipos para la próxima jornada de vuelta
			indicesVuelta.add(1, indicesVuelta.remove(indicesVuelta.size() - 1));
		}

		return jornadas;
	}

	/**
	 * Funcion para Sacar la Fecha en cada Jornada.
	 *
	 * @param fechaInicio la Fecha de Inicio de la Temporada
	 * @param semanas     el numero de semanas que se suman a fechaInicio
	 * @return la Fecha de la Jornada
	 */
	public static Fecha sacarFechaNueva(Fecha fechaInicio, int semanas) {
		Calendar calendar = fechaInicio.getCalendar();
		// Añadir las semanas a la fecha de fin
		calendar.add(Calendar.WEEK_OF_YEAR, semanas);
		return new Fecha(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.YEAR));
	}

}
