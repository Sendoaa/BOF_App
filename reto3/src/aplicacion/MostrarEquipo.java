package aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import definicion.Equipo;
import definicion.Jugador;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 * La Clase MostrarEquipo.
 */
public class MostrarEquipo extends JFrame implements ActionListener {

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

	/** El Lable de Entrenador. */
	private JLabel lblEntrenador;

	/** El Panel de Entrenador. */
	private JPanel panelEntrenador;

	/** El Label del Nombre del Entrenador. */
	private JLabel lblEntrenadorNombre;

	/** El Label del Apellido del Entrenador. */
	private JLabel lblEntrenadorApellido;

	/** El Label de la Nacionalidad del Entrenador. */
	private JLabel lblEntrenadorNacionalidad;

	/** El Label de la Fecha de Alta del Entrenador. */
	private JLabel lblEntrenadorFechaAlta;

	/** El Label de la Descripcion. */
	private JLabel lblDescripcion;

	/** El TextField de la Descripcion. */
	private JTextArea textDescripcion;

	/** El Scroll Pane de la Descripcion. */
	private JScrollPane scrollPane;

	/** El Scroll Pane de la Lista de Jugadores. */
	private JScrollPane scrollPanelst;

	/** El Label del DNI del Entrenador. */
	private JLabel lblEntrenadorDNI;

	/** El Label del Escudo. */
	private JLabel lblEscudo;

	/** El Label de los Datos del DNI del Entrenador. */
	private JLabel lblEntrenadorDatosDNI;

	/** El Panel de Jugadores. */
	private JPanel panelJugadores;

	/** El Label del Nombre de los Jugadores. */
	private JLabel lblJugadoresNombre;

	/** El Label del Apellido de los Jugadores. */
	private JLabel lblJugadoresApellido;

	/** El Label de la Nacionalidad de los Jugadores. */
	private JLabel lblJugadoresrNacionalidad;

	/** El Label de la Posicion de los Jugadores. */
	private JLabel lblJugadoresPosicion;

	/** El Label del DNI de los Jugadores. */
	private JLabel lblJugadoresDNI;

	/** El Equipo Seleccionado de la Lista */
	private Equipo equipoSeleccionado;

	/** El Label de los Datos del Nombre del Entrenador. */
	private JLabel lblEntrenadorDatosNombre;

	/** El Label de los Datos del Apellido del Entrenador. */
	private JLabel lblEntrenadorDatosApellido;

	/** El Label de los Datos de la Nacionalidad del Entrenador. */
	private JLabel lblEntrenadorDatosNacionalidad;

	/** El Label de los Datos del Dia de la Fecha del Alta del Entrenador. */
	private JLabel lblEntrenadorDatosFecha;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarEquipo frame = new MostrarEquipo();
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
	public MostrarEquipo() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		setResizable(false);
		setTitle("Informacion Equipo");
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
		btnVolver.setBounds(225, 550, 85, 40);
		contentPane.add(btnVolver);

		lblNombreEquipo = new JLabel("Nombre del Equipo");
		lblNombreEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEquipo.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNombreEquipo.setBounds(10, 10, 516, 33);
		contentPane.add(lblNombreEquipo);

		lblListaJugadores = new JLabel("Lista de Jugadores:");
		lblListaJugadores.setFont(new Font("Dialog", Font.BOLD, 18));
		lblListaJugadores.setBounds(42, 243, 200, 33);
		contentPane.add(lblListaJugadores);

		jlm = new DefaultListModel<Jugador>();

		lstJugadores = new JList<Jugador>();
		lstJugadores.setFont(new Font("Dialog", Font.BOLD, 10));
		lstJugadores.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstJugadores.setBounds(42, 278, 437, 75);
		// asocio el DefaultListModel a la lista
		lstJugadores.setModel(jlm);
		contentPane.add(lstJugadores);

		lblEntrenador = new JLabel("Entrenador:");
		lblEntrenador.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEntrenador.setBounds(42, 126, 234, 33);
		contentPane.add(lblEntrenador);

		panelEntrenador = new JPanel();
		panelEntrenador.setLayout(null);
		panelEntrenador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEntrenador.setBackground(Color.WHITE);
		panelEntrenador.setBounds(42, 169, 437, 54);
		contentPane.add(panelEntrenador);

		lblEntrenadorNombre = new JLabel("Nombre:");
		lblEntrenadorNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorNombre.setBounds(81, 10, 51, 13);
		panelEntrenador.add(lblEntrenadorNombre);

		lblEntrenadorApellido = new JLabel("Apellido:");
		lblEntrenadorApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorApellido.setBounds(156, 10, 51, 13);
		panelEntrenador.add(lblEntrenadorApellido);

		lblEntrenadorNacionalidad = new JLabel("Nacionalidad:");
		lblEntrenadorNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorNacionalidad.setBounds(226, 10, 68, 13);
		panelEntrenador.add(lblEntrenadorNacionalidad);

		lblEntrenadorFechaAlta = new JLabel("Fecha de Alta:");
		lblEntrenadorFechaAlta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorFechaAlta.setBounds(317, 10, 74, 13);
		panelEntrenador.add(lblEntrenadorFechaAlta);

		lblEntrenadorDNI = new JLabel("DNI:");
		lblEntrenadorDNI.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorDNI.setBounds(10, 10, 30, 13);
		panelEntrenador.add(lblEntrenadorDNI);

		lblEntrenadorDatosDNI = new JLabel("...");
		lblEntrenadorDatosDNI.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorDatosDNI.setBounds(10, 33, 68, 13);
		panelEntrenador.add(lblEntrenadorDatosDNI);

		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDescripcion.setBounds(42, 411, 200, 33);
		contentPane.add(lblDescripcion);

		// Reemplaza la declaración de JTextArea existente con la siguiente
		textDescripcion = new JTextArea();
		textDescripcion.setFont(new Font("Dialog", Font.PLAIN, 13));
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(42, 484, 351, 50);
		textDescripcion.setLineWrap(true);
		textDescripcion.setWrapStyleWord(true);

		// Crea un JScrollPane y envuelve el JTextArea con él
		scrollPane = new JScrollPane(textDescripcion);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(42, 454, 437, 70);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPane);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPanelst = new JScrollPane(lstJugadores);
		scrollPanelst.setBorder(null);
		scrollPanelst.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelst.setBounds(42, 318, 437, 75);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPanelst);

		lblEscudo = new JLabel("");
		lblEscudo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEscudo.setBounds(225, 53, 80, 74);
		contentPane.add(lblEscudo);

		panelJugadores = new JPanel();
		panelJugadores.setLayout(null);
		panelJugadores.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelJugadores.setBackground(Color.WHITE);
		panelJugadores.setBounds(42, 285, 437, 33);
		contentPane.add(panelJugadores);

		lblJugadoresNombre = new JLabel("Nombre:");
		lblJugadoresNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadoresNombre.setBounds(81, 10, 43, 13);
		panelJugadores.add(lblJugadoresNombre);

		lblJugadoresApellido = new JLabel("Apellido:");
		lblJugadoresApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadoresApellido.setBounds(156, 10, 50, 13);
		panelJugadores.add(lblJugadoresApellido);

		lblJugadoresrNacionalidad = new JLabel("Nacionalidad:");
		lblJugadoresrNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadoresrNacionalidad.setBounds(226, 10, 68, 13);
		panelJugadores.add(lblJugadoresrNacionalidad);

		lblJugadoresPosicion = new JLabel("Posicion:");
		lblJugadoresPosicion.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadoresPosicion.setBounds(317, 10, 50, 13);
		panelJugadores.add(lblJugadoresPosicion);

		lblJugadoresDNI = new JLabel("DNI:");
		lblJugadoresDNI.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadoresDNI.setBounds(10, 10, 28, 13);
		panelJugadores.add(lblJugadoresDNI);

		lblEntrenadorDatosNombre = new JLabel((String) null);
		lblEntrenadorDatosNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorDatosNombre.setBounds(81, 33, 68, 13);
		panelEntrenador.add(lblEntrenadorDatosNombre);

		lblEntrenadorDatosApellido = new JLabel((String) null);
		lblEntrenadorDatosApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorDatosApellido.setBounds(156, 33, 68, 13);
		panelEntrenador.add(lblEntrenadorDatosApellido);

		lblEntrenadorDatosNacionalidad = new JLabel((String) null);
		lblEntrenadorDatosNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorDatosNacionalidad.setBounds(226, 33, 81, 13);
		panelEntrenador.add(lblEntrenadorDatosNacionalidad);

		lblEntrenadorDatosFecha = new JLabel((String) null);
		lblEntrenadorDatosFecha.setBorder(null);
		lblEntrenadorDatosFecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEntrenadorDatosFecha.setBounds(317, 33, 74, 13);
		panelEntrenador.add(lblEntrenadorDatosFecha);
		
		lstJugadores.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					// Verificar si se ha seleccionado un equipo
					if (lstJugadores.getSelectedValue() != null) {
						// Ejecutar la función al seleccionar un equipo
						MostrarJugador();
					}
				}
			}
		});

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
			dispose();
		}
	}

	/**
	 * Funcion para Enviar el Equipo Seleccionado.
	 *
	 * @param equipo el Equipo
	 */
	public void EnviarEquipo(Equipo equipo) {

		this.equipoSeleccionado = equipo; // Guarda el equipo seleccionado
		VisualizarEquipo();
		VerDatosEquipo();
		VerDatosJugadores();
	}
	
	public void VerDatosEquipo() {
		try {
			// Crear una conexión a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3", "root", "");
			// Crear un objeto Statement para enviar consultas SQL a la base de datos
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// Ejecutar una consulta SQL para obtener todos los equipos
			String nombreEquipo = lblNombreEquipo.getText();
			ResultSet rs = st.executeQuery("SELECT * FROM entrenador WHERE DNIEnt = (SELECT DniEnt FROM equipo WHERE Nombre = '"+nombreEquipo+"');");
			
			if (rs.next()) {
			// Recorrer los resultados y agregarlos a la lista
			String EntrenadorDNI = rs.getString("DNIEnt");
			lblEntrenadorDatosDNI.setText(EntrenadorDNI);
			String EntrenadorNombre = rs.getString("Nombre");
			lblEntrenadorDatosNombre.setText(EntrenadorNombre);
			String EntrenadorApellido = rs.getString("Apellido");
			lblEntrenadorDatosApellido.setText(EntrenadorApellido);
			String EntrenadorNacionalidad = rs.getString("Nacionalidad");
			lblEntrenadorDatosNacionalidad.setText(EntrenadorNacionalidad);
			String EntrenadorFechaAlta = rs.getString("Fecha_Alta");
			lblEntrenadorDatosFecha.setText(EntrenadorFechaAlta);
			}
			
			// Cerrar la conexión
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VerDatosJugadores() {
		try {
			// Crear una conexión a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3", "root", "");
			// Crear un objeto Statement para enviar consultas SQL a la base de datos
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// Ejecutar una consulta SQL para obtener todos los equipos
			String nombreEquipo = lblNombreEquipo.getText(); 
			ResultSet rs = st.executeQuery("SELECT * FROM jugador WHERE DNIJug IN (SELECT DNIJug FROM pertenece WHERE Codeq = (SELECT Codeq FROM equipo WHERE Nombre = '"+nombreEquipo+"'));");

			// Limpiar el modelo de la lista
			jlm.clear();

			// Recorrer los resultados y agregarlos a la lista
			while (rs.next()) {
				String dni = rs.getString("DNIJug");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellido");
				String nacionalidad = rs.getString("nacionalidad");
				String posicion = rs.getString("posicion");
				Jugador jugador = new Jugador(dni, nombre, apellidos, nacionalidad, posicion);
				jlm.addElement(jugador);
			}
			// Cerrar la conexión
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para Visualizar el Equipo Seleccionado.
	 */
	public void VisualizarEquipo() {

		//Fecha fechaAltaEntrenador = equipoSeleccionado.getEntrenador().getFechaAlta();

		lblNombreEquipo.setText(equipoSeleccionado.getNombre());
		// Cargar y mostrar el escudo
		String escudoPath = equipoSeleccionado.getEscudo();
		if (escudoPath != null && !escudoPath.isEmpty()) {
			ImageIcon escudoIcon = new ImageIcon(escudoPath);
			Image escudoImage = escudoIcon.getImage().getScaledInstance(lblEscudo.getWidth(), lblEscudo.getHeight(),
					Image.SCALE_SMOOTH);
			lblEscudo.setIcon(new ImageIcon(escudoImage));
		} else {
			lblEscudo.setIcon(new ImageIcon("src/Imagenes/BOFlogo.png"));
		}
		/*lblEntrenadorDatosDNI.setText(equipoSeleccionado.getEntrenador().getDNI());
		lblEntrenadorDatosNombre.setText(equipoSeleccionado.getEntrenador().getNombre());
		lblEntrenadorDatosApellido.setText(equipoSeleccionado.getEntrenador().getApellido());
		lblEntrenadorDatosNacionalidad.setText(equipoSeleccionado.getEntrenador().getNacionalidad());
		lblEntrenadorDatosFecha.setText("" + equipoSeleccionado.getEntrenador().getFechaAlta().getDia());*/

		/*if (fechaAltaEntrenador.getDia() == 0) {
			lblEntrenadorDatosFecha.setText("1");
		}
		if (fechaAltaEntrenador.getMes() == 0) {
			lblEntrenadorDatosFechaMes.setText("1");
		}
		if (fechaAltaEntrenador.getAño() == 0) {
			lblEntrenadorDatosFechaAño.setText("2024");
		}*/

		/*// Limpiar el DefaultListModel antes de agregar nuevos jugadores
		jlm.clear();

		// Añadir los jugadores al DefaultListModel
		for (Jugador jugador : equipoSeleccionado.getListaJugadores()) {
			jlm.addElement(jugador);
		}*/

		textDescripcion.setText(equipoSeleccionado.getDescripcion());
	}
	
	/**
	 * Funcion para Mostrar el Equipo Seleccionado.
	 */
	private void MostrarJugador() {
		// Creo las variables
		MostrarJugador MJ = new MostrarJugador();
		int selectedIndex = lstJugadores.getSelectedIndex();
		// Muestro la ventana MostrarEquipo
		MJ.EnviarJugador(jlm.getElementAt(selectedIndex));
		MJ.setVisible(true);
		setEnabled(false);
		// Centrar la ventana en el centro de la pantalla
		MJ.setLocationRelativeTo(null);

		MJ.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if (MJ != null) {
					MJ.dispose();
				}
				// Habilitar la ventana de Equipos
				setEnabled(true);
				// Establece que la ventana se quede en primer plano
				requestFocus();
				lstJugadores.clearSelection();
			}
		});
	}
}
