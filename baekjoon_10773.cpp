#include <iostream>
#include <stack>

using namespace std;

int main()
{
    int testcase, input, sum = 0;
    stack<int> s;

    cin >> testcase;

    while (testcase--)
    {
        cin >> input;
        if(input == 0)
        {
            s.pop();
        }
        else
        {
            s.push(input);
        }
    }

    while (!s.empty())
    {
        sum += s.top();
        s.pop();
    }
    

    cout << sum << endl;
}