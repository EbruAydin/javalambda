package lambdapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));

        System.out.println("Boslula yazdirma :");
        boslukluYazdirma(list);
        System.out.println("\npozitif sayilari sirala : ");
        pozitifSirali(list);
        System.out.println("\nsayilarin karesini sirala :");
        kareleriSirali(list);
        System.out.println("\nsayilarin karesini tekrarsiz sirala : ");
        kareleriTekrasizList(list);
        System.out.println("\nsayilari kucukten buyuge gore sirala : ");
        kucukBuyukSirali(list);
        System.out.println("\nsayilari buyukten kucuge sirala : ");
        buyukKucukSirali(list);
        System.out.println("\npozitif sayilardan kuplerinin birler basamagi 5 olanlar :");
        kupBirlerBas5(list);
        System.out.println("\npozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlari :");
        kareBirlerBas5Olmayan(list);
        System.out.println("\nlist elemanlarinin toplami : ");
        listElemaniToplami(list);
        System.out.println("\npeek ile negatif sayilarin karelerini bulma :");
        System.out.println(negatiflerinKareleri(list));
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
    }
    public static void yazInteger(int n){
        System.out.print(n+" ");
    }
    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void boslukluYazdirma(List<Integer> list){
        list.
                stream().forEach(C1_IntList_StreamOrnekleri::yazInteger);

    }


    //S2: sadece negatif olanlari yazdir

    public static void negtifOlanSayilar(List<Integer> list){
        list.stream().
                filter(t->t<0).
                forEach(C1_IntList_StreamOrnekleri::yazInteger);
    }

    //S3: pozitif olanlardan yeni bir liste olustur

    public static void pozitifSirali(List<Integer> list){
        list.stream().
                filter(t->t>0).forEach(C1_IntList_StreamOrnekleri::yazInteger);

    }

    // S4: list in elemanlarin karelerinden yeni bir list olusturalim


    public static void kareleriSirali(List<Integer> list){

        list.stream().
                map(t->t*t).collect(Collectors.toList()).forEach(C1_IntList_StreamOrnekleri::yazInteger);
    }

    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim

    public static void kareleriTekrasizList(List<Integer> list){

        list.stream().
                map(t->t*t).
                distinct().
                collect(Collectors.toList()).
                forEach(C1_IntList_StreamOrnekleri::yazInteger);

    }

    //S6: listin elemanlarini kucukten buyuge siralayalim

    public static void kucukBuyukSirali(List<Integer> list){

        list.stream().
                sorted().forEach(C1_IntList_StreamOrnekleri::yazInteger);
    }

    //S7: listin elemanlarini buyukten kucuge siralayalim

    public static void buyukKucukSirali(List<Integer> list){

        list.stream().
                sorted(Comparator.reverseOrder()).
                forEach(C1_IntList_StreamOrnekleri::yazInteger);

    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim

    public static void kupBirlerBas5(List<Integer> list){

        list.stream().
                filter(t->t>0).
                map(t->t*t*t).
                filter(t->t%5==0).
                collect(Collectors.toList()).
                forEach(C1_IntList_StreamOrnekleri::yazInteger);

    }

    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static void kareBirlerBas5Olmayan(List<Integer> list){

        list.stream().
                filter(t->t>0).
                map(t->t*t).
                filter(t->t%5!=0).
                collect(Collectors.toList()).
                forEach(C1_IntList_StreamOrnekleri::yazInteger);

    }

    // S10 :list elemanlarini toplamini bulalim
    public static void listElemaniToplami(List<Integer> list){
        System.out.println(list.stream().
                reduce(Integer::sum));


    }


    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> negatiflerinKareleri(List<Integer> l) {
        System.out.println();
        return l.stream().filter(t->t<0).
                peek(t-> System.out.println("negatifler :" +t)).
                map(t->t*t).
                peek(t-> System.out.println("kareleri :" + t)).
                collect(Collectors.toList());
        //denetlemek istedigimizin sonrasına ekliyoruz
    }


    // S12 : listeden 5 den buyuk  sayi var mi?

    public static void bestenBuyukSayiVarMi(List<Integer> list){

    }

    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static void listeninElemani0danKucukMu(List<Integer> list){

    }


    // S14: listenin 100 e esit elemani yok mu ?

    public static void yuzeEsitElemanYokMu(List<Integer> list){

    }

    // S15: listenin sifira esit elemani yok mu?

    public static void sifiraEsitElamaniYokmMu(List<Integer> list){

    }

    // S16:  listenin ilk 5 elemanini topla?

    public static void listeninIlk5ElemaniniTopla(List<Integer> list){

    }

    //S17: listenin son bes elemaninin  listele
    public static void listeninSonBesElemanininiListele(List<Integer> list){

    }

}