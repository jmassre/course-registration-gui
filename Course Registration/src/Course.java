/*  
 * The Course class represents each course
 * @author Joseph Massre
 * @version 1
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Course implements Serializable{
	//properties
	static final long serialVersionUID = 42L;
	private String courseName;
	private String courseID;
	private int maxStudents;
	private int currentStudents;
	private ArrayList<String> firstNames = new ArrayList<String>();
	private ArrayList<String> lastNames = new ArrayList<String>();
	private String instructor;
	private String section;
	private String Location;

	//constructor sets each course object with its respective properties
	public Course(String courseName, String courseID, int maxStudents, int currentStudents, ArrayList<String> firstNames, ArrayList<String> lastNames, String instructor, String section, String Location) {
		this.setCourseName(courseName);
		this.setCourseID(courseID);
		this.setCurrentStudents(currentStudents);
		this.setFirstNames(firstNames);
		this.setLastNames(lastNames);
		this.setInstructor(instructor);
		this.setSection(section);
		this.setLocation(Location);
		this.setMaxStudents(maxStudents);
		
	}
	
	//overloaded constructor
	public Course() {
		
	}
	

	/*
	 * gets the course name
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/*
	 * sets the course name
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/*
	 * gets the course ID
	 * @return courseID
	 */
	public String getCourseID() {
		return courseID;
	}

	/*
	 * sets the course ID
	 * @param courseID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/*
	 * gets the current amount of students
	 * @return currentStudents
	 */
	public int getCurrentStudents() {
		return currentStudents;
	}
	
	
	/*
	 * sets the current amount of students
	 * @param currentStudents to set the current amount of students
	 */
	public void setCurrentStudents(int currentStudents) {
		this.currentStudents = currentStudents;
	}

	/*
	 * gets the course arraylist of first names
	 * @return firstNames
	 */
	public ArrayList<String> getFirstNames() {
		return firstNames;
	}
	/*
	 * sets the course arraylist of first names
	 * @param firstNames
	 */
	public void setFirstNames(ArrayList<String> firstNames) {
		this.firstNames = firstNames;
	}

	/*
	 * gets the course arraylist of last names
	 * @return lastNames
	 */
	public ArrayList<String> getLastNames() {
		return lastNames;
	}
	/*
	 * sets the course arraylist of last names
	 * @param lastNames
	 */
	public void setLastNames(ArrayList<String> lastNames) {
		this.lastNames = lastNames;
	}
	
	/*
	 * gets the course instructor
	 * @return instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	/*
	 * sets the course instructor
	 * @param instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/*
	 * gets the course section
	 * @return section
	 */
	public String getSection() {
		return section;
	}

	/*
	 * sets the course section
	 * @return section
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/*
	 * gets the course location
	 * @return location
	 */
	public String getLocation() {
		return Location;
	}

	/*
	 * sets the course location
	 * @return location
	 */
	public void setLocation(String location) {
		Location = location;
	}
	/*
	 * gets the max number of students possible in a course
	 * @return maxStudents
	 */
	public int getMaxStudents() {
		return maxStudents;
	}

	/*
	 * sets the cap amount of students
	 * @param maxStudents
	 */
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}



	
	
	
	
}
