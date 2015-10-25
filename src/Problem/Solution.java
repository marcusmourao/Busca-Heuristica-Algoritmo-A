package Problem;

import Logic.A;

/**
 * Created by lucas on 24/10/15.
 */
public class Solution {

    private Puzzle init_puzzle;
    private Puzzle solution;
    private float cost = 1.0f;

    public Solution(){
        init_problem();
        this.solution =  new Puzzle(cost);
        this.solution.create_solution();
    }

    public Solution(Puzzle init){
        this.init_puzzle = new Puzzle(init.cost);
        this.init_puzzle.setPuzzle(init.getPuzzle());
        this.solution =  new Puzzle(cost);
        this.solution.create_solution();
    }

    private void init_problem(){
       this.init_puzzle = new Puzzle(cost);
       this.init_puzzle.create_random_problem();
    }

    public void generate_solution(){
        A algorithm = new A(new State(init_puzzle), new State(solution));

        State result = algorithm.resolve();

        result.getCurrent_puzzle().show_puzzle();
    }

    public Puzzle getInit_puzzle() {
        return init_puzzle;
    }

    public void showInit_puzzle() {
        init_puzzle.show_puzzle();
        System.out.println(" ");
    }

    public void setInit_puzzle(Puzzle init_puzzle) {

        this.init_puzzle = init_puzzle;
    }

    public Puzzle getSolution() {
        return solution;
    }

    public void showSolution() {
        this.solution.show_puzzle();
        System.out.println(" ");
    }

    public void setSolution(Puzzle solution) {
        this.solution = solution;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
