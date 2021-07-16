#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> v;

int main()
{
  int N, input;
  cin >> N;

  for(int i=1; i<=N; ++i)
  {
    cin >> input;
    v[i].push_back(input);
    v[input].push_back(i);
  }


  for(int i=0; i<v.size(); ++i)
  {
    
  }
}