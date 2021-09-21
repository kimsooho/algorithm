
/**
 * @author suho kim
 * @no 10825
 * @title 국영수
 * @url https://www.acmicpc.net/problem/10825
 * @date 2021.09.21
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
  String name;
  int k;
  int e;
  int m;

  public Student(String name, int k, int e, int m) {
    this.name = name;
    this.k = k;
    this.e = e;
    this.m = m;
  }

  @Override
  public int compareTo(Student o) {
    if (this.k == o.k) {
      if (this.e == o.e) {
        if (this.m == o.m) {
          return this.name.compareTo(o.name);
        }
        return o.m - this.m;
      }
      return this.e - o.e;
    }
    return o.k - this.k;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PriorityQueue<Student> pq = new PriorityQueue<Student>();

    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      pq.offer(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())));
    }

    while (!pq.isEmpty()) {
      System.out.println(pq.poll().name);
    }

  }
}
