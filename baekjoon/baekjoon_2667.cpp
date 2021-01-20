#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> map;
queue<pair<int, int>> q;

int xAxis[] = {-1, 0, 1, 0};
int yAxis[] = {0, -1, 0, 1};
int bfs();

int main()
{
  int N;
  int input;
  vector<int> v;

  cin >> N;

  map.resize(N);

  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < N; ++j)
    {
      scanf("%1d", &input);
      map[i].push_back(input);
    }
  }

  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < N; ++j)
    {
      if (map[i][j] == 1)
      {      
        map[i][j] = 0;

        q.push(make_pair(i, j));
        v.push_back(bfs());        
      }
    }
  }

  sort(v.begin(), v.end());

  cout << v.size() << "\n";
  for(vector<int>::iterator iter = v.begin(); iter != v.end(); ++iter)
    cout << *iter << "\n";
}

int bfs()
{
  int count = 0;
  while (!q.empty())
  {
    int x = q.front().first;
    int y = q.front().second;
    
    q.pop();
    ++count;

    for (int i = 0; i < 4; ++i)
    {
      int nextX = x + xAxis[i];
      int nextY = y + yAxis[i];
      
      if (nextX < 0 || nextY < 0 || nextY > map[0].size() - 1 || nextX > map.size() - 1 || map[nextX][nextY] != 1)
        continue;

      map[nextX][nextY] = 0;
      q.push(make_pair(nextX, nextY));
    }
  }
  return count;
}
