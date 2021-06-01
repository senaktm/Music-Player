package proje3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
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
		
		JLabel lblChooseToEdt = new JLabel("CHOOSE TO EDIT\n\r\n");
		lblChooseToEdt.setForeground(Color.LIGHT_GRAY);
		lblChooseToEdt.setFont(new Font("MingLiU_HKSCS-ExtB", Font.BOLD, 30));
		lblChooseToEdt.setBounds(230, 158, 248, 46);
		panel.add(lblChooseToEdt);
		
		JLabel lblNewLabel = new JLabel("WELCOME BACK ADMIN,\r\n\r\n");
		lblNewLabel.setFont(new Font("MingLiU_HKSCS-ExtB", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(91, 114, 319, 46);
		panel.add(lblNewLabel);
		
		JButton btnAlbum = new JButton("ALBUM");
		btnAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
				AddAlbumAdmin albumAdmin = new AddAlbumAdmin();
				albumAdmin.setVisible(true);
			
			}
		});
		btnAlbum.setForeground(Color.LIGHT_GRAY);
		btnAlbum.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAlbum.setBackground(Color.BLACK);
		btnAlbum.setBounds(849, 228, 260, 197);
		panel.add(btnAlbum);
		
		JButton btnSnger = new JButton("SINGER");
		btnSnger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddSingerAdmin singerAdmin= new AddSingerAdmin();
				singerAdmin.setVisible(true);
				
			}
		});
		btnSnger.setForeground(Color.LIGHT_GRAY);
		btnSnger.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSnger.setBackground(Color.BLACK);
		btnSnger.setBounds(450, 228, 260, 197);
		panel.add(btnSnger);
		
		JButton btnNewButton = new JButton("SONG ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSongAdmin addsongadmin= new AddSongAdmin();
				addsongadmin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(53, 228, 260, 197);
		panel.add(btnNewButton);
		
		JTextArea txtrWelcomeBack = new JTextArea();
		txtrWelcomeBack.setForeground(Color.WHITE);
		txtrWelcomeBack.setOpaque(false);
		txtrWelcomeBack.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		txtrWelcomeBack.setText("A D M I N  P A N E L\r\n____________________\r\n\r\n    ");
		txtrWelcomeBack.setBounds(502, 11, 319, 84);
		panel.add(txtrWelcomeBack);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\FIRAT\\Desktop\\PROLAB II-proje3\\proje3\\pics\\adminPanel.jpg"));
		lblNewLabel_1.setBounds(-10, 0, 1177, 807);
		panel.add(lblNewLabel_1);
	}
}
