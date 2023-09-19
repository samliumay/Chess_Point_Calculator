package Taslar;



import Tahta.yer;

//Sah class'i. tas class'ının subclass'i tum taslar tas class'inin kendisi haric bu sekilde.

public class Sah extends Tas{
	
	//Deger haric onceden tanimli bir constructor var. 
	public Sah(boolean renk) {
		super(renk);
		this.deger = 100;
		// TODO Auto-generated constructor stub
	}

	//Bu metod spesifik yere tasin gidip gidemeyecegine bakiyor. Eger gidebiliyorsa true gidemiyorsa false donuyor.
	//Sah temelde her tarafa 1 gidebilir. Bu durumda gidebilecegi karelerin toplami caprazlar haric 1'dir. Bundan dolayi ona gore bir metod var.
	public boolean nereyiTehditEder(yer[][] satrancTahtasi, yer start, yer end) {
		
		
		if(end.getTas() == null) {
			return false;
		}else if(end.getTas().getRenk()==start.getTas().getRenk()) {
			return false;
		}
		else if((Math.abs(start.getX() - end.getX()) + (Math.abs(start.getY() - end.getY())))==1) {
			return true;
		}
		
		return false;
	}


	//Burada spesifik tasin gidebilecegi her yeri kontrol ediyoruz. Tum tahta kontrol ediliyor bu durumda. 
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
