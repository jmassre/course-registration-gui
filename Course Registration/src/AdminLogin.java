import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	private JLabel lblAdminLoginPortal;
	public JPasswordField passwordField;
	public JButton btnLogin;
	public JLabel lblInvalidUsernameAndor;
	public String adminUser;
	public String adminPass;
	private JButton btnMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblUsername.setBounds(30, 167, 87, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblPassword.setBounds(30, 218, 79, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(163, 163, 188, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblAdminLoginPortal = new JLabel("ADMIN LOGIN PORTAL");
		lblAdminLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblAdminLoginPortal.setBounds(89, 77, 300, 29);
		contentPane.add(lblAdminLoginPortal);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 214, 188, 33);
		contentPane.add(passwordField);
		
		btnLogin = new JButton("Login");
		
		
		
		btnLogin.setBounds(196, 259, 117, 29);
		contentPane.add(btnLogin);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(196, 300, 117, 29);
		contentPane.add(btnMainMenu);
		

		
		
		
	}

	/**
	 * @return the btnMainMenu
	 */
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	
	
}
