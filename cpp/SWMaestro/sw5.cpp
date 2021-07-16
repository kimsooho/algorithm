#include <vector>
#include <algorithm>
#include <iostream>
#include <map>

using namespace std;

int main()
{
  int n, s, k, t;
  vector<int> v;
  map<int, vector<int>> map;
  cin >> n;
  v.resize(n+1, 0);
  for(int i=1; i<=n*n; ++i)
  {
    cin >> s >> k;    
    while(k--)
    {
      cin >> t;
      if(map.count(t) == 0)
      {
        map.insert(make_pair(t, vector<int>()));
      }

      map.find(t)->second.push_back(s);
    }
  }


  for(int i=0; map.size(); ++i)
  {
    map.find(i)
  }
}