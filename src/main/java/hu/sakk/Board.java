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
        board[0][0] = new Rook(true, true, 0, 0);
        board[0][1] = new Knight(true, true, 0, 1);
        board[0][2] = new Bishop(true, true, 0, 2);
        board[0][3] = new King(true, true, 0, 3);
        board[0][4] = new Queen(true, true, 0, 4);
        board[0][5] = new Bishop(true, true, 0, 5);
        board[0][6] = new Knight(true, true, 0, 6);
        board[0][7] = new Rook(true, true, 0, 7);

        for(int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(true, true, 1, i);
        }

        //fekete bábúk
        board[7][0] = new Rook(false, true, 7, 0);
        board[7][1] = new Knight(false, true, 7, 1);
        board[7][2] = new Bishop(false, true, 7, 2);
        board[7][3] = new King(false, true, 7, 3);
        board[7][4] = new Queen(false, true, 7, 4);
        board[7][5] = new Bishop(false, true, 7, 5);
        board[7][6] = new Knight(false, true, 7, 6);
        board[7][7] = new Rook(false, true, 7, 7);

        for(int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(false, true, 6, i);
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

    public boolean isEnemy(Piece piece, int row, int col) {
        if(board[row][col] != null && getPiece(row, col).isColor() != piece.isColor()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightPosition(int newRow, int newCol) {
        if(newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
            return true;
        } else {
            return false;
        }
    }

    public void movePiece(Piece piece, int newRow, int newCol) {
        if(piece != null && isRightPosition(newRow, newCol)) {
            board[piece.getRow()][piece.getCol()] = null;
            board[newRow][newCol] = piece;
            piece.setRow(newRow);
            piece.setCol(newCol);
        }
    }

    public boolean isFreeStraightWay(Piece piece, int newRow, int newCol) {
        //függőleges út
        if(newCol == piece.getCol()) {
            int step;

            if(newRow > piece.getRow()) {
                step = 1;
            } else {
                step = -1;
            }

            for(int i = piece.getRow() + step; i != newRow; i += step) {
                if(board[i][piece.getCol()] != null) {
                    return false;
                }
            }

            return true;
        }

        //vízszintes út
        if(piece.getRow() == newRow) {
            int step;

            if(newCol > piece.getCol()) {
                step = 1;
            } else {
                step = -1;
            }

            for(int i = piece.getCol() + step; i != newCol; i += step) {
                if(board[piece.getRow()][i] != null) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public boolean isFreeDiagonalWay(Piece piece, int newRow, int newCol) {
        if(Math.abs(newRow - piece.getRow()) != Math.abs(newCol - piece.getCol())) {
            return false;
        }

        int rowStep;
        int colStep;

        if(newRow > piece.getRow()) {
            rowStep = 1;
        } else {
            rowStep = -1;
        }

        if(newCol > piece.getCol()) {
            colStep = 1;
        } else {
            colStep = -1;
        }
            
        int row = piece.getRow() + rowStep;
        int col = piece.getCol() + colStep;

        while (row != newRow && col != newCol) {
            if(board[row][col] != null) {
                return false;
            }

            row += rowStep;
            col += colStep;
        }

        return true;
    }



}
