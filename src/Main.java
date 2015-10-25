import Logic.QuickSort;
import Problem.Puzzle;
import Problem.Solution;
import Problem.State;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("---Busca Heuristica---");

//        Puzzle p =  new Puzzle(1.0f);
//        int m[][] = {{1,2,3},{4,5,-1},{7,8,6}};
//        p.setPuzzle(m);
//        Solution sol = new Solution(p);

        Solution sol = new Solution();
        System.out.println("-- Estado inicial --");
        sol.showInit_puzzle();
        System.out.println("-- Estado objetivo --");
        sol.showSolution();
        System.out.println("-- Estado final gerado pelo algoritmo --");
        sol.generate_solution();

//        teste.create_solution();
//        teste.show_puzzle();
//        System.out.println(teste.getBlanck_position().toString());
//        System.out.println();
//        teste.move_left();
//        teste.show_puzzle();
//        System.out.println(teste.getBlanck_position().toString());
//        System.out.println();
//        teste.move_left();
//        teste.show_puzzle();
//        System.out.println(teste.getBlanck_position().toString());
//        System.out.println();
//        teste.move_top();
//        teste.show_puzzle();
//        System.out.println(teste.getBlanck_position().toString());
//        System.out.println();
//        teste.move_top();
//        System.out.println(teste.getBlanck_position().toString());
//        teste.show_puzzle();
//        System.out.println("Outro puzzle");
//
//        Puzzle outro = new Puzzle(teste.clone());
//        outro.show_puzzle();
//        System.out.println(outro.getBlanck_position().toString());
//        outro.move_right();
//        outro.show_puzzle();
//        System.out.println(outro.getBlanck_position().toString());
//
//        System.out.println(outro.getHeuristic());

    }
}
