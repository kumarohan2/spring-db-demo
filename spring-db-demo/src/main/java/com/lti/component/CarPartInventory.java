package com.lti.component;

import java.util.List;

public interface CarPartInventory {
public void addNewPart(CarPart carPart);
	
	public List<CarPart> getAvailableParts();

public void updateStock(int partNo, int quantity); 

}
