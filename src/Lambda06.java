import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda06 {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");

        Path haluk = Path.of("src/halk.txt");//path haluk objesine atandi
        Stream<String> akis = Files.lines(haluk);//haluk.txt'indeki datalari akis stream'ine atamis oldu

        //1.yol
        Files.lines(haluk).//dosyadan bilgileri aldi ve buraya getirdi
                // Files.lines(Paths.get("src/halk.txt")).//dosyadan bilgileri aldi ve buraya getirdi
                        forEach(System.out::println);//her satirdaki string ifade yazildi

        //2.yol
        akis.forEach(System.out::println);

        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

        Files.lines(Paths.get("src/halk.txt")).map(String::toUpperCase).
                forEach(System.out::println);

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");

        //1.yol
        Files.lines(haluk).map(String::toLowerCase).limit(1).forEach(System.out::println);
        //2.yol
        System.out.println(Files.lines(haluk).map(t -> t.toLowerCase()).findFirst());

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");

        System.out.println(Files.lines(haluk).
                map(String::toLowerCase).//upper yaparsan bir sey gelmez
                        filter(t -> t.contains("basari")).
                count());

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");

        /*
        Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
        fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
        Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

        Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
        Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
        flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
        ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.

        */
        //1,yol distinct()
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).//satirdaki kelimeler Array'e atandi
                        flatMap(Arrays::stream).//2D array tek eleman olaarak akisa alindi
                        distinct().//akistaki elemanlar benzersiz yapildi
                        collect(Collectors.toList()));//akistaki tekrarsiz elemanlar liste atandi

        //2.yol toSet()
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).//satirdaki kelimeler Array'e atandi
                        flatMap(Arrays::stream).//2D array tek eleman olaarak akisa alindi
                        collect(Collectors.toSet()));

        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");

        Files.lines(haluk).
                map(t -> t.split(" ")).//satirdaki kelimeler Array'e atandi
                flatMap(Arrays::stream).
                sorted().//harf sirasi yapildi
                forEach(System.out::println);

        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(haluk).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.equals("basari")).
                count());

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).count());

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).collect(Collectors.toList()));

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("\\W", "").
                        replaceAll("\\d", "").
                        split("")).
                flatMap(Arrays::stream).distinct().
                count());

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        replaceAll("\\d", "").
                        split(" ")).
                flatMap(Arrays::stream).distinct().
                count());

        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        Files.lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        replaceAll("\\d", "").
                        split(" ")).
                flatMap(Arrays::stream).distinct().
                forEach(System.out::println);
    }
}
