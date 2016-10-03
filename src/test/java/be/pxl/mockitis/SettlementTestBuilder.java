package be.pxl.mockitis;

import java.util.*;

public class SettlementTestBuilder {

    private List<Settler> settlers;

    public static SettlementTestBuilder aSettlement(){
        return new SettlementTestBuilder();
    }

    public Settlement build() {
        return new Settlement(settlers);
    }

    public SettlementTestBuilder withSettlers(List<Settler> settlers){
        this.settlers = settlers;
        return this;
    }
}
