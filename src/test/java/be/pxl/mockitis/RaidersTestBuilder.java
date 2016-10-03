package be.pxl.mockitis;

public class RaidersTestBuilder {
    private int amountOfRaiders;
    private boolean hasLegendary;

    public static RaidersTestBuilder aRaiders(){
        return new RaidersTestBuilder();
    }

    public Raiders build() {
        Raiders raiders = new Raiders(hasLegendary);
        for (int i = 0;i < amountOfRaiders;i++){
            raiders.addAttacker(new Raider());
        }
        return raiders;
    }

    public RaidersTestBuilder withRaiders(int amountOfRaiders){
        this.amountOfRaiders = amountOfRaiders;
        return this;
    }

}
