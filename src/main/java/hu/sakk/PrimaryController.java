package hu.sakk;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PrimaryController {

    @FXML
    private GridPane boardGrid;

    @FXML
    private Label statusLabel;

    private Game game;

    private Button[][] board;

    private Piece[][] pieces;

    private int selectedRow;
    private int selectedCol;

    @FXML
    private void initialize() {
        game = new Game();
        createBoard();
        drawPieces();
        statusLabel.setText("Fehér következik");
    }

    private void createBoard() {
        board = new Button[8][8];

        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                Button button = new Button();
                button.setPrefSize(90, 90);
                button.setAlignment(Pos.CENTER);

                if((row + col) % 2 == 0) {
                    button.setStyle("-fx-background-color: beige; -fx-font-size: 38;");
                } else {
                    button.setStyle("-fx-background-color: gray; -fx-font-size: 38;");
                }

                final int selectedRow = row;
                final int selectedCol = col;

                button.setOnAction(e -> handleClick(selectedRow, selectedCol));

                board[row][col] = button;
                boardGrid.add(button, col, row);
            }
        }
    }

    private void drawPieces() {
        pieces = game.getBoard().getBoard();

        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                Piece piece = pieces[row][col];

                if(piece == null) {
                    board[row][col].setText("");
                } else {
                    board[row][col].setText(getPieceSymbol(piece));
                }
            }
        }
    }

    private String getPieceSymbol(Piece piece) {
        if (piece instanceof King) {
        return piece.isColor() ? "♔" : "♚";
        }
        if (piece instanceof Queen) {
            return piece.isColor() ? "♕" : "♛";
        }
        if (piece instanceof Rook) {
            return piece.isColor() ? "♖" : "♜";
        }
        if (piece instanceof Bishop) {
            return piece.isColor() ? "♗" : "♝";
        }
        if (piece instanceof Knight) {
            return piece.isColor() ? "♘" : "♞";
        }
        if (piece instanceof Pawn) {
            return piece.isColor() ? "♙" : "♟";
        }

        return "";
    }

    private void handleClick(int row, int col) {
        Piece selectedPiece = game.getBoard().getPiece(row, col);

        if(game.getSelectedPiece() == null) {
            if(selectedPiece != null && selectedPiece.isColor() == game.isTurn()) {
                game.setSelectedPiece(selectedPiece);
                selectedRow = row;
                selectedCol = col;
                statusLabel.setText("Bábu kiválasztva");
                refreshSelection();
            }

            return;
        }

        if(selectedPiece != null && selectedPiece.isColor() == game.isTurn()) {
            game.setSelectedPiece(selectedPiece);
            selectedRow = row;
            selectedCol = col;
            statusLabel.setText("Másik bábu kiválasztva");
            refreshSelection();
            return;
        }

        boolean moved = game.moveSelectedPiece(game.getSelectedPiece(), row, col);

        if(moved) {
            game.setSelectedPiece(null);
            selectedRow = -1;
            selectedCol = -1;
            drawPieces();
            refreshSelection();
            statusLabel.setText(game.isTurn() ? "Fehér következik" : "Fekete következik");
        } else {
            statusLabel.setText("Szabálytalan lépés");
        }
    }

    private void refreshSelection() {
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                if(row == selectedRow && col == selectedCol) {
                    board[row][col].setStyle("-fx-background-color: lightgreen; -fx-font-size: 38;");
                } else {
                    if((row + col) % 2 == 0) {
                        board[row][col].setStyle("-fx-background-color: beige; -fx-font-size: 38;");
                    } else {
                        board[row][col].setStyle("-fx-background-color: gray; -fx-font-size: 38;");
                    }
                }
            }
        }
    }

}
