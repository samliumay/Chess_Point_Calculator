package Main;


import java.io.*;
import java.util.*;
import Tahta.*;

//Modifiye edilmis ozel bir scanner classi. Bazi ozel fonskyonlar main classinda cok yer tutmasin diye yazdim.

public class theScannerClass {
	
	//Tahtanin lokasyonu ve kendisinin tutuldugu yer
	private String locationOfFile = "";
	public String theTotalString = "";
	
	//Setter ve getterlar
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
	
	//Burada ozellikle girilen inputta bazi duzeltmeler yaparak java file reader'ının dosyayi bulabilecegi bir formata getirdim. 
	//Sonrasinda da dosyayi okudum ve icidnekileri de 'theTotalString' variable'ina kayit ettim. 
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
