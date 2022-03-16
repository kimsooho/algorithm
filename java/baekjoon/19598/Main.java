
/**
 * @author suho kim
 * @no 19598
 * @title 최소 회의실 개수
 * @url https://www.acmicpc.net/problem/19598 
 * @date 2022.03.15
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Room implements Comparable<Room> {
  int time;
  int isOpen;

  public Room(int time, boolean isOpen) {
    this.time = time;
    this.isOpen = isOpen ? 1 : -1;
  }

  @Override
  public int compareTo(Room o) {
    return this.time - o.time;
  }
}

public class Main {
  static List<Room> rooms;

  public static void main(String[] args) throws IOException {
    int result = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    rooms = new ArrayList<Room>();
    int N = Integer.parseInt(st.nextToken());

    PriorityQueue<Room> pq = new PriorityQueue<Room>();

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      int sTime = Integer.parseInt(st.nextToken());
      int eTime = Integer.parseInt(st.nextToken());
      pq.offer(new Room(sTime, true));
      pq.offer(new Room(eTime, false));
    }

    int openRoomCount = 0;
    while (!pq.isEmpty()) {
      Room room = pq.poll();
      openRoomCount += room.isOpen;
      result = Math.max(result, openRoomCount);
    }

    System.out.println(result);
  }
}