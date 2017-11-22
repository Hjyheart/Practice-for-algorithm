#include <iostream>
#include <algorithm>

using namespace std;

struct node
{
	int val;
}NODE[800100];

void build(int root, int arr[], int pStart, int pEnd)
{
	if (pStart == pEnd)
	{
		NODE[root].val = arr[pStart];
		return;
	}

	int mid = (pStart + pEnd) / 2;
	build(root * 2 + 1, arr, pStart, mid);
	build(root * 2 + 2, arr, mid + 1, pEnd);
	NODE[root].val = min(NODE[root * 2 + 1].val, NODE[root * 2 + 2].val);
}

int query(int root, int nStart, int nEnd, int qStart, int qEnd)
{
	if (nStart > qEnd || nEnd < qStart)
	{
		return 9999999;
	}
	if (qStart <= nStart && qEnd >= nEnd)
	{
		return NODE[root].val;
	}

	int mid = (nStart + nEnd) / 2;
	return min(
		query(root * 2 + 1, nStart, mid, qStart, qEnd),
		query(root * 2 + 2, mid + 1, nEnd, qStart, qEnd)
		);
}

void update(int root, int nStart, int nEnd, int index, int val)
{
	if (nStart == nEnd)
	{
		NODE[root].val = val;
		return;
	}

	int mid = (nStart + nEnd) / 2;
	if (index <= mid)
	{
		update(root * 2 + 1, nStart, mid, index, val);
	}
	else
	{
		update(root * 2 + 2, mid + 1, nEnd, index, val);
	}
	NODE[root].val = min(NODE[root * 2 + 1].val, NODE[root * 2 + 2].val);
}

int main(int argc, char const *argv[])
{
	int M, N, accounts[100005];
	cin >> M >> N;

	for (int i = 0; i < M; ++i)
	{
		cin >> accounts[i];
	}

	build(0, accounts, 0, M - 1);

	for (int i = 0; i < N; ++i)
	{
		int flag = 0, a = 0, b = 0;
		cin >> flag >> a >> b;
		if (flag == 1)
		{
			if (i == N - 1)
			{
				cout << query(0, 0, M - 1, a - 1, b - 1);
			}
			else
			{
				cout << query(0, 0, M - 1, a - 1, b - 1) << " "; 
			}
		}
		else
		{
			update(0, 0, M - 1, a - 1, b);
		}
	}
	return 0;
}