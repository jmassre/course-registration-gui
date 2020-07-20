import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WithdrawCourseStudent extends JFrame {

	static JPanel contentPane;
	private JList list;
	private JButton btnWithdraw;
	private JButton btnMainMenu;
	private JButton btnLogOut;
	private static JLabel lblSuccess;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawCourseStudent frame = new WithdrawCourseStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WithdrawCourseStudent() {
		
		//set the contentpane background stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(119, 136, 153));
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label on top
		JLabel lblNewCourseMenu = new JLabel("WITHDRAW FROM A COURSE");
		lblNewCourseMenu.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewCourseMenu.setBounds(47, 42, 373, 44);
		contentPane.add(lblNewCourseMenu);
		
		
		//withdraw button
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(280, 260, 117, 29);
		contentPane.add(btnWithdraw);
		
		//main menu button
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(36, 423, 117, 29);
		contentPane.add(btnMainMenu);
		
		//log out button
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(320, 423, 117, 29);
		contentPane.add(btnLogOut);
		
		//initialize label but dont add
		lblSuccess = new JLabel("Success!");
		lblSuccess.setBounds(290, 296, 61, 16);
		
		
		
		
	}

	
	

	
	/**
	 * @return the btnMainMenu
	 */
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	/**
	 * @return the btnLogOut
	 */
	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	
	public JPanel getContentPane() {
		return contentPane;
	}


	public JList getList() {
		return list;
	}

	public JButton getBtnWithdraw() {
		return btnWithdraw;
	}

	/**
	 * @return the lblSuccess
	 */
	public static JLabel getLblSuccess() {
		return lblSuccess;
	}

}
