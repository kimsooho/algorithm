#include <iostream>
#include <queue>

using namespace std;

int main(int argc, const char **argv)
{
  queue<int> q;
  int num;
  cin >> num;

  for (int i = 1; i <= num; ++i)
  {
    q.push(i);
  }

  while (q.size() > 1)
  {
    q.pop();
    q.push(q.front());
    q.pop();
  }

  cout << q.front() << "\n";
}