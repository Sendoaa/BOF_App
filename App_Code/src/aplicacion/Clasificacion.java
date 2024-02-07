package aplicacion;

//Eventos importados
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import definicion.Equipo;
import definicion.Estadisticas;
import definicion.Fecha;
import definicion.Horario;
import definicion.Jornada;
import definicion.Logger;
import definicion.Partido;
import definicion.Seleccion;
import definicion.Sesion;
import definicion.Temporada;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

/**
 * La Clase Clasificacion.
 */
public class Clasificacion extends JFrame implements ActionListener, WindowListener {

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

	/** La Tabla de Clasificacion. */
	private JTable tableClasificacion;

	/** El Modelo de la Tabla de Clasificacion. */
	private DefaultTableModel ctm;

	/** La Lista de Equipos de la Temporada. */
	private List<Equipo> ListaEquipos;

	/** El Boton de Exportar PDF. */
	private JButton btnExportarPDF;

	/** El Boton de Exportar XML. */
	private JButton btnExportarXML;

	/** La Lista de Movimientos Totales que hay Registrados. */
	private ArrayList<Logger> ListaMovimientos;

	/** La Lista de Jornadas de la Temporada. */
	private List<Jornada> ListaJornadas;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clasificacion frame = new Clasificacion();
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
	public Clasificacion() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		// Añado acción listener
		this.addWindowListener(this);
		// Eliminar posibilidad de reescalar la ventana
		setResizable(false);
		// Establece el título
		setTitle("Clasificacion");
		// Establece que hacer cuando se cierra la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Establece posición y tamaño
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
		btnClasificacion.setEnabled(false);
		btnClasificacion.addActionListener(this);
		btnClasificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClasificacion.setFocusable(false);
		btnClasificacion.setBackground(new Color(184, 207, 229));
		btnClasificacion.setBounds(0, 106, 158, 108);
		panelLateral.add(btnClasificacion);

		// Crea un botón
		btnJornadas = new JButton("Jornadas");
		btnJornadas.setFont(new Font("Dialog", Font.BOLD, 15));
		btnJornadas.setForeground(new Color(255, 255, 255));
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
		btnEquipos.addActionListener(this);
		btnEquipos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEquipos.setFocusable(false);
		btnEquipos.setBackground(new Color(20, 185, 255));
		btnEquipos.setBounds(0, 318, 158, 108);
		panelLateral.add(btnEquipos);

		// Crea un panel
		panelCentral = new JPanel();
		// Propiedades del panel
		panelCentral.setFocusable(false);
		panelCentral.setBounds(159, 91, 874, 432);
		contentPane.add(panelCentral);
		panelCentral.setLayout(null);

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
		tableClasificacion.setBounds(74, 55, 725, 251);
		// Asignar el modelo de tabla a la JTable
		tableClasificacion.setModel(ctm);
		panelCentral.add(tableClasificacion);

		btnExportarXML = new JButton("Exportar XML");
		btnExportarXML.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExportarXML.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExportarXML.addActionListener(this);
		btnExportarXML.setForeground(Color.WHITE);
		btnExportarXML.setFocusable(false);
		btnExportarXML.setBorder(null);
		btnExportarXML.setBackground(new Color(74, 127, 214));
		btnExportarXML.setBounds(545, 341, 113, 63);
		panelCentral.add(btnExportarXML);

		btnExportarPDF = new JButton("Exportar PDF");
		btnExportarPDF.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExportarPDF.addActionListener(this);
		btnExportarPDF.setForeground(Color.WHITE);
		btnExportarPDF.setFocusable(false);
		btnExportarPDF.setBorder(null);
		btnExportarPDF.setBackground(new Color(74, 127, 214));
		btnExportarPDF.setBounds(216, 341, 113, 63);
		panelCentral.add(btnExportarPDF);

		// Obtener la lista de equipos
		if (Seleccion.getTemporadaSeleccionada() != null) {
			lblTemporada.setText("Temporada " + Seleccion.getTemporadaNumero());
			ListaEquipos = Seleccion.getTemporadaSeleccionada().getListaEquipos();

			llenarTabla();
		}

		if (Seleccion.getTemporadaSeleccionada().getEstado().equals("FINALIZADA")) {
			btnEditarTemp.setVisible(false);
			btnPanel.setBounds(864, 22, 140, 45);
		}

		ListaMovimientos = Logger.cargarMovimientos();

		ListaJornadas = Seleccion.getTemporadaSeleccionada().getListaJornadas();

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
	// Acción para los objetos
	@Override
	public void actionPerformed(ActionEvent e) {
		// Condición para dirigirnos a la funcion que corresponda
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
		} else if (e.getSource() == btnExportarPDF) {
			toPDF();
		} else if (e.getSource() == btnExportarXML) {
			toXML();
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
	 * Funcion To PDF.
	 */
	private void toPDF() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new Printable() {
			@Override
			public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
				if (page > 0) {
					return Printable.NO_SUCH_PAGE;
				}

				Graphics2D g2d = (Graphics2D) g;
				g2d.translate(pf.getImageableX(), pf.getImageableY());

				// Ajustar el tamaño de la fuente según el ancho de la columna
				int fontSize = 8;
				g2d.setFont(new Font("Arial", Font.PLAIN, fontSize));

				int yOffset = 20; // Ajusta esto según la posición inicial del contenido

				// Ajustar el ancho de la columna
				int columnWidth = (int) (pf.getImageableWidth() / tableClasificacion.getColumnCount());

				for (int i = 0; i < tableClasificacion.getRowCount(); i++) {
					for (int j = 0; j < tableClasificacion.getColumnCount(); j++) {
						String cellValue = tableClasificacion.getValueAt(i, j).toString();

						// Ajustar la posición de cada celda utilizando drawString
						int stringWidth = g2d.getFontMetrics().stringWidth(cellValue);
						int x = j * columnWidth + (columnWidth - stringWidth) / 2;
						g2d.drawString(cellValue, x, yOffset);
					}

					// Ajustar el yOffset para la próxima fila
					yOffset += g2d.getFontMetrics().getHeight() + 5; // Ajusta esto según tus necesidades
				}

				return Printable.PAGE_EXISTS;
			}
		});

		if (job.printDialog()) {
			try {
				job.print();
				JOptionPane.showMessageDialog(this, "PDF exportado correctamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

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
						"Ha exportado en formato PDF la clasificacion de la Temporada "
								+ Seleccion.getTemporadaSeleccionada().getNumero() + ".",
						fechaActual, horaActual);

				ListaMovimientos.add(movimiento);
				Logger.guardarMovimientos(ListaMovimientos);
			} catch (PrinterException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al exportar a PDF", "Error", JOptionPane.ERROR_MESSAGE);
			}
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