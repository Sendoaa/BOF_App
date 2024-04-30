package definicion;

/**
 * La Clase EquipoSeleccion.
 */
public class EquipoSeleccion {

	/** El Guardado, para comprobar si ha sido editado el equipo. */
	private static Boolean Guardado;

	/**
	 * La Posicion del Equipo, para averiguar en que parte de la lista se encuentra.
	 */
	private static Integer EquipoPosicion;

	/**
	 * El Equipo seleccionado, para comprobar que equipo se selecciono en la lista.
	 */
	private static Equipo EquipoSeleccionado;

	/**
	 * Obtener el Equipo Seleccionado.
	 *
	 * @return el Equipo Seleccionado
	 */
	public static Equipo getEquipoSeleccionado() {
		return EquipoSeleccionado;
	}

	/**
	 * Asignar el Equipo Seleccionado.
	 *
	 * @param equipoSeleccionado el nuevo Equipo Seleccionado
	 */
	public static void setEquipoSeleccionado(Equipo equipoSeleccionado) {
		EquipoSeleccionado = equipoSeleccionado;
	}

	/**
	 * Obtener la Posicion del Equipo en la Lista.
	 *
	 * @return la Posicion del Equipo en la Lista
	 */
	public static Integer getEquipoPosicion() {
		return EquipoPosicion;
	}

	/**
	 * Asignar la Posicion del Equipo en la Lista.
	 *
	 * @param equipoPosicion la nueva Posicion del Equipo en la Lista
	 */
	public static void setEquipoPosicion(Integer equipoPosicion) {
		EquipoPosicion = equipoPosicion;
	}

	/**
	 * Obtener la informacion de Guardado.
	 *
	 * @return la informacion de Guardado
	 */
	public static Boolean getGuardado() {
		return Guardado;
	}

	/**
	 * Asignar el Guardado.
	 *
	 * @param guardado el nuevo Guardado
	 */
	public static void setGuardado(Boolean guardado) {
		Guardado = guardado;
	}

}
