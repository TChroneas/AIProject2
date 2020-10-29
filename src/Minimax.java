import java.util.ArrayList;

public class Minimax {


    String player;
    Board board;

    public Minimax(Board board,String player) {
        this.board = board;
        this.player=player;

    }


    public Board miniiimax(int depth,boolean maxim,Board board) throws CloneNotSupportedException {
        ArrayList<String> moves;
        ArrayList<Board> boards = new ArrayList<>();


        if (maxim) {
            Move a = new Move(board.board, "First");
            a.generateMoves();
            moves = a.moves;
            for (String move : moves) {

                Board test=new Board(board);
                test.aiTest(move, "First");
                boards.add(test);
            }
        }else{
            Move a=new Move(board.board,"Second");
            a.generateMoves();
            moves=a.moves;
            for(String move:moves){
                Board test=new Board(board);
                test.aiTest(move,"Second");
                boards.add(test);
            }


        }
        if(depth==0||boards.isEmpty()){
            return board;
        }




        if(maxim){
            Board maxBoard=boards.get(0);
            for (Board child:boards){
                Board max=miniiimax(depth-1,false,child);
                if(max.evaluate("First")>maxBoard.evaluate("First")){
                    maxBoard=child;
                }
            }
             return maxBoard;
        }else{
            Board minBoard=boards.get(0);
            for (Board child:boards){
                Board min=miniiimax(depth-1,true,child);
                if(min.evaluate("Second")<minBoard.evaluate("Second")){
                    minBoard=child;
                }
            }
            return minBoard;


        }


    }





}
