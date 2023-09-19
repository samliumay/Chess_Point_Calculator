package Taslar;

import Tahta.yer;

//Fil class'i. tas class'ının subclass'i tum taslar tas class'inin kendisi haric bu sekilde.

public class Fil extends Tas{

	//Deger haric onceden tanimli bir constructor var. 
	public Fil(boolean renk) {
		super(renk);
		this.deger = 3;
		// TODO Auto-generated constructor stub
	}

	//Bu metod spesifik yere tasin gidip gidemeyecegine bakiyor. Eger gidebiliyorsa true gidemiyorsa false donuyor.
	//Fil capraz gidebilir. Bu durumda 4 farklı durumu kontrol etmem gerekti (sol çaprazlar ve sağ çaprazlar. Bundan dolayi uzun bir method.
	public boolean nereyiTehditEder(yer[][] satrancTahtasi, yer start, yer end) {
		if(end.getTas() == null) {
			return false;
		}else if(end.getTas().getRenk()==start.getTas().getRenk()) {
			return false;
		}
		
		//Caprazda oldugunun saglamasi
		int x = Math.abs(start.getX() - end.getX());
		int y = Math.abs(start.getY() - end.getY());
		
		
		//Tek tek tum caprazlarda onunda tas var mi kontrol.
		if(x==y) {
			if((start.getX() > end.getX()) && (start.getY() > end.getY()) ) {
				for(int a = start.getX()-1 , b= start.getY()-1;  end.getX()<a && end.getY()<b ;a--,b--) {
					if(satrancTahtasi[b][a].getTas() != null) {
				
						return false;
					}
				}
				if((start.getX() != end.getX()) || (start.getY() != end.getY())) {
					
					return true;
				}
			}else if((start.getX() < end.getX()) && (start.getY() > end.getY())) {
				for(int a = start.getX()+1 , b= start.getY()-1;  end.getX()>a && end.getY()<b ;a++,b--) {
					if(satrancTahtasi[b][a].getTas() != null) {
						return false;
					}	
				}
				if((start.getX() != end.getX()) || (start.getY() != end.getY())) {
					return true;
				}
			}else if((start.getX() < end.getX()) && (start.getY() < end.getY())) {
				for(int a = start.getX()+1 , b= start.getY()+1;  end.getX()>a && end.getY()>b ;a++,b++) {
					if(satrancTahtasi[b][a].getTas() != null) {
						return false;
					}
				}
				if((start.getX() != end.getX()) || (start.getY() != end.getY())) {
					return true;
				}
				
			}else if ((start.getX() > end.getX()) && (start.getY() < end.getY())) {
				for(int a = start.getX()-1 , b= start.getY()+1;  end.getX()<a && end.getY()>b ;a--,b++) {
					if(satrancTahtasi[b][a].getTas() != null) {
						return false;
					}
				}
				if((start.getX() != end.getX()) || (start.getY() != end.getY())) {
					return true;
				}
			}
		}
		
		
		return false;
	}

	//Burada spesifik tasin gidebilecegi her yeri kontrol ediyoruz. Tum tahta oluyor bu durumda. 
	public void nereyiTehditEder(yer[][] satrancTahtasi, yer olanYer) {
		for(int y = 0; satrancTahtasi.length>y;y++) {
			for(int x = 0; satrancTahtasi[y].length>x;x++) {
				if(satrancTahtasi[y][x].getTas() !=null) {
					if(nereyiTehditEder(satrancTahtasi,olanYer,satrancTahtasi[y][x])) {
						satrancTahtasi[y][x].getTas().setTehditAltinda(true);
					}
				}
			}
		}
	}





}
