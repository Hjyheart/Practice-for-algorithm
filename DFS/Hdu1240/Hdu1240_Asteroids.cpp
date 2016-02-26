//
//  Hdu1240_Asteroids.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/22.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string>
#include <cstdio>
#include <string.h>
#include <queue>

using namespace std;

char mp[10][10][10], flag[10][10][10];
int N, inX, inY, inZ, outX, outY, outZ;
int fx[6] = {1, -1, 0, 0, 0, 0};
int fy[6] = {0, 0, 1, -1, 0, 0};
int fz[6] = {0, 0, 0, 0, 1, -1};

struct Node{
    int x, y, z, output;
}now, nex;

void solve(int x, int y, int z){
    memset(flag, 0, sizeof(flag));
    queue<Node> s;
    now.x = x;
    now.y = y;
    now.z = z;
    now.output = 0;
    flag[z][x][y] = 1;
    s.push(now);
    
    while (!s.empty()) {
        now = s.front();
        if (now.x == outX && now.y == outY && now.z == outZ) {
            printf("%d %d\n", N, now.output);
            return;
        }
        s.pop();
        
        for (int i = 0; i < 6; i++) {
            nex = now;
            nex.x += fx[i];
            nex.y += fy[i];
            nex.z += fz[i];
            if (nex.z >=0 && nex.z < N && nex.x >= 0 && nex.x < N && nex.y >= 0 && nex.y < N && mp[nex.z][nex.x][nex.y] != 'X' && flag[nex.z][nex.x][nex.y] == 0) {
                nex.output++;
                flag[nex.z][nex.x][nex.y] = 1;
                s.push(nex);
            }
        }
    }
    printf("NO ROUTE\n");
}

int main(){
    string str;
    while (cin >> str >> N) {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                for (int z = 0; z < N; z++) {
                    cin >> mp[i][k][z];
                }
            }
        }
        cin >> inY >> inX >> inZ;
        cin >> outY >> outX >> outZ;
        cin >> str;
        solve(inX, inY, inZ);
    }
    return 0;
}