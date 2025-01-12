import java.io.FileWriter;
import java.io.IOException;

public class BagliListe {
    Dügüm head = null;
    Dügüm tail = null;
    


    public void Ekle(int numara, String ad, String soyad, int sinif, double ortalama) {
        Dügüm yeniDügüm = new Dügüm(numara, ad, soyad, sinif, ortalama);
        if (head == null) {
            // Liste boşsa
            head = yeniDügüm;
            tail = yeniDügüm;
            head.next = head;
            head.prew = head;
        }
        else {
            Dügüm öge = head;
            boolean eklenipEklenmedi = false;
        
            do {
                // Sıralama
                if ((yeniDügüm.ögrencino < öge.ögrencino) ||
                    (yeniDügüm.ögrencino == öge.ögrencino && yeniDügüm.soyad.compareTo(öge.soyad) < 0) || //Eğer yeniDügüm.soyad alfabetik olarak mevcut.soyad'dan önce geliyorsa, compareTo negatif bir değer döner.
                    (yeniDügüm.ögrencino == öge.ögrencino && yeniDügüm.soyad.equals(öge.soyad) && yeniDügüm.ad.compareTo(öge.ad) < 0)) {
                    // Yeni düğüm mevcut düğümün önüne ekledik
                    yeniDügüm.next = öge;
                    yeniDügüm.prew = öge.prew;
                    öge.prew.next = yeniDügüm;
                    öge.prew = yeniDügüm;
                    
                 // yeni head gelirse
                    if (öge == head && 
                        ((yeniDügüm.ögrencino < head.ögrencino) || 
                         (yeniDügüm.ögrencino == head.ögrencino && yeniDügüm.soyad.compareTo(head.soyad) < 0) || 
                         (yeniDügüm.ögrencino == head.ögrencino && yeniDügüm.soyad.equals(head.soyad) && yeniDügüm.ad.compareTo(head.ad) < 0))) {
                        head = yeniDügüm;
                    }
                    eklenipEklenmedi = true;
                    break;
                }
                öge = öge.next;
            } while (öge != head);

            if (!eklenipEklenmedi) {
                // Yeni düğüm sona 
                yeniDügüm.next = head;
                yeniDügüm.prew = head.prew;
                head.prew.next = yeniDügüm;
                head.prew = yeniDügüm;
            }
        }
    }
    public void listeyiYazdir() {
        if (head == null) {
            System.out.println("Liste boş");
            return;
        }

        Dügüm öge = head;
        do {
            System.out.println(öge.ögrencino + " " + öge.ad + " " + öge.soyad + " " + öge.sinif + " " + öge.ortalama);
            öge = öge.next;
        } while (öge != head);
    }
   
    public void listeyiDosyayaYaz(String dosyaAdi) throws IOException {
        FileWriter writer = new FileWriter(dosyaAdi);
        Dügüm öge = head;
        do {
            writer.write("=====================\n");
            writer.write("Öğrenci no  : "+ öge.ögrencino + "\n");
            writer.write("Ad          : "+ öge.ad + "\n");
            writer.write("Soyad       : " + öge.soyad + "\n");
            writer.write("Sınıf       :"+ öge.sinif + "\n");
            writer.write("Ortalama    : "+ öge.ortalama + "\n");
            öge = öge.next;
        } while (öge != head);
        writer.close();
    }
    

    public void sil(int ogrencino, String ad, String soyad) {
        if (head == null) {
            System.out.println("Liste boş");
            return;
        }

        Dügüm öge = head;
         

        do {
            if (öge.ögrencino == ogrencino && öge.ad.equals(ad) && öge.soyad.equals(soyad)) {
                

                // Öğrenci tek  düğümse
                if (öge == head && öge.next == head) {
                    head = null;
                    tail = null;
                    
                } 
                // Baş düğümse
                else if (öge == head) {
                    head = head.next;
                    head.prew = tail;
                    tail.next = head;
                    
                } 
                // Son düğümse
                else if (öge == tail) {
                    tail = tail.prew;
                    tail.next = head;
                    head.prew = tail;
                    
                } 
                // Aradaki herhangi  düğümse
                else {
                    öge.prew.next = öge.next;
                    öge.next.prew = öge.prew;
                }

                System.out.println(ogrencino + "numaralı " + ad + " " + soyad + " listeden silinmiştir.");
                return;
               
            }
            öge = öge.next;
        } while (öge != head);

        if (true) {
            System.out.println("Öğrenci mevcut değil");
        }
    }
    
    public void arama(int ogrencino) {
        if (head == null) {
            System.out.println("Liste boş");
            return;
        }

        Dügüm öge = head;
        boolean bulunma = false;
        do {
            if (öge.ögrencino == ogrencino) {
                bulunma = true;
                
                
                System.out.print(öge.ad + " " + öge.soyad + "listede mevcuttur.");
                System.out.print("Not Ortalaması:" + öge.ortalama + ",Durum:");
                
          
                if (öge.ortalama >= 3.00) {
                    System.out.println("Başarılı ");
                } else {
                    System.out.println("Başarısız");
                }
            }
            öge = öge.next;
        } while (öge != head);

        if (!bulunma) {
            System.out.println("Öğrenci mevcut değil");
        }
    }
       
    public void sinifBilgisi() {
    	
        int OgrenciSayisi = 0;
        double topOrtalama = 0;

        Dügüm öge = head;
        do {
            OgrenciSayisi =  OgrenciSayisi +1 ;
            topOrtalama =  topOrtalama + öge.ortalama;
            öge = öge.next;
        } while (öge != head);

        double ortalamaninort = topOrtalama / OgrenciSayisi;

        System.out.println("1.Toplam öğrenci sayısı:" + OgrenciSayisi);
        System.out.println("2. Toplam Ortalama: " + topOrtalama);
        System.out.println("3. Ortalamaların Ortalaması:" + ortalamaninort);
    	
    	
    	
    }
    public void grupBilgisi() {
    

      
        int[] ogrenciSayisi = new int[7]; 
        double[] toplamOrtalama = new double[7];
        double[] maxOrtalama = {0, 0, 0, 0};
        double[] minOrtalama = {4,4,4,4};

        
        Dügüm öge = head;
        do {
            int sinif = öge.sinif;
              
                ogrenciSayisi[sinif] =    ogrenciSayisi[sinif] +1 ;
                toplamOrtalama[sinif] = toplamOrtalama[sinif] + öge.ortalama;
                
                if (öge.ortalama > maxOrtalama[sinif]) {
                    maxOrtalama[sinif] = öge.ortalama;
                }
                if (öge.ortalama < minOrtalama[sinif]) {
                    minOrtalama[sinif] = öge.ortalama;
                }
            
            öge = öge.next;
        } while (öge != head);

       
          System.out.println("1. Her sınıfta yer alan toplam öğrenci sayısı: ");
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + ". Sınıf:" + ogrenciSayisi[i]);
        }

        System.out.println("2.Her sınıfta yer alan öğrencilerin toplam ortalaması:");
        for (int i = 1; i <= 3; i++) {
            double ortalama =  (toplamOrtalama[i] / ogrenciSayisi[i]) ;
            System.out.printf("%d. Sınıf: %.2f\n", i,ortalama);
        }

        System.out.println("3. Her sınıfta yer alan öğrencilerin maksimum ve minimum ortalaması:");
        for (int i = 1; i <= 3; i++) {
           
             System.out.printf("%d. Sınıf: mak: %.2f ve min: %.2f\n", i, maxOrtalama[i], minOrtalama[i]);
            
        }
    }
      public void sıralama() {
    	  boolean devam;
    	  do {
    	        devam  = false;
    	        Dügüm öge = head;

    	       
    	        do {
    	            boolean soyadSirala = öge.soyad.compareTo(öge.next.soyad) > 0;
    	            boolean adSirala = öge.soyad.equals(öge.next.soyad) && öge.ad.compareTo(öge.next.ad) > 0;

    	            if (soyadSirala || adSirala) {
    	               
    	                String tempAd = öge.ad;
    	                String tempSoyad = öge.soyad;
    	                int tempOgrenciNo = öge.ögrencino;
    	                int tempSinif = öge.sinif;
    	                double tempOrtalama = öge.ortalama;

    	                öge.ad = öge.next.ad;
    	                öge.soyad = öge.next.soyad;
    	                öge.ögrencino = öge.next.ögrencino;
    	                öge.sinif = öge.next.sinif;
    	                öge.ortalama = öge.next.ortalama;

    	                öge.next.ad = tempAd;
    	                öge.next.soyad = tempSoyad;
    	                öge.next.ögrencino = tempOgrenciNo;
    	                öge.next.sinif = tempSinif;
    	                öge.next.ortalama = tempOrtalama;

    	                devam = true; 
    	            }
    	            öge = öge.next;
    	        } while (öge.next != head); 

    	    } while (devam); 
    	  Dügüm öge = head;
          do {
              System.out.println(öge.ad + " " + öge.soyad + ", Sınıf:" + öge.sinif + ", Ortalama:" + öge.ortalama);
              öge = öge.next;
          } while (öge != head);
    	  
    	  
    	  
    	  
          
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
      }

    
    
    
    
    
    
    
    
    
        
        
        
        
   }
    
    
    
    
    
    
    

