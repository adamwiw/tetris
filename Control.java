public class Control {
    public static boolean canMovePieceLeft(boolean[][] board, Piece piece, int pieceX, int pieceY){
        boolean pieceMatrix[][] = piece.getPieceMatrix();

        if(pieceX > 0) {
            for(int x = 0; x < piece.getPieceWidth(); x++) {
                for(int y = 0; y < piece.getPieceHeight(); y++) {
                    if(board[pieceY + y][pieceX + x - 1] && pieceMatrix[y][x]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
            
    public static boolean canMovePieceRight(boolean[][] board, Piece piece, int pieceX, int pieceY){
        boolean pieceMatrix[][] = piece.getPieceMatrix();

        if(pieceX + piece.getPieceWidth() < board[0].length) {
            for(int x = 0; x < piece.getPieceWidth(); x++) {
                for(int y = 0; y < piece.getPieceHeight(); y++) {
                    if(board[pieceY + y][pieceX + x + 1] && pieceMatrix[y][x]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
            
    public static boolean canRotatePiece(boolean[][] board, Piece piece, int pieceX, int pieceY) throws CloneNotSupportedException {
        Piece rotatedPiece = piece.pieceRotatedClockwise();
        boolean pieceMatrix[][] = rotatedPiece.getPieceMatrix();

        if(pieceX >= 0 && pieceX + rotatedPiece.getPieceWidth() < board[0].length + 1) {
            for(int x = 0; x < rotatedPiece.getPieceWidth(); x++) {
                for(int y = 0; y < rotatedPiece.getPieceHeight(); y++) {
                    if(board[pieceY + y][pieceX + x] && pieceMatrix[y][x]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
            
    public static boolean canMovePieceDown(boolean[][] board, Piece piece, int pieceX, int pieceY) {
        boolean pieceMatrix[][] = piece.getPieceMatrix();

        if(pieceY + piece.getPieceHeight() < board.length) {
            for(int x = 0; x < piece.getPieceWidth(); x++) {
                for(int y = 0; y < piece.getPieceHeight(); y++) {
                    if(board[pieceY + y + 1][pieceX + x] && pieceMatrix[y][x]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
