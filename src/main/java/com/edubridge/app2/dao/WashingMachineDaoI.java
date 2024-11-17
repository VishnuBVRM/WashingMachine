package com.edubridge.app2.dao;

import java.util.List;

import com.edubridge.app2.model.WashingMachine;
import com.edubridge.app2.model.WashingMachine;

public interface WashingMachineDaoI {
	void addWashingMachine(WashingMachine washingMachine);

	List<WashingMachine> getAllWashingMachines();

	WashingMachine getWashingMachineById(Integer id);

	void updateWashingMachine(WashingMachine washingMachine);

	void deleteWashingMachine(Integer id);

	void deleteAllWashingMachines();
}
