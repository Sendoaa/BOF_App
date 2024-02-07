package definicion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * La Clase Usuario.
 */
public class Usuario implements Serializable {

	/** La Constante serialVersionUID generada para identificarse. */
	private static final long serialVersionUID = 1307437293073492995L;

	/** La Constante FILENAME que indica la ubicacion del fichero. */
	private static final String FILENAME = "ficheros/usuarios.ser";

	/** El Nombre. */
	private String Nombre;

	/** La Contraseña. */
	private String Contraseña;

	/** Si es Privilegiado. */
	private Boolean Privilegiado;

	/**
	 * Instancia para crear un nuevo Usuario por defecto.
	 */
	// Contrustor por defecto
	public Usuario() {
		this.Nombre = "";
		this.Contraseña = "";
		this.Privilegiado = false;
	}

	/**
	 * Instancia para crear un nuevo Usuario copia.
	 *
	 * @param u el Usuario
	 */
	// Contructor copia
	public Usuario(Usuario u) {
		this.Nombre = u.Nombre;
		this.Contraseña = u.Contraseña;
		this.Privilegiado = u.Privilegiado;
	}

	/**
	 * Instancia para crear un nuevo Usuario personalizado.
	 *
	 * @param n el Nombre
	 * @param c la Contraseña
	 * @param p si es Privilegiado
	 */
	// Contructor personalizado
	public Usuario(String n, String c, Boolean p) {
		this.Nombre = n;
		this.Contraseña = c;
		this.Privilegiado = p;
	}

	/**
	 * Instancia para crear un nuevo Usuario personalizado.
	 *
	 * @param n el Nombre
	 */
	// Contructor personalizado
	public Usuario(String n) {
		this.Nombre = n;
		this.Contraseña = "";
		this.Privilegiado = false;
	}

	/**
	 * Funcion To string.
	 *
	 * @return Informacion en formato String
	 */
	public String toString() {
		return ("Usuario: " + Nombre + " | Privilegiado: " + Privilegiado);
	}

	/**
	 * Obtener el Nombre.
	 *
	 * @return el Nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * Asignar el Nombre.
	 *
	 * @param nombre el nuevo Nombre
	 */
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	/**
	 * Obtener la Contraseña.
	 *
	 * @return la Contraseña
	 */
	public String getContraseña() {
		return Contraseña;
	}

	/**
	 * Asignar la Contraseña.
	 *
	 * @param contraseña la nueva Contraseña
	 */
	public void setContraseña(String contraseña) {
		this.Contraseña = contraseña;
	}

	/**
	 * Obtener si es Privilegiado.
	 *
	 * @return si es Privilegiado
	 */
	public Boolean getPrivilegiado() {
		return Privilegiado;
	}

	/**
	 * Asignar si es Privilegiado.
	 *
	 * @param privilegiado indica si es Privilegiado.
	 */
	public void setPrivilegiado(Boolean privilegiado) {
		this.Privilegiado = privilegiado;
	}

	/**
	 * Funcion Hash code.
	 *
	 * @return el hashCode de los Objetos a Comparar
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Nombre);
	}

	/**
	 * Funcion Equals.
	 *
	 * @param obj el Objeto a comparar
	 * @return true, si son Iguales
	 */
	// Compara los objetos de una clase
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			// Si son el mismo objeto
			return true;
		if (obj == null)
			// si el objeto no esta creado
			return false;
		if (getClass() != obj.getClass())
			// si son de distinta clase
			return false;
		// Comparo las propiedades
		Usuario other = (Usuario) obj;
		// Si tienen el mismo contenido devuelvo true
		return Objects.equals(this.Nombre, other.Nombre);
	}

	/**
	 * Funcion para Guardar usuarios en el fichero.
	 *
	 * @param usuarios la Lista de Usuarios
	 */
	// Guarda la lista de usuarios en un archivo
	public static void guardarUsuarios(ArrayList<Usuario> usuarios) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
			oos.writeObject(usuarios);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para Cargar usuarios desde fichero.
	 *
	 * @return el ArrayList de Usuarios
	 */
	// Carga la lista de usuarios desde un archivo
	@SuppressWarnings("unchecked")
	public static ArrayList<Usuario> cargarUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
			usuarios = (ArrayList<Usuario>) ois.readObject();
		} catch (FileNotFoundException e) {
			// El archivo no existe, se creará uno nuevo cuando sea necesario
		} catch (IOException | ClassNotFoundException e) {
			if (!usuarios.isEmpty()) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}

	/**
	 * Funcion para Obtener usuarios por defecto.
	 *
	 * @return el ArrayList de los Usuarios por defecto
	 */
	// Constructor para añadir usuarios por defecto
	public static ArrayList<Usuario> obtenerUsuariosPorDefecto() {
		ArrayList<Usuario> usuarios = cargarUsuarios();
		Usuario admin = new Usuario("admin", "admin", true);
		Usuario usuario = new Usuario("usuario", "usuario", false);

		if (!usuarios.contains(admin)) {
			// Añadir dos usuarios por defecto
			usuarios.add(admin);
		}
		if (!usuarios.contains(usuario)) {
			usuarios.add(usuario);
		}

		return usuarios;
	}
}
