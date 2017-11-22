//
//  Hdu1010_Tempter of the Bone.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/25.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string.h>
#include <algorithm>
#include <cstdio>
using namespace std;

int N, M, T, inX = 0, inY = 0, flag = 0, xNum = 0, pointNum = 0, outX = 0, outY = 0;
char mp[8][8];
int vis[8][8];

void solve(int x, int y, int t){
    if (t > T || flag) {
        return;
    }
    if (t == T) {
        if (mp[x][y] == 'D') {
            flag = 1;
            return;
        }
        return;
    }
    if (mp[x][y] == '.' || mp[x][y] == 'S') {
        
        vis[x][y] = 1;
        //up
        if (x - 1 >= 0 && vis[x - 1][y] == 0) {
            solve(x - 1, y, t + 1);
        }
        //down
        if (x + 1 < N && vis[x + 1][y] == 0) {
            solve(x + 1, y, t + 1);
        }
        //left
        if (y - 1 >= 0 && vis[x][y - 1] == 0) {
            solve(x, y - 1, t + 1);
        }
        //right
        if (y + 1 < M && vis[x][y + 1] == 0) {
            solve(x, y + 1, t + 1);
        }
        vis[x][y] = 0;
    }
}

int main(){
    scanf("%d%d%d", &N, &M, &T);
    while (N != 0 || M != 0 || T != 0) {
        getchar();
        flag = 0;
        memset(vis, 0, sizeof(vis));
        for (int i = 0;  i< N; i++) {
            for (int k = 0; k < M; k++) {
                scanf("%c", &mp[i][k]);
                if (mp[i][k] == 'S') {
                    inX = i;
                    inY = k;
                }
            }
            getchar();
        }
        solve(inX, inY, 0);
        if (flag) {
            printf("YES\n");
        }
        else{
            printf("NO\n");
        }
        scanf("%d%d%d", &N, &M, &T);
    }
    
    return 0;
}
