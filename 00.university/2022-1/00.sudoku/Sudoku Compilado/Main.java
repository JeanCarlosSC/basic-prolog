class Main {
  public static void main(String[] args) {
    
    // tablero 1
    System.out.println("\nTablero 1");
    int[][] tablero1 = Tablero.generarTablero();
    Tablero.printBoard(tablero1);

    System.out.println("Solución del tablero 1");
    Tablero.printBoard(Tablero.sudoku(tablero1));
  }
}