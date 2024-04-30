package definicion;

import java.io.Serializable;
import java.util.Objects;

/**
 * La Clase Estadisticas.
 */
public class Estadisticas implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = -6139057543933527268L;

	/** La Temporada. */
	private Temporada Temporada;

	/** Los Puntos Totales. */
	private Integer PuntosTotales;

	/** Los Partidos Jugados. */
	private Integer PartidosJugados;

	/** Los Partidos Ganados. */
	private Integer PartidosGanados;

	/** Los Partidos Empatados. */
	private Integer PartidosEmpatados;

	/** Los Partidos Perdidos. */
	private Integer PartidosPerdidos;

	/** Los Puntos a Favor. */
	private Integer PuntosFavor;

	/** Los Puntos en Contra. */
	private Integer PuntosContra;

	/**
	 * Instancia para crear unas nuevas Estadisticas por defecto.
	 */
	// Contrustor por defecto
	public Estadisticas() {
		this.Temporada = new Temporada();
		this.PuntosTotales = 0;
		this.PartidosJugados = 0;
		this.PartidosGanados = 0;
		this.PartidosEmpatados = 0;
		this.PartidosPerdidos = 0;
		this.PuntosFavor = 0;
		this.PuntosContra = 0;
	}

	/**
	 * Instancia para crear unas nuevas Estadisticas copia.
	 *
	 * @param e las Estadisticas copia
	 */
	// Contructor copia
	public Estadisticas(Estadisticas e) {
		this.Temporada = e.Temporada;
		this.PuntosTotales = e.PuntosTotales;
		this.PartidosJugados = e.PartidosJugados;
		this.PartidosGanados = e.PartidosGanados;
		this.PartidosEmpatados = e.PartidosEmpatados;
		this.PartidosPerdidos = e.PartidosPerdidos;
		this.PuntosFavor = e.PuntosFavor;
		this.PuntosContra = e.PuntosContra;
	}

	/**
	 * Instancia para crear unas nuevas Estadisticas personalizadas.
	 *
	 * @param t  la Temporada
	 * @param pt los Puntos Totales
	 * @param pj los Partidos Jugados
	 * @param pg los Partidos Ganados
	 * @param pe los Partidos Empatados
	 * @param pp Los Partidos Perdidos
	 * @param pf Los Puntos a Favor
	 * @param pc Los Puntos en Contra
	 */
	// Contructor personalizado
	public Estadisticas(Temporada t, Integer pt, Integer pj, Integer pg, Integer pe, Integer pp, Integer pf,
			Integer pc) {
		this.Temporada = t;
		this.PuntosTotales = pt;
		this.PartidosJugados = pj;
		this.PartidosGanados = pg;
		this.PartidosEmpatados = pe;
		this.PartidosPerdidos = pp;
		this.PuntosFavor = pf;
		this.PuntosContra = pc;
	}

	/**
	 * Instancia para crear unas nuevas Estadisticas personalizadas.
	 *
	 * @param t la Temporada
	 */
	// Contructor personalizado
	public Estadisticas(Temporada t) {
		this.Temporada = t;
		this.PuntosTotales = 0;
		this.PartidosJugados = 0;
		this.PartidosGanados = 0;
		this.PartidosEmpatados = 0;
		this.PartidosPerdidos = 0;
		this.PuntosFavor = 0;
		this.PuntosContra = 0;
	}

	/**
	 * Obtener los Puntos Totales.
	 *
	 * @return los Puntos Totales
	 */
	public Integer getPuntosTotales() {
		return PuntosTotales;
	}

	/**
	 * Asignar los Puntos Totales.
	 *
	 * @param puntosTotales los nuevos Puntos Totales
	 */
	public void setPuntosTotales(Integer puntosTotales) {
		PuntosTotales = puntosTotales;
	}

	/**
	 * Obtener los Partidos Jugados.
	 *
	 * @return los Partidos Jugados
	 */
	public Integer getPartidosJugados() {
		return PartidosJugados;
	}

	/**
	 * Asignar los Partidos Jugados.
	 *
	 * @param partidosJugados los nuevos Partidos Jugados
	 */
	public void setPartidosJugados(Integer partidosJugados) {
		PartidosJugados = partidosJugados;
	}

	/**
	 * Obtener los Partidos Ganados.
	 *
	 * @return los Partidos Ganados
	 */
	public Integer getPartidosGanados() {
		return PartidosGanados;
	}

	/**
	 * Asignar los Partidos Ganados.
	 *
	 * @param partidosGanados los nuevos Partidos Ganados
	 */
	public void setPartidosGanados(Integer partidosGanados) {
		PartidosGanados = partidosGanados;
	}

	/**
	 * Obtener los Partidos Empatados.
	 *
	 * @return los Partidos Empatados
	 */
	public Integer getPartidosEmpatados() {
		return PartidosEmpatados;
	}

	/**
	 * Asignar los Partidos Empatados.
	 *
	 * @param partidosEmpatados los nuevos Partidos Empatados
	 */
	public void setPartidosEmpatados(Integer partidosEmpatados) {
		PartidosEmpatados = partidosEmpatados;
	}

	/**
	 * Obtener los Partidos Perdidos.
	 *
	 * @return los Partidos Perdidos
	 */
	public Integer getPartidosPerdidos() {
		return PartidosPerdidos;
	}

	/**
	 * Asignar los Partidos Perdidos.
	 *
	 * @param partidosPerdidos los nuevos Partidos Perdidos
	 */
	public void setPartidosPerdidos(Integer partidosPerdidos) {
		PartidosPerdidos = partidosPerdidos;
	}

	/**
	 * Obtener los Puntos a Favor.
	 *
	 * @return los Puntos a Favor
	 */
	public Integer getPuntosFavor() {
		return PuntosFavor;
	}

	/**
	 * Asignar los Puntos a Favor.
	 *
	 * @param puntosFavor los nuevos Puntos a Favor
	 */
	public void setPuntosFavor(Integer puntosFavor) {
		PuntosFavor = puntosFavor;
	}

	/**
	 * Obtener los Puntos en Contra.
	 *
	 * @return los Puntos en Contra
	 */
	public Integer getPuntosContra() {
		return PuntosContra;
	}

	/**
	 * Asignar los Puntos en Contra.
	 *
	 * @param puntosContra los nuevos Puntos en Contra
	 */
	public void setPuntosContra(Integer puntosContra) {
		PuntosContra = puntosContra;
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
		return (PuntosTotales + " " + PartidosJugados + " " + PartidosGanados + " " + PartidosEmpatados + " "
				+ PartidosPerdidos + " " + PuntosFavor + " " + PuntosContra);
	}
	
	/**
	 * Funcion To XML.
	 *
	 * @return Informacion en formato XML
	 */
	public String toXML() {
		return ("<G>"+ PartidosGanados +"</G><E>"+ PartidosEmpatados +"</E><P>"+ PartidosPerdidos +"</P><J>"+ PartidosJugados +"</J><PF>"+ PuntosFavor +"</PF><PC>"+ PuntosContra +"</PC><PT>"+ PuntosTotales +"</PT>");
	}

	/**
	 * Funcion Hash code.
	 *
	 * @return el hashCode de los Objetos a Comparar
	 */
	@Override
	public int hashCode() {
		return Objects.hash(PuntosTotales);
	}

	/**
	 * Funcion Compare to.
	 *
	 * @param estadisticas1 las Estadisticas de el Equipo 1
	 * @param estadisticas2 las Estadisticas de el Equipo 2
	 * @return un int, que indica cual es mayor que el otro o si son iguales
	 */
	public int compareTo(Estadisticas estadisticas1, Estadisticas estadisticas2) {
		// Comparar por puntos totales (orden descendente)
		int comparacion = Integer.compare(estadisticas2.getPuntosTotales(), estadisticas1.getPuntosTotales());
		if (comparacion != 0) {
			return comparacion;
		}

		// Comparar por partidos ganados (orden descendente)
		comparacion = Integer.compare(estadisticas2.getPartidosGanados(), estadisticas1.getPartidosGanados());
		if (comparacion != 0) {
			return comparacion;
		}

		// Comparar por partidos empatados (orden descendente)
		comparacion = Integer.compare(estadisticas2.getPartidosEmpatados(), estadisticas1.getPartidosEmpatados());
		if (comparacion != 0) {
			return comparacion;
		}

		// Comparar por partidos perdidos (orden descendente)
		comparacion = Integer.compare(estadisticas2.getPartidosPerdidos(), estadisticas1.getPartidosPerdidos());
		if (comparacion != 0) {
			return comparacion;
		}

		// Comparar por puntos a favor (orden descendente)
		comparacion = Integer.compare(estadisticas2.getPuntosFavor(), estadisticas1.getPuntosFavor());
		if (comparacion != 0) {
			return comparacion;
		}

		// Comparar por puntos en contra (orden ascendente)
		return Integer.compare(estadisticas1.getPuntosContra(), estadisticas2.getPuntosContra());
	}

}
