#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<bool> visited;
queue<int> q;

int solution(int n, vector<vector<int>> computers);
void bfs(vector<vector<int>>);
int main()
{
  vector<vector<int>> v = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
  cout << solution(3, v);
}

int solution(int n, vector<vector<int>> computers)
{
  int answer = 0;
  visited.resize(n, false);  

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (!visited[j] && computers[i][j] != 0)
      {
        q.push(j);
        bfs(computers);
        ++answer;
      }
    }
  }
  return answer;
}

void bfs(vector<vector<int>> v)
{
  while (!q.empty())
  {    
    int idx = q.front();    
    visited[idx] = true;
    q.pop();

    for(int i=0; i<v[idx].size(); ++i)
    {
      if(!visited[i] && v[idx][i] != 0)
      {
        q.push(i);
      }
    }
  }
}