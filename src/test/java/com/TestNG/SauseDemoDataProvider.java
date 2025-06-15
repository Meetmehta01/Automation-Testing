package com.TestNG;

import org.testng.annotations.DataProvider;

public class SauseDemoDataProvider {
	@DataProvider
	public String[][]sauseDemoLogin(){
		String arr[][] = new String[6][2];
		arr[0][0] = "standard_user";
		arr[0][1] = "secret_sauce";
		arr[1][0] = "locked_out_user";
		arr[1][1] = "secret_sauce";
		arr[2][0] = "problem_user";
		arr[2][1] = "secret_sauce";
		arr[3][0] = "performance_glitch_user";
		arr[3][1] = "secret_sauce";
		arr[4][0] = "error_user";
		arr[4][1] = "secret_sauce";
		arr[5][0] = "visual_user";
		arr[5][1] = "secret_sauce";
		
		return arr;
	}
}
