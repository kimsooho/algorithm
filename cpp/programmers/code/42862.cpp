#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<int> v;
    v.resize(n+2, 0);
    
    for(int i=0; i<reserve.size(); ++i)
        v[reserve[i]] = 1;
    
    for(int i=0; i<lost.size(); ++i)
    {
        v[lost[i]] = v[lost[i]] == 1 ? 0 : -1;
    }
    
    for(int i=0; i<lost.size(); ++i)
    {
        if(v[lost[i]] == 0) continue;
        else if(v[lost[i]-1] == 1)
        {
            v[lost[i]-1] = 0;
            v[lost[i]] = 0;
        }
        else if(v[lost[i]+1] == 1)
        {
            v[lost[i]+1] = 0;
            v[lost[i]] = 0;
        }
    }
    
    for(int i=1; i<v.size()-1; ++i)
    {
        if(v[i] == 0 || v[i] == 1) ++answer;
    }
    return answer;
}