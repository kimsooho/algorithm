#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
  vector<int> v;
  int n, input;
  cin >> n;

  while(n--)
  {
    cin >> input;
    v.push_back(input);
  }

  sort(v.begin(), v.end());

  v.erase(unique(v.begin(), v.end()), v.end());

  for(vector<int>::iterator iter = v.begin(); iter != v.end(); ++iter)
  {
    cout << *iter << " ";
  }
}