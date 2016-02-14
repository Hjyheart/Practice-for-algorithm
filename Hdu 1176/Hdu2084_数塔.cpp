//
//  Hdu2084_数塔.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/14.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <algorithm>
#include <iostream>
using namespace std;

int T, N, arr[100][100];

int Hdu2084Solve(){
    for (int i = N - 2; i >= 0; i--) {
        for (int k = 0; k < i + 1; k++) {
            arr[i][k] = max(arr[i + 1][k], arr[i + 1][k + 1]) + arr[i][k];
        }
    }
    return arr[0][0];
}
/*
int main(){
    memset(arr, 0, sizeof(arr));
    scanf("%d", &T);
    for (int i = 0; i < T; i++) {
        scanf("%d", &N);
        for (int k = 0; k < N; k++) {
            for (int j = 0; j <= k; j++) {
                scanf("%d", &arr[k][j]);
            }
        }
        printf("%d\n", Hdu2084Solve());
        memset(arr, 0, sizeof(arr));
    }
    return 0;
}
*/