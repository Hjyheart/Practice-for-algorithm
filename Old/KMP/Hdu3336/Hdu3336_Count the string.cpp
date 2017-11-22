//
//  Hdu3336_Count the string.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/26.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <cstdio>
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int T, N, NEXT[200002], ans = 0;
string str;

void setNext(const string & par){
    NEXT[0] = -1;
    int j = 0, k = -1;
    while (j < par.length()) {
        if (k == -1 || par[k] == par[j]) {
            j++;
            k++;
            NEXT[j] = k;
        }
        else
            k = NEXT[k];
    }
}

void solve(const string & par){
    int p = 0, q = 0;
    while (p < str.length()) {
        if (q == -1 || str[p] == par[q]) {
            p++;
            q++;
        }
        else
            q = NEXT[q];
        if (q == par.length()) {
            ans++;
        }
    }
}

int main(){
    scanf("%d", &T);
    while (T--) {
        scanf("%d", &N);
        cin >> str;
        ans = N;
        setNext(str);
        for (int i = 1; i <= str.length(); i++) {
            int tmp = NEXT[i];
            while (tmp) {
                ans = (ans + 1) % 10007;
                tmp = NEXT[tmp];
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}