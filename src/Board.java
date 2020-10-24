import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Board {
    public String[][] board = new String[9][9];
    public void print()
    {
        for(int i=0;i<9;i++)
        {
         for(int j=0;j<9;j++){
             System.out.print(board[i][j]);
             System.out.print(" ");
         }
            System.out.println(" ");
        }


    }

    public Board() {
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                board[i][0] = "#";
            } else {

                board[i][0] = String.valueOf(i);
            }

        }
        for (int j = 1; j < 9; j++)
        {
            switch (j){
                case 1:
                    board[0][j]="A";
                    break;
                case 2:
                    board[0][j]="B";
                    break;
                case 3:
                    board[0][j]="C";
                    break;
                case 4:
                    board[0][j]="D";
                    break;
                case 5:
                    board[0][j]="E";
                    break;
                case 6:
                    board[0][j]="F";
                    break;
                case 7:
                    board[0][j]="G";
                    break;
                case 8:
                    board[0][j]="H";
                    break;
            }
        }
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                board[i][j]="-";

            }
        }
        board[4][4]="B";
        board[4][5]="W";
        board[5][4]="w";
        board[5][5]="B";

    }
    public String firstPlayerMessage(){
        return "Black player turn";
    }
    public String SecondPlayerMessage(){
        return "White player turn";
    }
    public void play()
    {
        boolean invalidInput=true;
        boolean invalidMove=true;
        do{
            System.out.println("Enter the tile you want to play");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.print();

            Scanner input = new Scanner(System.in);
            String move=input.nextLine();

            if (move.length()!=2){
                invalidInput=true;
                System.out.println("Invalid input");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {


                String firstPart = String.valueOf(move.charAt(0));
                String secondPart = String.valueOf(move.charAt(1));
                boolean fTest = false;
                boolean sTest = false;
                switch (firstPart) {
                    case "A":
                        fTest = true;
                        break;
                    case "B":
                        fTest = true;
                        break;
                    case "C":
                        fTest = true;
                        break;
                    case "D":
                        fTest = true;
                        break;
                    case "E":
                        fTest = true;
                        break;
                    case "F":
                        fTest = true;
                        break;
                    case "G":
                        fTest = true;
                        break;
                    case "H":
                        fTest = true;
                        break;
                }
                switch (secondPart) {
                    case "1":
                        sTest = true;
                        break;
                    case "2":
                        sTest = true;
                        break;
                    case "3":
                        sTest = true;
                        break;
                    case "4":
                        sTest = true;
                        break;
                    case "5":
                        sTest = true;
                        break;
                    case "6":
                        sTest = true;
                        break;
                    case "7":
                        sTest = true;
                        break;
                    case "8":
                        sTest = true;
                        break;
                }
                if (fTest && sTest) {
                    invalidInput = false;
                    System.out.println("Valid input");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    invalidInput = true;
                    System.out.println("Invalid input");
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


            if(!invalidInput)
            {


            }



        }while (invalidInput||invalidMove);






    }





    public static void main(String args[]){
        Board a=new Board();
        a.print();
        a.play();
    }

}

