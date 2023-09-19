package Taslar;


import Tahta.yer;

//Piyon class'i. tas class'ının subclass'i tum taslar tas class'inin kendisi haric bu sekilde.

public class Piyon extends Tas{

	//Deger haric onceden tanimli bir constructor var. 
	public Piyon(boolean renk) {
		super(renk);
		this.deger = 1;
		// TODO Auto-generated constructor stub
	}

	//Bu metod spesifik yere tasin gidip gidemeyecegine bakiyor. Eger gidebiliyorsa true gidemiyorsa false donuyor.
	//Piyon temelde capraza dogru tehdit eder ve yer. Ben de bu kontrolu yaptim. Fakat siyah ve beyaz taraf icin ayri metodlar gerekti cunku piyonların gidis yonu farkli
	public boolean nereyiTehditEder(yer[][] satrancTahtasi, yer start, yer end) {
		if(end.getTas() == null) {
			return false;
		}else if(end.getTas().getRenk()==start.getTas().getRenk()) {
			return false;
		}
		
		//Eger beyaz ise nasil hareket edecegi
		if(start.getTas().beyaz == true && end.getTas() !=null) {
			if((Math.abs(start.getX() - end.getX()) ==1) && (start.getY() - end.getY() == 1)) {
				if((start.getX() != end.getX()) && (start.getY() != end.getY())) {
					return true;
				}
			}
			
		}
		else if(start.getTas().beyaz == false && end.getTas() !=null)//Eger siyah ise nasil hareket edecegi
		{
			if((Math.abs(start.getX() - end.getX()) ==1) && (start.getY() - end.getY() == -1)) {
				if((start.getX() != end.getX()) && (start.getY() != end.getY())) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
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
