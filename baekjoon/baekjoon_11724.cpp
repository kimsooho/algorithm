#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> v;
vector<bool> visited;

void dfs(int);

int main()
{
  int N, M, U, V, count = 0;

  cin >> N >> M;

  v.resize(N + 1);
  visited.resize(N + 1, false);

  for (int i = 0; i < M; ++i)
  {
    cin >> U >> V;
    v[U].push_back(V);
    v[V].push_back(U);
  }

  for (vector<bool>::iterator iter = visited.begin() + 1; iter != visited.end(); ++iter)
  {
    if (!(*iter))
    {
      ++count;
      dfs(distance(visited.begin(), iter));
    }
  }

  cout << count << "\n";
}

void dfs(int V)
{
  visited[V] = true;

  for (vector<int>::iterator iter = v[V].begin(); iter != v[V].end(); ++iter)
  {
    if (!visited[*iter])
      dfs(*iter);
  }
}