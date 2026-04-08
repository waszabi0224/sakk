package hu.sakk;

//király
public class King extends Piece {

    public King(boolean color, boolean alive, int row, int col) {
        super(color, alive, row, col);
    }

    Board board = new Board();

    public boolean isRightStepKing(Piece piece, int newRow, int newCol) {
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
