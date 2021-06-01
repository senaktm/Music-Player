package proje3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddAlbumAdmin extends JFrame {

	
	JComboBox comboBox;
	private JPanel contentPane;
	private JTextField albumNameText;
	private JTextField releaseDateText;
	private JTable table;
	DefaultTableModel model;
	private String albumID;
	private String albumName;
	private String date;
	private int genre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAlbumAdmin frame = new AddAlbumAdmin();
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
	public AddAlbumAdmin() {
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
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(778, 139, 331, 314);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("ALBUM NAME : ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(39, 128, 118, 55);
		panel.add(lblNewLabel);
		
		JLabel lblReleasedate = new JLabel("RELEASE DATE :");
		lblReleasedate.setForeground(Color.WHITE);
		lblReleasedate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReleasedate.setBounds(39, 251, 129, 55);
		panel.add(lblReleasedate);
		
		JLabel lblGenre = new JLabel("GENRE :");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGenre.setBounds(39, 374, 102, 55);
		panel.add(lblGenre);
		
		albumNameText = new JTextField();
		albumNameText.setBackground(Color.WHITE);
		albumNameText.setBounds(167, 139, 202, 36);
		panel.add(albumNameText);
		albumNameText.setColumns(10);
		
		releaseDateText = new JTextField();
		releaseDateText.setBounds(167, 262, 202, 36);
		panel.add(releaseDateText);
		releaseDateText.setColumns(10);
		
	    comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(167, 383, 202, 37);
		panel.add(comboBox);
		addDataCombobox();
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddData();
				showData();
		
			  
			
			}
		});
		btnNewButton.setBounds(39, 514, 102, 69);
		panel.add(btnNewButton);
		
		JButton btnEdt = new JButton("EDIT");
		btnEdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editData();
			}
		});
		btnEdt.setForeground(Color.WHITE);
		btnEdt.setBackground(Color.BLACK);
		btnEdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdt.setBounds(167, 514, 102, 69);
		panel.add(btnEdt);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(298, 514, 102, 69);
		panel.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanel adminpanel = new AdminPanel();
				adminpanel.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(167, 613, 102, 69);
		panel.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("A L B U M  P A N E L");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNewLabel_1.setBounds(468, 11, 344, 47);
		panel.add(lblNewLabel_1);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				albumID=(String) model.getValueAt(table.getSelectedRow(), 0);
				albumNameText.setText((String)model.getValueAt(table.getSelectedRow(),1));
				releaseDateText.setText((String)model.getValueAt(table.getSelectedRow(),2));
				
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\albumPanel.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1177, 807);
		panel.add(lblNewLabel_2);
		
	
	}
	
	
	public void AddData() {
		Connection connect;
		PreparedStatement state;
		ResultSet result;
		try {
			String query="INSERT INTO album (albumName,releaseDate,genreID) VALUES(?,?,?)";
	connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	state=connect.prepareStatement(query)	;
	state.setString(1, albumNameText.getText());
	
	state.setString(2, releaseDateText.getText());
	state.setInt(3, comboBox.getSelectedIndex()+1);
	
	state.executeUpdate();
	JOptionPane.showMessageDialog(null, "YOU ADD SUCCESFULLY");
	}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
	}
	
	public void showData() {
		ResultSet result;
		Connection connect;
		PreparedStatement state;
		 model=new DefaultTableModel();
		model.addColumn("albumID");
		model.addColumn("albumName");
		model.addColumn("releaseDate");
		model.addColumn("genreID");
		
		String query=" SELECT * FROM album ";
		try {
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				state=connect.prepareStatement(query)	;
				result=state.executeQuery();
				while(result.next()) {
					model.addRow(new Object[]{
						result.getString("albumID"),result.getString("albumName"),result.getString("releaseDate"),result.getString("genreID")
						
					});
				}
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(1).setPreferredWidth(40);
				table.getColumnModel().getColumn(2).setPreferredWidth(40);
				table.getColumnModel().getColumn(3).setPreferredWidth(40);
		
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
			String query="SELECT genreName From musicgenre";
		
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	state=connection.prepareStatement(query)	;
	result=state.executeQuery(query);
	
	while(result.next()) {
		String name = result.getString("genreName");
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
			String query="DELETE FROM album WHERE albumID="+albumID;
			
 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	state=connect.prepareStatement(query)	;
	
	state.executeUpdate();
	JOptionPane.showMessageDialog(null, "YOU DELETE SUCCESFULLY");
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
		
		albumName=albumNameText.getText();
		date=releaseDateText.getText();
		genre=comboBox.getSelectedIndex()+1;

		try {
			String query="UPDATE album SET albumName='"+albumName+"',"+
		"releaseDate='"+date+"',genreID="+genre+" WHERE albumID="+albumID;
			

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
