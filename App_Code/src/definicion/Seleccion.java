package definicion;

/**
 * La Clase Seleccion.
 */
public class Seleccion {

	/**
	 * La Posicion de la Temporada, para averiguar en que parte de la lista se
	 * encuentra.
	 */
	private static Integer TemporadaPosicion;

	/** El Numero de la Temporada seleccionada. */
	private static Integer TemporadaNumero;

	/**
	 * La Temporada seleccionada, para comprobar que temporada se selecciono en la
	 * lista.
	 */
	private static Temporada TemporadaSeleccionada = null;

	/**
	 * Obtener la Posicion de la Temporada en la Lista.
	 *
	 * @return la Posicion de la Temporada en la Lista
	 */
	public static Integer getTemporadaPosicion() {
		return TemporadaPosicion;
	}

	/**
	 * Asignar la Posicion de la Temporada en la Lista.
	 *
	 * @param temporadaPosicion la nueva Posicion de la Temporada en la Lista.
	 */
	public static void setTemporadaPosicion(Integer temporadaPosicion) {
		TemporadaPosicion = temporadaPosicion;
	}

	/**
	 * Obtener el Numero de la Temporada seleccionada.
	 *
	 * @return la Temporada Seleccionada
	 */
	public static Integer getTemporadaNumero() {
		return TemporadaNumero;
	}

	/**
	 * Asignar el Numero de la Temporada seleccionada.
	 *
	 * @param temporadaNumero el Numero de la nueva Temporada seleccionada
	 */
	public static void setTemporadaNumero(Integer temporadaNumero) {
		TemporadaNumero = temporadaNumero;
	}

	/**
	 * Obtener la Temporada Seleccionada.
	 *
	 * @return la Temporada Seleccionada
	 */
	public static Temporada getTemporadaSeleccionada() {
		return TemporadaSeleccionada;
	}

	/**
	 * Asignar la Temporada Seleccionada.
	 *
	 * @param temporadaSeleccionada la nueva Temporada Seleccionada
	 */
	public static void setTemporadaSeleccionada(Temporada temporadaSeleccionada) {
		TemporadaSeleccionada = temporadaSeleccionada;
	}
}
