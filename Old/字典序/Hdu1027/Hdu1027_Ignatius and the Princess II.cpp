//
//  Hdu1027_Ignatius and the Princess II.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/3/1.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
using namespace std;

int num[1001], N, M;

void solve(){
    for (int i = 1; i <= N; i++) {
        num[i - 1] = i;
    }
    for (int i = 1; i < M; i++) {
        int flag1 = N - 1, flag2;
        while (num[flag1] < num[flag1 - 1]) {
            flag1--;
        }
        flag1--;
        flag2 = flag1;
        while (flag2 + 1 <  N && num[flag1] < num[flag2 + 1]) {
            flag2++;
        }
        int temp;
        temp = num[flag1];
        num[flag1] = num[flag2];
        num[flag2] = temp;
        int count = 0;
        for (int k = flag1 + 1; k <= (flag1 + 1 + N - 1) / 2; k++, count++) {
            temp = num[k];
            num[k] = num[N - 1 - count];
            num[N - 1 - count] = temp;
        }
    }
    for (int i = 0; i < N; i++) {
        if (i == N - 1) {
            printf("%d\n", num[i]);
            break;
        }
        printf("%d ", num[i]);
    }
}

int main(){
    while (cin >> N >> M) {
        solve();
    }
    return 0;
}



/*
1 2 3 4 5 6 7 8 9 10 11
1 2 3 4 5 6 7 8 9 11 10
1 2 3 4 5 6 7 8 10 9 11
1 2 3 4 5 6 7 8 10 11 9
1 2 3 4 5 6 7 8 11 9 10
1 2 3 4 5 6 7 8 11 10 9
1 2 3 4 5 6 7 9 8 10 11
1 2 3 4 5 6 7 9 8 11 10
 */



