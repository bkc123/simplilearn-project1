package com.hcl.project1.operation;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileOperationImp implements FileOperation{
	Scanner sc = new Scanner(System.in);

	SortFiles m = new SortFiles();
	Path path = Paths.get(m.FOLDER);

	// add  by copying existing file
	@Override
	public void addExistingFile() throws InvalidPathException{
		System.out.print("Please provide a file path:");
		String filePath = sc.nextLine();
		Path path = Paths.get(filePath.toLowerCase());

		if (!Files.exists(path)) {
			System.out.println("File does not exist");
			return;
		}

		String newFilePath = m.FOLDER + "/" + path.getFileName();
		int inc = 0;
		while (Files.exists(Paths.get(newFilePath.toLowerCase()))) {
			inc++;
			newFilePath = m.FOLDER + "/" + inc + "_" + path.getFileName();
			//System.out.println("Successfully copied file to the " + newFilePath);
		}
		try {
			Files.copy(path, Paths.get(newFilePath));
			System.out.println("Successfully, copied file to the " + newFilePath);
		} catch(IOException e) {
			System.out.println("Sorry, can't copy file to " + newFilePath);
		}

	}
	// add new file to the default location
	public void addNewFile() {
		System.out.print("Please provide a file name:");
		String f = sc.nextLine();
		Path path=  Paths.get(f);
		String newFilePath= m.FOLDER + "/" + path.getFileName();
		//File file = new File(m.FOLDER + "/" + f);
		if (!Files.exists(Paths.get(newFilePath.toLowerCase()))){
			
				File file = new File(m.FOLDER + "/" + f);
				try {
					file.createNewFile();
					System.out.println("Successfully, created and added new  file to the " + file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Sorry, can't add " + f);
				}
		}
		else {
		System.out.println("Sorry, can't add " + f + ". It already exist in " + newFilePath.toLowerCase());
		}
		
	}
	
	// it is adding newFolder file to the default folder or location 
	@Override
	public void addNewFolder() {
		// TODO Auto-generated method stub
		System.out.print("Please provide a file name:");
		String f = sc.nextLine();
		String newPath = path + "/" + f;
		
		try {
			/*
			if (!Files.exists(Paths.get(newPath.toLowerCase()))){
				
				File file = new File(m.FOLDER + "/" + f);
				file.createNewFile();	
			}*/
			Files.copy(path, Paths.get(newPath));
			System.out.println("Successfully, added file to the " + f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, can't add " + f + ". It already exist in " + newPath.toLowerCase());
		}
	}
	
	@Override
	public void searchFile(String f) {
		// TODO Auto-generated method stub
		File[] files = new File(m.FOLDER).listFiles();
		System.out.println("------------------");
		System.out.println("Scanning through folder to search ");
		//Set<String > myTree= new TreeSet<>();
		boolean found= false;
		for (File file: files) {
			if ((file.getName()).equals(f)) {
				found= true;
				System.out.println( "Successfully able to locate " + file.getName() );
				break;
			}

		}
		if (found == false) {
			System.out.println("Sorry, unable to locate " + f);
		}


	}
	
	@Override
	public void deleteFile(String f) {
		// TODO Auto-generated method stub
		File[] files = new File(m.FOLDER).listFiles();
		System.out.println("------------------");
		System.out.println("Scanning thorugh folder to delete");
		
		boolean found= false;
		for (File file: files) {
			if ((file.getName()).equals(f)) {
				System.out.println(file.getName() + " has been successfully deleted.");
				file.delete();
				found= true;
				break;
			}

		}
		
		if (found == false) {
			System.out.println("Sorry,unable to delete " + f +".It doesn't exist in folder");
		}
		
		files = new File(m.FOLDER).listFiles();
		
		System.out.println ("\nList of files after deletion");
		for (File file: files) {	
			System.out.println( file.getName() );
		}

		/****System.out.println("Unable to delete " + f +" or " + f + " doesnot exist in this folder");
		Set <String > myTree = new TreeSet<>();
		for (File file: files) {
			if(!file.isFile()) {
				continue;
			}
			myTree.add(file.getName());
		}
		Boolean action= myTree.remove(f);
		
		if (action == true){
			System.out.println(f + " has been successfully deleted.");
		}else {
			System.out.println(" unable to delete " + f +" or " + f + " doesnot exist in this folder" );
		}
		myTree.forEach(file -> System.out.println(file));
		files = new File(myTree.toString()).listFiles();
		*****/	
	}


}
