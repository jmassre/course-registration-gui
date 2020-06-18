/*
 * The Course class represents each student
 * @author Joseph Massre
 * @version 1
 */

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.*;
public class Student extends User implements studentInterface, Serializable {
	//properties
	private ArrayList<Course> registeredClasses = new ArrayList<Course>(); //just a string of the names of classes theyre in
	private String firstName;
	private String lastName;
	private String ID;
	

	//constructor sets the properties
	public Student(String username, String password, String firstName, String lastName, String ID) {
		super(username, password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setID(ID);
	}

	/*
	 * Allows student to view all courses in registrar.
	 * @param CourseList object c
	 */
	@Override
	public void viewAll(CourseList c) {
		
		ArrayList<Course> courses  = c.courses;
		//loops through and prints course name
		for (int i=0;i<courses.size();i++) {
			System.out.println(courses.get(i).getCourseName());
		}
		
		
	}
	
	public void viewAllGUI(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		
		String print =" \n";
		for (int i=0;i<courses.size();i++) {
			print+=("        Course Name:"+" "+courses.get(i).getCourseName()+ "\n");
			print+=("        Course ID: "+ courses.get(i).getCourseID()+"\n");
			print+=("        Instructor: "+ courses.get(i).getInstructor()+"\n");
			print+=("        Location: "+ courses.get(i).getLocation());
		
			print+="\n";
			print+="----------------------------------------------------------------------------";
			print+="\n";
	
		}

		
		JTextArea textArea = new JTextArea(print);
		textArea.setBackground((new Color(119, 136, 153)));
		
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(-16, 84, 496, 384);
		
		
		ViewAllStudent.contentPane.add(scrollPane);
	}
	/*
	 * Allows student to view all open courses.
	 * @param CourseList object c
	 */
	@Override
	public void viewOpen(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		//loop through courses
		for (int i=0;i<courses.size();i++) {
			//check if the course isn't maxed out and if it isn't print the course name
			if (courses.get(i).getCurrentStudents() < courses.get(i).getMaxStudents()) {
				System.out.println(courses.get(i).getCourseName());
			}
			
		}
		
	}
	
	public void viewOpenGUI(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		String print =" \n";
		
		int counter=0;
		
		for (int i=0;i<courses.size();i++) {
			
			//check if the course isn't maxed out and if it isn't print the course name
			if (courses.get(i).getCurrentStudents() < courses.get(i).getMaxStudents()) {
				print+=("        Course Name:"+" "+courses.get(i).getCourseName()+ "\n");
				print+=("        Course ID: "+ courses.get(i).getCourseID()+"\n");
				print+=("        Instructor: "+ courses.get(i).getInstructor()+"\n");
				print+=("        Location: "+ courses.get(i).getLocation());
			
				print+="\n";
				print+="----------------------------------------------------------------------------";
				print+="\n";
				
			}
			else {
				counter++;
			}
			
			
		}
		
		
		JLabel lblSorryAllCourses = new JLabel("Sorry, all courses are filled up!");
		lblSorryAllCourses.setForeground(Color.RED);
		lblSorryAllCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSorryAllCourses.setBounds(109, 177, 243, 29);
		
		if(counter==courses.size()) {
			ViewOpenStudent.contentPane.add(lblSorryAllCourses);
			
		}
		else {
			
		
	
			JTextArea textArea = new JTextArea(print);
			textArea.setBackground((new Color(119, 136, 153)));
			
			textArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setBounds(-16, 84, 496, 384);
			
			
			ViewOpenStudent.contentPane.add(scrollPane);
			
			
		}
		
	}
	/*
	 * Allows student to register in a course.
	 * @param CourseList object c
	 */
	@Override
	public void register(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Scanner scan = new Scanner(System.in);
		System.out.println("Course name: ");
		String course = scan.nextLine();
		System.out.println("Section: ");
		String section = scan.nextLine();
		int sameCounter=0; //how many duplicate course names
		int otherSameCounter=0; //this is the counter to see if this equals the amount of duplicate course names
		int counter=0;
		//checks for # of duplicate course names
		for (int n=0;n<courses.size();n++) {
			if (courses.get(n).getCourseName().equals(course)) {
				sameCounter+=1;
			}
		}
		for (int i=0;i<courses.size();i++) {
			counter+=1;
			//if the student's list of registered classes already has this class say that they're already registered
			if (this.getRegisteredClasses().contains(course) ){
				
			
				
				if(counter==courses.size()) {
					System.out.println("You are already registered in "+ course+".");
				}
				
			}
			//if not, then check if the coursename is the course and section is the section and it isnt maxed out
			else if ((courses.get(i).getCourseName().equals(course)) && (courses.get(i).getSection().equals(section)) && (courses.get(i).getCurrentStudents()!= courses.get(i).getMaxStudents()) ) {
				
				courses.get(i).setCurrentStudents(courses.get(i).getCurrentStudents()+1); //add amount of students
				courses.get(i).getFirstNames().add(this.getFirstName()); //add firstname
				
				courses.get(i).getLastNames().add(this.getLastName()); //add lastname
				this.getRegisteredClasses().add(courses.get(i)); //add the course
		
				System.out.println("You've successfully enrolled in "+ course+", congrats!");
				break;
				
			}
			//if its full, say its full
			else if (((courses.get(i).getCourseName().equals(course)) && (courses.get(i).getSection().equals(section)) && (courses.get(i).getCurrentStudents()== courses.get(i).getMaxStudents()))) {
				System.out.println("Sorry this course is full.");
				break;
			}
			
			else if (((courses.get(i).getCourseName().equals(course)) && (courses.get(i).getSection().equals(section)==false) )){
				otherSameCounter+=1;
				if (sameCounter==otherSameCounter) {//if it hit the amount of duplicate names and the section still isnt there
					System.out.println("Sorry, this section does not exist."); //let the student know
					break;
				}
				
			}
			//if it isnt the right name and its already gotten to the last element say it doesnt exist
			else if (courses.get(i).getCourseName().equals(course)==false) {
				
				
				if (counter==courses.size()) {
					
					
					System.out.println("Sorry, this course does not exist.");
				}

			}
		
			
		}		
	}
	
	
	public void registerGUI(CourseList c, int pos) {
		RegisterCourseStudent.contentPane.remove(RegisterCourseStudent.getLblSorryYoureAlready());
		RegisterCourseStudent.contentPane.remove(RegisterCourseStudent.getLblSorryThisCourse());
		RegisterCourseStudent.contentPane.remove(RegisterCourseStudent.getLblSuccess());
		ArrayList<Course> courses  = c.courses;
		if(this.getRegisteredClasses().contains(courses.get(pos))) {
			RegisterCourseStudent.contentPane.add(RegisterCourseStudent.getLblSorryYoureAlready());
		}
		else if(courses.get(pos).getCurrentStudents()==courses.get(pos).getMaxStudents()) {
			RegisterCourseStudent.contentPane.add(RegisterCourseStudent.getLblSorryThisCourse());
		}
		else {
			courses.get(pos).setCurrentStudents(courses.get(pos).getCurrentStudents()+1); //add amount of students
			courses.get(pos).getFirstNames().add(this.getFirstName()); //add firstname
			
			courses.get(pos).getLastNames().add(this.getLastName()); //add lastname
			this.getRegisteredClasses().add(courses.get(pos));
			
			RegisterCourseStudent.contentPane.add(RegisterCourseStudent.getLblSuccess());
		}
		
		
		
		
		
	}
	/*
	 * Allows student to withdraw from a course.
	 * @param CourseList object c
	 */
	@Override
	public void withdraw(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Scanner scan = new Scanner(System.in);
		System.out.println("Course name: ");
		String course = scan.nextLine();
		System.out.println("Section: ");
		String section = scan.nextLine();
		int counter=0;
		int sameCounter=0; //how many duplicate course names
		int otherSameCounter=0; //this is the counter to see if this equals the amount of duplicate course names
		//checks for # of duplicate course names
		for (int n=0;n<courses.size();n++) {
			if (courses.get(n).getCourseName().equals(course)) {
				sameCounter+=1;
			}
		}
		for (int i=0;i<courses.size();i++) {
			
			//if coursename and section is like entered
			if ((courses.get(i).getCourseName().equals(course)) && (courses.get(i).getSection().equals(section) && this.getRegisteredClasses().contains(course))  ) {
				
			courses.get(i).setCurrentStudents(courses.get(i).getCurrentStudents()-1); //decreased amount of enrolled students 
			//remove names
			courses.get(i).getFirstNames().remove(this.getFirstName());
				
			courses.get(i).getLastNames().remove(this.getLastName());
			//remove the course from student's registered classs list
			this.getRegisteredClasses().remove(courses.get(i));
			System.out.println("You've successfully withdrew in "+ course+", congrats!");
			
			break;
				
			}
			else if (((courses.get(i).getCourseName().equals(course)) && (courses.get(i).getSection().equals(section)==false))){
				otherSameCounter+=1;
				if (sameCounter==otherSameCounter) {//if it hit the amount of duplicate names and the section still isnt there
					System.out.println("Sorry, this section does not exist.");//let the student know
					break;
				}

			}
			
			
			else if ((courses.get(i).getCourseName().equals(course)==false) ) {
				counter+=1;
			
				if (counter==courses.size()) {
					System.out.println("Sorry, this course does not exist.");
				}
			}
			else if (this.getRegisteredClasses().contains(course)==false) {
				counter+=1;
				if (counter==courses.size()) {
					System.out.println("You are not enrolled in "+course+".");//if it is up to the last element and still no match on the registered courses

				}
				
				
			

		}
			
			
			
		}
		
	}
	public void withdrawGUI(CourseList c, int pos) {
		ArrayList<Course> courses  = c.courses;
		
		WithdrawCourseStudent.contentPane.remove(WithdrawCourseStudent.getLblSuccess());
		courses.get(pos).setCurrentStudents(courses.get(pos).getCurrentStudents()-1); //decreased amount of enrolled students 
		//remove names
		courses.get(pos).getFirstNames().remove(this.getFirstName());
			
		courses.get(pos).getLastNames().remove(this.getLastName());
		//remove the course from student's registered classs list
		this.getRegisteredClasses().remove(courses.get(pos));
		WithdrawCourseStudent.contentPane.add(WithdrawCourseStudent.getLblSuccess());
	}
	/*
	 * Allows student to view courses they are registered in.
	 * @param CourseList object c
	 */
	@Override
	public void viewRegistered() {
		//if registered classes are 0 say that student isnt registered in any classes
		if (this.getRegisteredClasses().size()==0) {
			System.out.println("You are currently not enrolled in any courses.");
		}
		else {
			//if not, loop through and print all classes they are registered in
			System.out.println("You are currently registered in:");
			for (int i=0;i<this.getRegisteredClasses().size();i++) {
				System.out.println(this.getRegisteredClasses().get(i));
			}
		}
		
	}
	
	public void viewRegisteredGUI() {
		if (this.getRegisteredClasses().size()==0) {
			ViewRegisteredStudent.contentPane.add(ViewRegisteredStudent.getLblYouAreCurrently());
			
		}
		else {
			

			
			String print="\n";
			for (int i=0;i<this.getRegisteredClasses().size();i++) {
				print+=("      • "+this.getRegisteredClasses().get(i).getCourseName()+"\n");
				
				
			}
			JTextArea textArea = new JTextArea(print);
			textArea.setBackground((new Color(119, 136, 153)));
			
			textArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setBounds(0, 100, 479, 157);
			
			
			ViewRegisteredStudent.contentPane.add(scrollPane);
		}
	}

	/*
	 * Allows student to exit from program.
	 */
	@Override
	public void exit() {
		//exit
		System.exit(0);
		
	}
	
	/*
	 * gets student's registered classes
	 * @return ArrayList registeredClasses
	 */
	public ArrayList<Course> getRegisteredClasses() {
		return registeredClasses;
	}
	/*
	 * sets student's registered classes
	 * @param ArrayList registeredClasses
	 */
	public void setRegisteredClasses(ArrayList<Course> registeredClasses) {
		this.registeredClasses = registeredClasses;
	}
	
	/*
	 * gets student's ID
	 * @return ID
	 */
	public String getID() {
		return ID;
	}

	/*
	 * sets student's ID
	 * @param ID
	 */
	public void setID(String iD) {
		ID = iD;
	}


}
