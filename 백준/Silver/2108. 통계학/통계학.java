import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    int[] arr = new int[n];
    int sum = 0;
    for (int x = 0; x < n; x++) {
      arr[x] = Integer.parseInt(reader.readLine());
      sum += arr[x];
    }
    Arrays.sort(arr);
    writer.write((Math.round((float) (sum) / n)) + "\n");
    writer.write(arr[n / 2] + "\n");

    ArrayList<Integer> mode = new ArrayList<>();
    int maxCount = 1;
    int curCount = 1;
    int prev = arr[0];
    for (int x = 1; x < n; x++) {
      if (arr[x] == prev) {
        curCount++;
      } else {
        if (curCount > maxCount) {
          mode = new ArrayList<>();
          mode.add(prev);
          maxCount = curCount;
        } else if (curCount == maxCount) {
          mode.add(prev);
        }
        curCount = 1;
        prev = arr[x];
      }
    }
    if (curCount > maxCount) {
      mode = new ArrayList<>();
      mode.add(prev);
      maxCount = curCount;
    } else if (curCount == maxCount) {
      mode.add(prev);
    }
    if (mode.size() == 1)
      writer.write(mode.get(0) + "\n");
    else
      writer.write(mode.get(1) + "\n");
    writer.write((arr[n - 1] - arr[0]) + "\n");

    writer.flush();
    writer.close();
    reader.close();
  }
}
