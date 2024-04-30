package aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import definicion.Equipo;
import definicion.EquipoSeleccion;
import definicion.Fecha;
import definicion.Horario;
import definicion.Logger;
import definicion.Sesion;
import definicion.Temporada;
import definicion.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;

/**
 * La Clase Panel.
 */
public class Panel extends JFrame implements ActionListener, ListSelectionListener {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1L;

	/** El Content Pane principal. */
	private JPanel contentPane;

	/** El Boton de Volver. */
	private JButton btnVolver;

	/** El Label de Movimientos Totales que hay Registrados. */
	private JLabel lblListaMovimientos;

	/** El Label de Usuarios Totales que hay Registrados. */
	private JLabel lblListaUsuarios;

	/** El Label de la Lista de Equipos Registrados. */
	private JLabel lblListaEquipos;

	/** La Lista de Movimientos Totales que hay Registrados. */
	private JList<Logger> lstMovimientos;

	/** La Lista de Usuarios Totales que hay Registrados. */
	private JList<Usuario> lstUsuarios;

	/** La Lista de Equipos Totales que hay Registrados. */
	private JList<Equipo> lstEquipos;

	/** El Modelo de la Lista de Movimientos. */
	private DefaultListModel<Logger> mlm;

	/** El Modelo de la Lista de Usuarios. */
	private DefaultListModel<Usuario> ulm;

	/** El Modelo de la Lista de Equipos. */
	private DefaultListModel<Equipo> elm;

	/** El Scroll Pane de la Lista de Movimientos. */
	private JScrollPane scrollPane;

	/** El Scroll Pane de la Lista de Usuarios. */
	private JScrollPane scrollPane2;

	/** El Scroll Pane de la Lista de Equipos. */
	private JScrollPane scrollPane3;

	/** El Panel de Usuarios. */
	private JPanel panelUsuarios;

	/** El Panel de Equipos. */
	private JPanel panelEquipos;

	/** El Boton de Editar Permisos. */
	private JButton btnEditarPermisos;

	/** El Boton de Eliminar Usuarios. */
	private JButton btnUsuariosEliminar;

	/** El Boton de Crear Equipos. */
	private JButton btnEquiposCrear;

	/** El Boton de Eliminar Equipos. */
	private JButton btnEquiposEliminar;

	/** El Boton de Editar Equipos. */
	private JButton btnEditarEquipos;

	/** La Lista de Movimientos Totales que hay Registrados. */
	private ArrayList<Logger> ListaMovimientos;

	/** La Lista de Usuarios Totales que hay Registrados. */
	//private ArrayList<Usuario> ListaUsuarios;

	/** La Lista de Equipos Totales que hay Registrados. */
	private ArrayList<Equipo> ListaEquipos;

	/** La Lista de Temporadas Totales que hay Registradas. */
	private ArrayList<Temporada> ListaTemporadas;

	/** Si algun Equipo ha sido Editado */
	//Boolean modificado = false;

	/**
	 * Ejecuta la aplicacion.
	 *
	 * @param args los Argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
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
	public Panel() {
		// Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		setTitle("Panel Administración");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 730);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(74, 127, 214));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVolver.setFocusable(false);
		btnVolver.setBounds(166, 640, 85, 40);
		contentPane.add(btnVolver);

		lblListaMovimientos = new JLabel("Lista de Movimientos:");
		lblListaMovimientos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblListaMovimientos.setBounds(60, 23, 200, 33);
		contentPane.add(lblListaMovimientos);

		lblListaUsuarios = new JLabel("Lista de Usuarios:");
		lblListaUsuarios.setFont(new Font("Dialog", Font.BOLD, 18));
		lblListaUsuarios.setBounds(60, 220, 200, 33);
		contentPane.add(lblListaUsuarios);

		mlm = new DefaultListModel<Logger>();

		lstMovimientos = new JList<Logger>();
		lstMovimientos.setFont(new Font("Dialog", Font.BOLD, 12));
		lstMovimientos.setEnabled(false);
		lstMovimientos.setBounds(60, 65, 315, 145);
		// asocio el DefaultListModel a la lista
		lstMovimientos.setModel(mlm);
		contentPane.add(lstMovimientos);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPane = new JScrollPane(lstMovimientos);
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(60, 65, 315, 145);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPane);

		ulm = new DefaultListModel<Usuario>();

		lstUsuarios = new JList<Usuario>();
		lstUsuarios.setFont(new Font("Dialog", Font.BOLD, 12));
		lstUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstUsuarios.setBounds(60, 325, 315, 93);
		// asocio el DefaultListModel a la lista
		lstUsuarios.setModel(ulm);
		contentPane.add(lstUsuarios);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPane2 = new JScrollPane(lstUsuarios);
		scrollPane2.setBorder(null);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setBounds(60, 325, 315, 93);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPane2);

		panelUsuarios = new JPanel();
		panelUsuarios.setLayout(null);
		panelUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuarios.setBackground(Color.WHITE);
		panelUsuarios.setBounds(60, 263, 315, 62);
		contentPane.add(panelUsuarios);

		btnEditarPermisos = new JButton("Editar permisos");
		btnEditarPermisos.setBackground(new Color(230, 230, 230));
		btnEditarPermisos.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEditarPermisos.setFocusable(false);
		btnEditarPermisos.addActionListener(this);
		btnEditarPermisos.setBounds(33, 10, 130, 40);
		panelUsuarios.add(btnEditarPermisos);

		btnUsuariosEliminar = new JButton("Eliminar");
		btnUsuariosEliminar.setBackground(new Color(230, 230, 230));
		btnUsuariosEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUsuariosEliminar.setFocusable(false);
		btnUsuariosEliminar.addActionListener(this);
		btnUsuariosEliminar.setBounds(196, 10, 86, 40);
		panelUsuarios.add(btnUsuariosEliminar);

		elm = new DefaultListModel<Equipo>();

		lstEquipos = new JList<Equipo>();
		lstEquipos.setFont(new Font("Dialog", Font.BOLD, 12));
		lstEquipos.addListSelectionListener(this);
		lstEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEquipos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstEquipos.setBounds(60, 533, 315, 93);
		// asocio el DefaultListModel a la lista
		lstEquipos.setModel(elm);
		contentPane.add(lstEquipos);

		// Crea un JScrollPane y envuelve el lstJugadores con él
		scrollPane3 = new JScrollPane(lstEquipos);
		scrollPane3.setBorder(null);
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setBounds(60, 533, 315, 93);
		// Añade el JScrollPane al contenido en lugar del JTextArea directamente
		contentPane.add(scrollPane3);

		panelEquipos = new JPanel();
		panelEquipos.setLayout(null);
		panelEquipos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEquipos.setBackground(Color.WHITE);
		panelEquipos.setBounds(60, 471, 315, 62);
		contentPane.add(panelEquipos);

		btnEquiposCrear = new JButton("Crear");
		btnEquiposCrear.setBackground(new Color(230, 230, 230));
		btnEquiposCrear.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEquiposCrear.setFocusable(false);
		btnEquiposCrear.addActionListener(this);
		btnEquiposCrear.setBounds(10, 10, 86, 40);
		panelEquipos.add(btnEquiposCrear);

		btnEquiposEliminar = new JButton("Eliminar");
		btnEquiposEliminar.setBackground(new Color(230, 230, 230));
		btnEquiposEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEquiposEliminar.setFocusable(false);
		btnEquiposEliminar.addActionListener(this);
		btnEquiposEliminar.setBounds(219, 10, 86, 40);
		panelEquipos.add(btnEquiposEliminar);

		btnEditarEquipos = new JButton("Editar");
		btnEditarEquipos.setBackground(new Color(230, 230, 230));
		btnEditarEquipos.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEditarEquipos.setFocusable(false);
		btnEditarEquipos.addActionListener(this);
		btnEditarEquipos.setBounds(114, 10, 86, 40);
		panelEquipos.add(btnEditarEquipos);

		lblListaEquipos = new JLabel("Equipos Registrados:");
		lblListaEquipos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblListaEquipos.setBounds(60, 428, 200, 33);
		contentPane.add(lblListaEquipos);

		ListaMovimientos = Logger.cargarMovimientos();
		//ListaUsuarios = Usuario.cargarUsuarios();
		ListaEquipos = Equipo.cargarEquipos();
		ListaTemporadas = Temporada.cargarTemporadas();

		for (Logger movimiento : ListaMovimientos) {
			mlm.addElement(movimiento);
		}

		// Crear el EntityManagerFactory y EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/reto26.odb");
		EntityManager em = emf.createEntityManager();

		// Realizar la consulta para obtener todos los usuarios
		TypedQuery<Usuario> q1 = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		List<Usuario> usuarios = q1.getResultList();

		// Añadir cada usuario a la lista
		for (Usuario usuario : usuarios) {
			ulm.addElement(usuario);
		}

		// Cerrar el EntityManager y EntityManagerFactory
		em.close();
		emf.close();
		/*
		 * for (Usuario usuario : ListaUsuarios) { ulm.addElement(usuario); }
		 */

		try {
			// Crear una conexión a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto26", "root", "");
			// Crear un objeto Statement para enviar consultas SQL a la base de datos
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// Ejecutar una consulta SQL para obtener todos los equipos
			ResultSet rs = st.executeQuery("SELECT * FROM equipo");

			// Limpiar el modelo de la lista
			elm.clear();

			// Recorrer el conjunto de resultados y añadir cada equipo al modelo de la lista
			while (rs.next()) {
				String nombreEquipo = rs.getString("nombreEq");
				if (!nombreEquipo.equalsIgnoreCase("Equipo para Descansar")) {
					Equipo equipo = new Equipo(); // Asume que tienes un constructor predeterminado o algún método para
															// establecer el nombre
					equipo.setNombre(nombreEquipo); // Asume que tienes un método setNombre
					elm.addElement(equipo);
				}
			}

			// Cerrar la conexión
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * for (Equipo equipo : ListaEquipos) { if
		 * (!equipo.getNombre().equalsIgnoreCase("Equipo para Descansar")) {
		 * elm.addElement(equipo); }
		 */
	}

	// EquipoSeleccion.setGuardado(false);

	/**
	 * Funcion Action performed.
	 *
	 * @param e el Evento Accionado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			dispose();
		} else if (e.getSource() == btnEditarPermisos) {
			EditarPermisos();
		} else if (e.getSource() == btnUsuariosEliminar) {
			EliminarUsuario();
		} else if (e.getSource() == btnEquiposCrear) {
			CrearEquipo();
		} else if (e.getSource() == btnEquiposEliminar) {
			EliminarEquipo();
		} else if (e.getSource() == btnEditarEquipos) {
			EditarEquipo();
		}
	}

	/**
	 * Funcion par Editar Permisos de Usuarios.
	 */
	private void EditarPermisos() {
		// Obtengo el índice del elemento seleccionado
		int indiceSeleccionado = lstUsuarios.getSelectedIndex();

		// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {
			// Verifico si el usuario que se quiere eliminar es el que esta logeado
			if (Sesion.getUsuarioActual().equals(ulm.elementAt(indiceSeleccionado))) {
				// Si es el que esta logeado NO se actualiza
				JOptionPane.showMessageDialog(this, "No se puede actualizar el usuario con el que estás logeado",
						"Usuario acivo", JOptionPane.ERROR_MESSAGE);
			} else {
				// Crear el EntityManagerFactory y EntityManager
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/reto26.odb");
				EntityManager em = emf.createEntityManager();

				// Obtengo el usuario correspondiente al índice
				Usuario usuario = ulm.elementAt(indiceSeleccionado);

				// Cambio el estado de la variable Privilegiado
				boolean nuevoPrivilegio = !usuario.getPrivilegiado();

				// Actualizo el usuario en la base de datos
				em.getTransaction().begin();
				Query q = em.createQuery(
						"UPDATE Usuario u SET u.Privilegiado = :nuevoPrivilegio WHERE u.Nombre = :nombreUsuario");
				q.setParameter("nuevoPrivilegio", nuevoPrivilegio);
				q.setParameter("nombreUsuario", usuario.getNombre());
				q.executeUpdate();
				em.getTransaction().commit();

				// Actualizo el usuario en el DefaultListModel
				usuario.setPrivilegiado(nuevoPrivilegio);
				ulm.setElementAt(usuario, indiceSeleccionado);

				// Muestro un mensaje para confirmar que se han editado los permisos
				// correctamente
				String mensaje = usuario.getNombre() + " - Permisos editados correctamente. Nuevo estado: "
						+ usuario.getPrivilegiado();
				JOptionPane.showMessageDialog(this, mensaje, "Edición de permisos exitosa",
						JOptionPane.INFORMATION_MESSAGE);

				// Cerrar el EntityManager y EntityManagerFactory
				em.close();
				emf.close();
			}
		} else {
			// Si no hay ningún elemento seleccionado
			JOptionPane.showMessageDialog(this, "No hay ningún usuario seleccionado", "Ningún usuario seleccionado",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Funcion para Eliminar un usuario
	 */
	private void EliminarUsuario() {
// Obtengo el índice del elemento seleccionado
		int indiceSeleccionado = lstUsuarios.getSelectedIndex();

// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {
			if (ulm.getElementAt(indiceSeleccionado).getNombre().equals("usuario")
					|| ulm.getElementAt(indiceSeleccionado).getNombre().equals("admin")) {
				JOptionPane.showMessageDialog(this,
						"No se puede eliminar este Usuario debido a que esta por defecto en el sistema",
						"Error de Eliminación", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// Preguntamos al usuario si está seguro de eliminar el usuario
			int opcion = JOptionPane.showConfirmDialog(this, "Estas seguro de que quieres eliminar el usuario?",
					"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (opcion == JOptionPane.YES_OPTION) {

				// Verifico si el usuario que se quiere eliminar es el que esta logeado
				if (Sesion.getUsuarioActual().equals(ulm.elementAt(indiceSeleccionado))) {
					// Si es el que esta logeado NO se elimina
					JOptionPane.showMessageDialog(this, "No se puede eliminar el usuario con el que estás logeado",
							"Usuario acivo", JOptionPane.ERROR_MESSAGE);
				} else {
					// Si NO es el que está logeado SI se elimina
					// Crear el EntityManagerFactory y EntityManager
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/reto26.odb");
					EntityManager em = emf.createEntityManager();

					// Obtengo el usuario correspondiente al índice
					Usuario usuario = ulm.elementAt(indiceSeleccionado);

					// Elimino el usuario seleccionado del DefaultListModel
					ulm.removeElementAt(indiceSeleccionado);

					// Elimino el usuario de la base de datos
					em.getTransaction().begin();
					Query q = em.createQuery("DELETE FROM Usuario u WHERE u.Nombre = :nombreUsuario");
					q.setParameter("nombreUsuario", usuario.getNombre());
					q.executeUpdate();
					em.getTransaction().commit();

					// Muestro un mensaje para confirmar que el usuario se ha eliminado
					// correctamente
					JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente", "Eliminación de usuario exitosa",
							JOptionPane.INFORMATION_MESSAGE);

					// Cerrar el EntityManager y EntityManagerFactory
					em.close();
					emf.close();
				}
			}
		} else {
			// Si no hay ningún elemento seleccionado
			JOptionPane.showMessageDialog(this, "No hay nigún usuario seleccionado", "Ningún usuario seleccionado",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Funcion para Crear un Equipo.
	 */
	private void CrearEquipo() {
		// Creo las variables
		AñadirEquipo AE = new AñadirEquipo();
		AE.setVentanaPanel(this);

		AE.setAbiertoPanel();
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

				mlm.clear();

				for (Logger movimientos : ListaMovimientos) {
					mlm.addElement(movimientos);
				}
			}
		});
		// Muestro la ventana Registro
		AE.setVisible(true);
		// Centrar la ventana en el centro de la pantalla
		AE.setLocationRelativeTo(null);

	}

	/**
	 * Funcion para Editar un Equipo.
	 */
	private void EditarEquipo() {
		// Obtengo las posiciones de los elementos seleccionados
		int indiceSeleccionado = lstEquipos.getSelectedIndex();

		// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {

			JOptionPane.showMessageDialog(this,
					"Los cambios realizados en el equipo no se aplicaran en las temporadas pertenecientes", "Aviso Edicion",
					JOptionPane.INFORMATION_MESSAGE);

			// Creo las variables
			EquipoSeleccion.setEquipoSeleccionado(elm.elementAt(indiceSeleccionado));

			elm.removeElementAt(indiceSeleccionado);
			ListaEquipos.remove(EquipoSeleccion.getEquipoSeleccionado());
			Equipo.guardarEquipos(ListaEquipos);

			EditarEquipo EE = new EditarEquipo();
			EE.setVentanaPanelEditar(this);

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

					elm.add(EquipoSeleccion.getEquipoPosicion(), EquipoSeleccion.getEquipoSeleccionado());
					lstEquipos.clearSelection();
					ListaEquipos.add(EquipoSeleccion.getEquipoPosicion(), EquipoSeleccion.getEquipoSeleccionado());
					Equipo.guardarEquipos(ListaEquipos);

					ListaMovimientos = Logger.cargarMovimientos();

					mlm.clear();

					for (Logger movimientos : ListaMovimientos) {
						mlm.addElement(movimientos);
					}
				}
			});
			// Muestro la ventana Registro
			EE.setVisible(true);
			// Centrar la ventana en el centro de la pantalla
			EE.setLocationRelativeTo(null);

			//modificado = true;

		} else {
			// No hay ningún elemento seleccionado
			mostrarError("Error, ningún elemento seleccionado en la lista");
		}
	}

	/**
	 * Funcion para Eliminar un Equipo.
	 */
	private void EliminarEquipo() {
		// Obtengo el índice del elemento seleccionado
		int indiceSeleccionado = lstEquipos.getSelectedIndex();

		// Compruebo si hay algún elemento seleccionado
		if (indiceSeleccionado != -1) {
			// Preguntamos al usuario si está seguro de eliminar el equipo
			int opcion = JOptionPane.showConfirmDialog(this, "Estas seguro de que quieres eliminar el equipo?",
					"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (opcion == JOptionPane.YES_OPTION) {

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
				Usuario usuariocreado = Sesion.getUsuarioActual();

				Logger movimiento = new Logger(usuariocreado,
						"Ha eliminado el Equipo " + elm.elementAt(indiceSeleccionado).getNombre() + ".", fechaActual,
						horaActual);

				ListaMovimientos.add(movimiento);
				Logger.guardarMovimientos(ListaMovimientos);

				mlm.clear();

				for (Logger movimientos : ListaMovimientos) {
					mlm.addElement(movimientos);
				}

				ListaEquipos = Equipo.cargarEquipos();

				boolean PerteneceTemporada = false;
				for (Temporada temporada : ListaTemporadas) {
					if (temporada.getListaEquipos().contains(elm.getElementAt(indiceSeleccionado))) {
						PerteneceTemporada = true;
						break;
					}
				}
				// Si el equipo no pertenece a ninguna temporada, eliminamos el escudo
				if (!PerteneceTemporada) {
					String rutaEscudo = elm.getElementAt(indiceSeleccionado).getEscudo();
					if (rutaEscudo != null && !rutaEscudo.isEmpty()) {
						File archivoEscudo = new File(rutaEscudo);
						if (archivoEscudo.exists()) {
							boolean eliminado = archivoEscudo.delete();
							if (!eliminado) {
								JOptionPane.showMessageDialog(this, "No se pudo eliminar el archivo del escudo del equipo",
										"Error al eliminar escudo", JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(this, "El archivo del escudo no existe", "Escudo no encontrado",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this, "La ruta del escudo es inválida", "Ruta de escudo inválida",
								JOptionPane.WARNING_MESSAGE);
					}
					// Eliminamos el escudo desde la ruta predeterminada
					String nombreEquipo = elm.getElementAt(indiceSeleccionado).getNombre();
					String extension = obtenerExtension(elm.getElementAt(indiceSeleccionado).getEscudo());
					File escudoPredeterminado = new File("ficheros/escudos/" + nombreEquipo + extension);
					if (escudoPredeterminado.exists()) {
						boolean eliminado = escudoPredeterminado.delete();
						if (!eliminado) {
							JOptionPane.showMessageDialog(this, "No se pudo eliminar el archivo del escudo del equipo",
									"Error al eliminar escudo", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this, "El archivo del escudo no existe", "Escudo no encontrado",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				// Elimino el usuario seleccionado del DefaultListModel y de la lista original
				elm.removeElementAt(indiceSeleccionado);
				ListaEquipos.remove(indiceSeleccionado);

				// Guardo la lista actualizada en el archivo
				Equipo.guardarEquipos(ListaEquipos);

				// Muestro un mensaje para confirmar que el equipo se ha eliminado correctamente
				JOptionPane.showMessageDialog(this, "Equipo eliminado correctamente", "Eliminacion de equipo exitosa",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			// Si no hay ningún elemento seleccionado
			JOptionPane.showMessageDialog(this, "No hay ningún equipo seleccionado", "Ningun equipo seleccionado",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para obtener la extensión del archivo de imagen del escudo
	 *
	 * @param fileName el Escudo
	 */
	private String obtenerExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
			return fileName.substring(dotIndex);
		}
		return ""; // Si no se encuentra extensión o no está presente en el nombre del archivo
	}

	/**
	 * Funcion para Añadir un Equipo a la Lista de Equipos Registrados.
	 *
	 * @param nuevoEquipo el Nuevo Equipo
	 */
	public void añadirEquipo(Equipo nuevoEquipo) {
		// TODO Auto-generated method stub
		elm.addElement(nuevoEquipo);
		ListaEquipos.add(nuevoEquipo);
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
	 * Funcion que Guarda los cambios de Seleccion de las Listas de Equipos.
	 *
	 * @param e el Evento de Seleccion de la Lista
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int selectedIndex = lstEquipos.getSelectedIndex();

		if (selectedIndex != -1) {

			EquipoSeleccion.setEquipoPosicion(selectedIndex);
		}
	}

}