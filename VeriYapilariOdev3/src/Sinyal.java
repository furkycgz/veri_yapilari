import java.util.Scanner;

public class Sinyal {
	
	
	
    public static int gecikenAğZamani(int[][] zaman, int dugumSayisi, int baslangic) {
        int sonsuz = Integer.MAX_VALUE;
        int[][] graf = new int[dugumSayisi + 1][dugumSayisi + 1];

        for (int i = 1; i <= dugumSayisi; i++) {
            for (int j = 1; j <= dugumSayisi; j++) {
                if (i == j) {
                    graf[i][j] = 0;
                } else {
                    graf[i][j] = sonsuz;
                }
            }
        }

        for (int[] zmn : zaman) {
            graf[zmn[0]][zmn[1]] = zmn[2];
        }

       
        boolean[] ziyaretEdilmişMİ = new boolean[dugumSayisi + 1];
        int[] minMesafe = new int[dugumSayisi + 1];

        for (int i = 1; i <= dugumSayisi; i++) {
            minMesafe[i] = sonsuz;
        }
        minMesafe[baslangic] = 0;

        for (int i = 1; i <= dugumSayisi; i++) {
            int enYakinDugum = -1;
            int enKisaMesafe = sonsuz;

            for (int j = 1; j <= dugumSayisi; j++) {
                if (!ziyaretEdilmişMİ[j] && minMesafe[j] < enKisaMesafe) {
                    enYakinDugum = j;
                    enKisaMesafe = minMesafe[j];
                }
            }

            if (enYakinDugum == -1) {
            	break;
            }

            ziyaretEdilmişMİ[enYakinDugum] = true;

            for (int komsu = 1; komsu <= dugumSayisi; komsu++) {
                if (!ziyaretEdilmişMİ[komsu] && graf[enYakinDugum][komsu] != sonsuz && minMesafe[enYakinDugum] + graf[enYakinDugum][komsu] < minMesafe[komsu]) {
                    minMesafe[komsu] = minMesafe[enYakinDugum] + graf[enYakinDugum][komsu];
                }
            }
        }
        int maxMesafe = 0;
        for (int i = 1; i <= dugumSayisi; i++) {
            if (minMesafe[i] == sonsuz) {
                return -1; 
            }
            if (minMesafe[i] > maxMesafe) { 
                maxMesafe = minMesafe[i]; 
            }
        }
        return maxMesafe; 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Düğüm sayısını giriniz: ");
        int dugumSayisi = scanner.nextInt();
        System.out.print("Kenar sayısını giriniz : ");
        int kenarSayisi = scanner.nextInt();

        int[][] zamanlar = new int[kenarSayisi][3];
        System.out.println("Her kenar için (kaynak, hedef, zaman) değerlerini giriniz:");
        for (int i = 0; i < kenarSayisi; i++) {
            System.out.print((i + 1) + ". Kenar (kaynak hedef zaman): ");
            zamanlar[i][0] = scanner.nextInt();
            zamanlar[i][1] = scanner.nextInt();
            zamanlar[i][2] = scanner.nextInt();
        }
        System.out.print("Başlangıç düğümünü giriniz: ");
        int baslangic = scanner.nextInt();

        
        
        int sonuc = gecikenAğZamani(zamanlar, dugumSayisi, baslangic);
        System.out.println("Sonuç: " + sonuc);

        
    }
}
