public class NQueenNRow {

    public static void NQueen(char[][] chessboard, int row) {
        if (row == chessboard.length) {
            printChess(chessboard);
            return;
        }

        for (int j = 0; j < chessboard.length; j++) {
            chessboard[row][j] = 'Q';
            NQueen(chessboard, row + 1);
            chessboard[row][j] = '.';
        }
    }

    public static void printChess(char chessboard[][]) {
        System.out.println("------chess-----");
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                System.out.print(chessboard[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 2;
        char chessboard[][] = new char[n][n];
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                chessboard[i][j] = '.';
            }
        }
        NQueen(chessboard, 0);
    }
}
