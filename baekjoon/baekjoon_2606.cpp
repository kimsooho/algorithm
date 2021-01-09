#include <iostream>
#include <stack>
#include <vector>

using namespace std;

vector<vector<int>> map;
vector<bool> visit;
int retValue = 0;

void dfs(int num)
{
  visit[num] = true;

  for (int i = 0; i < map[num].size(); ++i)
  {
    if (!visit[map[num][i]])
    {
      ++retValue;
      dfs(map[num][i]);
    }
  }

  return;
}

int main()
{
  int com_count, pair_count, src, dest;

  cin >> com_count;

  map.resize(com_count + 1);
  visit.resize(com_count + 1, false);

  cin >> pair_count;
  for (int i = 0; i < pair_count; ++i)
  {
    cin >> src >> dest;

    map.at(src).push_back(dest);
    map.at(dest).push_back(src);
  }

  dfs(1);

  cout << retValue;
}