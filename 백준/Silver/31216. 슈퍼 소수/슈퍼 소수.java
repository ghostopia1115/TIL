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

    int t = Integer.parseInt(reader.readLine());
    int[] primeNum = new int[318138];
    primeNum[0] = -1;
    primeNum[1] = -1;
    int primeCount = 0;
    ArrayList<Integer> primeList = new ArrayList<>();
    int[] superPrime = new int[3001];
    for (int x = 2; x < primeNum.length; x++) {
      if (primeNum[x] != -1) {
        primeCount++;
        primeNum[x] = primeCount;
        primeList.add(x);
        for (int y = x * 2; y < primeNum.length; y += x) {
          primeNum[y] = -1;
        }
      }
    }
    for (Integer prime : primeList) {
      int nthPrime = primeNum[primeNum[prime]];
      if (nthPrime != -1) {
        superPrime[nthPrime] = prime;
      }
    }
    for (int x = 0; x < t; x++) {
      int n = Integer.parseInt(reader.readLine());
      writer.write(superPrime[n] + "\n");
    }

    writer.flush();
    writer.close();
    reader.close();
  }
}
