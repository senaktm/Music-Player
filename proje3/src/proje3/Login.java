package proje3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;


public class Login extends javax.swing.JFrame {
	String adminUsername="admin";
	String adminPassword="12345";
	static int user,country;

	Connection connect;
	PreparedStatement state;
	ResultSet result;
	private JPanel contentPane;
	private JTextField userNameText;
	private JTextField passwordText;
	private JTextField txtWelcomeBack;
	private JTextField txtMUS;
	private JTextField txtDontHaveAn;
	private JTextField txtMUS_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
		setBounds(200, 10, 1193, 846);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 51, 102));
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 610, 807);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\icon.png"));
		lblNewLabel.setBounds(171, 79, 299, 349);
		panel.add(lblNewLabel);
		
		txtMUS_1 = new JTextField();
		txtMUS_1.setForeground(new Color(255, 204, 255));
		txtMUS_1.setBackground(new Color(153, 51, 102));
		txtMUS_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtMUS_1.setBorder(null);
		txtMUS_1.setText("M U S I C  P L A Y E R");
		txtMUS_1.setBounds(141, 455, 350, 118);
		panel.add(txtMUS_1);
		txtMUS_1.setColumns(10);
		
		JButton btnAdmin = new JButton("Admin Login");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateAdmin();
				

				
				
			}
		});
		btnAdmin.setBorder(null);
		btnAdmin.setForeground(new Color(255, 204, 255));
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdmin.setBackground(new Color(153, 51, 102));
		btnAdmin.setBounds(10, 703, 119, 72);
		panel.add(btnAdmin);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(609, 0, 568, 807);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(255, 204, 255));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("username :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(252, 266, 95, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("password :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(252, 385, 95, 20);
		panel_1.add(lblNewLabel_1_1);
		
		userNameText = new JTextField();
		userNameText.setBorder(null);
		userNameText.setForeground(new Color(0, 0, 0));
		userNameText.setBackground(new Color(255, 204, 255));
		userNameText.setBounds(218, 316, 166, 20);
		panel_1.add(userNameText);
		userNameText.setColumns(10);
		
		passwordText = new JTextField();
		passwordText.addFocusListener(new FocusAdapter() {
		
		
		});
		passwordText.setBorder(null);
		passwordText.setBackground(new Color(255, 204, 255));
		passwordText.setSelectionColor(new Color(0, 0, 0));
		passwordText.setColumns(10);
		passwordText.setBounds(218, 431, 166, 20);
		panel_1.add(passwordText);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.setForeground(new Color(255, 204, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			validateUser();
		/*	dispose();
			UserPanel userpanel=new UserPanel();
			userpanel.setVisible(true);
		*/	
			}
		});
		btnLogin.setBackground(new Color(153, 51, 102));
		btnLogin.setBorder(new LineBorder(new Color(153, 51, 102)));
		btnLogin.setBounds(139, 571, 95, 41);
		panel_1.add(btnLogin);
		
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrationForm form= new RegistrationForm();
				form.setVisible(true);
				
			
			
				
			
			}
		});
		btnSignup.setBorder(new LineBorder(new Color(153, 51, 102)));
		btnSignup.setForeground(new Color(255, 204, 255));
		btnSignup.setBackground(new Color(153, 51, 102));
		btnSignup.setBounds(340, 571, 95, 41);
		panel_1.add(btnSignup);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(218, 340, 160, 8);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(218, 458, 160, 8);
		panel_1.add(separator_1);
		
		txtWelcomeBack = new JTextField();
		txtWelcomeBack.setForeground(Color.WHITE);
		txtWelcomeBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtWelcomeBack.setText("WELCOME TO");
		txtWelcomeBack.setBackground(new Color(255, 204, 255));
		txtWelcomeBack.setBorder(null);
		txtWelcomeBack.setBounds(187, 37, 215, 56);
		panel_1.add(txtWelcomeBack);
		txtWelcomeBack.setColumns(10);
		
		txtMUS = new JTextField();
		txtMUS.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtMUS.setForeground(Color.WHITE);
		txtMUS.setBackground(new Color(255, 204, 255));
		txtMUS.setBorder(null);
		txtMUS.setText("M U S I C  P L A Y E R");
		txtMUS.setBounds(139, 119, 325, 41);
		panel_1.add(txtMUS);
		txtMUS.setColumns(10);
		
		txtDontHaveAn = new JTextField();
		txtDontHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtDontHaveAn.setBackground(new Color(255, 204, 255));
		txtDontHaveAn.setBorder(null);
		txtDontHaveAn.setText("Don't have an account?");
		txtDontHaveAn.setBounds(336, 615, 181, 20);
		panel_1.add(txtDontHaveAn);
		txtDontHaveAn.setColumns(10);
	}
	
	public void validateUser() {
		String username=userNameText.getText();
		String password=passwordText.getText();
		PreparedStatement s;
		ResultSet r;
		int x;
		try {
			
			
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
		
			String query="SELECT username,password FROM userinfo WHERE username='"+username+"' and password='"+password+"'";
		
			state=connect.prepareStatement(query)	;
		result = state.executeQuery();
	
		if(result.next()) {
			JOptionPane.showMessageDialog(null, "YOU LOGINED SUCCESFULLY");
			dispose();
		  
			UserPanel userpanel=new UserPanel();
			userpanel.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD");
		}
			
			}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		try {
			String query2= "SELECT userID from userinfo where username='"+username+"'";
			s=connect.prepareStatement(query2);
			r=s.executeQuery();
	   	  r.next();
				user= r.getInt(1);
				System.out.println(user);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		try {
			String query2= "SELECT countryID from userinfo where username='"+username+"'";
			s=connect.prepareStatement(query2);
			r=s.executeQuery();
	   	  r.next();
				country= r.getInt(1);
				System.out.println(country);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		
	}
	
	public void validateAdmin() {
		String adminUserName=userNameText.getText();
		String adminpassword=passwordText.getText();
        if(adminUserName.equals(adminUsername)&& adminpassword.equals(adminPassword)) {
        	JOptionPane.showMessageDialog(null, "ADMIN LOGINED SUCCESFULLY");
        	dispose();
			AdminPanel adminpanel=new AdminPanel();
			adminpanel.setVisible(true);
        	//return true;
        }
        else {
        	JOptionPane.showMessageDialog(null, "INVALID ADMIN USERNAME OR PASSWORD");
        	//return false;
        }
		
	
	}

}
