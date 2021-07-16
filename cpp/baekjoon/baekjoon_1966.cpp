#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main()
{
  int testCase, N, M, num;
  cin >> testCase;
  while (testCase--)
  {
    queue<pair<int, int>> q;
    priority_queue<int/*, vector<int>, less<int>*/> pq;
    vector<int> v;
    int count = 0;

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
      cin >> num;
      q.push(make_pair(num, i));
      pq.push(num);
    }
    while (true)
    {
      num = q.front().first;
      int idx = q.front().second;
      q.pop();
      if (num == pq.top())
      {
        ++count;
        if (idx == M)
        {
          cout << count << "\n";
          break;
        }
        pq.pop();
      }
      else
      {
        q.push(make_pair(num, idx));
      }
    }
  }
}