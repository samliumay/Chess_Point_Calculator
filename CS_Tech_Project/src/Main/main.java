package Main;

import java.io.IOException;

//Bu class ana class. Baslatma noktasi burasi. 

import Tahta.*;

import java.util.*; 
public class main {

	public static void main(String[] args) {
		
		//Tahtanın kendisi
		tahta satrancTahtasi;
		
		
		try {
			
			//Tum tahtayi almak icin ozel scanner classini kullandim.
			theScannerClass scan = new theScannerClass();
			
			String watned = scan.getTheTotalString();
			
			satrancTahtasi = new tahta(watned);
			
			//Siyah ve beyazın puanları hesaplanıyor.
			double degerB = satrancTahtasi.getPuanB();
			double degerS = satrancTahtasi.getPuanS();
			
			//Puanları yazdırıyorum. 
			System.out.println("Beyaz: "+degerB);
			System.out.println("Siyah: "+degerS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
