package hu.sakk;

//bástya
public class Rook extends Piece {

    public Rook(boolean color, boolean alive, int row, int col) {
        super(color, alive, row, col);
    }

    Board board = new Board();

    public boolean isRightStepRook(Piece piece, int newRow, int newCol) {
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
