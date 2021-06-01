package proje3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;

public class AddSingerAdmin extends JFrame {
	Connection connect;
	PreparedStatement state;
	ResultSet result;
	JComboBox comboBox ;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	DefaultTableModel model;
	private String singerID;
	private String singerName;
	private int countryID ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSingerAdmin frame = new AddSingerAdmin();
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
	public AddSingerAdmin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 1193, 846);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1177, 807);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("S I N G E R  P A N E L");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNewLabel_3.setBounds(452, 11, 362, 37);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(171, 173, 189, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(171, 297, 149, 32);
		panel.add(comboBox);
		addDataCombobox();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(781, 150, 362, 235);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(52, 467, 89, 63);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            addData();
			showData();
				
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SINGER NAME : ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(36, 173, 133, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("COUNTRY :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(36, 295, 133, 32);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel_1);
		
		JButton btnEdt = new JButton("EDIT");
		btnEdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editData();
			}
		});
		btnEdt.setBounds(185, 467, 89, 63);
		btnEdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(btnEdt);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		btnDelete.setBounds(311, 467, 89, 63);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanel adminpanel = new AdminPanel();
				adminpanel.setVisible(true);
			}
		});
		btnBack.setBounds(185, 583, 89, 63);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(btnBack);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				singerID=(String) model.getValueAt(table.getSelectedRow(), 0);
				textField.setText((String)model.getValueAt(table.getSelectedRow(),1));
			//	countryID=comboBox.setSelectedItem((String)model.getValueAt(table.getSelectedRow(),2));
			//	comboBox.setSelectedIndex((Integer)model.getValueAt(table.getSelectedRow(),2));
			
				
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\singerPanel.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1177, 807);
		panel.add(lblNewLabel_2);
	}
	
	public void addData() {
		ResultSet result;
		Connection connection;
		PreparedStatement state;
		
		try {
			String query="INSERT INTO singer (singerName,countryID) VALUES(?,?)";
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	state=connection.prepareStatement(query)	;
	state.setString(1, textField.getText());		
	state.setInt(2, comboBox.getSelectedIndex()+1);
	state.executeUpdate();
	JOptionPane.showMessageDialog(null, "YOU ADD SUCCESFULLY");
	}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
		
	}
	public void showData() {
		ResultSet r;
		Connection c;
		PreparedStatement s;
	    model=new DefaultTableModel();
		model.addColumn("singerID");
		model.addColumn("singerName");
		model.addColumn("countryID");
		
		String query=" SELECT * FROM singer ";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model.addRow(new Object[]{
						r.getString("singerID"),r.getString("singerName"),r.getString("countryID")
						
					});
				}
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(1).setPreferredWidth(40);
				table.getColumnModel().getColumn(2).setPreferredWidth(40);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
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
	
	public void deleteData() {
		ResultSet result;
		Connection connect;
		PreparedStatement state;
		
		try {
			String query="DELETE FROM singer WHERE singerID="+singerID;
			
 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	state=connect.prepareStatement(query)	;
	
	state.executeUpdate();
	JOptionPane.showMessageDialog(null, "YOU DELETED SUCCESFULLY");
	}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
	showData();
	}
	
	public void editData() {
		ResultSet result;
		Connection connect;
		PreparedStatement state;
		
		singerName=textField.getText();
		countryID=comboBox.getSelectedIndex()+1;

		try {
			String query="UPDATE singer SET singerName='"+singerName+"',"+
		"countryID="+countryID+" WHERE singerID="+singerID;
			

	 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
		state=connect.prepareStatement(query)	; 
	state.executeUpdate();
	JOptionPane.showMessageDialog(null, "YOU UPDATE SUCCESFULLY");
	}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
		showData();
	}
	
	
}
