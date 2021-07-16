#include <iostream>
#include <math.h>

using namespace std;

bool isPrime(int);

int main()
{
  int M, N, sum = 0, min = -1;

  cin >> M >> N;
  for (; M <= N; ++M)
  {
    if (isPrime(M))
    {
      sum += M;
      if (min == -1)
        min = M;
    }
  }
  if (sum == 0)
  {
    cout << "-1";
  }
  else
  {
    cout << sum << "\n"
         << min << "\n";
  }
}

bool isPrime(int n)
{
  if (n < 2)
    return false;
  if (n == 2)
    return true;

  if (n % 2 == 0)
    return false;

  int root = sqrt(n);

  for (int i = 3; i <= root; i += 2)
  {
    if (n % i == 0)
    {
      return false;
    }
  }
  return true;
}