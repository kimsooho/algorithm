#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
  int testCase, first, second;

  vector<pair<int, int>> v;
  cin >> testCase;

  while (testCase--)
  {
    cin >> first >> second;
    pair<int, int> p;
    p.first = first;
    p.second = second;

    v.push_back(p);
  }

  sort(v.begin(), v.end(), [](pair<int, int> a, pair<int, int> b) {
    if(a.second == b.second)
      return a.first < b.first;
    return a.second < b.second;
  });

  for(vector<pair<int, int>>::iterator iter = v.begin(); iter != v.end(); ++iter)
  {
    cout << iter->first << " " << iter->second << "\n";
  }
}