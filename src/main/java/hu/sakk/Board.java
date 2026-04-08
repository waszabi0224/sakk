package hu.sakk;

//tábla 8x8
public class Board {

    Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        createTable();
    }

    public void createTable() {
        //fehér bábúk
        board[0][0] = new Rook(false, true, 0, 0);
        board[0][1] = new Knight(false, true, 0, 1);
        board[0][2] = new Bishop(false, true, 0, 2);
        board[0][3] = new King(false, true, 0, 3);
        board[0][4] = new Queen(false, true, 0, 4);
        board[0][5] = new Bishop(false, true, 0, 5);
        board[0][6] = new Knight(false, true, 0, 6);
        board[0][7] = new Rook(false, true, 0, 7);

        for(int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(false, true, 1, i);
        }

        //fekete bábúk
        board[7][0] = new Rook(true, true, 7, 0);
        board[7][1] = new Knight(true, true, 7, 1);
        board[7][2] = new Bishop(true, true, 7, 2);
        board[7][3] = new King(true, true, 7, 3);
        board[7][4] = new Queen(true, true, 7, 4);
        board[7][5] = new Bishop(true, true, 7, 5);
        board[7][6] = new Knight(true, true, 7, 6);
        board[7][7] = new Rook(true, true, 7, 7);

        for(int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(true, true, 6, i);
        }
    }

    public Piece[][] getBoard() {
        return board;
    }
    
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(Piece piece, int row, int col) {
        board[row][col] = piece;
    }

    public boolean isEmpty(int row, int col) {
        if(board[row][col] == null) {
            return true;
        } else {
            return false;
        }
    }

    public void movePiece(Piece piece, int newRow, int newCol) {
        if(piece != null && newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
            board[piece.getRow()][piece.getCol()] = null;
            board[newRow][newCol] = piece;
            piece.setRow(newRow);
            piece.setCol(newCol);
        }
    }



}
