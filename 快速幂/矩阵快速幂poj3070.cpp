//
//  矩阵快速幂poj3070.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/1/28.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>

using namespace std;

int resA = 1, resB = 1, resC = 1, resD = 0;
int baseA = 1, baseB = 1, baseD = 0;

void init(){
    resA = resB = resC = baseA = baseB = 1;
    resD = baseD = 0;
}

void dealRes(){
    int C = resC, D = resD;
    resC = (C * baseA + D * baseB) % 10000;
    resD = (C * baseB + D * baseD) % 10000;
}

void dealBase(){
    int A = baseA, B = baseB, D = baseD;
    baseA = (A * A + B * B) % 10000;
    baseB = (A * B + B * D) % 10000;
    baseD = (B * B + D * D) % 10000;
}

int quickMPow(int n){
    if (n == 0) {
        return 0;
    }
    while (n) {
        if (n & 1) {
            dealRes();
        }
        dealBase();
        n >>= 1;
    }
    return resD;
}

int main(){
    int n = 0;
    while (n != -1) {
        scanf("%d", &n);
        printf("%d\n", quickMPow(n));
        init();
    }
    return 0;
}
