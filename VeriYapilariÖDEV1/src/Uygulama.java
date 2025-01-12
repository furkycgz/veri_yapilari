import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uygulama {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	boolean devam = true;
    	   BagliListe ogrenci = new BagliListe();
    	while (devam) {
            
            System.out.println("Lütfen bir seçenek seçiniz:");
            System.out.println("1: Listeye Ekle");
            System.out.println("2: Eleman silme ");
            System.out.println("3: Arama");
            System.out.println("4: Sıralama");
            System.out.println("5: Sınıf Bilgisi");
            System.out.println("6: Grup Bilgisi ");
            System.out.println("7: Çıkış");

            
            int secim = scanner.nextInt();
         
    
        switch (secim) { 
        
        
        case 1:
            
        	   

        
        ogrenci.Ekle(104, "Elif", "Güneş", 2, 3.90);
        ogrenci.Ekle(102, "Ayşe", "Demir", 1, 3.20);
        ogrenci.Ekle(103, "Can", "Kara", 3, 2.80);
        ogrenci.Ekle(106, "Zeynep", "Öztürk", 3, 4.00);
        ogrenci.Ekle(106, "Mehmet", "Aksoy", 2, 2.50);
        ogrenci.Ekle(101, "Ahmet", "Yılmaz", 2, 3.50);
        ogrenci.Ekle(104, "Yavuz", "Güneş", 2, 3.50);

        ogrenci.listeyiYazdir();  

       
        try {
            ogrenci.listeyiDosyayaYaz("KAYIT.txt");
            System.out.println("Veriler dosyaya başarıyla yazıldı.");
        } catch (IOException e) {
          
        }
        break;
        
        case 2 : 
        	
        	System.out.print("Silinecek öğrenci numarasını giriniz: ");
            int ogrencino = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Silinecek öğrenci adını giriniz: ");
            String ad = scanner.nextLine();

            System.out.print("Silinecek öğrenci soyadını giriniz: ");
            String soyad = scanner.nextLine();

            
            ogrenci.sil(ogrencino, ad, soyad);

            
            System.out.println(" Güncellenmiş Öğrenci Listesi:");
            ogrenci.listeyiYazdir();
        
        	break;
        case 3 : 
        	System.out.println("Öğrenci numarası giriniz :");
        	 int ogrencino1 = scanner.nextInt();
             scanner.nextLine(); 
             ogrencino=ogrencino1;
         	 ogrenci.arama(ogrencino);
        	 
       
        	break;
        case 4 : 
        	ogrenci.sıralama();
       
        	break;
        case 5 : 
        	ogrenci.sinifBilgisi();
        	
       
        	break;
        case 6 :  	
        	ogrenci.grupBilgisi();
        	
       
        break;
        case 7 : 
        	 System.out.println("Uygulamadan çıkıldı");
             devam = false; 
             break;	
    }
   }
 }
}
