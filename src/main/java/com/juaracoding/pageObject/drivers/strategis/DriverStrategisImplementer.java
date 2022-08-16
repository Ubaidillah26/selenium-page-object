package com.juaracoding.pageObject.drivers.strategis;

public class DriverStrategisImplementer {

	public static DriverStrategis chooseStrategis(String strategis) {
		switch (strategis) {
		case "Chrome":
			return new Chrome();
			
		case "Firefox":
			return new Firefox();
			
		default:
			return null;
		}
		
	}
	
}
