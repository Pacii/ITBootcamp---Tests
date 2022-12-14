package AleksandarDjordjevic;

import java.util.ArrayList;

public class Alpinista extends Planinar{
    private int godineIskustva;

    public Alpinista(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon, int godineIskustva) {
        super(id, ime, prezime, planine, maxUspon);
        this.godineIskustva = godineIskustva;
    }

    public int getGodineIskustva() {
        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        this.godineIskustva = godineIskustva;
    }
    @Override
    public boolean uspesanUspon(Planina p){
        if (p.getVisina() <= this.getMaxUspon()){
            this.getPlanine().add(p);
            return true;
        } else return false;
    }
    @Override
    public double clanarina(){
        double above2000Counter = 0;
        double clanarina;
        double bonus = 0;
        for (Planina planina : this.getPlanine()){
            if (planina.getVisina() > 2000){
                above2000Counter+= 1;
            }
        }
        if (above2000Counter == 0){
            return 1500;
        } else
            bonus = (1500*((above2000Counter*5)/100));
            clanarina = 1500-bonus;
            return clanarina;
    }
}
