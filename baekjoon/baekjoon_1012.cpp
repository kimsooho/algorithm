#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<vector<int>> map;
queue<pair<int, int>> q;

int xAxis[] = {-1, 0, 1, 0};
int yAxis[] = {0, -1, 0, 1};

void bfs();

int main()
{
  int T /* 테스트 케이스 */, M /* 가로 */, N /* 세로 */, K /* 그래프 수 */, X, Y;

  cin >> T;

  while (T--)
  {
    int count = 0;
    cin >> M >> N >> K;

    map.clear();
    map.resize(N);

    for (int i = 0; i < N; ++i)
    {
      for (int j = 0; j < M; ++j)
      {
        map[i].push_back(0);
      }
    }

    for (int i = 0; i < K; ++i)
    {
      cin >> X >> Y;
      map[Y][X] = 1;
    }

    for (int i = 0; i < N; ++i)
    {
      for (int j = 0; j < M; ++j)
      {
        if (map[i][j] == 1)
        {
          map[i][j] = 0;
          
          q.push(make_pair(i, j));
          ++count;
          bfs();
        }
      }
    }

    cout << count << "\n";
  }
}

void bfs()
{
  while (!q.empty())
  {    
    int y = q.front().first;
    int x = q.front().second;

    q.pop();

    for (int i = 0; i < 4; ++i)
    {
      int nextX = x + xAxis[i];
      int nextY = y + yAxis[i];

      if (nextX < 0 || nextY < 0 || nextX > map[0].size() - 1 || nextY > map.size() - 1 || map[nextY][nextX] != 1)
        continue;
      
      map[nextY][nextX] = 0;
      q.push(make_pair(nextY, nextX));
    }
  }
}