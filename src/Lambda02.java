import java.util.*;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);
        System.out.println("\n *****  ");
        tekKupBirFazla(sayi);
        System.out.println("\n *****  ");
        ciftKarekokPrint(sayi);
        System.out.println("\n *****  ");
        maxElBul(sayi);
        System.out.println("\n *****  ");
        ciftKareMax(sayi);
        System.out.println("\n *****  ");
        toplam(sayi);
        System.out.println("\n *****  ");
        ciftCarp(sayi);
        System.out.println("\n *****  ");
        minBul(sayi);
        System.out.println("\n *****  ");
        bestenBykEnKck(sayi);
        System.out.println("\n *****  ");
        tekKareBkPrint(sayi);
        System.out.println("\n *****  ");
        ciftKareKbPrint(sayi);
    }

    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                forEach(Lambda01::yazdir);
        //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.

    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi

    public static void tekKupBirFazla(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 != 1).//tek elemanlar filtrelendi
                map(t -> (t * t * t) + 1).//tek elemanlarin kuplerinin bir fazlasi
                forEach(Lambda01::yazdir);
    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekokPrint(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).//:: bununla method call yapiyoruz. Math()daki kodlari cagirmis olduk
                forEach(t -> System.out.print(t + " "));
        // forEach(Lambda01::yazdir); bu method int getirdigi icin olmadi, cunku bizim islem double sonuc uretiyor

    }

    // Task : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi) {
        //akisa sundugumuz sayilar uzerinde yaptiginiz aksiyondan eger sonucta tek bir eleman elde ediyorsak reduce() kullaniriz.
        //ortalama,toplama,cikarma da ornekler arasindadir

        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);//ama burada atama yapmis oluruz
        System.out.println(maxSayi);
        System.out.println("Halukca print " + sayi.stream().reduce(Math::max));//burada sadece cikti alinmis olur

        //int maxSayi olusturduk ve ona atama yapmaya calistik
        //ama hata verdi, uzerine gelip Optional bla bla atamasi yapman lazim dedi
        //secince boyle oldu, bu bir type'tir.
        //mesela sag/value uzerinden konusalim. bize deniyor ki 80den fazla not alan ogrenci
        // olunca yazdir dese ve 80 uzeri yoksa null olur ama int null olamaz ama Optional class null deger barindiriyor
        //bu durumda. Optional secenegi java kendi algoritmasina gore yapiyor, biz karar vermiyoruz ona

        /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftKareMax(List<Integer> sayi) {

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Math::max));//double vs oldugu icin daha genis

        System.out.println("daha hizli, specific integer class : " + sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//Integer classin kodlari call ediliyor ama Max daha parent, genis Integer'a gore.Integer daha specific
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...

    public static void toplam(List<Integer> sayi) {

        // System.out.println(sayi.stream().reduce(Integer::sum)); ama method reference bu

        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);//Lambda Expression

        /*
        a ilk degerini her zaman atanan degerden alir, identity bunu ifade ediyor
        b degerini her zaman akistan/stream'den alir
        a ilk degerinden sonraki her degeri aksiyondan alir yani islemden alir.
         */
        System.out.println(toplam);//43

        //method ref

        Optional<Integer> topla = sayi.stream().reduce(Integer::sum);//burasi istedi Optional
        //burada bir baslangic degeri yok, ve list bos olsaydi null degeri verirdi. bu nedenle optional veriyor
        //yukarida deger atamalari yaptik. 0+0 bile 0dir yukarida. Sonucta null uretecek bir olasilik varsa java bunu
        //hesapliyor ve ona gore Optional veriyor ya da vermiyor.
        System.out.println(sayi.stream().reduce(Integer::sum));//Optional[43]
    }

    //Task:Listeki cift sayilairn carpimi

    public static void ciftCarp(List<Integer> sayi) {

        //Method ref
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));

        //lamda expression
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> (a * b)));//1 etkisiz eleman carpmada

    }


    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void minBul(List<Integer> sayi) {
//1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println(minSayiInteger);
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath);
        //3. yontem Lambda Expression
        int minSayiJambda = sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        System.out.println(minSayiJambda);
        //burada MAX bir etkiye sahip degil, min bulmaya calistigimiz icin baslangiz noktasi olarak MAX koyariz
        //x burada ilk once max alacak ama sonrasinda islemden gelecek degerler
        //y ise akistan alacak, boylece akis bitince x sonucu getirecek.
        //x'in max olmasi sonrasi icin bir sey ifade etmez, cunku x daha sonra islemden deger alir yani min deger hangisi ise
        //x islemden min degerleri alir.
        //baslangic degeri oldugu icin de int olur, diger turlu Optional devreye giriyo

        //4. yontem Method Reference --> Haluk class

         Optional<Integer> minSayiHaluk=sayi.stream().reduce(Lambda02::byHalukMin);
        System.out.println(minSayiHaluk);

    }
    public static int byHalukMin(int a, int b){//bu method kendisine iki int degerinden en kucugunu return eder

        return a<b?a:b;

    }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBykEnKck(List<Integer> sayi){

        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Integer::min));


    }

// Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.


    public static void ciftKareKbPrint(List<Integer> sayi){//dogal sira oldugu icin sort.

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().
                forEach(Lambda01::yazdir);


    }
// Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
public static void tekKareBkPrint(List<Integer> sayi){

    sayi.//akis kaynagi
            stream().
            filter(t->t%2!=0).//tek elemanlari filtreledi
            map(t->t*t).//kare alindi
            sorted(Comparator.reverseOrder()).//buyukten kucuge siralama bu sekilde call edilir
            forEach(Lambda01::yazdir);


}
}
