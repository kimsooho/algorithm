#include <iostream>

using namespace std;
int main() {
    int x = 0;
    string input;
    cin >> input;
    
    for(string::iterator iter = input.begin(); iter != input.end(); ++iter)
    {
        if(*iter == '(')
        {
          ++x;
        }
        else
        {
          --x;
        }
    }
    

    if(x==0)
    {
      cout << "YES" << endl;
    }
    else
    {
      cout << "NO" << endl;
    }
}