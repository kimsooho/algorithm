#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, M, input;
  vector<int> v;

  cin >> N;
  while(N--)
  {
    cin >> input;
    v.push_back(input);
  }

  sort(v.begin(), v.end());

  cin >> M;
  while(M--)
  {
    cin >> input;

    cout << upper_bound(v.begin(), v.end(), input) - lower_bound(v.begin(), v.end(), input) << "\n";
  }
}