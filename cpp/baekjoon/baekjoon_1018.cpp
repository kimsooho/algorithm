#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main()
{
  string input;
  vector<string> v;
  int minValue = 2500, count, N, M;

  cin >> N >> M;

  for (int i = 0; i < N; ++i)
  {
    cin >> input;
    v.push_back(input);
  }

  for (int i = 0; i < N - 7; ++i)
  {
    for (int j = 0; j < M - 7; ++j)
    {
      for (int k = 0; k < 2; ++k)
      {
        count = 0;
        for (int ii = i; ii < 8 + i; ++ii)
        {
          for (int jj = j; jj < 8 + j; ++jj)
          {
            char c = (ii + jj + k) % 2 == 0 ? 'W' : 'B';
            string str = v[ii];
            if (str[jj] != c)
            {
              ++count;
            }
          }
        }
        minValue = min(count, minValue);
      }
    }
  }

  cout << minValue << "\n";
}