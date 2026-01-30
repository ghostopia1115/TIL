import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    int month = 1 + 7 * n;
    int year = 2024 + month / 12;
    month %= 12;
    if (month == 0)
      writer.write((year - 1) + " " + (12));
    else
      writer.write((year) + " " + (month));

    writer.flush();
    writer.close();
    reader.close();
  }
}
