package hu.sakk;

//játéklogikája, körváltás, lépéskezelés
public class Game {

    Board board;
    boolean turn;
    Piece selectedPiece;

    public Game() {
        startGame();
    }

    public void startGame() {
        board = new Board();
        turn = true;
        selectedPiece = null;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isTurn() {
        return turn;
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public boolean validMove(Piece selectedPiece, int newRow, int newCol) {
        if(selectedPiece.isColor() == turn && selectedPiece != null) {
            if(selectedPiece instanceof Knight) {
            return ((Knight)selectedPiece).isRightStepKnight(board, selectedPiece, newRow, newCol);
            }

            if(selectedPiece instanceof Rook) {
                return ((Rook)selectedPiece).isRightStepRook(board, selectedPiece, newRow, newCol);
            }

            if(selectedPiece instanceof Bishop) {
                return ((Bishop)selectedPiece).isRightStepBishop(board, selectedPiece, newRow, newCol);
            }

            if(selectedPiece instanceof Queen) {
                return ((Queen)selectedPiece).isRightStepQueen(board, selectedPiece, newRow, newCol);
            }

            if(selectedPiece instanceof King) {
                return ((King)selectedPiece).isRightStepKing(board, selectedPiece, newRow, newCol);
            }

            if(selectedPiece instanceof Pawn) {
                return ((Pawn)selectedPiece).isRightStepPawn(board, selectedPiece, newRow, newCol);
            }

            return false;
        }
        return false;
    }

    public boolean moveSelectedPiece(Piece selectedPiece, int newRow, int newCol) {
        if(validMove(selectedPiece, newRow, newCol)) {
            board.movePiece(selectedPiece, newRow, newCol);
            turn = !turn;
            return true;
        }
        return false;
    }

}
