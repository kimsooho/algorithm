#include <iostream>
#include <queue>
#include <vector>

using namespace std;

queue<int> q;
vector<int> visited;

void bfs(int);

int main()
{
  int N, K;
  cin >> N >> K;

  visited.resize(100001, -1);

  q.push(N);
  visited[N] = 0;
  bfs(100001);

  cout << visited[K] << "\n";

  return 0;
}

void bfs(int K)
{
  while (!q.empty())
  {    
    int N = q.front();
    q.pop();

    if (N == K) return;

    if (N - 1 >= 0 && visited[N - 1] == -1)
    {
      visited[N - 1] = visited[N] + 1;
      q.push(N - 1);
    }
    if (N + 1 <= K && visited[N + 1] == -1)
    {
      visited[N + 1] = visited[N] + 1;
      q.push(N + 1);
    }

    if (N * 2 <= K && visited[N * 2] == -1)
    {
      visited[N * 2] = visited[N] + 1;
      q.push(N * 2);
    }
  }
}