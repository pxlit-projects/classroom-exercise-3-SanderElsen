package be.pxl.mockitis;

public class Settler {
    private SettlerState state;

    public Settler(SettlerState state) {
        this.state = state;
    }
    public void kill(){
        state=SettlerState.DEAD;
    }
    public SettlerState getState(){return state;}

    public enum  SettlerState{
        DEFENDER,WORKER,DEAD
    }
}
