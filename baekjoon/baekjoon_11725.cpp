#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> v;
vector<bool> visited;
vector<int> parent;
void dfs(int);

int main()
{
  int N, from, to;

  cin >> N;

  v.resize(N + 1);
  visited.resize(N + 1, false);
  parent.resize(N + 1, 0);

  while (--N)
  {
    cin >> from >> to;

    v[from].push_back(to);
    v[to].push_back(from);
  }

  dfs(1);

  for (vector<int>::iterator iter = parent.begin() + 2; iter != parent.end(); ++iter)
  {
    cout << *iter << "\n";
  }
}

void dfs(int V)
{
  visited[V] = true;

  for (vector<int>::iterator iter = v[V].begin(); iter != v[V].end(); ++iter)
  {
    if (!visited[*iter])
    {
      parent[*iter] = V;
      dfs(*iter);
    }
  }
}