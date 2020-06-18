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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class CourseRosterTwoAdmin extends JFrame {

	public JLabel lblStudentLoginPortal;
	public static JPanel contentPane;
	
	public JScrollBar scrollBar;
	private static TextArea textArea;
	private JButton btnBack;
	private JButton btnLogOut;
	private JScrollPane scrollPane;
	private JLabel lblHereIsRoster;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseRosterTwoAdmin frame = new CourseRosterTwoAdmin();
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
	public CourseRosterTwoAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStudentLoginPortal = new JLabel("VIEW COURSE ROSTER");
		lblStudentLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblStudentLoginPortal.setBounds(78, 40, 308, 29);
		contentPane.add(lblStudentLoginPortal);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(312, 275, 117, 29);
		contentPane.add(btnLogOut);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(16, 275, 117, 29);
		contentPane.add(btnBack);
		
		lblHereIsRoster = new JLabel("Here is the roster for the course you selected:");
		lblHereIsRoster.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHereIsRoster.setBounds(67, 69, 326, 16);
		contentPane.add(lblHereIsRoster);
		
		
		

	}
	public JButton getBtnMainMenu() {
		return btnBack;
	}

	public JButton getBtnBack() {
		return btnBack;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	public static TextArea getTextArea() {
		return textArea;
	}

}
