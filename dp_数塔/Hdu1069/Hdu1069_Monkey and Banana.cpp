//
//  Hdu1069_Monkey and Banana.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/23.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string.h>
#include <cstdio>
#include <algorithm>
using namespace std;

int N, cnt = 1;
struct Node{
    int x, y, z;
}node[200];
bool cmp(Node a, Node b){
    return a.x < b.x;
}
int dp[200];

int main(){
    int a[3];
    scanf("%d", &N);
    while (N != 0) {
        for (int i = 0; i < N; i++) {
            scanf("%d%d%d", &a[0], &a[1], &a[2]);
            sort(a, a + 3);
            node[3 * i].x = a[0];
            node[3 * i].y = a[1];
            node[3 * i].z = a[2];
            node[3 * i + 1].x = a[0];
            node[3 * i + 1].y = a[2];
            node[3 * i + 1].z = a[1];
            node[3 * i + 2].x = a[1];
            node[3 * i + 2].y = a[2];
            node[3 * i + 2].z = a[0];
        }
        sort(node, node + 3 * N, cmp);
        for (int i = 0; i < 3 * N; i++) {
            dp[i] = node[i].z;
        }
        int Max = dp[0];
        for (int i = 0; i < 3 * N; i++) {
            for (int k = i - 1; k >= 0; k--) {
                if (node[k].x < node[i].x && node[k].y < node[i].y) {
                    if (dp[k] + node[i].z > dp[i]) {
                        dp[i] = dp[k] + node[i].z;
                    }
                }
            }
            if (dp[i] > Max) {
                Max = dp[i];
            }
        }
        printf("Case %d: maximum height = %d\n", cnt, Max);
        cnt++;
        scanf("%d", &N);
    }
    return 0;
}