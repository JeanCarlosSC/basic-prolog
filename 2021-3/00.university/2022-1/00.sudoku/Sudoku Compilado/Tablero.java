
import java.util.Random;

public class Tablero {
  
  private static Random random = new Random();
  
  public static int[][] generarTablero() {
    int[][] board = new int[9][9];
    board[0][0] = 2;
    int cantidadDeValores = random.nextInt(10)+5;
    
    while(cantidadDeValores > 0) {
      int x = random.nextInt(9);
      int y = random.nextInt(9);

      int limit = 0;
      do {
        board[x][y] = random.nextInt(9)+1;
        limit++;
        if(limit > 100) {
          board[x][y] = 0;
          break;
        }
      } while( !isValid(board) );
      cantidadDeValores--;
    }
    return board;
  }

  public static boolean isValid(int[][] board) {
    return verifyColumns(board) && verifyRows(board) && verifySquares(board);
  }

  private static boolean verifyColumns(int[][] board) {
    // itera por cada columna
    for(int j=0; j<9; j++) {
      // verifica que los números del 1 al 9 no se repitan
      for(int num=1; num<10; num++) {
        int contador = 0;
        // itera por cada elemento de la columna (por cada fila)
        for (int i=0; i<9; i++){
          if(board[i][j] == num) {
            contador++;
          }
          if(contador > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static boolean verifyRows(int[][] board) {
    // itera por cada fila
    for(int i=0; i<9; i++) {
      // verifica que los números del 1 al 9 no se repitan
      for(int num=1; num<10; num++) {
        int contador = 0;
        // itera por cada elemento de la fila (por cada columna)
        for (int j=0; j<9; j++){
          if(board[i][j] == num) {
            contador++;
          }
          if(contador > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static boolean verifySquares(int[][] board) {
    // itera en las tres cordenadas principales de x
    for(int x=0; x<9; x+=3) {
      // itera en las tres cordenadas principales de y
      for(int y=0; y<9; y+=3) {
        // cuenta por cada número
        for(int num=1; num<10; num++) {
          int contador = 0;
          // valida el respectivo cuadrado
          for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
              if(num==board[i+x][j+y]) {
                contador++;
              }
              if(contador > 1) {
                return false;
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  public static void printBoard(int[][] board) {
    System.out.println("\n - - - - - - - - - - - ");
    for(int i=0; i<9; i++) {
      for(int j=0; j<9; j++) {
        System.out.print(board[i][j] + " ");
        if(j%3 == 2) {
          System.out.print("| ");
        }
      }
      if(i%3 == 2) {
        System.out.println("\n - - - - - - - - - - - ");
      }
      else {
        System.out.println();
      }
    }
  }

  private static int[][] board;

  public static int[][] sudoku(int[][] newBoard) {
    board = newBoard;
    solve();
    return board;
  }
  
  private static boolean solve() {
    for (int row = 0; row < 9; row++) {
        for (int column = 0; column < 9; column++) {
            if (board[row][column] == 0) {
                for (int k = 1; k <= 9; k++) {
                    board[row][column] = k;
                    if (isValid(board) && solve()) {
                        return true;
                    }
                    board[row][column] = 0;
                }
                return false;
            }
        }
    }
    return true;
  }
}