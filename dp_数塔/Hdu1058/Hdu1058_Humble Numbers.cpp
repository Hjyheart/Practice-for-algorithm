//
//  Hdu1058_Humble Numbers.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/28.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <cstdio>
#include <iostream>
#include <string.h>
#include <vector>
using namespace std;

vector<int> ans;

void solve(){
    ans.push_back(-1);
    ans.push_back(1);
    for (int i = 2; i <= 5842; i++) {
        int min = -1;
        for (int k = i / 2; k <= i; k++) {
            if (ans[k] * 2 > ans[i - 1]) {
                min = ans[k] * 2;
                break;
            }
        }
        for (int k = i / 3; k <= i; k++) {
            if (k == 0) {
                break;
            }
            if (ans[k] * 3 > ans[i - 1]) {
                if (min > ans[k] * 3) {
                    min = ans[k] * 3;
                }
                break;
            }
        }
        for (int k = i / 5; k <= i; k++) {
            if (k == 0) {
                break;
            }
            if (ans[k] * 5 > ans[i - 1]) {
                if (min > ans[k] * 5) {
                    min = ans[k] * 5;
                }
                break;
            }
        }
        for (int k = i / 7; k <= i; k++) {
            if (k == 0) {
                break;
            }
            if (ans[k] * 7 > ans[i - 1]) {
                if (min > ans[k] * 7) {
                    min = ans[k] * 7;
                }
                break;
            }
        }
        ans.push_back(min);
    }
}

int main(){
    int T;
    solve();
    scanf("%d", &T);
    while (T != 0) {
        if (T % 100 == 11) {
            printf("The %dth humble number is %d.\n", T, ans[T]);
            scanf("%d", &T);
            continue;
        }
        if (T % 10 == 1) {
            printf("The %dst humble number is %d.\n", T, ans[T]);
            scanf("%d", &T);
            continue;
        }
        if (T % 100 == 12) {
            printf("The %dth humble number is %d.\n", T, ans[T]);
            scanf("%d", &T);
            continue;
        }
        if (T % 10 == 2) {
            printf("The %dnd humble number is %d.\n", T, ans[T]);
            scanf("%d", &T);
            continue;
        }
        if (T % 100 == 13) {
            printf("The %dth humble number is %d.\n", T, ans[T]);
            scanf("%d", &T);
            continue;
        }
        if (T % 10 == 3) {
            printf("The %drd humble number is %d.\n", T, ans[T]);
            scanf("%d", &T);
            continue;
        }
        printf("The %dth humble number is %d.\n", T, ans[T]);
        scanf("%d", &T);
    }
    return 0;
}
