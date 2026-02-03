import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String string_a = reader.readLine();
    String string_b = reader.readLine();

    writer.write(editCount(string_a, string_b) + "");
    writer.flush();
    writer.close();
    reader.close();
  }

  public static int editCount(String a, String b) {
    if (b.length() == 0)
      return a.length();
    int min = Math.max(a.length(), b.length());
    if (a.length() == b.length()) {
      for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) == b.charAt(i))
          min--;
      }
    }
    for (int i = 0; i < b.length(); i++) {
      for (int j = 0; j < a.length(); j++) {
        if (a.charAt(j) == b.charAt(i)) {
          int front = Math.max(i, j);
          if (front < min) {
            int back = editCount(a.substring(j + 1), b.substring(i + 1));
            if (front + back < min)
              min = front + back;
          }
        }
      }
    }
    return min;
  }
}