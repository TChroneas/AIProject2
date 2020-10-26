public class Move {
    String[][]board;
    String player;

    public Move(String[][] board, String player) {
        this.board = board;
        this.player = player;
    }
    public boolean topRightCheck(){
        boolean check=false;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i-1][j+1]=="X"){
                                for(int k=j+1,m=i-1;k<9||m>0;k++,m--){

                                    if(board[m][k]=="O"){
                                        check=true;
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
                                for(int k=j+1,m=i-1;k<9||m>0;k++,i--){
                                    if(board[m][k]=="X"){
                                        check=true;
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
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i+1][j-1]=="X"){
                                for(int k=j-1,m=i+1;k>0||m<9;k--,m++){

                                    if(board[m][k]=="O"){
                                        check=true;
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
                                for(int k=j-1,m=i+1;k>0||m<9;k--,i++){
                                    if(board[m][k]=="X"){
                                        check=true;
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
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i-1][j-1]=="X"){
                                for(int k=j-1,m=i-1;k>0||m>0;k--,m--){

                                    if(board[m][k]=="O"){
                                        check=true;
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
                            if(board[i-1][j-1]=="O"){
                                for(int k=j-1,m=i-1;k>0||m>0;k--,i--){
                                    if(board[m][k]=="X"){
                                        check=true;
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
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i+1][j+1]=="X"){
                                for(int k=j+1,m=i+1;k<9||m<9;k++,m++){

                                    if(board[m][k]=="O"){
                                        check=true;
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
                                for(int k=j+1,m=i+1;k<9||m<9;k++,i++){
                                    if(board[m][k]=="X"){
                                        check=true;
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
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i-1][j]=="X"){
                                for(int k=i-1;k>0;k--){
                                    if(board[k][j]=="O"){
                                        check=true;
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
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i+1][j]=="X"){
                                for(int k=i+1;k<9;k++){
                                    if(board[k][j]=="O"){
                                        check=true;
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
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i][j-1]=="X"){
                                for(int k=j-1;k>0;k--){
                                    if(board[i][k]=="O"){
                                        check=true;
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
                if(board[i][j]=="-"){
                    if(player=="First"){
                        try{
                            if(board[i][j+1]=="X"){
                                for(int k=j+1;k<9;k++){
                                    if(board[i][k]=="O"){
                                        check=true;
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
        return (upCheck()||downCheck()||leftCheck()||rightCheck()||downLeftCheck()||downRightCheck()||topLeftCheck()||topRightCheck());
    }



}
