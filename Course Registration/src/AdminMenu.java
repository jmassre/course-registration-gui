import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu extends JFrame {

	public static JPanel contentPane;
	public JButton btnCreateANew;
	public JButton btnLogOut;
	public JButton btnViewAllCourses;
	private JButton btnRemoveACourse;
	private JButton btnRegisterANew;
	private JButton btnSortCoursesBy;
	private JButton btnExamineCourseInformation;
	private JButton btnViewStudentsCourses;
	private JButton btnViewFullCourses;
	private JButton btnWriteAFile;
	private JButton btnViewCourseRosters;
	private JButton btnEditACourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setBackground(new Color(119, 136, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,850,625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnExamineCourseInformation = new JButton("Examine course information");
		btnExamineCourseInformation.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnExamineCourseInformation.setBounds(575, 222, 230, 89);
		contentPane.add(btnExamineCourseInformation);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome, Admin!");
		lblWelcomeAdmin.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblWelcomeAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeAdmin.setBounds(278, 30, 297, 43);
		contentPane.add(lblWelcomeAdmin);
		
		btnViewCourseRosters = new JButton("View course rosters");
		btnViewCourseRosters.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnViewCourseRosters.setBounds(310, 331, 230, 89);
		contentPane.add(btnViewCourseRosters);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnLogOut.setBounds(575, 441, 230, 89);
		contentPane.add(btnLogOut);
		
		btnSortCoursesBy = new JButton("Sort courses by size");
		btnSortCoursesBy.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnSortCoursesBy.setBounds(310, 441, 230, 89);
		contentPane.add(btnSortCoursesBy);
		
		btnViewStudentsCourses = new JButton("View students' courses");
		btnViewStudentsCourses.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnViewStudentsCourses.setBounds(47, 441, 230, 89);
		contentPane.add(btnViewStudentsCourses);
		
		btnRegisterANew = new JButton("Register a new student");
		btnRegisterANew.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnRegisterANew.setBounds(47, 331, 230, 89);
		contentPane.add(btnRegisterANew);
		
		btnViewAllCourses = new JButton("View all courses");
		btnViewAllCourses.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnViewAllCourses.setBounds(310, 110, 230, 89);
		contentPane.add(btnViewAllCourses);
		
		btnEditACourse = new JButton("Edit a course\n");
		btnEditACourse.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnEditACourse.setBounds(310, 222, 230, 89);
		contentPane.add(btnEditACourse);
		
		btnRemoveACourse = new JButton("Remove a course\n");
		btnRemoveACourse.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnRemoveACourse.setBounds(47, 222, 230, 89);
		contentPane.add(btnRemoveACourse);
		
		btnWriteAFile = new JButton("Write a file of full courses");
		btnWriteAFile.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnWriteAFile.setBounds(575, 110, 230, 89);
		contentPane.add(btnWriteAFile);
		
		btnViewFullCourses = new JButton("View full courses");
		btnViewFullCourses.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnViewFullCourses.setBounds(575, 331, 230, 89);
		contentPane.add(btnViewFullCourses);
		
		btnCreateANew = new JButton("Create a new course");
		btnCreateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCreateANew.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCreateANew.setBounds(47, 110, 230, 89);
		contentPane.add(btnCreateANew);
	}
	public JButton getBtnRemoveACourse() {
		return btnRemoveACourse;
	}


	/**
	 * @return the btnRegisterANew
	 */
	public JButton getBtnRegisterANew() {
		return btnRegisterANew;
	}

	/**
	 * @return the btnSortCoursesBy
	 */
	public JButton getBtnSortCoursesBy() {
		return btnSortCoursesBy;
	}

	/**
	 * @return the btnExamineCourseInformation
	 */
	public JButton getBtnExamineCourseInformation() {
		return btnExamineCourseInformation;
	}

	/**
	 * @return the btnViewStudentsCourses
	 */
	public JButton getBtnViewStudentsCourses() {
		return btnViewStudentsCourses;
	}

	/**
	 * @return the btnViewFullCourses
	 */
	public JButton getBtnViewFullCourses() {
		return btnViewFullCourses;
	}

	/**
	 * @return the btnWriteAFile
	 */
	public JButton getBtnWriteAFile() {
		return btnWriteAFile;
	}

	/**
	 * @return the btnViewCourseRosters
	 */
	public JButton getBtnViewCourseRosters() {
		return btnViewCourseRosters;
	}

	/**
	 * @return the btnEditACourse
	 */
	public JButton getBtnEditACourse() {
		return btnEditACourse;
	}
	
	
	
}
