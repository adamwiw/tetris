public class Piece implements Cloneable {
    private PieceType pieceType;
    private int pieceWidth;
    private int pieceHeight;
    private int pieceRotation;
    
    public Piece() {
        pieceType = PieceType.randomPieceType();
        this.pieceWidth = pieceType.getPieceWidth();
        this.pieceHeight = pieceType.getPieceHeight();
        this.pieceRotation = 0;
    }
    
    public int getPieceWidth() {
        return pieceWidth;
    }
    
    public int getPieceHeight() {
        return pieceHeight;
    }
    
    public void swapDimmensions() {
        int oldWidth = pieceWidth;
        pieceWidth = pieceHeight;
        pieceHeight = oldWidth;
    }
    
    private void rotatePieceClockwise() {
	swapDimmensions();
	if(PieceType.TYPE1 == pieceType  || pieceType.TYPE4 == pieceType)
            pieceRotation = ++pieceRotation % 2;
        if(PieceType.TYPE2 == pieceType  || pieceType.TYPE3 == pieceType)
            pieceRotation = ++pieceRotation % 4;
    }
    
    private void rotatePieceCounterClockwise() {
	swapDimmensions();
	if(PieceType.TYPE1 == pieceType  || pieceType.TYPE4 == pieceType)
            pieceRotation = --pieceRotation % 2;
        if(PieceType.TYPE2 == pieceType  || pieceType.TYPE3 == pieceType)
            pieceRotation = --pieceRotation % 4;
    }
    
    public Piece pieceRotatedClockwise() throws CloneNotSupportedException {
        Piece tmpPiece = (Piece) this.clone();
        tmpPiece.rotatePieceClockwise();
        return tmpPiece;
    }
    
    public Piece pieceRotatedCounterClockwise() throws CloneNotSupportedException {
        Piece tmpPiece = (Piece) this.clone();
        tmpPiece.rotatePieceCounterClockwise();
        return tmpPiece;
    }
    
    public boolean[][] getPieceMatrix() {
        boolean[][] pieceMatrix = new boolean[pieceHeight][pieceWidth];
        
        switch(pieceType) {
            case TYPE1:
                if(0 == pieceRotation)
                    pieceMatrix = new boolean[][] {{true, true, true, true}};
                else
		    pieceMatrix = new boolean[][] {{true}, {true}, {true}, {true}};
                break;
            case TYPE2:
                switch(pieceRotation) {
                    case 0:
                        pieceMatrix = new boolean[][] {{true, false}, {true, false}, {true, true}};
                        break;
                    case 1:
                        pieceMatrix = new boolean[][] {{true, true, true}, {true, false, false}};
                        break;
                    case 2:
                        pieceMatrix = new boolean[][] {{true, true}, {false, true}, {false, true}};
                        break;
                    case 3:
                        pieceMatrix = new boolean[][] {{false, false, true}, {true, true, true}};
                        break;
                }
                break;
            case TYPE3:
                switch(pieceRotation) {
                    case 0:
                        pieceMatrix = new boolean[][] {{false, true}, {false, true}, {true, true}};
                        break;
                    case 1:
                        pieceMatrix = new boolean[][] {{true, false, false}, {true, true, true}};
                        break;
                    case 2:
                        pieceMatrix = new boolean[][] {{true, true}, {true, false}, {true, false}};
                        break;
                    case 3:
                        pieceMatrix = new boolean[][] {{true, true, true}, {false, false, true}};
                        break;
                }
                break;
            case TYPE4:
                if(0 == pieceRotation)
                    pieceMatrix = new boolean[][] {{false, true}, {true, true}, {true, false}};
                else
                    pieceMatrix = new boolean[][] {{true, true, false}, {false, true, true}};
                break;
            case TYPE5:
                pieceMatrix = new boolean[][] {{true, true}, {true, true}};
                break;
        }
        return pieceMatrix;
    }
}
