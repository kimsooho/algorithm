#include <vector>
#include <iostream>

using namespace std;

int main()
{
  vector<bool> visited;
  vector<int> v;
  int n, input, ret = 0;

  cin >> n;
  visited.resize(n, false);
  
  for(int i=0; i<n; ++i)
  {    
    cin >> input;
    v.push_back(input);
  }
  

  for(int i=0; i<3; ++i)
  {
    int sum = 0;
    int idx = i;
    while(true)
    {
      ++sum;
      if(visited[idx])
      {
        ret = max(sum, ret);
        for(int j=0; j<n; ++j)
        {
          visited[j] = false;
        }
        break;
      }
      visited[idx] = true;      
      idx += v[idx];
    }
  }

  cout << ret;
}