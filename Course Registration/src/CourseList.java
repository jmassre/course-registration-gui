/*
 * The CourseList class represents each CourseList ArrayList
 * @author Joseph Massre
 * @version 1
 */

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;

public class CourseList implements Serializable {
	
	//property
	public ArrayList<Course> courses = new ArrayList<Course>();
	public JLabel lblPleaseInputA;
	public JLabel lblNewLabel_1;
	public JLabel lblCongratsHasBeen;

	static final long serialVersionUID = 44L;
	//constructor sets the arraylist
	public CourseList(ArrayList<Course> courses) {
		this.courses = new ArrayList<Course>(courses);
	}
	
	/*
	 * creates a new course object by asking admin for course information
	 */
	public void newcourse() {
		//ask for the properties of the new course
		Scanner scan = new Scanner(System.in);
		System.out.println("Course name: ");
		String courseName = scan.nextLine();
		System.out.println("Course ID: ");
		String courseID = scan.nextLine();
		System.out.println("Max # of students: ");
		String maxStudentsString = scan.nextLine();
		try{
			//make sure that the maxStudents is a number
			int maxStudents = Integer.parseInt(maxStudentsString);	
			System.out.println("Instructor name: ");
			String instructor = scan.nextLine();
			System.out.println("Section #: ");
			String section = scan.nextLine();
			Integer.parseInt(section);//also make sure that the section is a number
			System.out.println("Location: ");
			String location = scan.nextLine();
			
			ArrayList<String> firstNames = new ArrayList<String>();
			ArrayList<String> lastNames = new ArrayList<String>();
			//input all of these variables into the constructor to create the new object and add it into the courses list
			courses.add(new Course(courseName, courseID, maxStudents, 0, firstNames ,lastNames, instructor, section, location));
			System.out.println("You have successfully added "+courseName);
		}
		//if max students or section isn't a number say to input a number 
		catch(Exception e) {
			System.out.println("Please input a number and try again.");
		}
		
	}
	
	public void newcourseGUI() {
		String courseName = newCourse.getNameText().getText();
		String instructor = newCourse.getInstructorText().getText();
		String maxStudentsString = newCourse.getMaxText().getText();
		String section = newCourse.getSectionText().getText();
		String courseID = newCourse.getIDText().getText();
		String location = newCourse.getLocationText().getText();
		
		try{
			
			int maxStudents = Integer.parseInt(maxStudentsString);	//make sure that the maxStudents is a number
			newCourse.contentPane.remove(lblPleaseInputA);
			newCourse.contentPane.setVisible(false);
			newCourse.contentPane.setVisible(true);
			
				
			
			
		}
		//if max students or section isn't a number say to input a number 
		catch(Exception e) {

			lblPleaseInputA = new JLabel("Please input a number.");
			lblPleaseInputA.setForeground(new Color(255, 0, 0));
			lblPleaseInputA.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
			lblPleaseInputA.setBounds(133, 205, 181, 16);
			newCourse.contentPane.add(lblPleaseInputA);
			System.out.println("max");
			
			
			
			
		}
		try {
			Integer.parseInt(section);
			newCourse.contentPane.remove(lblNewLabel_1);
			newCourse.contentPane.setVisible(false);
			newCourse.contentPane.setVisible(true);
		}
		catch(Exception ne) {
			lblNewLabel_1 = new JLabel("Please input a number.");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
			lblNewLabel_1.setForeground(new Color(255, 0, 0));
			lblNewLabel_1.setBounds(133, 296, 158, 16);
			newCourse.contentPane.add(lblNewLabel_1);
			System.out.println("section");


		}
		try {
			
			int maxStudents = Integer.parseInt(maxStudentsString);
			Integer.parseInt(section);
			newCourse.contentPane.remove(lblPleaseInputA);
			
			
			newCourse.contentPane.setVisible(false);
			newCourse.contentPane.setVisible(true);
			
			newCourse.contentPane.remove(lblNewLabel_1);
			
			newCourse.contentPane.setVisible(false);
			newCourse.contentPane.setVisible(true);
			
			ArrayList<String> firstNames = new ArrayList<String>();
			ArrayList<String> lastNames = new ArrayList<String>();
			//input all of these variables into the constructor to create the new object and add it into the courses list
			courses.add(new Course(courseName, courseID, maxStudents, 0, firstNames ,lastNames, instructor, section, location));
			System.out.println("You have successfully added "+courseName);
			newCourse.contentPane.remove(lblPleaseInputA);
			newCourse.contentPane.remove(lblNewLabel_1);
			JLabel lblCongratsHasBeen = new JLabel("Congrats! "+ courseName+" has been successfully added.");
			lblCongratsHasBeen.setBounds(71, 375, 389, 16);
			newCourse.contentPane.add(lblCongratsHasBeen);
			
			
		}
		catch(Exception e){
			System.out.println("Nice try");
		}
		
		
		
	}
	
}
