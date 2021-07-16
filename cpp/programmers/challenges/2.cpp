#include <string>
#include <vector>

using namespace std;

int solution(string s)
{
  int answer = 0;

  int size = s.size();
  while (size--)
  {
    int smallCnt = 0;
    int middleCnt = 0;
    int bigCnt = 0;

    bool isSuccess = true;

    for (int i = 0; i < s.size(); ++i)
    {
      if (smallCnt < 0 || middleCnt < 0 || bigCnt < 0)
      {
        isSuccess = false;
        break;
      }

      if (s[i] == '(')
        ++smallCnt;
      else if (s[i] == '{')
        ++middleCnt;
      else if (s[i] == '[')
        ++bigCnt;
      else if (s[i] == ')')
        --smallCnt;
      else if (s[i] == '}')
        --middleCnt;
      else if (s[i] == ']')
        --bigCnt;
    }
    string ap(1, s[0]);
    s.append(ap);
    s.erase(0,1);

    if (isSuccess && !(smallCnt | middleCnt | bigCnt))
    {
      answer++;
    }
  }

  return answer;
}

int main()
{
}