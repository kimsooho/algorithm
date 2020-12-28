#include <iostream>

using namespace std;

int fib(int num)
{
  if (num < 2)
  {
    return num;
  }

  return fib(num - 2) + fib(num - 1);
}

int main()
{
  int num;
  cin >> num;

  cout << fib(num) << "\n";
}