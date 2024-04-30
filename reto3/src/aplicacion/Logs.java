package aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import definicion.Logger;
import definicion.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

public class Logs extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVolverLogs;
	private JLabel lblListaMovimientos;
	private JLabel lblListaUsuarios;
	private JList<Logger> lstMovimientos;
	private JList<Usuario> lstUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logs frame = new Logs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logs() {
		//Imagen de la aplicación
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/BOFlogo.png")).getImage());
		setTitle("Logs - Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolverLogs = new JButton("Volver");
		btnVolverLogs.addActionListener(this);
		btnVolverLogs.setForeground(new Color(255, 255, 255));
		btnVolverLogs.setBackground(new Color(128, 128, 128));
		btnVolverLogs.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVolverLogs.setFocusable(false);
		btnVolverLogs.setBounds(175, 475, 85, 21);
		contentPane.add(btnVolverLogs);
		
		lblListaMovimientos = new JLabel("Lista de Movimientos");
		lblListaMovimientos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblListaMovimientos.setBounds(60, 23, 200, 33);
		contentPane.add(lblListaMovimientos);
		
		lblListaUsuarios = new JLabel("Lista de Usuarios");
		lblListaUsuarios.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblListaUsuarios.setBounds(60, 257, 200, 33);
		contentPane.add(lblListaUsuarios);
		
		lstMovimientos = new JList<Logger>();
		lstMovimientos.setBounds(60, 65, 315, 145);
		contentPane.add(lstMovimientos);
		
		lstUsuarios = new JList<Usuario>();
		lstUsuarios.setBounds(60, 300, 315, 145);
		contentPane.add(lstUsuarios);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		//Cierro la ventana Login
		dispose();
	}
}
