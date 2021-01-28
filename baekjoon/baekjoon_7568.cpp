#include <iostream>
#include <vector>

using namespace std;

int main()
{
  vector<pair<int, int>> v;
  int N, x, y;

  cin >> N;
  for(int i=0; i<N; ++i)
  {
    cin >> x >> y;
    v.push_back(make_pair(x, y));
  }

  for(vector<pair<int, int>>::iterator iter = v.begin(); iter != v.end(); ++iter)
  {
    int count = N;
    for(vector<pair<int, int>>::iterator iter_ = v.begin(); iter_ != v.end(); ++iter_)
    {
      if(iter == iter_)
        continue;

      if(iter->first >= iter_->first || iter->second >= iter_->second) --count; 
      /* 
        같은 경우에도 순위를 내려야 함.
        if(iter->first > iter_->first || iter->second > iter_->second) --count;  -----> 실패 
      */
    }

    cout << count << " ";
  }
}
