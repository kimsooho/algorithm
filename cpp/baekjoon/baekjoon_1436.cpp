#include <iostream>
#include <string>

using namespace std;

int main()
{
  int N, index = 0, num = 665;

  cin >> N;

  while (true)
  {
    if (index == N)
    {
      cout << num;
      break;
    }

    ++num;

    if (to_string(num).find("666") != string::npos)
    {
      index++;
    }
  }
}