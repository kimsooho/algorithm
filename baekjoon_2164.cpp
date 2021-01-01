#include <iostream>
#include <queue>

using namespace std;

int main(int argc, const char** argv) {
  queue<int> q;
  int num;
  bool backFlag = false;
  cin >> num;

  for(int i=1; i <= num; ++i)
  {
    q.push(i);
  }
  
  while(q.size() > 1)
  {    
    if(!backFlag)
    {      
      q.pop();      
    }
    else
    {
      q.push(q.front());
      q.pop();
    }

    backFlag = !backFlag;
  }

  cout << q.front() << "\n";
}