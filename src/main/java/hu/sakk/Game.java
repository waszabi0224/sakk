package hu.sakk;

import java.util.ArrayList;
import java.util.List;

//játéklogikája, körváltás, lépéskezelés
public class Game {

    Board board;
    boolean turn;
    Piece selectedPiece;
    private String message;

    public Game() {
        startGame();
    }

    public void startGame() {
        board = new Board();
        turn = true;
        selectedPiece = null;
        message = "Fehér következik";
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

    public String getMessage() {
        return message;
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
        int formerRow = selectedPiece.getRow();
        int formerCol = selectedPiece.getCol();

        Piece targetPiece = board.getPiece(newRow, newCol);

        if(validMove(selectedPiece, newRow, newCol)) {
            board.movePiece(selectedPiece, newRow, newCol);
            
            if(isSakk(selectedPiece.isColor())) {
                board.setPiece(selectedPiece, formerRow, formerCol);
                board.setPiece(targetPiece, newRow, newCol);
                selectedPiece.setRow(formerRow);
                selectedPiece.setCol(formerCol);
                message = "Nem léphetsz, mert sakkban maradna a király";
                return false;
            } else {
                turn = !turn;

                if(isSakk(turn)) {
                    message = "Sakk! " + (turn ? "Fehér" : "Fekete") + " következik";
                } else {
                    message = turn ? "Fehér következik" : "Fekete következik";
                }
                return true;
            }
        } 

        message = "Szabálytalan lépés";
        return false;
    }

    public boolean isSakk(boolean color) {
        List<Piece> sakkPieces = new ArrayList<>();

        boolean isSakk = false;
        int kingRow = -1;
        int kingCol = -1;

        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);

                if(piece != null && piece.getClass() == King.class && piece.isColor() == color) {
                    kingRow = row;
                    kingCol = col;
                }
            }
        }

        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);

                if(piece != null && piece.isColor() != color) {
                    if(piece instanceof Knight) {
                        if(((Knight) piece).isRightStepKnight(board, piece, kingRow, kingCol)) {
                            return true;
                        }
                    }

                    if(piece instanceof Rook) {
                        if(((Rook) piece).isRightStepRook(board, piece, kingRow, kingCol)) {
                            return true;
                        }
                    }

                    if(piece instanceof Bishop) {
                        if(((Bishop) piece).isRightStepBishop(board, piece, kingRow, kingCol)) {
                            return true;
                        }
                    }

                    if(piece instanceof Queen) {
                        if(((Queen) piece).isRightStepQueen(board, piece, kingRow, kingCol)) {
                            return true;
                        }
                    }

                    if(piece instanceof Pawn) {
                        if(((Pawn) piece).isRightStepPawn(board, piece, kingRow, kingCol)) {
                            return true;
                        }
                    }
                }
            }
        }

        return isSakk;
    }

}
