//
//  Hdu1711_Number Sequence.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/26.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int T, N, M, NEXT[10001], a[1000004], b[10004];

void setNext(){
    NEXT[0] = -1;
    int j = 0, k = -1;
    while (j < M) {
        if (k == -1 || b[j] == b[k]) {
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
    while (p < N) {
        if (q == -1 || a[p] == b[q]) {
            q++;
            p++;
        }
        else
            q = NEXT[q];
        if (q == M) {
            printf("%d\n", p - M + 1);
            return;
        }
    }
    printf("-1\n");
}

int main(){
    scanf("%d", &T);
    while (T--) {
        scanf("%d%d", &N, &M);
        for (int i = 0; i < N; i++) {
            scanf("%d", &a[i]);
        }
        for (int i = 0; i < M; i++) {
            scanf("%d", &b[i]);
        }
        setNext();
        solve();
    }
    return 0;
}