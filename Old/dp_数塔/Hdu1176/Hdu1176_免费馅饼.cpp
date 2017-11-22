//
//  Hdu1176_免费馅饼.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/13.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <cstdio>
#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

int arr[11][100005];
int T, maxTime = 0;

int H1176_Solve(){
    for (int i = maxTime - 1; i >= 0; i--) {
        for (int k = 0; k < 11; k++) {
            int maxValue = arr[k][i + 1];
            if (k - 1 >= 0) {
                if (arr[k - 1][i + 1] > maxValue) {
                    maxValue = arr[k - 1][i + 1];
                }
            }
            if(k + 1 <= 10){
                if (arr[k + 1][i + 1] > maxValue) {
                    maxValue = arr[k + 1][i + 1];
                }
            }
            arr[k][i] = arr[k][i] + maxValue;
        }
    }
    int max = arr[4][1];
    for (int i = 4; i < 7; i++) {
        if(arr[i][1] > max){
            max = arr[i][1];
        }
    }
    
    return max;
}

int main(){
    scanf("%d", &T);
    while (T != 0) {
        for (int i = 0; i < T; i++) {
            int pos, time;
            scanf("%d%d", &pos, &time);
            arr[pos][time]++;
            if (maxTime < time) {
                maxTime = time;
            }
        }
        printf("%d\n", H1176_Solve());
        memset(arr, 0, sizeof(arr));
        maxTime = 0;
        scanf("%d", &T);
    }
    return 0;
}
