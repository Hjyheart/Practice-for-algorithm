//
//  1005_Number Sequence.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/20.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <cstdio>
#include <iostream>
#include <vector>
using namespace std;

int A, B, N, ju[4];

void solve(int a, int b, int n){
    int ans[4] = {1, 0, 0, 1};
    ju[0] = a % 7;
    ju[1] = 1;
    ju[2] = b % 7;
    ju[3] = 0;

    while (n) {
        if (n & 1) {
            int x = ans[0], y = ans[1], z = ans[2], h = ans[3];
            ans[0] = (x * ju[0] + y * ju[2]) % 7;
            ans[1] = (x * ju[1] + y * ju[3]) % 7;
            ans[2] = (z * ju[0] + h * ju[2]) % 7;
            ans[3] = (z * ju[1] + h * ju[3]) % 7;
        }
        int x = ju[0], y = ju[1], z = ju[2], h = ju[3];
        ju[0] = (x * x + y * z) % 7;
        ju[1] = (x * y + y * h) % 7;
        ju[2] = (z * x + h * z) % 7;
        ju[3] = (z * y + h * h) % 7;
        n >>= 1;
    }
    printf("%d\n", (ans[0] + ans[2]) % 7);
}

int main(){
    scanf("%d%d%d", &A, &B, &N);
    while (A != 0 || B != 0 || N != 0) {
        if(N == 1 || N == 2){
            printf("1\n");
            scanf("%d%d%d", &A, &B, &N);
            continue;
        }
        solve(A, B, N - 2);
        scanf("%d%d%d", &A, &B, &N);
    }
    return 0;
}
