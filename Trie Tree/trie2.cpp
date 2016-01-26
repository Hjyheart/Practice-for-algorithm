#include<cstdio>
#include<cstring>
#include<iostream>
using namespace std;
struct node
{
	int next[26];
	int cnt;
	void init()
	{
		cnt = 0;
		memset(next, -1, sizeof(next));
	}
}T[1000000];
int le;
void insert(char *s)
{
	int i = 0, p = 0;
	while (s[i])
	{
		int x = s[i] - 'a';
		if (T[p].next[x] == -1)
		{
			T[le].init();
			T[p].next[x] = le++;
		}
		p = T[p].next[x];
		T[p].cnt++;
		i++;
	}
}
void query(char *s)
{
	int i = 0, p = 0;
	while (s[i])
	{
		int x = s[i] - 'a';
		if (T[p].next[x] == -1)
		{
			puts("0");
			return;
		}
		p = T[p].next[x];
		i++;
	}
	printf("%d\n", T[p].cnt);
}
/*
int main()
{
	int n, m;
	char str[20];
	while (~scanf("%d", &n))
	{
		le = 1;
		T[0].init();
		while (n--)
		{
			scanf("%s", str);
			insert(str);
		}
		scanf("%d", &m);
		while (m--)
		{
			scanf("%s", str);
			query(str);
		}
	}
}
*/
