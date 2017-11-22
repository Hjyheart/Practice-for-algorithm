//
//  Hdu1257_最少拦截系统.cpp
//  算法学习
//
//  Created by 洪嘉勇 on 16/2/23.
//  Copyright © 2016年 洪嘉勇. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int T, cnt = 0;

int main(){
    while (cin >> T) {
        vector<int> s;
        int temp;
        scanf("%d", &temp);
        cnt++;
        s.push_back(temp);
        for (int i = 1; i < T; i++) {
            sort(s.begin(), s.end());
            scanf("%d", &temp);
            for (int k = 0; k < s.size(); k++) {
                if (s[k] > temp) {
                    s[k] = temp;
                    break;
                }
                if (k == s.size() - 1) {
                    cnt++;
                    s.push_back(temp);
                    break;
                }
            }
        }
        printf("%d\n", cnt);
        cnt = 0;
    }
    return 0;
}