package aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import definicion.Equipo;
import definicion.Fecha;
import definicion.Jugador;
import definicion.Sesion;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 * La Clase MostrarEquipo.
 */
public class MostrarJugadorCOPIA extends JFrame implements ActionListener, WindowListener {

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

	/** El Panel de Entrenador. */
	private JPanel panelJugador;

	/** El Label del Nombre del Entrenador. */
	private JLabel lblJugadorNombre;

	/** El Label del Apellido del Entrenador. */
	private JLabel lblJugadorApellido;

	/** El Label de la Nacionalidad del Entrenador. */
	private JLabel lblJugadorNacionalidad;

	/** El Label de la Fecha de Alta del Entrenador. */
	private JLabel lblJugadorFechaAlta;

	/** El Label del DNI del Entrenador. */
	private JLabel lblJugadorDNI;

	/** El Label del Escudo. */
	private JLabel lblFotoJugador;

	/** El Label de los Datos del DNI del Entrenador. */
	private JLabel lblJugadorDatosDNI;

	/** El Equipo Seleccionado de la Lista */
	private Jugador jugadorSeleccionado;

	/** El Label de los Datos del Nombre del Entrenador. */
	private JLabel lblJugadorDatosNombre;

	/** El Label de los Datos del Apellido del Entrenador. */
	private JLabel lblJugadorDatosApellido;

	/** El Label de los Datos de la Nacionalidad del Entrenador. */
	private JLabel lblJugadorDatosNacionalidad;

	/** El Label de los Datos del Dia de la Fecha del Alta del Entrenador. */
	private JLabel lblJugadorDatosFechaDia;

	/** El Label de los Datos del Mes de la Fecha del Alta del Entrenador. */
	private JLabel lblJugadorDatosFechaMes;

	/** El Label de los Datos del Año de la Fecha del Alta del Entrenador. */
	private JLabel lblJugadorDatosFechaAño;

	/** El Label de la Primera Barra de la Fecha de Alta del Entrenador. */
	private JLabel lblJugadorDatosFechaBarra1;

	/** El Label de la Segunda Barra de la Fecha de Alta del Entrenador. */
	private JLabel lblJugadorDatosFechaBarra2;
	private JButton btnCambiarImagen;
	
	private String Imagen = "";
	private JButton btnEditar;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarJugadorCOPIA frame = new MostrarJugadorCOPIA();
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
	public MostrarJugadorCOPIA() {
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
		btnVolver.setBackground(new Color(74,127,114));
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

		panelJugador = new JPanel();
		panelJugador.setLayout(null);
		panelJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelJugador.setBackground(Color.WHITE);
		panelJugador.setBounds(42, 169, 437, 54);
		contentPane.add(panelJugador);

		lblJugadorNombre = new JLabel("Nombre:");
		lblJugadorNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorNombre.setBounds(81, 10, 51, 13);
		panelJugador.add(lblJugadorNombre);

		lblJugadorApellido = new JLabel("Apellido:");
		lblJugadorApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorApellido.setBounds(156, 10, 51, 13);
		panelJugador.add(lblJugadorApellido);

		lblJugadorNacionalidad = new JLabel("Nacionalidad:");
		lblJugadorNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorNacionalidad.setBounds(226, 10, 68, 13);
		panelJugador.add(lblJugadorNacionalidad);

		lblJugadorFechaAlta = new JLabel("Fecha de Alta:");
		lblJugadorFechaAlta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorFechaAlta.setBounds(317, 10, 74, 13);
		panelJugador.add(lblJugadorFechaAlta);

		lblJugadorDNI = new JLabel("DNI:");
		lblJugadorDNI.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDNI.setBounds(10, 10, 30, 13);
		panelJugador.add(lblJugadorDNI);

		lblJugadorDatosDNI = new JLabel("...");
		lblJugadorDatosDNI.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDatosDNI.setBounds(10, 33, 68, 13);
		panelJugador.add(lblJugadorDatosDNI);


		lblFotoJugador = new JLabel("");
		lblFotoJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFotoJugador.setBounds(225, 53, 80, 74);
		contentPane.add(lblFotoJugador);

		lblJugadorDatosNombre = new JLabel((String) null);
		lblJugadorDatosNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDatosNombre.setBounds(81, 33, 68, 13);
		panelJugador.add(lblJugadorDatosNombre);

		lblJugadorDatosApellido = new JLabel((String) null);
		lblJugadorDatosApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDatosApellido.setBounds(156, 33, 68, 13);
		panelJugador.add(lblJugadorDatosApellido);

		lblJugadorDatosNacionalidad = new JLabel((String) null);
		lblJugadorDatosNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDatosNacionalidad.setBounds(226, 33, 81, 13);
		panelJugador.add(lblJugadorDatosNacionalidad);

		lblJugadorDatosFechaDia = new JLabel((String) null);
		lblJugadorDatosFechaDia.setBorder(null);
		lblJugadorDatosFechaDia.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDatosFechaDia.setBounds(317, 33, 24, 13);
		panelJugador.add(lblJugadorDatosFechaDia);

		lblJugadorDatosFechaMes = new JLabel((String) null);
		lblJugadorDatosFechaMes.setBorder(null);
		lblJugadorDatosFechaMes.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDatosFechaMes.setBounds(355, 33, 24, 13);
		panelJugador.add(lblJugadorDatosFechaMes);

		lblJugadorDatosFechaAño = new JLabel((String) null);
		lblJugadorDatosFechaAño.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDatosFechaAño.setBounds(391, 33, 38, 13);
		panelJugador.add(lblJugadorDatosFechaAño);

		lblJugadorDatosFechaBarra1 = new JLabel("/");
		lblJugadorDatosFechaBarra1.setBounds(341, 33, 14, 13);
		panelJugador.add(lblJugadorDatosFechaBarra1);
		lblJugadorDatosFechaBarra1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadorDatosFechaBarra1.setFont(new Font("Tahoma", Font.BOLD, 10));

		lblJugadorDatosFechaBarra2 = new JLabel("/");
		lblJugadorDatosFechaBarra2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadorDatosFechaBarra2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblJugadorDatosFechaBarra2.setBounds(377, 33, 14, 13);
		panelJugador.add(lblJugadorDatosFechaBarra2);
		
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
		} else if(e.getSource() == btnCambiarImagen) {
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
		//VisualizarJugador();
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
				JOptionPane.showMessageDialog(this, "Por favor, selecciona un archivo de imagen válido (jpg, jpeg o png).",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Almacenar la ruta del archivo seleccionado en la variable Escudo
			Imagen = selectedFile.getAbsolutePath();

			try {
				// Cargar la imagen en el JLabel
				ImageIcon imageIcon = new ImageIcon(Imagen);
				Image image = imageIcon.getImage().getScaledInstance(lblFotoJugador.getWidth(), lblFotoJugador.getHeight(),
						Image.SCALE_SMOOTH);
				lblFotoJugador.setIcon(new ImageIcon(image));

			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al cargar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				// Construir el nombre de archivo usando el nombre del equipo y su extensión
				extension = Imagen.substring(Imagen.lastIndexOf(".") + 1).toLowerCase();
				String destinationFileName = lblJugadorDatosDNI.getText() + "." + extension;

				// Construir la ruta de destino en la carpeta /ficheros/escudos
				String destinationPath = "ficheros/fotos/" + destinationFileName;

				// Copiar el archivo a la carpeta de destino
				Files.copy(new File(Imagen).toPath(), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
				
				Imagen = destinationPath;

			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al copiar el archivo de la foto.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}

	/**
	 * Funcion para Visualizar el Equipo Seleccionado.
	 */
	/*public void VisualizarJugador() {

		Fecha fechaAltaEntrenador = equipoSeleccionado.getEntrenador().getFechaAlta();

		lblNombreJugador.setText(equipoSeleccionado.getNombre());
		// Cargar y mostrar el escudo
		String escudoPath = equipoSeleccionado.getEscudo();
		if (escudoPath != null && !escudoPath.isEmpty()) {
			ImageIcon escudoIcon = new ImageIcon(escudoPath);
			Image escudoImage = escudoIcon.getImage().getScaledInstance(lblFotoJugador.getWidth(), lblFotoJugador.getHeight(),
					Image.SCALE_SMOOTH);
			lblFotoJugador.setIcon(new ImageIcon(escudoImage));
		} else {
			lblFotoJugador.setIcon(new ImageIcon("src/Imagenes/BOFlogo.png"));
		}
		lblJugadorDatosDNI.setText(equipoSeleccionado.getEntrenador().getDNI());
		lblJugadorDatosNombre.setText(equipoSeleccionado.getEntrenador().getNombre());
		lblJugadorDatosApellido.setText(equipoSeleccionado.getEntrenador().getApellido());
		lblJugadorDatosNacionalidad.setText(equipoSeleccionado.getEntrenador().getNacionalidad());
		lblJugadorDatosFechaDia.setText("" + equipoSeleccionado.getEntrenador().getFechaAlta().getDia());
		lblJugadorDatosFechaMes.setText("" + equipoSeleccionado.getEntrenador().getFechaAlta().getMes());
		lblJugadorDatosFechaAño.setText("" + equipoSeleccionado.getEntrenador().getFechaAlta().getAño());

		if (fechaAltaEntrenador.getDia() == 0) {
			lblJugadorDatosFechaDia.setText("1");
		}
		if (fechaAltaEntrenador.getMes() == 0) {
			lblJugadorDatosFechaMes.setText("1");
		}
		if (fechaAltaEntrenador.getAño() == 0) {
			lblJugadorDatosFechaAño.setText("2024");
		}

		// Limpiar el DefaultListModel antes de agregar nuevos jugadores
		jlm.clear();

		// Añadir los jugadores al DefaultListModel
		for (Jugador jugador : equipoSeleccionado.getListaJugadores()) {
			jlm.addElement(jugador);
		}
	}*/
}
