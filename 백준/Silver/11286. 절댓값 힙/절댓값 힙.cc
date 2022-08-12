#include<iostream>
#include<queue>
#include<cstdlib>

using namespace std;

struct cmp {
	bool operator()(int a, int b) {
		if (abs(a) > abs(b)) {
			return true;
		}
		else if (abs(a) == abs(b)) {
			return a > b;
		}
		else return false;
	}
};

int main() {
	
	priority_queue <int, vector<int>,cmp> pq;
	queue<int> q;

	long long n, temp;
	
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> temp;
		if (temp == 0) {
			if (pq.empty()) cout << 0 << "\n";
			else{
				cout << pq.top()<< "\n";
				pq.pop();
			}
		}
		else {
			pq.push(temp);
		}
	}

}