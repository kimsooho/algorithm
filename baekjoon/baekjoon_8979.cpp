#include <iostream>
#include <vector>

using namespace std;

int main()
{
  vector<vector<int>> v;
  int N, K, input, team;

  cin >> N >> K;
  v.resize(N + 1);

  while (N--)
  {
    cin >> team;
    for (int i = 0; i < 3; ++i)
    {
      cin >> input;
      v[team].push_back(input);
    }
  }
  int rank = 1;
  for (vector<vector<int>>::iterator iter = v.begin() + 1; iter != v.end(); ++iter)
  {
    if (iter - v.begin() == K)
      continue;

    for (int i = 0; i < 3; ++i)
    {
      if ((*iter)[i] < v[K][i]) break;
      if ((*iter)[i] > v[K][i])
      {        
        ++rank;
        break;
      }
    }
  }

  cout << rank << "\n";
}