import Problem.Puzzle;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Busca Heuristica");

       // JOptionPane.showMessageDialog(null, "teste");

        Puzzle teste = new Puzzle();
        teste.create_solution();
        teste.show_puzzle();
        System.out.println();
        teste.move_left();
        teste.show_puzzle();
        System.out.println();
        teste.move_left();
        teste.show_puzzle();
        System.out.println();
        teste.move_top();
        teste.show_puzzle();
        System.out.println();
        teste.move_top();
        teste.show_puzzle();
        System.out.println("Outro puzzle");

        Puzzle outro = new Puzzle(teste.clone());
        outro.show_puzzle();



    }
}