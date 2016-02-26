//
//  Hdu1241_Oil Deposits.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/24.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <string.h>
using namespace std;

int N, M, flag[100][100], ans = 0, start = 0;
char mp[100][100];

void solve(int x, int y){
    if (mp[x][y] == '*' || flag[x][y] == 1) {
        return;
    }
    flag[x][y] = 1;
    if (!start) {
        start = 1;
        ans++;
    }
    //up
    if (x - 1 >= 0) {
        solve(x - 1, y);
    }
    //down
    if (x + 1 < N) {
        solve(x + 1, y);
    }
    //left
    if (y - 1 >= 0) {
        solve(x, y - 1);
    }
    //right
    if (y + 1 < M) {
        solve(x, y + 1);
    }
    //leftUp
    if (y - 1 >= 0 && x - 1 >= 0) {
        solve(x - 1, y - 1);
    }
    //rightUp
    if (y + 1 < M && x - 1 >= 0) {
        solve(x - 1, y + 1);
    }
    //rightDown
    if (y + 1 < M && x + 1 < N) {
        solve(x + 1, y + 1);
    }
    //leftDown
    if (y - 1 >= 0 && x + 1 < N) {
        solve(x + 1, y - 1);
    }
}

int main(){
    scanf("%d%d", &N, &M);
    while (N != 0 || M != 0) {
        getchar();
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                scanf("%c", &mp[i][k]);
            }
            getchar();
        }
        memset(flag, 0, sizeof(flag));
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                start = 0;
                solve(i, k);
            }
        }
        printf("%d\n", ans);
        ans = 0;
        scanf("%d%d", &N, &M);
    }
    return 0;
}
