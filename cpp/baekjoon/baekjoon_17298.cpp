#include <iostream>
#include <stack>
using namespace std;

int main()
{
  int count, num, max = -1;
  stack<int> s;
  cin >> count;

  while (count--)
  {
    cin >> num;
    s.push(num);
  }

  while(!s.empty())
  { 
    if(max <= s.top())
    {
      cout << -1 << " ";
      max = s.top();
    }
    else
    {
      cout << max << " ";
    }
    
    s.pop();
  }
}