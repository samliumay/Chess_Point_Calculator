package Taslar;


import Tahta.yer;

public class Vezir extends Tas{

	public Vezir(boolean renk) {
		super(renk);
		this.deger=9;
		}

	@Override
	public boolean nereyiTehditEder(yer[][] satrancTahtasi, yer start, yer end) {
		if(end.getTas() == null) {
			return false;
		}else if(end.getTas().getRenk()==start.getTas().getRenk()) {
			return false;
		}		else if((start.getX() == end.getX()) || (start.getY() == end.getY())) {
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
		
		
		int x = Math.abs(start.getX() - end.getX());
		int y = Math.abs(start.getY() - end.getY());
		
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
