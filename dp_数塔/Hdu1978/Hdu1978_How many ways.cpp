//
//  Hdu1978_How many ways.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/29.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
using namespace std;

int T, N, M, mp[105][105], dp[105][105];

void solve(){
    dp[0][0] = 1;
    for (int i = 0; i < N; i++) {
        for (int k = 0; k < M; k++) {
            for (int j = 0; j <= i; j++) {
                for (int t = 0; t <= k; t++) {
                    if (j == i && t == k) {
                        continue;
                    }
                    if (i - j + k - t <= mp[j][t]) {
                        dp[i][k] = (dp[i][k] + dp[j][t]) % 10000;
                    }
                }
            }
        }
    }
    printf("%d\n", dp[N - 1][M - 1]);
}

int main(){
    scanf("%d", &T);
    while (T--) {
        scanf("%d%d", &N, &M);
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                scanf("%d", &mp[i][k]);
                dp[i][k] = 0;
            }
        }
        solve();
    }
    return 0;
}