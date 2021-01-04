#include <iostream>
#include <queue>

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
  queue<int> q;

  cin >> testCase;

  while (testCase--)
  {
    cin >> cmd;

    if(!cmd.compare("push"))
    {
      cin >> num;
      q.push(num);
    }
    else if (!cmd.compare("pop"))
    {
      cout << (q.empty() ? -1 : q.front()) << "\n";
      if(!q.empty()) q.pop();
    }
    else if (!cmd.compare("size"))
    {
      cout << q.size() << "\n";
    }
    else if (!cmd.compare("empty"))
    {
      cout << (q.empty() ? 1 : 0) << "\n";
    }
    else if (!cmd.compare("front"))
    {
      cout << (q.empty() ? -1 : q.front()) << "\n";
      
    }
    else if (!cmd.compare("back"))
    {
      cout << (q.empty() ? -1 : q.back()) << "\n";
    }
  }
}