package Problem;

/**
 * Created by Marcus on 22/10/2015.
 */
public class Puzzle {
    private int puzzle[][];
    private Position blanck_position;


    public Puzzle(){
        this.puzzle = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                //this.puzzle[i][j] = i*3+j+1;
                this.puzzle[i][j] = 0;
            }

        }

        this.blanck_position = new Position();
    }

    public Puzzle(Puzzle other_puzze){
        this.puzzle = other_puzze.puzzle;
        this.blanck_position = other_puzze.getBlanck_position();
    }

    public void setPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public Position getBlanck_position() {
        return blanck_position;
    }

    public void create_solution() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.puzzle[i][j] = i * 3 + j + 1;
            }
        }
        this.puzzle[2][2]= -1;

        this.blanck_position = findBlanck_position();
    }

    public void show_puzzle(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
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
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(this.puzzle[i][j]==-1){
                    blanck.setX(j);
                    blanck.setY(i);
                }
            }
        }
        return blanck;
    }

    public int getHeuristica(){
        Puzzle solution = new Puzzle();
        int different_positions =0;

        solution.create_solution();
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(solution.puzzle[i][j]!=this.puzzle[i][j])
                    different_positions++;
            }

        }
        return different_positions;
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
            return true;
        }

    }

    public boolean move_down(){
        if(blanck_position.getX()==2)
            return false;
        else
        {
            Position change_position = new Position();
            change_position.setX(blanck_position.getX()+1);
            change_position.setY(blanck_position.getY());
            change(blanck_position,change_position);
            blanck_position.setX(change_position.getX());
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
            return true;
        }

    }

    public Puzzle clone() {
        Puzzle new_puzzle = new Puzzle();
        for(int i=0;i<3;i++){
            for(int j=0; j<3; j++){
                new_puzzle.puzzle[i][j] = this.puzzle[i][j];
            }
        }

        new_puzzle.blanck_position = this.getBlanck_position();

        return new_puzzle;

    }

}

