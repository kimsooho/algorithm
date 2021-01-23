#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<char>> RGBmap;
vector<vector<char>> RGBmapCopy;

queue<pair<int, int>> q;

int xAxis[] = {-1, 1, 0, 0};
int yAxis[] = {0, 0, -1, 1};

void bfs(char, bool);

int main()
{
  int N, count;
  string input;

  cin >> N;

  RGBmap.resize(N);

  for (int i = 0; i < N; ++i)
  {
    cin >> input;

    for (string::iterator iter = input.begin(); iter != input.end(); ++iter)
    {
      RGBmap[i].push_back(*iter);
    }
  }

  RGBmapCopy.clear();
  RGBmapCopy.assign(RGBmap.begin(), RGBmap.end());
  count = 0;
  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < N; ++j)
    {
      if (RGBmapCopy[i][j] != '-')
      {
        ++count;
        q.push(make_pair(i, j));
        bfs(RGBmapCopy[i][j], false);
      }
    }
  }
  cout << count << " ";

  RGBmapCopy.clear();
  RGBmapCopy.assign(RGBmap.begin(), RGBmap.end());
  count = 0;
  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < N; ++j)
    {
      if (RGBmapCopy[i][j] != '-')
      {
        ++count;
        q.push(make_pair(i, j));
        bfs(RGBmapCopy[i][j], true);
      }
    }
  }

  cout << count << "\n";
}

void bfs(char RGB, bool isDaltonism)
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

      if (nextY < 0 || nextX < 0 || nextY > RGBmapCopy.size() - 1 || nextX > RGBmapCopy[0].size() - 1 || RGBmapCopy[nextY][nextX] == '-' ||
                  ((isDaltonism && RGB != 'B')
              ? RGBmapCopy[nextY][nextX] == 'B'
              : RGBmapCopy[nextY][nextX] != RGB))      
        continue;

      RGBmapCopy[nextY][nextX] = '-';
      q.push(make_pair(nextY, nextX));
    }
  }
}