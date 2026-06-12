#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int intervals, required, queries;
    cin >> intervals >> required >> queries;

    vector<int> mark(200002, 0);

    for (int idx = 0; idx < intervals; idx++) {
        int startPos, endPos;
        cin >> startPos >> endPos;

        mark[startPos]++;
        mark[endPos + 1]--;
    }

    vector<int> coverage(200001, 0);
    for (int pos = 1; pos <= 200000; pos++) {
        coverage[pos] = coverage[pos - 1] + mark[pos];
    }

    vector<int> qualifiedPrefix(200001, 0);
    for (int pos = 1; pos <= 200000; pos++) {
        qualifiedPrefix[pos] =
            qualifiedPrefix[pos - 1] + (coverage[pos] >= required);
    }

    while (queries--) {
        int leftBound, rightBound;
        cin >> leftBound >> rightBound;

        cout << qualifiedPrefix[rightBound]
                - qualifiedPrefix[leftBound - 1]
             << '\n';
    }

    return 0;
}