package com.hcl.project1.operation;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;



public class SortFiles extends AbstractSortFiles {

	final String FOLDER = "C:\\Users\\chhan\\Documents\\New folder";

	@Override
	public void showFilesInAscendingOrder() {
		System.out.println("------------------");
		System.out.println("Displaying files in ascending order");
	
			File[] files = new File(FOLDER).listFiles();
			//check if it contains any file
			if (files.length == 0){
				System.out.println("There is not any files to dispaly in ascending order");
			}else {
				// create tree set to sort the file
			Set<String> sorted = new TreeSet<>();
			for (File file: files) {
				/*if (!file.isFile()) {
					continue;
				} 
				*/
				sorted.add(file.getName());
			}
			//sorted.forEach(file -> {System.out.println(file);});
			sorted.forEach(System.out::println);
			System.out.println("------------------");
		
			}
		
	}



}
