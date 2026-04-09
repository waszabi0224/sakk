package hu.sakk;

//futó
public class Bishop extends Piece {

    public Bishop(boolean color, boolean alive, int row, int col) {
        super(color, alive, row, col);
    }

    public boolean isRightStepBishop(Board board, Piece piece, int newRow, int newCol) {
        if(board.isRightPosition(newRow, newCol)) {
            if(Math.abs(piece.getRow() - newRow) == Math.abs(piece.getCol() - newCol)) {
                if(board.isFreeDiagonalWay(piece, newRow, newCol) && (board.isEmpty(newRow, newCol) || board.isEnemy(piece, newRow, newCol))) {
                    return true;
                }
            }
        }

        return false;
    }

}
