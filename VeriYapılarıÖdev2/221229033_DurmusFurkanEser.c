#include <stdio.h>
#include <stdlib.h>

struct Dugum {
    int deger;
    struct Dugum* sonraki;
};

int donguVarMi(struct Dugum* baslangic, int tabloBoyutu) {
    struct Dugum* hashTablosu[tabloBoyutu];  
    struct Dugum* suanki = baslangic;
    while (suanki != NULL) {

        int hashIndex = (int)suanki % tabloBoyutu;

        if (hashTablosu[hashIndex] == suanki) {
            return 1; 
        }

        
        hashTablosu[hashIndex] = suanki;

   
        suanki = suanki->sonraki;
    }

    return 0;  
}


void listeyiYazdir(struct Dugum* baslangic, int max) {
    struct Dugum* suanki = baslangic;
    int Sayac = 0;

    printf("Bagli liste elemanlari: \n");
    while (suanki != NULL && Sayac < max) {
        printf("%d ", suanki->deger);
        suanki = suanki->sonraki;
        Sayac++;
    }

  
}


void Dongusuz() {
    struct Dugum dugum1 = {1, NULL};
    struct Dugum dugum2 = {2, NULL};
    struct Dugum dugum3 = {3, NULL};
    struct Dugum dugum4 = {4, NULL};


    
    dugum1.sonraki = &dugum2;
    dugum2.sonraki = &dugum3;
    dugum3.sonraki = &dugum4;


    listeyiYazdir(&dugum1, 10);

    int tabloBoyutu;
    printf("Hash tablosunun boyutunu girin: ");
    scanf("%d", &tabloBoyutu);

    if (donguVarMi(&dugum1, tabloBoyutu)) {
        printf("Dongu var.\n");
    } else {
        printf("Dongu yok.\n");
    }
}


void Dongulu() {
    struct Dugum dugum1 = {1, NULL};
    struct Dugum dugum2 = {2, NULL};
    struct Dugum dugum3 = {3, NULL};
    struct Dugum dugum4 = {4, NULL};


    dugum1.sonraki = &dugum2;
    dugum2.sonraki = &dugum3;
    dugum3.sonraki = &dugum4;


    dugum4.sonraki = &dugum2;

    
    listeyiYazdir(&dugum1, 10);

    int tabloBoyutu;
    printf("Hash tablosunun boyutunu girin: ");
    scanf("%d", &tabloBoyutu);

    if (donguVarMi(&dugum1, tabloBoyutu)) {
        printf("Dongu var.\n");
    } else {
        printf("Dongu yok.\n");
    }
}

int main(int argc, char *argv[]) {
    int secim;

    printf("Hangisini denemek istersiniz?\n");
    printf("1. Dongu icermeyen liste \n");
    printf("2. Dongu iceren liste \n");
    printf("Seciminizi yapin (1 veya 2): ");
    scanf("%d", &secim);

    switch (secim) {
        case 1:
            Dongusuz();
            break;
        case 2:
            Dongulu();
            break;
        default:
            printf("Geçersiz");
    }

    return 0;
}

