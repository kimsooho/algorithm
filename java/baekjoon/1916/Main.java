/**
 * @author suho kim
 * @no 1916
 * @title 최소비용 구하기
 * @url https://www.acmicpc.net/problem/1916
 * @date 2021.08.24
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair
{
  int v;
  int cost;
  public Pair(int v, int cost)
  {
    this.v = v;
    this.cost = cost;
  }
}

public class Main {

  static int[] costs;
  static ArrayList<ArrayList<Pair>> graph;
  static PriorityQueue<Pair> pq;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    StringTokenizer st;
    graph = new ArrayList<ArrayList<Pair>>();
    pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
      @Override
      public int compare(Pair o1, Pair o2) {        
        return o1.cost - o2.cost;
      }
    });
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    costs = new int[N+1];
    visited = new boolean[N+1];
    for(int i=0; i<N+1; ++i)
    {
      graph.add(new ArrayList<Pair>());
      costs[i] = Integer.MAX_VALUE;
    }

    for(int i=0; i<M; ++i)
    {
      st = new StringTokenizer(br.readLine());
      graph.get(Integer.parseInt(st.nextToken())).add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    
    st = new StringTokenizer(br.readLine());
    int from = Integer.parseInt(st.nextToken());
    int to = Integer.parseInt(st.nextToken());

    costs[from] = 0;
    pq.offer(new Pair(from, 0));
    run();    
    System.out.println(costs[to]);
  }

  private static void run()
  {
    while(!pq.isEmpty())
    {
      int v = pq.peek().v;
      int cost = pq.peek().cost;
      pq.poll();

      if(visited[v]) continue;
      visited[v] = true;
      for(int i=0; i<graph.get(v).size(); ++i)
      {
        int v2 = graph.get(v).get(i).v;
        int cost2 = graph.get(v).get(i).cost;

        if(costs[v2] > cost + cost2)
        {
          costs[v2] = cost + cost2;
          pq.offer(new Pair(v2, costs[v2]));
        }
      }
    }
  }
}
