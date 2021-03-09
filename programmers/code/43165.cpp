#include <string>
#include <vector>

using namespace std;

int dfs(vector<int>, int, int, int);
int solution(vector<int> numbers, int target) {
    int answer = dfs(numbers, target, 0, 0);
    return answer;
}

int dfs(vector<int> numbers, int target, int idx, int val)
{
    if(numbers.size() == idx)
    {
        return val == target ? 1 : 0;
    }
    
    return dfs(numbers, target, idx+1, val + numbers[idx]) + dfs(numbers, target, idx+1, val - numbers[idx]);
}