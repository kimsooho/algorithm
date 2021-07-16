#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<vector<int>> map;
vector<vector<bool>> visited;
queue<pair<int, int>> q;

int xAxis[] = {-1, 0, 1, 0};
int yAxis[] = {0, -1, 0, 1};

int bfs();

int main()
{
  int N, M, input;

  cin >> N >> M;

  map.resize(N);
  visited.resize(N);

  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < M; ++j)
    {
      scanf("%1d", &input);
      map[i].push_back(input);
      visited[i].push_back(false);
    }
  }

  visited[0][0] = true;
  q.push(make_pair(0, 0));

  cout << bfs() << "\n";

  cout << endl;
}

int bfs()
{
  while (!q.empty())
  {
    int y = q.front().first;
    int x = q.front().second;
    q.pop();

    if (y == map.size() - 1 && x == map[0].size() - 1)
    {
      return map[y][x];
    }

    for (int i = 0; i < 4; ++i)
    {
      int nextY = y + yAxis[i];
      int nextX = x + xAxis[i];

      if (nextX < 0 || nextY < 0 || nextX > map[0].size() - 1 || nextY > map.size() - 1 || map[nextY][nextX] == 0 || visited[nextY][nextX])
        continue;

      map[nextY][nextX] = map[y][x] + 1;
      visited[nextY][nextX] = true;
      q.push(make_pair(nextY, nextX));
    }
  }

  return -1;
}