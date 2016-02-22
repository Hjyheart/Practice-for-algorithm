//
//  Hdu2955_Robberies.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/15.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
using namespace std;

int T, N, t, k, j, val[101], sum = 0;
float P, cost[101], F[10010];

int main(){
    scanf("%d", &T);
    while (T--) {
        scanf("%f%d", &P, &N);
        P = 1 - P;
        memset(F, 0, sizeof(F));
        F[0] = 1.0;
        for ( k = 1; k <= N; k++) {
            scanf("%d%f", &val[k], &cost[k]);
            cost[k] = 1.0 - cost[k];
            sum += val[k];
        }
        for (k = 1; k <= N; k++) {
            for ( j = sum; j >= val[k]; j--) {
                F[j] = max(F[j], F[j - val[k]] * cost[k]);
            }
        }
        for (t = sum; t >= 0; t--) {
            if(F[t] >= P){
                break;
            }
        }
        printf("%d\n", t);
        sum = 0;
    }
    return 0;
}
