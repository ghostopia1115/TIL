import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String a = " " + reader.readLine();
    String b = " " + reader.readLine();
    int[][] dp = new int[a.length()][b.length()];
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < b.length(); j++) {
        if (i == 0)
          dp[i][j] = j;
        else if (j == 0)
          dp[i][j] = i;
        else if (a.charAt(i) == b.charAt(j)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
        }
      }
    }
    writer.write(dp[a.length() - 1][b.length() - 1] + "");
    writer.flush();
    writer.close();
    reader.close();
  }
}
