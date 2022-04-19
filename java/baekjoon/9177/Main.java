
/**
 * @author suho kim
 * @no 9177
 * @title 단어 섞기
 * @url https://www.acmicpc.net/problem/9177
 * @date 2022.04.20
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    for (int i = 1; i <= tc; ++i) {
      String[] words = br.readLine().split(" ");
      System.out.println(String.format("Data set %d: %s", i, makeable(words[0], words[1], words[2]) ? "yes" : "no"));
    }
  }

  private static boolean makeable(String wordA, String wordB, String targetWord) {
    Queue<int[]> q = new LinkedList<int[]>();
    boolean[][] visited = new boolean[201][201];
    q.offer(new int[] { 0, 0, 0 });
    visited[0][0] = true;
    while (!q.isEmpty()) {
      int[] idxs = q.poll();
      int wordAIdx = idxs[0];
      int wordBIdx = idxs[1];
      int targetWordIdx = idxs[2];

      if (targetWordIdx == targetWord.length()) {
        return true;
      }

      if (wordAIdx < wordA.length() && wordA.charAt(wordAIdx) == targetWord.charAt(targetWordIdx)
          && !visited[wordAIdx + 1][wordBIdx]) {
        visited[wordAIdx + 1][wordBIdx] = true;
        q.offer(new int[] { wordAIdx + 1, wordBIdx, targetWordIdx + 1 });
      }

      if (wordBIdx < wordB.length() && wordB.charAt(wordBIdx) == targetWord.charAt(targetWordIdx)
          && !visited[wordAIdx][wordBIdx + 1]) {
        visited[wordAIdx][wordBIdx + 1] = true;
        q.offer(new int[] { wordAIdx, wordBIdx + 1, targetWordIdx + 1 });
      }
    }
    return false;
  }
}
