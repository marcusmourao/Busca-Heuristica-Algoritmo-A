package Problem;

import java.util.ArrayList;

/**
 * Created by lucas on 22/10/15.
 */

/*
 * Esta classe representa as funcos aplicadas a cada passo do algoritmo
 *  */
public class Function {

    /*Funções referentes a o problema no quebra cabeça*/

    public float f_cost_puzze(State state){
        return  state.getCost()+ 1.0f;
    }

    /*
     * Numero de peças fora do lugar
     *
     * */
    public float f_heuristic_puzze(State state){

        int count = 0;
        for (int i = 0; i < state.getState_descrip().size(); i++) {
            if(state.getState_descrip().get(i) != i+1){
                count++;
            }
        }
        return  1.0f;
    }
}
