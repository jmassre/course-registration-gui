/**
 * Program to run course registration system. Two types of users are students and an admin. Uses serialization to save all information including courses and students.
 * In order to run, admin must create the student accounts. 
 * @author Joseph Massre
 * @version 0.1 
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Run  {

	private JFrame frame;
	private JPanel panel;
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton button;
	private JLabel success;

	
	
	//creates an admin object with user Admin and pass Admin001
			static Admin teacher = new Admin("Admin", "Admin001");
			static CourseList c = null;
			
			//filename
	        static String filename = "SerializedFromGithub.ser"; 
	        static File f = new File(filename);
	    public static void main(String[] args)  throws IOException {
		
		
		
	
		
		
        
     
        try
        {    
        	//if this isn't the first time deserializing and there's a file that exists then make the input stream to an object
        	//and deserealize
        	
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
            

            teacher = (Admin) in.readObject();
            c = (CourseList) in.readObject();
            in.close(); 
            file.close(); 
          

            
        } 
          
        catch(Exception ex) { 
        	
        	
        	try {
        		//if this is the first time deserializing and there is no file:
            	if (f.exists()==false) {
            		//get the file
            		Scanner data = new Scanner(new File("MyUniversityCourses.csv"));
            		int amount = 0;
            		//get the amount of rows
            		while (data.hasNextLine() ) {
            			data.nextLine();
            			amount+=1;
            			
            		}
            		data.close();
            		
            		data = new Scanner(new File("MyUniversityCourses.csv"));
            		
            		//create multidimensional array with same amount of rows in the CSV
            		String[][] lines = new String[amount][];
            		int counter = 0;
            		//within the array, each row has x columns
            		while( data.hasNextLine()) {
            			lines[counter]=data.nextLine().split(",");
            			
            			counter +=1;
            		}
            		
            		c = new CourseList(new ArrayList<Course>());
    	            
    	
    	            for (int i=1;i<amount;i++) {
    	                c.courses.add(new Course(lines[i][0],lines[i][1],Integer.parseInt(lines[i][2]),Integer.parseInt(lines[i][3]),new ArrayList<String>(),new ArrayList<String>(),lines[i][5],lines[i][6], lines[i][7]));
    	                	
    	            }
    	          //Saving of object in a file 
    	            FileOutputStream file = new FileOutputStream(filename); 
    	            ObjectOutputStream out = new ObjectOutputStream(file);
    	            out.writeObject(c);
    	            out.close(); 
    	            file.close(); 
    	            
            	}
            	//Saving of object in a file 
	            FileOutputStream file = new FileOutputStream(filename); 
	            ObjectOutputStream out = new ObjectOutputStream(file);
            	
            } 
              
            catch(IOException hi){ 
                System.out.println("IOException is caught right here."); 
            } 
        } 
          
        
       
        
        
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the University Course Registration System!");
		
		//create a loop that keeps going until the user exits
		while (true) {
			//see if the user is student or admin
			System.out.println("Are you a student or an admin?");
			String type = scan.nextLine();
			//case insensitive
			type = type.toLowerCase();
			//if user is student:
			if (type.equals("student")) {
				System.out.println("Username:");
				String studentUser = scan.nextLine();
				studentUser = studentUser.toLowerCase(); //case insensitive
				System.out.println("Password: ");
				String studentPass = scan.nextLine();
				int counter=0;
				//find the user with the inputted username and password
				for (int i=0;i<teacher.studentRegistered.size();i++) {
					counter+=1;
					if(teacher.studentRegistered.get(i).getUsername().toLowerCase().equals(studentUser) && teacher.studentRegistered.get(i).getPassword().equals(studentPass)) {
						System.out.println("Welcome, "+teacher.studentRegistered.get(i).getFirstName()+"! Please choose an action:");
						while (true) {
							System.out.println("1. View all courses");
							System.out.println("2. View open courses");
							System.out.println("3. Register in a course");
							System.out.println("4. Withdraw from a course");
							System.out.println("5. View your registered classes");
							System.out.println("6. Exit");
							String action = scan.nextLine();
							//see what the choice was and perform Student method by going to the admin's arraylist of student objects and accessing it through that
							if (action.equals("1")){
								teacher.studentRegistered.get(i).viewAll(c);
							}
							else if (action.equals("2")) {
								teacher.studentRegistered.get(i).viewOpen(c);
							}
							else if (action.equals("3")) {
								teacher.studentRegistered.get(i).register(c);
							}
							else if (action.equals("4")) {
								teacher.studentRegistered.get(i).withdraw(c);
							}
							else if (action.equals("5")){
								teacher.studentRegistered.get(i).viewRegistered();
							}
							else if (action.equals("6")) {
								//serialization
								FileOutputStream file = new FileOutputStream(filename); 
					            ObjectOutputStream out = new ObjectOutputStream(file);
					            //write to the teacher object
				            	out.writeObject(teacher);
				            	//write to the courselist
				            	out.writeObject(c);
				            	out.close();
								file.close();
								teacher.studentRegistered.get(i).exit();
							}	
							else {
								//if the user doesn't enter 1-6 then redo it
								System.out.println("Invalid response. Please try again.");
							}
						}	
						}
							//if there was no student found with the username and password then tell user to try again and loop through over again
						else if (counter==teacher.studentRegistered.size()){
							System.out.println("Invalid username/password. Please try again.");
						}
			
				}
				
			
				
			}
			//if the user inputted admin:
			else if (type.equals("admin")){
				//ask for user and password
				System.out.println("Username: ");
				String adminUser = scan.nextLine();
				System.out.println("Password: ");
				String adminPass = scan.nextLine();
				adminUser=adminUser.toLowerCase(); //case insensitive
				//check if user and pass is admin and admin001
				if(adminUser.toLowerCase().equals("admin") && adminPass.equals("Admin001")) {
				
					System.out.println("Welcome, admin! Please choose an action:");
					//choose an action 
					while (true){
						System.out.println("1.  Create a new course");
						System.out.println("2.  Remove a course");
						System.out.println("3.  Edit a course");
						System.out.println("4.  Examine course information");
						System.out.println("5.  Register a new student");
						System.out.println("6.  View all courses");
						System.out.println("7.  View full courses");
						System.out.println("8.  Write to a file a list of courses that are full");
						System.out.println("9.  View roster for specific courses");
						System.out.println("10. View a given student's courselist");
						System.out.println("11. Sort courses by class size");
						System.out.println("12. Exit");
						String action = scan.nextLine();
						if(action.equals("1")) {
							c.newcourse();
						}
						else if (action.equals("2")) {
							teacher.deleteCourse(c);
						}
						else if (action.equals("3")) {
							teacher.editCourse(c);
						}
						else if (action.equals("4")) {
							teacher.courseInfo(c);
						}
						else if (action.equals("5")) {
							teacher.register();
							 
						}
						else if (action.equals("6")) {
							teacher.viewAll(c);
						}
						else if (action.equals("7")) {
							teacher.viewFull(c);
						}
						else if (action.equals("8")) {
							teacher.writeFull(c);
						}
						else if (action.equals("9")) {
							teacher.viewRegistered(c);
						}
						else if (action.equals("10")) {
							teacher.viewStudentCourses(c);
						}
						else if (action.equals("11")) {
							teacher.sortCourses(c);
						}
						else if (action.equals("12")) {
							
						
							FileOutputStream file = new FileOutputStream(filename); 
						    ObjectOutputStream out = new ObjectOutputStream(file);
						    out.writeObject(teacher);
						    out.writeObject(c);
						    out.close();
						    file.close();
								
						    teacher.exit();
						
							
							
							
							
						}
						//if user typed something other than 1-12, reloop and try again
						else {
							
							System.out.println("Invalid response. Please try again.");
						}
					}
					}
					//if user inputted wrong user/pass, ask them to try again and reloop
					else {
						System.out.println("Invalid username/password. Please try again!");
						
					
						}
			}
			//if user inputted something other than admin or student tell them to try agian
			else {
				System.out.println("Invalid response. Please try again!");
				
			}
			
		}
		
			
		
		
	

	}
	

	
	
	

}
