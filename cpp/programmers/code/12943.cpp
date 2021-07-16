#include <string>
#include <vector>

using namespace std;

int solution(int num)
{
  int answer = 0;
  long long n = num;
  while (answer < 500)
  {
    if (n == 1)
      break;
    ++answer;
    n = n & 1 ? n * 3 + 1 : n / 2;
  }
  return answer == 500 ? -1 : answer;
}