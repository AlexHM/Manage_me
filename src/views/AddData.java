package views;
/*
 * @author_>Alejandro Honrubia

 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Model;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class AddData extends JFrame implements Views {

	private JPanel contentPane;
	private Controller controller;
	private Model model;
	private JButton btnBackArrow;
	private JLabel lblTitle;
	private JTextField txtName;
	private JTextField txtType;
	private JTextField txtPvp;
	private JButton btnSend;
	private JLabel lblName;
	private JLabel lblType;
	private JLabel lblPvp;
	private JTextField txtDate;
	private JLabel lblDate;
	private JLabel lblError;

	public AddData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(440, 250, 1005, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(AddData.class.getResource("/imgs/Data (1).png")));
		lblTitle.setBounds(425, 26, 105, 42);
		contentPane.add(lblTitle);

		btnBackArrow = new JButton("");
		btnBackArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.ChangeWindows(1, 0);
			}
		});
		btnBackArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBackArrow.setIcon(new ImageIcon(AddData.class.getResource("/imgs/backArrow_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBackArrow.setIcon(new ImageIcon(AddData.class.getResource("/imgs/backArrow 1_Shadow.png")));

			}
		});
		btnBackArrow.setIcon(new ImageIcon(AddData.class.getResource("/imgs/backArrow 1_Shadow.png")));
		btnBackArrow.setBackground(Color.WHITE);
		btnBackArrow.setBounds(10, 26, 89, 62);
		btnBackArrow.setFocusPainted(false);
		btnBackArrow.setBorderPainted(false);
		btnBackArrow.setContentAreaFilled(false);
		btnBackArrow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnBackArrow);

		txtName = new JTextField();
		txtName.setForeground(new Color(6, 11, 15));
		txtName.setBounds(41, 215, 161, 31);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtType = new JTextField();
		txtType.setForeground(new Color(6, 11, 15));
		txtType.setColumns(10);
		txtType.setBounds(231, 215, 161, 31);
		contentPane.add(txtType);

		txtPvp = new JTextField();
		txtPvp.setForeground(new Color(6, 11, 15));
		txtPvp.setColumns(10);
		txtPvp.setBounds(414, 215, 161, 31);
		contentPane.add(txtPvp);

		btnSend = new JButton("");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.insertDB();
			}
		});
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnSend.setIcon(new ImageIcon(AddData.class.getResource("/imgs/Send_Shadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSend.setIcon(new ImageIcon(AddData.class.getResource("/imgs/send_noShadow.png")));

			}
		});
		btnSend.setIcon(new ImageIcon(AddData.class.getResource("/imgs/Send_Shadow.png")));
		btnSend.setBounds(780, 202, 150, 49);
		btnSend.setFocusPainted(false);
		btnSend.setBorderPainted(false);
		btnSend.setContentAreaFilled(false);
		btnSend.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnSend);

		lblName = new JLabel("Name");
		lblName.setBounds(51, 190, 89, 14);
		contentPane.add(lblName);

		lblType = new JLabel("Type");
		lblType.setBounds(231, 190, 89, 14);
		contentPane.add(lblType);

		lblPvp = new JLabel("Price");
		lblPvp.setBounds(414, 190, 89, 14);
		contentPane.add(lblPvp);

		txtDate = new JTextField();
		txtDate.setForeground(new Color(6, 11, 15));
		txtDate.setColumns(10);
		txtDate.setBounds(595, 215, 161, 31);
		contentPane.add(txtDate);

		lblDate = new JLabel("Date (yy-mm-dd)");
		lblDate.setBounds(601, 190, 155, 14);
		contentPane.add(lblDate);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblError.setBounds(41, 312, 715, 14);
		contentPane.add(lblError);
	}

	public void setLblError(String lblError) {
		this.lblError.setText(lblError);
	}

	public String getTxtName() {
		return txtName.getText();
	}

	public String getTxtType() {
		return txtType.getText();
	}

	public String getTxtPvp() {
		return txtPvp.getText();
	}

	public String getTxtDate() {
		String aux = String.valueOf(txtDate.getText());
		return aux;
	}
	public void setTxtName(String txt) {
		this.txtName.setText(txt);
	}

	public void setTxtType(String txt) {
		this.txtType.setText(txt);
	}

	public void setTxtPvp(String txt) {
		this.txtPvp.setText(txt);
	}

	public void setTxtDate(String txt) {
		this.txtDate.setText(txt);
		
	}

	public void setController(Controller controller) {
		this.controller = controller;

	}
	public void setModel(Model model) {
		this.model = model;

	}
}
