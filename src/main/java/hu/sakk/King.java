package hu.sakk;

//király
public class King extends Piece {

    private boolean hasMoved;

    public King(boolean color, boolean hasMoved, int row, int col) {
        super(color, row, col);
        this.hasMoved = false;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean isRightStepKing(Board board, Piece piece, int newRow, int newCol) {
        if(board.isRightPosition(newRow, newCol)) {
            if(Math.abs(piece.getRow() - newRow) <= 1 && Math.abs(piece.getCol() - newCol) <= 1) {
                if(board.isEmpty(newRow, newCol) || board.isEnemy(piece, newRow, newCol)) {
                    return true;
                }
            }
        }

        return false;
    }
}
