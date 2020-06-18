import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class StudentMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnViewAll;
	private JButton btnViewOpen;
	private JButton btnRegister;
	private JButton btnWithdraw;
	private JButton btnViewRegistered;
	private JButton btnLogout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenu frame = new StudentMenu();
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
	public StudentMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME, STUDENT!");
		lblWelcome.setBounds(142, 52, 331, 31);
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		contentPane.add(lblWelcome);
		
		btnViewAll = new JButton("View all courses");
		btnViewAll.setBounds(58, 132, 230, 89);
		btnViewAll.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		contentPane.add(btnViewAll);
		
		btnViewOpen = new JButton("View open courses");
		btnViewOpen.setBounds(345, 132, 230, 89);
		btnViewOpen.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		contentPane.add(btnViewOpen);
		
		btnRegister = new JButton("Register in a course");
		btnRegister.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnRegister.setBounds(58, 249, 230, 89);
		contentPane.add(btnRegister);
		
		btnWithdraw =  new JButton("Withdraw from a course");
		btnWithdraw.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnWithdraw.setBounds(345, 249, 230, 89);
		contentPane.add(btnWithdraw);
		
		btnViewRegistered = new JButton("View registered courses");
		btnViewRegistered.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnViewRegistered.setBounds(58, 366, 230, 89);
		contentPane.add(btnViewRegistered);
		
		btnLogout = new JButton("Log Out");
		btnLogout.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnLogout.setBounds(345, 366, 230, 89);
		contentPane.add(btnLogout);
		
	}

	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @return the btnViewAll
	 */
	public JButton getBtnViewAll() {
		return btnViewAll;
	}

	/**
	 * @return the btnViewOpen
	 */
	public JButton getBtnViewOpen() {
		return btnViewOpen;
	}

	/**
	 * @return the btnRegister
	 */
	public JButton getBtnRegister() {
		return btnRegister;
	}

	/**
	 * @return the btnWithdraw
	 */
	public JButton getBtnWithdraw() {
		return btnWithdraw;
	}

	/**
	 * @return the btnViewRegistered
	 */
	public JButton getBtnViewRegistered() {
		return btnViewRegistered;
	}

	/**
	 * @return the btnLogout
	 */
	public JButton getBtnLogout() {
		return btnLogout;
	}

	
}
