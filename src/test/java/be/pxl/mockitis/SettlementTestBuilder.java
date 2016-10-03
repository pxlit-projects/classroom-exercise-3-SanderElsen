package be.pxl.mockitis;

import java.util.*;

public class SettlementTestBuilder {

    private int amountOfDefenders;
    private int amountOfNonDefenders;

    public static SettlementTestBuilder aSettlement(){
        return new SettlementTestBuilder();
    }

    public Settlement build() {
        Settlement settlement;
        List<Settler> settlers = new ArrayList<>();
        for (int i = 0;i < amountOfDefenders;i++){
            settlers.add(new Settler(true));
        }
        for (int i = 0;i < amountOfNonDefenders;i++){
            settlers.add(new Settler(false));
        }
        settlement = new Settlement(settlers);
        return settlement;
    }

    public SettlementTestBuilder withDefenders(int amountOfDefenders){
        this.amountOfDefenders = amountOfDefenders;
        return this;
    }
    public SettlementTestBuilder withNonDefenders(int amountOfNonDefenders){
        this.amountOfNonDefenders = amountOfNonDefenders;
        return this;
    }
}
