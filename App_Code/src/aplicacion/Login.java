package aplicacion;

//Eventos importados
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.Color;

import definicion.Fecha;
import definicion.Horario;
import definicion.Logger;
import definicion.Sesion;
import definicion.Usuario;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;

import java.awt.Cursor;

/**
 * La Clase Login.
 */
public class Login extends JFrame implements MouseListener, ActionListener, FocusListener {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1L;

	/** El Content Pane principal. */
	private JPanel contentPane;

	/** El Label del Login. */
	private JLabel lblLogin;

	/** El Label del Nombre del Login. */
	private JLabel lblLoginNombre;

	/** El Label de la Contraseña del Login. */
	private JLabel lblLoginContraseña;

	/** El TextField del Nombre del Usuario. */
	public JTextField txtLoginUsuario;

	/** El TextField de la Contraseña del Usuario. */
	public JPasswordField txtLoginPassword;

	/** El ToggleButton para Mostrar la Contraseña. */
	private JToggleButton tglbtnShowHide;

	/** El Label del Registro. */
	private JLabel lblLoginRegistrar;

	/** El Label del Emoticono 1. */
	private JLabel lblLoginEmoticono;

	/** El Label del Emoticono 2. */
	private JLabel lblLoginEmoticono2;

	/** El Boton de Login. */
	public JButton btnLogin;

	/** La Lista de Usuarios Totales que hay Registrados. */
	public ArrayList<Usuario> listaUsuarios;

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
					/* UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); */
					Login frame = new Login();
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
	public Login() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		// Mantener escala de la ventana fija
		setResizable(false);
		// Título de la ventana
		setTitle("Login");
		// Salir al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Definir el tamaño y la ubicación de la ventana
		setBounds(200, 200, 550, 400);
		// Centrar la ventana en el centro de la pantalla
		setLocationRelativeTo(null);
		// Crea un nuevo panel
		contentPane = new JPanel();
		// Define los bordes de el panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Hacer que el panel sea absoluto
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Creo el label de login
		lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		// Defino la fuente de lblLogin
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 40));
		// Ubicación del label
		lblLogin.setBounds(182, 33, 171, 55);
		// Añade el label al panel
		contentPane.add(lblLogin);

		// Creo el label de Nombre de usuario
		lblLoginNombre = new JLabel("Nombre de usuario:");
		lblLoginNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		// Ubicacion del label
		lblLoginNombre.setBounds(97, 111, 158, 13);
		contentPane.add(lblLoginNombre);

		// Creo el label de Contraseña
		lblLoginContraseña = new JLabel("Contraseña:");
		lblLoginContraseña.setFont(new Font("Dialog", Font.BOLD, 15));
		// Ubicacion del label
		lblLoginContraseña.setBounds(97, 196, 106, 13);
		contentPane.add(lblLoginContraseña);

		// Creo el campo de texto de Nombre de usuario
		txtLoginUsuario = new JTextField();
		// Defino los atributos del campo de texto
		txtLoginUsuario.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtLoginUsuario.setColumns(10);
		txtLoginUsuario.setBorder(new LineBorder(Color.WHITE, 2));
		txtLoginUsuario.setBackground(Color.WHITE);
		txtLoginUsuario.setBounds(93, 134, 350, 30);
		txtLoginUsuario.addFocusListener(this);
		txtLoginUsuario.addActionListener(this);
		contentPane.add(txtLoginUsuario);

		// Creo el campo de texto de Contraseña
		txtLoginPassword = new JPasswordField();
		// Defino los atributos del campo de Contraseña
		txtLoginPassword.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtLoginPassword.setEchoChar('•');
		txtLoginPassword.setBorder(new LineBorder(Color.WHITE, 2));
		txtLoginPassword.setBounds(93, 219, 291, 30);
		txtLoginPassword.addFocusListener(this);
		txtLoginPassword.addActionListener(this);
		contentPane.add(txtLoginPassword);

		// Boton de Show/Hide
		tglbtnShowHide = new JToggleButton("Show");
		// Cambio del cursor a la mano cuando esta encima del elemento
		tglbtnShowHide.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// Quitar el focus
		tglbtnShowHide.setFocusable(false);
		// Color de la letra
		tglbtnShowHide.setForeground(new Color(255, 255, 255));
		// Eliminacion del borde
		tglbtnShowHide.setBorder(null);
		// Cambio de color del fondo
		tglbtnShowHide.setBackground(new Color(0, 0, 0));
		// Acciones con el raton
		tglbtnShowHide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				// Cuando se deja clickado con el raton
				if (tglbtnShowHide.isSelected()) {
					// Se muestran los caracteres de la contraseña
					txtLoginPassword.setEchoChar((char) 0);
					// Se cambia el texto del boton Show/Hide
					tglbtnShowHide.setText("Hide");
				}
				// Cuando no se deja clickado con el raton
				else {
					// Se ocultan los caracteres de la contraseña
					txtLoginPassword.setEchoChar('•');
					// Se cambia el texto del boton Show/Hide
					tglbtnShowHide.setText("Show");
					// Cambio de color del fondo
					tglbtnShowHide.setBackground(new Color(0, 0, 0));
				}
			}
		});
		// Cambio de la fuente y tamaño de la letra
		tglbtnShowHide.setFont(new Font("Dialog", Font.PLAIN, 13));
		// Tamaño y ubicacion del Elemento
		tglbtnShowHide.setBounds(384, 219, 59, 30);
		// Añadido al Panel contentPane
		contentPane.add(tglbtnShowHide);

		// Creo el JLabel Emoticono para el nombre de usuario
		lblLoginEmoticono = new JLabel("👤");
		lblLoginEmoticono.setFont(new Font("Dialog", Font.PLAIN, 20));
		// Defino atributos del JLabel Emoticono
		lblLoginEmoticono.setBounds(68, 135, 20, 27);
		contentPane.add(lblLoginEmoticono);

		// Creo el JLabel Emoticono2 para la contraseña
		lblLoginEmoticono2 = new JLabel("🔒");
		lblLoginEmoticono2.setFont(new Font("Dialog", Font.PLAIN, 20));
		// Defino los atributos del JLabel Emoticono2
		lblLoginEmoticono2.setBounds(68, 220, 20, 27);
		contentPane.add(lblLoginEmoticono2);

		// Creo el botón de Login
		btnLogin = new JButton("Login");
		// Defino los atributos para el botón Login
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnLogin.setFocusable(false);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(Color.BLACK);
		// Acciones Listener añadidas
		btnLogin.addActionListener(this);
		btnLogin.setBorder(null);
		btnLogin.setBounds(195, 276, 145, 42);
		contentPane.add(btnLogin);

		// Creo el JLabel Registrarse
		lblLoginRegistrar = new JLabel("Registrarse");
		// Añado el mouselistener
		lblLoginRegistrar.addMouseListener(this);
		// Defino los atributos para el JLabel Registrarse
		lblLoginRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLoginRegistrar.setFont(new Font("Dialog", Font.BOLD, 12));
		lblLoginRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginRegistrar.setBounds(225, 328, 86, 13);
		contentPane.add(lblLoginRegistrar);

		listaUsuarios = Usuario.obtenerUsuariosPorDefecto();
		Usuario.guardarUsuarios(listaUsuarios);

		ListaMovimientos = Logger.cargarMovimientos();

	}

	/**
	 * Funcion para cuando se Clicka con el Cursor.
	 *
	 * @param e el Evento Accionado
	 */
	public void mouseClicked(MouseEvent e) {
		// Creo las variables
		Registro R = new Registro();
		// Muestro la ventana Registro
		R.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		R.setLocationRelativeTo(null);
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
		lblLoginRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	}

	/**
	 * Funcion para cuando se Selecciona con el Cursor.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		lblLoginRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Funcion para cuando el Cursor está por encima.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// Cambio de color del fondo
		lblLoginRegistrar.setForeground(Color.gray);

	}

	/**
	 * Funcion para cuando el Cursor ya no está por encima.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// Cambio el color de fondo
		lblLoginRegistrar.setForeground(new Color(0, 0, 0));
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
		if (o == this.txtLoginUsuario) {
			// Se mueve al siguiente elemento
			KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
		}
		// Si presionas el boton de Login o presionas enter seleccionando el elemento de
		// contraseña
		else if (o == btnLogin || o == this.txtLoginPassword) {
			String nombreUsuario = txtLoginUsuario.getText();
			String contraseña = new String(txtLoginPassword.getPassword());

			// Si hay campos vacios
			if ((nombreUsuario.isEmpty() || contraseña.isEmpty())) {
				// Cambio de color del fondo del Nombre
				this.txtLoginUsuario.setBackground(new Color(255, 192, 183));
				// Cambio de color del fondo de la Contraseña
				this.txtLoginPassword.setBackground(new Color(255, 192, 183));
				// Mostramos mensaje de error
				JOptionPane.showMessageDialog(null, "Por favor, introduzca datos en todos los campos", "Campos Vacios",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Bucle que recorre la lista de Usuarios para comprobar creedenciales
			for (Usuario usuario : listaUsuarios) {
				// Si el nombre esta registrado pero no coincide la contraseña
				if (usuario.getNombre().equals(nombreUsuario) && !usuario.getContraseña().equals(contraseña)) {
					// Cambio de color del fondo del Nombre
					this.txtLoginUsuario.setBackground(Color.WHITE);
					// Cambio de color del fondo de la Contraseña
					this.txtLoginPassword.setBackground(new Color(255, 192, 183));
					JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Error de autenticación",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// Si el nombre y la contraseña estan registrados
				else if (usuario.getNombre().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
					// Usuario autenticado

					Calendar calendar = Calendar.getInstance();
					int año = calendar.get(Calendar.YEAR);
					int mes = calendar.get(Calendar.MONTH) + 1; // Nota: los meses comienzan desde 0
					int dia = calendar.get(Calendar.DAY_OF_MONTH);
					int hora = calendar.get(Calendar.HOUR_OF_DAY);
					int minuto = calendar.get(Calendar.MINUTE);

					// Crear el formato de fecha y hora
					Fecha fechaActual = new Fecha(dia, mes, año);
					Horario horaActual = new Horario(hora, minuto);

					Logger movimiento = new Logger(usuario, "Ha iniciado sesión.", fechaActual, horaActual);

					ListaMovimientos.add(movimiento);
					Logger.guardarMovimientos(ListaMovimientos);

					// Creo las variables
					Inicio I = new Inicio();
					// Muestro la ventana Inicio
					I.setVisible(true);
					// Centrar la ventana en el centro de la pantalla
					I.setLocationRelativeTo(null);
					// Se guarda el usuario con el que se ha iniciado sesion
					Sesion.setUsuarioActual(usuario);

					// Cierro la ventana Login
					dispose();
					return;
				}
			}
			// Usuario no encontrado
			// Cambio de color del fondo del Nombre
			this.txtLoginUsuario.setBackground(new Color(255, 192, 183));
			// Cambio de color del fondo de la Contraseña
			this.txtLoginPassword.setBackground(new Color(255, 192, 183));
			JOptionPane.showMessageDialog(this, "Usuario no registrado", "Error de autenticación",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Funcion FocusEvent lo que Ocurre cuando se Gana el Focus.
	 *
	 * @param fe el Evento Accionado
	 */
	// Se aplica a los objetos que estas seleccionando
	public void focusGained(FocusEvent fe) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method
		// Se crea la varible que guarda que estas seleccionando
		Object o = fe.getSource();
		// Se cambia el color y tamaño del borde
		((JComponent) o).setBorder(new LineBorder(new Color(255,255,255), 2));
	}
}