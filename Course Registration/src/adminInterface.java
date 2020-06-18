/*
 * An interface whose methods should be implemented by the Admin class.
 * @author Joseph Massre
 * @version 1
 */

import java.io.IOException;

public interface adminInterface {
	

	
	/*
	 * deletes course from registrar
	 * @param CourseList object c
	 */
	public abstract void deleteCourse(CourseList c);
	
	/*
	 * allows admin to edit info on course except for course name and course id
	 * @param CourseList object c
	 */
	public abstract void editCourse(CourseList c);
	
	/*
	 * displays information for a given course
	 * @param CourseList object c
	 */
	public abstract void courseInfo(CourseList c);
	
	/*
	 * registers a student in a class
	 * @param CourseList object c
	 */
	public abstract void register();
	
	/*
	 * shows all courses
	 * @param CourseList object c
	 */
	public abstract void viewAll(CourseList c);
	
	/*
	 * shows all full courses
	 * @param CourseList object c
	 */
	public abstract void viewFull(CourseList c);
	
	/*
	 * writes all full courses to a file
	 * @param CourseList object c
	 */
	public abstract void writeFull(CourseList c) ;
	
	/*
	 * view all registered students in a course
	 * @param CourseList object c
	 */
	public abstract void viewRegistered(CourseList c);
	
	/*
	 * views all courses a given student is registered in
	 * @param CourseList object c
	 */
	public abstract void viewStudentCourses(CourseList c);
	
	/*
	 * sorts all courses by # of registered students
	 * @param CourseList object c
	 */
	public abstract void sortCourses(CourseList c);
	
	/*
	 * exits out of the program
	 */
	public abstract void exit();

	void viewAllGUI(CourseList c);
	
	
	
}
