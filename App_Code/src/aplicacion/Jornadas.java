package aplicacion;

//Eventos importados
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import definicion.Fecha;
import definicion.Horario;
import definicion.Jornada;
import definicion.Logger;
import definicion.Partido;
import definicion.Seleccion;
import definicion.Sesion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * La Clase Jornadas.
 */
public class Jornadas extends JFrame implements ActionListener, WindowListener {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1L;

	/** El Content Pane principal. */
	private JPanel contentPane;

	/** El Content Pane Superior. */
	private JPanel panelSuperior;

	/** El Boton de Cerrar Sesion. */
	private JButton btnCerrarSesion;

	/** El Content Pane Lateral. */
	private JPanel panelLateral;

	/** El Content Pane Central. */
	private JPanel panelCentral;

	/** El Boton de Temporadas. */
	private JButton btnTemporadas;

	/** El Boton de Clasificacion. */
	private JButton btnClasificacion;

	/** El Boton de Jornadas. */
	private JButton btnJornadas;

	/** El Boton de Equipos. */
	private JButton btnEquipos;

	/** El Boton de Panel. */
	private JButton btnPanel;

	/** El Boton de Editar Temporada. */
	private JButton btnEditarTemp;

	/** El Label de Temporada. */
	private JLabel lblTemporada;

	/** El Tabbed Pane de las Jornadas. */
	private JTabbedPane tabbedPaneJornadas;

	/** La Lista de Movimientos Totales que hay Registrados. */
	private ArrayList<Logger> ListaMovimientos;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jornadas frame = new Jornadas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Se Crea el Frame
	 */
	public Jornadas() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		// Añado acción listener
		this.addWindowListener(this);
		// Propiedades de la ventana
		setResizable(false);
		setTitle("Jornadas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 550);
		setLocationRelativeTo(null);
		// Crea un panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Hace que el panel sea absoluto
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Crea un panel
		panelSuperior = new JPanel();
		// Propiedades del panel
		panelSuperior.setBackground(new Color(74, 127, 214));
		panelSuperior.setBounds(0, 0, 1036, 90);
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(null);

		// Crea un botón
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 12));
		// Propiedades del boton
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setBackground(new Color(230, 230, 230));
		btnCerrarSesion.setFocusable(false);
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setBounds(22, 22, 119, 45);
		panelSuperior.add(btnCerrarSesion);

		// Crea un botón
		btnPanel = new JButton("Panel Administracion");
		btnPanel.setFont(new Font("Dialog", Font.BOLD, 12));
		// Añade accion de tipo listener al boton
		btnPanel.addActionListener(this);
		// Propiedades del boton
		btnPanel.setBackground(new Color(230, 230, 230));
		btnPanel.setBorder(null);
		btnPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPanel.setFocusable(false);
		btnPanel.setBounds(684, 22, 140, 45);
		panelSuperior.add(btnPanel);

		// Crea un botón
		btnEditarTemp = new JButton("Editar Temporada");
		btnEditarTemp.setForeground(new Color(255, 255, 255));
		btnEditarTemp.setFont(new Font("Dialog", Font.BOLD, 13));
		// Propiedades del botón
		btnEditarTemp.addActionListener(this);
		btnEditarTemp.setBackground(new Color(20, 185, 255));
		btnEditarTemp.setBorder(null);
		btnEditarTemp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarTemp.setFocusable(false);
		btnEditarTemp.setBounds(848, 22, 156, 45);
		panelSuperior.add(btnEditarTemp);

		// Crea un label
		lblTemporada = new JLabel("Temporada X");
		lblTemporada.setForeground(new Color(255, 255, 255));
		// Propiedades del label
		lblTemporada.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemporada.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTemporada.setBounds(303, 22, 429, 45);
		panelSuperior.add(lblTemporada);

		// Crea un panel
		panelLateral = new JPanel();
		// Propiedaddes del panel
		panelLateral.setBackground(new Color(128, 255, 255));
		panelLateral.setBounds(0, 88, 158, 435);
		contentPane.add(panelLateral);
		panelLateral.setLayout(null);

		// Crea un botón
		btnTemporadas = new JButton("Temporadas");
		btnTemporadas.setFont(new Font("Dialog", Font.BOLD, 15));
		// Propiedades del botón
		btnTemporadas.addActionListener(this);
		btnTemporadas.setForeground(new Color(255, 255, 255));
		btnTemporadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTemporadas.setFocusable(false);
		btnTemporadas.setBackground(new Color(20, 185, 255));
		btnTemporadas.setBounds(0, 0, 158, 108);
		panelLateral.add(btnTemporadas);

		// Crea un botón
		btnClasificacion = new JButton("Clasificación");
		btnClasificacion.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClasificacion.setForeground(new Color(255, 255, 255));
		// Propiedades del botón
		btnClasificacion.addActionListener(this);
		btnClasificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClasificacion.setFocusable(false);
		btnClasificacion.setBackground(new Color(20, 185, 255));
		btnClasificacion.setBounds(0, 106, 158, 108);
		panelLateral.add(btnClasificacion);

		// Crea un botón
		btnJornadas = new JButton("Jornadas");
		btnJornadas.setFont(new Font("Dialog", Font.BOLD, 15));
		btnJornadas.setForeground(new Color(255, 255, 255));
		// Propiedades del botón
		btnJornadas.setEnabled(false);
		btnJornadas.addActionListener(this);
		btnJornadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJornadas.setFocusable(false);
		btnJornadas.setBackground(new Color(184, 207, 222));
		btnJornadas.setBounds(0, 213, 158, 108);
		panelLateral.add(btnJornadas);

		// Crea un botón
		btnEquipos = new JButton("Equipos");
		btnEquipos.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEquipos.setForeground(new Color(255, 255, 255));
		// Propiedades del botón
		btnEquipos.addActionListener(this);
		btnEquipos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEquipos.setFocusable(false);
		btnEquipos.setBackground(new Color(20, 185, 255));
		btnEquipos.setBounds(0, 318, 158, 108);
		panelLateral.add(btnEquipos);

		// Crea un panel
		panelCentral = new JPanel();
		// Propiedades del panel
		panelCentral.setFocusable(false);
		panelCentral.setBounds(159, 91, 874, 432);
		contentPane.add(panelCentral);
		panelCentral.setLayout(null);

		tabbedPaneJornadas = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneJornadas.setFocusable(false);
		tabbedPaneJornadas.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneJornadas.setBorder(null);
		tabbedPaneJornadas.setFont(new Font("Dialog", Font.PLAIN, 10));
		tabbedPaneJornadas.setBackground(Color.WHITE);
		tabbedPaneJornadas.setBounds(108, 52, 612, 321);
		// asocio el DefaultListModel a la lista
		panelCentral.add(tabbedPaneJornadas);

		if (Seleccion.getTemporadaSeleccionada() != null) {
			lblTemporada.setText("Temporada " + Seleccion.getTemporadaNumero());

			List<Jornada> jornadas = Seleccion.getTemporadaSeleccionada().getListaJornadas();

			// Llama al método para crear los paneles y pestañas de las jornadas
			crearPanelesJornadas(jornadas);

			// System.out.println(Seleccion.getTemporadaSeleccionada().getListaJornadas());
		}
		
		if (Seleccion.getTemporadaSeleccionada().getEstado().equals("FINALIZADA")) {
			btnEditarTemp.setVisible(false);
			btnPanel.setBounds(864, 22, 140, 45);
		}
		
		ListaMovimientos = Logger.cargarMovimientos();

	}

	/**
	 * Funcion Action performed.
	 *
	 * @param e el Evento Accionado
	 */
	// Acción para los objetos
	@Override
	public void actionPerformed(ActionEvent e) {
		// Condición para dirigirnos a la función que corresponda
		if (e.getSource() == btnPanel) {
			Panel();
		} else if (e.getSource() == btnEditarTemp) {
			EditarTemporada();
		} else if (e.getSource() == btnTemporadas) {
			botonTemporadas();
		} else if (e.getSource() == btnClasificacion) {
			botonClasificacion();
		} else if (e.getSource() == btnJornadas) {
			botonJornadas();
		} else if (e.getSource() == btnCerrarSesion) {
			CerrarSesion();
		} else if (e.getSource() == btnEquipos) {
			botonEquipos();
		} else if (e.getSource() == btnPanel) {
			Panel();
		}
	}

	/**
	 * Funcion para el Panel.
	 */
	private void Panel() {
		// Creo las variables
		Panel L = new Panel();
		// Muestro la ventana Registro
		L.setVisible(true);
		setEnabled(false);
		// Centrar la ventana en el centro de la pantalla
		L.setLocationRelativeTo(null);

		L.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if (L != null) {
					L.dispose();
				}
				// Habilitar la ventana de inicio
				setEnabled(true);
				// Establece que la ventana se quede en primer plano
				requestFocus();
			}
		});
	}

	/**
	 * Funcion para Editar Temporada.
	 */
	private void EditarTemporada() {
		if (Seleccion.getTemporadaSeleccionada().getEstado().equals("FINALIZADA")) {
			JOptionPane.showMessageDialog(this, "La temporada esta Finalizada no se puede editar", "Temporada Errónea",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// Creo las variables
		EditarTemp ET = new EditarTemp();
		// Muestro la ventana Registro
		ET.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		ET.setLocationRelativeTo(null);
		// Cierro la ventana Login
		dispose();
	}

	/**
	 * Funcion para Cerrar Sesion.
	 */
	private void CerrarSesion() {
		// Pregunta al usuario si quiere cerrar sesion
		int opcion = JOptionPane.showConfirmDialog(this, (String) "¿Desea cerrar sesión?", "Cierre de sesión",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		switch (opcion) {
		// En el caso de darle a si
		case JOptionPane.YES_OPTION:
			JOptionPane.showMessageDialog(this, (String) "Se ha cerrado sesión. Volviendo a Login.",
					"Cierre de sesión correcto", JOptionPane.INFORMATION_MESSAGE);
			ListaMovimientos = Logger.cargarMovimientos();

			Calendar calendar = Calendar.getInstance();
			int año = calendar.get(Calendar.YEAR);
			int mes = calendar.get(Calendar.MONTH) + 1; // Nota: los meses comienzan desde 0
			int dia = calendar.get(Calendar.DAY_OF_MONTH);
			int hora = calendar.get(Calendar.HOUR_OF_DAY);
			int minuto = calendar.get(Calendar.MINUTE);

			// Crear el formato de fecha y hora
			Fecha fechaActual = new Fecha(dia, mes, año);
			Horario horaActual = new Horario(hora, minuto);

			Logger movimiento = new Logger(Sesion.getUsuarioActual(), "Ha cerrado sesión.", fechaActual, horaActual);

			ListaMovimientos.add(movimiento);
			Logger.guardarMovimientos(ListaMovimientos);

			// Creo las variables
			Login L = new Login();
			// Muestro la ventana Registro
			L.setVisible(true);
			// Centrar la ventana en el centro de la pantalla
			L.setLocationRelativeTo(null);
			// Cierro la ventana Login
			dispose();
			// Se quita el usuario con el que se ha iniciado sesion
			Sesion.setUsuarioActual(null);
			Seleccion.setTemporadaSeleccionada(null);
			Seleccion.setTemporadaNumero(null);
			Seleccion.setTemporadaPosicion(null);
			break;
		// En el caso de darle a no
		case JOptionPane.NO_OPTION:
			JOptionPane.showMessageDialog(this, (String) "La sesión sigue iniciada", "Cierre de sesión cancelado",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	/**
	 * Funcion para el Boton Temporadas.
	 */
	private void botonTemporadas() {
		// Creo las variables
		Inicio T = new Inicio();
		// Muestro la ventana Registro
		T.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		T.setLocationRelativeTo(null);
		// Cierro la ventana Login
		dispose();
	}

	/**
	 * Funcion para el Boton Clasificacion.
	 */
	private void botonClasificacion() {
		// Creo las variables
		Clasificacion C = new Clasificacion();
		// Muestro la ventana Registro
		C.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		C.setLocationRelativeTo(null);
		// Cierro la ventana Login
		dispose();
	}

	/**
	 * Funcion para el Boton Jornadas.
	 */
	private void botonJornadas() {
		// Creo las variables
		Jornadas J = new Jornadas();
		// Muestro la ventana Registro
		J.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		J.setLocationRelativeTo(null);
		// Cierro la ventana Login
		dispose();
	}

	/**
	 * Funcion para el Boton Equipos.
	 */
	private void botonEquipos() {
		// Creo las variables
		Equipos E = new Equipos();
		// Muestro la ventana Registro
		E.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		E.setLocationRelativeTo(null);
		// Cierro la ventana Login
		dispose();
	}

	/**
	 * Funcion para Crear los Paneles de las Jornadas.
	 *
	 * @param jornadas the jornadas
	 */
	private void crearPanelesJornadas(List<Jornada> jornadas) {
		// Iterar sobre la lista de jornadas
		for (Jornada jornada : jornadas) {
			// Crear un nuevo panel para la jornada
			JPanel panelJornadaX = new JPanel();
			// Agregar una pestaña al contenedor con el número de jornada como título y el
			// panel recién creado
			tabbedPaneJornadas.addTab("Jornada " + jornada.getNumero(), null, panelJornadaX, null);
			// Configurar el diseño del panel con un GridBagLayout
			GridBagLayout gbl_panelJornadaX = new GridBagLayout();
			gbl_panelJornadaX.columnWidths = new int[] { 5, 15, 10, 10, 10, 15, 5, 0 }; // Ajusta las anchuras de las
																													// columnas
			gbl_panelJornadaX.rowHeights = new int[] { 70, 70, 0 };
			gbl_panelJornadaX.columnWeights = new double[] { 0.0, 0.15, 0.1, 0.1, 0.1, 0.15, 0.0, Double.MIN_VALUE };
			gbl_panelJornadaX.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			panelJornadaX.setLayout(gbl_panelJornadaX);

			JLabel lblJornada = new JLabel("Jornada " + jornada.getNumero());
			lblJornada.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblJornada.setHorizontalAlignment(SwingConstants.CENTER);
			lblJornada.setHorizontalTextPosition(SwingConstants.LEADING);
			GridBagConstraints gbc_lblJornada = new GridBagConstraints();
			gbc_lblJornada.insets = new Insets(0, 0, 5, 5);
			gbc_lblJornada.gridwidth = 5;
			gbc_lblJornada.gridx = 1;
			gbc_lblJornada.gridy = 0;
			panelJornadaX.add(lblJornada, gbc_lblJornada);

			JLabel lblFecha = new JLabel("(" + jornada.getFecha() + ")");
			lblFecha.setHorizontalTextPosition(SwingConstants.LEADING);
			lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblFecha = new GridBagConstraints();
			gbc_lblFecha.anchor = GridBagConstraints.SOUTH;
			gbc_lblFecha.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
			gbc_lblFecha.gridwidth = 5;
			gbc_lblFecha.gridx = 1;
			gbc_lblFecha.gridy = 0;
			panelJornadaX.add(lblFecha, gbc_lblFecha);

			List<Partido> partidos = jornada.getListaPartidos();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridwidth = 1;
			int yPosition = 1; // Iniciar desde la segunda fila para los partidos

			// Iterar sobre la lista de partidos
			for (Partido partido : partidos) {
				gbc.gridy = yPosition;

            // Verificar si el equipo local es un equipo de descanso
				if (partido.getEquipoLocal().getNombre().equals("Equipo para Descansar")) {
					JLabel lblDescansa = new JLabel("Descansa");
					lblDescansa.setHorizontalTextPosition(SwingConstants.LEADING);
					lblDescansa.setHorizontalAlignment(SwingConstants.CENTER);
					lblDescansa.setFont(new Font("Tahoma", Font.BOLD, 25));
					GridBagConstraints gbc_lblDescansa = new GridBagConstraints();
					gbc_lblDescansa.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblDescansa.insets = new Insets(0, 0, 0, 5);
					gbc_lblDescansa.gridx = 3;
					gbc_lblDescansa.gridy = yPosition;
					panelJornadaX.add(lblDescansa, gbc_lblDescansa);

					// JLabel para el escudo visitante
					JLabel lblEscudoVisitante = new JLabel("");
					lblEscudoVisitante.setBorder(new LineBorder(new Color(0, 0, 0)));
					lblEscudoVisitante.setHorizontalAlignment(SwingConstants.CENTER);

					lblEscudoVisitante.setPreferredSize(new Dimension(80, 74));

					// Ajustar la imagen del escudo visitante al tamaño especificado
					String escudoVisitantePath = partido.getEquipoVisitante().getEscudo();
					if (escudoVisitantePath != null && !escudoVisitantePath.isEmpty()) {
						ImageIcon escudoVisitanteIcon = new ImageIcon(escudoVisitantePath);
						Image escudoVisitanteImage = escudoVisitanteIcon.getImage().getScaledInstance(80, 74,
								Image.SCALE_SMOOTH);
						lblEscudoVisitante.setIcon(new ImageIcon(escudoVisitanteImage));
					} else {
						lblEscudoVisitante.setIcon(null);
					}

					GridBagConstraints gbc_lblEscudoVisitante = new GridBagConstraints();
					gbc_lblEscudoVisitante.fill = GridBagConstraints.BOTH;
					gbc_lblEscudoVisitante.insets = new Insets(0, 0, 0, 5);
					gbc_lblEscudoVisitante.gridx = 5;
					gbc_lblEscudoVisitante.gridy = yPosition;
					panelJornadaX.add(lblEscudoVisitante, gbc_lblEscudoVisitante);

					JLabel lblEquipoVisitante = new JLabel(partido.getEquipoVisitante().getNombre());
					lblEquipoVisitante.setHorizontalTextPosition(SwingConstants.RIGHT);
					lblEquipoVisitante.setHorizontalAlignment(SwingConstants.CENTER);
					lblEquipoVisitante.setFont(new Font("Tahoma", Font.BOLD, 10));
					GridBagConstraints gbc_lblEquipoVisitante = new GridBagConstraints();
					gbc_lblEquipoVisitante.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblEquipoVisitante.gridx = 6;
					gbc_lblEquipoVisitante.gridy = yPosition;
					panelJornadaX.add(lblEquipoVisitante, gbc_lblEquipoVisitante);

					yPosition += 2;

					continue;
				}

            // Verificar si el equipo visitante es un equipo de descanso
				if (partido.getEquipoVisitante().getNombre().equals("Equipo para Descansar")) {
					JLabel lblDescansa = new JLabel("Descansa");
					lblDescansa.setHorizontalTextPosition(SwingConstants.LEADING);
					lblDescansa.setHorizontalAlignment(SwingConstants.CENTER);
					lblDescansa.setFont(new Font("Tahoma", Font.BOLD, 25));
					GridBagConstraints gbc_lblDescansa = new GridBagConstraints();
					gbc_lblDescansa.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblDescansa.insets = new Insets(0, 0, 0, 5);
					gbc_lblDescansa.gridx = 3;
					gbc_lblDescansa.gridy = yPosition;
					panelJornadaX.add(lblDescansa, gbc_lblDescansa);

					JLabel lblEquipoLocal = new JLabel(partido.getEquipoLocal().getNombre());
					lblEquipoLocal.setHorizontalTextPosition(SwingConstants.RIGHT);
					lblEquipoLocal.setHorizontalAlignment(SwingConstants.CENTER);
					lblEquipoLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
					GridBagConstraints gbc_lblEquipoLocal = new GridBagConstraints();
					gbc_lblEquipoLocal.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblEquipoLocal.insets = new Insets(0, 0, 0, 5);
					gbc_lblEquipoLocal.gridx = 0;
					gbc_lblEquipoLocal.gridy = yPosition;
					panelJornadaX.add(lblEquipoLocal, gbc_lblEquipoLocal);

					// JLabel para el escudo local
					JLabel lblEscudoLocal = new JLabel("");
					lblEscudoLocal.setBorder(new LineBorder(new Color(0, 0, 0)));
					lblEscudoLocal.setHorizontalAlignment(SwingConstants.CENTER);
					lblEscudoLocal.setPreferredSize(new Dimension(80, 74));

					// Ajustar la imagen del escudo local al tamaño especificado
					String escudoLocalPath = partido.getEquipoLocal().getEscudo();
					if (escudoLocalPath != null && !escudoLocalPath.isEmpty()) {
						ImageIcon escudoLocalIcon = new ImageIcon(escudoLocalPath);
						Image escudoLocalImage = escudoLocalIcon.getImage().getScaledInstance(80, 74, Image.SCALE_SMOOTH);
						lblEscudoLocal.setIcon(new ImageIcon(escudoLocalImage));
					} else {
						lblEscudoLocal.setIcon(null);
					}

					GridBagConstraints gbc_lblEscudoLocal = new GridBagConstraints();
					gbc_lblEscudoLocal.fill = GridBagConstraints.BOTH;
					gbc_lblEscudoLocal.insets = new Insets(0, 0, 0, 5);
					gbc_lblEscudoLocal.gridx = 1;
					gbc_lblEscudoLocal.gridy = yPosition;
					panelJornadaX.add(lblEscudoLocal, gbc_lblEscudoLocal);

					yPosition += 2;

					continue;
				}

				JLabel lblEquipoLocal = new JLabel(partido.getEquipoLocal().getNombre());
				lblEquipoLocal.setHorizontalTextPosition(SwingConstants.RIGHT);
				lblEquipoLocal.setHorizontalAlignment(SwingConstants.CENTER);
				lblEquipoLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
				GridBagConstraints gbc_lblEquipoLocal = new GridBagConstraints();
				gbc_lblEquipoLocal.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblEquipoLocal.insets = new Insets(0, 0, 0, 5);
				gbc_lblEquipoLocal.gridx = 0;
				gbc_lblEquipoLocal.gridy = yPosition;
				panelJornadaX.add(lblEquipoLocal, gbc_lblEquipoLocal);

				// JLabel para el escudo local
				JLabel lblEscudoLocal = new JLabel("");
				lblEscudoLocal.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblEscudoLocal.setHorizontalAlignment(SwingConstants.CENTER);
				lblEscudoLocal.setPreferredSize(new Dimension(80, 74));

				// Ajustar la imagen del escudo local al tamaño especificado
				String escudoLocalPath = partido.getEquipoLocal().getEscudo();
				if (escudoLocalPath != null && !escudoLocalPath.isEmpty()) {
					ImageIcon escudoLocalIcon = new ImageIcon(escudoLocalPath);
					Image escudoLocalImage = escudoLocalIcon.getImage().getScaledInstance(80, 74, Image.SCALE_SMOOTH);
					lblEscudoLocal.setIcon(new ImageIcon(escudoLocalImage));
				} else {
					lblEscudoLocal.setIcon(null);
				}

				GridBagConstraints gbc_lblEscudoLocal = new GridBagConstraints();
				gbc_lblEscudoLocal.fill = GridBagConstraints.BOTH;
				gbc_lblEscudoLocal.insets = new Insets(0, 0, 0, 5);
				gbc_lblEscudoLocal.gridx = 1;
				gbc_lblEscudoLocal.gridy = yPosition;
				panelJornadaX.add(lblEscudoLocal, gbc_lblEscudoLocal);

				JLabel lblPuntosLocal = new JLabel();
				if (String.valueOf(partido.getPuntosLocal()).equals("-1")) {
					lblPuntosLocal.setText("0");
				} else {
					lblPuntosLocal.setText(String.valueOf(partido.getPuntosLocal()));
				}
				lblPuntosLocal.setHorizontalTextPosition(SwingConstants.LEADING);
				lblPuntosLocal.setHorizontalAlignment(SwingConstants.CENTER);
				lblPuntosLocal.setFont(new Font("Tahoma", Font.BOLD, 25));
				GridBagConstraints gbc_lblPuntosLocal = new GridBagConstraints();
				gbc_lblPuntosLocal.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblPuntosLocal.insets = new Insets(0, 0, 0, 5);
				gbc_lblPuntosLocal.gridx = 2;
				gbc_lblPuntosLocal.gridy = yPosition;
				panelJornadaX.add(lblPuntosLocal, gbc_lblPuntosLocal);

				JLabel lblLinea = new JLabel("-");
				lblLinea.setHorizontalTextPosition(SwingConstants.LEADING);
				lblLinea.setHorizontalAlignment(SwingConstants.CENTER);
				lblLinea.setFont(new Font("Tahoma", Font.BOLD, 25));
				GridBagConstraints gbc_lblLinea = new GridBagConstraints();
				gbc_lblLinea.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblLinea.insets = new Insets(0, 0, 0, 5);
				gbc_lblLinea.gridx = 3;
				gbc_lblLinea.gridy = yPosition;
				panelJornadaX.add(lblLinea, gbc_lblLinea);

				JLabel lblPuntosVisitante = new JLabel();
				if (String.valueOf(partido.getPuntosVisitante()).equals("-1")) {
					lblPuntosVisitante.setText("0");
				} else {
					lblPuntosVisitante.setText(String.valueOf(partido.getPuntosVisitante()));
				}
				lblPuntosVisitante.setHorizontalTextPosition(SwingConstants.LEADING);
				lblPuntosVisitante.setHorizontalAlignment(SwingConstants.CENTER);
				lblPuntosVisitante.setFont(new Font("Tahoma", Font.BOLD, 25));
				GridBagConstraints gbc_lblPuntosVisitante = new GridBagConstraints();
				gbc_lblPuntosVisitante.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblPuntosVisitante.insets = new Insets(0, 0, 0, 5);
				gbc_lblPuntosVisitante.gridx = 4;
				gbc_lblPuntosVisitante.gridy = yPosition;
				panelJornadaX.add(lblPuntosVisitante, gbc_lblPuntosVisitante);

				// JLabel para el escudo visitante
				JLabel lblEscudoVisitante = new JLabel("");
				lblEscudoVisitante.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblEscudoVisitante.setHorizontalAlignment(SwingConstants.CENTER);
				lblEscudoVisitante.setPreferredSize(new Dimension(80, 74));

				// Ajustar la imagen del escudo visitante al tamaño especificado
				String escudoVisitantePath = partido.getEquipoVisitante().getEscudo();
				if (escudoVisitantePath != null && !escudoVisitantePath.isEmpty()) {
					ImageIcon escudoVisitanteIcon = new ImageIcon(escudoVisitantePath);
					Image escudoVisitanteImage = escudoVisitanteIcon.getImage().getScaledInstance(80, 74,
							Image.SCALE_SMOOTH);
					lblEscudoVisitante.setIcon(new ImageIcon(escudoVisitanteImage));
				} else {
					lblEscudoVisitante.setIcon(null);
				}

				GridBagConstraints gbc_lblEscudoVisitante = new GridBagConstraints();
				gbc_lblEscudoVisitante.fill = GridBagConstraints.BOTH;
				gbc_lblEscudoVisitante.insets = new Insets(0, 0, 0, 5);
				gbc_lblEscudoVisitante.gridx = 5;
				gbc_lblEscudoVisitante.gridy = yPosition;
				panelJornadaX.add(lblEscudoVisitante, gbc_lblEscudoVisitante);

				JLabel lblEquipoVisitante = new JLabel(partido.getEquipoVisitante().getNombre());
				lblEquipoVisitante.setHorizontalTextPosition(SwingConstants.RIGHT);
				lblEquipoVisitante.setHorizontalAlignment(SwingConstants.CENTER);
				lblEquipoVisitante.setFont(new Font("Tahoma", Font.BOLD, 10));
				GridBagConstraints gbc_lblEquipoVisitante = new GridBagConstraints();
				gbc_lblEquipoVisitante.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblEquipoVisitante.gridx = 6;
				gbc_lblEquipoVisitante.gridy = yPosition;
				panelJornadaX.add(lblEquipoVisitante, gbc_lblEquipoVisitante);

				yPosition += 2;
			}
			// Crear un JScrollPane y agregarlo como una nueva pestaña al contenedor
			JScrollPane scrollPane = new JScrollPane(panelJornadaX);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(tabbedPaneJornadas.getBounds());
			tabbedPaneJornadas.addTab("Jornada " + jornada.getNumero(), null, scrollPane, null);
		}
	}

	/**
	 * Funcion para la Apertura de la Ventana.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		if (Sesion.getUsuarioActual() != null) {
			// Si el usuario actual NO es un usuario con privilegios
			if (!Sesion.getUsuarioActual().getPrivilegiado()) {
				// Oculta el botón de logs
				btnPanel.setVisible(false);
				// Oculta el botón de editar temporada
				btnEditarTemp.setVisible(false);
			}
		}
	}

	/**
	 * Funcion previa al Cierre de la Ventana.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		if (Sesion.getUsuarioActual() != null) {
			ListaMovimientos = Logger.cargarMovimientos();

			Calendar calendar = Calendar.getInstance();
			int año = calendar.get(Calendar.YEAR);
			int mes = calendar.get(Calendar.MONTH) + 1; // Nota: los meses comienzan desde 0
			int dia = calendar.get(Calendar.DAY_OF_MONTH);
			int hora = calendar.get(Calendar.HOUR_OF_DAY);
			int minuto = calendar.get(Calendar.MINUTE);

			// Crear el formato de fecha y hora
			Fecha fechaActual = new Fecha(dia, mes, año);
			Horario horaActual = new Horario(hora, minuto);

			Logger movimiento = new Logger(Sesion.getUsuarioActual(), "Ha cerrado sesión.", fechaActual, horaActual);

			ListaMovimientos.add(movimiento);
			Logger.guardarMovimientos(ListaMovimientos);
		}
	}

	/**
	 * Funcion posterior al Cierre de la Ventana.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowClosed(WindowEvent e) {
	}

	/**
	 * Funcion para la Minimizacion de la Ventana.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowIconified(WindowEvent e) {
	}

	/**
	 * Funcion para la Desminimizacion de la Ventana.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	/**
	 * Funcion para cuando la Ventana esta Activa.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowActivated(WindowEvent e) {
	}

	/**
	 * Funcion para cuando la Ventana esta Desactivada.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}