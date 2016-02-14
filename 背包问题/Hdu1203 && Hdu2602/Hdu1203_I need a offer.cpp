//
//  Hdu1203_I need a offer.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/14.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <algorithm>
#include <iostream>
#include <cstdio>

using namespace std;

int n, m;
float arr[10003], ans[10003];
int cost[10003];

float Hdu_1203Solve(){
    for (int i = 1; i <= m; i++) {
        for (int k = n; k >= cost[i]; k--) {
            ans[k] = max(ans[k], 1 - (1 - ans[k - cost[i]]) * (1 - arr[i]));
        }
    }
    return ans[n];
}
/*
int main(){
    scanf("%d%d", &n, &m);
    while (n != 0 || m != 0) {
        memset(ans, 0, sizeof(ans));
        for (int i = 1; i <= m; i++) {
            scanf("%d%f", &cost[i], &arr[i]);
        }
        printf("%.1f%%\n", Hdu_1203Solve() * 100);
        scanf("%d%d", &n, &m);
    }
    return 0;
}
*/


