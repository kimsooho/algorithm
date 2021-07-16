#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
  vector<int> v;

  for(int i=0; i<5;++i)
  {
    v.push_back(i);
  }

  do
  {
    for(int i=0; i<5; ++i)
    {
      cout << v[i] << " ";
    }
    cout << endl;
  }while(next_permutation(v.begin(), v.end()));
}