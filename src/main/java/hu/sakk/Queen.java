package hu.sakk;

//királynő
public class Queen extends Piece {

    public Queen(boolean color, int row, int col) {
        super(color, row, col);
    }

    public boolean isRightStepQueen(Board board, Piece piece, int newRow, int newCol) {
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

            if(Math.abs(piece.getRow() - newRow) == Math.abs(piece.getCol() - newCol)) {
                if(board.isFreeDiagonalWay(piece, newRow, newCol) && (board.isEmpty(newRow, newCol) || board.isEnemy(piece, newRow, newCol))) {
                    return true;
                }
            }
        }

        return false;
    }
}
