package lambdapractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C07_DosyaOkuma {
    /*
    dosya eklemek icin 2 yol var
    1) Files.lines(Path.of("path")  buradan stream e eklemek icin
    Stream <String> satir=Files.lines(Path.of(".........."));
    bu bize tekrardan stream tanimlamadan kullanmayi saglar
    2) //Files.lines(Paths.get("..........")).  kullanilir
    ==========================================================
    intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
    bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
    sonrasinda copy path seciyoruz bundan sonra iki secenek var
    1) absolute path seciyoruz yada
    2) path from content root seciyoruz
    her ikisinde de path kopyalamis oluyoruz
    cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
    buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
    */
        public static void main(String[] args) throws IOException {

            Path dosya = Path.of("src/lambdapractice/C7_TextFile");
            //NOT PATH cift tirnak icine alinmali
            //artik stream e donustu methodlari kullanabiliriz
            Stream<String> akis = Files.lines(dosya);

            // S1: Yazdiralim
            akis.forEach(System.out::println);
            //S2: tum harflari buyuk harf ile yazdiralim
            Files.lines(dosya).map(String::toUpperCase).forEach(System.out::println);
            // S3: son satiri buyuk harfle yazdiralim
            System.out.println("ilk satiri buyuk yazdirma :  ");
            Files.lines(dosya).
                    sorted(Comparator.reverseOrder()).
                    limit(1).
                    map(t->t.toString().toUpperCase()).
                    forEach(System.out::println);

            //S4: 2.ve 3. satirlari yazdiralim

            System.out.println("2.ve 3. satirlari yazdiralim");
            Files.lines(dosya).
                    skip(1).limit(2).
                    forEach(System.out::println);

            //S5: kac tane "icin" kelimesi vardir
            System.out.println("kac tane icin kelimesi vardir : ");
            System.out.println(Files.lines(dosya).
                    filter(t -> t.contains("icin")).
                    count());

            //S6: tum kelimelerin tum kelimeleri natural order  yazdiriniz.
            System.out.println("kelimeleri natural ordera gore siralama : ");

            Files.lines(dosya).
                    map(t->t.split(" ")).
                    flatMap(Arrays::stream).
                    map(t->t.replaceAll("[.!,:)\\-]", "").
                             replaceAll("\\d", "")).
                    sorted().
                    forEach(System.out::println);
            // S7:  metinde kac tane "a"  vardir
            System.out.println("Metinde kac a vardir :");
            System.out.println(Files.lines(dosya).
                    filter(t -> t.contains("a")).count());

        }

        }

