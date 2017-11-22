//
//  Hdu1114_Piggy-Bank.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/21.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;
int T, S, E, v, N, V[10001], W[10001], F[10001];

int main(){
    cin >> T;
    while (T--) {
        scanf("%d%d", &S, &E);
        v = E - S;
        F[0] = 0;
        for (int i = 1; i <= v; i++) {
            F[i] = 1000000000;
        }
        scanf("%d", &N);
        for (int i = 0; i < N; i++) {
            scanf("%d%d", &V[i], &W[i]);
        }
        for (int i = 0; i < N; i++) {
            for (int k = W[i]; k <= v; k++) {
                if (F[k] > F[k - W[i]] + V[i]) {
                    F[k] = F[k - W[i]] + V[i];
                }
            }
        }
        if (F[v] == 1000000000) {
            printf("This is impossible.\n");
            continue;
        }
        else{
            printf("The minimum amount of money in the piggy-bank is %d.\n", F[v]);
        }
    }
    return 0;
}