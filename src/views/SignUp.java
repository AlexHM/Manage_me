package views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import model.Model;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame implements Views {

	private JPanel contentPane;
	private Controller controller;
	private Model model;
	private JLabel lblLoginTitle;
	private JPasswordField txtPassword;
	private JTextField txtEmail;
	private JButton btnSignUp;
	private JTextField txtUsername;

	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(440, 250, 1005, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLoginTitle = new JLabel("SIGN UP");
		lblLoginTitle.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblLoginTitle.setBounds(411, 49, 209, 37);
		contentPane.add(lblLoginTitle);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(367, 164, 234, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(367, 257, 234, 20);
		contentPane.add(txtPassword);
		
		btnSignUp = new JButton("sign up!");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.insertUser(getTxtEmail(),getTxtUsername(),getTxtPassword());
				controller.ChangeWindows(4, 0);
				
			}
		});
		btnSignUp.setBounds(437, 309, 89, 23);
		contentPane.add(btnSignUp);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(367, 210, 234, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
	}

	
	

	
	// Getters
	public String getTxtEmail() {
		return txtEmail.getText();
	}
	public char[] getTxtPassword() {
		return txtPassword.getPassword();
	}
	public String getTxtUsername() {
		return txtUsername.getText();
	}

	//Setters
	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}
	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}
}
