import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class EditCourseTwoAdmin extends JFrame {

	static JPanel contentPane;
	private JList list;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private JLabel lblPleaseSelectA;
	private JLabel lblMaximum;
	private JLabel lblInstructor;
	private JLabel lblSectionNumber;
	private JLabel lblLocation;
	private static JTextField maxStudentsText;
	private static JTextField sectionText;
	private static JTextField instructorText;
	private static JTextField locationText;
	private static JLabel lblPleaseEnterA;
	private static JLabel lblPleaseEnterA2;
	private static JLabel lblThisSectionNumber;
	private JButton btnEditLocation;
	private JButton buttonEditInstructor;
	private JButton btnEditSection;
	private JButton btnEditMax;
	private static JLabel lblYourCourseHas;
	



	/**
	 * Create the frame.
	 */
	public EditCourseTwoAdmin(int pos, CourseList c) {
		ArrayList<Course> courses  = c.courses;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(119, 136, 153));
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel lblNewCourseMenu = new JLabel("EDIT COURSE");
		lblNewCourseMenu.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewCourseMenu.setBounds(138, 22, 178, 44);
		contentPane.add(lblNewCourseMenu);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(36, 379, 117, 29);
		contentPane.add(btnMainMenu);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(321, 379, 117, 29);
		contentPane.add(btnLogOut);
		
		lblPleaseSelectA = new JLabel("Enter changes into textfields below:");
		lblPleaseSelectA.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPleaseSelectA.setBounds(101, 68, 282, 16);
		contentPane.add(lblPleaseSelectA);
		
		lblMaximum = new JLabel("Maximum Students:");
		lblMaximum.setBounds(36, 128, 145, 16);
		contentPane.add(lblMaximum);
		
		lblInstructor = new JLabel("Instructor:");
		lblInstructor.setBounds(36, 230, 72, 16);
		contentPane.add(lblInstructor);
		
		lblSectionNumber = new JLabel("Section Number:");
		lblSectionNumber.setBounds(36, 179, 117, 16);
		contentPane.add(lblSectionNumber);
		
		lblLocation = new JLabel("Location:");
		lblLocation.setBounds(36, 280, 61, 16);
		contentPane.add(lblLocation);
		
		maxStudentsText = new JTextField(Integer.toString(courses.get(pos).getMaxStudents()));
		maxStudentsText.setBounds(186, 123, 168, 26);
		contentPane.add(maxStudentsText);
		maxStudentsText.setColumns(10);
		
		sectionText = new JTextField(courses.get(pos).getSection());
		sectionText.setColumns(10);
		sectionText.setBounds(186, 174, 168, 26);
		contentPane.add(sectionText);
		
		instructorText = new JTextField(courses.get(pos).getInstructor());
		instructorText.setColumns(10);
		instructorText.setBounds(186, 225, 168, 26);
		contentPane.add(instructorText);
		
		locationText = new JTextField(courses.get(pos).getLocation());
		locationText.setColumns(10);
		locationText.setBounds(186, 275, 168, 26);
		contentPane.add(locationText);
		
		btnEditLocation = new JButton("Edit");
		btnEditLocation.setBounds(366, 275, 105, 29);
		contentPane.add(btnEditLocation);
		
		buttonEditInstructor = new JButton("Edit");
		buttonEditInstructor.setBounds(366, 225, 105, 29);
		contentPane.add(buttonEditInstructor);
		
		btnEditSection = new JButton("Edit");
		btnEditSection.setBounds(366, 174, 105, 29);
		contentPane.add(btnEditSection);
		
		btnEditMax = new JButton("Edit");
		btnEditMax.setBounds(366, 123, 105, 29);
		contentPane.add(btnEditMax);
		
		lblYourCourseHas = new JLabel("Your course has successfully been edited.");
		lblYourCourseHas.setBounds(117, 332, 285, 16);
		
		
		lblThisSectionNumber = new JLabel("This section number already exists.");
		lblThisSectionNumber.setForeground(Color.RED);
		lblThisSectionNumber.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblThisSectionNumber.setBounds(186, 199, 238, 16);
		
		lblPleaseEnterA = new JLabel("Please enter a number.");
		lblPleaseEnterA.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblPleaseEnterA.setForeground(Color.RED);
		lblPleaseEnterA.setBounds(186, 146, 158, 16);
		
		lblPleaseEnterA2 = new JLabel("Please enter a number.");
		lblPleaseEnterA2.setForeground(Color.RED);
		lblPleaseEnterA2.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblPleaseEnterA2.setBounds(186, 197, 158, 16);
		
		
		
		
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

	/**
	 * @return the maxStudentsText
	 */
	public static JTextField getMaxStudentsText() {
		return maxStudentsText;
	}

	/**
	 * @return the sectionText
	 */
	public static JTextField getSectionText() {
		return sectionText;
	}

	/**
	 * @return the instructorText
	 */
	public static JTextField getInstructorText() {
		return instructorText;
	}

	/**
	 * @return the locationText
	 */
	public static JTextField getLocationText() {
		return locationText;
	}





	/**
	 * @return the lblPleaseEnterA
	 */
	public static JLabel getLblPleaseEnterA() {
		return lblPleaseEnterA;
	}





	/**
	 * @return the lblPleaseEnterA2
	 */
	public static JLabel getLblPleaseEnterA2() {
		return lblPleaseEnterA2;
	}





	/**
	 * @return the lblThisSectionNumber
	 */
	public static JLabel getLblThisSectionNumber() {
		return lblThisSectionNumber;
	}





	/**
	 * @return the btnEditLocation
	 */
	public JButton getBtnEditLocation() {
		return btnEditLocation;
	}





	/**
	 * @return the buttonEditInstructor
	 */
	public JButton getBtnEditInstructor() {
		return buttonEditInstructor;
	}





	/**
	 * @return the btnEditSection
	 */
	public JButton getBtnEditSection() {
		return btnEditSection;
	}





	/**
	 * @return the btnEditMax
	 */
	public JButton getBtnEditMax() {
		return btnEditMax;
	}





	/**
	 * @return the lblYourCourseHas
	 */
	public static JLabel getLblYourCourseHas() {
		return lblYourCourseHas;
	}











	

	
	
	
}
