package lambdapractice;

import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {

        birden30aSayiYazdirma(30);
        System.out.println();
        otuzDahilYazdir(30);
        System.out.println();
        ikiDegerArasindakiSayilar(7, 15);
        System.out.println();
        otuz40ArasiOrtalama(30, 40);
        System.out.println();
        System.out.println(sekizIleBolunenler(325, 468));
        System.out.println();
        sekizIleBolunenSayilar(325, 468);
        System.out.println();
        System.out.println(sekizeBolunenToplam(364, 468));
        System.out.println();
        System.out.println(tekSayilarinCarpimi(7, 15));
        System.out.println();
        pozitifTekIlk10(20);
        System.out.println();
        yedininKatlari(21);
        System.out.println();
        yedininKatlariToplam(21);
    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)

    public static void birden30aSayiYazdirma(int x) {
        IntStream.
                range(1, x).
                forEach(t -> System.out.print(t + " "));
    }

    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)

    public static void otuzDahilYazdir(int x) {

        IntStream.
                rangeClosed(1, x).
                forEach(Methods::yazInteger);
    }

    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim

    public static void ikiDegerArasindakiSayilar(int a, int b) {
        System.out.println(IntStream.
                rangeClosed(a, b).
                sum());
    }

    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim

    public static void otuz40ArasiOrtalama(int a, int b) {
        System.out.println(IntStream.
                rangeClosed(a, b).
                average());
    }
    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?

    public static long sekizIleBolunenler(int x, int b) {
        return IntStream.
                range(x, b).
                filter(t -> t % 8 == 0).count();
    }

    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void sekizIleBolunenSayilar(int x, int b) {

        IntStream.
                range(x, b).
                filter(t -> t % 8 == 0).forEach(Methods::yazInteger);
    }

    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
    public static int sekizeBolunenToplam(int a, int b) {
        return IntStream.range(a, b).
                filter(t -> t % 8 == 0).
                sum();
    }

    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim

    public static int tekSayilarinCarpimi(int a, int b) {
        return IntStream.
                range(7, 15).
                filter(t -> t % 2 != 0).
                reduce(1, Math::multiplyExact);//1 ekleyip optional olmasini engelliyoruz
    }

    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim

    public static void pozitifTekIlk10(int a) {
/*
        IntStream.
                rangeClosed(1, a).
                limit(10).
                filter(t -> t % 2 != 0).
                forEach(Methods::yazInteger);

 */
        IntStream.
                iterate(1,t->t+2).
                limit(10).
                forEach(Methods::yazInteger);

    }

    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim

    public static void yedininKatlari(int a){

        IntStream.
                iterate(21,t->t+7).
                filter(t->t%2!=0).
                limit(10).
                forEach(Methods::yazInteger);
    }

    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim

    public static void yedininKatlariToplam(int a){

        System.out.println(IntStream.
                iterate(21, t -> t + 7).
                filter(t -> t % 2 != 0).
                limit(20).
                sum());
    }

}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz