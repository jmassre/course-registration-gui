/*
 * The User class represents each user
 * @author Joseph Massre
 * @version 1
 */

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	
	private static final long serialVersionUID = -3233757389292143684L;
	
	//properties
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	//constructor
	public User(String username, String password) {
		setUsername(username);
		setPassword(password);
		
	}

	
	/*
	 * gets username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/*
	 * sets username
	 * @param username to set username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/*
	 * gets password
	 *@return password
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * sets password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * gets first name
	 * @return firsName
	 */
	public String getFirstName() {
		return firstName;
	}

	/*
	 * sets first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * gets last name
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * sets last name
	 * @param last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
