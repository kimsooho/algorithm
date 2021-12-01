/**
 * @author suho kim
 * @no 17171
 * @title 연구소 2
 * @url https://www.acmicpc.net/problem/17141
 * @date 2021.12.01
 */
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<vector<int>> map;
vector<pair<int, int>> positions;
vector<pair<int, int>> selectedPosition;

vector<vector<bool>> visited;
vector<bool> isSelected;

int moveRow[4] = {-1, 1, 0, 0};
int moveCol[4] = {0, 0, -1, 1};

int N, virusLimit, input;
int retValue = INT16_MAX / 2;

void Sol();
bool IsValid();
void Selection(int, int, int);
void Setvisited();
int Vine();

int main()
{

  cin >> N >> virusLimit;

  map.resize(N);
  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < N; ++j)
    {
      cin >> input;
      map[i].push_back(input);
      if (input == 2)
      {
        positions.push_back(make_pair(i, j));
      }
    }
  }
  isSelected.resize(positions.size());

  Sol();
  std::cout << (retValue == INT16_MAX / 2 ? -1 : retValue) << std::endl;
}
bool IsValid()
{
  for (int i = 0; i < N; ++i)
  {
    for (int j = 0; j < N; ++j)
    {
      if (map[i][j] != 1 && !visited[i][j])
        return false;
    }
  }

  return true;
}
void Sol()
{
  Selection(0, 0, virusLimit);
}

void Selection(int idx, int depth, int limit)
{
  if (depth == limit)
  {
    retValue = min(Vine(), retValue);
    return;
  }

  for (int i = idx; i < positions.size(); ++i)
  {
    if (!isSelected[i])
    {
      isSelected[i] = true;
      selectedPosition.push_back(positions[i]);
      Selection(i, depth + 1, limit);
      selectedPosition.pop_back();
      isSelected[i] = false;
    }
  }
}

void SetVisited()
{
  visited.resize(N);
  for (int i = 0; i < N; ++i)
  {
    visited[i].resize(N);
    std::fill(visited[i].begin(), visited[i].end(), false);
  }
}

int Vine()
{
  SetVisited();
  queue<pair<int, int>> q;
  for (int i = 0; i < selectedPosition.size(); ++i)
  {
    int row = selectedPosition[i].first;
    int col = selectedPosition[i].second;
    q.push(make_pair(row, col));
    visited[row][col] = true;
  }

  int count = -1;
  while (!q.empty())
  {
    ++count;
    int size = q.size();
    for (int s = 0; s < size; ++s)
    {
      int row = q.front().first;
      int col = q.front().second;
      q.pop();

      for (int i = 0; i < 4; ++i)
      {
        int nextRow = row + moveRow[i];
        int nextCol = col + moveCol[i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || visited[nextRow][nextCol] || map[nextRow][nextCol] == 1)
          continue;

        visited[nextRow][nextCol] = true;
        q.push(make_pair(nextRow, nextCol));
      }
    }
  }
  return IsValid() ? count : INT16_MAX / 2;
}