package aplicacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import definicion.Jugador;
import definicion.Seleccion;
import definicion.Sesion;
import javax.swing.SwingConstants;
import javax.swing.JTable;

/**
 * La Clase MostrarEquipo.
 */
public class MostrarJugador extends JFrame implements ActionListener, WindowListener {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1L;

	/** El Content Pane principal. */
	private JPanel contentPane;

	/** El Boton de Volver. */
	private JButton btnVolver;

	/** El Label del Nombre de Equipo. */
	private JLabel lblNombreJugador;

	/** El Modelo de la Lista de Jugadores. */
	private DefaultListModel<Jugador> jlm;

	/** El Lable de Entrenador. */
	private JLabel lblJugador;

	/** El Label del Escudo. */
	private JLabel lblFotoJugador;

	/** El Equipo Seleccionado de la Lista */
	private Jugador jugadorSeleccionado;
	private JButton btnCambiarImagen;

	private String Imagen = "";
	private JButton btnEditar;

	// Vectores para la tabla
	private Vector<Vector<String>> datosTabla;
	private Vector<String> fila;
	private Vector<String> columnas;
	private DefaultTableModel dtmTabla;
	private JScrollPane scrollPane;
	private JTable tablaDatosJugador;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarJugador frame = new MostrarJugador();
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
	public MostrarJugador() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		setResizable(false);
		setTitle("Informacion Jugador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(74, 127, 114));
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 13));
		btnVolver.setFocusable(false);
		btnVolver.setBounds(266, 281, 85, 40);
		contentPane.add(btnVolver);

		lblNombreJugador = new JLabel("Nombre del Jugador");
		lblNombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJugador.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNombreJugador.setBounds(10, 10, 516, 33);
		contentPane.add(lblNombreJugador);

		jlm = new DefaultListModel<Jugador>();

		lblJugador = new JLabel("Datos personales");
		lblJugador.setFont(new Font("Dialog", Font.BOLD, 18));
		lblJugador.setBounds(42, 126, 234, 33);
		contentPane.add(lblJugador);

		lblFotoJugador = new JLabel("");
		lblFotoJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFotoJugador.setBounds(225, 53, 80, 74);
		contentPane.add(lblFotoJugador);

		btnCambiarImagen = new JButton("Seleccionar Imagen");
		btnCambiarImagen.addActionListener(this);
		btnCambiarImagen.setFocusable(false);
		btnCambiarImagen.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCambiarImagen.setBounds(315, 74, 131, 27);
		contentPane.add(btnCambiarImagen);

		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnEditar.setFocusable(false);
		btnEditar.setBackground(new Color(74, 127, 114));
		btnEditar.setBounds(180, 281, 85, 40);
		contentPane.add(btnEditar);

		scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setBounds(42, 162, 437, 109);
		contentPane.add(scrollPane);

		try {
			// Crear una conexión a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3", "root", "");
			// Crear un objeto Statement para enviar consultas SQL a la base de datos
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// Ejecutar una consulta SQL para obtener todos los equipos
			ResultSet rs = st.executeQuery("SELECT * FROM jugador");
		
			// Crear las columnas de la tabla
			Vector<String> columnas = new Vector<String>();
			columnas.add("DNIJug");
			columnas.add("Nombre");
			columnas.add("Apellidos");
			columnas.add("Nacionalidad");
			columnas.add("Posicion");
		
			// Crear los datos de la tabla
			Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
		
			// Recorrer el ResultSet y añadir cada fila a datosTabla
				Vector<String> fila = new Vector<String>();
				fila.add(Seleccion.jugadorSeleccionado.getDNI());
				fila.add(Seleccion.jugadorSeleccionado.getNombre());
				fila.add(Seleccion.jugadorSeleccionado.getApellido());
				fila.add(Seleccion.jugadorSeleccionado.getNacionalidad());
				fila.add(Seleccion.jugadorSeleccionado.getPosicion());
				datosTabla.add(fila);
			
		
			// Crear el DefaultTableModel de la tabla
			DefaultTableModel dtmTabla = new DefaultTableModel(datosTabla, columnas){
				@Override
				public boolean isCellEditable(int row, int column) {
					// Todas las celdas no son editables
					return false;
				}
			};
		
			JTable tablaDatosJugador = new JTable(dtmTabla);
			scrollPane.setViewportView(tablaDatosJugador);
		
			// Cerrar la conexión
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		addWindowListener(this);

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
		} else if (e.getSource() == btnCambiarImagen) {
			FotoJugador();
		}
	}

	/**
	 * Funcion para Enviar el Equipo Seleccionado.
	 *
	 * @param equipo el Equipo
	 */
	public void EnviarJugador(Jugador jugador) {

		this.jugadorSeleccionado = jugador; // Guarda el equipo seleccionado
		// VisualizarJugador();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// Si el usuario actual NO es un usuario con privilegios
		if (Sesion.getUsuarioActual() != null) {
			if (!Sesion.getUsuarioActual().getPrivilegiado()) {
				// Oculta el botón de cambiarImagen
				btnCambiarImagen.setVisible(false);
				btnEditar.setVisible(false);
				btnVolver.setBounds(220, 281, 85, 40);
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	private void FotoJugador() {
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
				JOptionPane.showMessageDialog(this,
						"Por favor, selecciona un archivo de imagen válido (jpg, jpeg o png).",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Almacenar la ruta del archivo seleccionado en la variable Escudo
			Imagen = selectedFile.getAbsolutePath();

			try {
				// Cargar la imagen en el JLabel
				ImageIcon imageIcon = new ImageIcon(Imagen);
				Image image = imageIcon.getImage().getScaledInstance(lblFotoJugador.getWidth(),
						lblFotoJugador.getHeight(),
						Image.SCALE_SMOOTH);
				lblFotoJugador.setIcon(new ImageIcon(image));

			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al cargar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
			}

			/*
			 * try { // Construir el nombre de archivo usando el nombre del equipo y su
			 * extensión extension = Imagen.substring(Imagen.lastIndexOf(".") +
			 * 1).toLowerCase(); String destinationFileName = lblJugadorDatosDNI.getText() +
			 * "." + extension;
			 * 
			 * // Construir la ruta de destino en la carpeta /ficheros/escudos String
			 * destinationPath = "ficheros/fotos/" + destinationFileName;
			 * 
			 * // Copiar el archivo a la carpeta de destino Files.copy(new
			 * File(Imagen).toPath(), Paths.get(destinationPath),
			 * StandardCopyOption.REPLACE_EXISTING);
			 * 
			 * Imagen = destinationPath;
			 * 
			 * } catch (IOException e) { e.printStackTrace();
			 * JOptionPane.showMessageDialog(this, "Error al copiar el archivo de la foto.",
			 * "Error", JOptionPane.ERROR_MESSAGE); return; }
			 */
		}
	}

	/**
	 * Funcion para Visualizar el Equipo Seleccionado.
	 */
	/*
	 * public void VisualizarJugador() {
	 * 
	 * Fecha fechaAltaEntrenador =
	 * equipoSeleccionado.getEntrenador().getFechaAlta();
	 * 
	 * lblNombreJugador.setText(equipoSeleccionado.getNombre()); // Cargar y mostrar
	 * el escudo String escudoPath = equipoSeleccionado.getEscudo(); if (escudoPath
	 * != null && !escudoPath.isEmpty()) { ImageIcon escudoIcon = new
	 * ImageIcon(escudoPath); Image escudoImage =
	 * escudoIcon.getImage().getScaledInstance(lblFotoJugador.getWidth(),
	 * lblFotoJugador.getHeight(), Image.SCALE_SMOOTH); lblFotoJugador.setIcon(new
	 * ImageIcon(escudoImage)); } else { lblFotoJugador.setIcon(new
	 * ImageIcon("src/Imagenes/BOFlogo.png")); }
	 * lblJugadorDatosDNI.setText(equipoSeleccionado.getEntrenador().getDNI());
	 * lblJugadorDatosNombre.setText(equipoSeleccionado.getEntrenador().getNombre())
	 * ; lblJugadorDatosApellido.setText(equipoSeleccionado.getEntrenador().
	 * getApellido());
	 * lblJugadorDatosNacionalidad.setText(equipoSeleccionado.getEntrenador().
	 * getNacionalidad()); lblJugadorDatosFechaDia.setText("" +
	 * equipoSeleccionado.getEntrenador().getFechaAlta().getDia());
	 * lblJugadorDatosFechaMes.setText("" +
	 * equipoSeleccionado.getEntrenador().getFechaAlta().getMes());
	 * lblJugadorDatosFechaAño.setText("" +
	 * equipoSeleccionado.getEntrenador().getFechaAlta().getAño());
	 * 
	 * if (fechaAltaEntrenador.getDia() == 0) {
	 * lblJugadorDatosFechaDia.setText("1"); } if (fechaAltaEntrenador.getMes() ==
	 * 0) { lblJugadorDatosFechaMes.setText("1"); } if (fechaAltaEntrenador.getAño()
	 * == 0) { lblJugadorDatosFechaAño.setText("2024"); }
	 * 
	 * // Limpiar el DefaultListModel antes de agregar nuevos jugadores jlm.clear();
	 * 
	 * // Añadir los jugadores al DefaultListModel for (Jugador jugador :
	 * equipoSeleccionado.getListaJugadores()) { jlm.addElement(jugador); } }
	 */
}
