#pragma warning(disable:4996)
#include <iostream>
#include <vector>

using namespace std;

long long sum = 0;
vector<int> m;

void merge(int start, int end) {
	int mid = (start + end) / 2;
	int left = start;
	int right = mid + 1;
	vector<int> temp;

	if (start == end) {
		return;
	}

	merge(start, mid);
	merge(mid + 1, end);

	while (left <= mid && right <=  end) {
		if (m[left] <= m[right]) {
			temp.push_back(m[left++]);
		}
		else {
			temp.push_back(m[right++]);
			sum += (mid + 1 - left);
		}
	}

	while (left <= mid) {
		temp.push_back(m[left++]);
	}

	while (right <= end) {
		temp.push_back(m[right++]);
	}

	for (int i = start, j = 0; i <= end; ++i, ++j) {
		m[i] = temp[j];
	}

}


int main(void) {
	int n;
	cin >> n;

	
	m.resize(n);

	for (int i = 0; i < n; i++) {
  		cin >> m[i];
	}

	merge(0, n - 1);

	cout << sum;
  }