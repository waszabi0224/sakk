package hu.sakk;

//közös bábú-tulajdonságok
public abstract class Piece {
    
    //true = white
    //false = dark
    public boolean color;
    public boolean alive;
    public int row;
    public int col;

    public Piece(boolean color, boolean alive, int row, int col) {
        this.color = color;
        this.alive = alive;
        this.row = row;
        this.col = col;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public boolean isColor() {
        return color;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

}
