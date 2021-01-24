#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

int main()
{
  vector<int> nums;
  int N, input, count = 0;

  cin >> N;

  while (N--)
  {
    cin >> input;
    nums.push_back(input);
  }

  for (vector<int>::iterator iter = nums.begin(); iter != nums.end(); ++iter)
  {
    if (*iter < 2)
      continue;
    if (*iter == 2)
    {
      ++count;
      continue;
    }

    if(*iter % 2 == 0) continue;

    int root = sqrt(*iter);
    bool isPrime = true;
    for(int i=3; i<=root; i+=2)
    {
      if(*iter % i == 0)
      {
        isPrime = false;
        break;
      }
    }

    if(isPrime)    
      ++count;
  }

  cout << count << "\n";
}