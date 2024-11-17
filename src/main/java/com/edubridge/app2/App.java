package com.edubridge.app2;

import java.util.List;
import java.util.Scanner;

import com.edubridge.app2.model.WashingMachine; // Import WashingMachine model
import com.edubridge.app2.service.WashingMachineService; // Import service for washing machines

public class App {
	public static void main(String[] args) {
		int option = 0;
		Scanner in = new Scanner(System.in);
		WashingMachineService service = new WashingMachineService(); // Instantiate service for washing machines
		String name, email, mobile;
		name = email = mobile = null;

		do {
			System.out.println("Welcome to Washing Machine Management Application");
			System.out.println("=======================================");
			System.out.println("1. Add Washing Machine");
			System.out.println("2. View All Washing Machines");
			System.out.println("3. Search Washing Machine");
			System.out.println("4. Update Washing Machine");
			System.out.println("5. Delete Washing Machine");
			System.out.println("6. Delete All Washing Machines");
			System.out.println("0. Exit");
			System.out.println("Please choose option: ");
			option = in.nextInt();

			switch (option) {
			case 1:
				System.out.println("Add New Washing Machine");
				System.out.println("------------");
				System.out.println("Enter Washing Machine Name (Model/Brand): ");
				name = in.next();
				System.out.println("Enter Washing Machine Email (Service Center): ");
				email = in.next();
				System.out.println("Enter Washing Machine Mobile (Support Contact): ");
				mobile = in.next();

				WashingMachine wm = new WashingMachine();
				wm.setName(name);
				wm.setEmail(email);
				wm.setMobile(mobile);

				service.addWashingMachine(wm); // Add washing machine
				break;

			case 2:
				System.out.println("View All Washing Machines");
				System.out.println("-------------------------");
				List<WashingMachine> washingMachines = service.getAllWashingMachines(); // Fetch all washing machines
				if (!washingMachines.isEmpty()) {
					for (WashingMachine w : washingMachines) {
						System.out.println(w.getId() + "\t" + w.getName() + "\t" + w.getEmail() + "\t" + w.getMobile());
					}
				} else {
					System.out.println("No washing machines found");
				}
				break;

			case 3:
				System.out.println("Search Washing Machine");
				System.out.println("-----------------------");
				System.out.println("Please enter washing machine id: ");
				int id = in.nextInt();
				WashingMachine foundWm = service.getWashingMachineById(id); // Search washing machine by ID
				if (foundWm != null) {
					System.out.println("Washing Machine Name: " + foundWm.getName());
					System.out.println("Washing Machine Email: " + foundWm.getEmail());
					System.out.println("Washing Machine Mobile: " + foundWm.getMobile());
				} else {
					System.out.println("No washing machine found with id: " + id);
				}
				break;

			case 4:
				System.out.println("Update Washing Machine Details");
				System.out.println("------------------------------");
				System.out.println("Enter Washing Machine Id: ");
				int wmId = in.nextInt();
				System.out.println("Enter Washing Machine Name (Model/Brand): ");
				name = in.next();
				System.out.println("Enter Washing Machine Email (Service Center): ");
				email = in.next();
				System.out.println("Enter Washing Machine Mobile (Support Contact): ");
				mobile = in.next();

				WashingMachine updatedWm = new WashingMachine();
				updatedWm.setId(wmId);
				updatedWm.setName(name);
				updatedWm.setEmail(email);
				updatedWm.setMobile(mobile);

				service.updateWashingMachine(updatedWm); // Update washing machine details
				break;

			case 5:
				System.out.println("Delete Washing Machine");
				System.out.println("----------------------");
				System.out.println("Please enter washing machine id: ");
				int wmIdToDelete = in.nextInt();
				service.deleteWashingMachine(wmIdToDelete); // Delete washing machine by ID
				break;

			case 6:
				System.out.println("Are you sure you want to delete all washing machines? [Y/N]");
				String confirm = in.next();
				if (confirm.equalsIgnoreCase("Y")) {
					service.deleteAllWashingMachines(); // Delete all washing machines
				}
				break;

			case 0:
				System.out.println("Bye!!!");
				System.exit(0);
				break;

			default:
				System.out.println("Please choose a correct option.");
				break;
			}

		} while (option != 0);
	}
}
