package Problem;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by lucas on 22/10/15.
 */
public class State{

    private float cost;
//    private T state_descrip;
    private List<Integer> state_descrip;

    public State(float cost, ArrayList<Integer> state){

        this.cost = cost;
        this.state_descrip = new ArrayList<Integer>();
        this.state_descrip.addAll(state);
    }

    public float getCost() {
        return cost;
    }

    public List<Integer> getState_descrip() {
        return state_descrip;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setState_descrip(List<Integer> state_descrip) {
        this.state_descrip = state_descrip;
    }
}
