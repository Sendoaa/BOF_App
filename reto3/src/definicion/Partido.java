package definicion;

import java.io.Serializable;

/**
 * La Clase Partido.
 */
public class Partido implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = -3447802470040493796L;

	/** El Equipo Local. */
	private Equipo EquipoLocal;

	/** Los Puntos del Local. */
	private Integer PuntosLocal;

	/** El Equipo Visitante. */
	private Equipo EquipoVisitante;

	/** Los Puntos del Visitante. */
	private Integer PuntosVisitante;

	/** Si el partido esta Jugado. */
	private Boolean Jugado;

	/**
	 * Instancia para crear un nuevo Partido por defecto.
	 */
	// Contrustor por defecto
	public Partido() {
		this.EquipoLocal = new Equipo();
		this.PuntosLocal = null;
		this.EquipoVisitante = new Equipo();
		this.PuntosVisitante = null;
		this.Jugado = false;
	}

	/**
	 * Instancia para crear un nuevo Partido copia.
	 *
	 * @param p el Partido copia
	 */
	// Contructor copia
	public Partido(Partido p) {
		this.EquipoLocal = p.EquipoLocal;
		this.PuntosLocal = p.PuntosLocal;
		this.EquipoVisitante = p.EquipoVisitante;
		this.PuntosVisitante = p.PuntosVisitante;
		this.Jugado = p.Jugado;
	}

	/**
	 * Instancia para crear un nuevo Partido personalizado.
	 *
	 * @param el el Equipo Local
	 * @param ev el Equipo Visitante
	 * @param pl los Puntos del Local
	 * @param pv los Puntos del Visitante
	 */
	// Contructor personalizado
	public Partido(Equipo el, Equipo ev, Integer pl, Integer pv) {
		this.EquipoLocal = el;
		this.PuntosLocal = pl;
		this.EquipoVisitante = ev;
		this.PuntosVisitante = pv;
		this.Jugado = false;
	}

	/**
	 * Instancia para crear un nuevo Partido personalizado.
	 *
	 * @param el el Equipo Local
	 * @param ev el Equipo Visitante
	 * @param pl los Puntos del Local
	 * @param pv los Puntos del Visitante
	 * @param j  si el partido esta Jugado
	 */
	// Contructor personalizado
	public Partido(Equipo el, Equipo ev, Integer pl, Integer pv, Boolean j) {
		this.EquipoLocal = el;
		this.PuntosLocal = pl;
		this.EquipoVisitante = ev;
		this.PuntosVisitante = pv;
		this.Jugado = j;
	}

	/**
	 * Funcion To string.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return ("Equipo Local:" + EquipoLocal + ", Puntos del Local:" + PuntosLocal + "Equipo Visitante:"
				+ EquipoVisitante + ", Puntos del Visitante:" + PuntosVisitante);
	}

	/**
	 * Obtener el Equipo Local.
	 *
	 * @return el Equipo Local
	 */
	public Equipo getEquipoLocal() {
		return EquipoLocal;
	}

	/**
	 * Asignar el Equipo Local.
	 *
	 * @param equipoLocal el nuevo Equipo Local
	 */
	public void setEquipoLocal(Equipo equipoLocal) {
		EquipoLocal = equipoLocal;
	}

	/**
	 * Obtener los Puntos del Local.
	 *
	 * @return los Puntos del Local
	 */
	public Integer getPuntosLocal() {
		return PuntosLocal;
	}

	/**
	 * Asignar los Puntos del Local.
	 *
	 * @param puntosLocal los nuevos Puntos del Local
	 */
	public void setPuntosLocal(Integer puntosLocal) {
		PuntosLocal = puntosLocal;
	}

	/**
	 * Obtener el Equipo Visitante.
	 *
	 * @return el Equipo Visitante
	 */
	public Equipo getEquipoVisitante() {
		return EquipoVisitante;
	}

	/**
	 * Asignar el Equipo Visitante.
	 *
	 * @param equipoVisitante el nuevo Equipo Visitante
	 */
	public void setEquipoVisitante(Equipo equipoVisitante) {
		EquipoVisitante = equipoVisitante;
	}

	/**
	 * Obtener los Puntos del Visitante.
	 *
	 * @return los Puntos del Visitante
	 */
	public Integer getPuntosVisitante() {
		return PuntosVisitante;
	}

	/**
	 * Asignar los Puntos del Visitante.
	 *
	 * @param puntosVisitante los nuevos Puntos del Visitante
	 */
	public void setPuntosVisitante(Integer puntosVisitante) {
		PuntosVisitante = puntosVisitante;
	}

	/**
	 * Obtener si el partido ha sido Jugado.
	 *
	 * @return si el partido ha sido Jugado.
	 */
	public Boolean getJugado() {
		return Jugado;
	}

	/**
	 * Asignar si el partido ha sido Jugado.
	 *
	 * @param jugado indica si el partido ha sido Jugado.
	 */
	public void setJugado(Boolean jugado) {
		Jugado = jugado;
	}

	/**
	 * Funcion para Determinar ganador.
	 *
	 * @param partido el Partido
	 * @return un String que indica el vencedor
	 */
	// Función para determinar el ganador de un partido
	public static String determinarGanador(Partido partido) {
		int puntosLocal = partido.getPuntosLocal();
		int puntosVisitante = partido.getPuntosVisitante();

		if (puntosLocal > puntosVisitante) {
			return "Local";
		} else if (puntosLocal < puntosVisitante) {
			return "Visitante";
		}
		return "Empate";

	}
}
