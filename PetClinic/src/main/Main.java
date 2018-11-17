package main;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Animal;
import model.Appointment;
import model.Doctor;
import util.DatabaseUtil;

public class Main extends Application {

//	public static void main(String[] args) {
	// Initialize the animal
//	Animal bob = new Animal();
//	bob.setName("Bob");
//	bob.setIdanimal(3);
//	Doctor d = new Doctor();
//	d.setName("Dr. DoLitlle");
//	d.setIddoctor(3);
//	List<Appointment> bobsAppointment = new ArrayList<>();
//	Appointment a = new Appointment();
//	a.setIdappointment(3);
//	a.setType("Consultanta");
//	a.setAnimal(bob);
//	a.setDoctor(d);
//	bobsAppointment.add(a);
//	bob.setAppointments(bobsAppointment);
//	d.setAppointments(bobsAppointment);
	
	// this is the db util
//	DatabaseUtil dbUtil = new DatabaseUtil();
//	dbUtil.setup();
//	dbUtil.startTransaction();
////	dbUtil.saveDoctor(d);
////	dbUtil.saveAnimal(bob);
////	dbUtil.saveAppointment(a);
//	dbUtil.commitTransaction();
//	for(Animal animal: dbUtil.getAllAnimals()) {
//	System.out.println("Animal name:" + animal.getName());
//	String appName = animal.getAppointments().get(0).getType();
//	System.out.println("This is the type of the appoinment " + appName);
//	}
//	dbUtil.stop();
//	
//	
		
		@Override
		public void start(Stage primaryStage) /*throws Exception */{
			try {
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/controllers/MainView.fxml"));
				Scene scene = new Scene(root,800,800);
				//scene.getStylesheets().add(getClass().getResource("/controllers/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) throws Exception {
			populateDB();
			launch(args);
		}

		private static void populateDB() {
	//		Initialize the animal, appointment,doctor; 
			Animal bob = new Animal();
			Appointment a = new Appointment();
			Doctor d = new Doctor();
			
			bob.setIdAnimal(2);
			bob.setName("Bob");
			
			d.setIdDoctor(2);
			d.setName("Dr. DoLitlle");		
			List<Appointment> bobsAppointment = new ArrayList<>();
			
			a.setIdappointment(2);
			a.setAnimal(bob);
			a.setDoctor(d);
			a.setType("Consultanta");	
			
			bobsAppointment.add(a);
			bob.setAppointments(bobsAppointment);
			d.setAppointments(bobsAppointment);
			
			
			DatabaseUtil dbUtil = new DatabaseUtil();
			try {
				dbUtil.setup();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbUtil.startTransaction();
			
			dbUtil.saveAnimal(bob);
			dbUtil.saveDoctor(d);
			dbUtil.saveAppointment(a);
			
			dbUtil.commitTransaction();
			for(Animal animal: dbUtil.getAllAnimals()) {
			System.out.println("Animal name:" + animal.getName());
			String appName = animal.getAppointments().get(0).getType();
			System.out.println("This is the type of the appoinment " + appName);
			}
			dbUtil.stop();
			
		}
	}
