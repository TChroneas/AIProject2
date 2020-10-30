import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Board implements Cloneable {
    public String[][] board = new String[9][9];
    public void print()
    {
        for(int i=0;i<9;i++)
        {
         for(int j=0;j<9;j++){
             System.out.print(board[i][j]);
             System.out.print("    ");
         }
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public Board(Board newBoard) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                this.board[i][j]=newBoard.board[i][j];
            }
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
        board[4][4]="O";
        board[4][5]="X";
        board[5][4]="X";
        board[5][5]="O";
       /* board[1][2]="X";
        board[1][2]="X";
        board[1][3]="X";
        board[1][4]="X";
        board[1][5]="X";
        board[1][6]="X";
        board[1][7]="X";
        board[1][1]="X";*/








    }


    public void startAIGame() throws CloneNotSupportedException {
        int i=0;
        while (true){


            if (i%2==0){
                Move a=new Move(this.board,"First");
                if(a.exists()) {
                    System.out.println(this.firstPlayerMessage());
                    a.printMoves();
                    System.out.println();
                    this.play("First");
                    this.print();

                }else{
                    System.out.println("First player has no moves");
                }
            }
            else {
                Move b=new Move(this.board,"Second");
                if(b.exists()) {
                    b.printMoves();
                    System.out.println();
                    System.out.println(this.secondPlayerMessage());
                    Minimax m=new Minimax(this,"Second");
                    this.board=m.miniiimax(10,false,m.board,Integer.MIN_VALUE,Integer.MAX_VALUE).board;


                }else{
                    System.out.println("Second player has no moves");
                }
            }
            i++;
            Move c=new Move(board,"First");
            Move d=new Move(board,"Second");
            if(!c.exists()&&!d.exists()){
                int oPieces=this.getPiecesCount("First");
                int xPieces=this.getPiecesCount("Second");
                System.out.println("Game over");
                if(oPieces>xPieces){
                    System.out.println("First player victory");
                }else if(oPieces<xPieces){
                    System.out.println("Second player victory");
                }else{
                    System.out.println("Draw");
                }
                System.out.println("Final board:");
                this.print();
                System.out.println("Final score:");
                System.out.println("Black:"+this.getPiecesCount("First")+",White:"+this.getPiecesCount("Second"));
                break;
            }

        }
    }

    public void startGame()
    {
        int i=0;
        while (true){


            if (i%2==0){
                Move a=new Move(this.board,"First");
                if(a.exists()) {
                    System.out.println(this.firstPlayerMessage());
                    a.printMoves();
                    System.out.println();
                    this.play("First");

                }else{
                    System.out.println("First player has no moves");
                }
            }
            else {
                Move b=new Move(this.board,"Second");
                if(b.exists()) {
                    b.printMoves();
                    System.out.println();
                    System.out.println(this.secondPlayerMessage());
                    this.play("Second");

                }else{
                    System.out.println("Second player has no moves");
                }



            }
            i++;
            Move c=new Move(board,"First");
            Move d=new Move(board,"Second");
            if(!c.exists()&&!d.exists()){
                int oPieces=this.getPiecesCount("First");
                int xPieces=this.getPiecesCount("Second");
                System.out.println("Game over");
                if(oPieces>xPieces){
                    System.out.println("First player victory");
                }else if(oPieces<xPieces){
                    System.out.println("Second player victory");
                }else{
                    System.out.println("Draw");
                }
                System.out.println("Final board:");
                this.print();
                System.out.println("Final score:");
                System.out.println("Black:"+this.getPiecesCount("First")+",White:"+this.getPiecesCount("Second"));
                break;
            }

        }




    }
    public int startValue(boolean maxim){
        if(maxim){
            return Integer.MIN_VALUE;

        }else{
            return Integer.MAX_VALUE;
        }
    }
    public int evaluate(String player){
        int piecesPoints=15;
        int cornerPoints=0;
        int movesPoints=-10;
        int nextToCornerPoints=-40;
        boolean check=false;
        boolean check2=false;
        boolean check3=false;
        boolean check4=false;
        if(player=="First"){
            int count=this.getPiecesCount("First")-this.getPiecesCount("Second");
            piecesPoints=piecesPoints*count;
            Move a=new Move(this.board,"Second");
            a.generateMoves();
            movesPoints=movesPoints*a.moves.size();
            if(board[1][1]=="O"){
                check=true;
                cornerPoints=cornerPoints+50;
            }
            if(board[1][8]=="O"){
                check2=true;
                cornerPoints=cornerPoints+50;
            }
            if(board[8][1]=="O"){
                check3=true;
                cornerPoints=cornerPoints+50;
            }
            if(board[8][8]=="O"){
                check4=true;
                cornerPoints=cornerPoints+50;
            }
            if(board[1][2]=="O"&&!check){
                nextToCornerPoints=nextToCornerPoints-40;

            }
            if(board[1][7]=="O"&&!check2){
                nextToCornerPoints=nextToCornerPoints-40;

            }
            if(board[8][2]=="O"&&!check3){
                nextToCornerPoints=nextToCornerPoints-40;

            }
            if(board[8][7]=="O"&&!check4){
                nextToCornerPoints=nextToCornerPoints-40;

            }
            return piecesPoints+nextToCornerPoints+cornerPoints+movesPoints;

        }else{
            int count=this.getPiecesCount("Second")-this.getPiecesCount("First");
            piecesPoints=piecesPoints*count;
            Move a=new Move(this.board,"First");
            a.generateMoves();
            movesPoints=movesPoints*a.moves.size();
            if(board[1][1]=="O"){
                check=true;
                cornerPoints=cornerPoints+50;
            }
            if(board[1][8]=="O"){
                check2=true;
                cornerPoints=cornerPoints+50;
            }
            if(board[8][1]=="O"){
                check3=true;
                cornerPoints=cornerPoints+50;
            }
            if(board[8][8]=="O"){
                check4=true;
                cornerPoints=cornerPoints+50;
            }
            if(board[1][2]=="O"&&!check){
                nextToCornerPoints=nextToCornerPoints-40;

            }
            if(board[1][7]=="O"&&!check2){
                nextToCornerPoints=nextToCornerPoints-40;

            }
            if(board[8][2]=="O"&&!check3){
                nextToCornerPoints=nextToCornerPoints-40;

            }
            if(board[8][7]=="O"&&!check4){
                nextToCornerPoints=nextToCornerPoints-40;

            }
            return -1*(piecesPoints+nextToCornerPoints+cornerPoints+movesPoints);



        }

    }
    public int getPiecesCount(String player)
    {
        int count=0;
        for(int i=1;i<9;i++){
            for (int j=1;j<9;j++){
                if (board[i][j]=="O"&&player=="First"){
                    count++;
                }else if(board[i][j]=="X"&&player=="Second"){
                    count++;
                }
            }
        }
        return count;
    }
    public String firstPlayerMessage()

    {
        return "First player turn (O Pieces)";
    }
    public String secondPlayerMessage()
    {
        return "Second player turn(X Pieces)";
    }
    public int rightSearch(int k,int m,String player)
    {
        int count=0;
        int column=0;
        int row=k;
        if(player=="First"){

                for (int i = m + 1; i < 9; i++) {
                    if (board[k][i] == "X") {
                        count++;
                    }
                    if (board[k][i] == "O") {
                        column=i;
                        break;

                    }

                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="O") {
                    for (int i = m; i < m + count+1 ; i++) {
                        board[k][i] = "O";
                    }
                }else{
                    count=0;
                }


        }else if(player=="Second"){

                for (int i = m + 1; i < 9; i++) {
                    if (board[k][i] == "O") {
                        count++;
                    }
                    if (board[k][i] == "X") {
                        column=i;
                        break;
                    }
                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="X") {
                    for (int i = m; i < m + count+1 ; i++) {
                        board[k][i] = "X";
                    }
                }else{
                    count=0;
                }



        }
        return count;

    }
    public int leftSearch(int k,int m,String player)
    {
        int count=0;
        int column=0;
        int row=k;
        if(player=="First"){

                for (int i = m - 1; i >0 ; i--) {
                    if (board[k][i] == "X") {
                        count++;
                    }
                    if (board[k][i] == "O") {
                        column=i;
                        break;
                    }

                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="O") {
                    for (int i = m; i > m - count-1 ; i--) {
                        board[k][i] = "O";
                    }

            }else{
                    count=0;
                }
        }else if(player=="Second"){

                for (int i = m - 1; i >0; i--) {
                    if (board[k][i] == "O") {
                        count++;
                    }
                    if (board[k][i] == "X") {
                        column=i;
                        break;
                    }
                    if (board[k][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="X") {
                    for (int i = m; i > m - count-1 ; i--) {
                        board[k][i] = "X";
                    }
                }
                else{
                    count=0;
                }
            }


        return count;

    }
    public int downSearch(int k,int m,String player)
    {
        int count=0;
        int column=m;
        int row=0;
        if(player=="First"){

                for (int i = k + 1; i < 9; i++) {
                    if (board[i][m] == "X") {
                        count++;
                    }
                    if (board[i][m] == "O") {
                        row=i;
                        break;
                    }

                    if (board[i][m] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="O") {
                    for (int i = k; i < k + count+1 ; i++) {
                        board[i][m] = "O";
                    }
                }else{
                    count=0;
                }


        }else if(player=="Second"){

                for (int i = k + 1; i < 9; i++) {
                    if (board[i][m] == "O") {
                        count++;
                    }
                    if (board[i][m] == "X") {
                        row=i;
                        break;
                    }
                    if (board[i][m] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="X") {
                    for (int i = k; i < k + count+1 ; i++) {
                        board[i][m] = "X";
                    }
                }else{
                    count=0;
                }

        }
        return count;

    }
    public int topSearch(int k,int m,String player)
    {
        int count=0;
        int column=m;
        int row=0;
        if(player=="First"){

                for (int i = k - 1; i >0 ; i--) {
                    if (board[i][m] == "X") {
                        count++;
                    }
                    if (board[i][m] == "O") {
                        row=i;
                        break;
                    }

                    if (board[i][m] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="O") {
                    for (int i = k; i > k - count-1 ; i--) {
                        board[i][m] = "O";
                    }

            }else{
                    count=0;
                }

        }else if(player=="Second"){

                for (int i = k - 1; i >0 ; i--) {
                    if (board[i][m] == "O") {
                        count++;
                    }
                    if (board[i][m] == "X") {
                        row=i;
                        break;
                    }

                    if (board[i][m] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="X") {
                    for (int i = k; i > k - count-1 ; i--) {
                        board[i][m] = "X";
                    }
                }else{
                    count=0;
                }


        }
        return count;

    }
    public int downRightSearch(int k,int m,String player)
    {
        int column=0;
        int row=0;
        int count=0;
        if(player=="First"){

                for (int i = m + 1,j=k+1; i < 9||j<9; i++,j++) {
                    if (board[j][i] == "X") {
                        count++;
                    }
                    if (board[j][i] == "O") {
                        row=j;
                        column=i;
                        break;
                    }

                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="O") {
                    for (int i = m,j=k; i < m + count+1||j<k+count+1 ; i++,j++) {
                        board[j][i] = "O";
                    }

            }else{
                    count=0;
                }

        }else if(player=="Second"){


                for (int i = m + 1,j=k+1; i < 9||j<9; i++,j++) {
                    if (board[j][i] == "O") {
                        count++;
                    }
                    if (board[j][i] == "X") {
                        row=j;
                        column=i;
                        break;
                    }
                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0 &&board[row][column]=="X") {
                    for (int i = m,j=k; i < m + count+1||j<count+k+1 ; i++,j++) {
                        board[j][i] = "X";
                    }
                }else{
                    count=0;
                }


        }
        return count;

    }
    public int topRightSearch(int k,int m,String player)
    {
        int count=0;
        int row=0;
        int column=0;
        if(player=="First"){

                for (int i = m + 1,j=k-1; i < 9||j>0; i++,j--) {
                    if (board[j][i] == "X") {
                        count++;
                    }
                    if (board[j][i] == "O") {
                        row=j;
                        column=i;
                        break;
                    }

                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="O") {
                    for (int i = m,j=k; i < m + count+1||j>k-count-1 ; i++,j--) {
                        board[j][i] = "O";
                    }
                }else{
                    count=0;
                }


        }else if(player=="Second"){

                for (int i = m + 1,j=k-1; i < 9||j>0; i++,j--) {
                    if (board[j][i] == "O") {
                        count++;
                    }
                    if (board[j][i] == "X") {
                        row=j;
                        column=i;
                        break;
                    }
                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="X") {
                    for (int i = m,j=k; i < m + count+1||j>k-count-1 ; i++,j--) {
                        board[j][i] = "X";
                    }
                }else{
                    count=0;
                }


        }
        return count;

    }
    public int downLeftSearch(int k,int m,String player)
    {
        int count=0;
        int row=0;
        int column=0;
        if(player=="First"){

                for (int i = m - 1,j=k+1; i >0 ||j<9; i--,j++) {
                    if (board[j][i] == "X") {
                        count++;
                    }
                    if (board[j][i] == "O") {
                        row=j;
                        column=i;
                        break;
                    }

                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="O") {
                    for (int i = m,j=k; i > m - count-1||j<k+count+1 ; i--,j++) {
                        board[j][i] = "O";
                    }
                }else{
                    count=0;
                }


        }else if(player=="Second"){

                for (int i = m - 1,j=k+1; i > 0||j<9; i--,j++) {
                    if (board[j][i] == "O") {
                        count++;
                    }
                    if (board[j][i] == "X") {
                        row=j;
                        column=i;
                        break;
                    }
                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="X") {
                    for (int i = m,j=k; i > m - count-1||j<k+count+1 ; i--,j++) {
                        board[j][i] = "X";
                    }
                }else{
                    count=0;
                }


        }
        return count;

    }
    public int topLeftSearch(int k,int m,String player)
    {
        int count=0;
        int row=0;
        int column=0;
        if(player=="First"){

                for (int i = m - 1,j=k-1; i >0 ||j>0; i--,j--) {
                    if (board[j][i] == "X") {
                        count++;
                    }
                    if (board[j][i] == "O") {
                        row=j;
                        column=i;
                        break;
                    }

                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="O") {
                    for (int i = m,j=k; i > m - count-1||j>k-count-1 ; i--,j--) {
                        board[j][i] = "O";
                    }
                }else{
                    count=0;
                }


        }else if(player=="Second"){

                for (int i = m - 1,j=k-1; i > 0||j>0; i--,j--) {
                    if (board[j][i] == "O") {
                        count++;
                    }
                    if (board[j][i] == "X") {
                        row=j;
                        column=i;
                        break;
                    }
                    if (board[j][i] == "-") {
                        count = 0;
                        break;
                    }
                }
                if (count != 0&&board[row][column]=="X") {
                    for (int i = m,j=k; i > m - count-1||j>k-count-1 ; i--,j--) {
                        board[j][i] = "X";
                    }
                }else{
                    count=0;
                }


        }
        return count;

    }
    public void aiTest(String move,String player){

        String firstPart = String.valueOf(move.charAt(0));
        String secondPart = String.valueOf(move.charAt(1));
        int i=Integer.parseInt(secondPart);
        int j=-1;
        switch (firstPart)
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
        try {
            this.rightSearch(i, j, player);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
             this.topRightSearch(i, j, player);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            this.topSearch(i, j, player);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
           this.topLeftSearch(i, j, player);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
           this.leftSearch(i, j, player);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
           this.downLeftSearch(i, j, player);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            this.downSearch(i, j, player);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            this.downRightSearch(i, j, player);
        } catch (ArrayIndexOutOfBoundsException e) {

        }


    }
    public void play(String player)
    {
        String fPart="";
        String sPart="";
        boolean invalidInput=true;
        boolean invalidMove=true;
        this.print();
        System.out.println("Black player:"+this.getPiecesCount("First")+" White player:"+this.getPiecesCount("Second"));
        do{
            System.out.println("Enter the tile you want to play");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



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
                int count=0;


                if(board[i][j]=="-") {
                    try {
                        count = count + this.rightSearch(i, j, player);
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        count = count + this.topRightSearch(i, j, player);
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        count = count + this.topSearch(i, j, player);
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        count = count + this.topLeftSearch(i, j, player);
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        count = count + this.leftSearch(i, j, player);
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        count = count + this.downLeftSearch(i, j, player);
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        count = count + this.downSearch(i, j, player);
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        count = count + this.downRightSearch(i, j, player);
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    if (count != 0) {
                        invalidMove = false;
                    }
                }
            }
            if(invalidMove){
                System.out.println("Move not legal,try again");
            }


        }while (invalidInput||invalidMove);
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


    public static void main(String args[]) throws CloneNotSupportedException {
        Board a=new Board();
        a.startAIGame();

    }

}

