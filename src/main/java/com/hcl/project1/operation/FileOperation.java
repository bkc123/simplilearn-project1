package com.hcl.project1.operation;

import java.io.File;
import java.io.IOException;

public interface FileOperation {
	
	
	public void addExistingFile();
	
	public void addNewFile();
	
	public void addNewFolder();
	
	public void searchFile(String f);
	
	public void deleteFile(String f);
	
	
}
