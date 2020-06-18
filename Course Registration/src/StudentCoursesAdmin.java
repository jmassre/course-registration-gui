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

public class StudentCoursesAdmin extends JFrame {

	static JPanel contentPane;
	private JList list;
	private JButton btnView;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private JLabel lblPleaseACourse;
	private JLabel lblPleaseSelectA;

	

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
	public StudentCoursesAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(119, 136, 153));
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel lblNewCourseMenu = new JLabel("VIEW STUDENTS' COURSES");
		lblNewCourseMenu.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewCourseMenu.setBounds(63, 18, 361, 44);
		contentPane.add(lblNewCourseMenu);
		
		
		
		btnView = new JButton("View");
		btnView.setBounds(280, 260, 117, 29);
		contentPane.add(btnView);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(36, 423, 117, 29);
		contentPane.add(btnMainMenu);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(320, 423, 117, 29);
		contentPane.add(btnLogOut);
		
		lblPleaseSelectA = new JLabel("Please select a student to view:");
		lblPleaseSelectA.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPleaseSelectA.setBounds(126, 58, 210, 16);
		contentPane.add(lblPleaseSelectA);
	
		
	}

	/**
	 * @return the btnExamine
	 */
	public JButton getBtnView() {
		return btnView;
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
