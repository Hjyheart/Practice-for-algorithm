//
//  Hdu1171_Big Event in Hdu.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/16.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
using namespace std;

int N, val, V = 0, cost[51], amount[51], F[250001];

void zeroOnePack(int cost, int wei){
    for (int j = V; j >= cost; j--) {
        F[j] = max(F[j], F[j - cost] + wei);
    }
}

void zeroTwoPack(int cost, int wei){
    for (int j = cost; j <= V; j++) {
        F[j] = max(F[j], F[j - cost] + wei);
    }
}

void zeroThreePack(int cost, int amount){
    if (cost * amount >= V) {
        zeroTwoPack(cost, cost);
        return;
    }
    int k = 1;
    while (k < amount) {
        zeroOnePack(k * cost, k * cost);
        amount = amount - k;
        k = k * 2;
    }
    zeroOnePack(amount * cost, amount * cost);
}

int main(){
    scanf("%d", &N);
    while (N > 0) {
        for (int i = 0; i < N; i++) {
            scanf("%d%d", &cost[i], &amount[i]);
            val += cost[i] * amount[i];
        }
        V = val / 2;
        memset(F, 0, sizeof(F));
        
        for (int i = 0; i < N; i++) {
            zeroThreePack(cost[i], amount[i]);
        }
        printf("%d %d\n", val - F[V], F[V]);
        scanf("%d", &N);
        val = 0;
    }
    return 0;
}