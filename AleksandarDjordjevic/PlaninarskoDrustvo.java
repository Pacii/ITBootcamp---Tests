package AleksandarDjordjevic;

import java.util.ArrayList;

public class PlaninarskoDrustvo {
    private ArrayList<Planinar> planinari;

    public PlaninarskoDrustvo(ArrayList<Planinar> planinari) {
        this.planinari = planinari;
    }

    public ArrayList<Planinar> getPlaninari() {
        return planinari;
    }

    @Override
    public String toString() {
        return "PlaninarskoDrustvo{" +
                "planinari=" + planinari +
                '}';
    }

    public void setPlaninari(ArrayList<Planinar> planinari) {
        this.planinari = planinari;
    }
    public void izbaciPlaninara(int id){
        for (int i = 0; i < planinari.size(); i++){
            if(planinari.get(i).getId() == id){
                planinari.remove(i);
            }
        }
    }
    public int najuspesnijiPlaninar(){
        if (this.getPlaninari().size() == 0){
            return 0;
        }
        int najviseMetara = 0;
        for (Planinar planinar : planinari){
            int sumaMetara = 0;
            for (Planina planina : planinar.getPlanine()){
                sumaMetara += planina.getVisina();
            }
            if (najviseMetara < sumaMetara){
                najviseMetara = sumaMetara;
            }
        }
        int idPlaninara = 0;
        for (Planinar planinar : planinari){
            int tempSuma = 0;
            for (Planina planina : planinar.getPlanine()){
                tempSuma += planina.getVisina();
            }
            if (tempSuma == najviseMetara){
                idPlaninara = planinar.getId();
                break;
            }
        }
        return idPlaninara;
    }
    public double prosecnaClanarinaPlaninara(){
        int sumaClanarina = 0;
        for (Planinar planinar : planinari){
            sumaClanarina += planinar.clanarina();
        }
        return sumaClanarina/planinari.size();
    }
    public boolean popniSeNaPlaninu(Planina p){
        if (this.getPlaninari().size() == 0){
            return false;
        }
        int brojAlpinistaSaIskustvom = 0;
        for (Planinar planinar : planinari){
            if (planinar instanceof Alpinista && (((Alpinista) planinar).getGodineIskustva() > 5)){
                brojAlpinistaSaIskustvom++;
            }
        }
        int brojUspesnihUspona = 0;
        for (Planinar planinar : planinari){
            if (planinar.uspesanUspon(p)){
                brojUspesnihUspona++;
            }
        }
        boolean popniSe = false;
        if ((brojAlpinistaSaIskustvom) > 0 && (brojUspesnihUspona > ((2*planinari.size())/3))){
            popniSe = true;
        }
        return popniSe;
    }
    public void sortPlaninariPoClanarini(){
        this.getPlaninari().sort(Planinar::compareTo);
    }

    public static void main(String[] args) {
        Planina prvaPlanina = new Planina("Stara planina", 2100);
        Planina drugaPlanina = new Planina("Kopaonik", 1950);
        Planina trecaPlanina = new Planina("Sar planina", 2300);
        Planina cetvrtaPlanina = new Planina("Zlatibor", 1700);
        Planina petaPlanina = new Planina("Vrsacke planine", 800);
        Planina sestaPlanina = new Planina("Rudnik", 1300);
        ArrayList<Planina> planine = new ArrayList<>();
        planine.add(prvaPlanina);
        planine.add(drugaPlanina);
        planine.add(trecaPlanina);
        planine.add(cetvrtaPlanina);
        planine.add(petaPlanina);
        planine.add(sestaPlanina);
        ArrayList<Planina> planine2 = new ArrayList<>();
        planine2.add(prvaPlanina);
        planine2.add(petaPlanina);
        planine2.add(sestaPlanina);

        Alpinista prviAlpinista = new Alpinista(1, "Marko", "Markovic", planine, 2300, 7);
        Alpinista drugiAlpinista = new Alpinista(2, "Petar", "Petrovic", planine2, 2000, 3);
        Rekreativac prviRekreativac = new Rekreativac(3,"Aleksandar", "Jovanovic", planine, 2300, 10);
        Rekreativac drugiRekreativac = new Rekreativac(4,"Nikola", "Nikolic", planine2, 2000, 5);
        ArrayList<Planinar> p1 = new ArrayList<>();
        p1.add(prviAlpinista);
        p1.add(drugiAlpinista);
        p1.add(prviRekreativac);
        p1.add(drugiRekreativac);
        PlaninarskoDrustvo drustvo = new PlaninarskoDrustvo(p1);
        System.out.println("Najuspesniji planinar je planinar sa id: " + drustvo.najuspesnijiPlaninar());
        System.out.println(drustvo.prosecnaClanarinaPlaninara());
        System.out.println(drustvo.popniSeNaPlaninu(trecaPlanina));
        System.out.println(drustvo.popniSeNaPlaninu(petaPlanina));
        drustvo.sortPlaninariPoClanarini();
        System.out.println(p1.toString());
        drustvo.izbaciPlaninara(1);
        System.out.println(p1.toString());
    }
}
