//
//  Hdu1312_Red and Black.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/26.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string.h>
#include <cstdio>
#include <algorithm>
using namespace std;

int N, M, vis[20][20], inX, inY, num = 0;
char mp[20][20];
int fx[4] = {0, 0, 1, -1};
int fy[4] = {1, -1, 0, 0};

void solve(int x, int y){
    if((mp[x][y] == '.' || mp[x][y] == '@') && vis[x][y] == 0){
        num++;
        vis[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nexX = x, nexY = y;
            nexX += fx[i];
            nexY += fy[i];
            if (nexX >=0 && nexX < N && nexY >= 0 && nexY < M) {
                solve(nexX, nexY);
            }
        }
    }
}

int main(){
    scanf("%d%d", &M, &N);
    while (N != 0 || M != 0) {
        getchar();
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                scanf("%c", &mp[i][k]);
                if (mp[i][k] == '@') {
                    inX = i;
                    inY = k;
                }
            }
            getchar();
        }
        memset(vis, 0, sizeof(vis));
        num = 0;
        solve(inX, inY);
        printf("%d\n", num);
        scanf("%d%d", &M, &N);
    }
    return 0;
}
