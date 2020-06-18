import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RegisterCourseStudent extends JFrame {

	static JPanel contentPane;
	private JList list;
	private JButton btnRegister;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private static JLabel lblSuccess;
	private static JLabel lblSorryYoureAlready;
	private static JLabel lblSorryThisCourse;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCourseAdmin frame = new DeleteCourseAdmin();
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
	public RegisterCourseStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(119, 136, 153));
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel lblNewCourseMenu = new JLabel("REGISTER IN A COURSE");
		lblNewCourseMenu.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewCourseMenu.setBounds(79, 42, 304, 44);
		contentPane.add(lblNewCourseMenu);
		
		
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(280, 260, 117, 29);
		contentPane.add(btnRegister);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(36, 423, 117, 29);
		contentPane.add(btnMainMenu);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(320, 423, 117, 29);
		contentPane.add(btnLogOut);
		
		lblSorryThisCourse = new JLabel("Sorry, this course is full.");
		lblSorryThisCourse.setForeground(Color.RED);
		lblSorryThisCourse.setBounds(290, 296, 194, 16);
		
		
		lblSorryYoureAlready = new JLabel("Sorry, you're already registered.");
		lblSorryYoureAlready.setForeground(Color.RED);
		lblSorryYoureAlready.setBounds(280, 296, 198, 16);
		
		
		lblSuccess = new JLabel("Success!");
		lblSuccess.setBounds(290, 296, 61, 16);
		
		
		
		
	}

	
	

	
	/**
	 * @return the btnMainMenu
	 */
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	/**
	 * @return the btnLogOut
	 */
	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	
	public JPanel getContentPane() {
		return contentPane;
	}


	public JList getList() {
		return list;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	/**
	 * @return the lblSuccess
	 */
	public static JLabel getLblSuccess() {
		return lblSuccess;
	}

	/**
	 * @return the lblSorryYoureAlready
	 */
	public static JLabel getLblSorryYoureAlready() {
		return lblSorryYoureAlready;
	}

	/**
	 * @return the lblSorryThisCourse
	 */
	public static JLabel getLblSorryThisCourse() {
		return lblSorryThisCourse;
	}
	
	

}
