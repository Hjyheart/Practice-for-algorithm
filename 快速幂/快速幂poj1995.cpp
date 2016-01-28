//
//  快速幂poj1995.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/1/28.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
using namespace std;

int quickMPow(int a, int b, int m){
    if (b == 0) {
        return 1;
    }
    int reslut = 1;
    a = a % m;
    
    while (b) {
        if (b & 1) {
            reslut *= a;
            reslut %= m;
        }
        a *= a;
        a %= m;
        b >>= 1;
    }
    return reslut % m;
}

int main(){
    int Z = 0, M = 0, H = 0, A = 0, B = 0;
    scanf("%d", &Z);
    for (int i = 0; i < Z; i++) {
        int res = 0;
        scanf("%d", &M);
        scanf("%d", &H);
        for (int k = 0; k < H; k++) {
            scanf("%d%d", &A, &B);
            res += quickMPow(A, B, M);
            res %= M;
        }
        printf("%d\n", res);
        res = 0;
    }
    return 0;
}
