package Taslar;


import Tahta.yer;

public abstract class Tas {

	protected boolean beyaz;
	protected boolean tehditAltinda = false;
	protected double deger;
	
	public Tas(boolean renk) {
		this.beyaz = renk;
	}
	
	public boolean getRenk() {
		return beyaz;
	}
	
	public boolean getTehditAltinda() {
		return tehditAltinda;
	}
	
	public void setTehditAltinda(boolean tehditAltinda) {
		this.tehditAltinda = tehditAltinda;
	}
	
	public void degerHesaplama() {
		if(tehditAltinda) {
			deger = deger/2;
		}
	}
	
	public double getDeger() {
		return deger;
	}
	//Bu metod spesifik yere tasin gidip gidemeyecegine bakiyor. Eger gidebiliyorsa true gidemiyorsa false donuyor tum metodlarda.
    public abstract boolean nereyiTehditEder(yer[][] satrancTahtasi, 
            yer start, yer end);
    
  //Burada spesifik tasin gidebilecegi her yeri kontrol ediyoruz. Ozellesme ihtimaline karsi abstract bir metod olarak yazmistim.
    public abstract void nereyiTehditEder(yer[][] satrancTahtasi, 
            yer olanYer);
	
}
