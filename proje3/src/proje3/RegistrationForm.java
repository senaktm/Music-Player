package proje3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class RegistrationForm extends JFrame {

	Connection connect,c;
	PreparedStatement state,s;
	ResultSet result,r;
	
	
	private JPanel contentPane;
	private JTextField txtSignUp;
	private JTextField userNameText;
	private JTextField passwordText;
	private JTextField emailText;
	private JTextField txtWelcome;
	JComboBox comboBox ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	public RegistrationForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 1194, 840);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 51, 102));
		panel.setBounds(0, 0, 616, 799);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel iconLabel = new JLabel("");
		
		iconLabel.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\icon.png"));
		iconLabel.setBounds(171, 79, 299, 349);
		panel.add(iconLabel);
		
		txtWelcome = new JTextField();
		txtWelcome.setText("M U S I C  P L A Y E R");
		txtWelcome.setToolTipText("");
		txtWelcome.setBorder(null);
		txtWelcome.setForeground(new Color(255, 204, 255));
		txtWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtWelcome.setBackground(new Color(153, 51, 102));
		txtWelcome.setBounds(141, 455, 350, 118);
		panel.add(txtWelcome);
		txtWelcome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(255, 204, 255));
		panel_1.setBounds(612, 0, 566, 799);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel userName = new JLabel("username :");
		userName.setForeground(Color.BLACK);
		userName.setFont(new Font("Tahoma", Font.BOLD, 15));
		userName.setBounds(245, 126, 160, 14);
		panel_1.add(userName);
		
		JLabel password = new JLabel("password :");
		password.setFont(new Font("Tahoma", Font.BOLD, 15));
		password.setBounds(245, 213, 129, 14);
		panel_1.add(password);
		
		JLabel email = new JLabel("e-mail :");
		email.setFont(new Font("Tahoma", Font.BOLD, 15));
		email.setBounds(252, 296, 63, 14);
		panel_1.add(email);
		
		JLabel country = new JLabel("country :");
		country.setFont(new Font("Tahoma", Font.BOLD, 15));
		country.setBounds(245, 377, 129, 20);
		panel_1.add(country);
		
		txtSignUp = new JTextField();
		txtSignUp.setForeground(Color.BLACK);
		txtSignUp.setBorder(null);
		txtSignUp.setBackground(new Color(255, 204, 255));
		txtSignUp.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtSignUp.setText("   Sign Up");
		txtSignUp.setBounds(10, 23, 232, 50);
		panel_1.add(txtSignUp);
		txtSignUp.setColumns(10);
		
		userNameText = new JTextField();
		userNameText.setBorder(null);
		userNameText.setBackground(new Color(255, 204, 255));
		userNameText.setFont(new Font("Tahoma", Font.BOLD, 11));
		userNameText.setBounds(224, 151, 129, 20);
		panel_1.add(userNameText);
		userNameText.setColumns(10);
		
		passwordText = new JTextField();
		passwordText.setFont(new Font("Tahoma", Font.BOLD, 11));
		passwordText.setColumns(10);
		passwordText.setBorder(null);
		passwordText.setBackground(new Color(255, 204, 255));
		passwordText.setBounds(224, 238, 129, 20);
		panel_1.add(passwordText);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Tahoma", Font.BOLD, 11));
		emailText.setColumns(10);
		emailText.setBorder(null);
		emailText.setBackground(new Color(255, 204, 255));
		emailText.setBounds(224, 328, 129, 20);
		panel_1.add(emailText);
		
		JComboBox cmbAccount = new JComboBox();
		cmbAccount.setModel(new DefaultComboBoxModel(new String[] {"Premium", "Free"}));
		cmbAccount.setBorder(new LineBorder(new Color(153, 51, 102)));
		cmbAccount.setBackground(new Color(255, 204, 255));
		cmbAccount.setBounds(328, 475, 89, 22);
		panel_1.add(cmbAccount);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="INSERT INTO userinfo (username,email,password,countryID,isPremium) VALUES(?,?,?,?,?)";
				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				state=connect.prepareStatement(query)	;
		
	
			
				
				if(checkEmptyFields()) {
					if(!isTaken(userNameText.getText())) {
						state.setString(1, userNameText.getText());
						
				state.setString(2, emailText.getText());
				state.setString(3, passwordText.getText());
		
				state.setString(5, cmbAccount.getSelectedItem().toString());
				state.setInt(4, comboBox.getSelectedIndex()+1);
				state.executeUpdate();
				JOptionPane.showMessageDialog(null, "YOU SIGN UP SUCCESFULLY");
				for( int i=1;i<4;i++) {
				
					
					
					try{
						String query2= "INSERT INTO playlist (ownerID,genreID) VALUES (?,?)";
						c=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
    		        s=c.prepareStatement(query2);
    		        s.setInt(1, maxOwnerID());
    		        s.setInt(2,i);
    		        s.executeUpdate();
    		        
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					
					
					
				}
				
		        dispose();
					}
						
				}
				
							
				
				
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			  
			    
					
								
								
								
				
				
			}
		
		});
		btnNewButton.setForeground(new Color(255, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(153, 51, 102));
		btnNewButton.setBorder(new LineBorder(new Color(153, 51, 102)));
		btnNewButton.setActionCommand("btnsignUp");
		btnNewButton.setBounds(245, 635, 111, 36);
		panel_1.add(btnNewButton);
		
		
	
		JLabel isPremium = new JLabel("Premium / Free :");
		isPremium.setFont(new Font("Tahoma", Font.BOLD, 15));
		isPremium.setBackground(new Color(255, 204, 255));
		isPremium.setBounds(186, 475, 129, 18);
		panel_1.add(isPremium);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(214, 176, 160, 8);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(214, 262, 160, 2);
		panel_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(214, 351, 160, 2);
		panel_1.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBackground(Color.BLACK);
		separator_2_1.setBounds(214, 432, 160, 2);
		panel_1.add(separator_2_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(186, 520, 129, 20);
		panel_1.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(214, 402, 149, 32);
		panel_1.add(comboBox);
		addDataCombobox();
	}
	
	public boolean checkEmptyFields() {
		String username=userNameText.getText();
		String email=emailText.getText();
		String password=passwordText.getText();

	    
		
		if(username.trim().equals("") || email.trim().equals("") || password.trim().equals("")) {
			JOptionPane.showMessageDialog(null, " PLEASE FILL OUT THE EMPTY FIELDS ");
			return false;
		}
		else {
			return true;
		}
		
	
	}
	
	public boolean isTaken(String userName) {
		boolean taken=false;
		ResultSet r;
		Connection c;
		PreparedStatement s;
	
		String query=" SELECT * FROM userinfo WHERE username=?";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			s=c.prepareStatement(query)	;
			s.setString(1, userName);
			r=s.executeQuery();
			if(r.next()) {
				taken=true;
				JOptionPane.showMessageDialog(null, " THIS USERNAME IS ALREADY TAKEN. PLEASE TRY AGAIN ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        return taken;
	}
	
	public void addDataCombobox() {
		ResultSet result;
		Connection connection;
		PreparedStatement state;
		try {
			String query="SELECT countryName From country";
		
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	state=connection.prepareStatement(query)	;
	result=state.executeQuery(query);
	
	while(result.next()) {
		String name = result.getString("countryName");
		comboBox.addItem(name);
			
	}
		
	}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
}
	public int maxOwnerID() {
		Connection connect;
		PreparedStatement state;
		ResultSet result;
		 int ID=0;
		 String query1 = "SELECT MAX(userID) FROM userinfo ";
			try {
				 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
					state=connect.prepareStatement(query1)	;
				 result=state.executeQuery();
				result.next();
				ID=result.getInt(1);
				
			    
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return ID;
	}
}
