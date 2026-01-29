import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    boolean[][] influenced = new boolean[8][8];
    int queenCount = 0;
    for (int x = 0; x < 8; x++) {
      String line = reader.readLine();
      for (int y = 0; y < 8; y++) {
        if (line.charAt(y) == '*') {
          queenCount++;
          if (influenced[x][y]) {
            System.out.println("invalid");
            System.exit(0);
          }

          for (int i = 0; i < 8; i++) {
            influenced[x][i] = true;
            influenced[i][y] = true;
            if (x - i >= 0 && y - i >= 0)
              influenced[x - i][y - i] = true;
            if (x - i >= 0 && y + i < 8)
              influenced[x - i][y + i] = true;
            if (x + i < 8 && y - i >= 0)
              influenced[x + i][y - i] = true;
            if (x + i < 8 && y + i < 8)
              influenced[x + i][y + i] = true;
          }
        }
      }
    }
    if (queenCount != 8)
      System.out.println("invalid");
    else
      System.out.println("valid");
  }
}
