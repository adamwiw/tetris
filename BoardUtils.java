public class BoardUtils {
    private static char SPACE = ' ';
    private static char CHARACTER = '*';
    private static char FRAME_CHAR = '*';
    private static char BTM_FRAME_CHAR = '*';

    public static boolean[][] assembleBoard(boolean[][] board, int width, int height, Piece piece, int pieceX, int pieceY) {
        boolean pieceMatrix[][] = piece.getPieceMatrix();
        boolean tmpBoard[][] = new boolean[height][width];
        
        for(int i = 0; i < board.length; i++)
	    tmpBoard[i] = board[i].clone();
        
        for(int x = 0; x < piece.getPieceWidth(); x++) {
            for(int y = 0; y < piece.getPieceHeight(); y++) {
                tmpBoard[pieceY + y][pieceX + x] = tmpBoard[pieceY + y][pieceX + x] || pieceMatrix[y][x];
            }
        }
        return tmpBoard;
    }
    
    public static void printBoard(boolean[][] board) {
        StringBuilder sb = new StringBuilder();
        for(boolean line[]: board) {
            sb.append(FRAME_CHAR);
            for(boolean ch: line) {
                sb.append(ch?CHARACTER:SPACE);
            }
            sb.append(FRAME_CHAR);
            System.out.println(sb);
            sb = new StringBuilder();
        }
        for(int n = 0; n < board[0].length + 2; n++) {
            sb.append(BTM_FRAME_CHAR);
        }
        System.out.println(sb);
    }
}
