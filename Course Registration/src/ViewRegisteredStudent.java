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

public class ViewRegisteredStudent extends JFrame {

	public JLabel lblStudentLoginPortal;
	public static JPanel contentPane;
	
	public JScrollBar scrollBar;
	private static TextArea textArea;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private static JLabel lblYouAreCurrently;


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
	public ViewRegisteredStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStudentLoginPortal = new JLabel("REGISTERED COURSES");
		lblStudentLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblStudentLoginPortal.setBounds(88, 49, 307, 29);
		contentPane.add(lblStudentLoginPortal);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(278, 274, 117, 29);
		contentPane.add(btnLogOut);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(55, 274, 117, 29);
		contentPane.add(btnMainMenu);
		
		lblYouAreCurrently = new JLabel("You are currently not enrolled in any courses.");
		lblYouAreCurrently.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblYouAreCurrently.setForeground(Color.RED);
		lblYouAreCurrently.setBounds(53, 185, 369, 16);
		
		
	

	}
	
	
	/**
	 * @return the lblYouAreCurrently
	 */
	public static JLabel getLblYouAreCurrently() {
		return lblYouAreCurrently;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

}
