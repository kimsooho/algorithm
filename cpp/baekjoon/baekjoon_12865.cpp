#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  int N, K, W, V;
  vector<pair<int ,int>> v;
  vector<vector<int>> mem;
  cin >> N >> K;

  v.resize(N+1);
  mem.resize(N+1, vector<int>(K+1, 0));

  for(int i=1; i<N+1; ++i)
  {
    cin >> W >> V;
    v[i] = make_pair(W, V);
  }

  for(int i=1; i<N+1; ++i)
  {
    for(int j=1; j<K+1; ++j)
    {
      int wei = v[i].first;
      int val = v[i].second;

      if(wei > j)
      {
        mem[i][j] = mem[i-1][j];
      }
      else
      {
        mem[i][j] = max(mem[i-1][j], mem[i-1][j-wei] + val);
      }
    }
  }

  cout << mem[N][K];
}