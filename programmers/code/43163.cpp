#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <map>

using namespace std;

int solution(string begin, string target, vector<string> words)
{
  int answer = 0;
  map<string, bool> visited;
  queue<pair<string, int>> q;

  for (vector<string>::iterator iter = words.begin(); iter != words.end(); ++iter)
  {
    visited.insert(make_pair(*iter, false));
  }

  q.push(make_pair(begin, 0));
  visited[begin] = true;
  while (!q.empty())
  {
    string word = q.front().first;
    int count = q.front().second;
    q.pop();
    if (word == target)
    {
      answer = count;
    }

    for (int i = 0; i < word.size(); ++i)
    {
      string tmp = word;
      for (char c = 'a'; c <= 'z'; ++c)
      {
        tmp[i] = c;
        if (visited.find(tmp) != visited.end() && !visited[tmp])
        {
          visited[tmp] = true;
          q.push(make_pair(tmp, count + 1));
        }
      }
    }
  }

  return answer;
}

int main()
{
  string begin = "hit", target = "cog";
  vector<string> words = {"hot", "dot", "dog", "lot", "log", "cog"};

  cout << solution(begin, target, words);
}