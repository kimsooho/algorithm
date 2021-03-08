#include <vector>
#include <map>
#include <queue>
#include <algorithm>
#include <string>

using namespace std;

struct PQcmp
{
  bool operator()(pair<int, int> a, pair<int, int> b)
  {
    if (a.second == b.second)
    {
      return a.first > b.first;
    }
    else
    {
      return a.second < b.second;
    }
  }
};

bool Vcmp(pair<string, int> a, pair<string, int> b)
{
  return a.second > b.second;
}


vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    map<string, int> playCount;
    map<string, priority_queue<pair<int, int>, vector<pair<int, int>>, PQcmp>> playInfo;
    
    for (int i = 0; i < genres.size(); ++i)
    {
        if (playCount.find(genres[i]) == playCount.end())
        {
        playCount.insert(make_pair(genres[i], 0));
        playInfo.insert(make_pair(genres[i],
                                    priority_queue<pair<int, int>, vector<pair<int, int>>, PQcmp>()));
        }

        playCount[genres[i]] += plays[i];
        playInfo[genres[i]].push(make_pair(i, plays[i]));
    }

    vector<pair<string, int>> v(playCount.begin(), playCount.end());
    sort(v.begin(), v.end(), Vcmp);
    
    for (pair<string, int> var : v)
    {
        priority_queue<pair<int, int>, vector<pair<int, int>>, PQcmp> pq = playInfo[var.first];
        int i = 0;
        while (!pq.empty() && i < 2)
        {
          int count = pq.top().second;
          int idx = pq.top().first;
          pq.pop();
    
          answer.push_back(idx);
          ++i;
        }
    }
    
    return answer;
}
// #include <iostream>
// #include <vector>
// #include <map>
// #include <queue>
// #include <algorithm>

// using namespace std;

// struct PQcmp
// {
//   bool operator()(pair<int, int> &a, pair<int, int> &b)
//   {
//     if (a.second == b.second)
//     {
//       return a.first > b.first;
//     }
//     else
//     {
//       return a.second < b.second;
//     }
//   }
// };

// bool Vcmp(pair<string, int> &a, pair<string, int> &b)
// {
//   return a.second > b.second;
// }

// int main()
// {
//   vector<string> genres = {"classic", "pop", "classic", "classic", "pop"};
//   vector<int> plays = {500, 600, 500, 800, 2500};
//   map<string, int> playCount;
//   map<string, priority_queue<pair<int, int>, vector<pair<int, int>>, PQcmp>> playInfo;

//   for (int i = 0; i < genres.size(); ++i)
//   {
//     if (playCount.find(genres[i]) == playCount.end())
//     {
//       playCount.insert(make_pair(genres[i], 0));
//       playInfo.insert(make_pair(genres[i],
//                                 priority_queue<pair<int, int>, vector<pair<int, int>>, PQcmp>()));
//     }

//     playCount[genres[i]] += plays[i];
//     playInfo[genres[i]].push(make_pair(i, plays[i]));
//   }

//   vector<pair<string, int>> v(playCount.begin(), playCount.end());
//   sort(v.begin(), v.end(), Vcmp);

//   for (pair<string, int> var : v)
//   {
//     cout << var.first << " : " << var.second << "\n";
//     priority_queue<pair<int, int>, vector<pair<int, int>>, PQcmp> pq = playInfo[var.first];
//     int i = 0;
//     while (!pq.empty() && i < 2)
//     {
//       int count = pq.top().second;
//       int idx = pq.top().first;
//       pq.pop();

//       cout << "idx : " << idx << endl;
//       cout << "count : " << count << endl;
//       ++i;
//     }
//   }
// }