import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public enum PieceType {
    TYPE1(4, 1),
    TYPE2(2, 3),
    TYPE3(2, 3),
    TYPE4(2, 3),
    TYPE5(2, 2);

    private final int pieceWidth;
    private final int pieceHeight;

    private static final List<PieceType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    PieceType(int pieceWidth, int pieceHeight) {
        this.pieceWidth = pieceWidth;
        this.pieceHeight = pieceHeight;
    }

    public static PieceType randomPieceType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public int getPieceWidth() {
        return pieceWidth;
    }

    public int getPieceHeight() {
        return pieceHeight;
    }
}
