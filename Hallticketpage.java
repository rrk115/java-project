package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Hallticketpage extends defaultFrame {
	
	Hallticketpage(){
		F.setTitle("HALLTICKET PAGE");
		F.getContentPane().setBackground(new Color(255, 182, 193));
		F.setSize(800,600);
		F.setLayout(null);
		
		
		JTextField txtCbseBordOf = new JTextField();
		txtCbseBordOf.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 16));
		txtCbseBordOf.setText("CBSE BORD OF EXAMINATION");
		txtCbseBordOf.setBounds(237, 48, 247, 43);
		F.add(txtCbseBordOf);
		txtCbseBordOf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("STUDENT ID");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(169, 171, 155, 33);
		F.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DATE OF BIRTH");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(169, 268, 155, 44);
		F.add(lblNewLabel_1);
		

		JTextArea textArea = new JTextArea();
		textArea.setBounds(389, 171, 252, 33);
		F.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(389, 280, 252, 32);
		F.add(textArea_1);
		
		JButton btnNewButton = new JButton("DOWNLOAD HALLTICKET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c = null;
				Statement stmt = null;
			      try {
			         Class.forName("org.postgresql.Driver");
			         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1793");
			         stmt = c.createStatement();
			        final int id = Integer.parseInt(textArea.getText());
			        final String dob = textArea_1.getText();
			         String sql = "select * from student where student_roll ='"+id+"' and date_of_birth ='"+dob+"' ";
			         ResultSet rs = stmt.executeQuery(sql);
			         
			         
			         if(rs.next()) {
			        	 String name = rs.getString("first_name");
			        	 Connection c1 = null;
							Statement stmt1 = null;
						      try {
						         Class.forName("org.postgresql.Driver");
						         c1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1793");
						         stmt1 = c1.createStatement();
						         
						         String sql1 = "select * from hall_ticket where student_roll ='"+id+"' ";
						         ResultSet rs1 = stmt.executeQuery(sql1);
						         
						         while(rs1.next()) {
						        	 
						        	 String htno = rs1.getString("hall_ticket_num");
						        	 JFrame l = new JFrame();
						        	 l.getContentPane().setBackground(new Color(255, 182, 193));
						        		l.setSize(1200,600);
						        		l.setLayout(null);
						        		
						        		JLabel lblNewLabel = new JLabel("");
						        		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gayat\\Downloads\\photo.png"));
						        		lblNewLabel.setBounds(823, 52, 200, 182);
						        		l.add(lblNewLabel);
						        		
						        		JLabel lblNewLabel_1 = new JLabel("");
						        		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\gayat\\Downloads\\cbse name.png"));
						        		lblNewLabel_1.setBounds(123, 63, 527, 129);
						        		l.add(lblNewLabel_1);
						        		
						        		JLabel lblNewLabel_2 = new JLabel("STUDENT ID     :");
						        		lblNewLabel_2.setBounds(360, 221, 128, 27);
						        		l.add(lblNewLabel_2);
						        		
						        		JLabel lblNewLabel_3 = new JLabel(textArea.getText());
						        		lblNewLabel_3.setBounds(522, 224, 101, 20);
						        		l.add(lblNewLabel_3);
						        		
						        		JLabel lblNewLabel_4 = new JLabel("STUDENT NAME :");
						        		lblNewLabel_4.setBounds(317, 275, 138, 27);
						        		l.add(lblNewLabel_4);
						        		
						        		JLabel lblNewLabel_5 = new JLabel(name);
						        		lblNewLabel_5.setBounds(514, 282, 109, 20);
						        		l.add(lblNewLabel_5);
						        		
						        		
						        		JLabel lblNewLabel_6 = new JLabel("HALLTICKET NUMBER:");
						        		lblNewLabel_6.setBounds(322, 329, 150, 20);
						        		l.add(lblNewLabel_6);
						        		
						        		JLabel lblNewLabel_7 = new JLabel(htno);
						        		lblNewLabel_7.setBounds(525, 329, 114, 20);
						        		l.add(lblNewLabel_7);
						        		
						        		
						        		JButton btnNewButton = new JButton("DOWNLOAD HALLTICKET");
						        		btnNewButton.addActionListener(new ActionListener() {
						        			public void actionPerformed(ActionEvent e) {
						        				JOptionPane.showMessageDialog(l,"SUCCUESSFULLY DOWNLOADED");
						        			}
						        		});
						        		btnNewButton.setBounds(421, 412, 185, 27);
						        		l.add(btnNewButton);
						        		JButton btnNewButton_1 = new JButton("BACK");
						        		btnNewButton_1.addActionListener(new ActionListener() {
						        			public void actionPerformed(ActionEvent e) {
						        				l.setVisible(false);
						        			}
						        		});
						        		btnNewButton_1.setBounds(10, 24, 85, 21);
						        		l.add(btnNewButton_1);
						        		l.setVisible(true);
						         }
						         
						      } catch (Exception e2) {
							         e2.printStackTrace();
							         System.err.println(e2.getClass().getName()+": "+e2.getMessage());
							         System.exit(0);
							      }
						      
			         }
			         else {
			        	 JOptionPane.showMessageDialog(F, "INVALID CREDITCS");
			         }
			         c.close();
			         stmt.close();
			      } catch (Exception e1) {
			         e1.printStackTrace();
			         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
			         System.exit(0);
			      }
				
			}
		});
		btnNewButton.setBounds(300, 442, 200, 33);
		F.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 24, 85, 21);
		F.add(btnNewButton_1);
		F.setVisible(true);
		
	}

}
