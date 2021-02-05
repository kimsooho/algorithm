#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    int pCount = 0, yCount = 0;
    
    for(string::iterator iter = s.begin(); iter != s.end(); ++iter)
    {
        if(*iter == 'p' || *iter == 'P') ++pCount;
        else if(*iter == 'y' || *iter == 'Y') ++yCount;
    }

    return answer = pCount == yCount;
}