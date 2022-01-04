package views;
/*
 * @author_>Alejandro Honrubia

 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import model.Model;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame implements Views{

	private JPanel contentPane;
	private Controller controller;
	private Model model;
	private JLabel lblManage;
	private JLabel lblIconHome;
	private JButton btnAddData;
	private JButton btnFilterData;


	public Home() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(440, 250, 1005, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblManage = new JLabel("");
		lblManage.setIcon(new ImageIcon(Home.class.getResource("/imgs/Manage2.png")));
		lblManage.setBounds(308, 25, 306, 69);
		contentPane.add(lblManage);
		
		lblIconHome = new JLabel("");
		lblIconHome.setIcon(new ImageIcon(Home.class.getResource("/imgs/Up-64px.png")));
		lblIconHome.setBounds(592, 11, 74, 95);
		contentPane.add(lblIconHome);
		
		btnAddData = new JButton("");
		btnAddData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.getConnection();
				controller.ChangeWindows(0, 1);
				
			}
		});
		btnAddData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddData.setIcon(new ImageIcon(Home.class.getResource("/imgs/addData_noShadow.png")));
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddData.setIcon(new ImageIcon(Home.class.getResource("/imgs/addData_Shadow(1).png")));
				
			}
		});
		btnAddData.setBackground(new Color(6, 11, 15));
		btnAddData.setBounds(141, 184, 281, 86);
		btnAddData.setFocusPainted(false);
		btnAddData.setBorderPainted(false);
		btnAddData.setContentAreaFilled(false);
		btnAddData.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnAddData.setIcon(new ImageIcon(Home.class.getResource("/imgs/addData_Shadow(1).png")));
		contentPane.add(btnAddData);
		
		btnFilterData = new JButton("");
		btnFilterData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.getConnection();
				controller.ChangeWindows(0, 2);
				controller.loadTableOcio();
				model.filcomboType();
			}
		});
		btnFilterData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFilterData.setIcon(new ImageIcon(Home.class.getResource("/imgs/FilterData_noShadow.png"))); 
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFilterData.setIcon(new ImageIcon(Home.class.getResource("/imgs/FilterData_Shadow(1).png"))); 
			}
		});
		btnFilterData.setIcon(new ImageIcon(Home.class.getResource("/imgs/FilterData_Shadow(1).png")));  
		btnFilterData.setFocusPainted(false);
		btnFilterData.setContentAreaFilled(false);
		btnFilterData.setBorderPainted(false);
		btnFilterData.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnFilterData.setBackground(new Color(6, 11, 15));
		btnFilterData.setBounds(524, 184, 281, 86);
		contentPane.add(btnFilterData);
		
		
	}


	public void setController(Controller controller) {
		this.controller=controller;
		
	}


	public void setModel(Model model) {
		this.model=model;
		
	}
}
