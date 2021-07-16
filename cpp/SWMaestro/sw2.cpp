#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  int p, n, h;
  int pcNum, hNum;
  vector<vector<int>> pc;

  vector<vector<int>> price;

  cin >> p >> n >> h;

  pc.resize(p + 1);
  price.resize(p + 1);

  for (int i = 0; i < n; ++i)
  {
    cin >> pcNum >> hNum;

    if (hNum > h)
      continue;

    pc[pcNum].push_back(hNum);
  }

  for (int i = 1; i < pc.size(); ++i)
  {
    sort(pc[i].begin(), pc[i].end());
  }

  for (int i = 1; i < pc.size(); ++i)
  {
    for (int j = 0; j < pc[i].size(); ++j)
    {
      int sum = 0;
      price[i].push_back(sum);
      for (int k = j; k < pc[i].size(); ++k)
      {
        if (sum + pc[i][k] > h)
          break;

        sum += pc[i][k];
      }
      price[i][j] = sum;
    }

    
  }
  for (int i = 1; i < pc.size(); ++i)
  {
    sort(price[i].begin(), price[i].end());
    reverse(price[i].begin(), price[i].end());

    for(int j=0; j<price[i].size(); ++j)
    {
      cout << price[i][j] << " ";
    }
    cout << endl;
  };
  for (int i = 1; i < pc.size(); ++i)
  {
    cout << i << " " << (price[i].empty() ? 0 : price[i][0]) * 1000 << endl;    
  }

}