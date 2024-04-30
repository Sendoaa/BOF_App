package test_junit;

//Importaciones
import org.junit.jupiter.api.Test;
import aplicacion.Login;
import definicion.Sesion;
import definicion.Usuario;
import junit.framework.TestCase;

class LoginTest extends TestCase {
	
	//Prueba el caso de login con un usuario existente
	@Test
   public void testLoginUsuarioExistente() {
		 //Crear una instancia de la clase Login
       Login login = new Login();

       //Establecer un usuario y una contraseña
       String testUsername = "testUserOkay";
       String testPassword = "testPassword";

       //Cea un usuario de prueba y lo añade a la lista de usuarios de la clase login
       Usuario testUser = new Usuario(testUsername, testPassword, false);
       login.listaUsuarios.add(testUser);

       //Establecer un usuario de prueba con credenciales correctas
       login.txtLoginUsuario.setText(testUsername);
       login.txtLoginPassword.setText(testPassword);

       //Simular un clic en el botón de inicio de sesión para activar el proceso de inicio de sesión
       login.btnLogin.doClick();

       //Obtener el usuario actual después del inicio de sesión
       Usuario loggedInUser = Sesion.getUsuarioActual();

       //Verificar que el inicio de sesión fue exitoso
       assertNotNull(loggedInUser);
       assertEquals(testUser, loggedInUser);
   }
	
	//Prueba el caso de login con un usuario inexistente
	@Test
   public void testLoginUsuarioInexistente() {
       // Crear una instancia de la clase Login
       Login login = new Login();

       // Establecer un usuario de prueba con credenciales incorrectas
       String nombreUsuario = "usuarioInexistente";
       String contraseñaIncorrecta = "contraseñaIncorrecta";

       // Establecer los campos de nombre de usuario y contraseña en el formulario de inicio de sesión
       login.txtLoginUsuario.setText(nombreUsuario);
       login.txtLoginPassword.setText(contraseñaIncorrecta);

       // Simular un clic en el botón de inicio de sesión para activar el proceso de inicio de sesión
       login.btnLogin.doClick();

       // Obtener el usuario actual después del inicio de sesión
       Usuario usuarioLogueado = Sesion.getUsuarioActual();

       // Verificar que el inicio de sesión fue sin éxito
       assertNull(usuarioLogueado);
   }
}