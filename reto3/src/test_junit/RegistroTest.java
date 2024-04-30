package test_junit;

import java.util.ArrayList;

//Importaciones
import org.junit.jupiter.api.Test;
import aplicacion.Registro;
import definicion.Usuario;
import junit.framework.TestCase;

class RegistroTest extends TestCase {

   @Test
   public void testRegistroUsuarioExistente() {
      //Guarda en una arraylist los usuarios por defecto y crea un archivo si no lo está
   	ArrayList<Usuario> listaUsuarios = Usuario.obtenerUsuariosPorDefecto();
   	
   	//Crear una instancia de la clase Registro
		Usuario.guardarUsuarios(listaUsuarios);
   	Registro registro = new Registro();
   	
      //Establecer un nombre de usuario que ya está en la lista de usuarios
      String usuarioExistente = "admin";
      String contraseña = "admin";

      //Establecer los campos de nombre de usuario y contraseña en el formulario de registro
      registro.txtRegistroUsuario.setText(usuarioExistente);
      registro.txtRegistroPassword.setText(contraseña);
      registro.txtRegistroPassword2.setText(contraseña);

      //Simular un clic en el botón de registro para activar el proceso de registro
      registro.btnRegistrarse.doClick();
   }
   
   @Test
   public void testRegistroCorrecto() {
      //Crear una instancia de la clase Registro
      Registro registro = new Registro();

      //Establecer un nombre de usuario que ya está en la lista de usuarios
      String usuarioExistente = "usuarioCorrecto";
      String contraseña = "contraseñaPrueba";

      //Agregar un usuario de prueba a la lista existente
      ArrayList<Usuario> listaUsuarios = new ArrayList<>();
      listaUsuarios.add(new Usuario(usuarioExistente, contraseña, false));
      Usuario.guardarUsuarios(listaUsuarios);

   	
      //Establecer los campos de nombre de usuario y contraseña en el formulario de registro
      registro.txtRegistroUsuario.setText(usuarioExistente);
      registro.txtRegistroPassword.setText(contraseña);
      registro.txtRegistroPassword2.setText(contraseña);

      //Simular un clic en el botón de registro para activar el proceso de registro
      registro.btnRegistrarse.doClick();

      
      //Restaurar la lista de usuarios original
      Usuario.guardarUsuarios(new ArrayList<>());
   }
}