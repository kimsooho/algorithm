#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    string str = "수박";
    
    for(int i=0; i < n/2; ++i)
    {
        answer += str;
    }
    
    if(n&1) answer += "수";
    return answer;
}