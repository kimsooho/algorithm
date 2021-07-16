/*
  https://programmers.co.kr/learn/courses/30/lessons/64061
*/
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves)
{
  int answer = 0;
  vector<int> basket;

  for (vector<int>::iterator iter = moves.begin(); iter != moves.end(); ++iter)
  {
    for (vector<vector<int>>::iterator itBoard = board.begin(); itBoard != board.end(); ++itBoard)
    {
      if ((*itBoard).at((*iter) - 1) != 0)
      {
        if (!basket.empty() && (*itBoard).at((*iter) - 1) == basket.back())
        {
          basket.pop_back();
          answer += 2;
        }
        else
        {
          basket.push_back((*itBoard).at((*iter) - 1));
        }
        (*itBoard).at((*iter) - 1) = 0;
        break;
      }
    }
  }

  return answer;
}