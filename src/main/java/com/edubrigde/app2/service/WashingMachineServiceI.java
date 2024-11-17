package com.edubrigde.app2.service;

import java.util.List;

import com.edubridge.app2.model.WashingMachine;

public interface WashingMachineServiceI {
	void addWashingMachine(WashingMachine washingMachine);

	List<WashingMachine> getAllWashingMachine();

	WashingMachine getWashingMachineById(Integer id);

	void updateWashingMachine(WashingMachine washingMachine);

	void deleteWashingMachine(Integer id);

	void deleteAllWashingMachine();
}
