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

}
