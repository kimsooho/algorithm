#include <iostream>
#include <deque>

using namespace std;

int main()
{
  /*
    11, 12행 : 시간 초과 문제 해결
  */
  cin.tie(0);
	cin.sync_with_stdio(false);
  

  int testCase, num;
  string cmd;
  deque<int> dq;

  cin >> testCase;

  while (testCase--)
  {
    cin >> cmd;

    if(!cmd.compare("push_front"))
    {
      cin >> num;
      dq.push_front(num);
    }
    if(!cmd.compare("push_back"))
    {
      cin >> num;
      dq.push_back(num);
    }
    else if (!cmd.compare("pop_front"))
    {
      cout << (dq.empty() ? -1 : dq.front()) << "\n";
      if(!dq.empty()) dq.pop_front();
    }
    else if (!cmd.compare("pop_back"))
    {
      cout << (dq.empty() ? -1 : dq.back()) << "\n";
      if(!dq.empty()) dq.pop_back();
    }
    else if (!cmd.compare("size"))
    {
      cout << dq.size() << "\n";
    }
    else if (!cmd.compare("empty"))
    {
      cout << (dq.empty() ? 1 : 0) << "\n";
    }
    else if (!cmd.compare("front"))
    {
      cout << (dq.empty() ? -1 : dq.front()) << "\n";
      
    }
    else if (!cmd.compare("back"))
    {
      cout << (dq.empty() ? -1 : dq.back()) << "\n";
    }
  }
}