#include <iostream>
#include <stack>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<vector<int>> map;
vector<bool> visitDFS;
vector<bool> visitBFS;
queue<int> q;

void dfs(int);
void bfs(int);

int main()
{
  int N, M, V, N1, N2;

  cin >> N >> M >> V;

  map.resize(N + 1);
  visitDFS.resize(N + 1, false);
  visitBFS.resize(N + 1, false);
  for (int i = 0; i < M; ++i)
  {
    cin >> N1 >> N2;
    map[N1].push_back(N2);
    map[N2].push_back(N1);
  }
  
  for(int i=0; i<map.size(); ++i)
  {
    sort(map[i].begin(), map[i].end());
  }

  dfs(V);
  cout << "\n";  
  bfs(V);
}

void dfs(int V)
{
  visitDFS[V] = true;
  cout << V << " ";

  for (int i = 0; i < map[V].size(); ++i)
  {
    if(!visitDFS[map[V][i]])
      dfs(map[V][i]);
  }
}

void bfs(int V)
{
  visitBFS[V] = true;
  cout << V << " ";

  for(int i=0; i<map[V].size(); ++i)
  {
    if(!visitBFS[map[V][i]])
      q.push(map[V][i]);
  }

  while(!q.empty())
  {
    int front = q.front();
    q.pop();
    if(!visitBFS[front])
      bfs(front);
  }
}