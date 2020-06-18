import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WriteFileAdmin extends JFrame {

	public static JPanel contentPane;
	private JLabel lblWrite;
	private static JButton btnLogOut;
	private static JButton btnMainMenu;
	private static JLabel lblTheFileHas;
	private static JLabel lblTheFileCould;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriteFileAdmin frame = new WriteFileAdmin();
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
	public WriteFileAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,480,480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWrite = new JLabel("WRITE FILE OF FULL COURSES");
		lblWrite.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblWrite.setBounds(45, 50, 378, 29);
		contentPane.add(lblWrite);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(290, 311, 117, 29);
		contentPane.add(btnLogOut);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(59, 311, 117, 29);
		contentPane.add(btnMainMenu);
		
		lblTheFileCould = new JLabel("The file could not be written.");
		lblTheFileCould.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTheFileCould.setForeground(Color.RED);
		lblTheFileCould.setBounds(105, 181, 255, 16);
		
		
		lblTheFileHas = new JLabel("The file has been written.");
		lblTheFileHas.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTheFileHas.setBounds(118, 165, 289, 16);
		
		
		
	}

	/**
	 * @return the lblTheFileCould
	 */
	public static JLabel getLblTheFileCould() {
		return lblTheFileCould;
	}



	/**
	 * @return the btnLogOut
	 */
	public static JButton getBtnLogOut() {
		return btnLogOut;
	}

	/**
	 * @return the btnMainMenu
	 */
	public static JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	/**
	 * @return the lblTheFileHas
	 */
	public 	static JLabel getLblTheFileHas() {
		return lblTheFileHas;
	}
	
	

}
