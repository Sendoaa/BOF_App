package aplicacion;

//Eventos importados
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import definicion.Fecha;
import definicion.Horario;
import definicion.Logger;
import definicion.Usuario;
import javax.swing.JPasswordField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;

/**
 * La Clase Registro.
 */
public class Registro extends JFrame implements MouseListener, ActionListener, FocusListener {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1L;

	/** El Content Pane principal. */
	private JPanel contentPane;

	/** El TextField del Nombre del Usuario. */
	public JTextField txtRegistroUsuario;

	/** El PasswordField de la Contraseña 1 del Usuario. */
	public JPasswordField txtRegistroPassword;

	/** El PasswordField de la Contraseña 2 del Usuario. */
	public JPasswordField txtRegistroPassword2;

	/** El Label del Registrarse. */
	private JLabel lblRegistrarse;

	/** El Label del Nombre del Registro. */
	private JLabel lblRegistroNombre;

	/** El Label de la Contraseña 1 del Registro. */
	private JLabel lblRegistroContraseña;

	/** El Label del Emoticono 1. */
	private JLabel lblRegistroEmoticono;

	/** El Label de la Contraseña 2 del Registro. */
	private JLabel lblRepetirPassword;

	/** El Label del Emoticono 2. */
	private JLabel lblRegistroEmoticono2;

	/** El Label del Emoticono 3. */
	private JLabel lblRegistroEmoticono3;

	/** El Boton de Registrarse. */
	public JButton btnRegistrarse;

	/** El Label para Volver al Login. */
	private JLabel lblLogin;

	/** La Lista de Usuarios Totales que hay Registrados. */
	//private ArrayList<Usuario> listaUsuarios;

	/** La Lista de Movimientos Totales que hay Registrados. */
	private ArrayList<Logger> ListaMovimientos;

	/** El Boton para Ocultar o Mostrar la Contraseña 1. */
	private JToggleButton tglbtnShowHide;

	/** El Boton para Ocultar o Mostrar la Contraseña 2. */
	private JToggleButton tglbtnShowHide_2;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Se Crea el Frame.
	 */
	public Registro() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		// Mantener escala de la ventana fija
		setResizable(false);
		// Titulo de la ventana
		setTitle("Registrarse");
		// Salir al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Definir el tamaño y la ubicación de la ventana
		setBounds(200, 200, 550, 400);
		// Centrar la ventana en el centro de la pantalla
		setLocationRelativeTo(null);
		// Crea un nuevo panel
		contentPane = new JPanel();
		// Defino la fuente de el panel
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 9));
		// Defino los bordes de el panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Definir el panel como absoluto
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tglbtnShowHide = new JToggleButton("Show");
		tglbtnShowHide.setForeground(Color.WHITE);
		tglbtnShowHide.setFont(new Font("Dialog", Font.PLAIN, 13));
		tglbtnShowHide.setFocusable(false);
		tglbtnShowHide.setBorder(null);
		tglbtnShowHide.setBackground(new Color(0, 0, 0));
		tglbtnShowHide.setBounds(384, 189, 59, 30);
		contentPane.add(tglbtnShowHide);
		tglbtnShowHide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				// Cuando se deja clickado con el raton
				if (tglbtnShowHide.isSelected()) {
					// Se muestran los caracteres de la contraseña
					txtRegistroPassword.setEchoChar((char) 0);
					// Se cambia el texto del boton Show/Hide
					tglbtnShowHide.setText("Hide");
				}
				// Cuando no se deja clickado con el raton
				else {
					// Se ocultan los caracteres de la contraseña
					txtRegistroPassword.setEchoChar('•');
					// Se cambia el texto del boton Show/Hide
					tglbtnShowHide.setText("Show");
					// Cambio de color del fondo
					tglbtnShowHide.setBackground(new Color(0, 0, 0));
				}
			}
		});

		// Creo el label lblRegistrarse
		lblRegistrarse = new JLabel("REGISTRARSE");
		// Alineo horizontalmente
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		// Defino la fuente
		lblRegistrarse.setFont(new Font("Dialog", Font.BOLD, 40));
		// Defino posición y tamaño
		lblRegistrarse.setBounds(121, 33, 294, 55);
		contentPane.add(lblRegistrarse);

		// Creo el label lblRegistroNombre
		lblRegistroNombre = new JLabel("Nombre de usuario");
		lblRegistroNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		// Defino posición y tamaño
		lblRegistroNombre.setBounds(97, 101, 158, 13);
		contentPane.add(lblRegistroNombre);

		// Creo el label lblRegistroContraseña
		lblRegistroContraseña = new JLabel("Contraseña");
		lblRegistroContraseña.setFont(new Font("Dialog", Font.BOLD, 12));
		// Defino posición y tamaño
		lblRegistroContraseña.setBounds(97, 166, 106, 13);
		contentPane.add(lblRegistroContraseña);

		// Creo el textField txtRegistroUsuario
		txtRegistroUsuario = new JTextField();
		// Defino la fuente
		txtRegistroUsuario.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtRegistroUsuario.addFocusListener(this);
		txtRegistroUsuario.setColumns(10);
		txtRegistroUsuario.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		txtRegistroUsuario.setBackground(Color.WHITE);
		txtRegistroUsuario.setBounds(93, 124, 350, 30);
		txtRegistroUsuario.addActionListener(this);
		contentPane.add(txtRegistroUsuario);

		// Creo el label RegistroEmoticono
		lblRegistroEmoticono = new JLabel("👤");
		lblRegistroEmoticono.setFont(new Font("Dialog", Font.PLAIN, 20));
		// Defino posición y tamaño
		lblRegistroEmoticono.setBounds(70, 124, 40, 32);
		contentPane.add(lblRegistroEmoticono);

		// Creo el passwordField txtRegistroPassword
		txtRegistroPassword = new JPasswordField();
		// Defino la fuente
		txtRegistroPassword.setFont(new Font("Dialog", Font.PLAIN, 18));
		// Defino el carácter que se mostrará
		txtRegistroPassword.setEchoChar('•');
		txtRegistroPassword.addFocusListener(this);
		txtRegistroPassword.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		txtRegistroPassword.setBounds(93, 189, 291, 30);
		txtRegistroPassword.addActionListener(this);
		contentPane.add(txtRegistroPassword);

		// Creo el label RepetirPassword
		lblRepetirPassword = new JLabel("Repetir Contraseña");
		lblRepetirPassword.setFont(new Font("Dialog", Font.BOLD, 12));
		// Defino posición y tamaño
		lblRepetirPassword.setBounds(97, 229, 139, 13);
		contentPane.add(lblRepetirPassword);

		// Creo el passwordField RegistroPassword2
		txtRegistroPassword2 = new JPasswordField();
		// Defino la fuente
		txtRegistroPassword2.setFont(new Font("Dialog", Font.PLAIN, 18));
		// Defino el carácter que se mostrará
		txtRegistroPassword2.setEchoChar('•');
		txtRegistroPassword2.addFocusListener(this);
		txtRegistroPassword2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		// Defino posición y tamaño
		txtRegistroPassword2.setBounds(93, 252, 291, 30);
		txtRegistroPassword2.addActionListener(this);
		contentPane.add(txtRegistroPassword2);

		// Creo el label lblRegistroEmoticono2 y le asigno el carácter
		lblRegistroEmoticono2 = new JLabel("🔒");
		lblRegistroEmoticono2.setFont(new Font("Dialog", Font.PLAIN, 20));
		// Defino posición y tamaño
		lblRegistroEmoticono2.setBounds(70, 192, 35, 22);
		contentPane.add(lblRegistroEmoticono2);

		// Creo el label RegistroEmoticono3 y le asigno el carácter
		lblRegistroEmoticono3 = new JLabel("🔒");
		lblRegistroEmoticono3.setFont(new Font("Dialog", Font.PLAIN, 20));
		// Defino posición y tamaño
		lblRegistroEmoticono3.setBounds(70, 252, 35, 23);
		contentPane.add(lblRegistroEmoticono3);

		// Creo el botón de registro
		btnRegistrarse = new JButton("Registrarse");
		// Defino los atributos para el botón de registro
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.setBorder(null);
		btnRegistrarse.setBackground(Color.BLACK);
		btnRegistrarse.setBounds(195, 288, 145, 42);
		btnRegistrarse.addActionListener(this);
		contentPane.add(btnRegistrarse);

		// Creo el label lblVolverLogin
		lblLogin = new JLabel("Volver al login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 9));
		lblLogin.addMouseListener(this);
		// Defino los atributos para el botón
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(212, 335, 111, 13);
		contentPane.add(lblLogin);

		tglbtnShowHide_2 = new JToggleButton("Show");
		tglbtnShowHide_2.setForeground(Color.WHITE);
		tglbtnShowHide_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		tglbtnShowHide_2.setFocusable(false);
		tglbtnShowHide_2.setBorder(null);
		tglbtnShowHide_2.setBackground(Color.BLACK);
		tglbtnShowHide_2.setBounds(384, 252, 59, 30);
		contentPane.add(tglbtnShowHide_2);
		tglbtnShowHide_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				// Cuando se deja clickado con el raton
				if (tglbtnShowHide_2.isSelected()) {
					// Se muestran los caracteres de la contraseña
					txtRegistroPassword2.setEchoChar((char) 0);
					// Se cambia el texto del boton Show/Hide
					tglbtnShowHide_2.setText("Hide");
				}
				// Cuando no se deja clickado con el raton
				else {
					// Se ocultan los caracteres de la contraseña
					txtRegistroPassword2.setEchoChar('•');
					// Se cambia el texto del boton Show/Hide
					tglbtnShowHide_2.setText("Show");
					// Cambio de color del fondo
					tglbtnShowHide_2.setBackground(new Color(0, 0, 0));
				}
			}
		});

		//listaUsuarios = Usuario.cargarUsuarios();
		ListaMovimientos = Logger.cargarMovimientos();
	}

	/**
	 * Funcion para cuando se Clicka con el Cursor.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Creo las variables
		Login L = new Login();
		// Muestro la ventana Registro
		L.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		L.setLocationRelativeTo(null);
		// Cierro la ventana Login
		dispose();
	}

	/**
	 * Funcion para cuando se Presiona con el Cursor.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	}

	/**
	 * Funcion para cuando se Selecciona con el Cursor.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

	/**
	 * Funcion para cuando el Cursor está por encima.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// Cuando el cursor pasa por encima
		// Cambio de color del fondo
		lblLogin.setForeground(Color.gray);
	}

	/**
	 * Funcion para cuando el Cursor ya no está por encima.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// Cuando el cursor ya no está por encima
		// Cambio el color de fondo
		lblLogin.setForeground(new Color(0, 0, 0));
	}

	/**
	 * Funcion Action performed.
	 *
	 * @param ae el Evento Accionado
	 */
	public void actionPerformed(ActionEvent ae) {
		// Se crea la varible que guarda que estas seleccionando
		Object o = ae.getSource();
		// creamos la variable que cuenta el número de errores

		// Si presionas enter seleccionando el elemento de nombre
		if (o == this.txtRegistroUsuario || o == this.txtRegistroPassword) {
			// Se mueve al siguiente elemento
			KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
		}
		// Si presionas el boton de Login o presionas enter seleccionando el elemento de
		// contraseña
		else if (o == btnRegistrarse || o == this.txtRegistroPassword2) {
			String nombreUsuario = txtRegistroUsuario.getText();
			String contraseña = new String(txtRegistroPassword.getPassword());
			String contraseña2 = new String(txtRegistroPassword2.getPassword());

			// Si Algo esta vacio
			if (nombreUsuario.isEmpty() || contraseña.isEmpty() || contraseña2.isEmpty()) {
				// Cambio de color del fondo del Nombre
				this.txtRegistroUsuario.setBackground(new Color(255, 192, 183));
				// Cambio de color del fondo de la Contraseña
				this.txtRegistroPassword.setBackground(new Color(255, 192, 183));
				// Cambio de color del fondo de la Contraseña
				this.txtRegistroPassword2.setBackground(new Color(255, 192, 183));
				// Mostramos error por pantalla
				JOptionPane.showMessageDialog(null, "Por favor, introduzca datos en todos los campos", "Campos Vacios",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/reto26.odb");
			EntityManager em = emf.createEntityManager();

			TypedQuery<Usuario> q1 = em.createQuery("SELECT u FROM Usuario u WHERE u.Nombre = :nombreUsuario",
					Usuario.class);
			q1.setParameter("nombreUsuario", nombreUsuario);
			List<Usuario> usuarios = q1.getResultList();

			// Si el nombre de usuario ya está en uso
			if (!usuarios.isEmpty()) {
				this.txtRegistroUsuario.setBackground(new Color(255, 192, 183));
				this.txtRegistroPassword.setBackground(new Color(255, 192, 183));
				this.txtRegistroPassword2.setBackground(new Color(255, 192, 183));
				JOptionPane.showMessageDialog(this, "El nombre de usuario ya está en uso", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Si las contraseñas no coinciden
			if (!contraseña.equals(contraseña2)) {
				this.txtRegistroUsuario.setBackground(Color.WHITE);
				this.txtRegistroPassword.setBackground(new Color(255, 192, 183));
				this.txtRegistroPassword2.setBackground(new Color(255, 192, 183));
				JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Creas un nuevo Usuario con los datos ingresados
			Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña, false);

			// Agregas el nuevo usuario a la base de datos
			em.getTransaction().begin();
			em.persist(nuevoUsuario);
			em.getTransaction().commit();

			JOptionPane.showMessageDialog(this, "Se ha registrado tu usuario con éxito", "Usuario Registrado",
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
			Usuario desconocido = new Usuario("");

			Logger movimiento = new Logger(desconocido, "Se ha creado el Usuario " + nuevoUsuario.getNombre() + ".",
					fechaActual, horaActual);

			ListaMovimientos.add(movimiento);
			Logger.guardarMovimientos(ListaMovimientos);

			// Creo las variables
			Login L = new Login();
			// Muestro la ventana Inicio
			L.setVisible(true);
			// Centrar la ventana en el centro de la pantalla
			L.setLocationRelativeTo(null);
			// Cierro la ventana Registro
			dispose();

			em.close();
			emf.close();
		}
	}

	/**
	 * Funcion FocusEvent lo que Ocurre cuando se Gana el Focus.
	 *
	 * @param fe el Evento Accionado
	 */
	// Se aplica a los objetos que estas seleccionando
	public void focusGained(FocusEvent fe) {
		// Se crea la varible que guarda que estas seleccionando
		Object o = fe.getSource();
		// Se cambia el color y tamaño del borde
		((JComponent) o).setBorder(new LineBorder(new Color(135, 206, 235), 2));
	}

	/**
	 * Funcion FocusEvent lo que Ocurre cuando se Pierde el Focus.
	 *
	 * @param fe el Evento Accionado
	 */
	// Se aplica a los objetos que no estas seleccionando
	public void focusLost(FocusEvent fe) {
		// Se crea la varible que guarda que estas seleccionando
		Object o = fe.getSource();
		// Se cambia el color y tamaño del borde
		((JComponent) o).setBorder(new LineBorder(new Color(255, 255, 255), 2));
	}
}