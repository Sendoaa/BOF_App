package definicion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La Clase Equipo.
 */
public class Equipo implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = -1650289960010952509L;

	/** La Constante FILENAME que indica la ubicacion del fichero. */
	private static final String FILENAME = "ficheros/equipos.ser";

	/** El Nombre. */
	private String Nombre;

	/** El Escudo. */
	private String Escudo;

	/** La Descripcion. */
	private String Descripcion;

	/** El Entrenador. */
	private Entrenador Entrenador;

	/** La Lista de Jugadores. */
	private List<Jugador> ListaJugadores;

	/** La Lista de estadisticas por temporada. */
	private List<Estadisticas> estadisticasPorTemporada;

	/**
	 * Instancia para crear un nuevo Equipo por defecto.
	 */
	// Constructor por defecto
	public Equipo() {
		this.Nombre = "";
		this.Escudo = "";
		this.Descripcion = "";
		this.Entrenador = new Entrenador();
		this.ListaJugadores = new ArrayList<Jugador>();
		this.estadisticasPorTemporada = new ArrayList<Estadisticas>();
	}

	/**
	 * Instancia para crear un nuevo Equipo copia.
	 *
	 * @param e el Equipo copia
	 */
	// Constructor copia
	public Equipo(Equipo e) {
		this.Nombre = e.Nombre;
		this.Escudo = e.Escudo;
		this.Descripcion = e.Descripcion;
		this.Entrenador = e.Entrenador;
		this.ListaJugadores = e.ListaJugadores;
		this.estadisticasPorTemporada = e.estadisticasPorTemporada;
	}

	/**
	 * Instancia para crear un nuevo Equipo personalizado.
	 *
	 * @param n   el Nombre
	 * @param esc el Escudo
	 * @param d   la Descripcion
	 * @param e   el Entrenador
	 * @param lj  la Lista de Jugadores
	 * @param es  la Lista de Estadisticas por Temporada
	 */
	// Constructor personalizado
	public Equipo(String n, String esc, String d, Entrenador e, List<Jugador> lj, List<Estadisticas> es) {
		this.Nombre = n;
		this.Escudo = esc;
		this.Descripcion = d;
		this.Entrenador = e;
		this.ListaJugadores = lj;
		this.estadisticasPorTemporada = es;
	}

	/**
	 * Instancia para crear un nuevo Equipo personalizado.
	 *
	 * @param n   el Nombre
	 * @param esc el Escudo
	 * @param d   la Descripcion
	 * @param e   el Entrenador
	 * @param lj  la Lista de Jugadores
	 */
	// Constructor personalizado
	public Equipo(String n, String esc, String d, Entrenador e, List<Jugador> lj) {
		this.Nombre = n;
		this.Escudo = esc;
		this.Descripcion = d;
		this.Entrenador = e;
		this.ListaJugadores = lj;
		this.estadisticasPorTemporada = new ArrayList<Estadisticas>();
	}

	/**
	 * Instancia para crear un nuevo Equipo personalizado.
	 *
	 * @param n el Nombre
	 */
	// Constructor personalizado
	public Equipo(String n) {
		this.Nombre = n;
		this.Escudo = "";
		this.Descripcion = "";
		this.Entrenador = new Entrenador();
		this.ListaJugadores = new ArrayList<Jugador>();
		this.estadisticasPorTemporada = new ArrayList<Estadisticas>();
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
	 * Obtener el Escudo.
	 *
	 * @return el Escudo
	 */
	public String getEscudo() {
		return Escudo;
	}

	/**
	 * Asignar el Escudo.
	 *
	 * @param escudo el nuevo Escudo
	 */
	public void setEscudo(String escudo) {
		Escudo = escudo;
	}

	/**
	 * Obtener la Descripcion.
	 *
	 * @return la Descripcion
	 */
	public String getDescripcion() {
		return Descripcion;
	}

	/**
	 * Asignar la Descripcion.
	 *
	 * @param descripcion la nueva Descripcion
	 */
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	/**
	 * Obtener el Entrenador.
	 *
	 * @return el Entrenador
	 */
	public Entrenador getEntrenador() {
		return Entrenador;
	}

	/**
	 * Asignar el Entrenador.
	 *
	 * @param entrenador el nuevo Entrenador
	 */
	public void setEntrenador(Entrenador entrenador) {
		Entrenador = entrenador;
	}

	/**
	 * Obtener la Lista de Jugadores.
	 *
	 * @return la Lista de Jugadores
	 */
	public List<Jugador> getListaJugadores() {
		return ListaJugadores;
	}

	/**
	 * Asignar la Lista de Jugadores.
	 *
	 * @param listaJugadores la nueva Lista de Jugadores
	 */
	public void setListaJugadores(List<Jugador> listaJugadores) {
		ListaJugadores = listaJugadores;
	}

	/**
	 * Obtener la Lista de Estadisticas por Temporada.
	 *
	 * @return la Lista de Estadisticas por Temporada
	 */
	public List<Estadisticas> getEstadisticasPorTemporada() {
		return estadisticasPorTemporada;
	}

	/**
	 * Asignar la Lista de Estadisticas por Temporada.
	 *
	 * @param estadisticasPorTemporada la nueva Lista de Estadisticas por Temporada
	 */
	public void setEstadisticasPorTemporada(List<Estadisticas> estadisticasPorTemporada) {
		this.estadisticasPorTemporada = estadisticasPorTemporada;
	}

	/**
	 * Funcion To string.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return (Nombre + " ");
	}
	
	/**
	 * Funcion To XML.
	 *
	 * @return Informacion en formato XML
	 */
	public String toXML() {
		return ("<nombre>"+ Nombre +"</nombre><imagen>../xml/XML_temporada"+ Seleccion.getTemporadaNumero() +"/escudos/"+ Nombre + obtenerExtension(Escudo) + "</imagen>");
	}
	
	/**
	 *  Método para obtener la extensión del archivo de imagen del escudo
	 *
	 * @param fileName el Escudo
	 */
	private String obtenerExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
			return fileName.substring(dotIndex);
		}
		return ""; // Si no se encuentra extensión o no está presente en el nombre del archivo
	}

	/**
	 * Funcion Hash code.
	 *
	 * @return el hashCode de los Objetos a Comparar
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Nombre);
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
		Equipo other = (Equipo) obj;
		// Si tienen el mismo contenido devuelvo true
		return Objects.equals(this.Nombre, other.Nombre);
	}

	/**
	 * Funcion para Guardar equipos en el fichero.
	 *
	 * @param lstEquipos la Lista de Equipos
	 */
	// Guarda la lista de equipos en un archivo
	public static void guardarEquipos(ArrayList<Equipo> lstEquipos) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
			oos.writeObject(lstEquipos);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para Cargar equipos desde fichero.
	 *
	 * @return el ArrayList de Equipos
	 */
	// Carga la lista de equipos desde un archivo
	@SuppressWarnings("unchecked")
	public static ArrayList<Equipo> cargarEquipos() {
		ArrayList<Equipo> equipos = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
			equipos = (ArrayList<Equipo>) ois.readObject();
		} catch (FileNotFoundException e) {
			// El archivo no existe, se creará uno nuevo cuando sea necesario
		} catch (IOException | ClassNotFoundException e) {
			if (!equipos.isEmpty()) {
				e.printStackTrace();
			}
		}
		return equipos;
	}

	/**
	 * Funcion para Actualizar estadisticas por temporada.
	 *
	 * @param partido      el partido
	 * @param temporada    la temporada
	 * @param nombreEquipo el nombre del equipo
	 */
	public void actualizarEstadisticas(Partido partido, Temporada temporada, String nombreEquipo) {
		// Obtener las estadísticas actuales del equipo para la temporada específica
		Estadisticas estadisticasActuales = obtenerEstadisticasPorTemporada(temporada);

		// Verificar si el equipo tiene 0 puntos en el partido
		Integer puntosLocal = partido.getPuntosLocal();
		Integer puntosVisitante = partido.getPuntosVisitante();

		int puntosEquipo = (nombreEquipo.equals(partido.getEquipoLocal().getNombre()))
				? (puntosLocal != null ? puntosLocal : 0)
				: (puntosVisitante != null ? puntosVisitante : 0);

		if (puntosEquipo != -1) {
			// Marcar el partido como jugado
			partido.setJugado(true);

			// Incrementar el número de partidos jugados
			estadisticasActuales.setPartidosJugados(estadisticasActuales.getPartidosJugados() + 1);

			// Determinar el resultado del partido y actualizar las estadísticas
			// correspondientes
			if (nombreEquipo.equals(partido.getEquipoLocal().getNombre())) {
				// El equipo local está involucrado en el partido
				if (Partido.determinarGanador(partido).equals("Local")) {
					// El equipo local ha ganado
					estadisticasActuales.setPartidosGanados(estadisticasActuales.getPartidosGanados() + 1);
					// Incrementar los puntos totales en 2 (por ganar)
					estadisticasActuales.setPuntosTotales(estadisticasActuales.getPuntosTotales() + 2);
				} else if (Partido.determinarGanador(partido).equals("Visitante")) {
					// El equipo local ha perdido
					estadisticasActuales.setPartidosPerdidos(estadisticasActuales.getPartidosPerdidos() + 1);
				} else {
					// Empate
					estadisticasActuales.setPartidosEmpatados(estadisticasActuales.getPartidosEmpatados() + 1);
					// Incrementar los puntos totales en 1 (por empatar)
					estadisticasActuales.setPuntosTotales(estadisticasActuales.getPuntosTotales() + 1);
				}

				// Actualizar los puntos a favor y en contra
				estadisticasActuales.setPuntosFavor(estadisticasActuales.getPuntosFavor() + partido.getPuntosLocal());
				estadisticasActuales.setPuntosContra(estadisticasActuales.getPuntosContra() + partido.getPuntosVisitante());
			} else if (nombreEquipo.equals(partido.getEquipoVisitante().getNombre())) {
				// El equipo visitante está involucrado en el partido
				if (Partido.determinarGanador(partido).equals("Visitante")) {
					// El equipo visitante ha ganado
					estadisticasActuales.setPartidosGanados(estadisticasActuales.getPartidosGanados() + 1);
					// Incrementar los puntos totales en 2 (por ganar)
					estadisticasActuales.setPuntosTotales(estadisticasActuales.getPuntosTotales() + 2);
				} else if (Partido.determinarGanador(partido).equals("Local")) {
					// El equipo visitante ha perdido
					estadisticasActuales.setPartidosPerdidos(estadisticasActuales.getPartidosPerdidos() + 1);
				} else {
					// Empate
					estadisticasActuales.setPartidosEmpatados(estadisticasActuales.getPartidosEmpatados() + 1);
					// Incrementar los puntos totales en 1 (por empatar)
					estadisticasActuales.setPuntosTotales(estadisticasActuales.getPuntosTotales() + 1);
				}

				// Actualizar los puntos a favor y en contra
				estadisticasActuales.setPuntosFavor(estadisticasActuales.getPuntosFavor() + partido.getPuntosVisitante());
				estadisticasActuales.setPuntosContra(estadisticasActuales.getPuntosContra() + partido.getPuntosLocal());
			}
		}
	}

	/**
	 * Funcion para Obtener estadisticas por temporada.
	 *
	 * @param temporada la temporada
	 * @return las Estadisticas
	 */
	private Estadisticas obtenerEstadisticasPorTemporada(Temporada temporada) {
		for (Estadisticas est : estadisticasPorTemporada) {
			if (est.getTemporada().equals(temporada)) {
				return est;
			}
		}
		// Si no se encuentra, crear y agregar nuevas estadísticas para la temporada
		Estadisticas nuevasEstadisticas = new Estadisticas(temporada);
		estadisticasPorTemporada.add(nuevasEstadisticas);
		return nuevasEstadisticas;
	}

}
