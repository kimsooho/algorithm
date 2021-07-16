#include <string>
#include <vector>
#include <stdlib.h>
#include <iostream>
using namespace std;

string solution(string number, int k) {
    string answer = "";
    for(int i=0, m = 0; i < number.size(); ++i, ++m)
    {
        char MAX = number[i];
        int idx = i;
        cout << "i : " << i << endl;
        for(int j=i; j < number.size() - k + m; ++j)
        {
            if(number[j] > MAX)
            {
                MAX = number[j];
                idx = j;
                cout << "i : " << i << ",,, idx : " << idx << endl;
            }
        }
        answer += MAX;
        i = idx;
    }
    return answer;
}

int main()
{
  std::cout << solution("1924", 2) << std::endl;
  std::cout << solution("1231234", 3) << std::endl;
  std::cout << solution("4177252841", 4) << std::endl;
}