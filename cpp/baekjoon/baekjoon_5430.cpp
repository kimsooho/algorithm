#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>
#include <deque>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int testcase, p;
  string inputStr, inputNum;
  deque<int> dq;

  cin >> testcase;

  while (testcase--)
  {
    dq.clear();
    bool isError = false;
    bool isReverse = false;
    cin >> inputStr >> p >> inputNum;

    string num = "";
    for (int i = 0; i < inputNum.size() && p != 0; ++i)
    {
      if (inputNum[i] == '[')
        continue;

      if (inputNum[i] == ',' || inputNum[i] == ']')
      {
        dq.push_back(stoi(num));
        num = "";
        continue;
      }

      num += inputNum[i];
    }

    for (string::iterator iter = inputStr.begin(); iter != inputStr.end(); ++iter)
    {
      if (*iter == 'R')
      {
        isReverse = !isReverse;
      }
      else if (*iter == 'D')
      {
        if (dq.empty())
        {
          isError = true;
          break;
        }

        if (isReverse)
          dq.pop_back();
        else
          dq.pop_front();
      }
    }

    if (isError)
    {
      cout << "error"
           << "\n";
    }
    else
    {
      cout << "[";
      if (isReverse)
      {
        for (deque<int>::reverse_iterator iter = dq.rbegin(); iter != dq.rend(); ++iter)
        {
          cout << *iter;
          if (iter != dq.rend() - 1)
          {
            cout << ",";
          }
        }
      }
      else
      {
        for (deque<int>::iterator iter = dq.begin(); iter != dq.end(); ++iter)
        {
          cout << *iter;
          if (iter != dq.end() - 1)
          {
            cout << ",";
          }
        }
      }
      cout << "]\n";
    }
  }
}