public class Universite {

   /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

    private String universite;
    private String bolum;
    private int ogrcSayisi;
    private int notOrt;

    public Universite() {
    }

    public Universite(String universite, String bolum, int ogrcSayisi, int notOrt) {

        this.universite = universite;
        this.bolum = bolum;
        this.ogrcSayisi = ogrcSayisi;
        this.notOrt = notOrt;
    }


    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrcSayisi() {
        return ogrcSayisi;
    }

    public void setOgrcSayisi(int ogrcSayisi) {
        this.ogrcSayisi = ogrcSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return
                "universite='" + universite + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrcSayisi=" + ogrcSayisi +
                ", notOrt=" + notOrt +
                '\n';
    }
}
