package aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import definicion.Jornada;
import definicion.Logger;
import definicion.Participante;
import definicion.Partido;
import definicion.Seleccion;
import definicion.Sesion;
import definicion.Temporada;
import definicion.Usuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JList;
import definicion.Equipo;
import definicion.EquipoSeleccion;
import definicion.Estadisticas;
import definicion.Fecha;
import definicion.Horario;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

/**
 * La Clase EditarTemp.
 */
public class EditarTemp extends JFrame implements ActionListener, WindowListener, ListSelectionListener {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1L;

	/** El Content Pane principal. */
	private JPanel contentPane;

	/** El Content Pane Superior. */
	private JPanel panelSuperior;

	/** El Boton de Cerrar Sesion. */
	private JButton btnCerrarSesion;

	/** El Content Pane Central. */
	private JPanel panelCentral;

	/** El Boton de Atras. */
	private JButton btnAtras;

	/** El Label de Temporada. */
	private JLabel lblTemporada;

	/** El Boton de Guardar. */
	private JButton btnGuardar;

	/** El Boton de Exportar XML. */
	private JButton btnExportarXML;

	/** El Tabbed Pane de las Jornadas. */
	private JTabbedPane tabbedPaneJornadas;

	/** La Lista de Temporadas. */
	private ArrayList<Temporada> ListaTemporadas;

	/** La Lista de Jornadas de la Temporada. */
	private List<Jornada> ListaJornadas;

	/** El Boton de Finalizar. */
	private JButton btnFinalizar;

	/** El Modelo de la Lista de Equipos de la Temporda. */
	private DefaultListModel<Equipo> elm;

	/** El Modelo de la Lista de Equipos Registrados. */
	private DefaultListModel<Equipo> elm2;

	/** La Lista de Equipos Registrados. */
	private JList<Equipo> lstEquiposRegistrados;

	/** La Lista de Equipos de la Temporada. */
	private JList<Equipo> lstEquipos;

	/** El Scroll Pane de la Lista de Equipos de la Temporada. */
	private JScrollPane scrollPanelst;

	/** El Scroll Pane de la Lista de Equipos Registrados. */
	private JScrollPane scrollPanelst2;

	/** El Panel de la Lista de Equipos de la Temporada. */
	private JPanel panelListaEquipos;

	/** El Boton de Eliminar Equipo de la Lista de Equipos Registrados. */
	private JButton btnListaEquiposEliminar;

	/** El Boton de Editar Equipo de la Lista de Equipos Registrados. */
	private JButton btnListaEquiposEditar;

	/** El Panel de la Lista de Equipos Registrados. */
	private JPanel panelListaEquiposRegistrados;

	/** El Boton de Añadir Equipo de la Lista de Equipos Registrados. */
	private JButton btnListaEquiposAñadir;

	/** El Boton de Crear Equipo de la Lista de Equipos Registrados. */
	private JButton btnListaEquiposCrear;

	/** El Label de los Equipos de la Temporada. */
	private JLabel lblListaEquipos;

	/** El Label de los Equipos Registrados. */
	private JLabel lblEquiposRegistrados;

	/** La Lista de Equipos de la Temporada. */
	private List<Equipo> ListaEquipos;

	/** La Lista de Movimientos Totales que hay Registrados. */
	private ArrayList<Logger> ListaMovimientos;

	/** La Lista de Equipos Totales que hay Registrados. */
	private ArrayList<Equipo> ListaEquiposRegistrados;

	/** El Modelo de la Tabla de Clasificacion. */
	private DefaultTableModel ctm;

	/** La Tabla de Clasificacion. */
	private JTable tableClasificacion;

	/** Si algo en la Lista de Equipos ha sido modificado */
	Boolean modificadoEquipos = false;

	/**
	 * Si se ha encontrado el Equipo Registrado en la Lista de Equipos de la
	 * Temporada.
	 */
	Boolean encontrado = false;
	private JButton btnIniciar;
	private JLabel lblFlecha;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarTemp frame = new EditarTemp();
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
	public EditarTemp() {
		// Añado acción listener
		this.addWindowListener(this);
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		setResizable(false);
		setTitle("Editar Temporada ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(74, 127, 214));
		panelSuperior.setBounds(0, 0, 1236, 90);
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(null);

		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setBackground(new Color(230, 230, 230));
		btnCerrarSesion.setFocusable(false);
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setBounds(22, 22, 119, 45);
		panelSuperior.add(btnCerrarSesion);

		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAtras.addActionListener(this);
		btnAtras.setBackground(new Color(230, 230, 230));
		btnAtras.setBorder(null);
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setFocusable(false);
		btnAtras.setBounds(1141, 22, 85, 45);
		panelSuperior.add(btnAtras);

		lblTemporada = new JLabel("Temporada X");
		lblTemporada.setForeground(new Color(255, 255, 255));
		lblTemporada.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemporada.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTemporada.setBounds(403, 22, 429, 45);
		panelSuperior.add(lblTemporada);

		panelCentral = new JPanel();
		panelCentral.setFocusable(false);
		panelCentral.setBounds(0, 91, 1236, 432);
		contentPane.add(panelCentral);
		panelCentral.setLayout(null);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGuardar.addActionListener(this);
		btnGuardar.setFocusable(false);
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(74, 127, 214));
		btnGuardar.setBounds(457, 355, 119, 45);
		panelCentral.add(btnGuardar);

		tabbedPaneJornadas = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneJornadas.setFocusable(false);
		tabbedPaneJornadas.setBorder(null);
		tabbedPaneJornadas.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneJornadas.setFont(new Font("Dialog", Font.PLAIN, 10));
		tabbedPaneJornadas.setBackground(Color.WHITE);
		tabbedPaneJornadas.setBounds(374, 55, 469, 290);
		// asocio el DefaultListModel a la lista
		panelCentral.add(tabbedPaneJornadas);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(new Color(255, 255, 255));
		btnFinalizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFinalizar.setFocusable(false);
		btnFinalizar.addActionListener(this);
		btnFinalizar.setBorder(null);
		btnFinalizar.setBackground(new Color(74, 127, 214));
		btnFinalizar.setBounds(328, 355, 119, 45);
		panelCentral.add(btnFinalizar);
		// Ocultar el boton
		btnFinalizar.setVisible(false);

		elm2 = new DefaultListModel<Equipo>();

		lstEquiposRegistrados = new JList<Equipo>();
		lstEquiposRegistrados.setFont(new Font("Dialog", Font.BOLD, 12));
		lstEquiposRegistrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEquiposRegistrados.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstEquiposRegistrados.setBounds(10, 154, 155, 191);
		lstEquiposRegistrados.addListSelectionListener(this);
		// asocio el DefaultListModel a la lista
		lstEquiposRegistrados.setModel(elm2);
		panelCentral.add(lstEquiposRegistrados);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPanelst = new JScrollPane(lstEquiposRegistrados);
		scrollPanelst.setBorder(null);
		scrollPanelst.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelst.setBounds(10, 154, 155, 191);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		panelCentral.add(scrollPanelst);

		elm = new DefaultListModel<Equipo>();

		lstEquipos = new JList<Equipo>();
		lstEquipos.setFont(new Font("Dialog", Font.BOLD, 12));
		lstEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEquipos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstEquipos.setBounds(209, 154, 155, 191);
		// asocio el DefaultListModel a la lista
		lstEquipos.setModel(elm);
		panelCentral.add(lstEquipos);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPanelst2 = new JScrollPane(lstEquipos);
		scrollPanelst2.setBorder(null);
		scrollPanelst2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelst2.setBounds(209, 154, 155, 191);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		panelCentral.add(scrollPanelst2);

		panelListaEquipos = new JPanel();
		panelListaEquipos.setLayout(null);
		panelListaEquipos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelListaEquipos.setBackground(Color.WHITE);
		panelListaEquipos.setBounds(209, 53, 155, 101);
		panelCentral.add(panelListaEquipos);

		btnListaEquiposEliminar = new JButton("Eliminar");
		btnListaEquiposEliminar.setFocusable(false);
		btnListaEquiposEliminar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnListaEquiposEliminar.setBackground(new Color(230, 230, 230));
		btnListaEquiposEliminar.addActionListener(this);
		btnListaEquiposEliminar.setBounds(34, 20, 86, 60);
		panelListaEquipos.add(btnListaEquiposEliminar);

		panelListaEquiposRegistrados = new JPanel();
		panelListaEquiposRegistrados.setLayout(null);
		panelListaEquiposRegistrados.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelListaEquiposRegistrados.setBackground(Color.WHITE);
		panelListaEquiposRegistrados.setBounds(10, 53, 155, 101);
		panelCentral.add(panelListaEquiposRegistrados);

		btnListaEquiposAñadir = new JButton("Añadir");
		btnListaEquiposAñadir.setFocusable(false);
		btnListaEquiposAñadir.setBackground(new Color(230, 230, 230));
		btnListaEquiposAñadir.setFont(new Font("Dialog", Font.BOLD, 10));
		btnListaEquiposAñadir.addActionListener(this);
		btnListaEquiposAñadir.setBounds(35, 41, 86, 21);
		panelListaEquiposRegistrados.add(btnListaEquiposAñadir);

		btnListaEquiposCrear = new JButton("Crear");
		btnListaEquiposCrear.setFont(new Font("Dialog", Font.BOLD, 10));
		btnListaEquiposCrear.setFocusable(false);
		btnListaEquiposCrear.setBackground(new Color(230, 230, 230));
		btnListaEquiposCrear.addActionListener(this);
		btnListaEquiposCrear.setBounds(35, 10, 86, 21);
		panelListaEquiposRegistrados.add(btnListaEquiposCrear);

		btnListaEquiposEditar = new JButton("Editar");
		btnListaEquiposEditar.setFocusable(false);
		btnListaEquiposEditar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnListaEquiposEditar.setBackground(new Color(230, 230, 230));
		btnListaEquiposEditar.setBounds(35, 70, 86, 21);
		panelListaEquiposRegistrados.add(btnListaEquiposEditar);
		btnListaEquiposEditar.addActionListener(this);

		lblListaEquipos = new JLabel("Equipos de la Temporada:");
		lblListaEquipos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListaEquipos.setBounds(209, 10, 175, 33);
		panelCentral.add(lblListaEquipos);

		lblEquiposRegistrados = new JLabel("Equipos Registrados:");
		lblEquiposRegistrados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEquiposRegistrados.setBounds(10, 10, 147, 33);
		panelCentral.add(lblEquiposRegistrados);

		ctm = new DefaultTableModel();
		ctm.addColumn("Posición");
		ctm.addColumn("Equipo");
		ctm.addColumn("Puntos Totales");
		ctm.addColumn("Partidos Jugados");
		ctm.addColumn("Partidos Ganados");
		ctm.addColumn("Partidos Empatados");
		ctm.addColumn("Partidos Perdidos");
		ctm.addColumn("Puntos a Favor");
		ctm.addColumn("Puntos en Contra");

		tableClasificacion = new JTable();
		tableClasificacion.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tableClasificacion.setEnabled(false);
		tableClasificacion.setBounds(853, 55, 373, 286);
		// Asignar el modelo de tabla a la JTable
		tableClasificacion.setModel(ctm);
		panelCentral.add(tableClasificacion);

		btnExportarXML = new JButton("Exportar XML");
		btnExportarXML.setForeground(Color.WHITE);
		// Añade accion de tipo listener al boton
		btnExportarXML.addActionListener(this);
		btnExportarXML.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExportarXML.setFocusable(false);
		btnExportarXML.setBorder(null);
		btnExportarXML.setBackground(new Color(74, 127, 214));
		btnExportarXML.setBounds(616, 355, 119, 45);
		panelCentral.add(btnExportarXML);

		btnIniciar = new JButton("Iniciar");
		// Añade accion de tipo listener al boton
		btnIniciar.addActionListener(this);
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnIniciar.setFocusable(false);
		btnIniciar.setBorder(null);
		btnIniciar.setBackground(new Color(74, 127, 214));
		btnIniciar.setBounds(763, 355, 119, 45);
		panelCentral.add(btnIniciar);
		
		lblFlecha = new JLabel("🢂");
		lblFlecha.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFlecha.setBounds(179, 200, 24, 36);
		panelCentral.add(lblFlecha);

		lblTemporada.setText("Editar Temporada " + Seleccion.getTemporadaNumero());

		ListaJornadas = Seleccion.getTemporadaSeleccionada().getListaJornadas();

		ListaTemporadas = Temporada.cargarTemporadas();

		ListaMovimientos = Logger.cargarMovimientos();

		ListaEquipos = Seleccion.getTemporadaSeleccionada().getListaEquipos();
		ListaEquiposRegistrados = Equipo.cargarEquipos();
		
		//Si hay una temporada ya activa
		for (Temporada temporada : ListaTemporadas) {
			if ("ACTIVA".equals(temporada.getEstado())) {
				btnIniciar.setVisible(false);
				break;
			}
			btnIniciar.setBounds(384, 355, 119, 45);
			btnExportarXML.setBounds(716, 355, 119, 45);
			btnGuardar.setBounds(550, 355, 119, 45);
		}
		
		if (Seleccion.getTemporadaSeleccionada().getEstado().equals("ACTIVA")) {
			lstEquiposRegistrados.setVisible(false);
			lstEquipos.setVisible(false);
			panelListaEquipos.setVisible(false);
			panelListaEquiposRegistrados.setVisible(false);
			lblEquiposRegistrados.setVisible(false);
			lblListaEquipos.setVisible(false);
			scrollPanelst2.setVisible(false);
			scrollPanelst.setVisible(false);
			lblFlecha.setVisible(false);
			tabbedPaneJornadas.setBounds(39, 55, 570, 290);
			tableClasificacion.setBounds(633, 55, 573, 286);
			btnFinalizar.setVisible(true);
			btnFinalizar.setBounds(384, 355, 119, 45);
			btnExportarXML.setBounds(716, 355, 119, 45);
			btnGuardar.setBounds(550, 355, 119, 45);
			btnIniciar.setVisible(false);
		}

		for (Equipo equipo : ListaEquiposRegistrados) {
			if (!equipo.getNombre().equalsIgnoreCase("Equipo para Descansar")) {
				elm2.addElement(equipo);
			}
		}
		for (Equipo equipo : ListaEquipos) {
			if (!equipo.getNombre().equalsIgnoreCase("Equipo para Descansar")) {
				elm.addElement(equipo);
			}
		}

		// Llama al método para crear los paneles y pestañas de las jornadas
		crearPanelesJornadas(ListaJornadas);
		llenarTabla();
		
		// Crear una instancia de DefaultTableCellRenderer
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		// Establecer la alineación del renderizador en el centro
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		// Aplicar el renderizador a todas las columnas de la tabla
		for (int i = 0; i < tableClasificacion.getColumnCount(); i++) {
			tableClasificacion.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}

	/**
	 * Funcion Action performed.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			Atras();
		} else if (e.getSource() == btnCerrarSesion) {
			CerrarSesion();
		} else if (e.getSource() == btnGuardar) {
			Guardar();
		} else if (e.getSource() == btnFinalizar) {
			Finalizar();
		} else if (e.getSource() == btnListaEquiposAñadir) {
			Añadir();
		} else if (e.getSource() == btnListaEquiposCrear) {
			Crear();
		} else if (e.getSource() == btnListaEquiposEditar) {
			Editar();
		} else if (e.getSource() == btnListaEquiposEliminar) {
			Eliminar();
		} else if (e.getSource() == btnIniciar) {
			Iniciar();
		} else if (e.getSource() == btnExportarXML) {
			toXML();
		}
	}

	/**
	 * Funcion para ir Atras.
	 */
	private void Atras() {
		if (modificadoEquipos) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de que quieres salir sin guardar?",
					"Cierre sin guardar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (opcion) {
			case 1:
				return;
			case JOptionPane.CLOSED_OPTION:
				return;
			}
		}
		// Creo las variables
		Inicio I = new Inicio();
		// Muestro la ventana Registro
		I.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		I.setLocationRelativeTo(null);
		// Cierro la ventana Login
		dispose();
	}

	/**
	 * Funcion para Cerrar Sesion.
	 */
	private void CerrarSesion() {
		if (modificadoEquipos) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de que quieres salir sin guardar?",
					"Cierre sin guardar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (opcion) {
			case 1:
				return;
			case JOptionPane.CLOSED_OPTION:
				return;
			}
		} else {
			int option = JOptionPane.showConfirmDialog(this, (String) "¿Desea cerrar sesión?", "Cierre de sesión",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			switch (option) {
			case JOptionPane.NO_OPTION:
				JOptionPane.showMessageDialog(this, (String) "La sesión sigue iniciada", "Cierre de sesión cancelado",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			case JOptionPane.CLOSED_OPTION:
				return;
			}
		}
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
		// Cierro la ventana

		dispose();
		// Se quita el usuario con el que se ha iniciado sesion
		Sesion.setUsuarioActual(null);
		Seleccion.setTemporadaSeleccionada(null);
		Seleccion.setTemporadaNumero(null);
		Seleccion.setTemporadaPosicion(null);
	}

	/**
	 * Funcion para Añadir un Equipo a la Lista de Equipos de la Temporada.
	 */
	private void Añadir() {
		if (comprobarTemporada()) {
			mostrarError("No se pueden editar los equipos en una temporada Activa.");
			return;
		}
		// Obtengo las posiciones de los elementos seleccionados
		int[] indicesSeleccionados = lstEquiposRegistrados.getSelectedIndices();

		// Compruebo si hay algún elemento seleccionado
		if (indicesSeleccionados.length != 0) {
			// Verificar duplicados en los equipos seleccionados
			for (int indice : indicesSeleccionados) {
				Equipo equipoEnLista = elm2.getElementAt(indice);

				// Verificar si el equipo ya está en la lista visual elm
				if (yaEstaEnLaLista(elm, equipoEnLista)) {
					mostrarError("El equipo '" + equipoEnLista.getNombre() + "' ya está en la lista.");
					return;
				}

				// Verificar duplicados entre los participantes de los equipos en elm y elm2
				Equipo equipoDuplicado = equipoConParticipantesDuplicados(elm, equipoEnLista);
				if (equipoDuplicado != null) {
					mostrarError("El equipo '" + equipoEnLista.getNombre() + "' contiene DNI's duplicados con el equipo '"
							+ equipoDuplicado.getNombre() + "'.");
					return;
				}

				elm.addElement(equipoEnLista);
				ListaEquipos.add(equipoEnLista);
			}

			modificadoEquipos = true;
		} else {
			// No hay ningún elemento seleccionado
			mostrarError("Error, ningún elemento seleccionado en la lista");
		}
	}

	/**
	 * Funcion para verificar que no se añade un Equipo con Participantes
	 * Duplicados.
	 *
	 * @param model  el Modelo de la Lista de tipo Equipo
	 * @param equipo el Equipo
	 * @return el Equipo, si tiene Participantes Duplicados
	 */
	private Equipo equipoConParticipantesDuplicados(DefaultListModel<Equipo> model, Equipo equipo) {
		List<Participante> participantesEquipo = new ArrayList<>(equipo.getListaJugadores());
		participantesEquipo.add(equipo.getEntrenador());

		// Recorrer la lista visual y verificar duplicados con el equipo actual
		for (int i = 0; i < model.getSize(); i++) {
			Equipo otroEquipo = model.getElementAt(i);

			if (otroEquipo != equipo) { // Evitar comparar el equipo consigo mismo
				for (Participante participante : otroEquipo.getListaJugadores()) {
					String dni = participante.getDNI();
					if (participantesEquipo.stream().anyMatch(p -> p.getDNI().equals(dni))) {
						return otroEquipo; // Devolver el equipo con participantes duplicados
					}
				}

				// Verificar duplicados con el entrenador del otro equipo
				String dniEntrenadorOtroEquipo = otroEquipo.getEntrenador().getDNI();
				if (participantesEquipo.stream().anyMatch(p -> p.getDNI().equals(dniEntrenadorOtroEquipo))) {
					return otroEquipo; // Devolver el equipo con participantes duplicados con el entrenador
				}
			}
		}

		return null; // No se encontraron DNIs duplicados entre equipos
	}

	/**
	 * Funcion para comprobar si un Equipo Ya esta en la Lista.
	 *
	 * @param model  el Modelo de la Lista de tipo Equipo
	 * @param equipo el Equipo
	 * @return true, si ya esta en la lista
	 */
	private boolean yaEstaEnLaLista(DefaultListModel<Equipo> model, Equipo equipo) {
		for (int i = 0; i < model.getSize(); i++) {
			Equipo otroEquipo = model.getElementAt(i);
			if (otroEquipo.equals(equipo)) {
				return true; // El equipo ya está en la lista
			}
		}
		return false; // El equipo no está en la lista
	}

	/**
	 * Funcion para Crear un nuevo Equipo.
	 */
	private void Crear() {
		if (comprobarTemporada()) {
			mostrarError("No se pueden editar los equipos en una temporada Activa.");
			return;
		}
		// Creo las variables
		AñadirEquipo AE = new AñadirEquipo();

		setEnabled(false);
		AE.setVentanaEditar(this);

		AE.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if (AE != null) {
					AE.dispose();
				}
				// Habilitar la ventana de inicio
				setEnabled(true);

				// Establece que la ventana se quede en primer plano
				requestFocus();
			}
		});
		// Muestro la ventana Registro
		AE.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		AE.setLocationRelativeTo(null);

		modificadoEquipos = true;
	}

	/**
	 * Funcion para Editar un Equipo.
	 */
	private void Editar() {
		if (comprobarTemporada()) {
			mostrarError("No se pueden editar los equipos en una temporada Activa.");
			return;
		}
		// Obtengo las posiciones de los elementos seleccionados
		int indiceSeleccionado = lstEquiposRegistrados.getSelectedIndex();

		// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {
			// Creo las variables
			EquipoSeleccion.setEquipoSeleccionado(elm2.elementAt(indiceSeleccionado));

			if (elm.contains(EquipoSeleccion.getEquipoSeleccionado())) {
				JOptionPane.showMessageDialog(this,
						"Si editas un equipo añadido en la temporada tendras que volver a añadirlo", "Aviso Edicion",
						JOptionPane.INFORMATION_MESSAGE);
			}

			// Elimino el equipo del programa
			elm2.removeElementAt(indiceSeleccionado);
			ListaEquiposRegistrados.remove(EquipoSeleccion.getEquipoSeleccionado());
			Equipo.guardarEquipos(ListaEquiposRegistrados);

			EditarEquipo EE = new EditarEquipo();

			setEnabled(false);

			EE.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					if (EE != null) {
						EE.dispose();
					}
					// Habilitar la ventana de inicio
					setEnabled(true);

					// Establece que la ventana se quede en primer plano
					requestFocus();

					elm2.add(EquipoSeleccion.getEquipoPosicion(), EquipoSeleccion.getEquipoSeleccionado());
					if (elm.contains(EquipoSeleccion.getEquipoSeleccionado()) && EquipoSeleccion.getGuardado()) {
						elm.removeElement(EquipoSeleccion.getEquipoSeleccionado());

						JOptionPane.showMessageDialog(null,
								"Se ha editado el Equipo y se ha tenido que eliminar de la temporada.", "Equipo Editado",
								JOptionPane.INFORMATION_MESSAGE);

						EquipoSeleccion.setGuardado(false);
					}

					lstEquiposRegistrados.clearSelection();
					lstEquipos.clearSelection();
					ListaEquiposRegistrados.add(EquipoSeleccion.getEquipoPosicion(),
							EquipoSeleccion.getEquipoSeleccionado());
					Equipo.guardarEquipos(ListaEquiposRegistrados);

				}
			});
			// Muestro la ventana Registro
			EE.setVisible(true);
			// Centrar la ventana en el centro de la pantalla
			EE.setLocationRelativeTo(null);
			modificadoEquipos = true;

		} else {
			// No hay ningún elemento seleccionado
			mostrarError("Error, ningún elemento seleccionado en la lista");
		}
	}

	/**
	 * Funcion para Eliminar un equipo de la Lista de Equipos de la Temporada.
	 */
	private void Eliminar() {
		if (comprobarTemporada()) {
			mostrarError("No se pueden editar los equipos en una temporada Activa.");
			return;
		}
		// Obtengo las posiciones de los elementos seleccionados
		int indiceSeleccionado = lstEquipos.getSelectedIndex();

		// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {
			// Elimino elemento
			elm.remove(indiceSeleccionado);
			ListaEquipos.remove(indiceSeleccionado);

			modificadoEquipos = true;
		} else {
			// No hay ningún elemento seleccionado
			mostrarError("Error, ningún elemento seleccionado en la lista");
		}
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

				if (comprobarTemporada()) {
					// Crear JTextField para puntos local
					JTextField textFieldPuntosLocal = new JTextField();
					if (String.valueOf(partido.getPuntosLocal()).equals("-1")) {
						textFieldPuntosLocal.setText("");
					} else {
						textFieldPuntosLocal.setText(String.valueOf(partido.getPuntosLocal()));
					}
					textFieldPuntosLocal.putClientProperty("partidoIndex", jornada.getListaPartidos().indexOf(partido));
					textFieldPuntosLocal.putClientProperty("equipo", "local");
					textFieldPuntosLocal.setHorizontalAlignment(JTextField.CENTER);
					textFieldPuntosLocal.setFont(new Font("Tahoma", Font.BOLD, 25));
					textFieldPuntosLocal.setColumns(3); // Set the number of columns to accommodate three digits
					GridBagConstraints gbc_textFieldPuntosLocal = new GridBagConstraints();
					gbc_textFieldPuntosLocal.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldPuntosLocal.insets = new Insets(0, 0, 0, 5);
					gbc_textFieldPuntosLocal.gridx = 2;
					gbc_textFieldPuntosLocal.gridy = yPosition;
					panelJornadaX.add(textFieldPuntosLocal, gbc_textFieldPuntosLocal);

					// Crear JTextField para puntos
					JTextField textFieldPuntosVisitante = new JTextField();

					if (String.valueOf(partido.getPuntosVisitante()).equals("-1")) {
						textFieldPuntosVisitante.setText("");
					} else {
						textFieldPuntosVisitante.setText(String.valueOf(partido.getPuntosVisitante()));
					}
					textFieldPuntosVisitante.putClientProperty("partidoIndex", jornada.getListaPartidos().indexOf(partido));
					textFieldPuntosVisitante.putClientProperty("equipo", "visitante");
					textFieldPuntosVisitante.setHorizontalAlignment(JTextField.CENTER);
					textFieldPuntosVisitante.setFont(new Font("Tahoma", Font.BOLD, 25));
					textFieldPuntosVisitante.setColumns(3); // Set the number of columns to accommodate three digits
					GridBagConstraints gbc_textFieldPuntosVisitante = new GridBagConstraints();
					gbc_textFieldPuntosVisitante.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldPuntosVisitante.insets = new Insets(0, 0, 0, 5);
					gbc_textFieldPuntosVisitante.gridx = 4;
					gbc_textFieldPuntosVisitante.gridy = yPosition;
					panelJornadaX.add(textFieldPuntosVisitante, gbc_textFieldPuntosVisitante);

				} else {
					JLabel lblPuntosLocal = new JLabel("0");
					lblPuntosLocal.setHorizontalTextPosition(SwingConstants.LEADING);
					lblPuntosLocal.setHorizontalAlignment(SwingConstants.CENTER);
					lblPuntosLocal.setFont(new Font("Tahoma", Font.BOLD, 25));
					GridBagConstraints gbc_lblPuntosLocal = new GridBagConstraints();
					gbc_lblPuntosLocal.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblPuntosLocal.insets = new Insets(0, 0, 0, 5);
					gbc_lblPuntosLocal.gridx = 2;
					gbc_lblPuntosLocal.gridy = yPosition;
					panelJornadaX.add(lblPuntosLocal, gbc_lblPuntosLocal);

					JLabel lblPuntosVisitante = new JLabel("0");
					lblPuntosVisitante.setHorizontalTextPosition(SwingConstants.LEADING);
					lblPuntosVisitante.setHorizontalAlignment(SwingConstants.CENTER);
					lblPuntosVisitante.setFont(new Font("Tahoma", Font.BOLD, 25));
					GridBagConstraints gbc_lblPuntosVisitante = new GridBagConstraints();
					gbc_lblPuntosVisitante.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblPuntosVisitante.insets = new Insets(0, 0, 0, 5);
					gbc_lblPuntosVisitante.gridx = 4;
					gbc_lblPuntosVisitante.gridy = yPosition;
					panelJornadaX.add(lblPuntosVisitante, gbc_lblPuntosVisitante);

				}

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
	 * Funcion para Guardar.
	 */
	private void Guardar() {

		if (modificadoEquipos) {
			if (elm.getSize() < 6) {
				lstEquipos.setBackground(new Color(255, 192, 183));
				mostrarError("El número mínimo de equipos permitidos es de 6");
				return;
			}
			lstEquipos.setBackground(Color.WHITE);

			ListaEquipos.clear();

			for (int i = 0; i < elm.getSize(); i++) {
				Equipo equipo = (Equipo) elm.getElementAt(i);
				ListaEquipos.add(equipo);
			}
			ListaJornadas = Jornada.generarJornadas(ListaEquipos, Seleccion.getTemporadaSeleccionada().getFechaInicio(),
					Seleccion.getTemporadaSeleccionada());

			ListaTemporadas.remove(Seleccion.getTemporadaSeleccionada());
			Seleccion.getTemporadaSeleccionada().setListaEquipos(ListaEquipos);
			Seleccion.getTemporadaSeleccionada().setListaJornadas(ListaJornadas);
			ListaTemporadas.add(Seleccion.getTemporadaSeleccionada());

			// Guardar la lista actualizada en el fichero
			Temporada.guardarTemporadas(ListaTemporadas);

			modificadoEquipos = false;
			tabbedPaneJornadas.removeAll();
			crearPanelesJornadas(ListaJornadas);
			// Cambiar la tabla de Clasificacion
			llenarTabla();

			JOptionPane.showMessageDialog(null, "Se han alterado los equipos de la temporada", "Temporada Actualizada",
					JOptionPane.INFORMATION_MESSAGE);
		}
		// Si la Temporada esta Activa
		else if (comprobarTemporada()) {
			// Se elimina la temporada de la lista
			ListaTemporadas.remove(Seleccion.getTemporadaSeleccionada());

			// Borra las estadísticas por temporada después de recorrer todas las jornadas
			for (Jornada jornada : ListaJornadas) {
				for (Partido partido : jornada.getListaPartidos()) {
					partido.getEquipoLocal().getEstadisticasPorTemporada().clear();
					partido.getEquipoVisitante().getEstadisticasPorTemporada().clear();
				}
			}

			// Se recorre todas las jornadas que haya en el tabbedpanel
			for (int i = 0; i < tabbedPaneJornadas.getTabCount(); i++) {
				// Se crea una variable sobre el panel de la jornada
				JPanel panelJornadaX = (JPanel) ((JScrollPane) tabbedPaneJornadas.getComponentAt(i)).getViewport()
						.getView();
				// Se busca la Jornada en concreto dentro de la lista de jornadas
				Jornada jornada = ListaJornadas.get(i);

				// Se recorre cada partido de cada jornada
				for (Partido partido : jornada.getListaPartidos()) {

					// Obtener todos los componentes del panel para buscar los JTextField
					Component[] components = panelJornadaX.getComponents();

					// Se recorren todos los componentes de el panel de la jornada
					for (Component component : components) {
						// Se comprueba si el componente es un JTextField
						if (component instanceof JTextField) {
							// Verificar si el componente tiene la propiedad del cliente que lo identifica
							Object partidoIndexObj = ((JTextField) component).getClientProperty("partidoIndex");
							Object equipoObj = ((JTextField) component).getClientProperty("equipo");

							// Se comprueba que los datos de identificación del partido no estén vacíos
							if (partidoIndexObj != null && equipoObj != null) {
								// Se crea una variable para buscar la propiedad de cada componente JTextField
								int partidoIndex = (Integer) partidoIndexObj;
								// Se crea una variable para buscar la propiedad específica de cada componente
								// JTextField y así identificarlo
								String equipo = equipoObj.toString();

								// Comprueba si el partido se encuentra dentro de la lista de partidos de cada
								// jornada
								if (partidoIndex == jornada.getListaPartidos().indexOf(partido)) {
									// Variable para guardar los puntos que se han insertado para cada equipo
									JTextField textField = (JTextField) component;
									String inputText = textField.getText();

									// Se valida que el dato introducido es correcto (\\d) representa lo introducido
									// como digito y {1,3} el rango de digitos minimos que debe tener
									if (inputText.matches("\\d{1,3}") || inputText.isBlank()) {
										int puntos;
										// Si esta vacio el Input le asignamos el valor -1, ya que es valor que se ha
										// configurado por defecto de los puntos
										if (inputText.isBlank()) {
											puntos = -1;
										} else {
											puntos = Integer.parseInt(inputText);
										}

										// Comprueba si la identificación del equipo es local o visitante
										if (equipo.equals("local")) {
											partido.setPuntosLocal(puntos);
										} else if (equipo.equals("visitante")) {
											partido.setPuntosVisitante(puntos);
										}

									} else if (inputText.isBlank()) {
										return;
									} else {
										// Mostrar Mensaje de Error
										JOptionPane.showMessageDialog(null,
												"En todos los campos tiene que ingresar un número entero positivo con un máximo de 3 dígitos.",
												"Error de entrada", JOptionPane.ERROR_MESSAGE);
										// Se cambia el valor insertado
										textField.setText("");
										return; // Salir de la Funcion
									}
								}
							} else {
								System.out.println("El componente no tiene las propiedades del cliente necesarias");
							}
						}
					}

					// Verifica si los puntos son -1 para ambos equipos o diferentes
					if ((partido.getPuntosLocal() == -1 && partido.getPuntosVisitante() != -1)
							|| (partido.getPuntosVisitante() == -1 && partido.getPuntosLocal() != -1)) {
						// Muestra un mensaje de error y retorna
						JOptionPane.showMessageDialog(null,
								"Hay un partido en el que solo se ha introducido los datos de un equipo.", "Error de entrada",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Obtener el nombre de ambos equipos
					String nombreEquipoLocal = partido.getEquipoLocal().getNombre();
					String nombreEquipoVisitante = partido.getEquipoVisitante().getNombre();

					// Actualizar las estadísticas para ambos equipos
					partido.getEquipoLocal().actualizarEstadisticas(partido, Seleccion.getTemporadaSeleccionada(),
							nombreEquipoLocal);
					partido.getEquipoVisitante().actualizarEstadisticas(partido, Seleccion.getTemporadaSeleccionada(),
							nombreEquipoVisitante);

					// Se eliminan y se vuelven a añdir los Equipos del Registro
					ListaEquiposRegistrados.remove(partido.getEquipoLocal());
					ListaEquiposRegistrados.remove(partido.getEquipoVisitante());
					ListaEquiposRegistrados.add(partido.getEquipoLocal());
					ListaEquiposRegistrados.add(partido.getEquipoVisitante());
					// Se eliminan y se vuelven a añdir los Equipos de la Lista de Equipos de la
					// Temporada
					Seleccion.getTemporadaSeleccionada().getListaEquipos().remove(partido.getEquipoLocal());
					Seleccion.getTemporadaSeleccionada().getListaEquipos().remove(partido.getEquipoVisitante());
					Seleccion.getTemporadaSeleccionada().getListaEquipos().add(partido.getEquipoLocal());
					Seleccion.getTemporadaSeleccionada().getListaEquipos().add(partido.getEquipoVisitante());
				}
			}
			// Guardar la lista actualizada en el fichero
			Equipo.guardarEquipos(ListaEquiposRegistrados);

			// Se actualiza la información de la lista de las Jornadas
			Seleccion.getTemporadaSeleccionada().setListaJornadas(ListaJornadas);
			// Se añade a la lista de temporadas para posteriormente guardarla
			ListaTemporadas.add(Seleccion.getTemporadaSeleccionada());
			// Guardar la lista actualizada en el fichero
			Temporada.guardarTemporadas(ListaTemporadas);
			// Cambiar la tabla de Clasificacion
			llenarTabla();
			// Mensaje que comprueba los cambios
			JOptionPane.showMessageDialog(null, "Se han alterado las Estadisticas", "Temporada Actualizada",
					JOptionPane.INFORMATION_MESSAGE);
		}
		// Se obtiene la fecha Actual del Sistema
		Calendar calendar = Calendar.getInstance();
		int año = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH) + 1; // Nota: los meses comienzan desde 0
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int hora = calendar.get(Calendar.HOUR_OF_DAY);
		int minuto = calendar.get(Calendar.MINUTE);

		// Crear el formato de fecha y hora
		Fecha fechaActual = new Fecha(dia, mes, año);
		Horario horaActual = new Horario(hora, minuto);
		Usuario usuario = Sesion.getUsuarioActual();
		// Se añade un nuevo movimiento al fichcero de logs
		Logger movimiento = new Logger(usuario,
				"Ha editado la Temporada " + Seleccion.getTemporadaSeleccionada().getNumero() + ".", fechaActual,
				horaActual);

		ListaMovimientos.add(movimiento);
		Logger.guardarMovimientos(ListaMovimientos);

	}

	/**
	 * Funcion para Llenar la Tabla.
	 */
	private void llenarTabla() {
		// Ordenar la lista de equipos por estadísticas en orden descendente
		ListaEquipos.sort((equipo1, equipo2) -> {
			Temporada temporadaActual = Seleccion.getTemporadaSeleccionada();
			Estadisticas estadisticas1 = obtenerEstadisticasEquipo(equipo1, temporadaActual);
			Estadisticas estadisticas2 = obtenerEstadisticasEquipo(equipo2, temporadaActual);

			// Utilizar el comparador personalizado para Estadisticas
			if (estadisticas1 != null && estadisticas2 != null) {
				return new Estadisticas().compareTo(estadisticas1, estadisticas2);
			}
			return 0;
		});

		// Variable para asignar la posición de cada equipo
		int posicion = 0;

		// Se reinicia el modelo de datos de la tabla
		ctm.setRowCount(0);

		// Se crea la primera fila por defecto de la Clasificación
		Object[] primerafila = new Object[] { "Posicion:", "Equipo:", "P.Totales:", "P.Jugados:", "P.Ganados:",
				"P.Empatados:", "P.Perdidos:", "P.A Favor:", "P.En Contra:" };
		ctm.addRow(primerafila);

		// Iterar sobre la lista de equipos para llenar la tabla
		for (Equipo equipo : ListaEquipos) {
			if (!equipo.getNombre().equals("Equipo para Descansar")) {

				// Se obtienen las estadísticas del Equipo en esa Temporada
				Estadisticas estadisticas = obtenerEstadisticasEquipo(equipo, Seleccion.getTemporadaSeleccionada());

				// Crear una fila de datos para la tabla
				Object[] fila = new Object[9];
				fila[0] = posicion + 1;
				fila[1] = equipo.getNombre();

				// Se verifica si hay datos en las Estadísticas
				if (estadisticas != null) {
					fila[2] = estadisticas.getPuntosTotales();
					fila[3] = estadisticas.getPartidosJugados();
					fila[4] = estadisticas.getPartidosGanados();
					fila[5] = estadisticas.getPartidosEmpatados();
					fila[6] = estadisticas.getPartidosPerdidos();
					fila[7] = estadisticas.getPuntosFavor();
					fila[8] = estadisticas.getPuntosContra();
				} else {
					// En caso de que no haya datos, se asigna 0 a todo
					fila[2] = 0;
					fila[3] = 0;
					fila[4] = 0;
					fila[5] = 0;
					fila[6] = 0;
					fila[7] = 0;
					fila[8] = 0;
				}

				// Agregar la fila a la tabla
				ctm.addRow(fila);

				// Incrementar la posición
				posicion++;
			}
		}
	}

	/**
	 * Funcion para Obtener las Estadisticas de un Equipo.
	 *
	 * @param equipo    el Equipo
	 * @param temporada la Temporada
	 * @return las Estadisticas
	 */
	private Estadisticas obtenerEstadisticasEquipo(Equipo equipo, Temporada temporada) {
		// Recorrer todas las esetadisticas por temporada que tiene un equipo
		for (Estadisticas est : equipo.getEstadisticasPorTemporada()) {
			// Cuando encuentre las Estadisticas que corresponden con la temporada que
			// buscamos
			if (est.getTemporada().equals(temporada)) {
				return est;
			}
		}
		// No se han Encontrado las Estadisticas
		return null;
	}

	/**
	 * Funcion para Finalizar Temporada.
	 */
	private void Finalizar() {
		Temporada temporadaSeleccionada = Seleccion.getTemporadaSeleccionada();

		// Verificar si todos los partidos han sido jugados
		if (!todosPartidosJugados(temporadaSeleccionada)) {
			JOptionPane.showMessageDialog(this, "No se pueden finalizar temporadas con partidos pendientes.",
					"Temporada Incompleta", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if ("ACTIVA".equals(temporadaSeleccionada.getEstado())) {
			int opcion = JOptionPane.showConfirmDialog(this,
					"¿Estás seguro de que quieres finalizar la temporada? Una vez finalizada, no podrás editarla.",
					"Finalizar Temporada", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (opcion) {
			case 1:
				return;
			case JOptionPane.CLOSED_OPTION:
				return;
			case 0:
				ListaTemporadas.remove(temporadaSeleccionada);
				temporadaSeleccionada.setEstado("FINALIZADA");
				ListaTemporadas.add(temporadaSeleccionada);

				Calendar calendar = Calendar.getInstance();
				int año = calendar.get(Calendar.YEAR);
				int mes = calendar.get(Calendar.MONTH) + 1; // Nota: los meses comienzan desde 0
				int dia = calendar.get(Calendar.DAY_OF_MONTH);
				int hora = calendar.get(Calendar.HOUR_OF_DAY);
				int minuto = calendar.get(Calendar.MINUTE);
				Boolean otraTemporada = false;

				// Crear el formato de fecha y hora
				Fecha fechaActual = new Fecha(dia, mes, año);
				Horario horaActual = new Horario(hora, minuto);
				Usuario usuario = Sesion.getUsuarioActual();

				Logger movimiento = new Logger(usuario,
						"Ha finalizado la Temporada " + Seleccion.getTemporadaSeleccionada().getNumero() + ".", fechaActual,
						horaActual);

				ListaMovimientos.add(movimiento);
				Logger.guardarMovimientos(ListaMovimientos);

				// Se quita el usuario con el que se ha iniciado sesión
				Seleccion.setTemporadaSeleccionada(null);

				// Buscar temporada con el estado "PROXIMAMENTE"
				DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
				for (Temporada temporada : ListaTemporadas) {
					if ("PROXIMAMENTE".equals(temporada.getEstado())) {
						comboBoxModel.addElement("Temporada " + temporada.getNumero());
						otraTemporada = true;
					}
				}

				if (otraTemporada) {
					JComboBox<String> comboBox = new JComboBox<>(comboBoxModel);

					int result = JOptionPane.showOptionDialog(null, comboBox, "¿Quieres Activar otra Temporada?",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (result == JOptionPane.YES_OPTION) {
						// Modificar la temporada seleccionada a estado "ACTIVA"
						String temporadaSeleccion = comboBox.getSelectedItem().toString();
						int numeroTemporada = Integer.parseInt(temporadaSeleccion.replaceAll("[\\D]", ""));
						for (Temporada temporada : ListaTemporadas) {
							if (temporada.getNumero() == numeroTemporada) {
								temporada.setEstado("ACTIVA");
								break;
							}
						}
					}
				}

				// Guardar la lista actualizada en el archivo
				Temporada.guardarTemporadas(ListaTemporadas);

				// Crear las variables
				Inicio I = new Inicio();
				// Mostrar la ventana Inicio
				I.setVisible(true);
				// Centrar la ventana en el centro de la pantalla
				I.setLocationRelativeTo(null);
				// Cerrar la ventana actual
				dispose();
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "No se puede finalizar una temporada que no está activa.",
				"Temporada Errónea", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Funcion para verificar que Todos los Partidos estan Jugados.
	 *
	 * @param temporada the temporada
	 * @return true, if successful
	 */
	private boolean todosPartidosJugados(Temporada temporada) {
		for (Jornada jornada : temporada.getListaJornadas()) {
			for (Partido partido : jornada.getListaPartidos()) {
				if (!partido.getJugado()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Funcion para Inciar la Temporada.
	 */
	private void Iniciar() {
		Temporada temporadaSeleccionada = Seleccion.getTemporadaSeleccionada();

		int opcion = JOptionPane.showConfirmDialog(this,
				"¿Estás seguro de que quieres iniciar la temporada?",
				"Iniciar Temporada", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		switch (opcion) {
		case 1:
			return;
		case JOptionPane.CLOSED_OPTION:
			return;
		case 0:
			ListaTemporadas.remove(temporadaSeleccionada);
			temporadaSeleccionada.setEstado("ACTIVA");
			ListaTemporadas.add(temporadaSeleccionada);

			Calendar calendar = Calendar.getInstance();
			int año = calendar.get(Calendar.YEAR);
			int mes = calendar.get(Calendar.MONTH) + 1; // Nota: los meses comienzan desde 0
			int dia = calendar.get(Calendar.DAY_OF_MONTH);
			int hora = calendar.get(Calendar.HOUR_OF_DAY);
			int minuto = calendar.get(Calendar.MINUTE);

			// Crear el formato de fecha y hora
			Fecha fechaActual = new Fecha(dia, mes, año);
			Horario horaActual = new Horario(hora, minuto);
			Usuario usuario = Sesion.getUsuarioActual();

			Logger movimiento = new Logger(usuario,
					"Se ha iniciado la Temporada " + Seleccion.getTemporadaSeleccionada().getNumero() + ".", fechaActual,
					horaActual);

			ListaMovimientos.add(movimiento);
			Logger.guardarMovimientos(ListaMovimientos);

			// Guardar la lista actualizada en el archivo
			Temporada.guardarTemporadas(ListaTemporadas);
			Seleccion.setTemporadaPosicion(0);

			// Crear las variables
			Inicio I = new Inicio();
			// Mostrar la ventana Inicio
			I.setVisible(true);
			// Centrar la ventana en el centro de la pantalla
			I.setLocationRelativeTo(null);
			// Cerrar la ventana actual
			dispose();
			return;
		}
	}

	/**
	 * Funcion To XML.
	 */
	private void toXML() {
		// Establecer el nombre predeterminado de la carpeta
		File defaultFolder = new File("XML_temporada" + Seleccion.getTemporadaNumero());

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setSelectedFile(defaultFolder);
		int userSelection = fileChooser.showSaveDialog(this);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File folderToSave = fileChooser.getSelectedFile();

			// Crear la carpeta si no existe
			File xmlFolder = new File(folderToSave, "XML_temporada" + Seleccion.getTemporadaNumero());
			if (!xmlFolder.exists()) {
				xmlFolder.mkdirs();
			}

			// Archivo XML para clasificación
			File clasificacionFile = new File(xmlFolder, "clasificacion.xml");

			try (PrintWriter writer = new PrintWriter(clasificacionFile)) {
				// Convertir la tabla de clasificación a XML
				writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
						+ "<?xml-stylesheet type=\"text/xsl\" href=\"cdcatalog.xsl\"?>");
				writer.println("<tabla xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
						+ "xsi:noNamespaceSchemaLocation=\"../xsd/clasificacion.xsd\">");
				writer.println("  <tempActual>" + Seleccion.getTemporadaNumero() + "</tempActual>");

				for (int i = 1; i < tableClasificacion.getRowCount(); i++) {
					writer.println("  <club>");

					writer.println("    <equipo>");
					// Utilizar la función toXML de la clase Equipo para obtener la información del
					// equipo en formato XML
					Equipo equipo = obtenerEquipoDesdeTabla(i);
					writer.println("      " + equipo.toXML());
					writer.println("    </equipo>");

					writer.println("    <puntuacion>");
					// Utilizar la función toXML de la clase Estadisticas para obtener la
					// información de estadísticas en formato XML
					Estadisticas estadisticas = obtenerEstadisticasDesdeTabla(i);
					writer.println("      " + estadisticas.toXML());
					writer.println("    </puntuacion>");

					writer.println("  </club>");
				}

				writer.println("</tabla>");

			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al exportar a XML", "Error", JOptionPane.ERROR_MESSAGE);
			}

			// Archivo XML para el calendario
			File calendarioFile = new File(xmlFolder, "calendario.xml");

			try (PrintWriter writer = new PrintWriter(calendarioFile)) {
				// Convertir la tabla de clasificación a XML
				writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
						+ "<?xml-stylesheet type=\"text/xsl\" href=\"cdcatalog.xsl\"?>");
				writer.println("<calendario xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
						+ "	xsi:noNamespaceSchemaLocation=\"../xsd/calendario.xsd\">");

				for (Jornada jornada : ListaJornadas) {
					writer.println("  <jornada>");

					writer.println("		<NumJornada>" + jornada.getNumero() + "</NumJornada>");

					writer.println("		<FechaInicio>");

					writer.println("			<dia>" + jornada.getFecha().getDia() + "</dia>");
					writer.println("			<mes>" + jornada.getFecha().getMes() + "</mes>");
					writer.println("			<año>" + jornada.getFecha().getAño() + "</año>");

					writer.println("		</FechaInicio>");

					for (Partido partido : jornada.getListaPartidos()) {
						writer.println("		<partido>");
						writer.println("			<equipos>");

						writer.println("				<equipo1>");
						writer.println("					<enlace>../html/paginaclub/Pag" + partido.getEquipoLocal().getNombre()
								+ ".html</enlace>");
						writer.println("					<imagen>../imagenes/escudos/" + partido.getEquipoLocal().getNombre()
								+ ".png</imagen>");
						writer.println("					<nombre>" + partido.getEquipoLocal().getNombre() + "</nombre>");
						if (partido.getPuntosLocal() == -1) {
							writer.println("					<canastas>0</canastas>");
						} else {
							writer.println("					<canastas>" + partido.getPuntosLocal() + "</canastas>");
						}
						writer.println("				</equipo1>");

						writer.println("				<equipo2>");
						writer.println("					<enlace>../html/paginaclub/Pag"
								+ partido.getEquipoVisitante().getNombre() + ".html</enlace>");
						writer.println("					<imagen>../imagenes/escudos/" + partido.getEquipoVisitante().getNombre()
								+ ".png</imagen>");
						writer.println("					<nombre>" + partido.getEquipoVisitante().getNombre() + "</nombre>");
						if (partido.getPuntosVisitante() == -1) {
							writer.println("					<canastas>0</canastas>");
						} else {
							writer.println("					<canastas>" + partido.getPuntosVisitante() + "</canastas>");
						}
						writer.println("				</equipo2>");

						writer.println("			</equipos>");

						writer.println("		</partido>");
					}
					writer.println("  </jornada>");
				}

				writer.println("</calendario>");

			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al exportar a XML", "Error", JOptionPane.ERROR_MESSAGE);
			}

			// Archivo XML para clubes
			File clubesFile = new File(xmlFolder, "clubes.xml");

			try (PrintWriter writer = new PrintWriter(clubesFile)) {
				// Convertir la tabla de clasificación a XML
				writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
						+ "<?xml-stylesheet type=\"text/xsl\" href=\"cdcatalog.xsl\"?>");
				writer.println("<clubes xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
						+ "xsi:noNamespaceSchemaLocation=\"../xsd/clubes.xsd\">");
				writer.println("  <tempActual>" + Seleccion.getTemporadaNumero() + "</tempActual>");

				for (Equipo equipo : ListaEquipos) {
					writer.println("  <equipo>");

					writer.println("    <escudo>");
					writer.println("      <enlace>../html/paginaclub/Pag" + equipo.getNombre() + ".html</enlace>");
					writer.println("      <imagen>../imagenes/escudos/" + equipo.getNombre() + ".png</imagen>");
					writer.println("    </escudo>");

					writer.println("    <nombre>" + equipo.getNombre() + "</nombre>");
					writer.println("    <entrenador>" + equipo.getEntrenador().getNombre() + " "
							+ equipo.getEntrenador().getApellido() + "</entrenador>");

					writer.println("  </equipo>");
				}

				writer.println("</clubes>");

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

				Logger movimiento = new Logger(Sesion.getUsuarioActual(),
						"Ha exportado en formato XML la clasificacion de la Temporada "
								+ Seleccion.getTemporadaSeleccionada().getNumero() + ".",
						fechaActual, horaActual);

				ListaMovimientos.add(movimiento);
				Logger.guardarMovimientos(ListaMovimientos);

				JOptionPane.showMessageDialog(this, "XML exportado correctamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al exportar a XML", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Obtiene la información del equipo desde la tabla en la posición dada.
	 *
	 * @param rowIndex Índice de la fila en la tabla
	 * @return Objeto Equipo con la información del equipo
	 */
	private Equipo obtenerEquipoDesdeTabla(int rowIndex) {
		String nombre = tableClasificacion.getValueAt(rowIndex, 1).toString().trim();

		// Buscar el equipo en ListaEquipos que coincida con el nombre
		for (Equipo equipo : ListaEquipos) {
			if (equipo.getNombre().equals(nombre)) {
				return equipo;
			}
		}
		return null;
	}

	/**
	 * Obtiene la información de estadísticas desde la tabla en la posición dada.
	 *
	 * @param rowIndex Índice de la fila en la tabla
	 * @return Objeto Estadisticas con la información de estadísticas
	 */
	private Estadisticas obtenerEstadisticasDesdeTabla(int rowIndex) {
		String nombre = tableClasificacion.getValueAt(rowIndex, 1).toString().trim();

		// Buscar el equipo en ListaEquipos que coincida con el nombre
		for (Equipo equipo : ListaEquipos) {
			if (equipo.getNombre().equals(nombre)) {
				// Obtener la temporada seleccionada
				Temporada temporadaSeleccionada = Seleccion.getTemporadaSeleccionada(); // Implementa esta función según tu
																												// lógica

				// Recorrer las estadísticas por temporada del equipo
				for (Estadisticas estadisticas : equipo.getEstadisticasPorTemporada()) {
					if (estadisticas.getTemporada().equals(temporadaSeleccionada)) {
						return estadisticas; // Devolver las estadísticas de la temporada seleccionada
					}
				}
			}
		}
		return null; // Si no se encuentra, devolver null
	}

	/**
	 * Funcion para Mostrar un Error.
	 *
	 * @param mensaje el Mensaje de Error
	 */
	private void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Campo Erroneo", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Funcion para Comprobar el Estado de una Temporada.
	 *
	 * @return true, if successful
	 */
	private boolean comprobarTemporada() {
		if (Seleccion.getTemporadaSeleccionada().getEstado().equals("ACTIVA")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Funcion para Añadir un Equipo a la Lista de Equipos Registrados.
	 *
	 * @param nuevoEquipo el Nuevo Equipo
	 */
	public void añadirEquipo(Equipo nuevoEquipo) {
		AñadirEquipo AE = new AñadirEquipo();
		// TODO Auto-generated method stub
		elm.addElement(nuevoEquipo);
		ListaEquiposRegistrados.add(nuevoEquipo);
		elm2.addElement(nuevoEquipo);
		ListaEquipos.add(nuevoEquipo);
		AE.setAbiertoEditar();
	}

	/**
	 * Funcion que Guarda los cambios de Seleccion de las Listas de Equipos.
	 *
	 * @param e el Evento de Seleccion de la Lista
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int selectedIndex = lstEquiposRegistrados.getSelectedIndex();

		if (selectedIndex != -1) {

			EquipoSeleccion.setEquipoPosicion(selectedIndex);
		}
	}

	/**
	 * Funcion para la Apertura de la Ventana.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowOpened(WindowEvent e) {
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
