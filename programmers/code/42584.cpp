#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    answer.resize(prices.size(), 0);
    
    for(int i=0; i<prices.size(); ++i)
    {
        for(int j=i+1; j<prices.size(); ++j)
        {
            ++answer[i];
            if(prices[i] > prices[j]) break;
        }
    }
    return answer;
}