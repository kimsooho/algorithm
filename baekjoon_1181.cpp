#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
  int count;
  vector<string> v;
  string input;
  cin >> count;

  while (count--)
  {
    cin >> input;    
    v.push_back(input);    
  }

  sort(v.begin(), v.end(), [](string a, string b){
    if(a.size() == b.size())
      return a < b;
    return a.size() < b.size();
  });
  
  v.erase(unique(v.begin(), v.end()), v.end());

  for(vector<string>::iterator iter = v.begin(); iter != v.end(); ++iter)
  {
    cout << *iter << "\n";
  }

}