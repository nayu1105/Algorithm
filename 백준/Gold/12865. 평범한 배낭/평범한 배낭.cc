#pragma warning(disable:4996)
#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n, k;

	cin >> n >> k;

	vector<pair<int, int>> product;
	vector<vector<int>> mat(n + 1, vector<int>(k + 1, 0));
	
	for (int i = 0;i < n;i++) {
		int w, v;
		cin >> w >> v;
		product.push_back(make_pair(w, v));
	}

	for (int j = 1;j <= n;j++) {
		for (int h = 1;h <= k; h++) {
			if (h - product[j-1].first >= 0) {
				int a = mat[j - 1][h];//넣음
				int b = mat[j-1][h - product[j - 1].first] + product[j - 1].second;//안넣음
				if (a > b) {
					mat[j][h] = a;
				}
				else mat[j][h] = b;
			}
			else  mat[j][h] = mat[j- 1][h];
		}
	}

	cout << mat[n][k];

}