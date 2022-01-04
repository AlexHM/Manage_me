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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class FilterData extends JFrame implements Views {

	private JPanel contentPane;
	private Controller controller;
	private Model model;
	private JButton btnBackArrow;
	private JComboBox cbFilter;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private String cbChoosed = "";
	private JLabel lblType;
	private JButton btnRemove;
	private JLabel lblError;
	private JButton btnUpdate;

	public FilterData() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				table.setModel(model.getModeloGeneral());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(440, 250, 1011, 652);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnBackArrow = new JButton("");
		btnBackArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.ChangeWindows(2, 0);
				controller.cleanComboboxType();
				setLblError(null);
			}
		});
		btnBackArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBackArrow.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/backArrow_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBackArrow.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/backArrow 1_Shadow.png")));
			}
		});
		btnBackArrow.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/backArrow 1_Shadow.png")));
		btnBackArrow.setBackground(Color.WHITE);
		btnBackArrow.setBounds(10, 26, 89, 62);
		btnBackArrow.setFocusPainted(false);
		btnBackArrow.setBorderPainted(false);
		btnBackArrow.setContentAreaFilled(false);
		btnBackArrow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnBackArrow);

		cbFilter = new JComboBox();
		cbFilter.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 11));
		cbFilter.addItemListener(event -> {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				cbChoosed = event.getItem().toString();
				controller.loadOption();
			}
		});
		cbFilter.setBounds(131, 116, 97, 22);
		contentPane.add(cbFilter);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 169, 732, 196);
		contentPane.add(scrollPane);

		table = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "New column" });

		scrollPane.setViewportView(table);

		lblType = new JLabel("Type");
		lblType.setBounds(131, 91, 67, 14);
		contentPane.add(lblType);
		
		btnRemove = new JButton("");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.removeRow();
			}
		});
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRemove.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/btnRemove_noShadow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRemove.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/btnRemove_Shadow.png")));
			}
		});
		btnRemove.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/btnRemove_Shadow.png")));
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setBounds(131, 398, 131, 62);
		btnRemove.setFocusPainted(false);
		btnRemove.setBorderPainted(false);
		btnRemove.setContentAreaFilled(false);
		btnRemove.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnRemove);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblError.setBounds(358, 546, 339, 14);
		contentPane.add(lblError);
		
		btnUpdate = new JButton("");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdate.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/btnUpdate_noShadow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdate.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/btnUpdate_shadow.png")));
			}
		});
		btnUpdate.setIcon(new ImageIcon(FilterData.class.getResource("/imgs/btnUpdate_shadow.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row=table.getSelectedRowCount();
				if (row>0) {
					controller.ChangeWindows(2, 3);
					controller.fillUpdateData(getTableModel());
				}else {
					setLblError("You have not selected anything to update");
				}
			}
		});
		btnUpdate.setBounds(717, 412, 146, 48);
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnUpdate);
	}

	public void setLblError(String lblError) {
		this.lblError.setText(lblError);
	}

	public JTable getTable() {
		return table;
	}

	public JComboBox getCbFilter() {
		return cbFilter;
	}

	@SuppressWarnings("unchecked")
	public void setCbFilter(String string) {
		this.cbFilter.addItem(string);
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public int getCbFilter2() {
		return cbFilter.getSelectedIndex();
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public String getCbChoosed() {
		return cbChoosed;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
