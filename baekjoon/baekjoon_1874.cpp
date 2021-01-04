#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main()
{
  int count, num;
  stack<int> s;
  vector<string> v;
  cin >> count;

  for (int i = 0, j = 1; i < count; ++i)
  {
    cin >> num;

    if (s.empty() || s.top() < num)
    {
      for (; j <= num;)
      {
        s.push(j++);
        v.push_back("+");
      }
    }
    else if (s.top() != num)
    {
      cout << "NO" << endl;
      return 0;
    }

    s.pop();
    v.push_back("-");
  }

  for (vector<string>::iterator iter = v.begin(); iter != v.end(); ++iter)
  {
    cout << *iter << "\n";
    // ** 시간 초과 : cout << *iter << endl; 
  }
}