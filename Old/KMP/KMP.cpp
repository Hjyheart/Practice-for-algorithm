//
//  KMP.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/26.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <cstdio>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
string ori, par;
int NEXT[10001], ans = 0;

void setNext(){
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

void solve(){
    int p = 0, q = 0;
    while (p < ori.length()) {
        if (q == -1 || par[q] == ori[p]) {
            q++;
            p++;
        }
        else
            q = NEXT[q];
        if (q == par.length()) {
            ans++;
        }
    }
}

int main(){
    int T;
    scanf("%d", &T);
    while (T--) {
        ans = 0;
        cin >> par >> ori;
        setNext();
        solve();
        printf("%d\n", ans);
    }
    return 0;
}