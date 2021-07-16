#include <string>
#include <vector>
#include <map>
#include <queue>
#include <iostream>
#include <algorithm>

using namespace std;

void dfs(string);

vector<string> solution(vector<vector<string>>);
vector<string> solution_(vector<vector<string>>);

vector<string> answer;
map<string, vector<pair<string, bool>>> m;
map<string, vector<string>> _map;
bool cmp(pair<string, bool>, pair<string, bool>);

int main()
{
  // {{"ICN", "B"}, {"B", "C"}, {"C", "ICN"}, {"ICN", "D"}, {"ICN", "E"}, {"E", "F"}}
  // {{"ICN", "B"}, {"ICN", "C"}, {"C", "D"}, {"D", "ICN"}};
  //{{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
  vector<vector<string>> tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
  vector<string> v = solution(tickets);  

  for(string val : v)
  {
    cout << val << " ";
  }
}

vector<string> solution(vector<vector<string>> tickets)
{
  for (vector<string> val : tickets)
  {
    if (_map.find(val[0]) == _map.end())
    {
      _map.insert(make_pair(val[0], vector<string>()));
    }
    _map[val[0]].push_back(val[1]);
  }  

  for(pair<string, vector<string>> val : _map)
  {
    sort(_map[val.first].begin(), _map[val.first].end());
  }

  vector<string> tmp;
  tmp.push_back("ICN");

  while (!tmp.empty())
  {    
    string from = tmp.back();

    if(_map.find(from) == _map.end() || _map[from].empty())
    {
      answer.push_back(from);
      tmp.pop_back();
    }
    else
    {
      tmp.push_back(_map[from].front());
      _map[from].erase(_map[from].begin());
    }
  }
  reverse(answer.begin(), answer.end());
  return answer;
}

// 문제가 뭐지?
vector<string> solution_(vector<vector<string>> tickets)
{
  for (vector<string> val : tickets)
  {
    if (m.find(val[0]) == m.end())
    {
      m.insert(make_pair(val[0], vector<pair<string, bool>>()));
    }
    m[val[0]].push_back(make_pair(val[1], false));
  }


  for (pair<string, vector<pair<string, bool>>> val : m)
    sort(m[val.first].begin(), m[val.first].end(), cmp);
  dfs("ICN");
  return answer;
}
void dfs(string key)
{
  cout << key << "\n";
  answer.push_back(key);

  for (vector<pair<string, bool>>::iterator iter = m[key].begin(); iter != m[key].end(); ++iter)
  {
    if(iter->second) continue; 
    iter->second = true;
    dfs(iter->first);
  }
}

bool cmp(pair<string, bool> a, pair<string, bool> b)
{
  if(m.find(a.first) != m.end())
  {
    if(m.find(b.first) != m.end())
      return a.first < b.first;
    else
      return true;
  }
  else
  {
    if(m.find(b.first) != m.end())
      return false;
    else
      return a.first < b.first;
  }
}