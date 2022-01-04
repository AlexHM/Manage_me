package controller;

/*
 * @author_>Alejandro Honrubia

 */


import model.Model;
import views.AddData;
import views.FilterData;
import views.Home;
import views.UpdateData;

public class Launcher {

	public static void main(String[] args) {

		Controller controller = new Controller();
		Model model = new Model();
		Home home = new Home();
		AddData addData = new AddData();
		FilterData filterData= new FilterData();
		UpdateData updateData= new UpdateData();

		// MVC
		// controller knows model and views
		controller.setModel(model);
		controller.setHome(home);
		controller.setAddData(addData);
		controller.setFilterData(filterData);
		controller.setUpdateData(updateData);


		// model knows views
		model.setHome(home);
		model.setAddData(addData);
		model.setFilterData(filterData);
		model.SetUpdateData(updateData);


		// views knows model and controller
		home.setController(controller);
		home.setModel(model);
		addData.setController(controller);
		addData.setModel(model);
		filterData.setController(controller);
		filterData.setModel(model);
		updateData.setModel(model);
		updateData.setController(controller);


		home.setVisible(true);

	}

}
