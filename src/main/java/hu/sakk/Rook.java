package hu.sakk;

//bástya
public class Rook extends Piece {

     private boolean hasMoved;

    public Rook(boolean color, boolean hasMoved, int row, int col) {
        super(color, row, col);
        this.hasMoved = false;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean isRightStepRook(Board board, Piece piece, int newRow, int newCol) {
        if(board.isRightPosition(newRow, newCol)) {
            if(Math.abs(piece.getRow() - newRow) > 0 && piece.getCol() - newCol == 0) {
                if(board.isFreeStraightWay(piece, newRow, newCol) && (board.isEmpty(newRow, newCol) || board.isEnemy(piece, newRow, newCol))) {
                    return true;
                }
            }

            if(piece.getRow() - newRow == 0 && Math.abs(piece.getCol() - newCol) > 0) {
                if(board.isFreeStraightWay(piece, newRow, newCol) && (board.isEmpty(newRow, newCol) || board.isEnemy(piece, newRow, newCol))) {
                    return true;
                }
            }
        }

        return false;
    }

}
