package aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;

import definicion.Equipo;
import definicion.EquipoSeleccion;
import definicion.Estadisticas;
import definicion.Fecha;
import definicion.Horario;
import definicion.Jornada;
import definicion.Logger;
import definicion.Participante;
import definicion.Sesion;
import definicion.Temporada;
import definicion.Usuario;

import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

/**
 * La Clase AñadirTemporada.
 */
public class AñadirTemporada extends JFrame implements ActionListener, ListSelectionListener {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1L;
	
	/** El Content Pane principal. */
	private JPanel contentPane;
	
	/** El Boton de Volver. */
	private JButton btnVolver;
	
	/** El Label del Numero de Temporada. */
	private JLabel lblNumeroTemporada;
	
	/** El Label de la Lista de Equipos. */
	private JLabel lblListaEquipos;
	
	/** La Lista de Equipos. */
	private JList<Equipo> lstEquipos;
	
	/** El Modelo de la Lista de Equipos de la Temporda. */
	private DefaultListModel<Equipo> elm;
	
	/** El Modelo de la Lista de Equipos Registrados. */
	private DefaultListModel<Equipo> elm2;
	
	/** El Boton de Añadir Equipo de la Lista de Equipos Registrados. */
	private JButton btnListaEquiposAñadir;
	
	/** El Boton de Editar Equipo de la Lista de Equipos Registrados. */
	private JButton btnListaEquiposEditar;
	
	/** El Boton de Eliminar Equipo de la Lista de Equipos Registrados. */
	private JButton btnListaEquiposEliminar;
	
	/** El TextField de Numero de la Temporada. */
	private JTextField textNumeroTemporada;
	
	/** El Label del Emoticono de la Flecha. */
	private JLabel lblFlecha;
	
	/** El Label de la Fecha de Inicio. */
	private JLabel lblFecha;
	
	/** El Panel de la Fecha de Inicio. */
	private JPanel panelFecha;
	
	/** El Boton de Guardar. */
	private JButton btnGuardar;
	
	/** La ComboBox del Dia de Inicio de la Temporada. */
	private JComboBox<Integer> comboBoxFechaDia;
	
	/** La ComboBox del Año de Inicio de la Temporada. */
	private JComboBox<Integer> comboBoxFechaAño;
	
	/** La ComboBox del Mes de Inicio de la Temporada. */
	private JComboBox<Integer> comboBoxFechaMes;
	
	/** El Label de la Primera Barra de la Fecha de Inicio. */
	private JLabel lblFechaBarra1;
	
	/** El Label de la Segunda Barra de la Fecha de Inicio. */
	private JLabel lblFechaBarra2;
	
	/** El Label del Dia de la Fecha de Inicio. */
	private JLabel lblFechaDia;
	
	/** El Label del Mes de la Fecha de Inicio. */
	private JLabel lblFechaMes;
	
	/** El Label del Año de la Fecha de Inicio. */
	private JLabel lblFechaAño;
	
	/** El Panel de la Lista de Equipos de la Temporada. */
	private JPanel panelListaEquipos;
	
	/** El Panel de la Lista de Equipos Registrados. */
	private JPanel panelListaEquiposRegistrados;
	
	/** El Scroll Pane de la Lista de Equipos de la Temporada. */
	private JScrollPane scrollPanelst;
	
	/** El Scroll Pane de la Lista de Equipos Registrados. */
	private JScrollPane scrollPanelst2;
	
	/** El Label de los Equipos Registrados. */
	private JLabel lblEquiposRegistrados;
	
	/** El Boton de Crear Equipo de la Lista de Equipos Registrados. */
	private JButton btnListaEquiposCrear;
	
	/** La Fecha Actual del Sistema. */
	private Calendar fechaActual;
	
	/** La Lista de Equipos Registrados. */
	private JList<Equipo> lstEquiposRegistrados;
	
	/** El Modelo de la ComboBox del Año de Inicio. */
	private DefaultComboBoxModel<Integer> modeloAño;
	
	/** La Lista de Temporadas Totales que hay Registradas. */
	private ArrayList<Temporada> ListaTemporadas;
	
	/** La Lista de Jornadas Generadas. */
	private ArrayList<Jornada> ListaJornadas;
	
	/** La Lista de Equipos de la Temporada. */
	private List<Equipo> ListaEquipos;
	
	/** La Lista de Equipos Totales que hay Registrados. */
	private ArrayList<Equipo> ListaEquiposRegistrados;
	
	/** La Lista de Movimientos Totales que hay Registrados. */
	private ArrayList<Logger> ListaMovimientos;
	
	/** La Clase Inicio. */
	Inicio Inicio;

	/** Si algo en la Lista de Equipos ha sido modificado */
	Boolean modificado = false;
	

	/** Los Dias del mes para las ComboBox de las Fechas. */
	private Integer[] dia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
			26, 27, 28, 29, 30, 31 };
	
	/** Los Meses del año para las ComboBox de las Fechas. */
	private Integer[] mes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	
	/** Los Años para las ComboBox de las Fechas. */
	private Integer[] año;

	/** El Dia de la Fecha de Inicio. */
	Integer FechaDia = 0;
	
	/** El Mes de la Fecha de Inicio. */
	Integer FechaMes = 0;
	
	/** El Año de la Fecha de Inicio. */
	Integer FechaAño = 0;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirTemporada frame = new AñadirTemporada();
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
	public AñadirTemporada() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		setResizable(false);
		setTitle("Añadir Temporada");
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
		btnVolver.setBackground(new Color(74,127,214));
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 13));
		btnVolver.setFocusable(false);
		btnVolver.setBounds(335, 523, 85, 50);
		contentPane.add(btnVolver);

		lblNumeroTemporada = new JLabel("Numero de Temporada:");
		lblNumeroTemporada.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNumeroTemporada.setBounds(42, 39, 234, 33);
		contentPane.add(lblNumeroTemporada);

		lblListaEquipos = new JLabel("Equipos:");
		lblListaEquipos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblListaEquipos.setBounds(42, 240, 91, 33);
		contentPane.add(lblListaEquipos);

		elm = new DefaultListModel<Equipo>();

		lstEquipos = new JList<Equipo>();
		lstEquipos.setFont(new Font("Dialog", Font.BOLD, 12));
		lstEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEquipos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstEquipos.setBounds(44, 0, 122, 75);
		// asocio el DefaultListModel a la lista
		lstEquipos.setModel(elm);
		contentPane.add(lstEquipos);

		panelListaEquipos = new JPanel();
		panelListaEquipos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelListaEquipos.setBackground(new Color(255, 255, 255));
		panelListaEquipos.setBounds(42, 283, 122, 62);
		contentPane.add(panelListaEquipos);
		panelListaEquipos.setLayout(null);

		btnListaEquiposEliminar = new JButton("Eliminar");
		btnListaEquiposEliminar.setFocusable(false);
		btnListaEquiposEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnListaEquiposEliminar.addActionListener(this);
		btnListaEquiposEliminar.setBounds(18, 10, 86, 40);
		btnListaEquiposEliminar.setBackground(new Color(230,230,230));
		panelListaEquipos.add(btnListaEquiposEliminar);

		textNumeroTemporada = new JTextField();
		textNumeroTemporada.setBorder(new LineBorder(new Color(171, 173, 179)));
		textNumeroTemporada.setFont(new Font("Dialog", Font.PLAIN, 22));
		textNumeroTemporada.setBounds(42, 82, 437, 33);
		contentPane.add(textNumeroTemporada);
		textNumeroTemporada.setColumns(10);

		lblFecha = new JLabel("Fecha de Inicio:");
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFecha.setBounds(42, 125, 168, 33);
		contentPane.add(lblFecha);

		panelFecha = new JPanel();
		panelFecha.setLayout(null);
		panelFecha.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFecha.setBackground(Color.WHITE);
		panelFecha.setBounds(42, 168, 200, 62);
		contentPane.add(panelFecha);

		comboBoxFechaDia = new JComboBox<Integer>(dia);
		comboBoxFechaDia.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBoxFechaDia.addActionListener(this);
		comboBoxFechaDia.setUI(new BasicComboBoxUI() {
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
		comboBoxFechaDia.setBounds(10, 21, 38, 19);
		panelFecha.add(comboBoxFechaDia);

		inicializarAño();
		modeloAño = new DefaultComboBoxModel<>(año);
		comboBoxFechaAño = new JComboBox<>(modeloAño);
		comboBoxFechaAño.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBoxFechaAño.addActionListener(this);
		comboBoxFechaAño.setUI(new BasicComboBoxUI() {
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
		comboBoxFechaAño.setBounds(131, 21, 59, 19);
		panelFecha.add(comboBoxFechaAño);

		comboBoxFechaMes = new JComboBox<Integer>(mes);
		comboBoxFechaMes.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBoxFechaMes.addActionListener(this);
		comboBoxFechaMes.setUI(new BasicComboBoxUI() {
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
		comboBoxFechaMes.setBounds(72, 21, 37, 19);
		panelFecha.add(comboBoxFechaMes);

		lblFechaBarra1 = new JLabel("/");
		lblFechaBarra1.setBounds(58, 21, 12, 19);
		panelFecha.add(lblFechaBarra1);
		lblFechaBarra1.setFont(new Font("Tahoma", Font.BOLD, 10));

		lblFechaBarra2 = new JLabel("/");
		lblFechaBarra2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaBarra2.setBounds(119, 21, 12, 19);
		panelFecha.add(lblFechaBarra2);

		lblFechaDia = new JLabel("Dia");
		lblFechaDia.setForeground(Color.GRAY);
		lblFechaDia.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaDia.setBounds(11, 39, 21, 13);
		panelFecha.add(lblFechaDia);

		lblFechaMes = new JLabel("Mes");
		lblFechaMes.setForeground(Color.GRAY);
		lblFechaMes.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaMes.setBounds(72, 39, 37, 13);
		panelFecha.add(lblFechaMes);

		lblFechaAño = new JLabel("Año");
		lblFechaAño.setForeground(Color.GRAY);
		lblFechaAño.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaAño.setBounds(131, 39, 21, 13);
		panelFecha.add(lblFechaAño);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGuardar.setFocusable(false);
		btnGuardar.setBackground(new Color(74,127,214));
		btnGuardar.setBounds(128, 523, 85, 50);
		contentPane.add(btnGuardar);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPanelst = new JScrollPane(lstEquipos);
		scrollPanelst.setBorder(null);
		scrollPanelst.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelst.setBounds(42, 345, 122, 125);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPanelst);

		fechaActual = Calendar.getInstance();
		fechaActual.setTime(new Date());
		comboBoxFechaDia.setSelectedItem(fechaActual.get(Calendar.DAY_OF_MONTH));
		comboBoxFechaMes.setSelectedItem(fechaActual.get(Calendar.MONTH) + 1); // Sumar 1 porque los meses van de 0 a 11
		comboBoxFechaAño.setSelectedItem(fechaActual.get(Calendar.YEAR));

		panelListaEquiposRegistrados = new JPanel();
		panelListaEquiposRegistrados.setLayout(null);
		panelListaEquiposRegistrados.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelListaEquiposRegistrados.setBackground(Color.WHITE);
		panelListaEquiposRegistrados.setBounds(197, 283, 323, 62);
		contentPane.add(panelListaEquiposRegistrados);

		btnListaEquiposAñadir = new JButton("Añadir");
		btnListaEquiposAñadir.setFocusable(false);
		btnListaEquiposAñadir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnListaEquiposAñadir.setBounds(16, 10, 86, 40);
		btnListaEquiposAñadir.setBackground(new Color(230,230,230));
		panelListaEquiposRegistrados.add(btnListaEquiposAñadir);

		btnListaEquiposCrear = new JButton("Crear");
		btnListaEquiposCrear.setFocusable(false);
		btnListaEquiposCrear.setFont(new Font("Dialog", Font.BOLD, 12));
		btnListaEquiposCrear.addActionListener(this);
		btnListaEquiposCrear.setBounds(220, 10, 86, 40);
		btnListaEquiposCrear.setBackground(new Color(230,230,230));
		panelListaEquiposRegistrados.add(btnListaEquiposCrear);

		btnListaEquiposEditar = new JButton("Editar");
		btnListaEquiposEditar.setFocusable(false);
		btnListaEquiposEditar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnListaEquiposEditar.setBounds(118, 10, 86, 40);
		btnListaEquiposEditar.setBackground(new Color(230,230,230));
		panelListaEquiposRegistrados.add(btnListaEquiposEditar);
		btnListaEquiposEditar.addActionListener(this);

		elm2 = new DefaultListModel<Equipo>();

		lstEquiposRegistrados = new JList<Equipo>();
		lstEquiposRegistrados.setFont(new Font("Dialog", Font.BOLD, 12));
		lstEquiposRegistrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEquiposRegistrados.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstEquiposRegistrados.setBounds(197, 345, 323, 125);
		lstEquiposRegistrados.addListSelectionListener(this);

		// asocio el DefaultListModel a la lista
		lstEquiposRegistrados.setModel(elm2);
		contentPane.add(lstEquiposRegistrados);
		btnListaEquiposAñadir.addActionListener(this);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPanelst2 = new JScrollPane(lstEquiposRegistrados);
		scrollPanelst2.setBorder(null);
		scrollPanelst2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelst2.setBounds(197, 345, 323, 125);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPanelst2);

		lblEquiposRegistrados = new JLabel("Equipos Registrados:");
		lblEquiposRegistrados.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEquiposRegistrados.setBounds(197, 240, 212, 33);
		contentPane.add(lblEquiposRegistrados);
		
		lblFlecha = new JLabel("🢀");
		lblFlecha.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFlecha.setBounds(170, 380, 24, 36);
		contentPane.add(lblFlecha);

		ListaTemporadas = Temporada.cargarTemporadas();
		ListaEquipos = new ArrayList<>(); // Agrega esta línea para inicializar ListaEquipos
		ListaJornadas = new ArrayList<>(); // Agrega esta línea para inicializar ListaEquipos

		ListaEquiposRegistrados = Equipo.cargarEquipos();

		for (Equipo equipo : ListaEquiposRegistrados) {
			if (!equipo.getNombre().equalsIgnoreCase("Equipo para Descansar")) {
				elm2.addElement(equipo);
			}
		}
		
		EquipoSeleccion.setGuardado(false);
		
		ListaMovimientos = Logger.cargarMovimientos();
	}

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
		} else if (e.getSource() == btnListaEquiposAñadir) {
			Añadir();
		} else if (e.getSource() == btnListaEquiposCrear) {
			Crear();
		} else if (e.getSource() == btnListaEquiposEditar) {
			Editar();
		} else if (e.getSource() == btnListaEquiposEliminar) {
			Eliminar();
		} else if (e.getSource() == comboBoxFechaDia) {
			FechaDia = (Integer) comboBoxFechaDia.getSelectedItem();
			Fecha();
		} else if (e.getSource() == comboBoxFechaMes) {
			FechaMes = (Integer) comboBoxFechaMes.getSelectedItem();
			Fecha();
		} else if (e.getSource() == comboBoxFechaAño) {
			FechaAño = (Integer) comboBoxFechaAño.getSelectedItem();
			Fecha();
		}
	}

	/**
	 * Funcion para seleccionar la Fecha.
	 */
	private void Fecha() {
		if (comboBoxFechaDia != null && comboBoxFechaMes != null && comboBoxFechaAño != null) {
			int selectedDay = (Integer) comboBoxFechaDia.getSelectedItem();
			int selectedMonth = (Integer) comboBoxFechaMes.getSelectedItem();
			int selectedYear = (Integer) comboBoxFechaAño.getSelectedItem();

			// Crear un objeto Calendar con la fecha seleccionada
			Calendar fechaSeleccionada = Calendar.getInstance();
			// Establecer la fecha seleccionada
			fechaSeleccionada.set(selectedYear, selectedMonth - 1, selectedDay); // Meses en Calendar van de 0 a 11

			// Verificar si el año seleccionado es bisiesto
			boolean esBisiesto = (selectedYear % 4 == 0 && (selectedYear % 100 != 0 || selectedYear % 400 == 0));

			// Crear un nuevo array con la longitud adecuada según el mes seleccionado y si
			// es bisiesto
			Integer[] newArray;
			if (selectedMonth == 2) {
				int daysInFebruary = esBisiesto ? 29 : 28;
				newArray = new Integer[daysInFebruary];
			} else if (selectedMonth == 4 || selectedMonth == 6 || selectedMonth == 9 || selectedMonth == 11) {
				newArray = new Integer[30];
			} else {
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
			comboBoxFechaDia.setModel(model);

			// Verificar si el día previamente seleccionado está dentro del rango de días
			// válidos
			if (selectedDay >= 1 && selectedDay <= dia.length) {
				// Mantener el día seleccionado
				comboBoxFechaDia.setSelectedItem(selectedDay);
			} else {
				// Seleccionar el primer día disponible
				comboBoxFechaDia.setSelectedItem(dia[0]);
			}
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
		dispose();
	}

	/**
	 * Funcion para Guardar.
	 */
	private void Guardar() {
		// Obtener valores de los campos
		String NumeroTemporada = textNumeroTemporada.getText();

		// Cambiar el color de fondo a blanco para todos los campos
		resetearColoresCampos();

		// Validar campos
		if (esCampoInvalido(NumeroTemporada) || NumeroTemporada.length() > 10 || !esEntero(NumeroTemporada)
				|| Integer.parseInt(NumeroTemporada) <= 0) {
			resaltarCampo(textNumeroTemporada);
			mostrarError(
					"Por favor, introduzca un numero entero positivo mayor que 0 para la temporada, que contenga 10 digitos o menos");
			return;
		}

		if (elm.getSize() < 6) {
			resaltarCampo(lstEquipos);
			mostrarError("El número mínimo de equipos permitidos es de 6");
			return;
		}
		// Se hace una busqueda en la lista de las temporadas para ver si el numero esta
		// en uso
		for (Temporada temporada : ListaTemporadas) {
			if (("" + temporada.getNumero()).equals(NumeroTemporada)) {
				resaltarCampo(textNumeroTemporada);
				mostrarError("El numero de la temporada ya está en uso");
				return;
			}
		}
		// Creas los nuevos datos ingresados
		// FechaInicio
		Fecha fi = new Fecha(FechaDia, FechaMes, FechaAño);

		ListaEquipos.clear();

		for (int i = 0; i < elm.getSize(); i++) {
			Equipo equipo = (Equipo) elm.getElementAt(i);
			ListaEquipos.add(equipo);
		}

		// Creas una nueva Temporada con los datos ingresados
		Temporada nuevaTemporada = new Temporada(Integer.parseInt(NumeroTemporada), fi, "PROXIMAMENTE", ListaEquipos);

		/*boolean hayTemporadaActiva = false;
		for (Temporada temporada : ListaTemporadas) {
			if ("ACTIVA".equals(temporada.getEstado())) {
				hayTemporadaActiva = true;
				break;
			}
		}

		if (!hayTemporadaActiva) {
			nuevaTemporada.setEstado("ACTIVA");
		}*/

		ListaJornadas = Jornada.generarJornadas(ListaEquipos, fi, nuevaTemporada);	

		// Asignar estadísticas a cada equipo en ListaEquipos
		for (Equipo equipo : ListaEquipos) {
			Estadisticas stats = new Estadisticas(nuevaTemporada);
			equipo.getEstadisticasPorTemporada().add(stats);
		}

		nuevaTemporada.setListaJornadas(ListaJornadas);
		// Agregas el nuevo usuario a la lista
		ListaTemporadas.add(nuevaTemporada);

		// Guardas la lista actualizada en el fichero
		Temporada.guardarTemporadas(ListaTemporadas);

		JOptionPane.showMessageDialog(this, "Se ha creado tu Temporada con éxito", "Temporada Registrado",
				JOptionPane.INFORMATION_MESSAGE);

		Inicio.añadirTemporada(nuevaTemporada);
		

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
				"Ha creado la Temporada " + nuevaTemporada.getNumero()+ ".", fechaActual,
				horaActual);

		ListaMovimientos.add(movimiento);
		Logger.guardarMovimientos(ListaMovimientos);
		
		dispose();
	}

	/**
	 * Funcion para Añadir un Equipo a la Lista de Equipos de la Temporada.
	 */
	private void Añadir() {
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

			modificado = true;
		} else {
			// No hay ningún elemento seleccionado
			mostrarError("Error, ningún elemento seleccionado en la lista");
		}
	}

	/**
	 * Funcion para verificar que no se añade un Equipo con Participantes Duplicados.
	 *
	 * @param model el Modelo de la Lista de tipo Equipo
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
	 * @param model el Modelo de la Lista de tipo Equipo
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
		// Creo las variables
		AñadirEquipo AE = new AñadirEquipo();
		AE.setVentanaTemporada(this);

		AE.setAbiertoTemporada();
		setEnabled(false);

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
				
				ListaMovimientos = Logger.cargarMovimientos();
			}
		});
		// Muestro la ventana Registro
		AE.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		AE.setLocationRelativeTo(null);

		modificado = true;
	}

	/**
	 * Funcion para Editar un Equipo.
	 */
	private void Editar() {
		
		// Obtengo las posiciones de los elementos seleccionados
		int indiceSeleccionado = lstEquiposRegistrados.getSelectedIndex();

		// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {
			// Creo las variables
			EquipoSeleccion.setEquipoSeleccionado(elm2.elementAt(indiceSeleccionado));

			if (elm.contains(EquipoSeleccion.getEquipoSeleccionado())) {
				JOptionPane.showMessageDialog(this, "Si editas un equipo añadido en la temporada tendras que volver a añadirlo", "Aviso Edicion",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
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
						EquipoSeleccion.setGuardado(false);
					}
					lstEquiposRegistrados.clearSelection();
					lstEquipos.clearSelection();
					ListaEquiposRegistrados.add(EquipoSeleccion.getEquipoPosicion(),
							EquipoSeleccion.getEquipoSeleccionado());
					Equipo.guardarEquipos(ListaEquiposRegistrados);

					ListaMovimientos = Logger.cargarMovimientos();
				}
			});
			// Muestro la ventana Registro
			EE.setVisible(true);
			// Centrar la ventana en el centro de la pantalla
			EE.setLocationRelativeTo(null);

			modificado = true;

		} else {
			// No hay ningún elemento seleccionado
			mostrarError("Error, ningún elemento seleccionado en la lista");
		}
	}

	/**
	 * Funcion para Eliminar un equipo de la Lista de Equipos de la Temporada.
	 */
	private void Eliminar() {
		// Obtengo las posiciones de los elementos seleccionados
		int indiceSeleccionado = lstEquipos.getSelectedIndex();

		// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {
			// Elimino elemento
			elm.remove(indiceSeleccionado);
			ListaEquipos.remove(indiceSeleccionado);

			if (elm.getSize() == 0) {
				modificado = false;
			}
		} else {
			// No hay ningún elemento seleccionado
			mostrarError("Error, ningún elemento seleccionado en la lista");
		}
	}

	/**
	 * Funcion para verificar si un String Es Entero.
	 *
	 * @param texto el Texto que se busca verificar
	 * @return true, si es Entero
	 */
	private boolean esEntero(String texto) {
		try {
			Integer.parseInt(texto);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Funcion para Resetear los colores de los campos por defecto.
	 */
	private void resetearColoresCampos() {
		textNumeroTemporada.setBackground(Color.WHITE);
		comboBoxFechaDia.setBackground(Color.WHITE);
		comboBoxFechaMes.setBackground(Color.WHITE);
		comboBoxFechaAño.setBackground(Color.WHITE);
		lstEquipos.setBackground(Color.WHITE);
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
		} else if (componente instanceof JList) {
			((JList<?>) componente).setBackground(new Color(255, 192, 183));
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
	 * Funcion par Inicializar el año de las Fechas.
	 */
	private void inicializarAño() {
		año = new Integer[201]; // 2124 - 1924 + 1

		for (int i = 2124; i >= 1924; i--) {
			año[2124 - i] = i;
		}
	}

	/**
	 * Funcion para Añadir un Equipo a la Lista de Equipos Registrados.
	 *
	 * @param nuevoEquipo el Nuevo Equipo
	 */
	public void añadirEquipo(Equipo nuevoEquipo) {
		// TODO Auto-generated method stub
		elm2.addElement(nuevoEquipo);
		ListaEquipos.add(nuevoEquipo);
	}

	/**
	 * Funcion para identificar a traves de que Ventana Inicio se ha
	 * abierto esta Clase.
	 *
	 * @param inicio la Ventan Inicio que se busca identificar
	 */
	public void setVentanaInicio(Inicio inicio) {
		this.Inicio = inicio;
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
}
