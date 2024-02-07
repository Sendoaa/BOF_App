package definicion;

import java.io.Serializable;

/**
 * La Clase Horario.
 */
public class Horario implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1307437293073492995L;

	/** La Hora. */
	private Integer Hora;

	/** El Minuto. */
	private Integer Minuto;

	/**
	 * Instancia para crear un nuevo Horario por defecto.
	 */
	// Contrustor por defecto
	public Horario() {
		this.Hora = 0;
		this.Minuto = 0;
	}

	/**
	 * Instancia para crear un nuevo Horario copia.
	 *
	 * @param h el Horario copia
	 */
	// Contructor copia
	public Horario(Horario h) {
		this.Hora = h.Hora;
		this.Minuto = h.Minuto;
	}

	/**
	 * Instancia para crear un nuevo Horario personalizado.
	 *
	 * @param h la hora
	 * @param m el minuto
	 */
	// Contructor personalizado
	public Horario(Integer h, Integer m) {
		this.Hora = h;
		this.Minuto = m;
	}

	/**
	 * Obtener la Hora.
	 *
	 * @return la Hora
	 */
	public Integer getHora() {
		return Hora;
	}

	/**
	 * Asignar la Hora.
	 *
	 * @param hora la nueva Hora
	 */
	public void setHora(Integer hora) {
		Hora = hora;
	}

	/**
	 * Obtener el Minuto.
	 *
	 * @return el Minuto
	 */
	public Integer getMinuto() {
		return Minuto;
	}

	/**
	 * Asignar el Minuto.
	 *
	 * @param minuto el nuevo Minuto
	 */
	public void setMinuto(Integer minuto) {
		Minuto = minuto;
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
	 * Funcion To String.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		if (Minuto >= 0 && Minuto <= 9) {
			return (Hora + ":0" + Minuto);
		}
		return (Hora + ":" + Minuto);
	}
}
