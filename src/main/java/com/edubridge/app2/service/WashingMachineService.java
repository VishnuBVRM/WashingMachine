package com.edubridge.app2.service;

import java.util.ArrayList;
import java.util.List;

import com.edubridge.app2.model.WashingMachine;

public class WashingMachineService {
	private List<WashingMachine> washingMachineList = new ArrayList<>();

	// Add WashingMachine
	public void addWashingMachine(WashingMachine washingMachine) {
		washingMachineList.add(washingMachine);
		System.out.println("Washing machine added successfully");
	}

	// Get all WashingMachines
	public List<WashingMachine> getAllWashingMachines() {
		return washingMachineList;
	}

	// Get WashingMachine by id
	public WashingMachine getWashingMachineById(int id) {
		for (WashingMachine washingMachine : washingMachineList) {
			if (washingMachine.getId() == id) {
				return washingMachine;
			}
		}
		return null;
	}

	// Update WashingMachine
	public void updateWashingMachine(WashingMachine washingMachine) {
		for (int i = 0; i < washingMachineList.size(); i++) {
			if (washingMachineList.get(i).getId() == washingMachine.getId()) {
				washingMachineList.set(i, washingMachine);
				System.out.println("Washing machine updated successfully");
				return;
			}
		}
		System.out.println("WashingMachine not found");
	}

	// Delete WashingMachine by id
	public void deleteWashingMachine(int id) {
		washingMachineList.removeIf(washingMachine -> washingMachine.getId() == id);
		System.out.println("Washing machine deleted successfully");
	}

	// Delete all WashingMachine
	public void deleteAllWashingMachines() {
		washingMachineList.clear();
		System.out.println("All Washing machine deleted");
	}

}
