#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main()
{
  int N, K;
  queue<int> q;
  vector<int> v;
  cin >> N >> K;

  
  for(int i=1; i<=N; ++i)
    q.push(i);
  int cnt = 0;
  do
  {
    ++cnt;
    int num = q.front();
    q.pop();
    if(cnt == K)
    {
      cnt = 0;
      v.push_back(num);
    }
    else
    {
      q.push(num);
    }
    
  } while (!q.empty());
  
  cout << "<";
  for(vector<int>::iterator iter = v.begin(); iter != v.end(); ++iter)
  {
    cout << *iter;
    if(iter != v.end() - 1)
      cout << ", ";
  }
  cout << ">";
}