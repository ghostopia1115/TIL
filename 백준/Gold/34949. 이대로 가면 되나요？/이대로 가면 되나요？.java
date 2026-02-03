import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(reader.readLine());
    st = new StringTokenizer(reader.readLine());
    ArrayList<ArrayList<Integer>> direction = new ArrayList<>();
    int[] questionsNeeded = new int[n];
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    for (int x = 0; x < n; x++) {
      direction.add(new ArrayList<>());
      questionsNeeded[x] = -1;
    }

    for (int x = 0; x < n; x++) {
      int destination = Integer.parseInt(st.nextToken()) - 1;
      direction.get(destination).add(x);
    }

    questionsNeeded[n - 1] = 0;
    dq.add(n - 1);
    while (dq.size() > 0) {
      int cur = dq.pollFirst();
      direction.get(cur).forEach((element) -> {
        if (questionsNeeded[element] != -1)
          return;
        dq.addLast(element);
        questionsNeeded[element] = questionsNeeded[cur] + 1;
      });
    }

    for (int x = 0; x < n; x++) {
      System.out.println(questionsNeeded[x]);
    }

    writer.flush();
    writer.close();
    reader.close();
  }
}
