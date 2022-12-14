/**
 * TEST 1 JAVA
 * Oblasti pokrivene testom: PROMENLJIVE, GRANANJA, PETLJE, NIZOVI, METODE
 * Vreme trajanja testa: 120 minuta
 * Maksimalan broj poena: 100
 * Broj poena po zadatku: 20
 *
 * Ime klase: ImePrezime(PeraPeric)
 * Napomena: Zadatak se smatra uradjenim ukoliko implementira zadatu funkcionalnost sa arbitrarnim argumentima.
 * Neki od mogucih argumenata su dati u javadoc opisu implementacije.
 * Ne menjati potpise metoda zbog brzeg i lakseg uvida u rad.
 * Voditi racuna da metoda vraca zahtevanu vrednost.
 *
 * Po zavretku upload-ovati file na uploadLokacija.
 * UploadLokacija: https://drive.google.com/drive/folders/17gLXRxx8l7Y_JN8WsAlXVjpRGwd8dq4z
 *
 */
public class AleksandarDjordjevic {

    /**
     * Implementirati deskripciju numericke ocene.
     * 5 - odlican
     * 4 - vrloDobar
     * 3 - dobar
     * 2 - dovoljan
     * 1 - nedovoljan
     * Za svaku ocenu koja nije 1-5 vratiti prazan string ""
     * @param ocena ocena
     * @return deskripcija numericke ocene
     */
    public static String ocene(int ocena) {//moze i sa switch
        String opisOcene="";

      if(ocena==1){
            opisOcene="nedovoljan";
        }
        else if (ocena==2){
            opisOcene="dovoljan";
        }
        else if (ocena==3){
            opisOcene="dobar";
        }
        else if (ocena==4){
            opisOcene="vrloDobar";
        }
        else if (ocena==5){
            opisOcene="odlican";
        }
        return opisOcene;
    }

    /**
     * Implementirati metodu koja vraca sumu svih elemenata niza, i to tako da je
     * svaki element pomnozen sa indeksom na kojim se nalazi.
     * {1, 2, 3, 4, ...} -> (1 * 0) + (2 * 1) + (3 * 2) + (4 * 3) + ...
     * {99} -> 99 * 0
     * {} -> 0
     * @param niz unos niz
     * @return suma
     */
    public static int proizvodElemenataNizaSaIndeksima(int[] niz) {
        int suma=0;
        for(int i =0;i<niz.length;i++){
            suma=suma+i*niz[i];
        }
        return suma;
    }

    /**
     * Implementirati metodu koja pretvara niz od String podataka u niz
     * u kome su svi stringovi mala slova.
     * {"Stefan", "Dusan", "Ana"} -> {"stefan", "dusan", "ana"}
     * {"ZDRAVO JA SAM PROGRAM"} -> {"zdravo ja sam program"}
     * {"ZDRAVO JA", "SAM PROGRAM"} -> {"zdravo ja", "sam program"}
     * {} -> {}
     * @param niz unos niz
     * @return novi niz sa malim slovima
     */
    public static String[] lowerCaseNiz(String[] niz) {
        String [] reciSaMalimslovima=new String[niz.length];
        for (int i =0;i<niz.length;i++){
            reciSaMalimslovima[i]=niz[i].toLowerCase();
        }

        return reciSaMalimslovima;
    }

    /**
     * Implementirati metodu koja vraca indeks na koji treba ubaciti element,
     * tako da je redosled elemenata sacuvan. Pretpostaviti da je niz rastuci.
     * ({1, 2, 3, 4, 5}, 1.5) -> 1
     * ({77, 78, 79, 80, 81}, 76.999999) -> 0
     * ({-11, -10, -9, -8, -7}, 7) -> 5
     * @param element broj
     * @param niz niz kao input
     * @return index
     */
    public static int indexGdeElementPripada(int  element, int[] niz) {
        int index=0;
        if (element<niz[0]){
            index=0;

        }
        if(element>niz[niz.length-1]){
            index=niz.length;
        }
        for(int i =0;i<niz.length-1;i++){

                if (niz[i] <=element && element <= niz[i+1]) {//vece ili jednako u ovom slucaju zbog int
                                                                //sa double tipom samo vece i manje
                    index = i + 1;
                }

                
            
            
        }
        return index;
    }

    /**
     * Implementirati metodu koja vraca slovo koje fali u nizu alfabeta.
     * Alfabet : A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
     * ABD -> "C"
     * IJKLN -> "M"
     * WXYZ -> ""
     * @param nizSlova niz slova. Ne mora pocinjati sa "A"
     * @return slovo koje nedostaje, ili prazan string "" ukoliko je redosled ispravan
     */
    public static String abeceda(String nizSlova) {
        String slovo="";
       //int  t=nizSlova.charAt(0);
      // int p =nizSlova.charAt(nizSlova.length()-1);
       // slovo =slovo+t+p;
        for (int  i = nizSlova.charAt(0);i<nizSlova.charAt(nizSlova.length()-1);i++) {
            boolean t=false;
            for(int j= 0;j<nizSlova.length();j++){
            if (nizSlova.charAt(j)==i){
                t=true;
                break;
            }

        }
            if (!t) {
            slovo = slovo + (char) i;
        }

        }
        return slovo;
    }

    public static void main(String[] args) {
      //  System.out.println(ocene(1));
       int niz[]=new int []{1,2,4};
      // System.out.println(proizvodElemenataNizaSaIndeksima(niz));
       // String [] nizReci= new String[]{"milak"};
       // System.out.println(Arrays.toString(lowerCaseNiz(nizReci)));
       // System.out.println(indexGdeElementPripada(5,niz));
      // String a="ABDE";
       // System.out.println(abeceda(a));

        }
    }


