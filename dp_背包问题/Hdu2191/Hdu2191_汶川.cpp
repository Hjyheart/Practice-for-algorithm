//
//  Hdu2191_汶川.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/16.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string.h>
#include <algorithm>
using namespace std;

int T, V, N, F[101], cost[101], wei[101], amount[101];

void zeroOnePack(int cost,int wei){
    for (int i = V; i >= cost; i--) {
        F[i] = max(F[i], F[i - cost] + wei);
    }
}

void zeroTwoPack(int cost, int wei){
    for (int i = cost; i <= V; i++) {
        F[i] = max(F[i], F[i - cost] + wei);
    }
}

int main(){
    scanf("%d", &T);
    while (T--) {
        scanf("%d%d", &V, &N);
        memset(F, 0, sizeof(F));
        for (int i = 0; i < N; i++) {
            scanf("%d%d%d", &cost[i], &wei[i], &amount[i]);
        }
        
        for (int i = 0; i < N; i++) {
            if (cost[i] * amount[i] >= V) {
                zeroTwoPack(cost[i], wei[i]);
                continue;
            }
            int k = 1;
            while (k < amount[i]) {
                zeroOnePack(k * cost[i], k * wei[i]);
                amount[i] = amount[i] - k;
                k = k * 2;
            }
            zeroOnePack(amount[i] * cost[i], amount[i] * wei[i]);
        }
        
        printf("%d\n", F[V]);
    }
    return 0;
}
