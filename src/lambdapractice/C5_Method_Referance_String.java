package lambdapractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C5_Method_Referance_String {
    public static void main(String[] args) {
        List<String> l= Arrays.asList("Elma", "Muz", "Portakal", "Cilek", "Limon");
       tumHarflerBuyuk(l);
        System.out.println();
        uzunlugaGoreSirala(l);
        System.out.println();
        eIleBaslayan(l);
    }
    // S1: Tum harfleri buyuk harf ile aralarinda bosluk birakarak yazdiralim
    public static void tumHarflerBuyuk(   List<String> l){
        l.stream().map(t->t.split("")).
                flatMap(Arrays::stream).
                map(t->t.toUpperCase()).
                forEach(t-> System.out.print(t + " "));
    }

    //S2: Stringleri uzunluklarina gore siralayip yaziniz

    public static void uzunlugaGoreSirala( List<String> l){

        l.stream().
                sorted(Comparator.comparing(String::length)).
                forEach(System.out::println);

    }
    //S3: E ILE Baslayanlari yazdiralim

    public static void eIleBaslayan(List<String> l){
        l.stream().
                filter(t->t.contains("E")).forEach(System.out::println);
    }
}
