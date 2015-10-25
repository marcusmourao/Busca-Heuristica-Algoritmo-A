package Problem;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Marcus on 22/10/2015.
 */
public class Puzzle {
    
    public final float cost = 1.0f;
    public final int row = 3;
    public final  int col = 3;
    
    private int puzzle[][];
    private Position blanck_position;
    private float cost_currently;
    private float f_evaluation; /* valor da funcao de avaliação*/

    public Puzzle(float c){

        this.cost_currently = c;
        this.puzzle = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                this.puzzle[i][j] = 0;
            }

        }
        this.blanck_position = new Position();
    }

    public Puzzle(Puzzle other_puzze){
        this.puzzle = other_puzze.getPuzzle();

        this.blanck_position = new Position();
        this.blanck_position.setX(other_puzze.getBlanck_position().getX());
        this.blanck_position.setY(other_puzze.getBlanck_position().getY());

        this.cost_currently  = other_puzze.getCost_currently();
        this.f_evaluation = other_puzze.getF_evaluation();
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(int[][] puzzle) {

        this.puzzle = puzzle;

        this.blanck_position.setX(findBlanck_position().getX());
        this.blanck_position.setY(findBlanck_position().getY());

        this.f_evaluation = this.cost_currently+getHeuristic();


    }

    public Position getBlanck_position() {
        return blanck_position;
    }

    public void create_solution() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.puzzle[i][j] = i * 3 + j + 1;
            }
        }
        this.puzzle[2][2]= -1;

        this.blanck_position.setX(findBlanck_position().getX());
        this.blanck_position.setY(findBlanck_position().getY());

    }

    public void create_random_problem(){
        Random r = new Random();
        create_solution();

        for (int i=0;i<50;i++){
            switch (((r.nextInt() % 4)+1)){
                case 1:
                    move_down();
                    break;
                case 2:
                    move_top();
                    break;
                case 3:
                    move_left();
                    break;
                case 4:
                    move_right();
            }
        }
        this.f_evaluation = this.cost + getHeuristic();
    }

    public void show_puzzle(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(this.puzzle[i][j]==-1)
                    System.out.print(" " + " ");
                else
                    System.out.print(this.puzzle[i][j] + " ");

            }
            System.out.println();
        }
    }

    public Position findBlanck_position(){
        Position blanck = new Position();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(this.puzzle[i][j]==-1){
                    blanck.setX(i);
                    blanck.setY(j);
                }
            }
        }
        return blanck;
    }

    /*
    * Gera a função heuristica do estado corrente
    *
    * */
    public int getHeuristic(){

        Puzzle solution = new Puzzle(this.cost); /*custo 1*/
        int different_positions =0;

        solution.create_solution();
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(solution.puzzle[i][j]!=this.puzzle[i][j])
                    different_positions++;
            }

        }
        return different_positions;
    }

    public float getCost_currently(){
        return cost_currently;
    }

    public void setCost_currently(float c){
        this.cost_currently = c;
    }

    public float getCost() {
        return cost;
    }

    /*
    * retorna o custo estimado de chegar a o estado corrente
    *  f(x) = c(x) + h(x)
    *
    * */
    public float getF_evaluation(){
        return this.f_evaluation;
    }

    public void change(Position a,Position b){
        int aux  = this.puzzle[a.getX()][a.getY()];
        this.puzzle[a.getX()][a.getY()] = this.puzzle[b.getX()][b.getY()];
        this.puzzle[b.getX()][b.getY()] = aux;
    }

    public boolean move_left(){
        if(blanck_position.getY()==0)
            return false;
        else
        {
            Position change_position = new Position();
            change_position.setX(blanck_position.getX());
            change_position.setY(blanck_position.getY()-1);
            change(blanck_position, change_position);
            blanck_position.setY(change_position.getY());

            /*calcula o novo custo corrente*/
            this.f_evaluation = this.cost_currently+this.cost+getHeuristic();
                    
            return true;
        }

    }

    public boolean move_right(){
        if(blanck_position.getY()==2)
            return false;
        else
        {
            Position change_position = new Position();
            change_position.setX(blanck_position.getX());
            change_position.setY(blanck_position.getY()+1);
            change(blanck_position,change_position);
            blanck_position.setY(change_position.getY());

            /*calcula o novo custo corrente*/
            this.f_evaluation = this.cost_currently+this.cost+getHeuristic();

            return true;
        }

    }

    public boolean move_down(){
        if(this.blanck_position.getX()==2) {
            return false;
        }else{
            Position change_position = new Position();
            change_position.setX(blanck_position.getX()+1);
            change_position.setY(blanck_position.getY());
            change(blanck_position,change_position);
            blanck_position.setX(change_position.getX());

            /*calcula o novo custo corrente*/
            this.f_evaluation = this.cost_currently+this.cost+getHeuristic();

            return true;
        }

    }

    public boolean move_top(){
        if(blanck_position.getX()==0)
            return false;
        else
        {
            Position change_position = new Position();
            change_position.setX(blanck_position.getX()-1);
            change_position.setY(blanck_position.getY());
            change(blanck_position,change_position);
            blanck_position.setX(change_position.getX());

            /*calcula o novo custo corrente*/
            this.f_evaluation = this.cost_currently+this.cost+getHeuristic();

            return true;
        }

    }

    public Puzzle clone() {
        Puzzle new_puzzle = new Puzzle(this.cost_currently);
        for(int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                new_puzzle.puzzle[i][j] = this.puzzle[i][j];
            }
        }

        new_puzzle.blanck_position.setX(this.getBlanck_position().getX());
        new_puzzle.blanck_position.setY(this.getBlanck_position().getY());

        new_puzzle.setCost_currently(this.cost_currently);
        new_puzzle.setF_evaluation(this.f_evaluation);

        return new_puzzle;

    }


    public boolean equals_puzze(Puzzle puzzle){

        int matriz[][] = puzzle.getPuzzle();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(this.puzzle[i][j] != matriz[i][j]){
                    return  false;
                }
            }
        }
        return true;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setBlanck_position(Position blanck_position) {

        this.blanck_position.setX(blanck_position.getX());
        this.blanck_position.setY(blanck_position.getY());
    }

    public void setF_evaluation(float f_evaluation) {
        this.f_evaluation = f_evaluation;
    }
}

