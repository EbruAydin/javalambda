import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
/*
	 	1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
	 	   Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
	       Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
	 	   Lambda’lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
	   	   Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir
	 		"Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	 	2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	 	3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	     	ve hatasiz code yazma acilarindan cok faydalidir.
	 	4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
           Lambda kullanmak hatasız code kullanmaktır.

            Collections Nedir?
            Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
            yapar. Array’ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
            yaptığı gibi, daha fazlasını da yapar.
            Java’da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
            topluluğu bir arada tutan bir yapıdır. ‘Collections Framework’ ise arayüzler ve onların kurgularından
            (implementations) oluşur.
	 */

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStuructured(sayi);
        System.out.println("\n   ***   ");
        printElFunctional(sayi);
        System.out.println("\n   ***   ");
        printElFunctional1(sayi);
        System.out.println("\n   ***   ");
        printElFunctional2(sayi);
        System.out.println("\n   ***   ");
        printCiftElSturctured(sayi);
        System.out.println("\n   ***   ");
        printCiftElFunctional(sayi);
        System.out.println("\n   ***   ");
        printCiftElFunctional1(sayi);
    }

    //Task : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStuructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }
    //Task : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayi) {
        sayi.stream().forEach((t) -> System.out.print(t + " "));
    }

    /*
        stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
        forEach() :datanin parametresine gore her bir elemanı isler
        t-> : Lambda operatoru
         Lambda Expression-->(parameter list) -> {action body}
             Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
             -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
             Body: Expressionları ve statementları içerir.

            Bir kod bloğundan oluşan bir body...
            Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
            Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

                () -> {
                 double pi = 3.1415;
                    return pi;
                };
       ahanda trick köşeşinde bugun :   Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

        */
    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);//method reference--> System.out yapısında prin methodu refere et
    }

    public static void yazdir(int a) {// verilen int degeri aynı satırda bosluk bırakarak yazdırma action yapan seed(tohum) method create edildi

        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.
                stream().
                forEach(Lambda01::yazdir);//method reference--> System.out yapısında prin methodu refere et
    }

    //structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElSturctured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    //functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElFunctional(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0).
                forEach(Lambda01::yazdir);

    }
    /*
    bi onceki method da olur ama Lambdanin mantigi () icerisine islemin nasil yapilacagini yazmamak
    bu nedenle seed methodlar create edilerek () icerisine method reference edilir.
     */

    public static boolean ciftBul(int a) {//seed(tohum) method kendiisne verilen int degerin cift olmasini kontrol eder

        return a % 2 == 0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi) {//bu sekilde yazmak daha profesyonel,tercih edilen, jasonformat denir
        sayi.
                stream().//list elemanlari akisa alindi
                filter(Lambda01::ciftBul).//ciftBul() refere edilerek akistaki elemanlar cift sayiya gore filtrelendi
                forEach(Lambda01::yazdir);//filtreden gelen elemanlar, print edildi, yazdir() refere edilerek yapildi

    }
    //functional Programming ile list elemanlarinin 34ten cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtuzKucukFunctional(List<Integer> sayi) {//seed(tohum) method kendiisne verilen int degerin cift olmasini kontrol eder

        sayi.
                stream().
                //filter(t->t<34 && t%2==0).//iki filtre bu sekilde kullanilabilir
                filter(Lambda01::ciftBul).
                filter(t -> t < 34).
                forEach(Lambda01::yazdir);
    }

    //functional Programming ile list elemanlarinin 34ten buyuk veya olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtuzKucukFunctional2(List<Integer> sayi) {//seed(tohum) method kendiisne verilen int degerin cift olmasini kontrol eder

        sayi.
                stream().
                filter(t->t<34 || t%2==0).//iki filtre bu sekilde kullanilabilir
                forEach(Lambda01::yazdir);
    }


}