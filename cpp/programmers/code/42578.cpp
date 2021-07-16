#include <iostream>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes)
{
  int answer = 1;
  map<string, int> m;
  for(vector<string> val : clothes)
  {
    if(m.find(val[1]) == m.end())
    {
      m.insert(make_pair(val[1], 1));
    }
    ++m[val[1]];
  }
  
  for(pair<string, int> val : m)
  {
    answer *= val.second;
  }
  return answer - 1;
}

int main()
{  
  vector<vector<string>> clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
  cout << solution(clothes);
}
