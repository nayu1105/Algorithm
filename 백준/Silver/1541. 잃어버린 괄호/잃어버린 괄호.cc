#include<iostream>
#include<sstream>
#include<string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	string s, sb, sbb;
	getline(cin, s);
	istringstream ss(s);

	int result = 0, temp = 0;
	int i = 0;
	while (getline(ss, sb, '-')) {
		istringstream sss(sb);
		while (getline(sss, sbb, '+')) {
			temp += stoi(sbb);
		}
		if (i == 0)result += temp;
		else result -= temp;
		temp = 0;
		i++;
	}
	
	cout << result;

}