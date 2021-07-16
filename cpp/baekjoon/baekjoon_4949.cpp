#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main()
{
  string text;
  stack<char> s;
  
  while (true)
  {
    getline(cin, text);
    
    if (text.compare(".") == 0)
      break;

    stack<char> s;
    bool isProblem = false;
    
    for (int i = 0; i < text.size(); ++i)
    {
      if (text[i] == '(' || text[i] == '[')
      {
        s.push(text[i]);
      }
      else if (text[i] == ')')
      {        
        if(s.empty() || s.top() != '(')
        {
          isProblem = true;
          break;
        }
        else
        {
          s.pop();
        }
      }
      else if (text[i] == ']')
      {
        if(s.empty() || s.top() != '[')
        {
          isProblem = true;
          break;
        }
        else
        {
          s.pop();
        }
      }
    }
    if (!s.empty() || isProblem)    
      cout << "no" << endl;      
    else
      cout << "yes" << endl;
  }
}