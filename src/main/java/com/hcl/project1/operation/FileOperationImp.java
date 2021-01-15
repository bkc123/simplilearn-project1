package com.hcl.project1.operation;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.*;

public class FileOperationImp implements FileOperation{
	Scanner sc = new Scanner(System.in);

	SortFiles m = new SortFiles();
	Path path = Paths.get(m.FOLDER);


	@Override
	public void addFile() throws InvalidPathException{
		System.out.print("Please provide a file path:");
		String filePath = sc.nextLine();
		Path path = Paths.get(filePath);

		if (!Files.exists(path)) {
			System.out.println("File does not exist");
			return;
		}

		String newFilePath = m.FOLDER + "/" + path.getFileName();
		int inc = 0;
		while (Files.exists(Paths.get(newFilePath))) {
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
		
	
	}


}
