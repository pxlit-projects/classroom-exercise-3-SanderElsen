package be.pxl.mockitis;

public class SettlerTestBuilder {
    private Settler.SettlerState state;

    public static SettlerTestBuilder aSettler(){
        return new SettlerTestBuilder();
    }
    public SettlerTestBuilder withState(Settler.SettlerState state) {
        this.state = state;
        return this;
    }

    public Settler build() {
        return new Settler(state);
    }
}