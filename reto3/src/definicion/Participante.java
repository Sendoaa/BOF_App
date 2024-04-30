package definicion;

import java.io.Serializable;

/**
 * La Clase Participante.
 */
public class Participante implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 2367560212698757456L;

	/** El DNI. */
	private String DNI;

	/** El Nombre. */
	private String Nombre;

	/** El Apellido. */
	private String Apellido;

	/** La Nacionalidad. */
	private String Nacionalidad;

	/**
	 * Instancia para crear un nuevo Participante por defecto.
	 */
	// Contrustor por defecto
	public Participante() {
		this.DNI = "";
		this.Nombre = "";
		this.Apellido = "";
		this.Nacionalidad = "";
	}

	/**
	 * Instancia para crear un nuevo Participante copia.
	 *
	 * @param p el Participante copia
	 */
	// Contructor copia
	public Participante(Participante p) {
		this.DNI = p.DNI;
		this.Nombre = p.Nombre;
		this.Apellido = p.Apellido;
		this.Nacionalidad = p.Nacionalidad;
	}

	/**
	 * Instancia para crear un nuevo Participante personalizado.
	 *
	 * @param d   el DNI
	 * @param n   el Nombre
	 * @param a   el Apellido
	 * @param nac la Nacionalidad
	 */
	// Contructor personalizado
	public Participante(String d, String n, String a, String nac) {
		this.DNI = d;
		this.Nombre = n;
		this.Apellido = a;
		this.Nacionalidad = nac;
	}

	/**
	 * Funcion To string.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return (DNI + " | " + Nombre + " | " + Apellido + " | " + Nacionalidad);
	}

	/**
	 * Obtener el DNI.
	 *
	 * @return el DNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * Asignar el DNI.
	 *
	 * @param dni el nuevo DNI
	 */
	public void setDNI(String dni) {
		DNI = dni;
	}

	/**
	 * Obtener el Nombre.
	 *
	 * @return el Nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * Asignar el Nombre.
	 *
	 * @param nombre el nuevo Nombre
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * Obtener el Apellido.
	 *
	 * @return el Apellido
	 */
	public String getApellido() {
		return Apellido;
	}

	/**
	 * Asignar el Apellido.
	 *
	 * @param apellido el nuevo Apellido
	 */
	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	/**
	 * Obtener la Nacionalidad.
	 *
	 * @return la Nacionalidad
	 */
	public String getNacionalidad() {
		return Nacionalidad;
	}

	/**
	 * Asignar la Nacionalidad.
	 *
	 * @param nacionalidad la nueva Nacionalidad.
	 */
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	/**
	 * Obtener el serialversionuid.
	 *
	 * @return el serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
