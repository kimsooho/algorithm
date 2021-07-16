#include <string>
#include <vector>

using namespace std;

vector<bool> visited;

long long solution(vector<int> a, vector<vector<int>> edges)
{
  long long answer = -1;
  int cnt = 0;
  for (int i = 0; i < a.size(); ++i)
  {
    cnt += a[i];
  }
  if (cnt != 0)
    return -1;

  vector<vector<int>> v;
  visited.resize(a.size(), false);
  v.resize(a.size());

  for(int i=0; i<edges.size(); ++i)
  {
    v[edges[i][0]].push_back(edges[i][1]);
    v[edges[i][1]].push_back(edges[i][0]);
  }

  return answer;
}