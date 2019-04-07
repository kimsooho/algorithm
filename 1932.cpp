#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int arr[501][501];
int main() {	
	
	int n;
	int input=0;
	int tmp = 0;
	cin >> n;	

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j <= i; ++j) {
			cin >> input;
			arr[i][j] = input;			
		}
	}

	
	for (int i = 1; i < n; ++i) {	
		for (int j = 0; j <= i; ++j) {			
			if (j == 0) {
				arr[i][j] += arr[i - 1][j];
			}
			else if (j == i) {
				arr[i][j] += arr[i - 1][j - 1];
			}
			else {
				arr[i][j] = max(arr[i][j] + arr[i - 1][j - 1], arr[i][j] + arr[i - 1][j]);
			}
		}
	}
	
	tmp = 0;
	for (int i = 0; i < n; ++i) {		
		tmp = max(tmp, arr[n - 1][i]);		
	}
	cout << tmp;
	std::system("pause");
}
