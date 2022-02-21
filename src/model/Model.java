package model;

/*
 * @author_>Alejandro Honrubia

 */
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import views.AddData;
import views.FilterData;
import views.Home;
import views.SignUp;
import views.UpdateData;

public class Model {

	private Home home;
	private AddData addData;
	private FilterData filter = new FilterData();
	private UpdateData updateData = new UpdateData();
	private SignUp signup = new SignUp();

	// Attributes connection
	private String db = "manage-me";
	private String pwd = "";
	private String dbUser = "root";
	private String url = "jdbc:mysql://localhost/" + db;
	private Connection connection;

	// Querys
	private String sql1 = "select * from gastos;";
	private String sql2 = "select * from gastos where tipo='ocio'";
	private String sql3 = "Select * from gastos where tipo='vacaciones'";
	private String sql4 = "Select * from gastos where tipo='mensual'";
	private String sql5 = "select distinct tipo from gastos;";

	private DefaultTableModel modelG;

	// Encrypted
	private KeyGenerator keygen;
	private SecretKey key;
	private Cipher aesCipher;

	public void getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, dbUser, pwd);
			System.out.println("Connected to SqlServer");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Driver JDBC not found");
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("Error to connect DB");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("General error");
			e.printStackTrace();
		}
	}
	public String encryptPassword(String password) {
		String passwordEncrypted = null;
		try {
			System.out.println("Obteniendo generador de claves");
			keygen = KeyGenerator.getInstance("AES");
			System.out.println("Generando clave");
			key = keygen.generateKey();
			System.out.println("Obteniendo objeto Cipher con cifrado AES");
			Cipher aesCipher = Cipher.getInstance("AES");
			System.out.println("Configurando Cipher para encriptar");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			passwordEncrypted = new String(aesCipher.doFinal(password.getBytes()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return passwordEncrypted;
	}

	

	public void loadTableOcio(DefaultTableModel model2) {

		int columnsNum = getNumColumns(sql1);
		int rowsNum = getnumRows(sql1);
		String[] header = new String[columnsNum];
		Object[][] content = new Object[rowsNum][columnsNum];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql1);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnsNum; i++) {
				header[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnsNum; col++) {
					content[row][col - 1] = rset.getString(col);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelG = new DefaultTableModel(content, header);
		filter.setTableModel(modelG);
	}

	private int getNumColumns(String sql) {

		int num = 0;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	private int getnumRows(String sql) {

		int num = 0;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				num++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public void loadOption(String filter2) {

		String aux = filter.getCbChoosed();
		if (aux.equalsIgnoreCase(filter.getCbChoosed())) {
			String query = "select * from gastos where tipo='" + aux + "';";
			int columnsNum = getNumColumns(query);
			int rowsNum = getnumRows(query);
			String[] header = new String[columnsNum];
			Object[][] content = new Object[rowsNum][columnsNum];
			PreparedStatement pstmt;
			try {
				pstmt = connection.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();
				ResultSetMetaData rsmd = rset.getMetaData();
				for (int i = 0; i < columnsNum; i++) {
					header[i] = rsmd.getColumnName(i + 1);
				}
				int row = 0;
				while (rset.next()) {
					for (int col = 1; col <= columnsNum; col++) {
						content[row][col - 1] = rset.getString(col);
					}
					row++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			modelG = new DefaultTableModel(content, header);
			filter.setTableModel(modelG);
			filter.setVisible(false);
			filter.setVisible(true);
		}
	}

	public void cleanComboboxType() {

		filter.getCbFilter().removeAllItems();
	}

	public void filcomboType() {

		int columnsNum = getNumColumns(sql5);
		int rowsNum = getnumRows(sql5);
		String[] header = new String[columnsNum];

		Object[][] content = new Object[rowsNum][columnsNum];
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql5);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < columnsNum; i++) {

				header[i] = rsmd.getColumnName(i + 1);
			}
			int row = 0;
			while (rset.next()) {
				for (int col = 1; col <= columnsNum; col++) {
					content[row][col - 1] = rset.getString(col);
					String aux = (String) content[row][col - 1];
					filter.setCbFilter(aux);
				}
				row++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		filter.setVisible(false);
		filter.setVisible(true);

	}

	public void insertDB() {
		try {
			String name = addData.getTxtName();
			String type = addData.getTxtType();
			String pvp = addData.getTxtPvp();
			double aux = Double.parseDouble(pvp);
			String date = addData.getTxtDate();

			String query = "insert into gastos (nombre,tipo,precio,fecha) values(?,?,?,?);";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			pstmt.setDouble(3, aux);
			pstmt.setString(4, date);
			pstmt.executeUpdate();

			addData.setLblError("One row affected");
			addData.setTxtDate(null);
			addData.setTxtName(null);
			addData.setTxtPvp(null);
			addData.setTxtType(null);

		} catch (Exception e) {
			addData.setLblError("Error inserting row");
			addData.setTxtDate(null);
			addData.setTxtName(null);
			addData.setTxtPvp(null);
			addData.setTxtType(null);
		}
	}

	public void fillUpdateData(JTable table, DefaultTableModel model) {

		try {
			model = modelG;
			table = filter.getTable();
			int row = table.getSelectedRow();
			String id = table.getModel().getValueAt(row, 0).toString();
			String name = table.getModel().getValueAt(row, 1).toString();
			String type = table.getModel().getValueAt(row, 2).toString();
			String price = table.getModel().getValueAt(row, 3).toString();
			String date = table.getModel().getValueAt(row, 4).toString();

			updateData.setTxtID(id);
			updateData.setTxtName(name);
			updateData.setTxtType(type);
			updateData.setTxtPrice(price);
			updateData.setTxtDate(date);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateRow(String name, String type, String price, String date, String id) {

		try {
			double aux = Double.parseDouble(price);
			int aux2 = Integer.parseInt(id);
			String query = "update gastos set nombre=?,tipo=?, precio=?, fecha=? where id_gasto=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			pstmt.setDouble(3, aux);
			pstmt.setString(4, date);
			pstmt.setInt(5, aux2);
			pstmt.executeUpdate();
			updateData.setLblError("One row affected");

		} catch (Exception e) {
			updateData.setLblError("There was an error, check that all the fields are correct");
			e.printStackTrace();
		}
	}

	public void removeRow(JTable table, DefaultTableModel model) {

		try {
			model = modelG;
			table = filter.getTable();
			int row = table.getSelectedRow();
			String value = table.getModel().getValueAt(row, 0).toString();
			int aux = Integer.parseInt(value);
			String query = "delete from gastos where id_gasto=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, aux);
			pstmt.executeUpdate();
			model.removeRow(table.getSelectedRow());
			filter.setLblError("Row deleted successfully");
		} catch (Exception e) {
			filter.setLblError("You have not selected anything to remove");
		}

	}

	public void insertUser(String txtEmail, String txtUsername, char[] txtPassword) {

		String aux = String.valueOf(txtPassword);
		String query = "insert into users (username,email,password) values(?,?,?);";

		try {
			getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, txtUsername);
			pstmt.setString(2, txtEmail);
			pstmt.setString(3, encryptPassword(aux));
			pstmt.executeUpdate();
			System.out.println("Added user successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Setters

	public void setHome(Home home) {
		this.home = home;
	}

	public void setAddData(AddData addData) {
		this.addData = addData;
	}

	public void setFilterData(FilterData filterData) {
		this.filter = filterData;
	}

	public void SetUpdateData(UpdateData updateData) {
		this.updateData = updateData;
	}

	public void setSignUp(SignUp signup) {
		this.signup = signup;

	}

	public DefaultTableModel getModeloGeneral() {
		return modelG;
	}

	

}
