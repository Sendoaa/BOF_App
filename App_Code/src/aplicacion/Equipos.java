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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import definicion.Equipo;
import definicion.Fecha;
import definicion.Horario;
import definicion.Logger;
import definicion.Seleccion;
import definicion.Sesion;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * La Clase Equipos.
 */
public class Equipos extends JFrame implements ActionListener, WindowListener {

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

	/** The lst equipos. */
	private JList<Equipo> lstEquipos;

	/** El Modelo de la Lista de Equipos de la Temporda. */
	private DefaultListModel<Equipo> elm;

	/** El Scroll Pane de la Lista de Equipos de la Temporada. */
	private JScrollPane scrollPane;

	/** La Lista de Equipos de la Temporada. */
	private List<Equipo> ListaEquipos;

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
					Equipos frame = new Equipos();
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
	public Equipos() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		// Añado acción listener
		this.addWindowListener(this);
		// Eliminar posibilidad de reescalar la ventana
		setResizable(false);
		// Establece el título
		setTitle("Equipos");
		// Establece que hacer cuando se cierra la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Establece posicion y tamaño
		setBounds(100, 100, 1050, 550);
		// Centrar la ventana en el centro de la pantalla
		setLocationRelativeTo(null);
		// Crea un panel
		contentPane = new JPanel();
		// Establece los bordes del panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Hacer el panel absoluto
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
		// Propiedades del botón
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
		// Propiedades del panel
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
		btnClasificacion.setForeground(new Color(255, 255, 255));
		btnClasificacion.setFont(new Font("Dialog", Font.BOLD, 15));
		// Propiedades del botón
		btnClasificacion.addActionListener(this);
		btnClasificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClasificacion.setFocusable(false);
		btnClasificacion.setBackground(new Color(20, 185, 255));
		btnClasificacion.setBounds(0, 106, 158, 108);
		panelLateral.add(btnClasificacion);

		// Crea un botón
		btnJornadas = new JButton("Jornadas");
		btnJornadas.setForeground(new Color(255, 255, 255));
		btnJornadas.setFont(new Font("Dialog", Font.BOLD, 15));
		// Propiedades del botón
		btnJornadas.addActionListener(this);
		btnJornadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJornadas.setFocusable(false);
		btnJornadas.setBackground(new Color(20, 185, 255));
		btnJornadas.setBounds(0, 213, 158, 108);
		panelLateral.add(btnJornadas);

		// Crea un botón
		btnEquipos = new JButton("Equipos");
		btnEquipos.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEquipos.setForeground(new Color(255, 255, 255));
		// Propiedades del botón
		btnEquipos.setEnabled(false);
		btnEquipos.addActionListener(this);
		btnEquipos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEquipos.setFocusable(false);
		btnEquipos.setBackground(new Color(184, 207, 229));
		btnEquipos.setBounds(0, 318, 158, 108);
		panelLateral.add(btnEquipos);

		// Crea un panel
		panelCentral = new JPanel();
		// Propiedades del panel
		panelCentral.setFocusable(false);
		panelCentral.setBounds(159, 91, 874, 432);
		contentPane.add(panelCentral);
		panelCentral.setLayout(null);

		elm = new DefaultListModel<Equipo>();

		lstEquipos = new JList<Equipo>();
		lstEquipos.setBackground(new Color(227, 227, 227));
		lstEquipos.setFont(new Font("Dialog", Font.BOLD, 20));
		lstEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEquipos.setBounds(131, 55, 612, 321);
		/* lstTemporada.addListSelectionListener(this); */
		// asocio el DefaultListModel a la lista
		lstEquipos.setModel(elm);
		panelCentral.add(lstEquipos);

		// Crear JScrollPane y agregar la lista a él
		scrollPane = new JScrollPane(lstEquipos);
		scrollPane.setBounds(131, 55, 612, 321);
		panelCentral.add(scrollPane);

		if (Seleccion.getTemporadaSeleccionada() != null) {
			lblTemporada.setText("Temporada " + Seleccion.getTemporadaNumero());

			ListaEquipos = Seleccion.getTemporadaSeleccionada().getListaEquipos();

			for (Equipo equipo : ListaEquipos) {
				if (!equipo.getNombre().equalsIgnoreCase("Equipo para Descansar")) {
					elm.addElement(equipo);
				}
			}
			lstEquipos.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						// Verificar si se ha seleccionado un equipo
						if (lstEquipos.getSelectedValue() != null) {
							// Ejecutar la función al seleccionar un equipo
							MostrarEquipo();
						}
					}
				}
			});
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
	 * Funcion para Mostrar el Equipo Seleccionado.
	 */
	private void MostrarEquipo() {
		// Creo las variables
		MostrarEquipo ME = new MostrarEquipo();
		int selectedIndex = lstEquipos.getSelectedIndex();
		// Muestro la ventana MostrarEquipo
		ME.EnviarEquipo(elm.getElementAt(selectedIndex));
		ME.setVisible(true);
		setEnabled(false);
		// Centrar la ventana en el centro de la pantalla
		ME.setLocationRelativeTo(null);

		ME.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if (ME != null) {
					ME.dispose();
				}
				// Habilitar la ventana de Equipos
				setEnabled(true);
				// Establece que la ventana se quede en primer plano
				requestFocus();
				lstEquipos.clearSelection();
			}
		});
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