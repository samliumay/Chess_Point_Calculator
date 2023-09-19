package Taslar;

import Tahta.yer;

//At class'i. tas class'ının subclass'i tum taslar tas class'inin kendisi haric bu sekilde.

public class At extends Tas{
	
	//Deger haric onceden tanimli bir constructor var. 
	public At(boolean renk) {
		super(renk);
		this.deger = 3;
	}

	//Bu metod spesifik yere tasin gidip gidemeyecegine bakiyor. Eger gidebiliyorsa true gidemiyorsa false donuyor.
	//Atin gidebilecegi yerlerin carpimi 2. Bundan dolayi basit bir fonksyonu var.
	public boolean nereyiTehditEder(yer[][] satrancTahtasi, yer start, yer end) {
		
		if(end.getTas() == null) {
			return false;
		}else if(end.getTas().getRenk()==start.getTas().getRenk()) {
			return false;
		}
		else if((Math.abs(start.getX() - end.getX()) *(Math.abs(start.getY() - end.getY())))==2) {
			if((start.getX() != end.getX()) && (start.getY() != end.getY())) {
				return true;
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
