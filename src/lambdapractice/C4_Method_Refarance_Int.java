package lambdapractice;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL= Arrays.asList(-2,-8,-5,0,2,5,6,7,15,6,8);
        tekYaz(intL);
        System.out.println();
        System.out.print("ciftlerin carpimi : " + ciftleriCarp(intL));
        System.out.println();
        negatiflerinKareToplamlari(intL);
        System.out.println();
        pozitifKupMaxBul(intL);
    }
    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim

    public static void tekYaz(  List<Integer> l){
        l.stream().
                filter(Methods::tekMi).
                forEach(Methods::yazInteger);
    }

    // S2: ciftlein carpimini bulalim
    public static Optional<Integer> ciftleriCarp(List<Integer> l){
        return l.stream().
                filter(Methods::ciftMi).
                reduce(Math::multiplyExact);
    }

    // S3: negatiflerin kare toplamlarini  bulalim

    public static void negatiflerinKareToplamlari(List<Integer> l){
        System.out.println(l.stream().
                filter(t -> t < 0).
                map(t -> t * t).
                reduce(Integer::sum).orElseThrow());

    }
    // S4: poziflerin kuplerinden max yazdiralim

    public static void pozitifKupMaxBul(List<Integer> l){
        System.out.println(l.stream().
                filter(t -> t > 0).
                map(t -> t * t * t).
                reduce(Math::max).orElseThrow());
    }

}
