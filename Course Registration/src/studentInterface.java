/*
 * An interface whose methods should be implemented by the Student class.
 * @author Joseph Massre
 * @version 1
 */
public interface studentInterface {
	
	/*
	 * Allows student to view all courses in registrar.
	 * @param CourseList object c
	 */
	public abstract void viewAll(CourseList c);
	
	/*
	 * Allows student to view all open courses.
	 * @param CourseList object c
	 */
	public abstract void viewOpen(CourseList c);
	
	/*
	 * Allows student to register in a course.
	 * @param CourseList object c
	 */
	public abstract void register(CourseList c);
	
	/*
	 * Allows student to withdraw from a course.
	 * @param CourseList object c
	 */
	public abstract void withdraw(CourseList c);
	
	/*
	 * Allows student to view courses they are registered in.
	 * @param CourseList object c
	 */
	public abstract void viewRegistered();
	
	/*
	 * Allows student to exit from program.
	 */
	public abstract void exit();
}
