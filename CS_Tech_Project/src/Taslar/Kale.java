package Taslar;


import Tahta.yer;

//Kale class'i. tas class'ının subclass'i tum taslar tas class'inin kendisi haric bu sekilde.

public class Kale extends Tas{
	
	//Deger haric onceden tanimli bir constructor var. 
	public Kale(boolean renk) {
		super(renk);
		this.deger = 5;
		// TODO Auto-generated constructor stub
	}

	//Bu metod spesifik yere tasin gidip gidemeyecegine bakiyor. Eger gidebiliyorsa true gidemiyorsa false donuyor.
	//Kale one, arkaya, saga ve sola gidebilir. Tum tahtaya da hakimdir. 4 koridoru'da kontrol etmek icin ayri metodar var. Bu yüzden fonskyonumuz biraz uzun.
	public boolean nereyiTehditEder(yer[][] satrancTahtasi, yer start, yer end) {
		if(end.getTas() == null) {
			return false;
		}else if(end.getTas().getRenk()==start.getTas().getRenk()) {
			return false;
		}
		
		//Burada on arka sag ve sol icin ayri kisimlar yazdim. Yol ustunde tas olup olmadigini kontrol ediyor. 
		else if((start.getX() == end.getX()) || (start.getY() == end.getY())) {
			if(start.getX() == end.getX()) {
				
				if(start.getY()> end.getY()) {
					for(int y = start.getY() -1 ;y>end.getY() ;y--) {
						
						if((y>0 && y<8) &&satrancTahtasi[y][start.getX()].getTas()!=null) {
							
							return false;
						}
					}
					if((start.getX() != end.getX()) || (start.getY() != end.getY())) {
						return true;
					}
				}
				else if(start.getY() < end.getY()){
					for(int y = start.getY()+1 ;y<end.getY()   ;y++) {
						if((y>0 && y<8) && satrancTahtasi[y][start.getX()].getTas()!=null) {
							return false;
						}
					}
					if((start.getX() != end.getX()) || (start.getY() != end.getY())) {
						return true;
					}
				}
				
				
			}else if(start.getY() == end.getY()){
				
				if(start.getX()> end.getX()) {
					for(int x = start.getX()-1;x>end.getX();x--) {
						if((x>0 && x<8) &&satrancTahtasi[start.getY()][x].getTas()!=null) {
							return false;
						}
					}
					if((start.getX() != end.getX()) || (start.getY() != end.getY())) {
						return true;
					}
				}
				else if(start.getX() < end.getX()){
					for(int x = start.getX()+1 ;x<end.getX();x++) {
						if((x>0 && x<8) &&satrancTahtasi[start.getY()][x].getTas()!=null) {
							return false;
						}
					}
					if((start.getX() != end.getX()) || (start.getY() != end.getY())) {
						return true;
					}
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
