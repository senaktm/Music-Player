package proje3;
	
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserPanel extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTable table;
	DefaultTableModel model;
	String songID,genreID;
int t=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel frame = new UserPanel();
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
	public UserPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 1193, 846);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("POP TOP10");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_8.setForeground(new Color(255, 204, 255));
		btnNewButton_8.setBackground(new Color(0, 0, 0));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("songID");
					model.addColumn("songName");
					model.addColumn("genreID");
					model.addColumn("albumID");	
					model.addColumn("songLenght");
					model.addColumn("releaseDate");
					model.addColumn("listenerCount");
		
				 try {
					 String query= "Select *from song where genreID=1 order by listenercount desc limit 10 " ; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
							r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("releaseDate"),r.getString("listenerCount")
							
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
					table.getColumnModel().getColumn(6).setPreferredWidth(40);
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnNewButton_9 = new JButton("ROCK TOP10");
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_9.setForeground(new Color(255, 204, 255));
		btnNewButton_9.setBackground(new Color(0, 0, 0));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("songID");
					model.addColumn("songName");
					model.addColumn("genreID");
					model.addColumn("albumID");	
					model.addColumn("songLenght");
					model.addColumn("releaseDate");
					model.addColumn("listenerCount");
		
				 try {
					 String query= "Select *from song where genreID=2 order by listenercount desc limit 10 " ; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
							r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("releaseDate"),r.getString("listenerCount")
							
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
					table.getColumnModel().getColumn(6).setPreferredWidth(40);
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		JButton btnNewButton_10 = new JButton("JAZZ TOP10");
		btnNewButton_10.setForeground(new Color(255, 204, 255));
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_10.setBackground(new Color(0, 0, 0));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("songID");
					model.addColumn("songName");
					model.addColumn("genreID");
					model.addColumn("albumID");	
					model.addColumn("songLenght");
					model.addColumn("releaseDate");
					model.addColumn("listenerCount");
		
				 try {
					 String query= "Select *from song where genreID=3 order by listenercount desc limit 10 " ; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
							r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("releaseDate"),r.getString("listenerCount")
							
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
					table.getColumnModel().getColumn(6).setPreferredWidth(40);
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_11 = new JButton("COUNTRY TOP10");
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_11.setForeground(new Color(255, 204, 255));
		btnNewButton_11.setBackground(new Color(0, 0, 0));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("songID");
					model.addColumn("songName");
					model.addColumn("genreID");
					model.addColumn("albumID");	
					model.addColumn("songLenght");
					
					model.addColumn("listenerCount");
		
				 try {
					 String query= "select s.songID,s.songName,s.genreID,s.albumID,s.songLenght,s.listenerCount from song s,countrysongconnection c "+
				 "where c.countryID="+Login.country+" and s.songID=c.songID order by c.listenerCount desc limit 10" ; 
					 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
								r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("listenerCount")
							
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
					
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		
			}
		});
			
			JButton btnNewButton_13 = new JButton("FOLLOW");
			btnNewButton_13.setForeground(Color.WHITE);
			btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_13.setBackground(Color.BLACK);
			btnNewButton_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResultSet result,r;
	    			Connection connect;
	    			PreparedStatement state,s;
	    			int x;
	    			String genreID=(String) model.getValueAt(table.getSelectedRow(), 2);
	    			
	    			if(genreID.equals("Premium")) {
	    			String query="INSERT INTO followingusers (userID,followingID) values (?,?)";
	    			try {
	    				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				        s=connect.prepareStatement(query);
	    		        s=connect.prepareStatement(query);
	    		        s.setInt(1, Login.user);
	    	    		  
	    		        s.setString(2, (String) model.getValueAt(table.getSelectedRow(), 0));
	    		        s.executeUpdate();
	    		        JOptionPane.showMessageDialog(null, "YOU FOLLOWED ");
	    		     
	    			} catch (SQLException eX) {
	    				// TODO Auto-generated catch block
	    				JOptionPane.showMessageDialog(null, "YOU ALREADY FOLLOWED THIS ACCOUNT");
	    				eX.printStackTrace();
	    			}
	    			}
	    			else {
	    				JOptionPane.showMessageDialog(null, "YOU CANNOT FOLLOW FREE ACCOUNTS");
	    				
	    			}
				}
			});
			
			JButton btnNewButton_16 = new JButton("GO TO POP PLAYLIST");
			btnNewButton_16.setForeground(new Color(255, 204, 255));
			btnNewButton_16.setBackground(new Color(0, 0, 0));
			btnNewButton_16.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ResultSet result,r;
					Connection connect;
					PreparedStatement state,s;
					  
						 String query= "SELECT * FROM song s where s.songID IN (select p.songID from playlistsongconnection p where p.playlistID IN (select pl.playlistID from playlist pl where pl.ownerID='"+(String)model.getValueAt(table.getSelectedRow(), 0)+"' and pl.genreID="+1+")) "; 
						 
						t=1;
					 try {
						
						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				        s=connect.prepareStatement(query);
						r=s.executeQuery();
						model=new DefaultTableModel();
						model.addColumn("songID");
						model.addColumn("songName");
						model.addColumn("genreID");
						model.addColumn("albumID");	
						model.addColumn("songLenght");
						model.addColumn("releaseDate");
						model.addColumn("listenerCount");
						while(r.next()) {
							model.addRow(new Object[]{
									r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("listenerCount"),r.getString("releaseDate")
								
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
						table.getColumnModel().getColumn(6).setPreferredWidth(40);
				
				
					 } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JButton btnNewButton_17 = new JButton("SHOW ALBUMS");
			btnNewButton_17.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_17.setForeground(new Color(255, 204, 255));
			btnNewButton_17.setBackground(new Color(0, 0, 0));
			btnNewButton_17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResultSet r,r2,r3;
					Connection c;
					PreparedStatement s,s2,s3;
					model=new DefaultTableModel();
					model.addColumn("albumID");
					model.addColumn("albumName");
					model.addColumn("releaseDate");
					model.addColumn("genreID");	
				
					try {
						
						String query2="SELECT * From album";
						
			
						c=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				s2=c.prepareStatement(query2)	;
				r2=s2.executeQuery(query2);
				
				
				
					
				while(r2.next()) {
					model.addRow(new Object[]{
							r2.getString("albumID"),r2.getString("albumName"),r2.getString("releaseDate"),r2.getString("genreID")
						
					});
				}
		        table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(1).setPreferredWidth(40);
				table.getColumnModel().getColumn(2).setPreferredWidth(40);
				table.getColumnModel().getColumn(3).setPreferredWidth(40);
				
				}
					 catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
				}
			});
			
			JButton btnNewButton_18 = new JButton("ALBUM'S SONGS");
			btnNewButton_18.setBackground(Color.BLACK);
			btnNewButton_18.setForeground(Color.WHITE);
			btnNewButton_18.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResultSet result,r;
					Connection connect;
					PreparedStatement state,s;
					  
						 String query= "SELECT * FROM song where albumID= "+(String)model.getValueAt(table.getSelectedRow(), 0)+""; 
						 
					 try {
						

						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				        s=connect.prepareStatement(query);
						r=s.executeQuery();
						model=new DefaultTableModel();
						model.addColumn("songID");
						model.addColumn("songName");
						model.addColumn("genreID");
						model.addColumn("albumID");	
						model.addColumn("songLenght");
						model.addColumn("releaseDate");
						model.addColumn("listenerCount");
						while(r.next()) {
							model.addRow(new Object[]{
									r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("listenerCount"),r.getString("releaseDate")
								
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
						table.getColumnModel().getColumn(6).setPreferredWidth(40);
				
				
					 } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JButton btnNewButton_19 = new JButton("ADD ALL SONGS");
			
			
			JButton btnNewButton_20 = new JButton("PLAY");
			btnNewButton_20.setBackground(new Color(0, 0, 0));
			btnNewButton_20.setForeground(Color.WHITE);
			btnNewButton_20.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Connection connect,con;
					PreparedStatement state,st;
				
					try {
						String query="UPDATE song SET listenerCount=listenerCount+1 WHERE songID="+(String)model.getValueAt(table.getSelectedRow(), 0)+" ";
						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				state=connect.prepareStatement(query);
				state.executeUpdate();
					}
				    catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
				    }
					try {
						String query1="UPDATE countrysongconnection SET listenerCount=listenerCount+1 WHERE songID="+(String)model.getValueAt(table.getSelectedRow(), 0)+" and countryID="+Login.country +" ";
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				st=con.prepareStatement(query1);
				st.executeUpdate();
					}
				    catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
				    }
					
				}
			});
			btnNewButton_20.setBounds(362, 502, 89, 43);
			contentPane.add(btnNewButton_20);
			btnNewButton_19.setBounds(204, 604, 407, 31);
			contentPane.add(btnNewButton_19);
			btnNewButton_18.setBounds(646, 441, 142, 50);
			contentPane.add(btnNewButton_18);
			btnNewButton_17.setBounds(21, 40, 162, 113);
			contentPane.add(btnNewButton_17);
			btnNewButton_16.setBounds(636, 256, 162, 50);
			contentPane.add(btnNewButton_16);
			
			JButton btnNewButton_15 = new JButton("GO TO ROCK PLAYLIST");
			btnNewButton_15.setBackground(new Color(0, 0, 0));
			btnNewButton_15.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_15.setForeground(new Color(255, 204, 255));
			btnNewButton_15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					ResultSet result,r;
					Connection connect;
					PreparedStatement state,s;
					  
						 String query= "SELECT * FROM song where song.songID IN (select songID from playlistsongconnection where playlistID IN (select playlistID from playlist where ownerID="+
								 (String)model.getValueAt(table.getSelectedRow(), 0)+" and genreID='"+2+"')) "; 
						 	t=2;
					 try {
						
						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				        s=connect.prepareStatement(query);
						r=s.executeQuery();
						model=new DefaultTableModel();
						model.addColumn("songID");
						model.addColumn("songName");
						model.addColumn("genreID");
						model.addColumn("albumID");	
						model.addColumn("songLenght");
						model.addColumn("releaseDate");
						model.addColumn("listenerCount");
						while(r.next()) {
							model.addRow(new Object[]{
									r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("listenerCount"),r.getString("releaseDate")
								
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
						table.getColumnModel().getColumn(6).setPreferredWidth(40);
				
				
					 } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_15.setBounds(636, 317, 162, 53);
			contentPane.add(btnNewButton_15);
			
			JButton btnNewButton_14 = new JButton("GO TO JAZZ PLAYLIST");
			btnNewButton_14.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_14.setForeground(new Color(255, 204, 255));
			btnNewButton_14.setBackground(new Color(0, 0, 0));
			btnNewButton_14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ResultSet result,r;
					Connection connect;
					PreparedStatement state,s;
					  
						 String query= "SELECT * FROM song where song.songID IN (select songID from playlistsongconnection where playlistID IN (select playlistID from playlist where ownerID="+
								 (String)model.getValueAt(table.getSelectedRow(), 0)+" and genreID='"+3+"')) "; 
						 t=3;
					 try {
						
						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				        s=connect.prepareStatement(query);
						r=s.executeQuery();
						model=new DefaultTableModel();
						model.addColumn("songID");
						model.addColumn("songName");
						model.addColumn("genreID");
						model.addColumn("albumID");	
						model.addColumn("songLenght");
						model.addColumn("releaseDate");
						model.addColumn("listenerCount");
						while(r.next()) {
							model.addRow(new Object[]{
									r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("listenerCount"),r.getString("releaseDate")
								
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
						table.getColumnModel().getColumn(6).setPreferredWidth(40);
				
				
					 } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_14.setBounds(636, 381, 162, 45);
			contentPane.add(btnNewButton_14);
			btnNewButton_13.setBounds(464, 200, 89, 23);
			contentPane.add(btnNewButton_13);
			
			btnNewButton_19.setBackground(Color.BLACK);
			btnNewButton_19.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_19.setForeground(Color.WHITE);
			btnNewButton_19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResultSet result,r;
	    			Connection connect;
	    			PreparedStatement state,s;
	    			
	    			int a=0;
				
					
					try {
							String query="SELECT playlistID from playlist where ownerID="+Login.user +" and genreID="+t+" ";
							System.out.print(t);
						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	    		        s=connect.prepareStatement(query);
	    		        r=s.executeQuery();
	    		        r.next();
	    		        a=r.getInt(1);
	    		        for (int i = 0; i < table.getRowCount(); i++) {
	 	    		       
	        				
	        		     
	        		     String query2="INSERT INTO playlistsongconnection (playlistID,songID) VALUES(?,?)";
	        		     state=connect.prepareStatement(query2);
	        		           state.setInt(1, a);
	        		   
	        		        state.setString(2, (String) model.getValueAt(i, 0));
	        		        state.executeUpdate();
	        			 
				}
					}
					catch (SQLException eX) {
	    				JOptionPane.showMessageDialog(null, "YOU ALREADY ADDED THIS SONG");
	    				eX.printStackTrace();
	    			}
				}
			});
		
			JButton btnNewButton_12 = new JButton("ADD SONG");
			btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_12.setBackground(Color.BLACK);
			btnNewButton_12.setForeground(Color.WHITE);
			btnNewButton_12.setBounds(204, 556, 410, 37);
			contentPane.add(btnNewButton_12);
			
	

		btnNewButton_11.setBounds(21, 299, 162, 113);
		contentPane.add(btnNewButton_11);
		btnNewButton_10.setBounds(21, 683, 162, 113);
		contentPane.add(btnNewButton_10);
		btnNewButton_9.setBounds(21, 556, 162, 113);
		contentPane.add(btnNewButton_9);
		btnNewButton_8.setBounds(21, 432, 162, 113);
		contentPane.add(btnNewButton_8);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(204, 249, 410, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton_7 = new JButton("WORLD TOP10");
		btnNewButton_7.setForeground(new Color(255, 204, 255));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_7.setBackground(new Color(0, 0, 0));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("songID");
					model.addColumn("songName");
					model.addColumn("genreID");
					model.addColumn("albumID");	
					model.addColumn("songLenght");
					model.addColumn("releaseDate");
					model.addColumn("listenerCount");
		
				 try {
					 String query= "Select *from song order by listenercount desc limit 10" ; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
							r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("releaseDate"),r.getString("listenerCount")
							
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
					table.getColumnModel().getColumn(6).setPreferredWidth(40);
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton_7.setBounds(21, 166, 162, 113);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("FOLLOWING");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("userID");
					model.addColumn("username");
					model.addColumn("isPremium");
				
				 try {
					 String query= "SELECT * FROM userinfo where userinfo.userID IN (select followingID from followingusers where userID="+Login.user+") "; 
					 connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
							r.getString("userID"),r.getString("username"),r.getString("isPremium")
							
						});
					}
					table.setModel(model);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(40);
					table.getColumnModel().getColumn(1).setPreferredWidth(40);
					table.getColumnModel().getColumn(2).setPreferredWidth(40);
		
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		btnNewButton_6.setForeground(new Color(255, 204, 255));
		btnNewButton_6.setBackground(new Color(0, 0, 0));
		btnNewButton_6.setBounds(530, 126, 150, 50);
		contentPane.add(btnNewButton_6);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 204, 255));
		separator.setBounds(348, 67, 300, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("M U S I C  P L A Y E R");
		lblNewLabel_1.setForeground(new Color(255, 204, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(333, 11, 387, 58);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("FIND OTHER USERS");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("userID");
					model.addColumn("username");
					model.addColumn("isPremium");
		
				 try {
					 String query= "Select userID,username,isPremium from userinfo " ; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
							r.getString("userID"),r.getString("username"),r.getString("isPremium")
							
						});
					}
					table.setModel(model);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(40);
					table.getColumnModel().getColumn(1).setPreferredWidth(40);
					table.getColumnModel().getColumn(2).setPreferredWidth(40);
		
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setForeground(new Color(255, 204, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setBounds(327, 126, 150, 53);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("songID");
					model.addColumn("songName");
					model.addColumn("genreID");
					model.addColumn("albumID");	
					model.addColumn("songLenght");
					model.addColumn("releaseDate");
					model.addColumn("listenerCount");
		
					int ID;
					String query="SELECT playlistID from playlist where ownerID="+Login.user +" and genreID="+3 +" ";
	    			
					try {
						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	    		        state=connect.prepareStatement(query);
	    		        result=state.executeQuery();
	    		        result.next();
	    		        ID=result.getInt(1);
	    		        System.out.println(ID);
	    		   String      query2="SELECT * FROM song where song.songID IN (select songID from playlistsongconnection where playlistID="+ID+ ") ";
	    		         s=connect.prepareStatement(query2);
		    		        r=s.executeQuery();
		    		        while(r.next()) {
								model.addRow(new Object[]{
										r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("releaseDate"),r.getString("listenerCount")
									
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
							table.getColumnModel().getColumn(6).setPreferredWidth(40);
					}
	    			catch (SQLException eX) {
	    				// TODO Auto-generated catch block
	    				eX.printStackTrace();
	    			}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\jazzicon.jpg"));
		btnNewButton_2.setBounds(824, 545, 300, 215);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("songID");
					model.addColumn("songName");
					model.addColumn("genreID");
					model.addColumn("albumID");	
					model.addColumn("songLenght");
					model.addColumn("releaseDate");
					model.addColumn("listenerCount");
		
					int ID;
					String query="SELECT playlistID from playlist where ownerID="+Login.user +" and genreID="+2 +" ";
	    			
					try {
						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	    		        state=connect.prepareStatement(query);
	    		        result=state.executeQuery();
	    		        result.next();
	    		        ID=result.getInt(1);
	    		        System.out.println(ID);
	    		   String      query2="SELECT * FROM song where song.songID IN (select songID from playlistsongconnection where playlistID="+ID+ ") ";
	    		         s=connect.prepareStatement(query2);
		    		        r=s.executeQuery();
		    		        while(r.next()) {
								model.addRow(new Object[]{
										r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("releaseDate"),r.getString("listenerCount")
									
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
							table.getColumnModel().getColumn(6).setPreferredWidth(40);
					}
	    			catch (SQLException eX) {
	    				// TODO Auto-generated catch block
	    				eX.printStackTrace();
	    			}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\rockicon.jpg"));
		btnNewButton_1.setBounds(824, 290, 300, 226);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("songID");
					model.addColumn("songName");
					model.addColumn("genreID");
					model.addColumn("albumID");	
					model.addColumn("songLenght");
					model.addColumn("releaseDate");
					model.addColumn("listenerCount");
		
					int ID;
					String query="SELECT playlistID from playlist where ownerID="+Login.user +" and genreID="+1 +" ";
	    			
					try {
						connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
	    		        state=connect.prepareStatement(query);
	    		        result=state.executeQuery();
	    		        result.next();
	    		        ID=result.getInt(1);
	    		        System.out.println(ID);
	    		   String      query2="SELECT * FROM song where song.songID IN (select songID from playlistsongconnection where playlistID="+ID+ ") ";
	    		         s=connect.prepareStatement(query2);
		    		        r=s.executeQuery();
		    		        while(r.next()) {
								model.addRow(new Object[]{
										r.getString("songID"),r.getString("songName"),r.getString("genreID"),r.getString("albumID"),r.getString("songLenght"),r.getString("releaseDate"),r.getString("listenerCount")
									
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
							table.getColumnModel().getColumn(6).setPreferredWidth(40);
					}
	    			catch (SQLException eX) {
	    				// TODO Auto-generated catch block
	    				eX.printStackTrace();
	    			}
				
			
				
				
			}
		});
		btnNewButton.setBackground(new Color(204, 102, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\popicon.jpg"));
		btnNewButton.setBounds(824, 40, 300, 226);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\userPanel.jpg"));
		lblNewLabel.setBounds(0, 0, 1177, 807);
		contentPane.add(lblNewLabel);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				songID=(String) model.getValueAt(table.getSelectedRow(), 0);
			    genreID=(String)model.getValueAt(table.getSelectedRow(), 2); 
			    System.out.print(songID);
			    System.out.print(genreID);  
				
			}
		});
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  
    			ResultSet result,r;
    			Connection connect;
    			PreparedStatement state,s;
    			int a;
    			
    			try {
    				String query="SELECT playlistID from playlist where ownerID="+Login.user +" and genreID='"+(String)model.getValueAt(table.getSelectedRow(), 2) +"' ";
    				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer1?useTimezone=true&serverTimezone=UTC", "root", "1234");
    		        s=connect.prepareStatement(query);
    		        r=s.executeQuery();
    		        r.next();
    		        a=r.getInt(1);
    		        System.out.println(a);
    		     
    		     String query2="INSERT INTO playlistsongconnection (playlistID,songID) VALUES(?,?)";
    		     state=connect.prepareStatement(query2);
    		           state.setInt(1, a);
    		   
    		        state.setString(2, (String) model.getValueAt(table.getSelectedRow(), 0));
    		        state.executeUpdate();
    		       
    			} catch (SQLException eX) {
    				// TODO Auto-generated catch block
    				JOptionPane.showMessageDialog(null, "YOU ALREADY ADDED THIS SONG");
    				eX.printStackTrace();
    			}
    			
				
				
				
				
			}
		});

	}
	
}
