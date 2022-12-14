import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class AleksandarDjordjevicMiniProject {
    public static void main(String[] args) {
        System.out.println("Zbir cifara je: " + zbirCifara(55));
        System.out.println(stepenBroja(125, 5));
        System.out.println(Arrays.toString(zbirIndexaNizaMeta(new int[]{12, 3, 4, -2}, 7)));
        System.out.println(toBinary(100));
        System.out.println("Broj reci koja se trazi je: " + brojPonavljanja("  cao", "cao ,pozdravljam te,cao, caocao pozdrav"));
        System.out.println(Arrays.toString(pomeriNule(new int[]{0, 5, 4, 0, 2, 0, 0, 3, 0, 0})));
        System.out.println(Arrays.toString(izbaciDuplikate(new int[]{6, 6, 5, 5, 4, 2})));

        //8 zadatak
        String[] set = {"1", "2", "3"};
        int i = set.length - 1;
        ArrayList<ArrayList<String>> result = powerSet(set, i);
        System.out.println(result);

        //9 zadatak
        validatePhone("(061) 1722126");
    }
    //0.Implementirati metode za unos elemenata niza varijabilne dužine. Elementi treba da budu tipa int, String i char.

    public static int[] unosCelihBrojeva() {
        Scanner s = new Scanner(System.in);
        System.out.print("Unesite duzinu niza celih brojeva: ");
        int duzina = s.nextInt();
        int[] nizCelihBrojeva = new int[duzina];
        for (int i = 0; i < duzina; i++) {
            System.out.println("Unesite" + i + ". clan niza: ");
            nizCelihBrojeva[i] = s.nextInt();
        }
        return nizCelihBrojeva;
    }

    public static String[] unosStringova() {
        Scanner s = new Scanner(System.in);
        System.out.print("Unesite duzinu niza reci: ");
        int duzina = s.nextInt();
        String[] nizStringova = new String[duzina];
        for (int i = 0; i < duzina; i++) {
            System.out.println("Unesite" + i + ". clan niza: ");
            nizStringova[i] = s.next();
        }
        return nizStringova;
    }

    public static char[] unosKaraktera() {
        Scanner s = new Scanner(System.in);
        System.out.print("Unesite duzinu niza karaktera: ");
        int duzina = s.nextInt();
        char[] nizKaraktera = new char[duzina];
        for (int i = 0; i < duzina; i++) {
            System.out.println("Unesite" + i + ". clan niza: ");
            nizKaraktera[i] = s.next().charAt(i);
        }
        return nizKaraktera;
    }

//1. Implementirati metodu int zbirCifara(int n) koja sabira cifre sve dok rezultat ne bude samo jedna cifra.
// Npr. 1234 -> 1, 43 -> 7, 55 -> 1, 556 -> 7

    public static int zbirCifara(int n) {
        int sum = 0;
        while (n > 0 || sum > 9) {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    //2. Implementirati metodu boolean stepenBroja(int n, int m) koja vraća true ukoliko je n stepen broja m.
    //Npr: (9, 3) -> true, (125, 5) -> true, (13, 4) -> false

    public static boolean stepenBroja(int n, int m) {
        boolean pripada = true;
        int rezultat = 1;
        while (rezultat < n) {
            rezultat *= m;
        }
        if (rezultat != n) {

            pripada = false;
        }
        return pripada;
    }

    //3. Implementirati metodu int[] zbirIndexaNizaMeta(int[] niz, int meta) koja vraća indekse dva elementa koji kada se saberu daju rezultat koji je jednak meti.
    //Npr. ({2, 3, 10, -2}, 5) -> {0, 1}

    public static int[] zbirIndexaNizaMeta(int[] niz, int meta) {

        int[] rezultat = new int[2];
        for (int i = 0; i < niz.length; i++) {
            for (int j = 1 + i, k = 0; j < niz.length; j++) {
                if (niz[i] + niz[j] == meta) {
                    rezultat[k] = i;
                    rezultat[k + 1] = j;
                    break;
                }
            }
        }

        return rezultat;
    }

    //4. Implementirati metodu String toBinary(int n) koja vraća broj n u binarnom formatu. Uzeti apsolutnu vredost n.
    //Npr. 10 -> 1010, 100 -> 1100100

    public static String toBinary(int n) {
        n = Math.abs(n);
        int pocetnaCifra = 1;

        int duzinaNiza = 0;
        while (pocetnaCifra < n) {
            pocetnaCifra *= 2;
            duzinaNiza++;
        }
        int[] niz = new int[duzinaNiza];
        pocetnaCifra = 1;
        for (int i = duzinaNiza - 1; i < duzinaNiza; i--) {
            niz[i] = pocetnaCifra;
            pocetnaCifra *= 2;
            if (i <= 0) {
                break;
            }
        }
        n = n - niz[0];
        niz[0] = 1;
        for (int i = 1; i < duzinaNiza; i++) {
            if (n < niz[i]) {
                niz[i] = 0;
                continue;
            } else {
                n = n - niz[i];
                niz[i] = 1;
            }

        }


        String binarniBroj = Arrays.toString(niz);
        return binarniBroj;
    }

    //  5. Implementirati metodu int brojPonavljanja(String s, String recenica) koja vraća broj ponavljanja stringa "s" u rečenici. Hint: istražiti s.split("") metodu.
    //  Npr. ("cao", "cao kako si cao") -> 2

    public static int brojPonavljanja(String s, String recenica) {
        s = s.trim();
        recenica = recenica.toLowerCase();
        int brojReci = 0;
        String trazenaRec = "";

        for (int i = 0; i < recenica.length(); i++) {
            if (recenica.charAt(i) == s.charAt(0)) {
                trazenaRec += recenica.charAt(i);
                for (int j = i + 1, k = 1; k < s.length(); j++, k++) {
                    if (recenica.charAt(j) == s.charAt(k)) {

                        trazenaRec += recenica.charAt(j);
                    }
                }
            }
        }
        brojReci = trazenaRec.length() / s.length();

        return brojReci;
    }

    //6. Implementirati metodu int[] pomeriNule(int[] niz) koja vraća niz u kome su sve nule pomerene na kraj niza.
    //Npr. {1, 0, 0, 2, 3} -> {1, 2, 3, 0, 0}

    public static int[] pomeriNule(int[] niz) {
        int cuvanjeNula;
        Arrays.sort(niz);
        for (int i = 0; i < niz.length; i++) {
            for (int j = i + 1; j < niz.length; j++) {
                if (niz[j] != 0) {
                    cuvanjeNula = niz[i];
                    niz[i] = niz[j];
                    niz[j] = cuvanjeNula;
                    break;
                }
            }
        }

        return niz;
    }

    //7. Implementirati metodu int[] izbaciDuplikate(int[] niz) koja vraća niz bez duplikata.
    //Npr. {1, 2, 3, 3} -> {1, 2, 3}, {3, 4, 3, 4, 3, 4, 5} -> {3, 4, 5}

    public static int[] izbaciDuplikate(int[] niz) {
        int kraj = niz.length;

        for (int i = 0; i < kraj; i++) {
            for (int j = i + 1; j < kraj; j++) {
                if (niz[i] == niz[j]) {
                    int pomeranje = j;
                    for (int k = j + 1; k < kraj; k++, pomeranje++) {
                        niz[pomeranje] = niz[k];
                    }
                    kraj--;
                    j--;
                }
            }

        }
        int[] nizBezDuplikata = new int[kraj];
        for (int i = 0; i < kraj; i++) {
            nizBezDuplikata[i] = niz[i];
        }
        return nizBezDuplikata;
    }

    //8. Implementirati metodu int[][] powerSet(int[] niz) koja vraća partitivni skup, odnosno, skup svih podskupova niza.
//Npr. {1, 2} -> {{1, 2}, {1}, {2}, {}}, {1, 2, 3} -> {{1, 2, 3}, {1, 2}, {1, 3}, {2, 3}, {1}, {2}, {3}, {}}



    static ArrayList<ArrayList<String> > powerSet(String[] set, int i)
    {
        ArrayList<ArrayList<String> > allSubsets;
        if (i < 0) {
            allSubsets = new ArrayList<ArrayList<String> >();
            allSubsets.add(new ArrayList<String>());
        }

        else {
            allSubsets = powerSet(set, i - 1);
            String item = set[i];
            ArrayList<ArrayList<String> > moreSubsets
                    = new ArrayList<ArrayList<String> >();

            for (ArrayList<String> subset : allSubsets) {
                ArrayList<String> newSubset = new ArrayList<String>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }




//9. Implementirati metodu boolean validatePhone(String num) koja proverava da li je broj napisan u odgovarajućem formatu.
//Pretpostaviti da se validan telefonski broj može pojaviti u jednom od sledećih formata: (xxx) xxx-xxxx ili xxx-xxx-xxxx gde 'x' predstavlja jednu cifru.
//Za ovaj zadatak koristiti regex.

    public static boolean validatePhone(String num) {
        String patterns = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        boolean poklapanje;
        if (num.matches(patterns)) {
            poklapanje = true;
            System.out.println("Broj je validan!");
        } else {
            poklapanje = false;
            System.out.println("Broj nije validan!");
        }
        return poklapanje;

    }
}