public class Board {
    private int width;
    private int height;
    private Piece piece;
    private int pieceX;
    private int pieceY;
    boolean[][] board;
    
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        piece = new Piece();
        pieceX = (width / 2) - (piece.getPieceWidth() / 2);
        pieceY = 0;
        board = new boolean[height][width];
    }
    
    public void draw() {
        boolean[][] assembledBoard = BoardUtils.assembleBoard(board, width, height, piece, pieceX, pieceY);
        BoardUtils.printBoard(assembledBoard);
    }
    
    private boolean movePieceDown() {
        if(Control.canMovePieceDown(board, piece, pieceX, pieceY)) {
            pieceY += 1;
        } else {
            if(0 == pieceY)
            return false;
            board = BoardUtils.assembleBoard(board, width, height, piece, pieceX, pieceY);
            piece = new Piece();
            pieceX = (width / 2) - (piece.getPieceWidth() / 2);
            pieceY = 0;
        }
        return true;
    }
    
    public boolean movePieceLeft() {
        if(Control.canMovePieceLeft(board, piece, pieceX, pieceY))
            pieceX -= 1;
        if(!movePieceDown())
            return false;
        draw();
        return true;
    }
    
    public boolean movePieceRight() {
        if(Control.canMovePieceRight(board, piece, pieceX, pieceY))
            pieceX += 1;
        if(!movePieceDown())
            return false;
        draw();
        return true;
    }
    
    public boolean rotatePieceClockwise() throws CloneNotSupportedException {
        if(Control.canRotatePiece(board, piece, pieceX, pieceY))
            piece = piece.pieceRotatedClockwise();
        if(!movePieceDown())
            return false;
        draw();
        return true;
    }
    
    public boolean rotatePieceCounterClockwise() throws CloneNotSupportedException {
        if(Control.canRotatePiece(board, piece, pieceX, pieceY))
            piece = piece.pieceRotatedCounterClockwise();
        if(!movePieceDown())
            return false;
        draw();
        return true;
    }
    
    public boolean advance() {
        if(!movePieceDown())
            return false;
        draw();
        return true;
    }
}
