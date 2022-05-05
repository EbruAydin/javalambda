import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

 /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

    public static void main(String[] args) {
        Universite bogazici = new Universite("bogazici", "matematik", 571, 89);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yildiz teknik", "gemi", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv));// false yazdirir cun
        System.out.println("=============");
        System.out.print(ogrSayiBksirala(unv));
        System.out.println("=============");
        System.out.println(notOrtBkSiraliIlkUc(unv));
        System.out.println("=============");
        System.out.println(enAzOgrcSayisi2Unv(unv));
        System.out.println("=============");
        System.out.println(notOrt63denBykOgrSayiToplami(unv));
        System.out.println("=============");
        System.out.println(ogrcSayisiort333denByk(unv));
        System.out.println("=============");
        System.out.println(mathBolmSayisi(unv));
        System.out.println("=============");
        System.out.println(ogrcSayisiort571denBykNotOrtlamasi(unv));
        System.out.println("=============");
        System.out.println(ogrSayisi1071MinnotOrt(unv));
    }

    //task1 notOrt'larinin 74'ten buyuk oldugunu kontrol eden bi r method create ediniz

    //kontrol ifadesi var mi yok mu demeye denk geliyor, bu nedenle boolean

    public static boolean notOrt74BykUnv(List<Universite> unv) {
        //t'nin hepsi obje yani unv burada get ile onun icerisine girip datalar alinir. burada ortalama istendi o yuzden getNotOrt ve o da uni
        //classindan yani pojodan gelir

        return unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74);//hepsinin 74ten buyuk olmasi lazimdi true vermesi icin. soru 74ten buyuk olup olmadigini kontrol
        //edin diyor soruda bu yuzden allMatch,


        //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    }

    public static boolean ogrcSayisi110AzMi(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getOgrcSayisi() > 110);

    }
    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.


    public static boolean matBolumVarmi(List<Universite> unv) {
        return unv.stream().anyMatch(t -> t.getBolum().contains("mat"));//get sonrasinda toLowerCase yapabiliriz
    }


    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogrSayiBksirala(List<Universite> unv) {//return type List<Universite> cunku sana List donecek

        return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrcSayisi).reversed()).//burada list var, bu nedenle toList kullanacagiz
                        collect(Collectors.toList());//hoca esneklik acisindan toList kullaniyor, yazdirmasi kolay diye
        //collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    /*
    ilk 3 dedigi icin keseriz, limit kullaniriz yani
     */

    public static List<Universite> notOrtBkSiraliIlkUc(List<Universite> unv) {

        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
                limit(3).
                collect(Collectors.toList());
        /*
simdi sadece limit() yapip biraksak bize reference getirir, cunku Limit() stream getiriyor. bunu liste eklememiz gerektigi
icin collect(Collectors.toList()) yapmak gerekir.
         */

    }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.

    public static List<Universite> enAzOgrcSayisi2Unv(List<Universite> unv) {

       return unv.
               stream().
               sorted(Comparator.comparing(Universite::getOgrcSayisi)).
               limit(2).
               skip(1).
               collect(Collectors.toList());
    }


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz.

    public static int notOrt63denBykOgrSayiToplami(List<Universite> unv){

        return unv.
                stream().
                filter(t->t.getNotOrt()>63).
                map(t->t.getOgrcSayisi()).
                //reduce(Integer::sum)
               // reduce(Math::addExact)
                reduce(0,(t,u)->(t+u));

    }

    public static int notOrt63denBykOgrSayiToplamiToInt(List<Universite> unv){

        return unv.
                stream().
                filter(t->t.getNotOrt()>63).
                mapToInt(t->t.getOgrcSayisi()).//bunu yapinca reduce'e gerek kalmiyor, akisi int wrapper classina atmis oluyoruz
        sum();


    }



    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.

    public static OptionalDouble ogrcSayisiort333denByk(List<Universite> unv){

       return unv.
               stream().
               filter(t->t.getOgrcSayisi()>333).
               mapToDouble(t->t.getNotOrt()).//akistaki elemanlarin data type'ini parametresindeki degere gore update eder
               average();
    }


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int mathBolmSayisi(List<Universite> unv){

        return (int) unv.stream().filter(t->t.getBolum().contains("mat")).count();

    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static OptionalInt ogrcSayisiort571denBykNotOrtlamasi(List<Universite> unv){

        return unv.stream().
                filter(t->t.getOgrcSayisi()>571).
                mapToInt(t->t.getNotOrt()).//akistaki unv objelerini notOrt akisi olarak update edildi
                max();//akisin en buyuk degerini alir
    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrSayisi1071MinnotOrt(List<Universite> unv){

         return unv.stream().
                filter(t->t.getOgrcSayisi()<1071).
                mapToInt(t->t.getNotOrt()).min();

    }


}