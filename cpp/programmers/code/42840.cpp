#include <string>
#include <vector>
#include <deque>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    deque<int> d1,d2,d3;
    int answer1 = 0, answer2 = 0, answer3 = 0;
    d1.push_back(1);
    d1.push_back(2);
    d1.push_back(3);
    d1.push_back(4);
    d1.push_back(5);
    
    d2.push_back(2);
    d2.push_back(1);
    d2.push_back(2);
    d2.push_back(3);
    d2.push_back(2);
    d2.push_back(4);
    d2.push_back(2);
    d2.push_back(5);
    
    d3.push_back(3);
    d3.push_back(3);
    d3.push_back(1);
    d3.push_back(1);
    d3.push_back(2);
    d3.push_back(2);
    d3.push_back(4);
    d3.push_back(4);
    d3.push_back(5);
    d3.push_back(5);
    
    for(vector<int>::iterator iter = answers.begin(); iter != answers.end(); ++iter)
    {
        int ans1 = d1.front();
        d1.pop_front();
        int ans2 = d2.front();
        d2.pop_front();
        int ans3 = d3.front();
        d3.pop_front();
        
        d1.push_back(ans1);
        d2.push_back(ans2);
        d3.push_back(ans3);
        
        if(*iter == ans1)
        {
            ++answer1;
        }
        if(*iter == ans2)
        {
            ++answer2;
        }
        if(*iter == ans3)
        {
            ++answer3;
        }
    }
    
    if(answer1 >= answer2 && answer1 >= answer3) answer.push_back(1);
    if(answer2 >= answer1 && answer2 >= answer3) answer.push_back(2);
    if(answer3 >= answer1 && answer3 >= answer2) answer.push_back(3);
    
    return answer;
}