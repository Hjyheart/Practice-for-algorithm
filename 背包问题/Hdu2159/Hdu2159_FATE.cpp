//
//  Hdu2159_FATE.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/16.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string.h>
#include <cstdio>
#include <algorithm>
using namespace std;

struct guai{
    int val;
    int patient;
}mons[101];

int nVal, m, k, s;
int F[101], amount[101];

int main(){
    while(scanf("%d%d%d%d", &nVal, &m, &k, &s) != EOF){
        memset(F, 0, sizeof(F));
        memset(amount, 0, sizeof(amount));
        for (int i = 0; i < k; i++) {
            scanf("%d%d", &mons[i].val, &mons[i].patient);
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = mons[i].patient; j <= m; j++) {
                if (F[j - mons[i].patient] + mons[i].val > F[j]) {
                    amount[j] = amount[j - mons[i].patient] + 1;
                }
                F[j] = max(F[j], F[j - mons[i].patient] + mons[i].val);
            }
        }
        for (int i = 0; i <= m; i++) {
            if(F[i] >= nVal && amount[i] <= s){
                printf("%d\n",m - i);
                break;
            }
            if(i == m){
                printf("-1\n");
            }
        }
    }
    
    return 0;
}