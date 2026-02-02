import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(reader.readLine());
    for (int x = 0; x < n; x++) {
      st = new StringTokenizer(reader.readLine());
      ArrayDeque<String> list = new ArrayDeque<>();
      while (st.countTokens() > 0)
        list.add(st.nextToken());
      writer.write(parseExpr(list).toString() + "\n\n");
    }

    writer.flush();
    writer.close();
    reader.close();
  }

  public static StringBuilder parseExpr(ArrayDeque<String> list) {
    StringBuilder front = parseTerm(list);
    String addition = list.peekFirst();
    if (addition == null || !addition.equals("+") && !addition.equals("-")) {
      if (front.substring(front.length() - 1).equals(")")) {
        front.deleteCharAt(0);
        front.deleteCharAt(front.length() - 1);
      }
      return front;
    }
    front.append(" ");
    front.append(list.pollFirst());
    front.append(" ");
    front.append(parseTerm(list));
    while (list.size() > 0) {
      addition = list.peekFirst();
      if (addition.equals("+") || addition.equals("-")) {
        front.insert(0, '(');
        front.append(") ");
        front.append(list.pollFirst());
        front.append(" ");
        front.append(parseTerm(list));
      } else {
        return front;
      }
    }
    return front;
  }

  public static StringBuilder parseTerm(ArrayDeque<String> list) {
    StringBuilder front = new StringBuilder(list.pollFirst());
    String mult = list.peekFirst();
    if (mult == null || !mult.equals("X"))
      return front;
    front.insert(0, '(');
    front.append(" ");
    front.append(list.pollFirst());
    front.append(" ");
    front.append(list.pollFirst());
    front.append(')');
    while (list.size() > 0) {
      mult = list.peekFirst();
      if (mult.equals("X")) {
        front.insert(0, '(');
        front.append(" ");
        front.append(list.pollFirst());
        front.append(" ");
        front.append(list.pollFirst());
        front.append(')');
      } else {
        return front;
      }
    }
    return front;
  }
}