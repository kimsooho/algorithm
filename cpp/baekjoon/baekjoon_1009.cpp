/**
 * @author suho kim
 * @no 1009
 * @title 분산처리
 * @url https://www.acmicpc.net/problem/1009
 * @date 2021.11.01
 */
#include <iostream>
using namespace std;
int main()
{
  int t, a, b, result;
  cin >> t;
  while (t--)
  {
    cin >> a >> b;
    result = a;
    b = b % 4 + 4;
    for (int i = 1; i < b; ++i)
    {
      result = (result * a) % 10;
    }
    if (result == 0)
      result = 10;
    cout << result << endl;
  }
}