package views;
/*
 * @author_>Alejandro Honrubia

 */


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import model.Model;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class UpdateData extends JFrame implements Views {

	private FilterData filter=new FilterData();
	private Model model;
	private Controller controller;
	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblType;
	private JLabel lblPrice;
	private JLabel lblDate;
	private JTextField txtName;
	private JTextField txtType;
	private JTextField txtPrice;
	private JTextField txtDate;
	private JButton btnUpdate;
	private JLabel lblId;
	private JTextField txtID;
	private JButton btnBackArrow;
	private JLabel lblError;

	public UpdateData() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 351);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(146, 107, 59, 26);
		contentPane.add(lblName);
		
		lblType = new JLabel("Type");
		lblType.setBounds(304, 107, 59, 26);
		contentPane.add(lblType);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(455, 107, 59, 26);
		contentPane.add(lblPrice);
		
		lblDate = new JLabel("Date(yy-mm-dd)");
		lblDate.setBounds(542, 107, 124, 26);
		contentPane.add(lblDate);
		
		txtName = new JTextField();
		txtName.setBounds(99, 144, 136, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtType = new JTextField();
		txtType.setColumns(10);
		txtType.setBounds(245, 144, 154, 20);
		contentPane.add(txtType);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(414, 144, 113, 20);
		contentPane.add(txtPrice);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(537, 144, 97, 20);
		contentPane.add(txtDate);
		
		btnUpdate = new JButton("");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdate.setIcon(new ImageIcon(UpdateData.class.getResource("/imgs/btnUpdate_noShadow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdate.setIcon(new ImageIcon(UpdateData.class.getResource("/imgs/btnUpdate_shadow.png")));
			}
		});
		btnUpdate.setIcon(new ImageIcon(UpdateData.class.getResource("/imgs/btnUpdate_shadow.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.updateRow(getTxtName(),getTxtType(),getTxtPrice(),getTxtDate(),getTxtID());
				setTxtID(null);
				setTxtName(null);
				setTxtPrice(null);
				setTxtType(null);
				setTxtDate(null);
				
			}
		});
		btnUpdate.setBounds(651, 128, 174, 52);
		btnUpdate.setFocusPainted(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnUpdate);
		
		lblId = new JLabel("ID");
		lblId.setBounds(23, 107, 59, 26);
		contentPane.add(lblId);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(10, 144, 59, 20);
		contentPane.add(txtID);
		
		btnBackArrow = new JButton("");
		btnBackArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.ChangeWindows(3, 2);
				filter.setLblError(null);
				model.getConnection();
				
			}
		});
		btnBackArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBackArrow.setIcon(new ImageIcon(UpdateData.class.getResource("/imgs/backArrow_noShadow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBackArrow.setIcon(new ImageIcon(UpdateData.class.getResource("/imgs/backArrow 1_Shadow.png")));
			}
		});
		btnBackArrow.setIcon(new ImageIcon(UpdateData.class.getResource("/imgs/backArrow 1_Shadow.png")));
		btnBackArrow.setFocusPainted(false);
		btnBackArrow.setContentAreaFilled(false);
		btnBackArrow.setBorderPainted(false);
		btnBackArrow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnBackArrow.setBackground(Color.WHITE);
		btnBackArrow.setBounds(0, 0, 78, 52);
		contentPane.add(btnBackArrow);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblError.setBounds(235, 191, 448, 14);
		contentPane.add(lblError);
	}

	
	
	
	
	public void setLblError(String lblError) {
		this.lblError.setText(lblError);
	}





	public String getTxtID() {
		return txtID.getText();
	}





	public void setTxtID(String txtID) {
		this.txtID.setText(txtID);
	}





	public String getTxtName() {
		return txtName.getText();
	}

	public void setTxtName(String txtName) {
		this.txtName.setText(txtName);
	}

	public String getTxtType() {
		return txtType.getText();
	}

	public void setTxtType(String txtType) {
		this.txtType.setText(txtType);
	}

	public String getTxtPrice() {
		return txtPrice.getText();
	}

	public void setTxtPrice(String txtPrice) {
		this.txtPrice.setText(txtPrice);;
	}

	public String getTxtDate() {
		return txtDate.getText();
	}

	public void setTxtDate(String txtDate) {
		this.txtDate.setText(txtDate);
	}

	public void setModel(Model model) {
		this.model = model;

	}

	public void setController(Controller controller) {
		this.controller = controller;

	}
}
