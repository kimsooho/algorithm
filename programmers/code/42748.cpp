#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    vector<int> v;
    
    for(vector<vector<int>>::iterator iter = commands.begin(); iter != commands.end(); ++iter)
    {
        v = vector<int>(array.begin() + iter->at(0) - 1, array.begin() + iter->at(1));
        sort(v.begin(), v.end());
        answer.push_back(v[iter->at(2) - 1]);
    }
    
    return answer;
}