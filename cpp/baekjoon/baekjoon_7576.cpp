#include <iostream>
#include <queue>

using namespace std;

int xAxis[] = {-1, 0, 1, 0};
int yAxis[] = {0, -1, 0, 1};

vector<vector<int>> vMap;
queue<pair<int, int>> q;

void bfs();

int main()
{
  int M /*가로*/, N /*세로*/;
  int input;
  cin >> M >> N;

  vMap.resize(N);

  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < M; ++j)
    {
      cin >> input;
      if (input == 1)
      {
        q.push(make_pair(i, j));
      }
      vMap[i].push_back(input);
    }
  }

  bfs();

  int retValue = -1;

  for (int i = 0; i < vMap.size(); ++i)
  {
    for (int j = 0; j < vMap[i].size(); ++j)
    {
      if (vMap[i][j] == 0)
      {
        cout << -1 << "\n";
        return 0;
      }

      retValue = max(vMap[i][j], retValue);
    }
  }

  cout << retValue - 1 << "\n";
}

void bfs()
{
  while (!q.empty())
  {
    int x = q.front().first;
    int y = q.front().second;
    q.pop();
    
    for (int i = 0; i < 4; ++i)
    {
      int nextX = x + xAxis[i];
      int nextY = y + yAxis[i];

      if (
          nextX < 0 || nextY < 0 ||
          nextX > vMap.size() - 1 || nextY > vMap[0].size() - 1 ||
          vMap[nextX][nextY] != 0
        )
        continue;

      vMap[nextX][nextY] = vMap[x][y] + 1;
      q.push(make_pair(nextX, nextY));
    }
  }
}