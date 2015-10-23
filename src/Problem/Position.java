package Problem;

/**
 * Created by Marcus on 22/10/2015.
 */
public class Position {
    int x;
    int y;

    public Position(){
        this.x=0;
        this.y=0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
