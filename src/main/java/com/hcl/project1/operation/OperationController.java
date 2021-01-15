package com.hcl.project1.operation;

import java.util.Scanner;

public class OperationController {

	Scanner sc = new Scanner(System.in);
	//final String FOLDER = "C:\\Users\\chhan\\Documents\\New folder";
	FileOperationImp file= new FileOperationImp();
	SortFiles mn= new SortFiles();
	//Project1MenuOption mainMenu = new Project1MenuOption();
	String f;

	public void showMenu(){
		System.out.println(" ***Main Menu*** ");
		System.out.println("1.) Show files in ascending order");
		System.out.println("2.) Perform file operations");
		System.out.println("3.) Close the application");
		System.out.println("---------------");
		this.menuOption();
	}

	//menu menuOption
	public void menuOption() {
		System.out.print("Enter your choice from 1, 2 or 3: ");
		String option = sc.nextLine();
		switch (option) {
		case "1":
			mn.showFilesInAscendingOrder();
			break;
		case "2":
			this.showFileOperations();
		case "3":
			System.out.println("Thanks for using SimplilearnProject1.hcl.com. Closing application.");
			System.exit(0);
			break;
		default:
			System.out.println("Entered Invalid input, please choose 1, 2 or 3.");

		}
		showMenu();
	}
	// File Menu Options
	public void showFileOperations() {
		System.out.println("--------------");
		System.out.println("1.) Add a file");
		System.out.println("2.) Delete a file");
		System.out.println("3.) Search for a file");
		System.out.println("4.) Back to main menu");
		System.out.println("--------------");
		fileOperation();
	}

	// File operation option
	public void fileOperation() {
		System.out.print("Please enter your choice from 1, 2, 3 or 4 : ");
		String choice = sc.nextLine();

		switch(choice) {
		case "1":
			showAddFileOperations();
			break;

		case "2": 
			System.out.print("Please enter a file to delete: ");
			f= sc.nextLine();
			file.deleteFile(f);
			break;

		case "3": 
			System.out.print("Please enter a file to search: ");
			f= sc.nextLine();
			file.searchFile(f);
			break;

		case "4":
			showMenu();
			break;

		default:
			System.out.println("Entered Invalid input, please choose 1, 2, 3 or 4.");

		}
		showFileOperations();
	}

	// add options menu
	public void showAddFileOperations() {
		System.out.println("--------------" +
				"\n1.) Add an existing file from another folder"+
				"\n2.) Add a new file to the folder" +
				"\n3.) Add a new file alternative way(without parameter method) " +
				"\n4.) Back to fileOperation menu" +
				"\n--------------");
		addOperation();
	}

	//add operations or options for file
	public void addOperation() {
		System.out.print("Please enter your choice from 1, 2, 3 or 4 : ");
		String choice = sc.nextLine();

		switch(choice) {
		case "1":
			file.addExistingFile();
			break;

		case "2":
			
			file.addNewFile();
			break;
			
		case "3":
			file.addNewFolder();
			break;

		case "4":
			showFileOperations();
			break;

		default:
			System.out.println("Entered Invalid input, please choose 1, 2, 3 or 4.");

		}
		showAddFileOperations();

	}


}
