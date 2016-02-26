//
//  Hdu1016_Prime Ring Problem.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/26.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
#include <stack>
#include <vector>
#include <cmath>
using namespace std;

int N, cnt = 0, vis[20];
vector<int> s;

bool judge(int a){
    for (int i = 2; i <= sqrt(a); i++) {
        if (a % i == 0) {
            return false;
        }
    }
    return true;
}

void solve(int cur){
    vis[cur] = 1;
    int cmp = s[s.size() - 1];
    if (judge(cur + cmp)) {
        s.push_back(cur);
    }
    else{
        vis[cur] = 0;
        return;
    }
    if (s.size() == N) {
        if (!judge(s[s.size() - 1] + 1)) {
            s.pop_back();
            vis[cur] = 0;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (i != N - 1) {
                printf("%d ", s[i]);
                continue;
            }
            printf("%d\n", s[i]);
        }
        s.pop_back();
        vis[cur] = 0;
        return;
    }
    for (int i = 2; i <= N; i++) {
        if (vis[i] == 0) {
            solve(i);
        }
        continue;
    }
    s.pop_back();
    vis[cur] = 0;
}

int main(){
    while (scanf("%d", &N) != EOF) {
        cnt++;
        memset(vis, 0, sizeof(vis));
        s.clear();
        s.push_back(1);
        vis[1] = 1;
        printf("Case %d:\n", cnt);
        for (int i = 2; i <= N; i++) {
            solve(i);
        }
        printf("\n");
    }
    return 0;
}
