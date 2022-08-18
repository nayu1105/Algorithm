#include<iostream>
#include<queue>

using namespace std;

bool arr[1001][1001];
bool arr2[1001];
bool arr3[1001];
queue <int> q;
int node, edge, start;

void dfs(int a) {
	cout << a << " ";
	arr2[a] = true;
	for (int i = 1; i <= node; i++) {
		if (arr[a][i]&&!arr2[i])dfs(i);
	}
}

void bfs() {
	if (q.empty())return;
	else {
		int t = q.front();
		q.pop();
		cout << t << " ";
		arr3[t] = true;
		for (int i = 1; i <= node; i++) {
			if (arr[t][i] && !arr3[i]) {
				q.push(i);
				arr3[i] = true;
			}
		}
		bfs();
	}
}
int main(){
	
	cin >> node >> edge >> start;
	
	int s, e;

	for (int i = 0; i < edge; i++) {
		cin >> s >> e;
		arr[s][e] = true;
		arr[e][s] = true;
	}

	dfs(start);
	cout << "\n";
	q.push(start);
	bfs();

}