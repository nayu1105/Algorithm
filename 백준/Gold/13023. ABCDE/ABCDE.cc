#include<iostream>
#include<vector>

using namespace std;

int depth = 0;
int result = 0;
vector <vector<int>> v;
bool arr[2000] = { false };

void dfs(int a) {
	arr[a] = true;
	int size = v[a].size();
	for (int i = 0; i < size; i++) {
		if (arr[v[a][i]] == false) {
			depth++;
			dfs(v[a][i]);
			if (depth >= 4) {
				result = 1;
				return;
			}
			depth--;
			arr[v[a][i]] = false;
		}
	}
}


int main() {
	int n, s, a, b;
	cin >> n >> s;
	v = vector<vector<int>>(n);

	for (int i = 0; i < s; i++) {
		cin >> a >> b;

		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int j = 0; j < n; j++) {
		dfs(j);
		if (result==1) {
			break;
		}
		fill_n(arr, n, false);
	}

	if (result == 1) cout << "1";
	else cout << "0";
}