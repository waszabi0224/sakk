package hu.sakk;

//huszár
public class Knight extends Piece {

    public Knight(boolean color, int row, int col) {
        super(color, row, col);
    }

    public boolean isRightStepKnight(Board board, Piece piece, int newRow, int newCol) {

        if(board.isRightPosition(newRow, newCol)) {

            if(Math.abs(piece.getRow() - newRow) == 2 && Math.abs(piece.getCol() - newCol) == 1) {
                if(board.isEmpty(newRow, newCol) || board.isEnemy(piece, newRow, newCol)) {
                    return true;
                }
            }

            if(Math.abs(piece.getRow() - newRow) == 1 && Math.abs(piece.getCol() - newCol) == 2) {
                if(board.isEmpty(newRow, newCol) || board.isEnemy(piece, newRow, newCol)) {
                    return true;
                }
            }
        }

        return false;
    }
}
