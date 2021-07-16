#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, K, input;
  vector<int> v;
  cin >> N >> K;

  while(N--)
  {
    cin >> input;
    v.push_back(input);
  }

  sort(v.begin(), v.end());

  cout << v[K-1] << "\n";
}