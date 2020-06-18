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
    public static String filename = "SerializedFromGithub.ser"; 
    public static File f = new File(filename);
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
		
		
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the University Course Registration System!");
		lblWelcomeToThe.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblWelcomeToThe.setBounds(24, 58, 439, 16);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblAreYouA = new JLabel("Are you a student or an admin?");
		lblAreYouA.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblAreYouA.setBounds(116, 93, 253, 16);
		frame.getContentPane().add(lblAreYouA);
		
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
						

						String studentUser = studentLogin.getTextField().getText();
						String studentPass = studentLogin.getPasswordField().getText();
						int counter=0;
						for (int i=0;i<teacher.studentRegistered.size();i++) {
							counter++;
							
							if(teacher.studentRegistered.get(i).getUsername().toLowerCase().equals(studentUser) && teacher.studentRegistered.get(i).getPassword().equals(studentPass)) {
								
							
								StudentMenu studentMenu = new StudentMenu();
								studentLogin.setVisible(false);
								studentMenu.setVisible(true);
								int studentIndex = i;
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
								
								studentMenu.getBtnViewOpen().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ViewOpenStudent viewOpen = new ViewOpenStudent();
										studentMenu.setVisible(false);
										viewOpen.setVisible(true);
										teacher.studentRegistered.get(studentIndex).viewOpenGUI(c);
										
									}
								});
								
								studentMenu.getBtnViewRegistered().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ViewRegisteredStudent viewRegistered = new ViewRegisteredStudent();
										viewRegistered.setVisible(true);
										studentMenu.setVisible(false);
										teacher.studentRegistered.get(studentIndex).viewRegisteredGUI();
										
										viewRegistered.getBtnLogOut().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												System.exit(0);
											}
										});
										
										viewRegistered.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												studentMenu.setVisible(true);
												viewRegistered.setVisible(false);
											}
										});
									}
								});
								studentMenu.getBtnRegister().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										RegisterCourseStudent register = new RegisterCourseStudent();
										studentMenu.setVisible(false);
										register.setVisible(true);
										ArrayList<Course> courses  = c.courses;
										ArrayList<String> courseNames= new ArrayList<String>();
										JList jlist = new JList();
										DefaultListModel list = new DefaultListModel();
										for(int i=0; i<courses.size();i++) {
											courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
											list.add(i, courseNames.get(i));
											
										}
										
										
										jlist.setModel(list);
										
										
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(36, 82, 240, 321);
										scrollPane.setViewportView(jlist);
										jlist.setLayoutOrientation(JList.VERTICAL);
										
										RegisterCourseStudent.contentPane.add(scrollPane);
										
										register.getBtnRegister().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {												
												int index = jlist.getSelectedIndex();
												
												try {
													teacher.studentRegistered.get(studentIndex).registerGUI(c, index);
													
												}
												catch(Exception f) {
												
												}
												
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
										
										register.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												register.setVisible(false);
												studentMenu.setVisible(true);
											}
										});
										
										register.getBtnLogOut().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												System.exit(0);
											}
										});
									}
								});
								
								studentMenu.getBtnWithdraw().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										WithdrawCourseStudent withdraw = new WithdrawCourseStudent();
										studentMenu.setVisible(false);
										withdraw.setVisible(true);
										ArrayList<Course> courses  = c.courses;
										ArrayList<String> courseNames= new ArrayList<String>();
										JList jlist = new JList();
										DefaultListModel list = new DefaultListModel();
										for(int i=0; i<teacher.studentRegistered.get(studentIndex).getRegisteredClasses().size();i++) {
											courseNames.add(teacher.studentRegistered.get(studentIndex).getRegisteredClasses().get(i).getCourseName()+" (Section: "+teacher.studentRegistered.get(studentIndex).getRegisteredClasses().get(i).getSection()+")");
											list.add(i, courseNames.get(i));
											
										}
										
										
										jlist.setModel(list);
										
										
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(36, 82, 240, 321);
										scrollPane.setViewportView(jlist);
										jlist.setLayoutOrientation(JList.VERTICAL);
										
										WithdrawCourseStudent.contentPane.add(scrollPane);
										
										withdraw.getBtnWithdraw().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												int index = jlist.getSelectedIndex();
												list.removeElementAt(index);
												
												try {
													teacher.studentRegistered.get(studentIndex).withdrawGUI(c, index);
													
												}
												catch(Exception f) {
												
												}
												
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
												
												
												withdraw.setVisible(false);
												withdraw.setVisible(true);
											}
										});
										withdraw.getBtnLogOut().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												System.exit(0);
											}
										});
										
										withdraw.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												withdraw.setVisible(false);
												studentMenu.setVisible(true);
											}
										});
									}
									
								});
								
							}
							else if (teacher.studentRegistered.size()==0){
								studentLogin.contentPane.add(studentLogin.getLblInvalidUsernameAndor());
								studentLogin.setVisible(false);
								studentLogin.setVisible(true);
							}
							else if (counter==teacher.studentRegistered.size()){
								studentLogin.contentPane.add(studentLogin.getLblInvalidUsernameAndor());
								studentLogin.setVisible(false);
								studentLogin.setVisible(true);
							}
						}
						studentLogin.getBtnMainMenu().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frame.setVisible(true);
								studentLogin.setVisible(false);
							}
						});
						
					}
					
				});
				
					
				}	
		});
		btnStudent.setBounds(138, 150, 183, 73);
		frame.getContentPane().add(btnStudent);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnAdmin.setBounds(138, 247, 183, 73);
		frame.getContentPane().add(btnAdmin);

		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.setVisible(true);
				
				adminLogin.getBtnMainMenu().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(true);
						adminLogin.setVisible(false);
					}
				});
				adminLogin.btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						adminLogin.adminUser = adminLogin.textField.getText();
						adminLogin.adminPass = adminLogin.passwordField.getText();
						if ((adminLogin.adminUser.equals("admin") || adminLogin.adminUser.equals("Admin"))  && adminLogin.adminPass.equals("Admin001")) {
							adminLogin.dispose();
							AdminMenu adminMenu = new AdminMenu();
							adminMenu.setVisible(true);
							
							newCourse add = new newCourse();
							AllCoursesAdmin viewAll = new AllCoursesAdmin();
							
							adminMenu.btnCreateANew.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									adminMenu.setVisible(false);
									add.setVisible(true);
									
									add.btnMainMenu.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											add.setVisible(false);
										}
									});
									
									
									
									
									add.btnCreate.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											c.newcourseGUI();
											add.setVisible(false);
											add.setVisible(true);

											try {
												serialize();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}
									});
									add.btnLogOut.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
												teacher.exit();
											
												
										}
									});
									
								}
							});
							
							adminMenu.btnLogOut.addActionListener(new ActionListener() {
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
							
							adminMenu.btnViewAllCourses.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									AllCoursesAdmin viewAll = new AllCoursesAdmin();
									adminMenu.dispose();
									viewAll.setVisible(true);
									teacher.viewAllGUI(c);
						
									
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
									viewAll.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											viewAll.dispose();
											adminMenu.setVisible(true);
											
											
										}
									});
									
									
								}
							});
							
							
							adminMenu.getBtnRemoveACourse().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									
										DeleteCourseAdmin delete = new DeleteCourseAdmin();
										adminMenu.setVisible(false);
										delete.setVisible(true);
										ArrayList<Course> courses  = c.courses;
										ArrayList<String> courseNames= new ArrayList<String>();
										JList jlist = new JList();
										DefaultListModel list = new DefaultListModel();
										for(int i=0; i<courses.size();i++) {
											courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
											list.add(i, courseNames.get(i));
											
										}
										
										
										jlist.setModel(list);
										
										
										JScrollPane scrollPane = new JScrollPane();
										scrollPane.setBounds(36, 82, 240, 321);
										scrollPane.setViewportView(jlist);
										jlist.setLayoutOrientation(JList.VERTICAL);
										
										DeleteCourseAdmin.contentPane.add(scrollPane);

										
										//DeleteCourseAdmin.contentPane.add(list);
										delete.getBtnDelete().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												int index = jlist.getSelectedIndex();
										
												teacher.deleteCourseGUI(c, index);
											
												list.removeElementAt(index);
												try {
													serialize();
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												
												
												delete.setVisible(false);
												delete.setVisible(true);
											}
										});
										
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
										
										delete.getBtnMainMenu().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												adminMenu.setVisible(true);
												delete.setVisible(false);
											}
										});
									
										
								}
							});
							
							adminMenu.getBtnRegisterANew().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									NewStudentAdmin newStudent = new NewStudentAdmin();
									
									adminMenu.setVisible(false);
									newStudent.setVisible(true);
									
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
									
									
									newStudent.getBtnLogOut().addActionListener(new ActionListener() {
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
									
									newStudent.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											newStudent.setVisible(false);
										}
									});
								}
							});
							adminMenu.getBtnSortCoursesBy().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									SortAdmin sort = new SortAdmin();
									adminMenu.setVisible(false);
									sort.setVisible(true);
									teacher.sortCoursesGUI(c);
									sort.getBtnLogOut().addActionListener(new ActionListener() {
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
									sort.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											sort.setVisible(false);
											
											
											
											
										}
									});
								}
							});
	
							adminMenu.getBtnExamineCourseInformation().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									CourseInfoAdmin courseInfo = new CourseInfoAdmin();
									adminMenu.setVisible(false);
									courseInfo.setVisible(true);
									ArrayList<Course> courses  = c.courses;
									ArrayList<String> courseNames= new ArrayList<String>();
									JList jlist = new JList();
									DefaultListModel list = new DefaultListModel();
									for(int i=0; i<courses.size();i++) {
										courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
										list.add(i, courseNames.get(i));
										
									}
									
									
									jlist.setModel(list);
									
									
									JScrollPane scrollPane = new JScrollPane();
									scrollPane.setBounds(36, 82, 240, 321);
									scrollPane.setViewportView(jlist);
									jlist.setLayoutOrientation(JList.VERTICAL);
									
									CourseInfoAdmin.contentPane.add(scrollPane);

									
									//DeleteCourseAdmin.contentPane.add(list);
									courseInfo.getBtnExamine().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											int index = jlist.getSelectedIndex();
											
											CourseInfoTwoAdmin courseInfoTwo = new CourseInfoTwoAdmin();
											courseInfo.setVisible(false);
											courseInfoTwo.setVisible(true);
											
											teacher.courseInfoGUI(c, index);
											
											courseInfoTwo.getBtnLogOut().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													teacher.exit();
												}
											});
											
											courseInfoTwo.getBtnBack().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													courseInfoTwo.setVisible(false);
													courseInfo.setVisible(true);
												}
											});
											
											
										}
									});
									courseInfo.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											courseInfo.setVisible(false);
											adminMenu.setVisible(true);
										}
									});
									courseInfo.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
									});
								}
							});
							adminMenu.getBtnViewStudentsCourses().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									StudentCoursesAdmin studentCourses = new StudentCoursesAdmin();
									adminMenu.setVisible(false);
									studentCourses.setVisible(true);
									
									ArrayList<Course> courses  = c.courses;
									ArrayList<Student> students = teacher.getStudentRegistered();
									JList jlist = new JList();
									DefaultListModel list = new DefaultListModel();
									for(int i=0; i<students.size();i++) {
										
										list.add(i, students.get(i).getFirstName()+" "+students.get(i).getLastName());
										
									}
								
									jlist.setModel(list);
									
									
									JScrollPane scrollPane = new JScrollPane();
									scrollPane.setBounds(36, 82, 240, 321);
									scrollPane.setViewportView(jlist);
									jlist.setLayoutOrientation(JList.VERTICAL);
									
									StudentCoursesAdmin.contentPane.add(scrollPane);
									
									studentCourses.getBtnView().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											StudentCoursesTwoAdmin studentCoursesTwo = new StudentCoursesTwoAdmin();
											studentCourses.setVisible(false);
											studentCoursesTwo.setVisible(true);
											
											int index = jlist.getSelectedIndex();
											
											teacher.viewStudentCoursesGUI(c, index);
											
											studentCoursesTwo.getBtnLogOut().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													teacher.exit();
												}
											});
											studentCoursesTwo.getBtnBack().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													studentCoursesTwo.setVisible(false);
													studentCourses.setVisible(true);
												}
											});
										}
									});
									studentCourses.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											studentCourses.setVisible(false);
											
										}
									});
									studentCourses.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
									});
								}
								
							});
							adminMenu.getBtnViewFullCourses().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									ViewFullAdmin viewFull = new ViewFullAdmin();
									
									viewFull.setVisible(true);
									adminMenu.setVisible(false);
									teacher.viewFullGUI(c);
									
									viewFull.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
									});
									viewFull.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											viewFull.setVisible(false);
										}
									});
								}
							});
							
							adminMenu.getBtnWriteAFile().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									WriteFileAdmin write = new WriteFileAdmin();
									
									write.setVisible(true);
									adminMenu.setVisible(false);
									
									teacher.writeFullGUI(c);
									
									write.getBtnLogOut().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											teacher.exit();
										}
									});
									
									write.getBtnMainMenu().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											adminMenu.setVisible(true);
											write.setVisible(false);
										}
									});
									
								}
							});
							
							adminMenu.getBtnViewCourseRosters().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									CourseRosterAdmin courseRoster = new CourseRosterAdmin();
									adminMenu.setVisible(false);
									courseRoster.setVisible(true);
									ArrayList<Course> courses  = c.courses;
									ArrayList<String> courseNames= new ArrayList<String>();
									JList jlist = new JList();
									DefaultListModel list = new DefaultListModel();
									for(int i=0; i<courses.size();i++) {
										courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
										list.add(i, courseNames.get(i));
										
									}
									
									
									jlist.setModel(list);
									
									
									JScrollPane scrollPane = new JScrollPane();
									scrollPane.setBounds(36, 82, 240, 321);
									scrollPane.setViewportView(jlist);
									jlist.setLayoutOrientation(JList.VERTICAL);
									
									CourseRosterAdmin.contentPane.add(scrollPane);
									
									courseRoster.getBtnView().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											CourseRosterTwoAdmin courseRoster2 = new CourseRosterTwoAdmin();
											
											int index = jlist.getSelectedIndex();
											
											teacher.viewRegisteredGUI(c, index);
											courseRoster2.setVisible(true);
											courseRoster.setVisible(false);
											
										}
									});
								}
							});
							adminMenu.getBtnEditACourse().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									EditCourseAdmin editCourse = new EditCourseAdmin();
									
									adminMenu.setVisible(false);
									editCourse.setVisible(true);
									ArrayList<Course> courses  = c.courses;
									ArrayList<String> courseNames= new ArrayList<String>();
									JList jlist = new JList();
									DefaultListModel list = new DefaultListModel();
									for(int i=0; i<courses.size();i++) {
										courseNames.add(courses.get(i).getCourseName()+" (Section: "+courses.get(i).getSection()+")");
										list.add(i, courseNames.get(i));
										
									}
									
									
									jlist.setModel(list);
									
									
									JScrollPane scrollPane = new JScrollPane();
									scrollPane.setBounds(36, 82, 240, 321);
									scrollPane.setViewportView(jlist);
									jlist.setLayoutOrientation(JList.VERTICAL);
									
									EditCourseAdmin.contentPane.add(scrollPane);
									
									editCourse.getBtnEdit().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											int index = jlist.getSelectedIndex();
											
											EditCourseTwoAdmin editCourse2 = new EditCourseTwoAdmin(index, c);
											editCourse.setVisible(false);
											editCourse2.setVisible(true);
											
											
											editCourse2.getBtnEditMax().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													editCourse2.setVisible(false);
													editCourse2.setVisible(true);
													teacher.editCourseGUI(c, index, 1);
													try {
														serialize();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
												}
											});
											
											editCourse2.getBtnEditSection().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													editCourse2.setVisible(false);
													editCourse2.setVisible(true);
													teacher.editCourseGUI(c, index, 2);
													try {
														serialize();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
												}
											});
											
											editCourse2.getBtnEditInstructor().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													editCourse2.setVisible(false);
													editCourse2.setVisible(true);
													teacher.editCourseGUI(c, index, 3);
													try {
														serialize();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
												}
											});
											editCourse2.getBtnEditLocation().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													editCourse2.setVisible(false);
													editCourse2.setVisible(true);
													teacher.editCourseGUI(c, index, 4);
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
