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

public class ViewFullAdmin extends JFrame {

	public JLabel lblStudentLoginPortal;
	public static JPanel contentPane;
	
	public JScrollBar scrollBar;
	private static TextArea textArea;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private static JLabel lblNoFull;
	private static JLabel lblHereIsA;

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
	public ViewFullAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStudentLoginPortal = new JLabel("FULL COURSES");
		lblStudentLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblStudentLoginPortal.setBounds(133, 55, 240, 29);
		contentPane.add(lblStudentLoginPortal);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(289, 21, 117, 29);
		contentPane.add(btnLogOut);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(53, 21, 117, 29);
		contentPane.add(btnMainMenu);
		
		JLabel label = new JLabel("");
		label.setBounds(147, 174, 61, 16);
		contentPane.add(label);
		
		lblHereIsA = new JLabel("Here is a list of full courses:");
		lblHereIsA.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHereIsA.setBounds(133, 85, 206, 16);
		
		lblNoFull = new JLabel("There are no full courses to be displayed at this time.");
		lblNoFull.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNoFull.setForeground(Color.RED);
		lblNoFull.setBounds(17, 174, 457, 16);
		
		


	}
	
	
	/**
	 * @return the lblHereIsA
	 */
	public static JLabel getLblHereIsA() {
		return lblHereIsA;
	}

	/**
	 * @return the lblNoFull
	 */
	public static JLabel getLblNoFull() {
		return lblNoFull;
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
