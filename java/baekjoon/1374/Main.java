
/**
 * @author suho kim
 * @no 1374
 * @title 강의실
 * @url https://www.acmicpc.net/problem/1374
 * @date 2022.03.23
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Room implements Comparable<Room> {
  int time;
  int value;

  public Room(int time, int value) {
    this.time = time;
    this.value = value;
  }

  @Override
  public int compareTo(Room o) {
    if (this.time == o.time)
      return this.value - o.value;

    return this.time - o.time;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    PriorityQueue<Room> pq = new PriorityQueue<Room>();

    int N = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      st.nextToken();
      int startTime = Integer.parseInt(st.nextToken());
      int endTime = Integer.parseInt(st.nextToken());

      pq.offer(new Room(startTime, 1));
      pq.offer(new Room(endTime, -1));
    }

    int result = 0;
    int openRoomCount = 0;
    while (!pq.isEmpty()) {
      openRoomCount += pq.poll().value;
      result = Math.max(result, openRoomCount);
    }

    System.out.println(result);
  }
}
