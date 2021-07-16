#include <iostream>
#include <vector>

using namespace std;
int main()
{
  vector<int> cards;
  int N, M, input, retValue = -1;
  cin >> N >> M;

  while (N--)
  {
    cin >> input;
    cards.push_back(input);
  }

  for (int i = 0; i < cards.size() - 2; ++i)
  {
    for (int j = i + 1; j < cards.size() - 1; ++j)
    {
      if(cards[i] + cards[j] >= M) continue;

      for (int k = j + 1; k < cards.size(); ++k)
      {
        int sumValue = cards[i] + cards[j] + cards[k];
        if(sumValue > M) continue;
        
        retValue = max(retValue, sumValue);
      }
    }
  }

  cout << retValue << "\n";
}