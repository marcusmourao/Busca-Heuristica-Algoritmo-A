package Problem;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by lucas on 22/10/15.
 */
public class State{

    private Puzzle current_puzzle;

    public Puzzle getCurrent_puzzle() {
        return current_puzzle;
    }

    public void setCurrent_puzzle(Puzzle current_puzzle) {
        this.current_puzzle = current_puzzle;
    }

    public int getHeuristic(){
        return this.current_puzzle.getHeuristic();
    }

    public List<Puzzle> generate_sons(){

        List <Puzzle> sons = new ArrayList<Puzzle>();

        Puzzle top_son = new Puzzle(this.current_puzzle.clone());
        Puzzle down_son = new Puzzle(this.current_puzzle.clone());
        Puzzle right_son = new Puzzle(this.current_puzzle.clone());
        Puzzle left_son = new Puzzle(this.current_puzzle.clone());

        if(top_son.move_top())
            sons.add(top_son);
        if(down_son.move_down())
            sons.add(down_son);
        if(right_son.move_right())
            sons.add(right_son);
        if(left_son.move_left())
            sons.add(left_son);

        return sons;
    }

    //    private float cost;
//   // private T state_descrip;
//    private List<Integer> state_descrip;
//
//    public State(float cost, ArrayList<Integer> state){
//
//        this.cost = cost;
//        this.state_descrip = new ArrayList<Integer>();
//        this.state_descrip.addAll(state);
//    }
//
//    public float getCost() {
//        return cost;
//    }
//
//    public List<Integer> getState_descrip() {
//        return state_descrip;
//    }
//
//    public void setCost(float cost) {
//        this.cost = cost;
//    }
//
//    public void setState_descrip(List<Integer> state_descrip) {
//        this.state_descrip = state_descrip;
//    }
}
