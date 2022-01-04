package controller;

/*
 * @author_>Alejandro Honrubia

 */

import javax.swing.table.DefaultTableModel;

import model.Model;
import views.AddData;
import views.FilterData;
import views.Home;
import views.UpdateData;
import views.Views;

public class Controller {

	private Model model;
	private Views[] views;
	private AddData add= new AddData();
	private FilterData filter= new FilterData();
	private UpdateData updateData=new UpdateData();

	// BUILDER

	public Controller() {

		this.views = new Views[4];
		model = new Model();
	}
	
	public void ChangeWindows(int fromTo, int until) {
		views[fromTo].setVisible(false);
		views[until].setVisible(true);
	}
	
	//Setters

	public void setModel(Model model) {
		this.model=model;
	}

	public void setHome(Home home) {
		this.views[0]=home;
	}

	public void setAddData(AddData addData) {
		this.views[1]=addData;
	}


	public void setFilterData(FilterData filterData) {
		this.views[2]= filterData;
	}

	public void setUpdateData(UpdateData updateData) {
		this.views[3]=(Views) updateData;
	}

	public void getConnection() {
		model.getConnection();
	}

	public void insertDB() {
		model.insertDB();
	}

	public void loadTableOcio() {
		model.loadTableOcio(filter.getTableModel());
	}

	public void loadOption() {
		model.loadOption(filter.getCbChoosed());
	}

	public void cleanComboboxType() {
		model.cleanComboboxType();
	}

	public void removeRow() {
		model.removeRow(filter.getTable(),filter.getTableModel());	
	}

	public void fillUpdateData(DefaultTableModel model) {
		this.model.fillUpdateData(filter.getTable(),filter.getTableModel());	
	}

	public void updateRow(String name, String type, String price, String date, String id) {
		model.updateRow(name,type,price,date,id);	
	}
}
