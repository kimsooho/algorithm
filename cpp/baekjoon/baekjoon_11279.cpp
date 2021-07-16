#include <iostream>
#include <queue>

using namespace std;

int main()
{
  /*
    11, 12 행 추가 - 시간 초과 해결
  */
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int N, input;
  priority_queue<int> pq;

  cin >> N;

  while (N--)
  {
    cin >> input;

    if (input == 0)
    {
      if (pq.empty())
        cout << 0 << "\n";
      else
      {
        cout << pq.top() << "\n";
        pq.pop();
      }
    }
    else
    {
      pq.push(input);
    }
  }
}