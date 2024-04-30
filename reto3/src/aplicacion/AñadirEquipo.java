package aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicComboBoxUI;

import definicion.Entrenador;
import definicion.Equipo;
import definicion.Fecha;
import definicion.Horario;
import definicion.Jugador;
import definicion.Logger;
import definicion.Participante;
import definicion.Sesion;
import definicion.Usuario;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.ScrollPaneConstants;

/**
 * La Clase AñadirEquipo.
 */
public class AñadirEquipo extends JFrame implements ActionListener, ListSelectionListener {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1L;

	/** El Content Pane principal. */
	private JPanel contentPane;

	/** El Boton de Volver. */
	private JButton btnVolver;

	/** El Label del Nombre de Equipo. */
	private JLabel lblNombreEquipo;

	/** El Label de la Lista de Jugadores. */
	private JLabel lblListaJugadores;

	/** La Lista de Jugadores. */
	private JList<Jugador> lstJugadores;

	/** El Modelo de la Lista de Jugadores. */
	private DefaultListModel<Jugador> jlm;

	/** El TextField de los Nombres de los Jugadores. */
	private JTextField textListaJugadoresNombre;

	/** El Boton de Añadir Jugadores de la Lista. */
	private JButton btnListaJugadoresAñadir;

	/** El Boton de Eliminar Jugadores de la Lista. */
	private JButton btnListaJugadoresEliminar;

	/** El TextField de los Apellidos de los Jugadores. */
	private JTextField textListaJugadoresApellido;

	/** El Label del Nombre de los Jugadores de la Lista. */
	private JLabel lblListajugadoresNombre;

	/** El Label del Apellido de los Jugadores de la Lista. */
	private JLabel lblListaJugadoresApellido;

	/** El Boton de Añadir Escudo. */
	private JButton btnAñadirEscudo;

	/** El TextField del Nombre del Equipo. */
	private JTextField textNombreEquipo;

	/** El Label de la Posicion de los Jugadores de la Lista. */
	private JLabel lblListaJugadoresPosicion;

	/** El Label de la Nacionalidad de los Jugadores de la Lista. */
	private JLabel lblListajugadoresNacionalidad;

	/** La ComboBox de la Nacionalidad de los Jugadores de la Lista. */
	private JComboBox<String> comboBoxListaJugadoresNacionalidad;

	/** El Lable de Entrenador. */
	private JLabel lblEntrenador;

	/** El Panel de Entrenador. */
	private JPanel panelEntrenador;

	/** El TextField del Nombre del Entrenador. */
	private JTextField textEntrenadorNombre;

	/** El TextField del Apellido del Entrenador. */
	private JTextField textEntrenadorApellido;

	/** El Label del Nombre del Entrenador. */
	private JLabel lblEntrenadorNombre;

	/** El Label del Apellido del Entrenador. */
	private JLabel lblEntrenadorApellido;

	/** El Label de la Nacionalidad del Entrenador. */
	private JLabel lblEntrenadorNacionalidad;

	/** La ComboBox la Nacionalidad del Entrenador. */
	private JComboBox<String> comboBoxEntrenadorNacionalidad;

	/** El Label de la Fecha de Alta del Entrenador. */
	private JLabel lblEntrenadorFechaAlta;

	/** El Boton de Guardar. */
	private JButton btnGuardar;

	/** La ComboBox del Dia de Alta del Entrenador. */
	private JComboBox<Integer> comboBoxEntrenadorDia;

	/** La ComboBox del Año de Alta del Entrenador. */
	private JComboBox<Integer> comboBoxEntrenadorAño;

	/** La ComboBox del Mes de Alta del Entrenador. */
	private JComboBox<Integer> comboBoxEntrenadorMes;

	/** El Label de la Primera Barra de la Fecha de Alta del Entrenador. */
	private JLabel lblListajugadoresBarra1;

	/** El Label de la Segunda Barra de la Fecha de Alta del Entrenador. */
	private JLabel lblListajugadoresBarra2;

	/** El Label del Dia de la Fecha de Alta del Entrenador. */
	private JLabel lblEntrenadorDia;

	/** El Label del Mes de la Fecha de Alta del Entrenador. */
	private JLabel lblEntrenadorMes;

	/** El Label del Año de la Fecha de Alta del Entrenador. */
	private JLabel lblEntrenadorAño;

	/** El Panel de la Lista de Jugadores. */
	private JPanel panelListaJugadores;

	/** La ComboBox de la Posicion de los Jugadores de la Lista. */
	private JComboBox<String> comboBoxListaJugadoresPosicion;

	/** El Label de Añadir Escudo. */
	private JLabel lblAñadirEscudo;

	/** El Label de la Descripcion. */
	private JLabel lblDescripcion;

	/** El TextField de la Descripcion. */
	private JTextArea textDescripcion;

	/** El Scroll Pane de la Descripcion. */
	private JScrollPane scrollPane;

	/** El Scroll Pane de la Lista de Jugadores. */
	private JScrollPane scrollPanelst;

	/** El TextField del DNI de los Jugadores de la Lista. */
	private JTextField textListaJugadoresDNI;

	/** El Label del DNI de los Jugadores de la Lista. */
	private JLabel lblListajugadoresDNI;

	/** El TextField del DNI del Entrenador. */
	private JTextField textEntrenadorDNI;

	/** El Label del DNI del Entrenador. */
	private JLabel lblEntrenadorDNI;

	/** El Label del Escudo. */
	private JLabel lblEscudo;

	/** La Lista de Jugadores del Equipo. */
	private ArrayList<Jugador> ListaJugadores;

	/** La Lista de Entrenadores Totales que hay Registrados. */
	private ArrayList<Entrenador> ListaEntrenadores;

	/** La Lista de Equipos Totales que hay Registrados. */
	private ArrayList<Equipo> ListaEquipos;

	/** La Lista de Movimientos Totales que hay Registrados. */
	private ArrayList<Logger> ListaMovimientos;

	/** La Clase AñadirTemporada */
	AñadirTemporada AT;

	/** La Clase EditarTemporada */
	EditarTemp ET;

	/** La Clase Panel */
	Panel P;

	/** Los Dias del mes para las ComboBox de las Fechas. */
	private Integer[] dia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
			26, 27, 28, 29, 30, 31 };

	/** Los Meses del año para las ComboBox de las Fechas. */
	private Integer[] mes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	/** Los Años para las ComboBox de las Fechas. */
	private Integer[] año;

	/** Las Posiciones para la ComboBox de Posicion. */
	private String[] posiciones = { "...", "Base", "Escolta", "Alero", "Ala-Pivot", "Pivot" };

	/** Las Nacionalidades para la ComboBox de Nacionalidad. */
	private String[] nacionalidades = { "...", "Afganistán", "Albania", "Alemania", "Andorra", "Angola",
			"Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán",
			"Bahamas", "Bangladés", "Barbados", "Baréin", "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania",
			"Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi",
			"Bután", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre",
			"Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil",
			"Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador",
			"Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia",
			"Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada",
			"Grecia", "Guatemala", "Guyana", "Guinea", "Guinea ecuatorial", "Guinea-Bisáu", "Haití", "Honduras", "Hungría",
			"India", "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel",
			"Italia", "Jamaica", "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos",
			"Lesoto", "Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo",
			"Macedonia del Norte", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos", "Mauricio",
			"Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Mozambique", "Namibia",
			"Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Omán", "Países Bajos",
			"Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal", "Reino Unido",
			"República Centroafricana", "República Checa", "República del Congo", "República Democrática del Congo",
			"República Dominicana", "Ruanda", "Rumanía", "Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino",
			"San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles",
			"Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán",
			"Sudán del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo",
			"Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay",
			"Uzbekistán", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue" };

	/** Si algo en la Lista de Jugadores ha sido modificado */
	Boolean modificado = false;

	/** Se comprueba desde que Ventana externa ha sido abierta la Clase */
	Integer abierto = 0;

	/** El Escudo del Equipo. */
	String Escudo = "";

	/** El Dia de la Fecha de Alta del Entrenador. */
	Integer DiaEntrenador = 0;

	/** El Mes de la Fecha de Alta del Entrenador. */
	Integer MesEntrenador = 0;

	/** El Año de la Fecha de Alta del Entrenador. */
	Integer AñoEntrenador = 0;

	/** La Nacionalidad de el Entrenador por defecto. */
	String NacionalidadEntrenador = "...";

	/** La Nacionalidad de los Jugadores por defecto. */
	String NacionalidadJugador = "...";

	/** La Posicion de los Jugadores por defecto. */
	String PosicionJugador = "...";

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirEquipo frame = new AñadirEquipo();
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
	public AñadirEquipo() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		setResizable(false);
		setTitle("Añadir Equipo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(74, 127, 214));
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 13));
		btnVolver.setFocusable(false);
		btnVolver.setBounds(329, 556, 85, 40);
		contentPane.add(btnVolver);

		lblNombreEquipo = new JLabel("Nombre del Equipo:");
		lblNombreEquipo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNombreEquipo.setBounds(36, 10, 200, 33);
		contentPane.add(lblNombreEquipo);

		lblListaJugadores = new JLabel("Lista de Jugadores:");
		lblListaJugadores.setFont(new Font("Dialog", Font.BOLD, 18));
		lblListaJugadores.setBounds(36, 247, 200, 33);
		contentPane.add(lblListaJugadores);

		jlm = new DefaultListModel<Jugador>();

		lstJugadores = new JList<Jugador>();
		lstJugadores.setFont(new Font("Dialog", Font.BOLD, 10));
		lstJugadores.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstJugadores.setBounds(42, 368, 437, 75);
		lstJugadores.addListSelectionListener(this);
		// asocio el DefaultListModel a la lista
		lstJugadores.setModel(jlm);
		contentPane.add(lstJugadores);

		panelListaJugadores = new JPanel();
		panelListaJugadores.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelListaJugadores.setBackground(new Color(255, 255, 255));
		panelListaJugadores.setBounds(36, 278, 463, 90);
		contentPane.add(panelListaJugadores);
		panelListaJugadores.setLayout(null);

		textListaJugadoresNombre = new JTextField();
		textListaJugadoresNombre.setBounds(114, 27, 106, 19);
		panelListaJugadores.add(textListaJugadoresNombre);
		textListaJugadoresNombre.setColumns(10);

		btnListaJugadoresAñadir = new JButton("Añadir");
		btnListaJugadoresAñadir.setFocusable(false);
		btnListaJugadoresAñadir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnListaJugadoresAñadir.addActionListener(this);
		btnListaJugadoresAñadir.setBackground(new Color(230, 230, 230));
		btnListaJugadoresAñadir.setBounds(341, 22, 112, 28);
		panelListaJugadores.add(btnListaJugadoresAñadir);

		btnListaJugadoresEliminar = new JButton("Eliminar");
		btnListaJugadoresEliminar.setFocusable(false);
		btnListaJugadoresEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnListaJugadoresEliminar.addActionListener(this);
		btnListaJugadoresEliminar.setBackground(new Color(230, 230, 230));
		btnListaJugadoresEliminar.setBounds(341, 56, 112, 28);
		panelListaJugadores.add(btnListaJugadoresEliminar);

		textListaJugadoresApellido = new JTextField();
		textListaJugadoresApellido.setColumns(10);
		textListaJugadoresApellido.setBounds(225, 27, 106, 19);
		panelListaJugadores.add(textListaJugadoresApellido);

		lblListajugadoresNombre = new JLabel("Nombre:");
		lblListajugadoresNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblListajugadoresNombre.setBounds(114, 10, 106, 13);
		panelListaJugadores.add(lblListajugadoresNombre);

		lblListaJugadoresApellido = new JLabel("Apellido:");
		lblListaJugadoresApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblListaJugadoresApellido.setBounds(225, 10, 106, 13);
		panelListaJugadores.add(lblListaJugadoresApellido);

		lblListaJugadoresPosicion = new JLabel("Posicion:");
		lblListaJugadoresPosicion.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblListaJugadoresPosicion.setBounds(114, 48, 106, 13);
		panelListaJugadores.add(lblListaJugadoresPosicion);

		lblListajugadoresNacionalidad = new JLabel("Nacionalidad:");
		lblListajugadoresNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblListajugadoresNacionalidad.setBounds(6, 48, 106, 13);
		panelListaJugadores.add(lblListajugadoresNacionalidad);

		comboBoxListaJugadoresPosicion = new JComboBox<>(posiciones);
		comboBoxListaJugadoresPosicion.setBackground(Color.WHITE);
		comboBoxListaJugadoresPosicion.setFocusable(false);
		comboBoxListaJugadoresPosicion.addActionListener(this);
		comboBoxListaJugadoresPosicion.setBounds(113, 65, 106, 19);
		panelListaJugadores.add(comboBoxListaJugadoresPosicion);

		comboBoxListaJugadoresNacionalidad = new JComboBox<>(nacionalidades);
		comboBoxListaJugadoresNacionalidad.setBackground(Color.WHITE);
		comboBoxListaJugadoresNacionalidad.setFocusable(false);
		comboBoxListaJugadoresNacionalidad.addActionListener(this);
		comboBoxListaJugadoresNacionalidad.setBounds(6, 65, 106, 19);
		panelListaJugadores.add(comboBoxListaJugadoresNacionalidad);

		textListaJugadoresDNI = new JTextField();
		textListaJugadoresDNI.setColumns(10);
		textListaJugadoresDNI.setBounds(6, 27, 106, 19);
		panelListaJugadores.add(textListaJugadoresDNI);

		lblListajugadoresDNI = new JLabel("DNI/NIE:");
		lblListajugadoresDNI.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblListajugadoresDNI.setBounds(6, 10, 106, 13);
		panelListaJugadores.add(lblListajugadoresDNI);

		lblAñadirEscudo = new JLabel("Añadir Escudo:");
		lblAñadirEscudo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAñadirEscudo.setBounds(36, 81, 200, 33);
		contentPane.add(lblAñadirEscudo);

		btnAñadirEscudo = new JButton("Subir Archivo");
		btnAñadirEscudo.setFocusable(false);
		btnAñadirEscudo.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAñadirEscudo.addActionListener(this);
		btnAñadirEscudo.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAñadirEscudo.setBounds(36, 112, 338, 33);
		btnAñadirEscudo.setBackground(Color.WHITE);
		contentPane.add(btnAñadirEscudo);

		textNombreEquipo = new JTextField();
		textNombreEquipo.setBorder(new LineBorder(new Color(171, 173, 179)));
		textNombreEquipo.setFont(new Font("Dialog", Font.PLAIN, 22));
		textNombreEquipo.setBounds(36, 41, 463, 33);
		contentPane.add(textNombreEquipo);
		textNombreEquipo.setColumns(10);

		lblEntrenador = new JLabel("Entrenador:");
		lblEntrenador.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEntrenador.setBounds(36, 150, 234, 33);
		contentPane.add(lblEntrenador);

		panelEntrenador = new JPanel();
		panelEntrenador.setLayout(null);
		panelEntrenador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEntrenador.setBackground(Color.WHITE);
		panelEntrenador.setBounds(36, 181, 463, 62);
		contentPane.add(panelEntrenador);

		textEntrenadorNombre = new JTextField();
		textEntrenadorNombre.setColumns(10);
		textEntrenadorNombre.setBounds(81, 27, 65, 19);
		panelEntrenador.add(textEntrenadorNombre);

		textEntrenadorApellido = new JTextField();
		textEntrenadorApellido.setColumns(10);
		textEntrenadorApellido.setBounds(156, 27, 65, 19);
		panelEntrenador.add(textEntrenadorApellido);

		lblEntrenadorNombre = new JLabel("Nombre:");
		lblEntrenadorNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorNombre.setBounds(81, 10, 65, 13);
		panelEntrenador.add(lblEntrenadorNombre);

		lblEntrenadorApellido = new JLabel("Apellido:");
		lblEntrenadorApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorApellido.setBounds(156, 10, 65, 13);
		panelEntrenador.add(lblEntrenadorApellido);

		lblEntrenadorNacionalidad = new JLabel("Nacionalidad:");
		lblEntrenadorNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorNacionalidad.setBounds(226, 10, 77, 13);
		panelEntrenador.add(lblEntrenadorNacionalidad);

		comboBoxEntrenadorNacionalidad = new JComboBox<>(nacionalidades);
		comboBoxEntrenadorNacionalidad.setBackground(Color.WHITE);
		comboBoxEntrenadorNacionalidad.setFocusable(false);
		comboBoxEntrenadorNacionalidad.addActionListener(this);
		comboBoxEntrenadorNacionalidad.setBounds(226, 27, 86, 19);
		panelEntrenador.add(comboBoxEntrenadorNacionalidad);

		lblEntrenadorFechaAlta = new JLabel("Fecha de Alta:");
		lblEntrenadorFechaAlta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorFechaAlta.setBounds(317, 10, 74, 13);
		panelEntrenador.add(lblEntrenadorFechaAlta);

		comboBoxEntrenadorDia = new JComboBox<Integer>(dia);
		comboBoxEntrenadorDia.addActionListener(this);
		comboBoxEntrenadorDia.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				return new JButton() {
					private static final long serialVersionUID = 1L;

					@Override
					public int getWidth() {
						return 0; // Oculta la flecha hacia abajo de la comboBox
					}
				};
			}
		});
		comboBoxEntrenadorDia.setBounds(318, 27, 35, 19);
		panelEntrenador.add(comboBoxEntrenadorDia);

		inicializarAño();
		comboBoxEntrenadorAño = new JComboBox<Integer>(año);
		comboBoxEntrenadorAño.addActionListener(this);
		comboBoxEntrenadorAño.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				return new JButton() {
					private static final long serialVersionUID = 1L;

					@Override
					public int getWidth() {
						return 0; // Establece el ancho del botón de flecha a cero
					}

					@Override
					public boolean isVisible() {
						return false; // Hace que el botón de flecha no sea visible
					}
				};
			}
		});
		comboBoxEntrenadorAño.setBounds(392, 27, 61, 19);
		panelEntrenador.add(comboBoxEntrenadorAño);

		comboBoxEntrenadorMes = new JComboBox<Integer>(mes);
		comboBoxEntrenadorMes.addActionListener(this);
		comboBoxEntrenadorMes.setMaximumRowCount(12);
		comboBoxEntrenadorMes.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				return new JButton() {
					private static final long serialVersionUID = 1L;

					@Override
					public int getWidth() {
						return 0; // Establece el ancho del botón de flecha a cero
					}

					@Override
					public boolean isVisible() {
						return false; // Hace que el botón de flecha no sea visible
					}
				};
			}
		});
		comboBoxEntrenadorMes.setBounds(363, 27, 21, 19);
		panelEntrenador.add(comboBoxEntrenadorMes);

		lblListajugadoresBarra1 = new JLabel("/");
		lblListajugadoresBarra1.setBounds(355, 27, 12, 19);
		panelEntrenador.add(lblListajugadoresBarra1);
		lblListajugadoresBarra1.setFont(new Font("Tahoma", Font.BOLD, 10));

		lblListajugadoresBarra2 = new JLabel("/");
		lblListajugadoresBarra2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblListajugadoresBarra2.setBounds(386, 27, 12, 19);
		panelEntrenador.add(lblListajugadoresBarra2);

		lblEntrenadorDia = new JLabel("Dia");
		lblEntrenadorDia.setForeground(Color.GRAY);
		lblEntrenadorDia.setFont(new Font("Dialog", Font.BOLD, 10));
		lblEntrenadorDia.setBounds(319, 45, 21, 13);
		panelEntrenador.add(lblEntrenadorDia);

		lblEntrenadorMes = new JLabel("Mes");
		lblEntrenadorMes.setForeground(Color.GRAY);
		lblEntrenadorMes.setFont(new Font("Dialog", Font.BOLD, 10));
		lblEntrenadorMes.setBounds(358, 45, 29, 13);
		panelEntrenador.add(lblEntrenadorMes);

		lblEntrenadorAño = new JLabel("Año");
		lblEntrenadorAño.setForeground(Color.GRAY);
		lblEntrenadorAño.setFont(new Font("Dialog", Font.BOLD, 10));
		lblEntrenadorAño.setBounds(395, 45, 35, 13);
		panelEntrenador.add(lblEntrenadorAño);

		textEntrenadorDNI = new JTextField();
		textEntrenadorDNI.setColumns(10);
		textEntrenadorDNI.setBounds(10, 27, 65, 19);
		panelEntrenador.add(textEntrenadorDNI);

		lblEntrenadorDNI = new JLabel("DNI/NIE:");
		lblEntrenadorDNI.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorDNI.setBounds(10, 10, 65, 13);
		panelEntrenador.add(lblEntrenadorDNI);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGuardar.setFocusable(false);
		btnGuardar.setBackground(new Color(74, 127, 214));
		btnGuardar.setBounds(122, 556, 85, 40);
		contentPane.add(btnGuardar);

		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDescripcion.setBounds(36, 453, 200, 33);
		contentPane.add(lblDescripcion);

		// Reemplaza la declaración de JTextArea existente con la siguiente
		textDescripcion = new JTextArea();
		textDescripcion.setFont(new Font("Dialog", Font.PLAIN, 13));
		textDescripcion.setBounds(42, 484, 351, 50);
		textDescripcion.setLineWrap(true);
		textDescripcion.setWrapStyleWord(true);

		// Crea un JScrollPane y envuelve el JTextArea con él
		scrollPane = new JScrollPane(textDescripcion);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 484, 464, 50);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPane);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPanelst = new JScrollPane(lstJugadores);
		scrollPanelst.setBorder(null);
		scrollPanelst.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelst.setBounds(36, 368, 464, 75);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPanelst);

		lblEscudo = new JLabel("");
		lblEscudo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEscudo.setBounds(433, 98, 65, 59);
		contentPane.add(lblEscudo);

		ListaJugadores = new ArrayList<Jugador>();
		ListaEntrenadores = Entrenador.cargarEntrenadores();
		ListaEquipos = Equipo.cargarEquipos();
		ListaMovimientos = Logger.cargarMovimientos();
	};

	/**
	 * Funcion Action performed.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Cierro la ventana Login
		// Condicion para dirigirnos a la funcion que corresponda
		if (e.getSource() == btnVolver) {
			Volver();
		} else if (e.getSource() == btnGuardar) {
			Guardar();
		} else if (e.getSource() == btnAñadirEscudo) {
			Escudo();
		} else if (e.getSource() == btnListaJugadoresAñadir) {
			Añadir();
		} else if (e.getSource() == btnListaJugadoresEliminar) {
			Eliminar();
		} else if (e.getSource() == comboBoxEntrenadorDia) {
			DiaEntrenador = (Integer) comboBoxEntrenadorDia.getSelectedItem();
		} else if (e.getSource() == comboBoxEntrenadorMes) {
			MesEntrenador = (Integer) comboBoxEntrenadorMes.getSelectedItem();
			Fecha();
		} else if (e.getSource() == comboBoxEntrenadorAño) {
			AñoEntrenador = (Integer) comboBoxEntrenadorAño.getSelectedItem();
			Fecha();
		} else if (e.getSource() == comboBoxEntrenadorNacionalidad) {
			NacionalidadEntrenador = (String) comboBoxEntrenadorNacionalidad.getSelectedItem();
		} else if (e.getSource() == comboBoxListaJugadoresNacionalidad) {
			NacionalidadJugador = (String) comboBoxListaJugadoresNacionalidad.getSelectedItem();
		} else if (e.getSource() == comboBoxListaJugadoresPosicion) {
			PosicionJugador = (String) comboBoxListaJugadoresPosicion.getSelectedItem();
		}
	}

	/**
	 * Funcion para seleccionar el Escudo.
	 */
	private void Escudo() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png");
		fileChooser.setFileFilter(filter);

		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();

			// Verificar si el archivo tiene una extensión de imagen permitida
			String fileName = selectedFile.getName();
			String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
			if (!extension.equals("jpg") && !extension.equals("jpeg") && !extension.equals("png")) {
				JOptionPane.showMessageDialog(this, "Por favor, selecciona un archivo de imagen válido (jpg, jpeg o png).",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Almacenar la ruta del archivo seleccionado en la variable Escudo
			Escudo = selectedFile.getAbsolutePath();

			try {
				// Cargar la imagen en el JLabel
				ImageIcon imageIcon = new ImageIcon(Escudo);
				Image image = imageIcon.getImage().getScaledInstance(lblEscudo.getWidth(), lblEscudo.getHeight(),
						Image.SCALE_SMOOTH);
				lblEscudo.setIcon(new ImageIcon(image));

			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al cargar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Funcion para seleccionar la Fecha.
	 */
	private void Fecha() {
		// Almacena el día actualmente seleccionado
		int selectedDay = (Integer) comboBoxEntrenadorDia.getSelectedItem();
		int selectedMonth = (Integer) comboBoxEntrenadorMes.getSelectedItem();
		int selectedYear = (Integer) comboBoxEntrenadorAño.getSelectedItem();

		// Crear un nuevo array con la longitud adecuada según el mes seleccionado
		Integer[] newArray;

		if (selectedMonth == 2) {
			// Febrero, verificar si el año es bisiesto
			int daysInFebruary = (selectedYear % 4 == 0 && (selectedYear % 100 != 0 || selectedYear % 400 == 0)) ? 29 : 28;
			newArray = new Integer[daysInFebruary];
		} else if (selectedMonth == 4 || selectedMonth == 6 || selectedMonth == 9 || selectedMonth == 11) {
			// Meses con 30 días
			newArray = new Integer[30];
		} else {
			// Meses con 31 días
			newArray = new Integer[31];
		}

		// Llenar el array con días consecutivos
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = i + 1;
		}

		// Actualizar el array original con el nuevo array
		dia = newArray;

		// Actualizar el modelo del JComboBox con el nuevo array
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>(dia);
		comboBoxEntrenadorDia.setModel(model);

		// Verificar si el día previamente seleccionado está dentro del rango de días
		// válidos
		if (selectedDay >= 1 && selectedDay <= dia.length) {
			// Mantener el día seleccionado
			comboBoxEntrenadorDia.setSelectedItem(selectedDay);
		} else {
			// Seleccionar el primer día disponible
			comboBoxEntrenadorDia.setSelectedItem(dia[0]);
		}
	}

	/**
	 * Funcion para Volver.
	 */
	private void Volver() {
		if (modificado) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de que quieres salir sin guardar?",
					"Cierre sin guardar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (opcion) {
			case 1:
				return;
			case JOptionPane.CLOSED_OPTION:
				return;
			}
		}
		// Cierro la ventana Login
		dispose();
	}

	/**
	 * Funcion para Guardar.
	 */
	private void Guardar() {
		// Obtener valores de los campos
		String NombreEquipo = textNombreEquipo.getText();
		String DNIEntrenador = textEntrenadorDNI.getText();
		String NombreEntrenador = textEntrenadorNombre.getText();
		String ApellidoEntrenador = textEntrenadorApellido.getText();
		String Descripcion = textDescripcion.getText();

		// Cambiar el color de fondo a blanco para todos los campos
		resetearColoresCampos();

		// Se hace una busqueda en la lista de los Equipos para ver si el nombre esta en
		// uso
		for (Equipo equipo : ListaEquipos) {
			if (equipo.getNombre().equals(NombreEquipo)) {
				resaltarCampo(textNombreEquipo);
				mostrarError("El nombre del equipo ya está en uso");
				return;
			}
		}

		// Validar campos
		if (esCampoInvalido(NombreEquipo) || NombreEquipo.length() > 10) {
			resaltarCampo(textNombreEquipo);
			mostrarError("Por favor, introduzca el Nombre del Equipo, el maximo de caracteres permitido es 9");
			return;
		}

		if (esCampoInvalido(Escudo)) {
			resaltarCampo(lblEscudo);
			mostrarError("Por favor, introduzca el Escudo del Equipo");
			return;
		}

		if (esCampoInvalido(DNIEntrenador) || DNIEntrenador.length() != 9 || verificarDNIDuplicado(DNIEntrenador)) {
			resaltarCampo(textEntrenadorDNI);
			mostrarError("Por favor, introduzca el DNI del Entrenador, debe contener 9 caracteres y debe ser unico");
			return;
		}

		if (esCampoInvalido(NombreEntrenador)) {
			resaltarCampo(textEntrenadorNombre);
			mostrarError("Por favor, introduzca el Nombre del Entrenador");
			return;
		}

		if (esCampoInvalido(ApellidoEntrenador)) {
			resaltarCampo(textEntrenadorApellido);
			mostrarError("Por favor, introduzca el Apellido del Entrenador");
			return;
		}

		if (esCampoInvalido(NacionalidadEntrenador) || NacionalidadEntrenador.equals("...")) {
			resaltarCampo(comboBoxEntrenadorNacionalidad);
			mostrarError("Por favor, seleccione la Nacionalidad del Entrenador");
			return;
		}

		if (jlm.getSize() < 5) {
			resaltarCampo(lstJugadores);
			mostrarError("El número mínimo de jugadores permitidos es de 5");
			return;
		}

		if (esCampoInvalido(Descripcion)) {
			resaltarCampo(textDescripcion);
			mostrarError("Por favor, introduzca la Descripción");
			return;
		}
		
		// Si todos los campos están validados correctamente, procedemos a guardar el
		// Escudo en la Carpeta
		try {
			// Construir el nombre de archivo usando el nombre del equipo y su extensión
			String extension = Escudo.substring(Escudo.lastIndexOf(".") + 1).toLowerCase();
			String destinationFileName = NombreEquipo + "." + extension;

			// Construir la ruta de destino en la carpeta /ficheros/escudos
			String destinationPath = "ficheros/escudos/" + destinationFileName;

			// Copiar el archivo a la carpeta de destino
			Files.copy(new File(Escudo).toPath(), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
			
			Escudo = destinationPath;

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al copiar el archivo del escudo.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		ArrayList<Jugador> TotalJugadores = Jugador.cargarJugadores();

		TotalJugadores.addAll(ListaJugadores);

		// Guardas la lista actualizada en el fichero
		Jugador.guardarJugadores(TotalJugadores);
		// Creas los nuevos datos ingresados
		Participante nuevoParticipante = new Participante(DNIEntrenador, NombreEntrenador, ApellidoEntrenador,
				NacionalidadEntrenador);

		Fecha f = new Fecha(DiaEntrenador, MesEntrenador, AñoEntrenador);
		Entrenador nuevoEntrenador = new Entrenador(nuevoParticipante, f);
		// Agregas el nuevo entrenador a la lista
		ListaEntrenadores.add(nuevoEntrenador);
		// Guardas la lista actualizada en el fichero
		Entrenador.guardarEntrenadores(ListaEntrenadores);

		// Creas un nuevo Equipo con los datos ingresados
		Equipo nuevoEquipo = new Equipo(NombreEquipo, Escudo, Descripcion, nuevoEntrenador, ListaJugadores);

		// Agregas el nuevo usuario a la lista
		ListaEquipos.add(nuevoEquipo);

		// Guardas la lista actualizada en el fichero
		Equipo.guardarEquipos(ListaEquipos);

		JOptionPane.showMessageDialog(this, "Se ha registrado tu Equipo con éxito", "Equipo Registrado",
				JOptionPane.INFORMATION_MESSAGE);

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

		Logger movimiento = new Logger(usuario, "Ha creado el Equipo " + nuevoEquipo.getNombre() + ".", fechaActual,
				horaActual);

		ListaMovimientos.add(movimiento);
		Logger.guardarMovimientos(ListaMovimientos);

		// Se detecta desde que ventana externa a sido abierta la Clase
		switch (abierto) {
		case 1:
			AT.añadirEquipo(nuevoEquipo);
			dispose();
			break;
		case 2:
			ET.añadirEquipo(nuevoEquipo);
			dispose();
			break;
		case 3:
			P.añadirEquipo(nuevoEquipo);
			dispose();
			break;
		}

	}

	/**
	 * Funcion para Añadir un Jugador a la Lista de Jugadores.
	 */
	private void Añadir() {
		String DNIJugador = textListaJugadoresDNI.getText();
		String DNIEntrenador = textEntrenadorDNI.getText();
		String NombreJugador = textListaJugadoresNombre.getText();
		String ApellidoJugador = textListaJugadoresApellido.getText();

		// Cambio de color del fondo del todo a Blanco
		resetearColoresCampos();

		if (DNIJugador.equals(DNIEntrenador)) {
			// Se encontró un DNI duplicado
			resaltarCampo(textListaJugadoresDNI);
			// Mostramos mensaje de error
			mostrarError("Lo siento, el DNI que intenta introducir lo tiene asignado el Entrenador");
			return;
		}

		if (verificarDNIDuplicado(DNIJugador)) {
			resaltarCampo(textListaJugadoresDNI);
			// Mostramos mensaje de error
			mostrarError("Lo siento, el DNI que intenta introducir se encuentra repetido");
			return;
		}

		if (esCampoInvalido(DNIJugador) || DNIJugador.length() != 9) {
			// Cambio de color del fondo del DNI
			resaltarCampo(textListaJugadoresDNI);
			// Mostramos mensaje de error
			mostrarError("Por favor, introduzca el DNI del Jugador, debe contener 9 caracteres");
			return;
		} else if (esCampoInvalido(NombreJugador)) {
			// Cambio de color del fondo del DNI
			resaltarCampo(textListaJugadoresNombre);
			// Mostramos mensaje de error
			mostrarError("Por favor, introduzca el Nombre del Jugador");
			return;
		} else if (esCampoInvalido(ApellidoJugador)) {
			// Cambio de color del fondo del DNI
			resaltarCampo(textListaJugadoresApellido);
			// Mostramos mensaje de error
			mostrarError("Por favor, introduzca el Apellido del Jugador");
			return;
		} else if (NacionalidadJugador.equals("...")) {
			// Cambio de color del fondo del DNI
			resaltarCampo(comboBoxListaJugadoresNacionalidad);
			// Mostramos mensaje de error
			mostrarError("Por favor, seleccione la Nacionalidad del Jugador");
			return;
		} else if (PosicionJugador.equals("...")) {
			// Cambio de color del fondo del DNI
			resaltarCampo(comboBoxListaJugadoresPosicion);
			// Mostramos mensaje de error
			mostrarError("Por favor, seleccione la Posición del Jugador");
			return;
		}

		// Crear un nuevo objeto Jugador con la información proporcionada
		Participante nuevoParticipante = new Participante(DNIJugador, NombreJugador, ApellidoJugador,
				NacionalidadJugador);
		Jugador nuevoJugador = new Jugador(nuevoParticipante, PosicionJugador);

		// Agregas el nuevo usuario a la lista
		ListaJugadores.add(nuevoJugador);

		// Añadir el nuevo jugador al DefaultListModel
		jlm.addElement(nuevoJugador);

		// Limpiar los campos después de añadir el jugador
		textListaJugadoresDNI.setText("");
		textListaJugadoresNombre.setText("");
		textListaJugadoresApellido.setText("");
		comboBoxListaJugadoresNacionalidad.setSelectedIndex(0);
		comboBoxListaJugadoresPosicion.setSelectedIndex(0);

		lstJugadores.clearSelection();
		// Indicar que se ha modificado la lista
		modificado = true;

	}

	/**
	 * Funcion para Eliminar un Jugador a la Lista de Jugadores.
	 */
	private void Eliminar() {
		// Obtengo las posiciones de los elementos seleccionados
		int[] indicesSeleccionados = lstJugadores.getSelectedIndices();

		// Compruebo si hay algún elemento seleccionado
		if (indicesSeleccionados.length > 0) {
			// Si hay elementos seleccionados, elimino cada uno de ellos en orden inverso
			for (int i = indicesSeleccionados.length - 1; i >= 0; i--) {
				jlm.remove(indicesSeleccionados[i]);
				// Elimino el jugador correspondiente de la lista general
				ListaJugadores.remove(indicesSeleccionados[i]);
			}

			// Verifico si la lista está vacía después de la eliminación
			if (jlm.getSize() == 0) {
				// Haz algo si la lista está vacía, si es necesario
			}
		} else {
			// No hay ningún elemento seleccionado
			mostrarError("Error, ningún elemento seleccionado en la lista");
		}
	}

	/**
	 * Funcion para Resetear los colores de los campos por defecto.
	 */
	private void resetearColoresCampos() {
		textNombreEquipo.setBackground(Color.WHITE);
		lblEscudo.setBorder(new LineBorder(Color.BLACK));
		textEntrenadorDNI.setBackground(Color.WHITE);
		textEntrenadorNombre.setBackground(Color.WHITE);
		textEntrenadorApellido.setBackground(Color.WHITE);
		comboBoxEntrenadorNacionalidad.setBackground(Color.WHITE);
		comboBoxEntrenadorDia.setBackground(Color.WHITE);
		comboBoxEntrenadorMes.setBackground(Color.WHITE);
		comboBoxEntrenadorAño.setBackground(Color.WHITE);
		lstJugadores.setBackground(Color.WHITE);
		textDescripcion.setBackground(Color.WHITE);

		textListaJugadoresDNI.setBackground(Color.WHITE);
		textListaJugadoresNombre.setBackground(Color.WHITE);
		textListaJugadoresApellido.setBackground(Color.WHITE);
		comboBoxListaJugadoresNacionalidad.setBackground(Color.WHITE);
		comboBoxListaJugadoresPosicion.setBackground(Color.WHITE);
	}

	/**
	 * Funcion para verificar si Es Campo Invalido.
	 *
	 * @param campo el Campo que se quiere comprobar
	 * @return true, si el contenido es null o esta vacio
	 */
	private boolean esCampoInvalido(String campo) {
		return campo == null || campo.trim().isEmpty();
	}

	/**
	 * Funcion para Resaltar el Campo.
	 *
	 * @param componente el Componente que se quiere resaltar
	 */
	private void resaltarCampo(JComponent componente) {
		if (componente instanceof JTextField) {
			((JTextField) componente).setBackground(new Color(255, 192, 183));
		} else if (componente instanceof JLabel) {
			((JLabel) componente).setBorder(new LineBorder(new Color(255, 192, 183)));
		} else if (componente instanceof JComboBox) {
			((JComboBox<?>) componente).setBackground(new Color(255, 192, 183));
		} else if (componente instanceof JList) {
			((JList<?>) componente).setBackground(new Color(255, 192, 183));
		} else if (componente instanceof JTextArea) {
			((JTextArea) componente).setBackground(new Color(255, 192, 183));
		}
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
	 * Funcion para Verificar un DNI Duplicado.
	 *
	 * @param nuevoDNI el Nuevo DNI introducido
	 * @return true, si el DNI esta Duplicado
	 */
	private boolean verificarDNIDuplicado(String nuevoDNI) {
		for (Participante participante : ListaJugadores) {
			if (participante.getDNI().equals(nuevoDNI)) {
				// Se encontró un DNI duplicado
				return true;
			}
		}
		// No se encontraron DNIs duplicados
		return false;
	}

	/**
	 * Funcion par Inicializar el año de las Fechas.
	 */
	private void inicializarAño() {
		año = new Integer[121]; // 2024 - 1904 + 1

		for (int i = 2024; i >= 1904; i--) {
			año[2024 - i] = i;
		}
	}

	/**
	 * Funcion para indicar que se ha abierto la Ventana a traves de la clase
	 * AñadirTemporada.
	 */
	public void setAbiertoTemporada() {
		abierto = 1;
	}

	/**
	 * Funcion para indicar que se ha abierto la Ventana a traves de la clase
	 * EditarTemporada.
	 */
	public void setAbiertoEditar() {
		abierto = 2;
	}

	/**
	 * Funcion para indicar que se ha abierto la Ventana a traves de la clase Panel.
	 */
	public void setAbiertoPanel() {
		abierto = 3;
	}

	/**
	 * Funcion para identificar a traves de que Ventana AñadirTemporada se ha
	 * abierto esta Clase.
	 *
	 * @param ventanaTemporada la Ventan AñadirTemporada que se busca identificar
	 */
	public void setVentanaTemporada(AñadirTemporada ventanaTemporada) {
		this.AT = ventanaTemporada;
	}

	/**
	 * Funcion para identificar a traves de que Ventana EditarTemporada se ha
	 * abierto esta Clase.
	 *
	 * @param EditarTemp la Ventan EditarTemporada que se busca identificar
	 */
	public void setVentanaEditar(EditarTemp EditarTemp) {
		this.ET = EditarTemp;
	}

	/**
	 * Funcion para identificar a traves de que Ventana Panel se ha abierto esta
	 * Clase.
	 *
	 * @param panel la Ventan Panel que se busca identificar
	 */
	public void setVentanaPanel(Panel panel) {
		this.P = panel;
	}

	/**
	 * Funcion que Guarda los cambios de Seleccion de la Lista de Jugadores.
	 *
	 * @param e el Evento de Seleccion de la Lista
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// Obtener el índice seleccionado en la lista activa
		int selectedIndex = lstJugadores.getSelectedIndex();

		if (selectedIndex != -1) {
			// Cambiar valores de los txt
			textListaJugadoresDNI.setText(jlm.getElementAt(selectedIndex).getDNI());
			textListaJugadoresNombre.setText(jlm.getElementAt(selectedIndex).getNombre());
			textListaJugadoresApellido.setText(jlm.getElementAt(selectedIndex).getApellido());
			comboBoxListaJugadoresNacionalidad.setSelectedItem(jlm.getElementAt(selectedIndex).getNacionalidad());
			comboBoxListaJugadoresPosicion.setSelectedItem(jlm.getElementAt(selectedIndex).getPosicion());
		}

	}
}
