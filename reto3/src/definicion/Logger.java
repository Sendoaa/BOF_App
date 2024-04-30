package definicion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * La Clase Logger.
 */
public class Logger implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = -7021149973598236767L;

	/** La Constante FILENAME que indica la ubicacion del fichero. */
	private static final String FILENAME = "ficheros/logs.ser";

	/** El Usuario. */
	private Usuario Usuario;

	/** El Tipo de Movimiento. */
	private String TipoMovimiento;

	/** La Fecha. */
	private Fecha Fecha;

	/** El Horario. */
	private Horario Horario;

	/**
	 * Instancia para crear un nuevo Log por defecto.
	 */
	// Contrustor por defecto
	public Logger() {
		this.Usuario = new Usuario();
		this.TipoMovimiento = "";
		this.Fecha = new Fecha();
		this.Horario = new Horario();
	}

	/**
	 * Instancia para crear un nuevo Log copia.
	 *
	 * @param l el Log copia
	 */
	// Contructor copia
	public Logger(Logger l) {
		this.Usuario = l.Usuario;
		this.TipoMovimiento = l.TipoMovimiento;
		this.Fecha = l.Fecha;
		this.Horario = l.Horario;
	}

	/**
	 * Instancia para crear un nuevo Log personalizado.
	 *
	 * @param u  el Usuario
	 * @param tm el Tipo de Movimiento
	 * @param f  la Fecha
	 * @param h  el Horario
	 */
	// Contructor personalizado
	public Logger(Usuario u, String tm, Fecha f, Horario h) {
		this.Usuario = u;
		this.TipoMovimiento = tm;
		this.Fecha = f;
		this.Horario = h;
	}

	/**
	 * Funcion To string.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return (Usuario.getNombre() + ": " + TipoMovimiento + " " + Fecha + " " + Horario);
	}

	/**
	 * Obtener el Usuario.
	 *
	 * @return el Usuario
	 */
	public Usuario getUsuario() {
		return Usuario;
	}

	/**
	 * Asignar el Usuario.
	 *
	 * @param usuario el nuevo Usuario
	 */
	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	/**
	 * Obtener el Tipo de Movimiento.
	 *
	 * @return el Tipo de Movimiento
	 */
	public String getTipoMovimiento() {
		return TipoMovimiento;
	}

	/**
	 * Asignar el Tipo de Movimiento.
	 *
	 * @param tipoMovimiento el nuevo Tipo de Movimiento
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
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
	 * Obtener el Horario.
	 *
	 * @return el Horario
	 */
	public Horario getHorario() {
		return Horario;
	}

	/**
	 * Asignar el Horario.
	 *
	 * @param horario el nuevo Horario
	 */
	public void setHorario(Horario horario) {
		Horario = horario;
	}

	/**
	 * Funcion Hash code.
	 *
	 * @return el hashCode de los Objetos a Comparar
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Usuario, TipoMovimiento, Fecha);
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
		Logger other = (Logger) obj;
		// Si tienen el mismo contenido devuelvo true
		return Objects.equals(this.Usuario, other.Usuario) && Objects.equals(this.TipoMovimiento, other.TipoMovimiento)
				&& Objects.equals(this.Fecha, other.Fecha);
	}

	/**
	 * Funcion para Guardar movimientos en el fichero.
	 *
	 * @param movimientos la Lista de Movimientos
	 */
	// Guarda la lista de movimientos en un archivo
	public static void guardarMovimientos(ArrayList<Logger> movimientos) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
			oos.writeObject(movimientos);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para Cargar movimientos desde fichero.
	 *
	 * @return el ArrayList de Movimientos
	 */
	// Carga la lista de movimientos desde un archivo
	@SuppressWarnings("unchecked")
	public static ArrayList<Logger> cargarMovimientos() {
		ArrayList<Logger> movimientos = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
			movimientos = (ArrayList<Logger>) ois.readObject();
		} catch (FileNotFoundException e) {
			// El archivo no existe, se creará uno nuevo cuando sea necesario
		} catch (IOException | ClassNotFoundException e) {
			if (!movimientos.isEmpty()) {
				e.printStackTrace();
			}
		}
		return movimientos;
	}

}
