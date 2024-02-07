package aplicacion;

//Eventos importados
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import definicion.Equipo;
import definicion.EquipoSeleccion;
import definicion.Fecha;
import definicion.Horario;
import definicion.Logger;
import definicion.Seleccion;
import definicion.Sesion;
import definicion.Temporada;
import definicion.Usuario;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

/**
 * La Clase Inicio.
 */
public class Inicio extends JFrame implements ActionListener, WindowListener, ListSelectionListener {

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

	/** El Boton de Añadir Temporada. */
	private JButton btnAñadirTemp;

	/** El Boton de Eliminar Temporada. */
	private JButton btnEliminarTemp;

	/** La Lista de Temporadas. */
	private JList<Temporada> lstTemporada;

	/** El Modelo de la Lista de Tempordas. */
	private DefaultListModel<Temporada> tlm;

	/** El Scroll Pane de la Lista de Temporadas. */
	private JScrollPane scrollPane;

	/** La Lista de Temporadas Totales que hay Registradas. */
	private ArrayList<Temporada> ListaTemporadas;

	/** La Lista de Movimientos Totales que hay Registrados. */
	private ArrayList<Logger> ListaMovimientos;

	/** La Lista de Equipos Totales que hay Registrados. */
	private ArrayList<Equipo> ListaEquipos;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());

		// Añado acción listener
		this.addWindowListener(this);
		// Eliminar posibilidad de reescalar la ventana
		setResizable(false);
		// Establece el título
		setTitle("Inicio ");
		// Establece que hacer cuando se cierra la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Establece posicion y tamaño
		setBounds(100, 100, 1050, 550);
		// Centrar la ventana en el centro de la pantalla
		setLocationRelativeTo(null);
		// Se crea el panel para insertar los elementos
		contentPane = new JPanel();
		// Establece los bordes del panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Hace el panel absoluto
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Crea un panel
		panelSuperior = new JPanel();
		// Establece el color de fondo
		panelSuperior.setBackground(new Color(74, 127, 214));
		// Establece posicion y tamaño
		panelSuperior.setBounds(0, 0, 1036, 90);
		// Hace el panel absoluto
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(null);

		// Crea un botón
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 12));
		// Añade accion de tipo listener
		btnCerrarSesion.addActionListener(this);
		// Establece el color de fondo del botón
		btnCerrarSesion.setBackground(new Color(230, 230, 230));
		btnCerrarSesion.setForeground(new Color(12, 12, 12));
		// Establece que el botón no se puede tabular
		btnCerrarSesion.setFocusable(false);
		// Establece el tipo de cursor
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// Establece los bordes
		btnCerrarSesion.setBorder(null);
		// Establece posicion y tamaño
		btnCerrarSesion.setBounds(22, 22, 119, 45);
		// Añade el botón al panel
		panelSuperior.add(btnCerrarSesion);

		// Crea un botón
		btnPanel = new JButton("Panel Administracion");
		btnPanel.setFont(new Font("Dialog", Font.BOLD, 12));
		// Añade accion de tipo listener al boton
		btnPanel.addActionListener(this);
		// Propiedades del boton
		btnPanel.setBackground(new Color(230, 230, 230));
		btnPanel.setForeground(new Color(12, 12, 12));
		btnPanel.setBorder(null);
		btnPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPanel.setFocusable(false);
		btnPanel.setBounds(684, 22, 140, 45);
		panelSuperior.add(btnPanel);

		// Crea un botón
		btnEditarTemp = new JButton("Editar Temporada");
		btnEditarTemp.setFont(new Font("Dialog", Font.BOLD, 13));
		// Añade accion de tipo listener al boton
		btnEditarTemp.addActionListener(this);
		// Propiedades del boton
		btnEditarTemp.setBackground(new Color(20, 185, 255));
		btnEditarTemp.setForeground(Color.WHITE);
		btnEditarTemp.setBorder(null);
		btnEditarTemp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarTemp.setFocusable(false);
		btnEditarTemp.setBounds(848, 22, 156, 45);
		panelSuperior.add(btnEditarTemp);

		// Crea un label
		lblTemporada = new JLabel("Seleccionar Temporada");
		lblTemporada.setForeground(Color.WHITE);
		// Establece el tipo de orientacion horizontal
		lblTemporada.setHorizontalAlignment(SwingConstants.CENTER);
		// Establece la fuente
		lblTemporada.setFont(new Font("Dialog", Font.BOLD, 25));
		// Establece posicion y tamaño
		lblTemporada.setBounds(303, 22, 429, 45);
		// Añade el label al panel
		panelSuperior.add(lblTemporada);

		// Crea un panel
		panelLateral = new JPanel();
		// Propiedades de panel
		panelLateral.setBackground(new Color(128, 255, 255));
		panelLateral.setBounds(0, 88, 158, 435);
		contentPane.add(panelLateral);
		panelLateral.setLayout(null);

		// Crea un botón
		btnTemporadas = new JButton("Temporadas");
		btnTemporadas.setFont(new Font("Dialog", Font.BOLD, 15));
		btnTemporadas.setEnabled(false);
		btnTemporadas.setForeground(Color.WHITE);
		// Añade accion de tipo listener al botón
		btnTemporadas.addActionListener(this);
		btnTemporadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTemporadas.setFocusable(false);
		btnTemporadas.setBackground(new Color(184, 207, 229));
		btnTemporadas.setBounds(0, 0, 158, 108);
		panelLateral.add(btnTemporadas);

		// Crea un botón
		btnClasificacion = new JButton("Clasificación");
		btnClasificacion.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClasificacion.setForeground(Color.WHITE);
		// Añade accion de tipo listener al botón
		btnClasificacion.addActionListener(this);
		// Propiedades del botón
		btnClasificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClasificacion.setFocusable(false);
		btnClasificacion.setBackground(new Color(20, 185, 255));
		btnClasificacion.setBounds(0, 106, 158, 108);
		panelLateral.add(btnClasificacion);

		// Crea un botón
		btnJornadas = new JButton("Jornadas");
		btnJornadas.setFont(new Font("Dialog", Font.BOLD, 15));
		btnJornadas.setForeground(Color.WHITE);
		// Añade accion de tipo listener al botón
		btnJornadas.addActionListener(this);
		// Propiedades del botón
		btnJornadas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJornadas.setFocusable(false);
		btnJornadas.setBackground(new Color(20, 185, 255));
		btnJornadas.setBounds(0, 213, 158, 108);
		panelLateral.add(btnJornadas);

		// Crea un botón
		btnEquipos = new JButton("Equipos");
		btnEquipos.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEquipos.setForeground(Color.WHITE);
		// Añade accion de tipo listener al botón
		btnEquipos.addActionListener(this);
		// Propiedades del botón
		btnEquipos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEquipos.setFocusable(false);
		btnEquipos.setBackground(new Color(20, 185, 255));
		btnEquipos.setBounds(0, 318, 158, 108);
		panelLateral.add(btnEquipos);

		panelCentral = new JPanel();
		panelCentral.setFocusable(false);
		panelCentral.setBounds(159, 91, 874, 432);
		panelCentral.setBackground(new Color(240, 240, 240));
		contentPane.add(panelCentral);
		panelCentral.setLayout(null);

		btnAñadirTemp = new JButton("Añadir temporada");
		btnAñadirTemp.setForeground(new Color(255, 255, 255));
		btnAñadirTemp.setFocusable(false);
		btnAñadirTemp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadirTemp.setBorder(null);
		btnAñadirTemp.setBackground(new Color(74, 127, 214));
		btnAñadirTemp.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAñadirTemp.addActionListener(this);
		btnAñadirTemp.setBounds(204, 348, 186, 46);
		panelCentral.add(btnAñadirTemp);

		btnEliminarTemp = new JButton("Eliminar temporada");
		btnEliminarTemp.setFocusable(false);
		btnEliminarTemp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarTemp.setBorder(null);
		btnEliminarTemp.setForeground(new Color(255, 255, 255));
		btnEliminarTemp.setBackground(new Color(74, 127, 214));
		btnEliminarTemp.setFont(new Font("Dialog", Font.BOLD, 13));
		btnEliminarTemp.addActionListener(this);
		btnEliminarTemp.setBounds(464, 348, 186, 46);
		panelCentral.add(btnEliminarTemp);

		tlm = new DefaultListModel<Temporada>();

		lstTemporada = new JList<Temporada>();
		lstTemporada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Creo las variables
				Clasificacion C = new Clasificacion();
				// Muestro la ventana Registro
				C.setVisible(true);
				// Centrar la ventana en el centro de la pantalla
				C.setLocationRelativeTo(null);
				// Cierro la ventana Login
				dispose();
			}
		});
		lstTemporada.setBackground(new Color(240, 240, 240));
		lstTemporada.setFont(new Font("Dialog", Font.BOLD, 18));
		lstTemporada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstTemporada.setBounds(123, 49, 628, 262);
		lstTemporada.addListSelectionListener(this);
		// asocio el DefaultListModel a la lista
		lstTemporada.setModel(tlm);
		panelCentral.add(lstTemporada);

		// Crear JScrollPane y agregar la lista a él
		scrollPane = new JScrollPane(lstTemporada);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBounds(123, 49, 628, 262);
		panelCentral.add(scrollPane);

		// Después de cargar las temporadas desde el archivo
		ListaTemporadas = Temporada.cargarTemporadas();

		ordenarTemporadas();

		if (Seleccion.getTemporadaSeleccionada() == null && !tlm.isEmpty()
				&& tlm.firstElement().getEstado().equals("ACTIVA")) {
			Seleccion.setTemporadaSeleccionada(tlm.firstElement());
			Seleccion.setTemporadaPosicion(tlm.indexOf(tlm.firstElement()));
			Seleccion.setTemporadaNumero(tlm.firstElement().getNumero());
			lstTemporada.setSelectedIndex(tlm.indexOf(tlm.firstElement()));
		}

		if (Seleccion.getTemporadaSeleccionada() != null
				&& Seleccion.getTemporadaSeleccionada().getEstado().equals("FINALIZADA")) {
			btnEditarTemp.setVisible(false);
			btnPanel.setBounds(864, 22, 140, 45);
		}

		if (Seleccion.getTemporadaPosicion() != null) {
			lstTemporada.setSelectedIndex(Seleccion.getTemporadaPosicion());
		}
		ListaMovimientos = Logger.cargarMovimientos();
		ListaEquipos = Equipo.cargarEquipos();

		EquipoSeleccion.setGuardado(false);
	}

	/**
	 * Funcion Action performed.
	 *
	 * @param e el Evento Accionado
	 */
	// Acción para los objetos
	@Override
	public void actionPerformed(ActionEvent e) {
		// Condicion para dirigirnos a la funcion que corresponda
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
		} else if (e.getSource() == btnAñadirTemp) {
			AñadirTemporada();
		} else if (e.getSource() == btnEliminarTemp) {
			EliminarTemporada();
		}
	}

	/**
	 * Funcion para Añadir Temporada.
	 */
	private void AñadirTemporada() {
		// Creo las variables
		AñadirTemporada AT = new AñadirTemporada();
		AT.setVentanaInicio(this);
		// Muestro la ventana Temporadas
		AT.setVisible(true);
		// Desabilito la Ventana de Inicio
		setEnabled(false);
		// Centrar la ventana en el centro de la pantalla
		AT.setLocationRelativeTo(null);

		AT.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if (AT != null) {
					AT.dispose();
				}
				// Habilitar la ventana de inicio
				setEnabled(true);
				// Establece que la ventana se quede en primer plano
				requestFocus();

				ListaTemporadas = Temporada.cargarTemporadas();
				ordenarTemporadas();

				if (Seleccion.getTemporadaSeleccionada() == null && !tlm.isEmpty()
						&& tlm.firstElement().getEstado().equals("ACTIVA")) {
					Seleccion.setTemporadaSeleccionada(tlm.firstElement());
					Seleccion.setTemporadaPosicion(tlm.indexOf(tlm.firstElement()));
					Seleccion.setTemporadaNumero(tlm.firstElement().getNumero());
					lstTemporada.setSelectedIndex(tlm.indexOf(tlm.firstElement()));
				}

				if (Seleccion.getTemporadaPosicion() != null) {
					lstTemporada.setSelectedIndex(Seleccion.getTemporadaPosicion());
				}
				repaint();
			}
		});
	}

	/**
	 * Funcion para Eliminar Temporada.
	 */
	private void EliminarTemporada() {
		// Obtengo el índice del elemento seleccionado
		int indiceSeleccionado = lstTemporada.getSelectedIndex();

		// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {
			// Preguntamos al usuario si está seguro de eliminar la temporada
			int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar la temporada?",
					"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

			if (opcion == JOptionPane.YES_OPTION) {

				ListaMovimientos = Logger.cargarMovimientos();

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
						"Ha eliminado la Temporada " + Seleccion.getTemporadaSeleccionada().getNumero() + ".", fechaActual,
						horaActual);

				ListaMovimientos.add(movimiento);
				Logger.guardarMovimientos(ListaMovimientos);

				ListaTemporadas = Temporada.cargarTemporadas();

				// Verifico si la temporada eliminada es la activa
				if (ListaTemporadas.get(indiceSeleccionado).getEstado().equals("ACTIVA")) {
					// Borra las estadísticas por temporada de los equipos
					for (Equipo equipo : Seleccion.getTemporadaSeleccionada().getListaEquipos()) {
						ListaEquipos.remove(equipo);
						equipo.getEstadisticasPorTemporada().clear();
						ListaEquipos.add(equipo);
					}
					Equipo.guardarEquipos(ListaEquipos);

					// Elimino la temporada seleccionada del DefaultListModel y de la lista original
					tlm.removeElementAt(indiceSeleccionado);
					ListaTemporadas.remove(indiceSeleccionado);

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
							String temporadaSeleccionada = comboBox.getSelectedItem().toString();
							int numeroTemporada = Integer.parseInt(temporadaSeleccionada.replaceAll("[\\D]", ""));
							for (Temporada temporada : ListaTemporadas) {
								if (temporada.getNumero() == numeroTemporada) {
									temporada.setEstado("ACTIVA");
									break;
								}
							}
						}
					}

				} else {
					// Elimino la temporada seleccionada del DefaultListModel y de la lista original
					tlm.removeElementAt(indiceSeleccionado);
					ListaTemporadas.remove(indiceSeleccionado);
				}

				Seleccion.setTemporadaPosicion(null);
				Seleccion.setTemporadaSeleccionada(null);
				lblTemporada.setText("Seleccionar Temporada");

				// Guardo la lista actualizada en el archivo
				Temporada.guardarTemporadas(ListaTemporadas);
				ordenarTemporadas();

				if (Seleccion.getTemporadaSeleccionada() == null && !tlm.isEmpty()
						&& tlm.firstElement().getEstado().equals("ACTIVA")) {
					Seleccion.setTemporadaSeleccionada(tlm.firstElement());
					Seleccion.setTemporadaPosicion(tlm.indexOf(tlm.firstElement()));
					Seleccion.setTemporadaNumero(tlm.firstElement().getNumero());
					lstTemporada.setSelectedIndex(tlm.indexOf(tlm.firstElement()));
				}
			}

		} else {
			// No hay ningún elemento seleccionado
			JOptionPane.showMessageDialog(this, "No hay ningún elemento seleccionado", "Acción Errónea",
					JOptionPane.ERROR_MESSAGE);
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
		if (Seleccion.getTemporadaSeleccionada() == null) {
			JOptionPane.showMessageDialog(this, "No hay ninguna temporada seleccionada", "Temporada Errónea",
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
		// Pregunta al usuario si quiere cerrar sesión
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
		if (Seleccion.getTemporadaSeleccionada() == null) {
			JOptionPane.showMessageDialog(this, "No hay ninguna temporada seleccionada", "Temporada Errónea",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
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
		if (Seleccion.getTemporadaSeleccionada() == null) {
			JOptionPane.showMessageDialog(this, "No hay ninguna temporada seleccionada", "Temporada Errónea",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
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
		if (Seleccion.getTemporadaSeleccionada() == null) {
			JOptionPane.showMessageDialog(this, "No hay ninguna temporada seleccionada", "Temporada Errónea",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
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
	 * Funcion para que se Añada una Temporada a Lista.
	 *
	 * @param nuevaTemporada la Nueva Temporada
	 */
	public void añadirTemporada(Temporada nuevaTemporada) {
		// TODO Auto-generated method stub
		tlm.addElement(nuevaTemporada);
	}

	/**
	 * Funcion que Guarda los cambios de Seleccion de las Listas de Temporadas.
	 *
	 * @param e el Evento de Seleccion de la Lista
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Obtener el índice seleccionado en la lista activa
		int selectedIndex = lstTemporada.getSelectedIndex();

		if (selectedIndex != -1) {
			// Obtener el Alumno seleccionado
			Temporada selectedTemporada = tlm.getElementAt(selectedIndex);

			// Se llama a los elementos de la clase Fecha
			lblTemporada.setText("Temporada " + selectedTemporada.getNumero());

			// Se guarda el usuario con el que se ha iniciado sesion
			Seleccion.setTemporadaPosicion((selectedIndex));
			Seleccion.setTemporadaNumero(tlm.getElementAt(selectedIndex).getNumero());
			Seleccion.setTemporadaSeleccionada(tlm.getElementAt(selectedIndex));

			if (Seleccion.getTemporadaSeleccionada().getEstado().equals("FINALIZADA")) {
				btnEditarTemp.setVisible(false);
				btnPanel.setBounds(864, 22, 140, 45);
			} else {
				btnEditarTemp.setVisible(true);
				btnPanel.setBounds(684, 22, 140, 45);
			}
		}
	}

	/**
	 * Funcion para Ordenar las Temporadas de la Lista.
	 */
	public void ordenarTemporadas() {
		Collections.sort(ListaTemporadas, new Comparator<Temporada>() {

			@Override
			public int compare(Temporada t1, Temporada t2) {
				// Comparar por estado
				int estadoComparison = t1.getEstado().compareTo(t2.getEstado());
				if (estadoComparison != 0) {
					return estadoComparison;
				}

				// Si tienen el mismo estado, comparar por nombre
				return t1.getEstado().compareTo(t2.getEstado());
			}
		});

		// Limpiar el DefaultListModel antes de agregar las temporadas ordenadas
		tlm.clear();

		// Agregar las temporadas ordenadas al DefaultListModel
		for (Temporada temporada : ListaTemporadas) {
			tlm.addElement(temporada);
		}
		Temporada.guardarTemporadas(ListaTemporadas);
	}

	/**
	 * Funcion para la Apertura de la Ventana.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// Si el usuario actual NO es un usuario con
		if (Sesion.getUsuarioActual() != null) {
			if (!Sesion.getUsuarioActual().getPrivilegiado()) {
				// Oculta el botón de logs
				btnPanel.setVisible(false);
				// Oculta el botón de editar temporada
				btnEditarTemp.setVisible(false);
				// Oculta el botón de logs
				btnAñadirTemp.setVisible(false);
				// Oculta el botón de editar temporada
				btnEliminarTemp.setVisible(false);
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