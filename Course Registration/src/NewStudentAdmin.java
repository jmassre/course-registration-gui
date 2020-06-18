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

public class NewStudentAdmin extends JFrame {

	public static JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblId;
	
	private static JTextField userText;
	private static JPasswordField passText;
	private static JTextField firstText;
	private static JTextField lastText;
	private static JTextField idText;
	
	private JButton btnCreate;
	private JButton btnLogOut;
	private JButton btnMainMenu;
	private static JLabel lblThisUsernameAlready;
	private static JLabel label;
	private static JLabel lblNumber;
	private static JLabel lblCongrats;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudentAdmin frame = new NewStudentAdmin();
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
	public NewStudentAdmin() {
		setBackground(new Color(119, 136, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewStudent = new JLabel("REGISTER A NEW STUDENT");
		lblNewStudent.setBounds(61, 35, 347, 31);
		lblNewStudent.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		contentPane.add(lblNewStudent);
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(22, 195, 95, 16);
		contentPane.add(lblUsername);
		
		userText = new JTextField();
		userText.setBounds(133, 190, 181, 26);
		contentPane.add(userText);
		userText.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(22, 233, 95, 16);
		contentPane.add(lblPassword);
		
		passText = new JPasswordField();
		passText.setColumns(10);
		passText.setBounds(133, 228, 181, 26);
		contentPane.add(passText);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(22, 119, 95, 16);
		contentPane.add(lblFirstName);
		
		firstText = new JTextField();
		firstText.setColumns(10);
		firstText.setBounds(133, 114, 181, 26);
		contentPane.add(firstText);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(22, 157, 115, 16);
		contentPane.add(lblLastName);
		
		lastText = new JTextField();
		lastText.setColumns(10);
		lastText.setBounds(133, 152, 181, 26);
		contentPane.add(lastText);

		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(22, 271, 111, 16);
		contentPane.add(lblId);
		
		
		idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(133, 266, 181, 26);
		contentPane.add(idText);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(156, 314, 117, 29);
		contentPane.add(btnCreate);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(306, 401, 117, 29);
		contentPane.add(btnLogOut);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(22, 401, 117, 29);
		contentPane.add(btnMainMenu);
		
		
		
		
		lblNumber = new JLabel("Please enter a number and try again.");
		lblNumber.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblNumber.setForeground(Color.RED);
		lblNumber.setBounds(133, 293, 290, 16);
		
		
		lblThisUsernameAlready = new JLabel("This username already exists. Try again.");
		lblThisUsernameAlready.setForeground(Color.RED);
		lblThisUsernameAlready.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblThisUsernameAlready.setBounds(133, 214, 253, 16);
		
		
		label = new JLabel("This ID already exists. Try again.");
		label.setForeground(Color.RED);
		label.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		label.setBounds(133, 292, 253, 16);
		
		
	}
	
	

	/**
	 * @return the lblCongrats
	 */
	public static JLabel getLblCongrats() {
		return lblCongrats;
	}

	/**
	 * @return the lblNumber
	 */
	public static JLabel getLblNumber() {
		return lblNumber;
	}

	/**
	 * @return the userText
	 */
	public static JTextField getUserText() {
		return userText;
	}

	/**
	 * @return the passText
	 */
	public static JPasswordField getPassText() {
		return passText;
	}

	/**
	 * @return the firstText
	 */
	public static JTextField getFirstText() {
		return firstText;
	}

	/**
	 * @return the lastText
	 */
	public static JTextField getLastText() {
		return lastText;
	}

	/**
	 * @return the idText
	 */
	public static JTextField getIdText() {
		return idText;
	}

	/**
	 * @return the btnCreate
	 */
	public JButton getBtnCreate() {
		return btnCreate;
	}

	/**
	 * @return the lblThisUsernameAlready
	 */
	public static JLabel getLblThisUsernameAlready() {
		return lblThisUsernameAlready;
	}

	/**
	 * @return the label
	 */
	public static JLabel getLabel() {
		return label;
	}

	/**
	 * @return the btnLogOut
	 */
	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	/**
	 * @return the btnMainMenu
	 */
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	
	
	

	
}
