import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.Font;

public class crsgui {
	
	
	private static JFrame frame;	
	private JFrame studentFrame;
	public static Admin teacher = new Admin("Admin", "Admin001");
	public static CourseList c = null;
	
	//filename
    public static String filename = "regiunrginerh.ser"; 
    public static File f = new File(filename);
    ArrayList<Course> courses  = c.courses;
    public static Scanner scan = new Scanner(System.in);
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
	 
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
	    
	    
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crsgui window = new crsgui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
					
	}

	
	
	/**
	 * Create the application.
	 */
	public crsgui() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBackground(new Color(119, 136, 153));
		frame.getContentPane().setLayout(null);
		frame.setBounds(500,100,480,480);
		
		
		//labels
		JLabel lblWelcomeToThe = new JLabel("Welcome to the University Course Registration System!");
		lblWelcomeToThe.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblWelcomeToThe.setBounds(24, 58, 439, 16);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblAreYouA = new JLabel("Are you a student or an admin?");
		lblAreYouA.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblAreYouA.setBounds(116, 93, 253, 16);
		frame.getContentPane().add(lblAreYouA);
		
		//if student
		JButton btnStudent = new JButton("Student");
		btnStudent.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnStudent.setBackground(new Color(128, 128, 128));
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogin studentLogin = new StudentLogin();
				frame.setVisible(false);
				studentLogin.setVisible(true);
				studentLogin.getBtnLogin().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//check if student user and pass matches
						String studentUser = studentLogin.getTextField().getText();
						String studentPass = studentLogin.getPasswordField().getText();
						int counter=0;
						for (int i=0;i<teacher.studentRegistered.size();i++) {
							counter++;
							if(teacher.studentRegistered.get(i).getUsername().toLowerCase().equals(studentUser) && teacher.studentRegistered.get(i).getPassword().equals(studentPass)) {
								counter=teacher.studentRegistered.size()+1;
								//open student menu
								StudentMenu studentMenu = new StudentMenu();
								studentLogin.setVisible(false);
								studentMenu.setVisible(true);
								int studentIndex = i;
								
								
								studentMenu.getBtnLogout().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										System.exit(0);
										
										
									}
								});
								//view all courses
								studentMenu.getBtnViewAll().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ViewAllStudent viewAll = new ViewAllStudent();
										studentMenu.setVisible(false);
										viewAll.setVisible(true);
										
										teacher.studentRegistered.get(studentIndex).viewAllGUI(c);
										
										viewAll.getBtnLogOut().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												teacher.exit();
											}
										});
										viewAll.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												studentMenu.setVisible(true);
												viewAll.setVisible(false);
											}
										});
									}
								});
								
								//view open courses
								studentMenu.getBtnViewOpen().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ViewOpenStudent viewOpen = new ViewOpenStudent();
										studentMenu.setVisible(false);
										viewOpen.setVisible(true);
										teacher.studentRegistered.get(studentIndex).viewOpenGUI(c);
										
									}
								});
								
								//view student's registered courses
								studentMenu.getBtnViewRegistered().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ViewRegisteredStudent viewRegistered = new ViewRegisteredStudent();
										viewRegistered.setVisible(true);
										studentMenu.setVisible(false);
										teacher.studentRegistered.get(studentIndex).viewRegisteredGUI();
										
										//log out
										viewRegistered.getBtnLogOut().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												System.exit(0);
											}
										});
										
										//get main menu
										viewRegistered.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												studentMenu.setVisible(true);
												viewRegistered.setVisible(false);
											}
										});
									}
								});
								
								//register in a course
								studentMenu.getBtnRegister().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										RegisterCourseStudent register = new RegisterCourseStudent();
										studentMenu.setVisible(false);
										register.setVisible(true);
										//get course list
										ArrayList<Course> courses  = c.courses;
										ArrayList<String> courseNames= new ArrayList<String>();
										JList jlist = new JList();
										DefaultListModel list = new DefaultListModel();
										
										//put these courses into default list model
										for(int i=0; i<courses.size();i++) {
											courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
											list.add(i, courseNames.get(i));
											
										}
										
										//put the default list model into j list
										jlist.setModel(list);
										
										
										//put jlist into jscrollpane to scroll through the list
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(36, 82, 240, 321);
										scrollPane.setViewportView(jlist);
										jlist.setLayoutOrientation(JList.VERTICAL);
										
										RegisterCourseStudent.contentPane.add(scrollPane);
										
										//whichever one they choose after clicking register, register them in the course
										register.getBtnRegister().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {												
												int index = jlist.getSelectedIndex();
												
												try {
													teacher.studentRegistered.get(studentIndex).registerGUI(c, index);
													
												}
												catch(Exception f) {
												
												}
												//try and serialize
												try {
													FileOutputStream file = new FileOutputStream(filename); 
												    ObjectOutputStream out = new ObjectOutputStream(file);
												    out.writeObject(teacher);
												    out.writeObject(c);
												    out.close();
												    file.close();
												}
												catch(Exception f) {
													System.out.println("Didnt serialize");
												}
												
												
												register.setVisible(false);
												register.setVisible(true);
											}
										});
										//goes back to main menu by setting menu visible and this pane invisible
										register.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												register.setVisible(false);
												studentMenu.setVisible(true);
											}
										});
										
										
										//logout, exits system
										register.getBtnLogOut().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												System.exit(0);
											}
										});
									}
								});
								
								
								//withdraw from a course
								studentMenu.getBtnWithdraw().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										WithdrawCourseStudent withdraw = new WithdrawCourseStudent();
										studentMenu.setVisible(false);
										withdraw.setVisible(true);
										//get course list
										ArrayList<Course> courses  = c.courses;
										ArrayList<String> courseNames= new ArrayList<String>();
										JList jlist = new JList();
										
										//put these courses into default list model
										DefaultListModel list = new DefaultListModel();
										for(int i=0; i<teacher.studentRegistered.get(studentIndex).getRegisteredClasses().size();i++) {
											courseNames.add(teacher.studentRegistered.get(studentIndex).getRegisteredClasses().get(i).getCourseName()+" (Section: "+teacher.studentRegistered.get(studentIndex).getRegisteredClasses().get(i).getSection()+")");
											list.add(i, courseNames.get(i));
											
										}
										
										
										//put default list model into jlist
										jlist.setModel(list);
										
										
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(36, 82, 240, 321);
										scrollPane.setViewportView(jlist);
										jlist.setLayoutOrientation(JList.VERTICAL);
										
										WithdrawCourseStudent.contentPane.add(scrollPane);
										
										
										//see what they choose after clicking register and withdraw them from the course
										withdraw.getBtnWithdraw().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												int index = jlist.getSelectedIndex();
												list.removeElementAt(index);
												
												try {
													teacher.studentRegistered.get(studentIndex).withdrawGUI(c, index);
													
												}
												catch(Exception f) {
												
												}
												//try to serialize
												try {
													FileOutputStream file = new FileOutputStream(filename); 
												    ObjectOutputStream out = new ObjectOutputStream(file);
												    out.writeObject(teacher);
												    out.writeObject(c);
												    out.close();
												    file.close();
												}
												catch(Exception f) {
													System.out.println("Didnt serialize");
												}
												
												//refresh page
												withdraw.setVisible(false);
												withdraw.setVisible(true);
											}
										});
										
										//log out button exits system
										withdraw.getBtnLogOut().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												System.exit(0);
											}
										});
										
										//main meny sets menu visible and current pane invisible 
										withdraw.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												withdraw.setVisible(false);
												studentMenu.setVisible(true);
											}
										});
									}
									
								});
								
							}
							//if there are no registered students, error handle
							else if (teacher.studentRegistered.size()==0){
								studentLogin.contentPane.add(studentLogin.getLblInvalidUsernameAndor());
								studentLogin.setVisible(false);
								studentLogin.setVisible(true);
							}
							//if nothing matches, error handle.
							else if (counter==teacher.studentRegistered.size()-1){
								studentLogin.contentPane.add(studentLogin.getLblInvalidUsernameAndor());
								studentLogin.setVisible(false);
								studentLogin.setVisible(true);
							}
						}
						
						
					}
					
				});
				
				//main menu
				studentLogin.getBtnMainMenu().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(true);
						studentLogin.setVisible(false);
					}
				});
					
				}	
			
		});
		
		//student button
		btnStudent.setBounds(138, 150, 183, 73);
		frame.getContentPane().add(btnStudent);
		
		//add and initialize admin button
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnAdmin.setBounds(138, 247, 183, 73);
		frame.getContentPane().add(btnAdmin);

		//if clicked admin button, then the rest goes step by step
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//show admin login page
				frame.setVisible(false);
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.setVisible(true);
				
				//goes back to main menu
				adminLogin.getBtnMainMenu().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(true);
						adminLogin.setVisible(false);
					}
				});
				
				
				//if user clicks login
				adminLogin.btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//check if admin user and admin pass match
						adminLogin.adminUser = adminLogin.textField.getText();
						adminLogin.adminPass = adminLogin.passwordField.getText();
						if ((adminLogin.adminUser.equals("admin") || adminLogin.adminUser.equals("Admin"))  && adminLogin.adminPass.equals("Admin001")) {
							
							//show admin menu
							adminLogin.dispose();
							AdminMenu adminMenu = new AdminMenu();
							adminMenu.setVisible(true);
							
							NewCourse add = new NewCourse();
							AllCoursesAdmin viewAll = new AllCoursesAdmin();
							
							//new course
							adminMenu.btnCreateANew.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									//show new course menu
									adminMenu.setVisible(false);
									add.setVisible(true);
									
									
									//shoes admin menu when clicked
									add.btnMainMenu.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											add.setVisible(false);
										}
									});
									
									
									
									//when they click create button
									add.btnCreate.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											//use the admin's new course method
											c.newcourseGUI();
											//refresh
											add.setVisible(false);
											add.setVisible(true);

											//try to serialize
											try {
												serialize();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}
									});
									
									//log out exits program
									add.btnLogOut.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
												teacher.exit();
											
												
										}
									});
									
								}
							});
							
							//log out button from menu
							adminMenu.btnLogOut.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//try to serialize
									try {
										serialize();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									//exit program
									teacher.exit();
								}
							});
							
							//view all courses
							adminMenu.btnViewAllCourses.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//show view courses menu
									AllCoursesAdmin viewAll = new AllCoursesAdmin();
									adminMenu.dispose();
									viewAll.setVisible(true);
									
									//use admin view all gui method
									teacher.viewAllGUI(c);
						
									//logt out and serialize button
									viewAll.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											try {
												serialize();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											teacher.exit();
										}
									});
									
									//go to main menu button
									viewAll.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											viewAll.dispose();
											adminMenu.setVisible(true);
											
											
										}
									});
									
									
								}
							});
							
							
							//remove course button
							adminMenu.getBtnRemoveACourse().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
										//show delete course menu
										DeleteCourseAdmin delete = new DeleteCourseAdmin();
										adminMenu.setVisible(false);
										delete.setVisible(true);
										
										//add each course to arraylist and put the arraylist into defaultlistmodel
										ArrayList<Course> courses  = c.courses;
										ArrayList<String> courseNames= new ArrayList<String>();
										JList jlist = new JList();
										DefaultListModel list = new DefaultListModel();
										for(int i=0; i<courses.size();i++) {
											courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
											list.add(i, courseNames.get(i));
											
										}
										
										//put defaultlistmodel into jlist
										jlist.setModel(list);
										
										
										//put jlist into scroll pane
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(36, 82, 240, 321);
										scrollPane.setViewportView(jlist);
										jlist.setLayoutOrientation(JList.VERTICAL);
										
										//put content pane into scroll pane
										DeleteCourseAdmin.contentPane.add(scrollPane);

										//when they actually click delete
										delete.getBtnDelete().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												//use that selected index to delete it with the admin's method
												int index = jlist.getSelectedIndex();
										
												teacher.deleteCourseGUI(c, index);
											
												list.removeElementAt(index); //remove from the list
												
												//serialize
												try {
													serialize();
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												
												//refresh
												delete.setVisible(false);
												delete.setVisible(true);
											}
										});
										
										
										//log out button
										delete.getBtnLogOut().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												try {
													serialize();
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												teacher.exit();
											}
										});
										
										//main menu button
										delete.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												adminMenu.setVisible(true);
												delete.setVisible(false);
											}
										});
									
										
								}
							});
							
							//register a new student button
							adminMenu.getBtnRegisterANew().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//show register pane
									NewStudentAdmin newStudent = new NewStudentAdmin();
									
									adminMenu.setVisible(false);
									newStudent.setVisible(true);
									
									
									//when admin clicks register button, use the admin's register method
									newStudent.getBtnCreate().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											NewStudentAdmin.contentPane.remove(NewStudentAdmin.getLblThisUsernameAlready());
											NewStudentAdmin.contentPane.remove(NewStudentAdmin.getLabel());

											teacher.registerGUI();
											try {
												serialize();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
									});
									
									//log out button 
									newStudent.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											//serialize
											try {
												serialize();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											//quit program
											teacher.exit();
										}
									});
									
									//main menu button
									newStudent.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											newStudent.setVisible(false);
										}
									});
								}
							});
							
							//sort course button
							adminMenu.getBtnSortCoursesBy().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//show the new pane
									SortAdmin sort = new SortAdmin();
									adminMenu.setVisible(false);
									sort.setVisible(true);
									
									//sort courses
									teacher.sortCoursesGUI(c);
									
									//serialize
									try {
										serialize();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									//log out button
									sort.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											//serialize
											try {
												serialize();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
											//quit program
											teacher.exit();
										}
									});
									
									//main menu button
									sort.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											sort.setVisible(false);
											
											
											
											
										}
									});
								}
							});
							
							//examin course info button
							adminMenu.getBtnExamineCourseInformation().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//show the new pane
									CourseInfoAdmin courseInfo = new CourseInfoAdmin();
									adminMenu.setVisible(false);
									courseInfo.setVisible(true);
									
									//put all courses into arraylist 
									ArrayList<Course> courses  = c.courses;
									ArrayList<String> courseNames= new ArrayList<String>();
									JList jlist = new JList();
									DefaultListModel list = new DefaultListModel();
									
									//put those into the defaultlistmodel
									for(int i=0; i<courses.size();i++) {
										courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
										list.add(i, courseNames.get(i));
										
									}
									
									//put defaultlistmodel into jlist
									jlist.setModel(list);
									
									//put jlist into scrollpane
									JScrollPane scrollPane = new JScrollPane();
									scrollPane.setBounds(36, 82, 240, 321);
									scrollPane.setViewportView(jlist);
									jlist.setLayoutOrientation(JList.VERTICAL);
									
									
									//put into contentpane
									CourseInfoAdmin.contentPane.add(scrollPane);

									//when they actually click the button to examine the course info
									courseInfo.getBtnExamine().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											//get the selected index
											int index = jlist.getSelectedIndex();
											
											//go to new pane
											CourseInfoTwoAdmin courseInfoTwo = new CourseInfoTwoAdmin();
											courseInfo.setVisible(false);
											courseInfoTwo.setVisible(true);
											
											//use admin method to show the course info
											teacher.courseInfoGUI(c, index);
											
											//log out button
											courseInfoTwo.getBtnLogOut().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													teacher.exit();
												}
											});
											
											//back button
											courseInfoTwo.getBtnBack().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													courseInfoTwo.setVisible(false);
													courseInfo.setVisible(true);
												}
											});
											
											
										}
									});
									
									//main menu button from first course info page
									courseInfo.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											courseInfo.setVisible(false);
											adminMenu.setVisible(true);
										}
									});
									
									//log out button from first course info page
									courseInfo.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
									});
								}
							});
							
							//view speciric students courses button
							adminMenu.getBtnViewStudentsCourses().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//show new pane
									StudentCoursesAdmin studentCourses = new StudentCoursesAdmin();
									adminMenu.setVisible(false);
									studentCourses.setVisible(true);
									
									//put all students into arraylist
									ArrayList<Course> courses  = c.courses;
									ArrayList<Student> students = teacher.getStudentRegistered();
									JList jlist = new JList();
									DefaultListModel list = new DefaultListModel();
									
									//loop through students and put them into the defaultlistmodel
									for(int i=0; i<students.size();i++) {
										
										list.add(i, students.get(i).getFirstName()+" "+students.get(i).getLastName());
										
									}
								
									//put defaultlistmodel into jlist
									jlist.setModel(list);
									
									//put jlist into scrollpane
									JScrollPane scrollPane = new JScrollPane();
									scrollPane.setBounds(36, 82, 240, 321);
									scrollPane.setViewportView(jlist);
									jlist.setLayoutOrientation(JList.VERTICAL);
									
									//put scrollpane into contentpane
									StudentCoursesAdmin.contentPane.add(scrollPane);
									
									//when they actually click view
									studentCourses.getBtnView().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											//show new pane
											StudentCoursesTwoAdmin studentCoursesTwo = new StudentCoursesTwoAdmin();
											studentCourses.setVisible(false);
											studentCoursesTwo.setVisible(true);
											
											//use index to access that student
											int index = jlist.getSelectedIndex();
											
											teacher.viewStudentCoursesGUI(c, index);
											
											
											//log out button
											studentCoursesTwo.getBtnLogOut().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													teacher.exit();
												}
											});
											
											//back utton
											studentCoursesTwo.getBtnBack().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													studentCoursesTwo.setVisible(false);
													studentCourses.setVisible(true);
												}
											});
										}
									});
									
									//main menu button from first student courses pane
									studentCourses.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											studentCourses.setVisible(false);
											
										}
									});
									
									//log out button from first student courses pane
									studentCourses.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
									});
								}
								
							});
							
							//view full courses button
							adminMenu.getBtnViewFullCourses().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//new pane
									ViewFullAdmin viewFull = new ViewFullAdmin();
									
									viewFull.setVisible(true);
									adminMenu.setVisible(false);
									
									//use admin's view full method
									teacher.viewFullGUI(c);
									
									//log out button
									viewFull.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
									});
									
									//main menu button
									viewFull.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											viewFull.setVisible(false);
										}
									});
								}
							});
							
							//write to new file button
							adminMenu.getBtnWriteAFile().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//show new pane
									WriteFileAdmin write = new WriteFileAdmin();
									
									write.setVisible(true);
									adminMenu.setVisible(false);
									
									teacher.writeFullGUI(c);
									
									//log out button
									write.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
									});
									
									//main menu button
									write.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											write.setVisible(false);
										}
									});
									
								}
							});
							
							//view course rosters button
							adminMenu.getBtnViewCourseRosters().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									//show new pane
									CourseRosterAdmin courseRoster = new CourseRosterAdmin();
									adminMenu.setVisible(false);
									courseRoster.setVisible(true);
									
									//put courses into arraylist
									ArrayList<Course> courses  = c.courses;
									ArrayList<String> courseNames= new ArrayList<String>();
									JList jlist = new JList();
									DefaultListModel list = new DefaultListModel();
									
									//put arraylist into defaultlistmodel
									for(int i=0; i<courses.size();i++) {
										courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
										list.add(i, courseNames.get(i));
										
									}
									
									//put defaultlistmodel into jlist
									jlist.setModel(list);
									
									//put jlist into scrollpane 
									JScrollPane scrollPane = new JScrollPane();
									scrollPane.setBounds(36, 82, 240, 321);
									scrollPane.setViewportView(jlist);
									jlist.setLayoutOrientation(JList.VERTICAL);
									
									//put scrollpane into contentpane
									CourseRosterAdmin.contentPane.add(scrollPane);
									
									
									//when they click view
									courseRoster.getBtnView().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											//use the index to view that students registered courses
											CourseRosterTwoAdmin courseRoster2 = new CourseRosterTwoAdmin();
											
											int index = jlist.getSelectedIndex();
											
											teacher.viewRegisteredGUI(c, index);
											courseRoster2.setVisible(true);
											courseRoster.setVisible(false);
											
										}
									});
								}
							});
							
							//edit a course button
							adminMenu.getBtnEditACourse().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									
									EditCourseAdmin editCourse = new EditCourseAdmin();
									
									//log out button
									editCourse.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
										
										
									});
									//main menu button
									editCourse.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											editCourse.setVisible(false);
										}
									});
									
									//show new [ane
									adminMenu.setVisible(false);
									editCourse.setVisible(true);
									ArrayList<Course> courses  = c.courses;
									ArrayList<String> courseNames= new ArrayList<String>();
									JList jlist = new JList();
									DefaultListModel list = new DefaultListModel();
									
									//put all courses into defaultlistmodel
									for(int i=0; i<courses.size();i++) {
										courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
										list.add(i, courseNames.get(i));
										
									}
									
									//put defaultlistmodel into jlist
									jlist.setModel(list);
									
									//put jlist into scrollpane
									JScrollPane scrollPane = new JScrollPane();
									scrollPane.setBounds(36, 82, 240, 321);
									scrollPane.setViewportView(jlist);
									jlist.setLayoutOrientation(JList.VERTICAL);
									
									//add scrollpane to contentpane
									EditCourseAdmin.contentPane.add(scrollPane);
									
									
									//when they click edit on a certain class
									editCourse.getBtnEdit().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											//go to a new pane for the selected class 
											int index = jlist.getSelectedIndex();
											
											EditCourseTwoAdmin editCourse2 = new EditCourseTwoAdmin(index, c);
											editCourse.setVisible(false);
											editCourse2.setVisible(true);
											//go to main menu
											editCourse2.getBtnMainMenu().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													//do all of the above by putting into arraylist and then jlist, etc
													//basically refresh
													
													
													editCourse2.setVisible(false);
													list.removeAllElements();
													for(int i=0; i<courses.size();i++) {
														
														list.add(i, courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
														
													}
													
													
													
													jlist.setModel(list);
												
													
													
													
													scrollPane.setViewportView(jlist);
													jlist.setLayoutOrientation(JList.VERTICAL);
													EditCourseAdmin.contentPane.add(scrollPane);
													
													
													editCourse.setVisible(true);
												}
											});
											
											//if edit max 
											editCourse2.getBtnEditMax().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													//refresh
													editCourse2.setVisible(false);
													editCourse2.setVisible(true);
													//edit the course with parameter 1 for max students
													teacher.editCourseGUI(c, index, 1);
													
													//serialize
													try {
														serialize();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
												}
											});
											
											
											//if edit section
											editCourse2.getBtnEditSection().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													
													//refresh
													editCourse2.setVisible(false);
													editCourse2.setVisible(true);
													//edit the course with parameter 2 for section
													teacher.editCourseGUI(c, index, 2);
													
													//serialize
													try {
														serialize();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
												}
											});
											
											//if edit instructor
											editCourse2.getBtnEditInstructor().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													
													//refresh
													editCourse2.setVisible(false);
													editCourse2.setVisible(true);
													//edit the course with parameter 3 for instructor
													teacher.editCourseGUI(c, index, 3);
													//serialize
													try {
														serialize();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
												}
											});
											//if edit location
											editCourse2.getBtnEditLocation().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													//refresh
													editCourse2.setVisible(false);
													editCourse2.setVisible(true);
													//edit the course with parameter 4 for location
													teacher.editCourseGUI(c, index, 4);
													//serialize
													try {
														serialize();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
												}
											});
										}
									});
									
								}
								
							});
							
						}
						//if it user and pass dont match say invalid user and password
						else {
							JLabel lblInvalidUsernameAndor = new JLabel("Invalid username and/or password. Please try again.");
							lblInvalidUsernameAndor.setBounds(56, 246, 350, 16);
							lblInvalidUsernameAndor.setForeground(new Color(255, 0, 0));
							adminLogin.contentPane.add(lblInvalidUsernameAndor);
							adminLogin.setVisible(false);
							adminLogin.setVisible(true);
							
							
						}
						
					}
					
					
				});
				
				
				
				
			}
			
			//serialize method
			public void serialize() throws IOException {
				FileOutputStream file = new FileOutputStream(filename); 
			    ObjectOutputStream out = new ObjectOutputStream(file);
			    out.writeObject(teacher);
			    out.writeObject(c);
			    out.close();
			    file.close();
					
			   
			}
	});
		
		
	}
	
	
}
