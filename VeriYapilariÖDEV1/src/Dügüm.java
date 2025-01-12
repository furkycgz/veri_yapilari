
public class Dügüm {
     int ögrencino ;
     String ad ; 
     String soyad ; 
     int sinif ;
     double ortalama ; 
     Dügüm next ; 
     Dügüm prew ;
	public Dügüm(int ögrencino, String ad, String soyad, int sinif, double ortalama) {
		super();
		this.ögrencino = ögrencino;
		this.ad = ad;
		this.soyad = soyad;
		this.sinif = sinif;
		this.ortalama = ortalama;
		next = null;
		prew = null;
	} 
     
     
     
     
     
}
