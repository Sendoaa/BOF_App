package definicion;

import java.io.Serializable;
import java.util.Calendar;

/**
 * La Clase Fecha.
 */
public class Fecha implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1307437293073492995L;

	/** El Dia. */
	private Integer Dia;

	/** El Mes. */
	private Integer Mes;

	/** El Año. */
	private Integer Año;

	/**
	 * Instancia para crear una nueva Fecha por defecto.
	 */
	// Contrustor por defecto
	public Fecha() {
		this.Dia = 1;
		this.Mes = 1;
		this.Año = 2024;
	}

	/**
	 * Instancia para crear una nueva Fecha copia.
	 *
	 * @param f la Fecha copia
	 */
	// Contructor copia
	public Fecha(Fecha f) {
		this.Dia = f.Dia;
		this.Mes = f.Mes;
		this.Año = f.Año;
	}

	/**
	 * Instancia para crear una nueva Fecha personalizada.
	 *
	 * @param d el Dia
	 * @param m el Mes
	 * @param a el Año
	 */
	// Contructor personalizado
	public Fecha(Integer d, Integer m, Integer a) {
		this.Dia = d;
		this.Mes = m;
		this.Año = a;
	}

	public Fecha(String fechaCompleta) {
		String[] partes = fechaCompleta.split("-");
		this.Dia = Integer.parseInt(partes[2]);
		this.Mes = Integer.parseInt(partes[1]);
		this.Año = Integer.parseInt(partes[0]);
	}

	/**
	 * Funcion To String.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return (Dia + "/" + Mes + "/" + Año);
	}

	/**
	 * Obtener el Dia.
	 *
	 * @return el Dia
	 */
	public Integer getDia() {
		return Dia;
	}

	/**
	 * Asignar el Dia.
	 *
	 * @param dia el nuevo Dia
	 */
	public void setDia(Integer dia) {
		Dia = dia;
	}

	/**
	 * Obtener el Mes.
	 *
	 * @return el Mes
	 */
	public Integer getMes() {
		return Mes;
	}

	/**
	 * Asignar el Mes.
	 *
	 * @param mes el nuevo Mes
	 */
	public void setMes(Integer mes) {
		Mes = mes;
	}

	/**
	 * Obtener el Año.
	 *
	 * @return el Año
	 */
	public Integer getAño() {
		return Año;
	}

	/**
	 * Asignar el Año.
	 *
	 * @param año el nuevo Año
	 */
	public void setAño(Integer año) {
		Año = año;
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
	 * Obtener la Fecha Actual del Sistema con Calendar.
	 *
	 * @return la Fecha Actual del Sistema
	 */
	public Calendar getCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, Dia);
		calendar.set(Calendar.MONTH, Mes - 1); // Restamos 1 porque en Calendar los meses van de 0 a 11
		calendar.set(Calendar.YEAR, Año);
		return calendar;
	}
}
