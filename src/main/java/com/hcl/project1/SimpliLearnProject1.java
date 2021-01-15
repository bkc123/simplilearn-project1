package com.hcl.project1;

import com.hcl.project1.operation.OperationController;

public class SimpliLearnProject1 {

	public static void main(String[] args) {
		welcomeScreen();
		OperationController menu = new OperationController();
		menu.showMenu();
     
	}
	
	//Welcome Screen
	 private static void welcomeScreen() {
	        System.out.println("----------------------------------------");
	        System.out.println("Application: SimpliLearnProject1.hcl.com");
	        System.out.println("Developer: Bishnu K Chhantyal");
	        System.out.println("----------------------------------------");
	    }

}
