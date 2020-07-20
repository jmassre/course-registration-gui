import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class NewCourse extends JFrame {

	public static JPanel contentPane;
	private static JTextField nameText;
	private static JTextField IDText;
	private static JTextField maxText;
	private static JTextField instructorText;
	private static JTextField sectionText;
	private static JTextField locationText;
	public String courseName;
	public String courseID;
	public String maxStudentsString;
	public String instructor;
	public String section;
	public String location;
	public JButton btnCreate;
	public JButton btnLogOut;
	private static JLabel lblPleaseInputA;
	public JButton btnMainMenu;
	private static JLabel lblNewLabel_1;
	private static JLabel lblThatSectionAlready;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCourse frame = new NewCourse();
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
	public NewCourse() {
		setBackground(new Color(119, 136, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewCourseMenu = new JLabel("CREATE A COURSE");
		lblNewCourseMenu.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewCourseMenu.setBounds(85, 42, 246, 44);
		contentPane.add(lblNewCourseMenu);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(22, 111, 95, 16);
		contentPane.add(lblCourseName);
		
		nameText = new JTextField();
		nameText.setBounds(133, 106, 181, 26);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JLabel lblCourseId = new JLabel("Course ID:");
		lblCourseId.setBounds(22, 149, 95, 16);
		contentPane.add(lblCourseId);
		
		IDText = new JTextField();
		IDText.setColumns(10);
		IDText.setBounds(133, 144, 181, 26);
		contentPane.add(IDText);
		
		JLabel lblMaxStudents = new JLabel("Max Students:");
		lblMaxStudents.setBounds(22, 187, 95, 16);
		contentPane.add(lblMaxStudents);
		
		maxText = new JTextField();
		maxText.setColumns(10);
		maxText.setBounds(133, 182, 181, 26);
		contentPane.add(maxText);
		
		JLabel lblInstructorName = new JLabel("Instructor Name:");
		lblInstructorName.setBounds(22, 235, 115, 16);
		contentPane.add(lblInstructorName);
		
		sectionText = new JTextField();
		sectionText.setColumns(10);
		sectionText.setBounds(133, 268, 181, 26);
		contentPane.add(sectionText);
		
		JLabel lblNewLabel = new JLabel("Section Number:");
		lblNewLabel.setBounds(22, 273, 111, 16);
		contentPane.add(lblNewLabel);
		
		instructorText = new JTextField();
		instructorText.setColumns(10);
		instructorText.setBounds(133, 230, 181, 26);
		contentPane.add(instructorText);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(22, 322, 130, 16);
		contentPane.add(lblLocation);
		
		locationText = new JTextField();
		locationText.setColumns(10);
		locationText.setBounds(133, 317, 181, 26);
		contentPane.add(locationText);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(158, 373, 117, 29);
		contentPane.add(btnCreate);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(305, 423, 117, 29);
		contentPane.add(btnLogOut);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(22, 423, 117, 29);
		contentPane.add(btnMainMenu);
		
		lblThatSectionAlready = new JLabel("That section already exists. Please try again.");
		lblThatSectionAlready.setForeground(new Color(255, 0, 0));
		lblThatSectionAlready.setBounds(85, 355, 294, 16);
		
		lblPleaseInputA = new JLabel("Please input a number.");
		lblPleaseInputA.setForeground(new Color(255, 0, 0));
		lblPleaseInputA.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblPleaseInputA.setBounds(133, 205, 181, 16);
		
		lblNewLabel_1 = new JLabel("Please input a number.");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(133, 296, 158, 16);
		

		
	}

	/**
	 * @return the nameText
	 */
	public static JTextField getNameText() {
		return nameText;
	}

	/**
	 * @return the iDText
	 */
	public static JTextField getIDText() {
		return IDText;
	}

	/**
	 * @return the maxText
	 */
	public static JTextField getMaxText() {
		return maxText;
	}

	/**
	 * @return the instructorText
	 */
	public static JTextField getInstructorText() {
		return instructorText;
	}

	/**
	 * @return the sectionText
	 */
	public static JTextField getSectionText() {
		return sectionText;
	}

	/**
	 * @return the locationText
	 */
	public static JTextField getLocationText() {
		return locationText;
	}

	/**
	 * @return the lblThatSectionAlready
	 */
	public static JLabel getLblThatSectionAlready() {
		return lblThatSectionAlready;
	}

	/**
	 * @return the lblPleaseInputA
	 */
	public static JLabel getLblPleaseInputA() {
		return lblPleaseInputA;
	}

	/**
	 * @return the lblNewLabel_1
	 */
	public static JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}
	
	
	
}
