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

public class SortAdmin extends JFrame {

	public JLabel lblStudentLoginPortal;
	public static JPanel contentPane;
	
	public JScrollBar scrollBar;
	private static TextArea textArea;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private JLabel lblTheCoursesHave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortAdmin frame = new SortAdmin();
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
	public SortAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStudentLoginPortal = new JLabel("SORTED COURSES");
		lblStudentLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblStudentLoginPortal.setBounds(102, 56, 259, 29);
		contentPane.add(lblStudentLoginPortal);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(289, 21, 117, 29);
		contentPane.add(btnLogOut);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(53, 21, 117, 29);
		contentPane.add(btnMainMenu);
		
		lblTheCoursesHave = new JLabel("Courses have been sorted based on the amount of registered students.");
		lblTheCoursesHave.setBounds(17, 84, 446, 16);
		contentPane.add(lblTheCoursesHave);
	}
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public static TextArea getTextArea() {
		return textArea;
	}

}
