import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StudentLogin extends JFrame {


	public JPanel contentPane;
	private JTextField textField;
	private JLabel lblStudentLoginPortal;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblInvalidUsernameAndor;
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
	public StudentLogin() {
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
		
		lblStudentLoginPortal = new JLabel("STUDENT LOGIN PORTAL");
		lblStudentLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblStudentLoginPortal.setBounds(76, 77, 341, 29);
		contentPane.add(lblStudentLoginPortal);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 214, 188, 33);
		contentPane.add(passwordField);
		
		btnLogin = new JButton("Login");
		
		
		
		btnLogin.setBounds(188, 266, 117, 29);
		contentPane.add(btnLogin);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(188, 307, 117, 29);
		contentPane.add(btnMainMenu);
		
		lblInvalidUsernameAndor = new JLabel("Invalid username and/or password. Please try again.");
		lblInvalidUsernameAndor.setBounds(56, 246, 350, 16);
		lblInvalidUsernameAndor.setForeground(new Color(255, 0, 0));
		
	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @return the passwordField
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	/**
	 * @return the btnLogin
	 */
	public JButton getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @return the lblInvalidUsernameAndor
	 */
	public JLabel getLblInvalidUsernameAndor() {
		return lblInvalidUsernameAndor;
	}

	/**
	 * @return the btnMainMenu
	 */
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	
	

}
