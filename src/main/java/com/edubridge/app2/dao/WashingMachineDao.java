package com.edubridge.app2.dao;

import com.edubridge.app2.model.WashingMachine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class WashingMachineDao {

	private EntityManagerFactory emf;
	private EntityManager em;

	public WashingMachineDao() {
		// Initialize the EntityManagerFactory and EntityManager
		emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");
		em = emf.createEntityManager();
	}

	// Add a new washing machine
	public void addWashingMachine(WashingMachine washingMachine) {
		try {
			em.getTransaction().begin();
			em.persist(washingMachine); // Save the washing machine object to the database
			em.getTransaction().commit();
			System.out.println("Washing Machine added successfully.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// Get all washing machines
	public List<WashingMachine> getAllWashingMachines() {
		try {
			TypedQuery<WashingMachine> query = em.createQuery("SELECT wm FROM WashingMachine wm", WashingMachine.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Get a washing machine by ID
	public WashingMachine getWashingMachineById(int id) {
		try {
			return em.find(WashingMachine.class, id); // Find washing machine by ID
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Update a washing machine's details
	public void updateWashingMachine(WashingMachine washingMachine) {
		try {
			em.getTransaction().begin();
			em.merge(washingMachine); // Merge the updated washing machine object into the database
			em.getTransaction().commit();
			System.out.println("Washing Machine updated successfully.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// Delete a washing machine by ID
	public void deleteWashingMachine(int id) {
		try {
			em.getTransaction().begin();
			WashingMachine washingMachine = em.find(WashingMachine.class, id);
			if (washingMachine != null) {
				em.remove(washingMachine); // Remove the washing machine object from the database
				em.getTransaction().commit();
				System.out.println("Washing Machine deleted successfully.");
			} else {
				System.out.println("No washing machine found with the given ID.");
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// Delete all washing machines
	public void deleteAllWashingMachines() {
		try {
			em.getTransaction().begin();
			TypedQuery<WashingMachine> query = em.createQuery("SELECT wm FROM WashingMachine wm", WashingMachine.class);
			List<WashingMachine> washingMachines = query.getResultList();
			for (WashingMachine wm : washingMachines) {
				em.remove(wm); // Remove each washing machine
			}
			em.getTransaction().commit();
			System.out.println("All Washing Machines deleted successfully.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// Close EntityManager when done
	public void close() {
		em.close();
		emf.close();
	}
}
