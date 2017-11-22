//
//  Hud1231_最大连续子序列.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/22.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <cstdio>
#include <iostream>
#include <string.h>
using namespace std;

int N, num[10001];

int main(){
    scanf("%d", &N);
    while (N != 0) {
        for (int i = 0; i < N; i++) {
            scanf("%d", &num[i]);
        }
        int max = -1<<31, temp = 0, sum = 0, start = 0, end = 0, startStore = 0;
        for (int i = 0; i < N; i++, temp++) {
            sum += num[temp];
            if (sum > max) {
                max = sum;
                start = startStore;
                end = temp;
            }
            if (sum < 0) {
                sum = 0;
                startStore = temp + 1;
            }
        }
        if(max < 0){
            printf("0 %d %d\n", num[0], num[N - 1]);
        }
        else{
            printf("%d %d %d\n", max, num[start], num[end]);
        }
        scanf("%d", &N);
    }
    return 0;
}
