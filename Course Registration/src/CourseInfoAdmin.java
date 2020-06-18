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

public class CourseInfoAdmin extends JFrame {

	static JPanel contentPane;
	private JList list;
	private JButton btnExamine;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private JLabel lblPleaseSekectA;

	

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
	public CourseInfoAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(119, 136, 153));
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel lblNewCourseMenu = new JLabel("COURSE INFO");
		lblNewCourseMenu.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewCourseMenu.setBounds(138, 18, 181, 44);
		contentPane.add(lblNewCourseMenu);
		
		
		
		btnExamine = new JButton("Examine");
		btnExamine.setBounds(280, 260, 117, 29);
		contentPane.add(btnExamine);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(36, 423, 117, 29);
		contentPane.add(btnMainMenu);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(320, 423, 117, 29);
		contentPane.add(btnLogOut);
		
		lblPleaseSekectA = new JLabel("Please select a course to examine.");
		lblPleaseSekectA.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPleaseSekectA.setBounds(111, 57, 265, 16);
		contentPane.add(lblPleaseSekectA);
		
		
		
		
	}

	/**
	 * @return the btnExamine
	 */
	public JButton getBtnExamine() {
		return btnExamine;
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

}
