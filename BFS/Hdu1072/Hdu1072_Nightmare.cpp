//
//  Hdu1072_Nightmare.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/17.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <queue>
#include <string.h>
using namespace std;

int T, N, M, mp[9][9], flag[9][9], inx, iny;
int fx[4]={0,0,1,-1};
int fy[4]={1,-1,0,0};
struct Node{
    int x, y, time, output;
}now, nex;

void solve(){
    queue<Node> s;
    memset(flag, 0, sizeof(flag));
    now.x = inx;
    now.y = iny;
    now.time = 6;
    now.output = 0;
    flag[inx][iny] = 6;
    s.push(now);
    
    while (!s.empty()) {
        now = s.front();
        s.pop();
        for (int i = 0; i < 4; i++) {
            nex = now;
            nex.x = now.x + fx[i];
            nex.y = now.y + fy[i];
            if(nex.x >= 0 && nex.x < N && nex.y >= 0 && nex.y < M && flag[nex.x][nex.y] < now.time - 1){
                if (mp[nex.x][nex.y] == 0) {
                    continue;
                }
                if(mp[nex.x][nex.y] == 3){
                    printf("%d\n", now.output + 1);
                    return;
                }
                if (mp[nex.x][nex.y] == 1) {
                    if (now.time - 1) {
                        flag[nex.x][nex.y] = now.time - 1;
                        nex.output = now.output + 1;
                        nex.time = now.time - 1;
                        s.push(nex);
                        continue;
                    }
                    continue;
                }
                if (mp[nex.x][nex.y] == 4) {
                    flag[nex.x][nex.y] = now.time - 1;
                    nex.output = now.output + 1;
                    nex.time = 6;
                    s.push(nex);
                    continue;
                }
            }
        }
    }
    printf("-1\n");
}

int main(){
    scanf("%d", &T);
    while (T--) {
        scanf("%d%d", &N, &M);
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                scanf("%d", &mp[i][k]);
                if(mp[i][k] == 2){
                    inx = i;
                    iny = k;
                }
            }
        }
        solve();
    }
    return 0;
}
