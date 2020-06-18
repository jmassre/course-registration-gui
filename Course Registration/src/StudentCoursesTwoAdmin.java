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

public class StudentCoursesTwoAdmin extends JFrame {

	public JLabel lblStudentLoginPortal;
	public static JPanel contentPane;
	
	public JScrollBar scrollBar;
	private static TextArea textArea;
	private JButton btnBack;
	private JButton btnLogOut;
	private JScrollPane scrollPane;
	private JLabel lblHereIsInformation;

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
	public StudentCoursesTwoAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStudentLoginPortal = new JLabel("VIEW STUDENTS' COURSES");
		lblStudentLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblStudentLoginPortal.setBounds(59, 38, 356, 29);
		contentPane.add(lblStudentLoginPortal);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(339, 6, 117, 29);
		contentPane.add(btnLogOut);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(24, 6, 117, 29);
		contentPane.add(btnBack);
		
		lblHereIsInformation = new JLabel("Here are the courses for the student you selected:");
		lblHereIsInformation.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHereIsInformation.setBounds(59, 79, 356, 16);
		contentPane.add(lblHereIsInformation);
		
		
		

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
