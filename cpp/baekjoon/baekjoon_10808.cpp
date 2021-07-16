#include <iostream>
#include <vector>

using namespace std;

int main()
{
  string input;
  vector<int> v;
  cin >> input;
  v.resize(26, 0);
  for(string::iterator iter = input.begin(); iter != input.end(); ++iter)
  {
    ++v[(*iter - 97)];
  }

  for(vector<int>::iterator iter = v.begin(); iter != v.end(); ++iter)
  {
    cout << *iter << " ";
  }
}