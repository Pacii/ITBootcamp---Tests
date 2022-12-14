package AleksandarDjordjevic;

import java.util.ArrayList;

public class Rekreativac extends Planinar {
    private double tezinaOpreme;

    public Rekreativac(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon, double tezinaOpreme) {
        super(id, ime, prezime, planine, maxUspon);
        this.tezinaOpreme = tezinaOpreme;
    }

    public double getTezinaOpreme() {
        return tezinaOpreme;
    }

    public void setTezinaOpreme(double tezinaOpreme) {
        this.tezinaOpreme = tezinaOpreme;
    }
    @Override
    public boolean uspesanUspon(Planina p){
        double noviMaksUspon = this.getMaxUspon()-(this.getTezinaOpreme()*50);
        if (p.getVisina() <= noviMaksUspon){
            this.getPlanine().add(p);
            return true;
        } else return false;
    }
    @Override
    public double clanarina(){
        double clanarine = 0;
        double bonus;
        double planine = this.getPlanine().size();
        if (this.getPlanine().size() == 0){
            return 1000;
        } else
            bonus = ((planine * 2) / 100) * 1000;
            clanarine = 1000 - bonus;
            return clanarine;
    }
}
