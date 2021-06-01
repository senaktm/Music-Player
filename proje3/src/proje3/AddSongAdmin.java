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
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

public class AddSongAdmin extends JFrame {
	Connection connect;
	PreparedStatement state;
	ResultSet result;
	
	private String album;
	private String songID;
	private String songName;
	private String date;
	private String singerID;
	private String genre;
	private String time;
	DefaultTableModel model=new DefaultTableModel();
	DefaultTableModel model1=new DefaultTableModel();
	DefaultTableModel model2=new DefaultTableModel();
	DefaultTableModel model3=new DefaultTableModel();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnEdt;
	private JButton btnDelete;
	private JButton btnBack;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSongAdmin frame = new AddSongAdmin();
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
	public AddSongAdmin() {
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
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(186, 358, 134, 61);
		contentPane.add(scrollPane_4);
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(188, 266, 134, 51);
		contentPane.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(186, 195, 143, 37);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		textField = new JTextField();
		textField.setBounds(186, 123, 143, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 430, 143, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 508, 143, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(810, 120, 342, 311);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(47, 584, 89, 60);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));

		chooseGenre();
		chooseSinger();
		chooseAlbum();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=(String)model2.getValueAt(table_4.getSelectedRow(), 2);
				String b=(String)model3.getValueAt(table_2.getSelectedRow(), 0);
				if(a.equals(b)){
				addData();
			showData();
		singerSongTable();
	//	albumSongTable();
		countrySongTable();
				}
				else {
					JOptionPane.showMessageDialog(null, "SONG GENRE AND ALBUM GENRE IS NOT SAME");
					
				}
			}
		});
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("SONG NAME : ");
		lblNewLabel.setBounds(42, 123, 134, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("GENRE :");
		lblNewLabel_1.setBounds(42, 195, 94, 37);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("SINGER NAME :");
		lblNewLabel_2.setBounds(42, 280, 117, 39);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ALBUM NAME :");
		lblNewLabel_3.setBounds(42, 353, 117, 39);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("SONG LENGHT : ");
		lblNewLabel_4.setBounds(42, 425, 134, 39);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("RELEASE DATE :");
		lblNewLabel_5.setBounds(42, 503, 134, 39);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_5);
		
		btnEdt = new JButton("EDIT");
		
		btnEdt.setBounds(174, 584, 89, 60);
		btnEdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnEdt);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		btnDelete.setBounds(301, 584, 89, 60);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnDelete);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanel adminpanel = new AdminPanel();
				adminpanel.setVisible(true);
				
			}
		});
		btnBack.setBounds(174, 687, 89, 60);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnBack);
		
		lblNewLabel_6 = new JLabel("S O N G  P A N E L");
		lblNewLabel_6.setBounds(457, 0, 316, 51);
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		contentPane.add(lblNewLabel_6);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				songID=(String) model.getValueAt(table.getSelectedRow(), 0);
				textField.setText((String)model.getValueAt(table.getSelectedRow(),1));				
				textField_1.setText((String)model.getValueAt(table.getSelectedRow(),4));
				textField_2.setText((String)model.getValueAt(table.getSelectedRow(),5));	
				
			}
		});
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\songPanel.jpg"));
		lblNewLabel_7.setBounds(0, 0, 1177, 807);
		contentPane.add(lblNewLabel_7);
		btnEdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				editData();
			
				
				
			}
		});
		
	}
	

	
	
	public void addData() {
		ResultSet result;
		Connection connection;
		PreparedStatement state;
	
		try {
			String query="INSERT INTO song (songName,genreID,albumID,songLenght,releaseDate) VALUES(?,?,?,?,?)";
	connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	state=connect.prepareStatement(query)	;
	state.setString(1, textField.getText());
	
	state.setString(2, (String)model3.getValueAt(table_2.getSelectedRow(), 0));
	state.setString(3, (String)model2.getValueAt(table_4.getSelectedRow(), 0));
	state.setString(4, textField_1.getText());
	state.setString(5, textField_2.getText());
	state.executeUpdate();
	JOptionPane.showMessageDialog(null, "YOU ADD SUCCESFULLY");
	}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
		}
	
		
	
	
	public void showData() {
		ResultSet result;
		Connection connection;
		PreparedStatement state;
	    model=new DefaultTableModel();
		model.addColumn("songID");
		model.addColumn("songName");
		model.addColumn("genreID");
		model.addColumn("albumID");	
		model.addColumn("songLenght");
		model.addColumn("releaseDate");
		String query=" SELECT * FROM song ";
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				state=connection.prepareStatement(query)	;
				result=state.executeQuery();
				while(result.next()) {
					model.addRow(new Object[]{
						result.getString("songID"),result.getString("songName"),result.getString("genreID"),result.getString("albumID"),result.getString("songLenght"),result.getString("releaseDate")
						
					});
				}
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(1).setPreferredWidth(40);
				table.getColumnModel().getColumn(2).setPreferredWidth(40);
				table.getColumnModel().getColumn(3).setPreferredWidth(40);
				table.getColumnModel().getColumn(4).setPreferredWidth(40);
				table.getColumnModel().getColumn(5).setPreferredWidth(40);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	


	
 public int maxSongID() {
	Connection connect;
	PreparedStatement state;
	ResultSet result;
	 int ID=0;
	 String query1 = "SELECT MAX(songID) FROM song ";
		try {
			 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				state=connect.prepareStatement(query1)	;
			 result=state.executeQuery();
			result.next();
			ID=result.getInt(1);
			 System.out.println(songID);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ID;
 }
	
public int maxcountryID() {
	Connection connect;
	PreparedStatement state;
	ResultSet result;
	 int ID=0;
	 String query1 = "SELECT MAX(countryID) FROM country ";
		try {
			 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				state=connect.prepareStatement(query1)	;
			 result=state.executeQuery();
			result.next();
			ID=result.getInt(1);
			 System.out.println(songID);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ID;
}
 public void singerSongTable() {
	     Connection connect;
		PreparedStatement state;
		ResultSet result;
		 String query1 = "INSERT INTO songsingerconnection (songID,singerID) VALUES (?,?)";

			try {
				 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				
					state=connect.prepareStatement(query1)	;	
					state.setInt(1,maxSongID() );
					state.setString(2,(String)model1.getValueAt(table_3.getSelectedRow(), 0));
				    state.executeUpdate();			  
						    
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
}

 /*
 public void albumSongTable() {
	 try {
	 String query="INSERT INTO albumsongconnection (albumID,songID) VALUES(?,?)";
	    connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
		state=connect.prepareStatement(query)	;
		state.setInt(1, comboBox_2.getSelectedIndex()+1);
		state.setInt(2, maxSongID());
		state.executeUpdate();
			}
 
		    catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
 }
 */
	
	public void deleteData() {
		ResultSet result;
		Connection connect;
		PreparedStatement state;
		
		try {
			String query="DELETE FROM song WHERE songID="+songID;
			
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
		ResultSet result,r;
		Connection connect;
		PreparedStatement state,s;
		songName=textField.getText();
		 album=(String)model2.getValueAt(table_4.getSelectedRow(), 2);
		 date=textField_2.getText();
		 genre=(String)model3.getValueAt(table_2.getSelectedRow(), 0);
		time=textField_1.getText();
		singerID=(String)model1.getValueAt(table_3.getSelectedRow(), 0);
		String a=(String)model3.getValueAt(table_2.getSelectedRow(), 0);
		String b=(String)model2.getValueAt(table_4.getSelectedRow(), 2);
		if (a.equals(b)) {
		try {
			String query="UPDATE song SET songName='"+songName+"',genreID="+genre+
		" ,albumID="+album+",songLenght='"+time+"', releaseDate='"+date+"' WHERE songID="+songID+"";
		connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");

	state=connect.prepareStatement(query)	;
	state.executeUpdate();

	}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
	
		try {
			String query="UPDATE songsingerconnection SET singerID="+singerID+" WHERE songID="+songID+"";
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	state=connect.prepareStatement(query);
	state.executeUpdate();
		}
	    catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
	    }
		JOptionPane.showMessageDialog(null, "YOU UPDATE SUCCESFULLY");
		showData();
		}
		else{
			JOptionPane.showMessageDialog(null, "SONG GENRE AND ALBUM GENRE IS NOT SAME");
		}
		
		
		
		
		
	
	
}
	public void countrySongTable() {
		ResultSet result,r;
		Connection connect;
		PreparedStatement state,s;
		 try {
				for (int i = 1; i <= maxcountryID(); i++) {
					String query="INSERT INTO countrysongconnection(countryID,songID,listenerCount) VALUES(?,?,?)";
					 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
					state=connect.prepareStatement(query)	;
					state.setInt(1, i);
					state.setInt(2,maxSongID());
					state.setInt(3, 0);
					state.executeUpdate();
				}
		    	
			}
		    catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
	}
	public void chooseSinger() {
		ResultSet r;
		Connection c;
		PreparedStatement s;
	
		model1.addColumn("singerID");
		model1.addColumn("singerName");
		

		
		model1.setRowCount(0);
		String query=" SELECT singerID,singerName FROM singer ";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model1.addRow(new Object[]{
						r.getString("singerID"),r.getString("singerName")
						
					});
				}
				table_3.setModel(model1);
				table_3.setAutoResizeMode(0);
				table_3.getColumnModel().getColumn(0).setPreferredWidth(45);
				table_3.getColumnModel().getColumn(1).setPreferredWidth(50);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chooseAlbum() {
		ResultSet r;
		Connection c;
		PreparedStatement s;

		model2.addColumn("albumID");
		model2.addColumn("albumName");
		model2.addColumn("genreID");
        model2.addColumn("releaseDate");
		
		model2.setRowCount(0);
		String query=" SELECT albumID,albumName,genreID,releaseDate FROM album ";
		try {
		  	c=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model2.addRow(new Object[]{
						r.getString("albumID"),r.getString("albumName"),r.getString("genreID"),r.getString("releaseDate")
						
					});
				}
				table_4.setModel(model2);
				table_4.setAutoResizeMode(0);
				table_4.getColumnModel().getColumn(0).setPreferredWidth(45);
				table_4.getColumnModel().getColumn(1).setPreferredWidth(50);
				table_4.getColumnModel().getColumn(2).setPreferredWidth(50);
				table_4.getColumnModel().getColumn(3).setPreferredWidth(50);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chooseGenre() {
		ResultSet r;
		Connection c;
		PreparedStatement s;

		model3.addColumn("ID");
		model3.addColumn("genreName");
		
	
		model3.setRowCount(0);
		String query=" SELECT * FROM musicgenre ";
		try {
		 	c=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model3.addRow(new Object[]{
						r.getString("ID"),r.getString("genreName")
						
					});
				}
				table_2.setModel(model3);
				table_2.setAutoResizeMode(0);
				table_2.getColumnModel().getColumn(0).setPreferredWidth(45);
				table_2.getColumnModel().getColumn(1).setPreferredWidth(50);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
