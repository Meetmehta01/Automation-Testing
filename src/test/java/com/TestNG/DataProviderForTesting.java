package com.TestNG;

import org.testng.annotations.DataProvider;

public class DataProviderForTesting {
	@DataProvider
	public String[] flipkartforsearchdata() {
		String[] arr = new String[3];
		arr[0] = "Mobile";
		arr[1] = "Bluetooth Earphones";
		arr[2] = "Smart Watch";
		
		return arr;
		
	}
}
