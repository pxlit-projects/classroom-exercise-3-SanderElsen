package be.pxl.mockitis;

import java.util.List;
import java.util.Optional;

public class Settlement {
    private List<Settler> settlers;

    public Settlement(List<Settler> settlers) {
            this.settlers = settlers;
    }

    public void defend(Raiders raiders) {
        //Zou ook een manier kunnen vinden om ze niet 1v1 beide te laten sterven maar dat is voor een andere keer.
        for (int i =0;i<raiders.getAmountOfRaiders();i++){
            Optional<Settler> upForSlaughter = settlers.stream().filter(s -> s.getState() == Settler.SettlerState.DEFENDER).findFirst();
            if (upForSlaughter.isPresent()){
                upForSlaughter.get().kill();
            }else{
                wipe();
            }
        }
    }

    public void wipe(){
        settlers.stream().filter(s -> s.getState() != Settler.SettlerState.DEAD).forEach(Settler::kill);
    }

    /*
        filters kunnen ook aangepast worden met: "is[insert state here]" functies in de settler maar daar was ik te tam voor
    */
    public long getDefenders(){
        return settlers.stream().filter(s -> s.getState() == Settler.SettlerState.DEFENDER).count();
    }
    public long getWorkers(){
        return settlers.stream().filter(s -> s.getState() == Settler.SettlerState.WORKER).count();
    }
    public long getDead(){
        return settlers.stream().filter(s -> s.getState() == Settler.SettlerState.DEAD).count();
    }
    public long getTotalPopulation(){
        return settlers.size();
    }
    public long getAlivePopulation(){
        return settlers.stream().filter(s -> s.getState() != Settler.SettlerState.DEAD).count();
    }
}
