import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("TASK 01 Amele-->" + toplamAmele(10));
        System.out.println("TASK 01 Cincix-->" + toplaCincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" +toplaCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + toplaIlkXCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->" +toplaIlkXTek(10));
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvvetPrint(7);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        istenenSayininIlkXKuvvetPrint(4,3);
        System.out.println("====");
        istenenSayininIlkXKuvvetPrint(3,4);
        System.out.println("====");
        istenenSayininIlkXKuvvetPrint(14531453,1);
        System.out.println("\n  ***   ");

        System.out.println("TASK 07 -->" +istenenSayininFaktoryeli(5));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->" + xKuvveti(4,3));
        System.out.println("TASK 08 -->" + xKuvveti(3,4));
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming

    public static int toplamAmele(int x){
        int toplam = 0;
        for (int i = 1; i <=x ; i++) {
            toplam+=i;

        }
        return toplam;
    }

    //Functional(cincix Programming

    public static int toplaCincix(int x){
        return IntStream.
                range(1,x+1).//1'den x;e kadar (+1 dahil ediyor x'i) int degerler akisa alindi
                        /*
                        range ilk degeri alir, ikincisini almaz
                         */
                sum();//degerler toplandi

    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x){
        return IntStream.
                rangeClosed(1,x).//burada a ve b degerleri dahil demektir
                filter(Lambda01::ciftBul).
                sum();
    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int toplaIlkXCift(int x){
        return IntStream.
                iterate(2,t->t+2).//2'den baslayarak sonsuza kadar elemanlari 2 artirarak akisa alir
                limit(x).//akistaki x'e kadar olan degerleri alir
                sum();
    }


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x){
        return IntStream.
                iterate(1,t->t+2).//2'den baslayarak sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x).//akistaki x'e kadar olan degerleri alir
                        sum();
    }


    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x){
         IntStream.
                iterate(2,t->t*2).//2'den baslayarak sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x).//akistaki x'e kadar olan degerleri alir
                        forEach(Lambda01::yazdir);
    }



    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayininIlkXKuvvetPrint(int istenenSayi,int x){
        IntStream.
                iterate(istenenSayi,t->t*istenenSayi).//2'den baslayarak sonsuza kadar elemanlari 2 artirarak akisa alir
                limit(x).//akistaki x'e kadar olan degerleri alir
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayininFaktoryeli(int x){
      return  IntStream.
                rangeClosed(1,x).
               // reduce(Math::multiplyExact)
               reduce(1, (t,u)->t*u);
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.

    public static int xKuvveti (int istenenSayi, int x) {
        return //Math.pow(istenenSayi,x);
        IntStream.iterate(istenenSayi,t->t*istenenSayi).limit(x).reduce(0,(t,u)->u);

                //limit(x).skip(x-1).findFirst().orElseThrow();

    }
}

