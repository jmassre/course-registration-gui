import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

public class ViewOpenStudent extends JFrame {

	public JLabel lblStudentLoginPortal;
	public static JPanel contentPane;
	
	public JScrollBar scrollBar;
	private static TextArea textArea;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private static JLabel lblSorryAllCourses;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllCoursesAdmin frame = new AllCoursesAdmin();
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
	public ViewOpenStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStudentLoginPortal = new JLabel("OPEN COURSES");
		lblStudentLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblStudentLoginPortal.setBounds(125, 50, 203, 29);
		contentPane.add(lblStudentLoginPortal);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(289, 21, 117, 29);
		contentPane.add(btnLogOut);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(53, 21, 117, 29);
		contentPane.add(btnMainMenu);
		
//		lblSorryAllCourses = new JLabel("Sorry, all courses are filled up!");
//		lblSorryAllCourses.setForeground(Color.RED);
//		lblSorryAllCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
//		lblSorryAllCourses.setBounds(109, 177, 243, 29);
		
		
	

	}
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	/**
	 * @return the lblSorryAllCourses
	 */
	public static JLabel getLblSorryAllCourses() {
		return lblSorryAllCourses;
	}



	
}
