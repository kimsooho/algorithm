#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> map;

int xAxis[] = {0, 0, -1, 1};
int yAxis[] = {-1, 1, 0, 0};

int main()
{
  int T /* 테스트 케이스 */, N /* 행 & 열 */, D /* 방향 */, W /* 소금쟁이 */;
  int x, y;
  cin >> T;

  while (T--)
  {
    cin >> N >> W;
    int saveW = W;
    map.clear();
    map.resize(N);
    for (int i = 0; i < N; ++i)
    {
      for (int j = 0; j < N; ++j)
      {
        map[i].push_back(0);
      }
    }

    while (W--)
    {
      cin >> y >> x >> D;
      for (int i = 3; i > 0; --i)
      {
        x = x + xAxis[D - 1] * i;
        y = y + yAxis[D - 1] * i;

        if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || map[y][x] != 0)
        {
          --saveW;
          break;
        }

        if (i == 1)
        {
          map[y][x] = 1;
        }
      }
    }
    cout << "Alive : " << saveW << "\n\n";

    for (int i = 0; i < N; ++i)
    {
      for (int j = 0; j < N; ++j)
      {
        cout << map[i][j] << " ";
      }
      cout << endl;
    }
  }
}