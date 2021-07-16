#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> map;
queue<pair<int, int>> q;

int xAxis[] = {-1, 1, 0, 0, 1, 1, -1, -1};
int yAxis[] = {0, 0, -1, 1, -1, 1, 1, -1};

void bfs();

int main()
{
  int w, h, input, count;

  while (true)
  {
    cin >> w >> h;

    if (w == 0 && h == 0)
      break;

    count = 0;

    map.clear();
    map.resize(h);

    for (int i = 0; i < h; ++i)
    {
      for (int j = 0; j < w; ++j)
      {
        cin >> input;
        map[i].push_back(input);
      }
    }

    for (int i = 0; i < h; ++i)
    {
      for (int j = 0; j < w; ++j)
      {
        if (map[i][j] == 1)
        {
          ++count;
          q.push(make_pair(i, j));
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
    int h = q.front().first;
    int w = q.front().second;
    q.pop();
    for (int i = 0; i < 8; ++i)
    {
      int nextX = w + xAxis[i];
      int nextY = h + yAxis[i];
      
      if (nextX < 0 || nextY < 0 || nextX > map[0].size() - 1 || nextY > map.size() - 1 || map[nextY][nextX] != 1)
        continue;

      map[nextY][nextX] = 0;
      q.push(make_pair(nextY, nextX));
    }
  }
}