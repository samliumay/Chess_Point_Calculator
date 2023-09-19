package Tahta;

import Taslar.*;

//Bu class Tum tahtayı sımule ettiğim bir class. her bir yeri simile ediyorum. Aynı zamanda tahtanın tamamını string olarak alıp doldurduğum bir yer.

public class tahta {

	//8x8 satranc tahtasi
	public yer tumTahta [][] = new yer[8][8];
	private double puanB= 0;
	private double puanS = 0;
	
	//ilk olarak tum tahtayi isliyorum. Sonra kimin kimi tehdit ettiğini hesapladiktan sonra puanlari hesapliyorum.
	public tahta (String tumTahtaKayit) {
		tahtaIslemesi(tumTahtaKayit);
		tahtaKontrolu();
		puanHesaplamasi();
	}
	
	//Burada girilen String'i alip tahtada yerine koyuyorum.
	public void tahtaIslemesi(String tumTahtaKayit) {
		String tumSatirlar[] = tumTahtaKayit.split("\n");
		for(int y = 0; tumSatirlar.length> y;y++) {
			String satirdakiYerler[] = tumSatirlar[y].split(" ");
			for(int x = 0; satirdakiYerler.length > x; x++) {
				
				tumTahta[y][x] = new yer(x,y,null);
				if(satirdakiYerler[x].equals("--")){
					tumTahta[y][x] = new yer(x,y,null);
				}else if(satirdakiYerler[x].equals("ps")) {
					tumTahta[y][x] = new yer(x,y,new Piyon(false));
				}else if(satirdakiYerler[x].equals("pb")) {
					tumTahta[y][x] = new yer(x,y,new Piyon(true));
				}else if(satirdakiYerler[x].equals("ks")) {
					tumTahta[y][x] = new yer(x,y,new Kale(false));
				}else if(satirdakiYerler[x].equals("kb")) {
					tumTahta[y][x] = new yer(x,y,new Kale(true));
				}else if(satirdakiYerler[x].equals("fs")) {
					tumTahta[y][x] = new yer(x,y,new Fil(false));
				}else if(satirdakiYerler[x].equals("fb")) {
					tumTahta[y][x] = new yer(x,y,new Fil(true));
				}else if(satirdakiYerler[x].equals("as")) {
					tumTahta[y][x] = new yer(x,y,new At(false));
				}else if(satirdakiYerler[x].equals("ab")) {
					tumTahta[y][x] = new yer(x,y,new At(true));
				}else if(satirdakiYerler[x].equals("vs")) {
					tumTahta[y][x] = new yer(x,y,new Vezir(false));
				}else if(satirdakiYerler[x].equals("vb")) {
					tumTahta[y][x] = new yer(x,y,new Vezir(true));
				}else if(satirdakiYerler[x].equals("ss")) {
					tumTahta[y][x] = new yer(x,y,new Sah(false));
				}else if(satirdakiYerler[x].equals("sb")) {
					tumTahta[y][x] = new yer(x,y,new Sah(true));
				}
			}
			
		}
	}
	
	//Tum tahtadaki taslari kontrol ediyorum kim nereyi tehdit ediyor diye. her bir tas icin bu kontrolu yapiyorum.
	public void tahtaKontrolu() {
		for(int y = 0; tumTahta.length>y;y++) {
			for(int x = 0; tumTahta[y].length>x;x++) {
				if(tumTahta[y][x].getTas() !=null) {
					tumTahta[y][x].getTas().nereyiTehditEder(tumTahta, tumTahta[y][x]);
				}
				
			}
		}
	}	
	
	//Tahtadaki puanlari hesapliyorum.
	public void puanHesaplamasi() {
		for(int y = 0; tumTahta.length>y;y++) {
			for(int x = 0; tumTahta[y].length>x;x++) {
				if(tumTahta[y][x].getTas() !=null) {
					tumTahta[y][x].getTas().degerHesaplama();
					if(tumTahta[y][x].getTas().getRenk() == true) {
						puanB = puanB + tumTahta[y][x].getTas().getDeger();
					}
					else {
						puanS = puanS + tumTahta[y][x].getTas().getDeger();
					}
					
				}
			}
		}
	}
	
	//Puanlari almak icin getterlar.
	public double getPuanB() {
		return puanB;
	}
	public double getPuanS() {
		return puanS;
	}
}
