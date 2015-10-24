package Logic;

import Problem.State;

import java.util.ArrayList;

/**
 * Created by lucas on 22/10/15.
 */

public class A {


    private State goal_state;

    private ArrayList<State> open_states;
    private ArrayList<State> close_states;

    public A(State init_state, State goal){
        open_states = new ArrayList<State>();
        close_states = new ArrayList<State>();

        this.goal_state = null;

        this.goal_state = goal;
        open_states.add(init_state);
    }

    public void resolve(){

        State state_currently = null;
        ArrayList<State> states_son = new ArrayList<State>();
        int position = -1;

        while(!open_states.isEmpty()){

            state_currently = open_states.get(0);
            open_states.remove(0);

            states_son.addAll(state_currently.generate_sons());

            for (State s: states_son){
                /*
                * Se o estado filho já está em open
                *
                * */
                position = contain(open_states,s);
                if(position >=0){
                    /*
                    * o novo estado filho tem uma funcao melhor (menor) que o estado
                    * pertencente a lista de abertos
                    *
                    * */
                    if(open_states.get(position).evaluation_cost(s)){
                        open_states.remove(position);
                        open_states.add(s);
                    }

                /*
                * O estado filho nao esta em open
                *
                * */
                }else{
                    /*
                    *
                    * Se o estado está em closed
                    * */
                    position = contain(close_states,s);
                    if(position >= 0){
                        /*
                        * o novo estado filho tem uma funcao melhor (menor) que o estado
                        * pertencente a lista de fechados
                        *
                        * */
                        if(close_states.get(position).evaluation_cost(s)){
                            close_states.remove(position);
                            open_states.add(s);
                        }
                    }else{
                        /*
                        * Se o stado filho s não foi expandido antes
                        * */
                        open_states.add(s);
                    }

                }
            }
            close_states.add(state_currently);
            quick_sort(open_states);
        }
    }

    /*
    * Se o estado pertencer a lista retorna a posição da lista no estado, senão retorna -1
    * */
    private int contain(ArrayList<State> list, State state){

        int position = -1;

        return position;
    }

    private void quick_sort(ArrayList<State> list){


    }



}
