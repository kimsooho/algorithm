/**
 * @author suho kim
 * @no 1753
 * @title 최단경로
 * @url https://www.acmicpc.net/problem/1753
 * @date 2021.08.24
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair
{
  int v;
  int weight;
  public Pair(int v, int weight)
  {
    this.v = v;
    this.weight = weight;
  }
}

public class Main {
  static final int INF = Integer.MAX_VALUE;
  static int[] weight;  

  static ArrayList<ArrayList<Pair>> map;
  static PriorityQueue<Pair> pq;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());    

    pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
      @Override
      public int compare(Pair o1, Pair o2) {        
        return o1.weight - o2.weight;
      }
    });
    weight = new int[V + 1];    
    Arrays.fill(weight, INF);
    map = new ArrayList<ArrayList<Pair>>();

    st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    
    for(int i=0; i<V+1; ++i)
    {
      map.add(new ArrayList<Pair>());
    }

    for(int i=0; i<E; ++i)
    {
      st = new StringTokenizer(br.readLine());
      map.get(Integer.parseInt(st.nextToken())).add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    weight[K] = 0;
    pq.offer(new Pair(K, 0));

    bfs();

    for(int i=1; i<V+1; ++i)
    {
      System.out.println(weight[i] == INF ? "INF" : weight[i]);
    }
  }

  private static void bfs()
  {
    while(!pq.isEmpty())
    {
      int v = pq.peek().v;
      int w = pq.peek().weight;
      pq.poll();

      for(int i=0; i<map.get(v).size(); ++i)
      {
        int v2 = map.get(v).get(i).v;
        int w2 = map.get(v).get(i).weight;

        if(weight[v2] > w + w2)
        {
          weight[v2] = w + w2;
          pq.offer(new Pair(v2, weight[v2]));
        }
      }
    }
  }
}
