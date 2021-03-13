#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

int solution(string skill, vector<string> skill_trees)
{
  int answer = 0;
  map<string, int> map_skill;
  map<int, bool> map_visited;  
  for (vector<string>::iterator iter = skill_trees.begin(); iter != skill_trees.end(); ++iter)
  {
    bool isSuccess = true;
    map_skill.clear();
    map_visited.clear();

    for (int i = 0; i < skill.size(); ++i)
    {
      map_skill.insert(make_pair(string(1, skill[i]), i));
      map_visited.insert(make_pair(i, false));
    }

    for (int k = 0; k < iter->size() && isSuccess; ++k)
    {
      string tmp = string(1, iter->at(k));      
      if (map_skill.find(tmp) != map_skill.end())
      {
        int idx = map_skill[tmp];
        map_visited[idx] = true;

        for(int j=0; j<idx && isSuccess; ++j)
        {
          if(!map_visited[j])
          {
            isSuccess = false;
          }
        }
      }
    }

    if(isSuccess)
      ++answer;
  }

  return answer;
}

int main()
{
  string skill = "CBD";
  vector<string> skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
  cout << solution(skill, skill_trees);
}