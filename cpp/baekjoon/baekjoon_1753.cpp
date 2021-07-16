#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

#define INF 20000 * 10 + 1
vector<vector<pair<int, int>>> map;
vector<int> weight;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

void run();

int main()
{
  int V, E, K, v1, v2, w;

  cin >> V >> E >> K;
  weight.resize(V + 1, INF);
  map.resize(V + 1);

  for (int i = 0; i < E; ++i)
  {
    cin >> v1 >> v2 >> w;
    map[v1].push_back(make_pair(v2, w));
  }

  weight[K] = 0;
  pq.push(make_pair(0, K));
  run();

  for (vector<int>::iterator iter = weight.begin() + 1; iter != weight.end(); ++iter)
  {
    cout << (*iter == INF ? "INF" : to_string(*iter)) << "\n";
  }
}

void run()
{
  while (!pq.empty())
  {
    int w = pq.top().first;
    int v = pq.top().second;
    pq.pop();

    for (vector<pair<int, int>>::iterator iter = map[v].begin(); iter != map[v].end(); ++iter)
    {
      int v2 = iter->first;
      int w2 = iter->second;

      if (weight[v2] > w + w2)
      {
        weight[v2] = w + w2;
        pq.push(make_pair(weight[v2], v2));
      }
    }
  }
}