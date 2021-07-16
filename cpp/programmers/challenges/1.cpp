#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> absolutes, vector<bool> signs)
{
  int answer = 0;
  int size = absolutes.size();
  for (int i=0; i<size; ++i)
  {
    if(!signs[i])
      absolutes[i] = absolutes[i] * -1;

    answer += absolutes[i];
  }

  return answer;
}

int main()
{
  cout << "test" << endl;
}