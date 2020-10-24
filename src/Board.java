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
    public String secondPlayerMessage(){
        return "White player turn";
    }
    public int rightSearch(int k,int m,String player){
        int count=0;
        if(player=="First"){
            for(int i=k+1;i<9;i++){
                if(board[i][m]=="W"){
                    count++;
                }
                if(board[i][m]=="B"){
                    break;
                }

                if(board[i][m]=="-"){
                    count=0;
                    break;

                }


            }
            if(count!=0){
                for(int i=k;i<k+count+1;i++){
                    board[m][i]="B";
                }
            }

           this.print();





        }
        return count;

    }
    public void play()
    {
        String fPart="";
        String sPart="";
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
                    sPart=secondPart;
                    fPart=firstPart;
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
                boolean topRightCorner=false;
                boolean topLeftCorner=false;
                boolean bottomRightCorner=false;
                boolean bottomLeftCorner=false;
                boolean leftBorder=false;
                boolean rightBorder=false;
                boolean topBorder=false;
                boolean bottomBorder=false;
                int i=-1;
                int j=Integer.parseInt(sPart);
                switch (fPart)
                {
                    case"A":
                    i=1;
                    break;
                    case"B":
                        i=2;
                        break;
                    case"C":
                        i=3;
                        break;
                    case"D":
                        i=4;
                        break;
                    case"E":
                        i=5;
                        break;
                    case"F":
                        i=6;
                        break;
                    case"G":
                        i=7;
                        break;
                    case"H":
                        i=8;
                        break;
                }
                System.out.printf(i+" "+j);
                System.out.println();

                this.rightSearch(i,j,"First");
                invalidMove=false;







            }



        }while (invalidInput||invalidMove);






    }


    public static void main(String args[]){
        Board a=new Board();
        a.print();
        a.play();
    }

}

