#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;

int search(int);
int main()
{
  cin.tie(0);
  cin.sync_with_stdio(false);

  int N, M, input;

  cin >> N;
  while (N--)
  {
    cin >> input;
    v.push_back(input);
  }
  sort(v.begin(), v.end());

  cin >> M;

  while (M--)
  {
    cin >> input;
    cout << binary_search(v.begin(), v.end(), input) << "\n";
  }
}

int search(int num)
{
  int l = 0, r = v.size() - 1;
  while (l <= r)
  {
    int m = (l + r) / 2;
    if (v[m] > num)
    {
      r = m - 1;
    }
    else if (v[m] < num)
    {
      l = m + 1;
    }
    else
    {
      return 1;
    }
  }
  return 0;
}
