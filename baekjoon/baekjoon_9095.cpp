#include <iostream>
#include <vector>

using namespace std;

int dfs(int);

int N;

int main()
{
  int T;
  cin >> T;

  while(T--)
  {
    cin >> N;
    cout << dfs(0) << endl;
  }
}

int dfs(int num)
{
  if(num == N)
    return 1;
  else if(num > N)
    return 0;
  else
  {
    return dfs(num + 1) + dfs(num + 2) + dfs(num + 3);
  } 
}