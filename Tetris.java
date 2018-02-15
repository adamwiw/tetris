/* 
  *    started at 4:22pm
  *    have time until 1:22am
  */
import java.util.Scanner;

public class Tetris {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner s = new Scanner(System.in);
        Board board = new Board(20, 20);
        String input = "";
        
        board.draw();
        
        while(!input.equals("q")) {
            System.out.print("Your move: ");
            input = s.nextLine();
            if(input.equals("a"))
                if(!board.movePieceLeft())
                    break;
            if(input.equals("d"))
                if(!board.movePieceRight())
                    break;
            if(input.equals("w"))
                if(!board.rotatePieceCounterClockwise())
                    break;
            if(input.equals("s"))
                if(!board.rotatePieceClockwise())
                    break;
            if(input.equals(" "))
                if(!board.advance())
                    break;
        }
        
        System.out.println("Game over!");
    }
}
