package Tahta;

import Taslar.*;

//Burada yer class'i var. oldugu nokta ve eger varsa o karedeki tasi tutuyorum. 

public class yer {
	Tas tas = null;
	private int x = -1;
	private int y = -1;
	
	//Constructor'da gerekli tum bilgileri aliyorum.
	public yer(int x,int y,Tas tas) {
		this.x = x;
		this.y = y;
		this.tas = tas;
	}
	
	//Olasi gerekliliklere karsi getter ve setterlar. 
	public Tas getTas() {
		return tas;
	}
	public void setTas(Tas tas) {
		this.tas = tas;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
