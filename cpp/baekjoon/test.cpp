#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
  int n;
  vector<int> v;
  vector<int> tmp;
  int num;
  cin >> n;
  while (n--)
  {
    cin >> num;
    v.push_back(num);
    tmp.push_back(0);
  }
  tmp[0] = v[0];
  int MAX = tmp[0];
  for (int i = 1; i < v.size(); ++i)
  {
    tmp[i] = max(tmp[i - 1] + v[i], v[i]);
    MAX = max(MAX, tmp[i]);
  }

  for (int i = 0; i < tmp.size(); ++i)
  {
    cout << tmp[i] << " ";
  }
  cout << MAX;
}