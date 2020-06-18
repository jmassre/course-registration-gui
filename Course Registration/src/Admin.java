/*
 * The Admin class represents the admin.
 * @author Joseph Massre
 * @version 1
 */

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Admin extends User implements adminInterface, Serializable {
	public ArrayList<Student> studentRegistered= new ArrayList<Student>();
	public static JLabel lblCongrats;
	static final long serialVersionUID = 43L;
	//constructor sets admin properties from User class
	public Admin(String username, String password) {
		super(username, password);
	}


	/*
	 * deletes course from registrar
	 * @param CourseList object c
	 */
	@Override
	public void deleteCourse(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Scanner scan = new Scanner(System.in);
		//get the course to delete
		System.out.println("Which course would you like to delete? ");
		String courseName = scan.nextLine();
		
		//get the section to delete
		System.out.println("What section of "+courseName+" would you like to delete?");
		String section = scan.nextLine();
		int counter=0;
		int sameCounter=0; //how many duplicate course names
		int otherSameCounter=0; //this is the counter to see if this equals the amount of duplicate course names
		
		//checks for # of duplicate course names
		for (int i=0;i<courses.size();i++) {
			if (courses.get(i).getCourseName().equals(courseName)) {
				sameCounter+=1;
			}
		}
		
		//loop through all courses
		for (int i=0;i<courses.size();i++) {
			
			
			counter+=1;
			
			//if the course name and section are the same
			if (courses.get(i).getCourseName().equals(courseName) && courses.get(i).getSection().equals(section)) {
				courses.remove(i); //remove the course from the courselist
				
				System.out.println("You have successfully deleted course "+courseName+".");
				for (int n=0;n<this.studentRegistered.size();n++) {
					//remove it from the students registered classes
					for (int j=0;j<this.studentRegistered.get(n).getRegisteredClasses().size();j++) {
						if (this.studentRegistered.get(n).getRegisteredClasses().contains(courses.get(i))) {
							this.studentRegistered.get(n).getRegisteredClasses().remove(courseName);
						}
					}
					
				}
				break;
			}
			//if the section isn't there but coursename is 
			else if(courses.get(i).getCourseName().equals(courseName) && (courses.get(i).getSection().equals(section)==false) ){
				otherSameCounter+=1; //
				if (sameCounter==otherSameCounter) { //if it hit the amount of duplicate names and the section still isnt there
					System.out.println("There is no course "+ courseName+" with the section "+section+"."); //let the user know
					break;
				}
				
			}
			//if there is no course with that section:
			else if (counter==courses.size()){
				
				System.out.println("Sorry, there is no course with the name "+courseName+".");
			}
				
			}
			
	}
	
	
	public void deleteCourseGUI(CourseList c, int pos) {

		ArrayList<Course> courses  = c.courses;

		for (int n=0;n<this.studentRegistered.size();n++) {
			//remove it from the students registered classes
			for (int j=0;j<this.studentRegistered.get(n).getRegisteredClasses().size();j++) {
				if (this.studentRegistered.get(n).getRegisteredClasses().contains(courses.get(pos))) {
					this.studentRegistered.get(n).getRegisteredClasses().remove(courses.get(pos).getCourseName());
				}
			}
			
		}
		courses.remove(pos);
		c.courses=courses;
		
	}
	
	/*
	 * allows admin to edit info on course except for course name and course id
	 * @param CourseList object c
	 */
	@Override
	public void editCourse(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Scanner scan = new Scanner(System.in);
		int counter1=0;
		int counter2=0;
		int sameCounter=0; //how many duplicate course names
		int otherSameCounter=0; //this is the counter to see if this equals the amount of duplicate course names
		
		while (true) {
			//gets the course to edit
			System.out.println("Which course would you like to edit? ");
			String courseName=scan.nextLine();
			System.out.println("What section of "+courseName+" would you like to delete?");
			String section = scan.nextLine();
			
			
			//checks for # of duplicate course names
			for (int n=0;n<courses.size();n++) {
				if (courses.get(n).getCourseName().equals(courseName)) {
					sameCounter+=1;
				}
			}
			
			for (int i=0;i<courses.size();i++) {
				
				if(courses.get(i).getCourseName().equals(courseName) && (courses.get(i).getSection().equals(section)==false) ){
					otherSameCounter+=1; //
					if (sameCounter==otherSameCounter) { //if it hit the amount of duplicate names and the section still isnt there
						System.out.println("There is no course "+ courseName+" with the section "+section+"."); //let the user know
						return;
					}
					
				}
				counter2+=1;
				//checks if there is a course with the name courseName
				if(courses.get(i).getCourseName().equals(courseName)==false && counter2==courses.size()) {
					
					System.out.println("Sorry, here is no course named "+courseName+".");
					return;
					
				}
				//break out of here if they do equal eachother
				else if(courses.get(i).getCourseName().equals(courseName) && courses.get(i).getSection().equals(section)) {
					break;
				}
			}
			//asks what part of the course the user should edit
			System.out.println("What part of " + courseName + " would you like to edit? ");
			System.out.println("1. Instructor name");
			System.out.println("2. Section number");
			System.out.println("3. Location");
			String choice = scan.nextLine();
			
		
			for (int i=0;i<courses.size();i++) {
				//changes the instructor if user chose 1
				if (courses.get(i).getCourseName().equals(courseName) && (choice.equals("1"))) {
					System.out.println("Who is the new instructor for this course?");
					String instructor = scan.nextLine();
					courses.get(i).setInstructor(instructor);
					System.out.println("Success! The new instructor has been changed to " + instructor+".");
					break;
				}
				//changes the section number if the user chose 2
				else if (courses.get(i).getCourseName().equals(courseName) && (choice.equals("2"))) {
					System.out.println("What would you like to change this section number to?");
					String sectionNew = scan.nextLine();
					courses.get(i).setSection(sectionNew);
					System.out.println("Success! The new section has been changed to " + sectionNew+".");
					break;
				}
					
				//changes the location if the user chose 3
				else if (courses.get(i).getCourseName().equals(courseName) && (choice.equals("3"))) {
					System.out.println("Where would you like to change the course location to?");
					String location = scan.nextLine();
					courses.get(i).setLocation(location);
					System.out.println("Success! The new location has been changed to " + location+".");
					break;
				}
				// if user didnt choose 1-3, then print that it's an invalid selection.
				else {
					counter1+=1;
					if (counter1==courses.size()) {
						System.out.println("Invalid selection, please try again.");
					}
					
				}
				
			}
			break;
		}
		
		
		
	}
	
	
	
	public void editCourseGUI(CourseList c, int pos, int buttonChosen) {
		
		ArrayList<Course> courses  = c.courses;
		
		String max = EditCourseTwoAdmin.getMaxStudentsText().getText();
		String location = EditCourseTwoAdmin.getLocationText().getText();
		String section = EditCourseTwoAdmin.getSectionText().getText();
		String instructor = EditCourseTwoAdmin.getInstructorText().getText();
		
		EditCourseTwoAdmin.contentPane.remove(EditCourseTwoAdmin.getLblPleaseEnterA());
		EditCourseTwoAdmin.contentPane.remove(EditCourseTwoAdmin.getLblPleaseEnterA2());
		EditCourseTwoAdmin.contentPane.remove(EditCourseTwoAdmin.getLblThisSectionNumber());
		EditCourseTwoAdmin.contentPane.remove(EditCourseTwoAdmin.getLblYourCourseHas());
		
		EditCourseTwoAdmin.contentPane.setVisible(false);
		EditCourseTwoAdmin.contentPane.setVisible(true);
		
		
		if(buttonChosen==1) {
			try {	
				int maximum = Integer.parseInt(max);
				courses.get(pos).setMaxStudents(maximum);
				EditCourseTwoAdmin.contentPane.add(EditCourseTwoAdmin.getLblYourCourseHas());
			}
			catch(Exception e) {
				EditCourseTwoAdmin.contentPane.add(EditCourseTwoAdmin.getLblPleaseEnterA());
				EditCourseTwoAdmin.contentPane.setVisible(false);
				EditCourseTwoAdmin.contentPane.setVisible(true);
			}
		}
		else if(buttonChosen==2) {
			int intCount=0;
			try {
				Integer.parseInt(section);
				
			}
			catch(Exception e) {
				EditCourseTwoAdmin.contentPane.add(EditCourseTwoAdmin.getLblPleaseEnterA2());
				EditCourseTwoAdmin.contentPane.setVisible(false);
				EditCourseTwoAdmin.contentPane.setVisible(true);
				return;
			}
			int sameCount=0;
			System.out.println(sameCount);
			for(int i=0;i<courses.size();i++) {
				if(courses.get(i).getCourseName().equals(courses.get(pos).getCourseName()) && courses.get(i).getSection().equals(EditCourseTwoAdmin.getSectionText().getText()) ) {
					EditCourseTwoAdmin.contentPane.add(EditCourseTwoAdmin.getLblThisSectionNumber());
					EditCourseTwoAdmin.contentPane.setVisible(false);
					EditCourseTwoAdmin.contentPane.setVisible(true);
					return;
				}
			}
			courses.get(pos).setSection(section);
			EditCourseTwoAdmin.contentPane.add(EditCourseTwoAdmin.getLblYourCourseHas());
			EditCourseTwoAdmin.contentPane.setVisible(false);
			EditCourseTwoAdmin.contentPane.setVisible(true);
			
			
		}
		else if(buttonChosen==3) {
			courses.get(pos).setInstructor(instructor);
			EditCourseTwoAdmin.contentPane.add(EditCourseTwoAdmin.getLblYourCourseHas());
		
		}
		else if(buttonChosen==4) {
			courses.get(pos).setLocation(location);
			EditCourseTwoAdmin.contentPane.add(EditCourseTwoAdmin.getLblYourCourseHas());
		}
		
		
		
		
		
	}
	/*
	 * displays information for a given course
	 * @param CourseList object c
	 */
	@Override
	public void courseInfo(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Scanner scan = new Scanner(System.in);
		//gets course ID to look for course
		System.out.println("Please provide the course ID: ");
		String courseID=scan.nextLine();
		
		int counter=0;
		for (int i=0;i<courses.size();i++) {
			//loops through courselist to see if it matches the course ID and print its course name, max # of students, current # of students, list of enrolled students, instructor, and location
			if (courses.get(i).getCourseID().equals(courseID)) {
				System.out.println("Course name: "+ courses.get(i).getCourseName());
				System.out.println("Max # of students: "+ courses.get(i).getMaxStudents());
				System.out.println("Current # of students: "+ courses.get(i).getCurrentStudents());
				//want list of students in 1 line so if there are no students then use println to get a new line, if not use print to continue on the line
				if(courses.get(i).getFirstNames().size()>0) {
					System.out.print("List of enrolled students: ");
				}
				else {
					System.out.println("List of enrolled students: ");
				}
				if(courses.get(i).getCourseID().equals(courseID)) {
					for (int n=0; n<courses.get(i).getFirstNames().size();n++) {
						counter+=1;
						//if the counter is up to the last element in the course name list then use println and don't include a comma
						if (counter==courses.get(i).getFirstNames().size()) {
							System.out.println(courses.get(i).getFirstNames().get(n)+ " "+ courses.get(i).getLastNames().get(n));
						}
						//if the counter is not at the last element then use print to continue on the line and add a comma
						else {
							System.out.print(courses.get(i).getFirstNames().get(n)+ " "+ courses.get(i).getLastNames().get(n)+", ");
						}
						
					}
						
				}
				System.out.println("Instructor: "+ courses.get(i).getInstructor());
				System.out.println("Location: "+ courses.get(i).getLocation());
			}
		}
	}
	
	public void courseInfoGUI(CourseList c, int pos) {
		ArrayList<Course> courses  = c.courses;
		
		
		String print =" \n";
		
			print+=("     Course Name:"+" "+courses.get(pos).getCourseName()+ "\n");
			print+=("     Instructor: "+courses.get(pos).getInstructor()+"\n");
			print+=("     Course ID: "+courses.get(pos).getCourseID()+"\n");
			print+=("     Amount Enrolled: "+ courses.get(pos).getCurrentStudents()+"\n");
			print+=("     Max Enrollment: "+ Integer.toString(courses.get(pos).getMaxStudents())+"\n");

			print+=("     Registered Students: ");
			for (int n=0; n<courses.get(pos).getFirstNames().size();n++) {
				if(n==courses.get(pos).getFirstNames().size()-1 ) {
					print+=(courses.get(pos).getFirstNames().get(n)+" "+courses.get(pos).getLastNames().get(n));
				}
				else {
					print+=(courses.get(pos).getFirstNames().get(n)+" "+courses.get(pos).getLastNames().get(n)+", ");
				}
				
				
			}
			

		JTextArea textArea = new JTextArea(print);
		textArea.setBackground((new Color(119, 136, 153)));
		textArea.setBounds(6, 135, 480, 135);
		textArea.setEditable(false);
		
		
		
		CourseInfoTwoAdmin.contentPane.add(textArea);
	}

	/*
	 * registers a student in a class
	 * @param CourseList object c
	 */
	@Override
	public void register() {
			//get username, password, firstname, last name, and id
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter student's username: ");
			String username=scan.nextLine();
			System.out.println("Please enter student's password: ");
			String password=scan.nextLine();
			System.out.println("Please enter student's first name: ");
			String firstName=scan.nextLine();
			System.out.println("Please enter student's last name: ");
			String lastName=scan.nextLine();
			System.out.println("Please enter student's ID:");
			String ID = scan.nextLine();
			//check if username exists
			for(int i=0;i<studentRegistered.size();i++) {
				if(studentRegistered.get(i).getUsername().toLowerCase().equals(username.toLowerCase())) {
					System.out.println("Sorry, this username already exists. Please try again.");
					return;
				}
				
				
			}
			//check if ID exists
			for(int i=0;i<studentRegistered.size();i++) {
				if(studentRegistered.get(i).getID().equals(ID)) {
					System.out.println("Sorry, this ID already exists. Please try again.");
					return;
				}
				
				
			}
			//if they dont exist, create the student and add it to the studentRegistered list of student objects
			studentRegistered.add(new Student(username, password, firstName, lastName, ID));
			
			
			
			
		
		
	}
	
	public void registerGUI() {
		
		
		lblCongrats = new JLabel("Congrats! "+ NewStudentAdmin.getFirstText().getText() +" "+  NewStudentAdmin.getLastText().getText()+" has been added.");
		lblCongrats.setBounds(72, 356, 347, 16);
		
		
		
		String firstName = NewStudentAdmin.getFirstText().getText();
		String lastName = NewStudentAdmin.getLastText().getText();
		String username = NewStudentAdmin.getUserText().getText();
		String password = NewStudentAdmin.getPassText().getText();
		String ID = NewStudentAdmin.getIdText().getText();
		
		
//		NewStudentAdmin.contentPane.remove(lblCongrats);
		NewStudentAdmin.contentPane.remove(NewStudentAdmin.getLabel());
		
		NewStudentAdmin.contentPane.remove(NewStudentAdmin.getLblThisUsernameAlready());

		NewStudentAdmin.contentPane.remove(NewStudentAdmin.getLblNumber());
		NewStudentAdmin.contentPane.setVisible(false);
		NewStudentAdmin.contentPane.setVisible(true);
		
		int sameID = 0;
		int sameUser= 0;
		
		
		for(int i=0;i<studentRegistered.size();i++) {
			if(studentRegistered.get(i).getUsername().toLowerCase().equals(username.toLowerCase())) {
				sameUser++;
			}
			
			if(studentRegistered.get(i).getID().equals(ID)) {
				sameID++;
	
			}
		}
		
		
		if(sameID>0 && sameUser==0) {
			NewStudentAdmin.contentPane.add(NewStudentAdmin.getLabel());
			NewStudentAdmin.contentPane.setVisible(false);
			NewStudentAdmin.contentPane.setVisible(true);
			
		}
		else if(sameUser>0 && sameID==0) {
			NewStudentAdmin.contentPane.add(NewStudentAdmin.getLblThisUsernameAlready());
			NewStudentAdmin.contentPane.setVisible(false);
			NewStudentAdmin.contentPane.setVisible(true);
			
		}
		else if(sameUser>0 && sameID>0) {
			NewStudentAdmin.contentPane.add(NewStudentAdmin.getLblThisUsernameAlready());
			
			NewStudentAdmin.contentPane.setVisible(false);
			NewStudentAdmin.contentPane.setVisible(true);
			
			NewStudentAdmin.contentPane.add(NewStudentAdmin.getLabel());
			NewStudentAdmin.contentPane.setVisible(false);
			NewStudentAdmin.contentPane.setVisible(true);
			
		}
		
		else {
			try {
				
				Integer.parseInt(ID);
				//if they dont exist, create the student and add it to the studentRegistered list of student objects
				studentRegistered.add(new Student(username, password, firstName, lastName, ID));
				
				
				NewStudentAdmin.contentPane.add(lblCongrats);
				
				
				
			}
			catch(Exception e) {
				NewStudentAdmin.contentPane.add(NewStudentAdmin.getLblNumber());
				
			}
		}
		
		
		
	
	
}
	/*
	 * shows all courses including their roster, # students enrolled, and max students
	 * @param CourseList object c
	 */
	@Override
	public void viewAll(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		int counter1=0;
		//want list of students in 1 line so if there are no students then use println to get a new line, if not use print to continue on the line
		for (int i=0;i<courses.size();i++) {
			System.out.println(courses.get(i).getCourseName());
			
			if (courses.get(i).getFirstNames().size()>0) {
				System.out.print("Roster: ");
			}
			else {
				System.out.println("Roster:");
			}
			for (int n=0; n<courses.get(i).getFirstNames().size();n++) {
				counter1+=1;
				//if the counter is up to the last element in the course name list then use println and don't include a comma

				if (counter1==courses.get(i).getFirstNames().size()) {
					//print first names and last names and 
					System.out.print(courses.get(i).getFirstNames().get(n)+ " "+ courses.get(i).getLastNames().get(n)+" (ID: ");
					for (int j=0;j<this.studentRegistered.size();j++) {
						
						//if the student list's registered classes has the course and the course list has the students then print the student's id and close off with a parenthases
						if (this.studentRegistered.get(j).getRegisteredClasses().contains(courses.get(i).getCourseName()) && courses.get(i).getFirstNames().get(n).equals(this.studentRegistered.get(j).getFirstName()) && courses.get(i).getLastNames().get(n).equals(this.studentRegistered.get(j).getLastName()) ) {
							
							System.out.println(this.studentRegistered.get(j).getID()+")");
							counter1=0;
							
						}
					}
					
				}
				//if it's not up to the last element, use print and include a comma cause it'll keep getting ppl
				else {
					//print first and last name 
					System.out.print(courses.get(i).getFirstNames().get(n)+ " "+ courses.get(i).getLastNames().get(n)+" (ID: ");
					for (int j=0;j<this.studentRegistered.size();j++) {
						if (this.studentRegistered.get(j).getRegisteredClasses().contains(courses.get(i).getCourseName()) && courses.get(i).getFirstNames().get(n).equals(this.studentRegistered.get(j).getFirstName()) && courses.get(i).getLastNames().get(n).equals(this.studentRegistered.get(j).getLastName())) {
							//if the student list's registered classes has the course and the course list has the students then print the student's id and close off with a parenthases and add a comma

							System.out.print(this.studentRegistered.get(j).getID()+"), ");
							
						}
					}
				}
				
				
					
							
			}
			System.out.println("Number of students enrolled: "+courses.get(i).getCurrentStudents());
			System.out.println("Maximum enrollment: "+courses.get(i).getMaxStudents());
			System.out.println(" ");
		}
		
	}
	
	
	/*
	 * shows all courses including their roster, # students enrolled, and max students
	 * @param CourseList object c
	 */
	@Override
	public void viewAllGUI(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		
		
		String print =" \n";
		for (int i=0;i<courses.size();i++) {
			print+=("        Course Name:"+" "+courses.get(i).getCourseName()+ "\n");
			print+=("        Amount Enrolled: "+ courses.get(i).getCurrentStudents()+"\n");
			print+=("        Max Enrollment: "+ Integer.toString(courses.get(i).getMaxStudents())+"\n");
			print+=("        Registered Students: ");
			for (int n=0; n<courses.get(i).getFirstNames().size();n++) {
				if(n==courses.get(i).getFirstNames().size()-1 ) {
					print+=(courses.get(i).getFirstNames().get(n)+" "+courses.get(i).getLastNames().get(n));
				}
				else {
					print+=(courses.get(i).getFirstNames().get(n)+" "+courses.get(i).getLastNames().get(n)+", ");
				}
				
				
			}
			
			print+="\n";
			print+="----------------------------------------------------------------------------";
			print+="\n";
			
			
			
		}
		
		
		
		
		JTextArea textArea = new JTextArea(print);
		textArea.setBackground((new Color(119, 136, 153)));
		
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(-16, 84, 496, 384);
		
		
		AllCoursesAdmin.contentPane.add(scrollPane);
		
	}
	/*
	 * shows all full courses
	 * @param CourseList object c
	 */
	@Override
	public void viewFull(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		int counter=0;
		//check how many classes are full
		for (int i=0;i<courses.size();i++) {
			if (courses.get(i).getCurrentStudents()== courses.get(i).getMaxStudents()) {
				counter+=1;
			}
		}
		//if none are full then print that there arent any
		if (counter==0) {
			System.out.println("There are no full courses.");
		}
		//if there are full classes, loop through and print the full ones
		else {
			System.out.println("Here is a list of full courses:");
		}
		for (int i=0;i<courses.size();i++) {
			if (courses.get(i).getCurrentStudents()== courses.get(i).getMaxStudents()) {
				System.out.println(courses.get(i).getCourseName());
			}
		}
		
	}
	public void viewFullGUI(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		int counter=0;
		String print =" \n";
		//check how many classes are full
		for (int i=0;i<courses.size();i++) {
			if (courses.get(i).getCurrentStudents()== courses.get(i).getMaxStudents()) {
				counter+=1;
			}
		}
		if (counter==0) {
			ViewFullAdmin.contentPane.add(ViewFullAdmin.getLblNoFull());
		}
		else {
			ViewFullAdmin.contentPane.add(ViewFullAdmin.getLblHereIsA());
		}
		for (int i=0;i<courses.size();i++) {
			if (courses.get(i).getCurrentStudents()== courses.get(i).getMaxStudents()) {
				
				
					print+=("        Course Name:"+" "+courses.get(i).getCourseName()+ "\n");
					print+=("        Amount Enrolled: "+ courses.get(i).getCurrentStudents()+"\n");
					print+=("        Max Enrollment: "+ Integer.toString(courses.get(i).getMaxStudents())+"\n");
					print+=("        Registered Students: ");
					for (int n=0; n<courses.get(i).getFirstNames().size();n++) {
						if(n==courses.get(i).getFirstNames().size()-1 ) {
							print+=(courses.get(i).getFirstNames().get(n)+" "+courses.get(i).getLastNames().get(n));
						}
						else {
							print+=(courses.get(i).getFirstNames().get(n)+" "+courses.get(i).getLastNames().get(n)+", ");
						}
						
						
					}
					
					print+="\n";
					print+="----------------------------------------------------------------------------";
					print+="\n";

				
			}
			
		}
		JTextArea textArea = new JTextArea(print);
		textArea.setBackground((new Color(119, 136, 153)));
		
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(-16, 100, 496, 384);
		
		
		ViewFullAdmin.contentPane.add(scrollPane);
		
			
		
		
	}
	/*
	 * writes all full courses to a file
	 * @param CourseList object c
	 */
	@Override
	public void writeFull(CourseList c) {
		try {
			
			ArrayList<Course> courses  = c.courses;
			//make file
			BufferedWriter file = new BufferedWriter(new FileWriter("FullCourses.txt"));
			for (int i=0;i<courses.size();i++) {
				//write each full course using the toString method
				if (courses.get(i).getCurrentStudents()==courses.get(i).getMaxStudents()) {
					file.write(courses.get(i).toString());
					
					
				}
			}
			//if it worked, say that it worked.
			System.out.println("You have successfuly written to a file of full courses.");
			file.close();
		}
		catch(Exception e){
			//say that there was an error
			System.out.println("The file could not be written.");
		}
		
		
	}
	public void writeFullGUI(CourseList c) {
		try {
			ArrayList<Course> courses  = c.courses;
			//make file
			BufferedWriter file = new BufferedWriter(new FileWriter("FullCourses.txt"));
			for (int i=0;i<courses.size();i++) {
				//write each full course using the toString method
				if (courses.get(i).getCurrentStudents()==courses.get(i).getMaxStudents()) {
					file.write(courses.get(i).toString());
					
				}
			}
			//if it worked, say that it worked.
			WriteFileAdmin.contentPane.add(WriteFileAdmin.getLblTheFileHas());
			file.close();
				
			}
		catch(Exception e) {
			WriteFileAdmin.contentPane.add(WriteFileAdmin.getLblTheFileCould());
		
		}
	}
	/*
	 * view all registered students in a course
	 * @param CourseList object c
	 */
	@Override
	public void viewRegistered(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Scanner scan = new Scanner(System.in);
		System.out.println("What course would you like to view the roster for? ");
		String course=scan.nextLine();
		System.out.println("What section of course "+ course +" would you like to view the roster for? ");
		String section=scan.nextLine();
		int counter1=0;
		int counter2=0;
		int sameCounter=0; //amount of duplicates
		int otherSameCounter=0; //counter to see how many duplicates its looped through in the for loop
		//check the amount of duplicatess
		for (int i=0;i<courses.size();i++) {
			if (courses.get(i).getCourseName().equals(course)) {
				sameCounter+=1;
			}
		}
		for (int i=0;i<courses.size();i++) {
			
			counter2+=1;
			//if the section and course equal the inputs
			if(courses.get(i).getCourseName().equals(course) && courses.get(i).getSection().equals(section)) {
				//pring out the roster in the same line
				System.out.println("Here is the roster for "+course +": ");
				for (int n=0; n<courses.get(i).getFirstNames().size();n++) {
					
						
					counter1+=1;
					//if its the last element in the arraylist then use println and dont add a comma and print out the names
					if (counter1==courses.get(i).getFirstNames().size()) {
						System.out.println(courses.get(i).getFirstNames().get(n)+ " "+ courses.get(i).getLastNames().get(n));
						
					}
					//if its not the last element in the arraylist then use print, add a comma, and print out the names

					else {
						
						System.out.print(courses.get(i).getFirstNames().get(n)+ " "+ courses.get(i).getLastNames().get(n)+", ");
					}
					
							
				}
				break;
				
							
					
				
				
			}
			//if the course is right but there is no section the print that there's no course with the section
			else if(courses.get(i).getCourseName().equals(course) && (courses.get(i).getSection().equals(section)==false) ){
				otherSameCounter+=1;
				if (otherSameCounter==sameCounter) { //checks to see if it's looped through all types of the same name 
					System.out.println("There is no course "+ course+" with the section "+section+".");
					break;
				}
				
				
			}
			//if it's gone through all and there aren't any courses with the name then say the course doesnt exist
			else if (courses.get(i).getCourseName().equals(course)==false && counter2==courses.size() ) {
				System.out.println("Sorry this course does not exist.");
				
			}
			
		}
			

		
		
	}
	
	public void viewRegisteredGUI(CourseList c, int pos) {
		ArrayList<Course> courses  = c.courses;
		String print="\n";
		for (int i=0; i<courses.get(pos).getFirstNames().size();i++) {
			print+=("   •"+courses.get(pos).getFirstNames().get(i)+" "+courses.get(pos).getLastNames().get(i)+"\n");
	
		}
		
		JTextArea textArea = new JTextArea(print);
		textArea.setBackground((new Color(119, 136, 153)));
		
		textArea.setEditable(false);
		textArea.setBackground((new Color(119, 136, 153)));
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0, 100, 479, 157);
		
		
		CourseRosterTwoAdmin.contentPane.add(scrollPane);
		
	}
	/*
	 * views all courses a given student is registered in
	 * @param CourseList object c
	 */
	@Override
	public void viewStudentCourses(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input student's first name:");
		String firstName=scan.nextLine();
		System.out.println("Please input student's last name:");
		String lastName = scan.nextLine();
		System.out.println("Please input student's ID:");
		String ID = scan.nextLine();
		int k=0;
		for (int i=0;i<courses.size();i++) {
			if (courses.get(i).getLastNames().size()>0) {
				for (int n=0; n<courses.get(i).getLastNames().size();n++) {
					
					if (courses.get(i).getFirstNames().get(n).equals(firstName) && courses.get(i).getLastNames().get(n).equals(lastName)) {
						k+=1;
					}
				}
			}
			
		}
		if(k==0) {
			System.out.println("Sorry, this student is not enrolled in any courses.");
		}
		else {
			System.out.println("Here are "+ firstName + " "+lastName+"'s courses:");
			for (int i=0;i<courses.size();i++) {
				if (courses.get(i).getLastNames().size()>0) {
					for (int n=0; n<courses.get(i).getLastNames().size();n++) {
						
						if (courses.get(i).getFirstNames().get(n).equals(firstName) && courses.get(i).getLastNames().get(n).equals(lastName)) {
							System.out.println(courses.get(i).getCourseName());
							k+=1;
						}
					}
				}
				
			}
		}
		
	}
	
	public void viewStudentCoursesGUI(CourseList c, int pos) {
		ArrayList<Course> courses  = c.courses;
		String print="\n";
		for (int i=0;i<courses.size();i++) {
			if (courses.get(i).getLastNames().size()>0) {
				for (int n=0; n<courses.get(i).getLastNames().size();n++) {
					
					if (courses.get(i).getFirstNames().get(n).equals(studentRegistered.get(pos).getFirstName()) && courses.get(i).getLastNames().get(n).equals(studentRegistered.get(pos).getLastName())) {
							print+=("        Course Name:"+" "+courses.get(i).getCourseName()+ "\n");
							print+=("        Course ID: "+courses.get(i).getCourseID()+"\n");
							print+=("        Instructor: "+courses.get(i).getInstructor()+"\n");
							print+=("        Amount Enrolled: "+ courses.get(i).getCurrentStudents()+"\n");
							print+=("        Max Enrollment: "+ Integer.toString(courses.get(i).getMaxStudents())+"\n");
							print+="\n";
							print+="----------------------------------------------------------------------------";
							print+="\n";
					}
				}
			}
			
		}
		
		JTextArea textArea = new JTextArea(print);
		textArea.setBackground((new Color(119, 136, 153)));
		
		textArea.setEditable(false);
		textArea.setBackground((new Color(119, 136, 153)));
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(-16, 100, 496, 384);
		
		
		StudentCoursesTwoAdmin.contentPane.add(scrollPane);
	}

	
	/*
	 * sorts all courses by # of registered students
	 * @param CourseList object c
	 */
	@Override
	public void sortCourses(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Course temp;
		//loop through courses using 2 loops. second loop starts with the second element
		for (int i=0; i<courses.size();i++) {
			for (int j=i+1;j<courses.size();j++) {
				//if the amount of students are less, then change them and set it underneath
				if(courses.get(i).getCurrentStudents()< courses.get(j).getCurrentStudents()) {
					temp = courses.get(i);
					courses.set(i, courses.get(j));
					courses.set(j, temp);
				}
			}
		}
		//print out sorted courses
		System.out.println("Your courses have been sorted. Here they are:");
		for (int i=0; i<courses.size();i++) {
			System.out.println(courses.get(i).getCourseName());
		}
		
	}
	
	
	public void sortCoursesGUI(CourseList c) {
		ArrayList<Course> courses  = c.courses;
		Course temp;
		//loop through courses using 2 loops. second loop starts with the second element
		for (int i=0; i<courses.size();i++) {
			for (int j=i+1;j<courses.size();j++) {
				//if the amount of students are less, then change them and set it underneath
				if(courses.get(i).getCurrentStudents()< courses.get(j).getCurrentStudents()) {
					temp = courses.get(i);
					courses.set(i, courses.get(j));
					courses.set(j, temp);
				}
			}
		}
		String print =" \n";
		for (int i=0;i<courses.size();i++) {
			print+=("        Course Name:"+" "+courses.get(i).getCourseName()+ "\n");
			print+=("        Amount Enrolled: "+ courses.get(i).getCurrentStudents()+"\n");
			print+=("        Max Enrollment: "+ Integer.toString(courses.get(i).getMaxStudents())+"\n");
			print+=("        Registered Students: ");
			for (int n=0; n<courses.get(i).getFirstNames().size();n++) {
				if(n==courses.get(i).getFirstNames().size()-1 ) {
					print+=(courses.get(i).getFirstNames().get(n)+" "+courses.get(i).getLastNames().get(n));
				}
				else {
					print+=(courses.get(i).getFirstNames().get(n)+" "+courses.get(i).getLastNames().get(n)+", ");
				}
				
				
			}
			
			print+="\n";
			print+="----------------------------------------------------------------------------";
			print+="\n";
			
			
			
		}
		
		
		
		
		JTextArea textArea = new JTextArea(print);
		textArea.setBackground((new Color(119, 136, 153)));
		
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(-16, 100, 496, 384);
		
		SortAdmin.contentPane.add(scrollPane);
	}
	/*
	 * exits out of the program
	 */
	@Override
	public void exit() { 
		
		//exit the system.
		System.exit(0);
		
	}


	/**
	 * @return the studentRegistered
	 */
	public ArrayList<Student> getStudentRegistered() {
		return studentRegistered;
	}
	


	


	
}
