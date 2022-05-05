import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {


        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilice", "havucDilim", "buryan", "yaglama",
                "kokorec", "arabAsi", "guvec"));

        alfBykTekrrsiz(menu);
        System.out.println("\n    *****   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n    *****   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n    *****   ");
        chrSayisiBkSirala(menu);
        System.out.println("\n    *****   ");
        sonHrBkSirala(menu);
        System.out.println("\n    *****   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n    *****   ");
        wIleBaslyanElKontrol(menu);
        System.out.println("\n    *****   ");
        xIleBitenElKontrol(menu);
        System.out.println("\n    *****   ");
        ilkElHaricSonHrfSiraliPrint(menu);
        System.out.println("\n    *****   ");
        charSayisiBykElPrint(menu);
    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void alfBykTekrrsiz(List<String> menu) {

        menu.//akis kaynagi
                stream().//akisa girdi
                //map(t->t.toUpperCase()).//Lambda Expression ile elemanlar buyuk harf oldu
                        map(String::toUpperCase).//Method ref ile elemanlar buyuk yazildi
                sorted().//dogal siralama yapti
                distinct().//benzersiz/tekrarsiz hale getirdi akistan gelen elemanlari
                forEach(t -> System.out.println(t + " "));//print etti

        //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır. Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
// Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
// Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.

    }

// Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz.
/*
burada map yapmak lazim String'i yani karakter sayisina cevirip, daha sonra yazdiracagiz
 */
    public static void chrSayisiTersSirali(List<String> menu){

        menu.stream().
                //map(t->t.length()). ya da alttaki
                map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().forEach(Lambda01::yazdir);

    }

// Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    //karakter sayisina gore karsilastirma yapmamizi istiyor/String

    public static void chrSayisiBkSirala(List<String> menu){

        menu.
                stream().
                sorted(Comparator.
                        comparing(String::length)).//karakter sayisi verir
                forEach(t -> System.out.print(t + " "));
    }

// Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    /*
    elemanlari update etseydik map kullanirdik ama burada sadece sirala dedigi icin sorted kullandik
    once son harf bulundurulacak, sonra ters siralma yapilacak
     */

    public static void sonHrBkSirala(List<String> menu){

        menu.stream().
                sorted(Comparator.
                        comparing(t->t.toString().
                                charAt(t.toString().length()-1)).reversed()).
                forEach(t -> System.out.print(t + " "));

    }


    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz...
    public static void charKaresiCiftElSirala(List<String> menu) {
        menu.
                stream().//akısa alndı
                map(t -> t.length() * t.length()).//akısdaki string elemanları boyutlarının karesine update edildi
                filter(Lambda01::ciftBul).//cift elelmalar filtrelendi
                distinct().//tekrarsız yapıldı
                sorted(Comparator.reverseOrder()).//ters b->k sıra yapıldı
                forEach(Lambda01::yazdir);// print edildi
    }
// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    /*
    bu task icerisinde sart var ayni zamanda, boolean calismak lazim. filter yapilirsa eleman elenir
    bu nedenle bu asamada yeni method calisiyoruz allMatch
     */

    //amele kod
    public static void harfSayisi7denAzKontrol(List<String> menu){

        boolean kontrol=menu.stream().allMatch(t->t.length()<=7);
        if(kontrol){
            System.out.println("List elemanlari 7 harften daha az.");
        } else System.out.println("List elemanlari 7 harften daha buyuk.");

        //clean code
        System.out.println(kontrol);
        System.out.println(menu.stream().allMatch(t->t.length()<=7)?"List elemanlari 7 harften daha az.":"List elemanlari 7 harften daha buyuk.");
    }

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.

    public static void wIleBaslyanElKontrol(List<String> menu){

        System.out.println(menu.stream().noneMatch(t->t.startsWith("w"))?"w ile baslayan yemegin menude ne isi var?":"w ile baslayan yemek olur mu?");

    }

// Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.

    public static void xIleBitenElKontrol(List<String> menu){
        System.out.println(menu.stream().anyMatch(t->t.endsWith("x"))?"x ile biten yemegin menude ne isi var?":"x ile biten yemek olur mu?");

    }


// Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public  static void charSayisiBykElPrint(List<String> menü){
        Stream<String> sonIsim = menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                //   findFirst();//ilk eleman alındı
                        limit(3);//limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.
        /*
        limiti dogrudan yazinca adress getirir, cunku yeni akis/stream return eder. eleman vermesini istiyorsak
        list ya da Array'e atariz. Burada stream Array'de calisir. Bu yuzden Array'e ceviriyorum. toArray ile (asagida)
        ceviriyoruz.ilk bes eleman, son bes eleman gibi sorular icin kullanilir

         */
/*
sonIsim.toArray()--> limit() meth return dan dolayı  stream type olan sonIsim toArray() method ile array type convert edildi
 */

        System.out.println(Arrays.toString(sonIsim.toArray()));//arraya cevrilen sonIsim stream print edildi

//limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
// şekilde kesilmiş bir akış return eder. Stream return eder.
        // akıs cıktısını bir veriable assaign edilebilir
        Optional<String> enBykKrEl= menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst();//ilk eleman alındı yani sana eleman getirir

    }
// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHaricSonHrfSiraliPrint(List<String> menu){

        menu.
                stream().//akisa girdi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harfe gore siralandi
                skip(1).//ilk eleman atlandi
                forEach(t-> System.out.println(t+ " "));//print edildi

        // skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
// Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
//skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.

    }
}
