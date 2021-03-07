#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> map;
vector<vector<int>> weight;
void bfs();
int main()
{
  int N, M, input;  
  
  cin >> N >> M;

  map.resize(N+1);
  weight.resize(N+1);
  for(int i=0; i <= N; ++i)
  {
    map[i].resize(M+1);
    weight[i].resize(M+1);
  }

  for(int i=1; i<=N; ++i)
  {
    for(int j=1; j<=M; ++j)
    {
      cin >> input;
      map[i][j] = input;
    }
  }

  weight[1][1] = map[1][1];

  for(int i=1; i<=N; ++i)
  {
    for(int j=1; j<=M; ++j)
    {
      weight[i][j] = max(max(weight[i-1][j], weight[i][j-1]), weight[i-1][j-1]) + map[i][j];
    }
  }
  cout << weight[N][M];
}