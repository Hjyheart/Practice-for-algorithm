//
//  Hdu1181_变形课.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/25.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string>
#include <cstdio>
#include <algorithm>
#include <string.h>

using namespace std;

string s[1001];
int vis[1001];
int cnt = 0, flag = 0;

void solve(int i){
    vis[i] = 1;
    char end = s[i][s[i].size() - 1];
    if (end == 'm') {
        flag = 1;
        return;
    }
    
    for (int k = 0; k < cnt; k++) {
        if (s[k][0] == end && vis[k] == 0) {
            solve(k);
        }
        if (flag) {
            break;
        }
    }
}

int main(){
    string temp;
    while (cin >> temp) {
        memset(vis, 0, sizeof(vis));
        while (temp != "0") {
            s[cnt] = temp;
            cnt++;
            cin >> temp;
        }
        for (int i = 0; i < cnt; i++) {
            if (s[i][0] != 'b') {
                continue;
            }
            solve(i);
            if (flag) {
                break;
            }
        }
        if (flag) {
            printf("Yes.\n");
        }
        else{
            printf("No.\n");
        }
        cnt = 0;
        flag = 0;
    }
    return 0;
}