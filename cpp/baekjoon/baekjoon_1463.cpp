#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  vector<int> v;
  int N;
  cin >> N;
  int MAXNUM = 1000001;
  v.resize(N+1, MAXNUM);
  v[N] = 0;
  for(int i=N; i > 0; --i)
  {
    //if(v[i] == MAXNUM) continue;
    if(i%3 == 0) v[i/3] = min(v[i/3], v[i] + 1);
    if(i%2 == 0) v[i/2] = min(v[i/2], v[i] + 1);
    if(i > 1) v[i-1] = min(v[i-1], v[i] + 1);
  }

  cout << v[1];
}