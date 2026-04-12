package hu.sakk;

//gyalog
public class Pawn extends Piece {

    public Pawn(boolean color, int row, int col) {
        super(color, row, col);
    }

    public boolean isRightStepPawn(Board board, Piece piece, int newRow, int newCol) {
        if(board.isRightPosition(newRow, newCol)) {
            if(piece.isColor() == true) {
                int goalRowR = piece.getRow() + 1;
                int goalColR = piece.getCol() + 1;
                int goalColL = piece.getCol() - 1;

                if(piece.getRow() == 1) {
                    if(((board.isRightPosition(goalRowR, goalColR) && board.isEnemy(piece, goalRowR, goalColR)) 
                        || (board.isRightPosition(goalRowR, goalColL) && board.isEnemy(piece, goalRowR, goalColL))) 
                        && ((newRow == goalRowR && newCol == goalColR) || (newRow == goalRowR && newCol == goalColL))) {
                        return true;
                    }

                    if(piece.getRow() - newRow >= -2 && piece.getRow() - newRow < 0 && piece.getCol() == newCol) {
                        if(board.isFreeStraightWay(piece, newRow, newCol) && board.isEmpty(newRow, newCol)) {
                            return true;
                        }
                    }
                } else {
                    if(((board.isRightPosition(goalRowR, goalColR) && board.isEnemy(piece, goalRowR, goalColR)) 
                        || (board.isRightPosition(goalRowR, goalColL) && board.isEnemy(piece, goalRowR, goalColL))) 
                        && ((newRow == goalRowR && newCol == goalColR) || (newRow == goalRowR && newCol == goalColL))) {
                        return true;
                    }

                    if(piece.getRow() - newRow == -1 && piece.getCol() == newCol) {
                        if(board.isEmpty(newRow, newCol)) {
                            return true;
                        }
                    }
                }
            } else {
                int goalRowL = piece.getRow() - 1;
                int goalColL = piece.getCol() - 1;
                int goalColR = piece.getCol() + 1;

                if(piece.getRow() == 6) {
                    if(((board.isRightPosition(goalRowL, goalColL) && board.isEnemy(piece, goalRowL, goalColL)) 
                        || (board.isRightPosition(goalRowL, goalColR) && board.isEnemy(piece, goalRowL, goalColR))) 
                        && ((newRow == goalRowL && newCol == goalColL) || (newRow == goalRowL && newCol == goalColR))) {
                        return true;
                    }

                    if(piece.getRow() - newRow <= 2 && piece.getRow() - newRow > 0 && piece.getCol() == newCol) {
                        if(board.isFreeStraightWay(piece, newRow, newCol) && board.isEmpty(newRow, newCol)) {
                            return true;
                        }
                    }
                } else {
                    if(((board.isRightPosition(goalRowL, goalColL) && board.isEnemy(piece, goalRowL, goalColL)) 
                        || (board.isRightPosition(goalRowL, goalColR) && board.isEnemy(piece, goalRowL, goalColR))) 
                        && ((newRow == goalRowL && newCol == goalColL) || (newRow == goalRowL && newCol == goalColR))) {
                        return true;
                    }

                    if(piece.getRow() - newRow == 1 && piece.getCol() == newCol) {
                        if(board.isEmpty(newRow, newCol)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

}
