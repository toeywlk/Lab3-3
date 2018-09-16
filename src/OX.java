public class OX {
    private String [][] table = {
            {"", " 0", " 1", " 2",} ,
            {"0", " -", " -", " -",} ,
            {"1", " -", " -", " -",} ,
            {"2", " -", " -", " -",}
    };
    private String player;
    private int countX;
    private int countO;
    private int countDraw;
    private int trun;

    public OX(){
        player = " X";
        countX = 0;
        countO = 0;
        countDraw = 0;
        trun = 0;
    }

    public String getTableString() {
        String result = " ";
        for(int row = 0 ;row < 4 ; row++){
            for(int col = 0 ;col < 4 ;col++){
                result = result + table [row][col] ;

            }
            result = result + "\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountO() {
        return  countO;
    }

    public int getCountDraw() {
        return countDraw;
    }

    public boolean put(int col, int row) {
        try {
            if (!table[row + 1][col + 1].equals(" -")) {
                return false;
            }
            table[row + 1][col + 1] = player;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        trun++;

        if (checkWin(col, row)) {
            if (player.equals(" X")) {
                countX++;
            } else if (player.equals(" O")) {
                countO++;
            }
        }

        if (Draw()) {
            countDraw++;
        }

        return true;



    }
    public void reset() {
        for(int row = 0 ;row < 3 ; row++){
            for(int col = 0 ;col < 3 ;col++){
                table[row+1][col+1] = " -";
            }
        }
        player = " X";
        trun = 0;
    }

    public int getTurn() {
        return trun;
    }

    public boolean Draw() {
        if(trun < 9) {
            return false;
        }
        return true;
    }
    public String get(int col, int row) {
        if(col > 2 || col < 0 || row > 2 || row < 0) {
            return null;
        }
        return table[row+1][col+1];
    }


    public boolean checkWin(int col, int row) {
        boolean winRow = true;
        for (int c = 0; c < 3; c++) {
            if (!table[row + 1][c + 1].equals(player)) {
                winRow =  false;
            }
        }
        if(winRow){
            return true;
        }

        boolean winCol = true;
        for (int r = 0; r < 3; r++) {
            if (!table[r + 1][col + 1].equals(player)) {
                winCol =  false;
            }
        }
        if(winCol){
            return true;
        }

        boolean winES = true;
        for (int d = 0; d < 3; d++) {
            if (!table[d + 1][d + 1].equals(player)) {
                winES =  false;
            }
        }
        if(winES){
            return true;
        }

        boolean winSS = true;
        for (int u = 0; u < 3; u++) {
            if (!table[u + 1][3 - u].equals(player)) {
                winSS =  false;
            }
        }
        if(winSS){
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        if (player.equals(" X")) {
            player = " O";
        } else {
            player = " X";
        }
    }
}
