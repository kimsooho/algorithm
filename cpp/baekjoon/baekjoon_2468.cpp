#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<vector<int>> mapSource;
vector<vector<int>> mapCopy;
vector<int> islands;

queue<pair<int, int>> q;

int xAxis[] = {-1, 1, 0, 0};
int yAxis[] = {0, 0, -1, 1};

void bfs(int);

int main()
{
  int N, input, maxVal = -1;
  cin >> N;

  mapSource.resize(N);

  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < N; ++j)
    {
      cin >> input;
      maxVal = max(maxVal, input);
      mapSource[i].push_back(input);
    }
  }
  islands.resize(maxVal + 1);
  for (int i = 0; i <= maxVal; ++i)
  {
    mapCopy.clear();
    mapCopy.assign(mapSource.begin(), mapSource.end());

    for (int y = 0; y < N; ++y)
    {
      for (int x = 0; x < N; ++x)
      {
        if (mapCopy[y][x] > i)
        {
          q.push(make_pair(y, x));
          ++islands[i];
          bfs(i);
        }
      }
    }
  }

  sort(islands.begin(), islands.end());

  cout << *(islands.end() - 1) << "\n";
}

void bfs(int height)
{
  while (!q.empty())
  {
    int y = q.front().first;
    int x = q.front().second;
    q.pop();

    for (int i = 0; i < 4; ++i)
    {
      int nextY = y + yAxis[i];
      int nextX = x + xAxis[i];

      if (nextY < 0 || nextX < 0 || nextY > mapCopy.size() - 1 || nextX > mapCopy[0].size() - 1 || mapCopy[nextY][nextX] <= height)
        continue;

      mapCopy[nextY][nextX] = 0;
      q.push(make_pair(nextY, nextX));
    }
  }
}