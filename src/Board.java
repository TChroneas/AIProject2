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
    public Board()
    {
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
        board[5][4]="W";
        board[5][5]="B";
        board[3][3]="B";




    }
    public String firstPlayerMessage()
    {
        return "Black player turn";
    }
    public String secondPlayerMessage()
    {
        return "White player turn";
    }
    public int rightSearch(int k,int m,String player)
    {
        int count=0;
        if(player=="First"){
            if(board[k][m]=="-") {
                for (int i = m + 1; i < 9; i++) {
                    if (board[k][i] == "W") {
                        count++;
                    }
                    if (board[k][i] == "B") {
                        break;
                    }

                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m; i < m + count+1 ; i++) {
                        board[k][i] = "B";
                    }
                }
            }
           this.print();
        }else if(player=="Second"){
            if(board[k][m]=="-") {
                for (int i = m + 1; i < 9; i++) {
                    if (board[k][i] == "B") {
                        count++;
                    }
                    if (board[k][i] == "W") {
                        break;
                    }
                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m; i < m + count+1 ; i++) {
                        board[k][i] = "W";
                    }
                }
            }
            this.print();
        }
        return count;

    }
    public int leftSearch(int k,int m,String player)
    {
        int count=0;
        if(player=="First"){
            if(board[k][m]=="-") {
                for (int i = m - 1; i >0 ; i--) {
                    if (board[k][i] == "W") {
                        count++;
                    }
                    if (board[k][i] == "B") {
                        break;
                    }

                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m; i > m - count-1 ; i--) {
                        board[k][i] = "B";
                    }
                }
            }
            this.print();
        }else if(player=="Second"){
            if(board[k][m]=="-") {
                for (int i = m - 1; i >0; i--) {
                    if (board[k][i] == "B") {
                        count++;
                    }
                    if (board[k][i] == "W") {
                        break;
                    }
                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m; i > m - count-1 ; i--) {
                        board[k][i] = "W";
                    }
                }
            }
            this.print();
        }
        return count;

    }
    public int downSearch(int k,int m,String player)
    {
        int count=0;
        if(player=="First"){
            if(board[k][m]=="-") {
                for (int i = k + 1; i < 9; i++) {
                    if (board[i][m] == "W") {
                        count++;
                    }
                    if (board[i][m] == "B") {
                        break;
                    }

                    if (board[i][m] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = k; i < k + count+1 ; i++) {
                        board[i][m] = "B";
                    }
                }
            }
            this.print();
        }else if(player=="Second"){
            if(board[k][m]=="-") {
                for (int i = k + 1; i < 9; i++) {
                    if (board[k][i] == "B") {
                        count++;
                    }
                    if (board[k][i] == "W") {
                        break;
                    }
                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = k; i < k + count+1 ; i++) {
                        board[k][i] = "W";
                    }
                }
            }
            this.print();
        }
        return count;

    }
    public int topSearch(int k,int m,String player)
    {
        int count=0;
        if(player=="First"){
            if(board[k][m]=="-") {
                for (int i = k - 1; i >0 ; i--) {
                    if (board[i][m] == "W") {
                        count++;
                    }
                    if (board[i][m] == "B") {
                        break;
                    }

                    if (board[i][m] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = k; i > k - count-1 ; i--) {
                        board[i][m] = "B";
                    }
                }
            }
            this.print();
        }else if(player=="Second"){
            if(board[k][m]=="-") {
                for (int i = k - 1; i > 0; i--) {
                    if (board[k][i] == "B") {
                        count++;
                    }
                    if (board[k][i] == "W") {
                        break;
                    }
                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = k; i > k - count-1 ; i--) {
                        board[k][i] = "W";
                    }
                }
            }
            this.print();
        }
        return count;

    }
    public int downRightSearch(int k,int m,String player)
    {
        int count=0;
        if(player=="First"){
            if(board[k][m]=="-") {
                for (int i = m + 1,j=k+1; i < 9||j<9; i++,j++) {
                    if (board[j][i] == "W") {
                        count++;
                    }
                    if (board[j][i] == "B") {
                        break;
                    }

                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m,j=k; i < m + count+1||j<k+count+1 ; i++,j++) {
                        board[j][i] = "B";
                    }
                }
            }
            this.print();
        }else if(player=="Second"){
            if(board[k][m]=="-") {
                for (int i = m + 1,j=k+1; i < 9||j<9; i++,j++) {
                    if (board[j][i] == "B") {
                        count++;
                    }
                    if (board[j][i] == "W") {
                        break;
                    }
                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m,j=k; i < m + count+1||j<count+k+1 ; i++,j++) {
                        board[j][i] = "W";
                    }
                }
            }
            this.print();
        }
        return count;

    }
    public int topRightSearch(int k,int m,String player)
    {
        int count=0;
        if(player=="First"){
            if(board[k][m]=="-") {
                for (int i = m + 1,j=k-1; i < 9||j>0; i++,j--) {
                    if (board[j][i] == "W") {
                        count++;
                    }
                    if (board[j][i] == "B") {
                        break;
                    }

                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m,j=k; i < m + count+1||j>k-count-1 ; i++,j--) {
                        board[j][i] = "B";
                    }
                }
            }
            this.print();
        }else if(player=="Second"){
            if(board[k][m]=="-") {
                for (int i = m + 1,j=k+1; i < 9||j>0; i++,j--) {
                    if (board[j][i] == "B") {
                        count++;
                    }
                    if (board[j][i] == "W") {
                        break;
                    }
                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m,j=k; i < m + count+1||j>count-k-1 ; i++,j--) {
                        board[j][i] = "W";
                    }
                }
            }
            this.print();
        }
        return count;

    }
    public int downLeftSearch(int k,int m,String player)
    {
        int count=0;
        if(player=="First"){
            if(board[k][m]=="-") {
                for (int i = m - 1,j=k+1; i >0 ||j<9; i--,j++) {
                    if (board[j][i] == "W") {
                        count++;
                    }
                    if (board[j][i] == "B") {
                        break;
                    }

                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m,j=k; i > m - count-1||j<k+count+1 ; i--,j++) {
                        board[j][i] = "B";
                    }
                }
            }
            this.print();
        }else if(player=="Second"){
            if(board[k][m]=="-") {
                for (int i = m - 1,j=k+1; i > 0||j<9; i--,j++) {
                    if (board[j][i] == "B") {
                        count++;
                    }
                    if (board[j][i] == "W") {
                        break;
                    }
                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m,j=k; i > m - count-1||j<count+k+1 ; i++,j--) {
                        board[j][i] = "W";
                    }
                }
            }
            this.print();
        }
        return count;

    }
    public int topLeftSearch(int k,int m,String player)
    {
        int count=0;
        if(player=="First"){
            if(board[k][m]=="-") {
                for (int i = m - 1,j=k-1; i >0 ||j>0; i--,j--) {
                    if (board[j][i] == "W") {
                        count++;
                    }
                    if (board[j][i] == "B") {
                        break;
                    }

                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m,j=k; i > m - count-1||j>k-count-1 ; i--,j--) {
                        board[j][i] = "B";
                    }
                }
            }
            this.print();
        }else if(player=="Second"){
            if(board[k][m]=="-") {
                for (int i = m - 1,j=k-1; i > 0||j>0; i--,j--) {
                    if (board[j][i] == "B") {
                        count++;
                    }
                    if (board[j][i] == "W") {
                        break;
                    }
                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0) {
                    for (int i = m,j=k; i > m - count-1||j>count-k-1 ; i--,j--) {
                        board[j][i] = "W";
                    }
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
                int j=-1;
                int i=Integer.parseInt(sPart);
                switch (fPart)
                {
                    case"A":
                    j=1;
                    break;
                    case"B":
                        j=2;
                        break;
                    case"C":
                        j=3;
                        break;
                    case"D":
                        j=4;
                        break;
                    case"E":
                        j=5;
                        break;
                    case"F":
                        j=6;
                        break;
                    case"G":
                        j=7;
                        break;
                    case"H":
                        j=8;
                        break;
                }
                System.out.printf(i+" "+j);
                System.out.println();

                this.rightSearch(i,j,"First");
                this.leftSearch(i,j,"First");
                this.downSearch(i,j,"First");
                this.topSearch(i,j,"First");
                this.downRightSearch(i,j,"First");
                this.topRightSearch(i,j,"First");
                this.downLeftSearch(i,j,"First");
                this.topLeftSearch(i,j,"First");
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

