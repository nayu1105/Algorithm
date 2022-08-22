#include<iostream>
#include<queue>
using namespace std;

int arr[1000001];
queue <int> q;

void uni(int a, int b) {
	while (arr[a] != a) {
		a = arr[a];
	}
	while (arr[b] != b) {
		b = arr[b];
	}
	arr[b] = a;
}

bool find(int a, int b) {
	while (arr[a] != a) {
		q.push(a);
		a = arr[a];		
	}
	while (!q.empty()) {
		int qt = q.front();
		arr[qt] = a;
		q.pop();
	}
	while (arr[b] != b) {
		b = arr[b];
	}
	while (!q.empty()) {  
		int qt = q.front();
		arr[qt] = b;
		q.pop();
	}
	if (a == b)return true;
	else return false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	
	for (int i = 0; i <= 1000000; i++) {
		arr[i] = i;
	}

	for (int i = 0; i < m; i++) {
		int mode, a, b;
		cin >> mode;
		cin >> a >> b;
		if (mode == 0) {
			uni(a, b);			
		}
		else {
			bool ans = find(a, b);
			if (ans == true)cout << "YES" << "\n";
			else cout << "NO" << "\n";
		}
	}

}