
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Move {
    String[][]board;
    String player;
    ArrayList<String> moves=new ArrayList<>();
    int row,column=-1;

    public Move(String[][] board, String player) {
        this.board = board;
        this.player = player;
        moves.clear();
    }

    public void printMoves(){
        moves = new ArrayList<String>(new LinkedHashSet<String>(moves));
        System.out.print("Available moves: ");
        for(String move:moves){
            System.out.print(move+" ");
        }
    }
    public void moveToString(int i,int j){
        String move="";
        switch (j){
            case 1:
                move="A"+String.valueOf(i);
                break;
            case 2:
                move="B"+String.valueOf(i);
                break;
            case 3:
                move="C"+String.valueOf(i);
                break;
            case 4:
                move="D"+String.valueOf(i);
                break;
            case 5:
                move="E"+String.valueOf(i);
                break;
            case 6:
                move="F"+String.valueOf(i);
                break;
            case 7:
                move="G"+String.valueOf(i);
                break;
            case 8:
                move="H"+String.valueOf(i);
                break;
        }
        moves.add(move);
    }

    public boolean topRightCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                row=i;
                column=j;
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i-1][j+1]=="X"){
                                for(int k=j+1,m=i-1;k<9||m>0;k++,m--){

                                    if(board[m][k]=="O"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[m][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }else if(player=="Second"){
                        try{
                            if(board[i-1][j+1]=="O"){
                                for(int k=j+1,m=i-1;k<9||m>0;k++,m--){
                                    if(board[m][k]=="X"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[m][k]=="-"){
                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }
                }
            }
        }

        return check;
    }
    public boolean downLeftCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                row=i;
                column=j;
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i+1][j-1]=="X"){
                                for(int k=j-1,m=i+1;k>0||m<9;k--,m++){

                                    if(board[m][k]=="O"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[m][k]=="-"){
                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }else if(player=="Second"){
                        try{
                            if(board[i+1][j-1]=="O"){
                                for(int k=j-1,m=i+1;k>0||m<9;k--,m++){
                                    if(board[m][k]=="X"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[m][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }
                }
            }
        }

        return check;

    }
    public boolean topLeftCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                row=i;
                column=j;
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i-1][j-1]=="X"){
                                for(int k=j-1,m=i-1;k>0||m>0;k--,m--){

                                    if(board[m][k]=="O"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[m][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e) {

                        }
                    }else if(player=="Second"){
                        try{
                            if(board[i-1][j-1]=="O"){
                                for(int k=j-1,m=i-1;k>0||m>0;k--,m--){
                                    if(board[m][k]=="X"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[m][k]=="-"){
                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }
                }
            }
        }

        return check;

    }
    public boolean downRightCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                row=i;
                column=j;
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i+1][j+1]=="X"){
                                for(int k=j+1,m=i+1;k<9||m<9;k++,m++){

                                    if(board[m][k]=="O"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[m][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }else if(player=="Second"){
                        try{
                            if(board[i+1][j+1]=="O"){
                                for(int k=j+1,m=i+1;k<9||m<9;k++,m++){
                                    if(board[m][k]=="X"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[m][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }
                }
            }
        }

        return check;

    }
    public boolean upCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                row=i;
                column=j;
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i-1][j]=="X"){
                                for(int k=i-1;k>0;k--){
                                    if(board[k][j]=="O"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[k][j]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }else if(player=="Second"){
                        try{
                            if(board[i-1][j]=="O"){
                                for(int k=i-1;k>0;k--){
                                    if(board[k][j]=="X"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[k][j]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }
                }
            }
        }

        return check;

    }

    public boolean downCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                row=i;
                column=j;
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i+1][j]=="X"){
                                for(int k=i+1;k<9;k++){
                                    if(board[k][j]=="O"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[k][j]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }else if(player=="Second"){
                        try{
                            if(board[i+1][j]=="O"){
                                for(int k=i+1;k<9;k++){
                                    if(board[k][j]=="X"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[k][j]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }
                }
            }
        }

        return check;

    }

    public boolean leftCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                row=i;
                column=j;
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i][j-1]=="X"){
                                for(int k=j-1;k>0;k--){
                                    if(board[i][k]=="O"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[i][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }else if(player=="Second"){
                        try{
                            if(board[i][j-1]=="O"){
                                for(int k=j-1;k>0;k--){
                                    if(board[i][k]=="X"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[i][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }
                }
            }
        }

        return check;

    }
    public boolean rightCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                row=i;
                column=j;
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i][j+1]=="X"){
                                for(int k=j+1;k<9;k++){
                                    if(board[i][k]=="O"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[i][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }else if(player=="Second"){
                        try{
                            if(board[i][j+1]=="O"){
                                for(int k=j+1;k<9;k++){
                                    if(board[i][k]=="X"){
                                        check=true;
                                        moveToString(row,column);
                                    }else if(board[i][k]=="-"){

                                        break;
                                    }
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                    }
                }
            }
        }

        return check;

    }

    public boolean exists(){
        boolean firstCheck=upCheck();
        boolean secondCheck=downCheck();
        boolean thirdCheck=leftCheck();
        boolean fourthCheck=rightCheck();
        boolean fifthCheck=downLeftCheck();
        boolean sixthCheck=downRightCheck();
        boolean seventhCheck=topLeftCheck();
        boolean eighthCheck=topRightCheck();
        return (firstCheck||secondCheck||thirdCheck||fourthCheck||fifthCheck||sixthCheck||seventhCheck||eighthCheck);
    }



}
