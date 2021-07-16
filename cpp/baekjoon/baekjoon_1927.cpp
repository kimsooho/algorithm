#include <iostream>
#include <queue>

using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  priority_queue<int, vector<int>, greater<int>> pq;

  int n, input;
  cin >> n;

  while(n--)
  {
    cin >> input;

    if(input == 0)
    {
      if(pq.empty())
      {
        cout << 0 << "\n";
      }
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