package util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;
import model.Appointment;
import model.Doctor;

public class DatabaseUtil {

	public EntityManagerFactory entityManagerFactory;
	public EntityManager entityManager;

	/**
	 * This is the setUp method
	 */
	public void setup()  {
		entityManagerFactory = Persistence.createEntityManagerFactory("veterinaryclinic");
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * this is the start transaction method
	 */
	public void startTransaction() {
		entityManager.getTransaction().begin();
	}

	/**
	 * 
	 */
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	/**
	 * 
	 */
	public void stop() {
		entityManager.clear();
	}
	
	/**
	 * @param animal
	 */
	public void saveAnimal(Animal animal) {
		entityManager.persist(animal);
	}
	
	/**
	 * @param appointment
	 */
	public void saveAppointment(Appointment appointment) {
		entityManager.persist(appointment);
	}
	
	/**
	 * @param doctor
	 */
	public void saveDoctor(Doctor doctor) {
		entityManager.persist(doctor);
	}
	
	/**
	 * @return all animals from db;
	 */
	public List<Animal> getAllAnimals() {
		List<Animal> animaList = (List<Animal>) entityManager.createNativeQuery("SELECT * FROM veterinaryclinic.animal", Animal.class).getResultList();
		return animaList;
	}
	
	/**
	 * @return
	 */
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctorList = (List<Doctor>) entityManager.createNativeQuery("SELECT * FROM veterinaryclinic.doctor");
		return doctorList;
	}
	
	/**
	 * @return
	 */
	public List<Appointment> getAllAppointments() {
		List<Appointment> appointmentList = (List<Appointment>) entityManager.createNativeQuery("SELECT * FROM veterinaryclinic.appointment");
		return appointmentList;
	}


}
