//
//  Hdu1175_连连看.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/18.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string.h>
#include <cstdio>
#include <queue>
using namespace std;

int N, M, T, mp[1001][1001], flag[1001][1001];
int fx[4] = {0, 0, 1, -1};
int fy[4] = {1, -1, 0, 0};

struct Node{
    int x, y, time, fx, fy;
}now, nex;

void solve(int x1, int y1, int x2, int y2){
    if (mp[x1][y1] == 0 || mp[x2][y2] == 0 || mp[x1][y1] != mp[x2][y2]) {
        printf("NO\n");
        return;
    }
    memset(flag, 0, sizeof(flag));
    queue <Node> s;
    now.x = x1;
    now.y = y1;
    now.time = 3;
    now.fx = -1;
    now.fy = -1;
    flag[x1][y1] = 3;
    s.push(now);
    
    while (!s.empty()) {
        now = s.front();
        s.pop();
        
        for (int i = 0; i < 4; i++) {
            nex = now;
            nex.x += fx[i];
            nex.y += fy[i];
            if (nex.fx != fx[i] || nex.fy != fy[i]) {
                if (nex.fx != -1 || nex.fy != -1) {
                    nex.time--;
                    if (nex.time) {
                        nex.fx = fx[i];
                        nex.fy = fy[i];
                    }
                    else
                        continue;
                }
            }
            
            
            
            if (nex.x >= 0 && nex.x < N && nex.y >= 0 && nex.y < M && nex.time >= flag[nex.x][nex.y]) {
                if (mp[nex.x][nex.y] == 0) {
                    flag[nex.x][nex.y] = nex.time;
                    if (nex.fx == -1 && nex.fy == -1) {
                        nex.fx = fx[i];
                        nex.fy = fy[i];
                    }
                    s.push(nex);
                    continue;
                }
                if (mp[nex.x][nex.y] > 0) {
                    if (nex.x == x2 && nex.y == y2) {
                        printf("YES\n");
                        return;
                    }
                    else{
                        continue;
                    }
                }
            }
        }
    }
    printf("NO\n");
}

int main(){
    scanf("%d%d", &N, &M);
    while (N != 0 || M != 0) {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                scanf("%d", &mp[i][k]);
            }
        }
        scanf("%d", &T);
        for (int i = 0; i < T; i++) {
            int x1, y1, x2, y2;
            scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
            solve(x1 - 1, y1 - 1, x2 - 1, y2 - 1);
        }
        scanf("%d%d", &N, &M);
    }
    return 0;
}
