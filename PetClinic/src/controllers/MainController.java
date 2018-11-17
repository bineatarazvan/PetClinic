package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Animal;
import util.DatabaseUtil;

public class MainController implements Initializable {

	@FXML
	private ListView<String> listView;

	public void populateMainListView() throws Exception {
		DatabaseUtil db = new DatabaseUtil() ;
			db.setup();
			db.startTransaction();
			List<Animal> animalDBList = (List<Animal>) db.getAllAnimals();
			ObservableList<String> animalNamesList = getAnimalName(animalDBList);
			listView.setItems(animalNamesList);
			listView.refresh();
			db.stop();
		}

	public ObservableList<String>  getAnimalName(List<Animal>animals){
		ObservableList<String> names = FXCollections.observableArrayList();
		for(Animal a:animals) {
			names.add(a.getName());
		}
		return names;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			populateMainListView();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
