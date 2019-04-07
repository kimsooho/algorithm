#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	pair<int, int> pr;
	vector<pair<int, int>> v;

	int count = 1;
	int MAX = 0;
	int n;
	int a, b;
	int tmp;
	cin >> n;
	while (n--) {
		cin >> a >> b;
		pr.first = b;
		pr.second = a;

		v.push_back(pr);
	}
	sort(v.begin(), v.end());
	tmp = v[0].first;
	if (v.size() != 1) {
		for (vector<pair<int, int>>::iterator iter = v.begin() + 1; iter != v.end(); ++iter) {
			if (tmp <= (*iter).second) {
				count++;
				tmp = (*iter).first;
			}
		}
	}	
	cout << count << endl;	
}
