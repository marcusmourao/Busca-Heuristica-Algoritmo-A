package Problem;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by lucas on 22/10/15.
 */
public class State{

    private Puzzle current_puzzle;

    public State(Puzzle puzzle){
        this.current_puzzle = puzzle;
    }

    public Puzzle getCurrent_puzzle() {
        return current_puzzle;
    }

    public void setCurrent_puzzle(Puzzle current_puzzle) {
        this.current_puzzle = current_puzzle;
    }

    public int getHeuristic(){
        return this.current_puzzle.getHeuristic();
    }

    /*
    * Gera os puzze filho, monta os estados e retorna uma lista de estados filho
    *
    * */
    public ArrayList<State> generate_sons(){

        ArrayList <Puzzle> sons = new ArrayList<Puzzle>();

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

        ArrayList<State> states_son = new ArrayList<>();

        for(Puzzle son: sons){
            states_son.add(new State(son));
        }

        return states_son;
    }

    /*
     * verifica se a matriz do estado corrente eh igual a matriz do estado passado por parametro
     *
     * */
    public void state_iguals(State state){
    }

    /*
    * verifica se a funcao de avaliacao do estado corrente é menor que a
    * funcao de avaliacao do estato passado por parametro
    * caso seja verdade retorna true, cc retorna false;
    *
    * */
    public boolean evaluation_cost(State state){

       if(this.current_puzzle.getCost_currently() < state.getCurrent_puzzle().getCost_currently())
           return true;
       else
           return false;
    }
}
