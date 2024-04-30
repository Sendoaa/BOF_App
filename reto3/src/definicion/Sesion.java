package definicion;

/**
 * La Clase Sesion.
 */
public class Sesion {

	/** El Usuario Actual. */
	private static Usuario UsuarioActual;

	/**
	 * Obtener el Usuario Actual.
	 *
	 * @return el Usuario Actual
	 */
	public static Usuario getUsuarioActual() {
		return UsuarioActual;
	}

	/**
	 * Asignar el Usuario Actual.
	 *
	 * @param usuario el nuevo Usuario Actual
	 */
	public static void setUsuarioActual(Usuario usuario) {
		UsuarioActual = usuario;
	}
}
