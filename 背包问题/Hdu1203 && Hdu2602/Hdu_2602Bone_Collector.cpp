//
//  Hdu_2602Bone_Collector.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/14.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <cstdio>
#include <iostream>
#include <string.h>
#include <algorithm>
using namespace std;

int T, N, V;
int cost[1001], val[1001], F[1001];

int main(){
    scanf("%d", &T);
    for (int i = 0; i < T; i++) {
        memset(F, 0, sizeof(F));
        scanf("%d%d", &N, &V);
        for (int k = 0; k < N; k++) {
            scanf("%d", &val[k]);
        }
        for (int k = 0; k < N; k++) {
            scanf("%d", &cost
                  [k]);
        }
        
        for (int i = 0; i < N; i++) {
            for (int k = V; k >= cost[i]; k--) {
                F[k] = max(F[k], F[k - cost[i]] + val[i]);
            }
        }
        printf("%d\n", F[V]);
    }
    return 0;
}