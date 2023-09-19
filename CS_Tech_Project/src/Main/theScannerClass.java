package Main;


import java.io.*;
import java.util.*;
import Tahta.*;

public class theScannerClass {
	private String locationOfFile = "";
	public String theTotalString = "";
	
	
	public String getLocationOfFile() {
		return locationOfFile;
	}
	
	public void setLocationOfFile(String locationOfFile) {
		this.locationOfFile = locationOfFile;
	}
	
	public String getTheTotalString() {
		return theTotalString;
	}
	
	public void setTheTotalString(String theTotalString) {
		this.theTotalString = theTotalString;
	}
	
	public theScannerClass() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file location:");
	    String locationOfFile = scan.nextLine();  // Read user input
	    locationOfFile = locationOfFile.replace("\\", "\\\\");
	    System.out.println("File location is: " + locationOfFile); 
	    
	    
        File file = new File(locationOfFile);
    
        Scanner scan2 = new Scanner(file);
	
	    while (scan2.hasNextLine()) {
	        String theLine = scan2.nextLine();
	        theTotalString = theTotalString + theLine + "\n";
	        
	    }
	  

	}
	
}
